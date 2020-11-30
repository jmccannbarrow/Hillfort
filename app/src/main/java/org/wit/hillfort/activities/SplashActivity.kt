package org.wit.hillfort.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.wit.hillfort.R
import org.wit.hillfort.views.hillfort.HillfortView
import org.wit.hillfort.views.hillfortlist.HillfortListView
import org.wit.hillfort.views.login.LoginView


class SplashActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity


            //startActivity(Intent(this,LoginActivity::class.java))


            startActivity(Intent(this, LoginView::class.java))

            //startActivity(Intent(this, HillfortView::class.java))
            //startActivity(Intent(this, HillfortListView::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}