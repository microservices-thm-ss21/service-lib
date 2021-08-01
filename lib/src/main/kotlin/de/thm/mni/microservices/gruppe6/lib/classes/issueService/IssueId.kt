package de.thm.mni.microservices.gruppe6.lib.classes.issueService

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("issueIds")
data class IssueId(
    @Id var id: UUID?
)