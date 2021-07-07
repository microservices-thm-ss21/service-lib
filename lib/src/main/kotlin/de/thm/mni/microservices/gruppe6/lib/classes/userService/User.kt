package de.thm.mni.microservices.gruppe6.lib.classes.userService

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class User(
    val id: UUID?,
    val username: String?,
    val name: String?,
    val lastName: String?,
    val email: String?,
    val dateOfBirth: LocalDate?,
    val createTime: LocalDateTime?,
    val globalRole: String?,
    val lastLogin: LocalDateTime?
)

