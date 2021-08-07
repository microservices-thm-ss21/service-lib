package de.thm.mni.microservices.gruppe6.lib.classes.userService

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

/**
 * DTO = Data Transport Object
 */
class UserDTO {
    var username: String? = null
    var password: String? = null
    var name: String? = null
    var lastName: String? = null
    var email: String? = null

    @JsonFormat(pattern = "dd.MM.yyyy")
    var dateOfBirth: LocalDate? = null
    var globalRole: GlobalRole? = null

    override fun toString(): String {
        return "username: $username, password: $password, name: $name, lastName: $lastName, email: $email, dateOfBirth: $dateOfBirth role: $globalRole"
    }
}
