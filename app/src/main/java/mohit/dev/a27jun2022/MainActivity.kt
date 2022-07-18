package mohit.dev.a27jun2022

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tv_name = findViewById<EditText>(R.id.tv_userName)
        var tv_Email = findViewById<EditText>(R.id.tv_UserEmail)
        var tv_password = findViewById<EditText>(R.id.tv_UserPass)
        var tv_contact = findViewById<EditText>(R.id.tv_UserContact)
        var btnsave = findViewById<Button>(R.id.btnsave)
        var btnhigh=findViewById<Button>(R.id.btnhigh)
        var btnmeduim=findViewById<Button>(R.id.btnmedium)
        var btnlow=findViewById<Button>(R.id.btnlow)
        var tv_Priority=findViewById<TextView>(R.id.tv_Priority)

        btnhigh.setOnClickListener {

            tv_Priority.text="1"

        }
        btnmeduim.setOnClickListener {


            tv_Priority.text="2"

        }
        btnlow.setOnClickListener {

            tv_Priority.text="3"

        }



        var priority=0








        //   var id:Int
        var dbhelper = Databasehelper(this)

        btnsave.setOnClickListener {
            var id = dbhelper.insertData(
                UserModel(
                    it.id,
                    tv_name.text.toString(),
                    tv_Email.text.toString(),
                    tv_password.text.toString(),
                    tv_contact.text.toString(),
                    Integer.valueOf(tv_Priority.text.toString())
                )
            )

            if (id > 0) {
                //  Log.d("mydata","id-"+id)
                var intent = Intent(this, ViewUser::class.java)
                //   Toast.makeText(this, "saved at $id", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        }


    }


}