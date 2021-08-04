package de.thm.mni.microservices.gruppe6.lib.classes.projectService


enum class ProjectRole {
    USER,
    ADMIN,
    SUPPORT;

    fun getAuthority(): String = this.name
}
