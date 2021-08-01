package de.thm.mni.microservices.gruppe6.lib.classes.userService

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("userIds")
data class UserId(
    @Id var id: UUID?
)