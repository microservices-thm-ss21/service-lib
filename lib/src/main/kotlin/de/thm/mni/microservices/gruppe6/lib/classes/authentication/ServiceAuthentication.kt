package de.thm.mni.microservices.gruppe6.lib.classes.authentication

import de.thm.mni.microservices.gruppe6.lib.classes.userService.GlobalRole
import de.thm.mni.microservices.gruppe6.lib.classes.userService.User
import org.springframework.security.core.Authentication

/**
 * Class representing a Authentication object used by all services.
 */
class ServiceAuthentication(
    val user: User?,
    private val jwt: String
) : Authentication {

    private var valid: Boolean = true

    override fun getName() = user?.name
    override fun getAuthorities() = mutableListOf(GlobalRole.valueOf(user?.globalRole!!))
    override fun getCredentials() = jwt
    override fun getDetails() = jwt
    override fun getPrincipal() = user
    override fun isAuthenticated() = user != null && valid
    override fun setAuthenticated(isAuthenticated: Boolean) {
        valid = isAuthenticated
    }

    constructor(jwt: String) : this(null, jwt)


}
