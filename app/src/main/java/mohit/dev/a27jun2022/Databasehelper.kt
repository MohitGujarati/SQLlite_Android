package mohit.dev.a27jun2022

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Databasehelper(var context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "mydb"
        private val DATABASE_VERSION = 1


        private const val TABLE_NAME = "student"
        private const val KEY_ID = "id"
        private const val KEY_USERNAME = "username"
        private const val KEY_EMAIL = "email"
        private const val KEY_PASSWORD = "password"
        private const val KEY_MOBILE = "mobile"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE =
            (
                    "CREATE TABLE " + TABLE_NAME + " "
                            + " ( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                            + KEY_USERNAME + " TEXT, " + ""
                            + KEY_EMAIL + " TEXT,"
                            + KEY_PASSWORD + " TEXT,"
                            + KEY_MOBILE + " TEXT)"
                    )

        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    fun insertData(userModel: UserModel): Long {
        var db = this.writableDatabase
        var cv = ContentValues()

        cv.put(KEY_USERNAME, userModel.username)
        cv.put(KEY_EMAIL, userModel.userEmail)
        cv.put(KEY_MOBILE, userModel.userMobile)
        cv.put(KEY_PASSWORD, userModel.userPassword)


        var inserData = db.insert(TABLE_NAME, null, cv)
        return inserData

    }

    @SuppressLint("Range")
    fun getAllData(): MutableList<UserModel> {

        var userlist: MutableList<UserModel> = ArrayList()
        var sel_que = "select * from $TABLE_NAME ORDER BY $KEY_ID DESC "


        var cursor: Cursor?
        var db = this.readableDatabase

        try {
            cursor = db.rawQuery(sel_que, null)
        } catch (Exception: SQLException) {
            db.execSQL(sel_que)
            return ArrayList()

        }

        var userid: Int
        var username: String
        var userEmail: String
        var userPassword: String
        var userMobile: String

        if (cursor.count > 0)

        {
            if (cursor.moveToFirst()) {

                do {
                    userid = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                    username = cursor.getString(cursor.getColumnIndex(KEY_USERNAME))
                    userEmail = cursor.getString(cursor.getColumnIndex(KEY_EMAIL))
                    userPassword = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD))
                    userMobile = cursor.getString(cursor.getColumnIndex(KEY_MOBILE))

                    var userdata = UserModel(userid, username, userEmail, userPassword, userMobile)
                    userlist.add(userdata)


                } while (cursor.moveToNext())
            }
        }

        return userlist
    }
}