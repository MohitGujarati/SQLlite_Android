package mohit.dev.a27jun2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var Log_userName=findViewById<EditText>(R.id.tv_userName_Log)
        var Log_userEmail=findViewById<EditText>(R.id.tv_UserEmail_Log)
        var Log_userPass=findViewById<EditText>(R.id.tv_UserPass_Log)
        var Log_userContact=findViewById<EditText>(R.id.tv_UserContact_Log)
    }
}