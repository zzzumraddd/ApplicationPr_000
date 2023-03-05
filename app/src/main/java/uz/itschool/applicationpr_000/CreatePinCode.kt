package uz.itschool.applicationpr_000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_create_pin_code.*
import kotlinx.android.synthetic.main.activity_enter_pin_code.*
import kotlinx.android.synthetic.main.activity_registration.*

class CreatePinCode : AppCompatActivity() {
    /*var pos:Boolean=true*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pin_code)
        var sharedpreferences=getSharedPreferences("reg", MODE_PRIVATE)
        var edit=sharedpreferences.edit()
        /*var gson= Gson()
        var userList= mutableListOf<Users>()
        var type=object : TypeToken<List<Users>>(){}.type*/



        check_pin_Code.setOnClickListener {
            var pin_code_str:String =""
            pin_code_str= pin_code_str+id_pin_1.text.toString()
            pin_code_str= pin_code_str+id_pin_2.text.toString()
            pin_code_str= pin_code_str+id_pin_3.text.toString()
            pin_code_str= pin_code_str+id_pin_4.text.toString()
            edit.putString("pincode",pin_code_str).commit()
            var intent=Intent(this, Choose_card_view::class.java)
            startActivity(intent)

            /*var users=sharedpreferences.getString("users","")

            var pos=false
            var n=0
            if(users==""){
                userList= mutableListOf()
                userList.add(Users(text_input_email.text.toString(),text_input_password.text.toString(),
                    ""
                ))
                Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                val str=gson.toJson(userList)
                edit.putString("users", str).commit()
            }
            else{
                userList=gson.fromJson(users,type)
                for(i in 0 .. userList.size-1){
                    if(userList[i].pinCode!=pin_code_str){
                        pos=true
                        n=i
                    }
                    else{
                        pos=false
                        break
                    }
                }

                if(pos==true){
                    userList[n].pinCode=pin_code_str
                    Toast.makeText(this, "Pin Code successfully was saved.", Toast.LENGTH_SHORT).show()
                    var str=gson.toJson(userList)
                    edit.putString("users", str).commit()
                    var intent= Intent(this, Choose_card_view::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Change inputs!", Toast.LENGTH_SHORT).show()
                }
            }*/
        }
    }
}