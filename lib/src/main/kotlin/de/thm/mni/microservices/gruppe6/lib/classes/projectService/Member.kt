package de.thm.mni.microservices.gruppe6.lib.classes.projectService

import java.util.*
data class Member(
        var id: UUID?,
        var projectId: UUID,
        var userId: UUID,
        var projectRole: String
) {
    constructor(projectId: UUID, memberDTO: MemberDTO) : this(
            null,
            projectId,
            memberDTO.userId!!,
            memberDTO.projectRole!!
    )
}
