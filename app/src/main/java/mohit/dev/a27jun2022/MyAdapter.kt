package mohit.dev.a27jun2022

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context:Context,var userlist:MutableList<UserModel>)
    : RecyclerView.Adapter<MyAdapter.Myclass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.layout_userrowdata,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder:Myclass, position: Int) {
        var mymodel=userlist[position]
        Toast.makeText(context, mymodel.username, Toast.LENGTH_SHORT).show()
        holder.userName.text=mymodel.username
        holder.userEmail.text=mymodel.userEmail
        holder.userMobile.text=mymodel.userMobile
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class Myclass(it:View):RecyclerView.ViewHolder(it){

      var   userName=it.findViewById<TextView>(R.id.layout_userName)
      var   userEmail=it.findViewById<TextView>(R.id.layout_userEmail)
      var   userMobile=it.findViewById<TextView>(R.id.layout_userMobile)

    }
}