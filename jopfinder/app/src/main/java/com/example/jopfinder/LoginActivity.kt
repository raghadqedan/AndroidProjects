package com.example.jopfinder



import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var editTextPassword: EditText
    lateinit var editTextEmail: EditText
    lateinit var checkbox: CheckBox
    lateinit var createAccountBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editTextName = findViewById(R.id.name)
        editTextEmail = findViewById(R.id.email)
        editTextPassword = findViewById(R.id.password)
        checkbox = findViewById(R.id.checkbox)
        createAccountBtn = findViewById(R.id.create_account_button)
        editTextName.setOnKeyListener { view, keyCode, _-> handleKeyEvent(view, keyCode)}
        editTextPassword.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        editTextEmail.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
        editTextName.addTextChangedListener(loginListener)
        editTextEmail.addTextChangedListener(loginListener)
        editTextPassword.addTextChangedListener(loginListener)
        createAccountBtn.addTextChangedListener(loginListener)
    }

    fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }


    private var loginListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

              override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            checkbox.setOnCheckedChangeListener() { _, _ -> createAccountBtn.isEnabled = name.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty() && checkbox.isChecked }
        }
    }

}





