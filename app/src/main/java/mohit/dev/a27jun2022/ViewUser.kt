package mohit.dev.a27jun2022

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ViewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_user)

        var rec_data = findViewById<RecyclerView>(R.id.rev_data)
        var btn_add = findViewById<FloatingActionButton>(R.id.btn_add)

        var btnlh=findViewById<Button>(R.id.btnlowtohigh)
        var btnhl=findViewById<Button>(R.id.hightolow)

        var num=0
        loadrec(rec_data,num)
        btnhl.setOnClickListener {
            Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show()
            num=1
            loadrec(rec_data,num)
        }

        btnlh.setOnClickListener {
            Toast.makeText(this, "yellow", Toast.LENGTH_SHORT).show()
            num=2
            loadrec(rec_data,num)
        }


        Toast.makeText(this, "this is -$num", Toast.LENGTH_SHORT).show()


        // rec_data.layoutManager=GridLayoutManager(this,2)

        btn_add.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun loadrec(recData: RecyclerView, num: Int) {
        recData.layoutManager = LinearLayoutManager(this)

        var db_helper = Databasehelper(this)

        var userList: MutableList<UserModel> = ArrayList()
        userList = db_helper.getAllData(num)


        var connect_Adapter = MyAdapter(this, userList)
        recData.adapter = connect_Adapter



    }
}