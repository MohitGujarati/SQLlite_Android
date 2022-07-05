package mohit.dev.a27jun2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var reg_userName=findViewById<EditText>(R.id.tv_userName_Reg)
        var reg_userEmail=findViewById<EditText>(R.id.tv_UserEmail_Reg)
        var reg_userPass=findViewById<EditText>(R.id.tv_UserPass_Reg)
        var reg_userContact=findViewById<EditText>(R.id.tv_UserContact_Reg)
        var btn_Register=findViewById<Button>(R.id.btn_Register)




    }
}