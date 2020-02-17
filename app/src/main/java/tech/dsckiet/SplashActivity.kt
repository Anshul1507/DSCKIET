package tech.dsckiet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)

        val logolayout: ImageView = findViewById(R.id.image_splash)
        logolayout.animate().alpha(1.0f).scaleX(1.1f).scaleY(1.1f).duration = 2000
        val isFirstRun = getSharedPreferences("PREFERENCES", MODE_PRIVATE)
            .getBoolean("isfirstrun", true)
        logolayout.animate().alpha(1.0f).scaleX(1.1f).scaleY(1.1f).setDuration(2500)
//        if (isFirstRun) {
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent i = new Intent(getApplicationContext(), IntroActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }, 3000);
//
//            getSharedPreferences("PREFERENCES", MODE_PRIVATE).edit()
//                    .putBoolean("isfirstrun", false).commit();
//        } else
        //        if (isFirstRun) {
//
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    Intent i = new Intent(getApplicationContext(), IntroActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }, 3000);
//
//            getSharedPreferences("PREFERENCES", MODE_PRIVATE).edit()
//                    .putBoolean("isfirstrun", false).commit();
//        } else

        Handler().postDelayed({
//            showLogin()
                val i = Intent(applicationContext, HomeActivity::class.java)
                startActivity(i)
                finish()
                finishActivity(0)
        }, 1600)

    }
}
