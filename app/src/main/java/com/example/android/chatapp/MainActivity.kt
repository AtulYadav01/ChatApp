package com.example.android.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.database.FirebaseListOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val email = editTextTextEmailAddress2.text.toString()
            val password = editTextTextPassword2.text.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            startActivity(Intent(this, ChatActivity::class.java))
        }


    }
}