package de.thm.mni.microservices.gruppe6.lib.classes.projectService

import java.time.LocalDateTime
import java.util.*

data class Project(
    var id: UUID?,
    var name: String,
    var creatorId: UUID?,
    var createTime: LocalDateTime,
) {
    constructor(projectDTO: ProjectDTO) : this(
            null,
            projectDTO.name!!,
            projectDTO.creatorId,
            LocalDateTime.now()
    )
}

