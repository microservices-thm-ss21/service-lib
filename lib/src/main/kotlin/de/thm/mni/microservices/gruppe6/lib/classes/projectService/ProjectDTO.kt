package de.thm.mni.microservices.gruppe6.lib.classes.projectService

import java.util.*

/**
 * DTO = Data Transport Object
 */
data class ProjectDTO (
    var name: String? = null,
    var creatorId: UUID? = null,
    var members: List<MemberDTO>? = null
)
