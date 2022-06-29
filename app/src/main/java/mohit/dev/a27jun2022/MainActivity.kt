package mohit.dev.a27jun2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv_name=findViewById<EditText>(R.id.tv_userName)
        var tv_Email=findViewById<EditText>(R.id.tv_UserEmail)
        var tv_password=findViewById<EditText>(R.id.tv_UserPass)
        var tv_contact=findViewById<EditText>(R.id.tv_UserContact)
        var btnsave=findViewById<Button>(R.id.btnsave)

        var getname=tv_name.toString()
        var getEmail=tv_Email.toString()
        var getPassword=tv_password.toString()
        var getContact=tv_contact

        


    }
}