package uz.itschool.applicationpr_000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_pin_code.*
import kotlinx.android.synthetic.main.activity_enter_pin_code.*

class EnterPinCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_pin_code)
        var sharedpreferences = getSharedPreferences("reg", MODE_PRIVATE)

            check_pincode.setOnClickListener {
                var pin_code_str: String=""
                var pincode_str=sharedpreferences.getString("pincode","")
                pin_code_str = pin_code_str + id_pin1.text.toString()
                pin_code_str = pin_code_str + id_pin2.text.toString()
                pin_code_str = pin_code_str + id_pin3.text.toString()
                pin_code_str = pin_code_str + id_pin4.text.toString()
                Log.d("TAG", pin_code_str)
                if(pincode_str==pin_code_str){
                    var intent = Intent(this, Choose_card_view::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Change inputs",Toast.LENGTH_SHORT).show()
                }

            }
    }
}