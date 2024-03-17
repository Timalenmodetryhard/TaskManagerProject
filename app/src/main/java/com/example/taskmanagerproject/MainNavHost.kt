package com.example.taskmanagerproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskmanagerproject.ui.tasks.TasksScreen
import com.example.taskmanagerproject.ui.add_task.AddTaskScreen
import com.example.taskmanagerproject.ui.notifications.NotificationsScreen
import com.example.taskmanagerproject.ui.login.LoginScreen
import com.example.taskmanagerproject.ui.login.connectEmail

@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = LoginPage.route,
        modifier = modifier
    ) {
        composable("login") {

            LoginScreen(onLoginSuccess = {
                navController.navigate("tasks"){
                    popUpTo(0)
                }
            })
        }
        composable(route = Tasks.route) {
            TasksScreen(
                text = "Tasks"
            )
        }
        composable(route = AddTask.route) {
            AddTaskScreen(onTaskAdd = {
                navController.navigate("tasks"){
                    popUpTo(0)
                }
            })
        }
        composable(route = Notifications.route) {
            NotificationsScreen(
                text = "Notifications"
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }