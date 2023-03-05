
package uz.itschool.applicationpr_000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sharedpreferences=getSharedPreferences("reg", MODE_PRIVATE)
        var edit=sharedpreferences.edit()
        var gson= Gson()
        var userList= mutableListOf<Users>()
        var type=object : TypeToken<List<Users>>(){}.type
        button_get_started.setOnClickListener {
            var email_tocheck=sharedpreferences.getString("email","")
            var password_tocheck=sharedpreferences.getString("password","")
            var pin_code_tocheck=sharedpreferences.getString("pincode","")



            if (email_tocheck!="" && password_tocheck!="" && pin_code_tocheck!="") {
                    var intent=Intent(this, EnterPinCode::class.java)
                    startActivity(intent)
                }
                else{
                    var intent=Intent(this, Registration::class.java)
                    startActivity(intent)
                }


        }
    }
}