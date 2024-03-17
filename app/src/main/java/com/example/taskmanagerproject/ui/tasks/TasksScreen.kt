package com.example.taskmanagerproject.ui.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagerproject.data.UserData
import com.example.taskmanagerproject.ui.login.connectEmail
import com.example.taskmanagerproject.ui.theme.TaskManagerProjectTheme
import kotlinx.coroutines.delay

@Composable
fun TasksScreen(
    text:String,
    modifier : Modifier = Modifier
) {
    var refreshTrigger by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(fraction = 0.95f)
    ) {
        UserData.accounts.map { account ->
            if (connectEmail == account.email) {
                account.tasks.map { task ->
                    TaskComponent(
                        text = task,
                        isChecked = account.notifications.contains(task),
                        onMarkAsValidClick = {
                            account.notifications.add(task+", done.")
                            account.tasks.remove(task)
                            refreshTrigger++
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        LaunchedEffect(refreshTrigger) {
            delay(100)
        }
    }
}

@Composable
fun TaskComponent(
    text : String,
    isChecked: Boolean,
    onMarkAsValidClick: () -> Unit,
    backgroundColor : Color = Color(95, 205, 231),
    modifier : Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(backgroundColor)
            .clip(RoundedCornerShape(20.dp))
            .padding(8.dp)
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
        )
        Button(
            onClick = onMarkAsValidClick,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Validate tasks")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerProjectTheme {
        TasksScreen(text = "Tasks")
    }
}