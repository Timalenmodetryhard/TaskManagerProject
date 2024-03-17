package com.example.taskmanagerproject.data

import androidx.compose.runtime.Immutable

/* Hard-coded data for the Rally sample. */

@Immutable
data class Account(
    val email: String,
    val password: String,
    var notifications: MutableList<String>,
    var tasks: MutableList<String>,
)

object UserData {
    val accounts: List<Account> = listOf(
        Account(
            "leeliandu972@gmail.com",
            "leevee972",
            mutableListOf("Passer le balai, done.",
                "Passer le balai2, done.",
                "Passer le balai3, done."),
            mutableListOf("Faire la vaisselle",
                "Faire la vaisselle2",
                "Faire la vaisselle3")
        ),
        Account(
            "google@gmail.com",
            "1234",
            mutableListOf("Passer le balai, done.",
                "Passer le balai2, done.",
                "Passer le balai3, done."),
            mutableListOf("Faire la vaisselle",
                "Faire la vaisselle2",
                "Faire la vaisselle3")
        ),
        Account(
            "example@gmail.com",
            "1234",
            mutableListOf("Passer le balai, done.",
                "Passer le balai2, done.",
                "Passer le balai3, done."),
            mutableListOf("Faire la vaisselle",
                "Faire la vaisselle2",
                "Faire la vaisselle3")
        ),
        Account(
            "email@gmail.com",
            "1234",
            mutableListOf("Passer le balai, done.",
                "Passer le balai2, done.",
                "Passer le balai3, done."),
            mutableListOf("Faire la vaisselle",
                "Faire la vaisselle2",
                "Faire la vaisselle3")
        )
    )

    fun getAccount(accountName: String?): Account {
        return accounts.first { it.email == accountName }
    }
}