package de.thm.mni.microservices.gruppe6.lib.classes.projectService

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("members")
data class Member(
    @Id @JsonIgnore var id: UUID?,
    var projectId: UUID,
    var userId: UUID,
    var projectRole: String
) {
    constructor(projectId: UUID, userId: UUID, projectRole: ProjectRole) : this(
        null,
        projectId,
        userId,
        projectRole.name
    )
}
