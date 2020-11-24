package org.wit.hillfort.activities



import android.content.Context
import android.widget.*
import org.wit.hillfort.R

//import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_hillfort.*

import org.wit.hillfort.main.MainApp

import android.content.Intent
import org.jetbrains.anko.*
import org.wit.hillfort.views.hillfort.HillfortView
import org.wit.hillfort.views.hillfortlist.HillfortListView


/**
 * A Login Form Example in Kotlin Android
 */
class LoginActivity : AppCompatActivity() {

    //val user_name = "homer";
    //val password = "secret";

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbarAdd)


        // get reference to all views
        var et_email_address = findViewById(R.id.et_email_address) as EditText
        var et_password = findViewById(R.id.et_password) as EditText
        var btn_reset = findViewById(R.id.btn_reset) as Button
        var btn_submit = findViewById(R.id.btn_submit) as Button

        btn_reset.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            et_email_address.setText("")
            et_password.setText("")
        }

        // set on-click listener
        btn_submit.setOnClickListener {
            val name:String = et_email_address.text.toString()
            val pass:String = et_password.text.toString()

            if (name.trim().length == 0  || pass.trim().length == 0){
                Toast.makeText(this, "Username or Password blank", Toast.LENGTH_LONG).show()
            }
            else if (name.equals("homer@simpson.com") and pass.equals("secret")){
                val editor = getSharedPreferences("name", Context.MODE_PRIVATE).edit()
                editor.putString("name", name)
                editor.apply()
                val intent = Intent(this, HillfortListView::class.java)
                intent.putExtra("name", name)
                startActivity(intent)

            }
            else{
                Toast.makeText(this, "Username or Password Do not Match", Toast.LENGTH_LONG).show()
            }
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_login, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {

            R.id.item_register -> {startActivityForResult<RegisterActivity>(0)
            }

        }
        return super.onOptionsItemSelected(item)
    }



}