package mohit.dev.a27jun2022

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ViewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)

        var rec_data = findViewById<RecyclerView>(R.id.rev_data)
        var btn_add = findViewById<FloatingActionButton>(R.id.btn_add)


        rec_data.layoutManager=GridLayoutManager(this,2)
        //rec_data.layoutManager =LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        var db_helper = Databasehelper(this)

        var userList: MutableList<UserModel> = ArrayList()
        userList = db_helper.getAllData()



        var connect_Adapter =MyAdapter(this, userList)
        rec_data.adapter = connect_Adapter


        btn_add.setOnClickListener {
            var intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}