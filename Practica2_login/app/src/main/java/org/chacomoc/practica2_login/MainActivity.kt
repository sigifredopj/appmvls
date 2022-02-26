package org.chacomoc.practica2_login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var txtUser : EditText
    private lateinit var txtPass : EditText
    private lateinit var btnSend : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initElements()
    }

    private fun initElements(){
        txtUser = findViewById(R.id.txtUser)
        txtPass = findViewById(R.id.txtPass)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener{
            if(validator(txtUser.text.toString(),txtPass.text.toString())){
                var intent = Intent(this, welcome ::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Usuario o contraseña no valido",Toast.LENGTH_SHORT).show()
                txtUser.setText("")
                txtPass.setText("")
            }
        }
    }

    private fun validator(user: String, password: String): Boolean{
        if(user.equals("sigi") && password.equals("igis")){
            return true
        }
        return false
    }
}
