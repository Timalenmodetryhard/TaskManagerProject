package com.example.taskmanagerproject.ui.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagerproject.data.UserData

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext

    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(value = email, onValueChange = { email = it },
            label = { Text(text = "Email")},
            shape = RoundedCornerShape(20.dp),

        )

        OutlinedTextField(value = password, onValueChange = { password = it },
            label = { Text(text = "Password")},
            shape = RoundedCornerShape(20.dp),

            )
        Button(onClick = {
            if (authentificate(email, password)){
                onLoginSuccess()
                Toast.makeText(context, "Login successul", Toast.LENGTH_SHORT)
            } else {
                Toast.makeText(context, "Invalid password/email", Toast.LENGTH_SHORT)
            }
        }) {
            Text(text = "Login", fontSize = 22.sp)
        }
    }
}

var connectEmail = ""

private fun authentificate(email: String, password: String): Boolean{
    var validEmail : String? = null
    var validPassword : String? = null
    UserData.accounts.map { account ->
        if (account.email == email && account.password == password) {
            validEmail = email
            validPassword = password
            connectEmail = email
        }
    }

    return email == validEmail && password == validPassword
}