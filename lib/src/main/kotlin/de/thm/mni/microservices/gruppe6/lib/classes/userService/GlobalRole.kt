package de.thm.mni.microservices.gruppe6.lib.classes.userService

import org.springframework.security.core.GrantedAuthority

enum class GlobalRole: GrantedAuthority {
    USER,
    ADMIN,
    SUPPORT,
    NORMAL;

    override fun getAuthority(): String = this.name
}