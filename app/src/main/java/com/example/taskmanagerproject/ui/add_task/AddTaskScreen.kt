package com.example.taskmanagerproject.ui.add_task

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
import com.example.taskmanagerproject.ui.login.connectEmail

@Composable
fun AddTaskScreen(onTaskAdd: () -> Unit){
    var name by remember { mutableStateOf("") }
    val context = LocalContext.current.applicationContext

    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(value = name, onValueChange = { name = it },
            label = { Text(text = "Name")},
            shape = RoundedCornerShape(20.dp),

            )
        Button(onClick = {
            if (valid(name)){
                onTaskAdd()
                UserData.accounts.map { account ->
                    if (account.email == connectEmail){
                        account.tasks.add(name)
                    }
                }
                Toast.makeText(context, "Task added", Toast.LENGTH_SHORT)
            } else {
                Toast.makeText(context, "Empty task name", Toast.LENGTH_SHORT)
            }
        }) {
            Text(text = "Add", fontSize = 22.sp)
        }
    }
}

private fun valid(name: String): Boolean{
    return name.isNotEmpty()
}