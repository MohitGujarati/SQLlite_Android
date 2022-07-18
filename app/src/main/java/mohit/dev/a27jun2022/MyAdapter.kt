package mohit.dev.a27jun2022

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var userlist: MutableList<UserModel>) :
    RecyclerView.Adapter<MyAdapter.Myclass>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_userrowdata, parent, false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        var mymodel = userlist[position]
        Toast.makeText(context, mymodel.userName, Toast.LENGTH_SHORT).show()
        holder.userName.text = mymodel.userName
        holder.userEmail.text = mymodel.userEmail
        holder.userMobile.text = mymodel.userMobile
        holder.tv_UserPriority.text= mymodel.userPriority.toString()
        holder.btn_edit.setOnClickListener {
            var d = Dialog(context)
            d.setContentView(R.layout.mydialog)
            d.setCancelable(true)

            var ed_username = d.findViewById<EditText>(R.id.ed_username)
            var ed_email = d.findViewById<EditText>(R.id.ed_email)
            var ed_password = d.findViewById<EditText>(R.id.ed_password)
            var ed_contact = d.findViewById<EditText>(R.id.ed_contact)

            var btn_update = d.findViewById<Button>(R.id.btn_update)

            ed_username.setText(mymodel.userName)
            ed_email.setText(mymodel.userEmail)
            ed_password.setText(mymodel.userPassword)
            ed_contact.setText(mymodel.userMobile)


            btn_update.setOnClickListener {

                var i = Intent(context, ViewUser::class.java)
                var dbhelper = Databasehelper(context)

                var id_update = dbhelper.updatedata(
                    UserModel(
                        mymodel.userid,
                        ed_username.text.toString(),
                        ed_email.text.toString(),
                        ed_password.text.toString(),
                        ed_contact.text.toString(),
                        1
                    )
                )
                context.startActivity(i)

            }

            d.show()
        }
        holder.btn_delete.setOnClickListener {

            var alertdialog = AlertDialog.Builder(context)
                .setTitle("Delete User")
                .setMessage("Are you sure")
                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, i ->

                    var dbhelper = Databasehelper(context)
                    Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show()
                    var id_delete = dbhelper.delete(UserModel(mymodel.userid, "", "", "", "",0))

                    var k = Intent(context, ViewUser::class.java)
                    context.startActivity(k)
                    dialog.dismiss()
                })

                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, i ->
                    dialog.dismiss()
                })

                .show()

        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class Myclass(it: View) : RecyclerView.ViewHolder(it) {

        var userName = it.findViewById<TextView>(R.id.layout_userName)
        var userEmail = it.findViewById<TextView>(R.id.layout_userEmail)
        var userMobile = it.findViewById<TextView>(R.id.layout_userMobile)
        var tv_UserPriority = it.findViewById<TextView>(R.id.tv_UserPriority)


        var btn_delete = it.findViewById<Button>(R.id.btn_delete)
        var btn_edit = it.findViewById<Button>(R.id.btn_edit)

    }
}