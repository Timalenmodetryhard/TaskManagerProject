package com.example.taskmanagerproject

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

interface TaskDestination {
    val name: String
    val route: String
}

object Tasks : TaskDestination {
    override val name = "Tasks"
    override val route = "tasks"
}

object Notifications : TaskDestination {
    override val name = "Notifications"
    override val route = "notifications"
}

object AddTask : TaskDestination {
    override val name = "Add a task"
    override val route = "add_tasks"
}

object LoginPage : TaskDestination {
    override val name = "Logout"
    override val route = "login"
}

val  taskTabRowScreens = listOf(Notifications, Tasks, AddTask, LoginPage)