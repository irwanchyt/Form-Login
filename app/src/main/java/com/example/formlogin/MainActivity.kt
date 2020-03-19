package com.example.formlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        fun validateName(): Boolean {
            if (edit_name.text.length == 0) {
                error_name.setText("TOLONG NAMANYA DI ISI YA")
                return false
            } else {
                error_name.setText(null)
                return true
            }

        }

        fun validateEmail(): Boolean {
            if (edit_email.text.length == 0) {
                error_email.setText("TOLONG ISI EMAILNYA")
                return false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(edit_email.text).matches()) {
                error_email.setText("EMAIL SALAH")
                return false

            } else {
                error_email.setText(null)
                return false

            }


        }

        fun validatePassword(): Boolean {
            if (edit_password.text.length == 0) {
                error_password.setText("ISI PASSWORD")
                return false
            } else if (edit_password.text.length < 8) {
                error_password.setText("PASSWORD HARUS LEBIH DARI 8 KARAKTER")
                return false

            } else {
                error_password.setText(null)
                return true

            }
        }

        fun validateGender(): Boolean {
            if (radio_group.checkedRadioButtonId == -1) {
                error_gender.setText("PILIH JENIS SALAH SATU JENIS KELAMIN")
                return false
            } else {
                error_gender.setText(null)
                return true

            }

        }

        fun validate() {
            if (validateName() && validateEmail() && validatePassword() && validateGender()) {
                Toast.makeText(this@MainActivity, "SUKSEES", Toast.LENGTH_LONG).show()

            }

        }
        btn_submit.setOnClickListener {
            validate()
        }
    }

}
