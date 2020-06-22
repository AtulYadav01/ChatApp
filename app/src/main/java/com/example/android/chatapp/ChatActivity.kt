package com.example.android.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.firebase.ui.database.FirebaseListAdapter
import com.firebase.ui.database.FirebaseListOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat.*
import android.widget.TextView as TextView1

@Suppress("UNREACHABLE_CODE")
class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        button2.setOnClickListener {
            val msg = editTextTextPersonName.text.toString()
            val email = FirebaseAuth.getInstance().currentUser!!.email

            FirebaseDatabase.getInstance().reference.child(messages.toString())
                .push()
                .setValue(
                    Message(email!!,msg)
                )
            val query = FirebaseDatabase.getInstance().reference.child("messages")

            val options = FirebaseListOptions.Builder<Message>()
                .setLayout(android.R.layout.simple_list_item_1)
                .setQuery(query, Message::class.java)
                .build()

            val adapter = object  : FirebaseListAdapter<Message>(options) {
                override fun populateView(v: View, model: Message, position: Int) {
                    TODO("Not yet implemented")
                    (v as TextView1).text = model.email + "\n" + model.msg
                }

            }
            adapter.startListening()
        }

    }
}

class Message (var email: String, var msg: String ) {

    constructor(): this("", "")


}