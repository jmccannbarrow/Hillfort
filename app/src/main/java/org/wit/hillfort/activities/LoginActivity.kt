package org.wit.hillfort.activities



import android.content.Context
import android.view.View
import android.widget.*
import org.wit.hillfort.R

import org.jetbrains.anko.intentFor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_hillfort.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

import org.wit.hillfort.helpers.readImage
import org.wit.hillfort.helpers.readImageFromPath
import org.wit.hillfort.helpers.showImagePicker
import org.wit.hillfort.main.MainApp

import android.content.Intent
import android.os.Handler
import org.wit.hillfort.models.Location

import java.util.regex.Matcher
import java.util.regex.Pattern


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
                val intent = Intent(this, HillfortListActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)

            }
            else{
                Toast.makeText(this, "Username or Password Do not Match", Toast.LENGTH_LONG).show()
            }
        }


    }

}