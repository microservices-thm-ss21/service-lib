package de.thm.mni.microservices.gruppe6.lib.classes.userService

import com.fasterxml.jackson.annotation.JsonIgnore
import io.jsonwebtoken.Claims
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.userdetails.UserDetails
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Table("users")
data class User(
    @Id var id: UUID? = null,
    @Column private var username: String,
    @Column private var password: String,
    @Column var name: String,
    @Column var lastName: String,
    @Column var email: String,
    @Column var dateOfBirth: LocalDate,
    @Column var createTime: LocalDateTime,
    @Column var globalRole: String,
) : UserDetails {
    constructor(userDTO: UserDTO) : this(
        null,
        userDTO.username!!,
        userDTO.password!!,
        userDTO.name!!,
        userDTO.lastName!!,
        userDTO.email!!,
        userDTO.dateOfBirth!!,
        LocalDateTime.now(),
        userDTO.globalRole!!.name,
    )

    @JsonIgnore
    override fun getAuthorities() = mutableListOf(GlobalRole.valueOf(globalRole.toUpperCase()))
    @JsonIgnore
    override fun getPassword() = password
    fun setPassword(password: String) {
        this.password = password
    }

    fun setUsername(username: String) {
        this.username = username
    }

    @JsonIgnore
    override fun getUsername() = username
    @JsonIgnore
    override fun isAccountNonExpired() = true
    @JsonIgnore
    override fun isAccountNonLocked() = true
    @JsonIgnore
    override fun isCredentialsNonExpired() = true
    @JsonIgnore
    override fun isEnabled() = true

    @JsonIgnore
    fun getJwtClaims(): Map<String, Any?> =
        mutableMapOf<String, Any?>(
            Pair("id", id),
            Pair("username", username),
            Pair("password", password),
            Pair("name", name),
            Pair("lastName", lastName),
            Pair("email", email),
            Pair("dateOfBirth", Date.from(dateOfBirth.atStartOfDay(ZoneId.systemDefault()).toInstant())),
            Pair("createTime", Date.from(createTime.atZone(ZoneId.systemDefault()).toInstant())),
            Pair("globalRole", globalRole),
        )

    @JsonIgnore
    constructor(claims: Claims) : this(
        UUID.fromString(claims["id"] as String),
        claims["username"] as String,
        claims["password"] as String,
        claims["name"] as String,
        claims["lastName"] as String,
        claims["email"] as String,
        Instant.ofEpochMilli(claims["dateOfBirth"] as Long).atZone(ZoneId.systemDefault()).toLocalDate(),
        Instant.ofEpochMilli(claims["createTime"] as Long).atZone(ZoneId.systemDefault()).toLocalDateTime(),
        claims["globalRole"] as String,
    )

}

