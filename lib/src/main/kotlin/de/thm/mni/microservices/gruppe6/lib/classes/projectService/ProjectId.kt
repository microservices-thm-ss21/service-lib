package de.thm.mni.microservices.gruppe6.lib.classes.projectService

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("projectIds")
data class ProjectId(
    @Id var id: UUID?
)