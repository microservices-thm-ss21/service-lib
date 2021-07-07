package de.thm.mni.microservices.gruppe6.lib.classes.projectService

import java.util.*

/**
 * DTO = Data Transport Object
 */
data class MemberDTO (
    var userId: UUID? = null,
    var projectRole: String? = null
)
