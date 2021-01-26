package com.example.mymarketmobileversion
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var confirmInputPassword: EditText
    private lateinit var signupButton: Button
    private lateinit var loginText: TextView
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        inputEmail = findViewById(R.id.inputEmail)
        inputPassword = findViewById(R.id.inputPassword)
        confirmInputPassword = findViewById(R.id.confirmInputPassword)
        signupButton = findViewById(R.id.signupButton)
        loginText = findViewById(R.id.loginText)
        mAuth = FirebaseAuth.getInstance();

        loginText.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        signupButton.setOnClickListener{
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            val confirmPassword = confirmInputPassword.text.toString()

            if(email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() && password != confirmPassword){
                Toast.makeText(this, "Please fix errors", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }
}