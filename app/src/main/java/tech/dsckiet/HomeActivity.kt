package tech.dsckiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        text_home_to_register.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
            overridePendingTransition(R.anim.slide_up,R.anim.no_animation)
        }

    }
}
