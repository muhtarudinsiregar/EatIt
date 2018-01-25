package com.example.ardin.eatit

import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.ardin.eatit.data.model.User
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_signin.*

class Signin : AppCompatActivity() {
    lateinit var firebase: DatabaseReference
    lateinit var dialog: AlertDialog;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        btnSignIn.setOnClickListener {
            dialog = ProgressDialog(this@Signin)
            dialog.setMessage("Please Waiting...")
            dialog.show()
            showDialog()
        }
    }

    var itemListener: ValueEventListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // Get Post object and use the values to update the UI
            signIn(dataSnapshot)
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Item failed, log a message
            Log.w("MainActivity", "loadItem:onCancelled", databaseError.toException())
        }
    }

    fun showDialog() {
        firebase = FirebaseDatabase.getInstance().getReference()

        firebase.orderByKey().addListenerForSingleValueEvent(itemListener)
    }

    fun signIn(dataSnapshot: DataSnapshot) {

        dialog.dismiss()

        //check user if already in db
        //get user info
        val data = dataSnapshot.child("User").child(edtPhone.text.toString()).getValue(User::class.java)

        if (data?.password.equals(edtPassword.text.toString())) {
            println("SUKSES SINI KOK")
            Toast.makeText(this, "Sign In Success!", Toast.LENGTH_SHORT).show();
        } else {
            println("GAGAL SINI KOK")
            Toast.makeText(this, "Failed Signin!", Toast.LENGTH_SHORT).show();

        }

    }
}
