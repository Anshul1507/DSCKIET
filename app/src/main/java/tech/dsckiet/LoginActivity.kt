package tech.dsckiet

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.razir.progressbutton.attachTextChangeAnimator
import com.github.razir.progressbutton.bindProgressButton
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showProgress
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_login.*
import kotlinx.android.synthetic.main.layout_registration.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val arrayColors = intArrayOf(R.array.progressColors)
        bindProgressButton(button_login)
        bindProgressButton(button_register)

        button_login.hideProgress(R.string.login)
        button_register.hideProgress(R.string.register)

        button_login.setOnClickListener {
            button_login.isClickable = false
            button_login.attachTextChangeAnimator()
            button_login.showProgress {
                buttonTextRes = R.string.loading
                progressColors = arrayColors
            }
        }
        button_register.setOnClickListener {
            button_register.isClickable = false
            button_register.attachTextChangeAnimator()
            button_register.showProgress {
                buttonTextRes = R.string.loading
                progressColors = arrayColors
            }
        }

        text_login_to_register.setOnClickListener {
            showRegistration()
        }
        text_register_to_login.setOnClickListener {
            showLogin()
        }
        
        fab_skip_login.setOnClickListener {
                finish()
                overridePendingTransition(R.anim.no_animation,R.anim.slide_down)
        }
    }

    private fun showRegistration(){
        layout_register.visibility = View.VISIBLE
        layout_login.visibility = View.INVISIBLE

    }
    private fun showLogin(){
        layout_register.visibility = View.INVISIBLE
        layout_login.visibility = View.VISIBLE
    }
}
