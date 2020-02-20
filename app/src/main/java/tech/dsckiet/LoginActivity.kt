package tech.dsckiet


import android.os.Bundle
import android.os.Handler
import android.text.BoringLayout
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.razir.progressbutton.attachTextChangeAnimator
import com.github.razir.progressbutton.bindProgressButton
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showProgress
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_login.*
import kotlinx.android.synthetic.main.layout_registration.*

class LoginActivity : AppCompatActivity() {

    private var flag : Boolean= false
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

        //Eye Icon Password Edit text
        editText_login_password.setOnTouchListener { view, motionEvent -> passIcon(view,motionEvent) }
        editText_register_password.setOnTouchListener { view, motionEvent -> passIcon(view,motionEvent) }

        text_login_to_register.setOnClickListener {
            val rotate:Animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
            register_image?.startAnimation(rotate)
            section_register_form.startAnimation(rotate)
            text_register_to_login.startAnimation(rotate)
            showRegistration()
        }

        text_register_to_login.setOnClickListener {
            val rotate:Animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
            login_image?.startAnimation(rotate)
            section_login_form.startAnimation(rotate)
            text_login_to_register.startAnimation(rotate)
            showLogin()
        }

        fab_skip_login.setOnClickListener {
            Handler().postDelayed({
                finish()
                overridePendingTransition(R.anim.no_animation,R.anim.slide_down)
            }, 100)
        }
        fab_skip_register.setOnClickListener {
            Handler().postDelayed({
                finish()
                overridePendingTransition(R.anim.no_animation,R.anim.slide_down)
            }, 100)
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
    private fun passIcon(view: View,event: MotionEvent): Boolean{
        var DRAWABLE_LEFT = 0
        var DRAWABLE_TOP = 1
        val DRAWABLE_RIGHT  = 2
        var DRAWABLE_BOTTOM = 3
        if(event.action == MotionEvent.ACTION_UP) {
            if(event.rawX >= (editText_login_password.right - editText_login_password.compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                if (!flag){
                    //close pass eye icon
                    flag = true
                    editText_login_password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_pass_eye_open, 0);
                    editText_login_password.transformationMethod = HideReturnsTransformationMethod.getInstance()
                }else{
                    //open pass eye icon
                    flag = false
                    editText_login_password.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_pass_eye_close, 0);
                    editText_login_password.transformationMethod = PasswordTransformationMethod.getInstance()
                }
                return true
            }
        }
        return false
    }
}
