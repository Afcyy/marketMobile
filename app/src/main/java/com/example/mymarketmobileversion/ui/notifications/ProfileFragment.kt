package com.example.mymarketmobileversion.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mymarketmobileversion.LoginActivity
import com.example.mymarketmobileversion.MainActivity
import com.example.mymarketmobileversion.R
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var logoutButton: Button
    private lateinit var userName: TextView
    private lateinit var mAuth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance();

        mAuth.signOut()
        startActivity(Intent(activity, LoginActivity::class.java))

    }
}