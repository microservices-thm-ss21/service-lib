package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable
import java.util.*

abstract class DataEvent: Serializable {
    abstract val code: DataEventCode
    abstract val id: UUID
}

enum class DataEventCode {
    CREATED,
    UPDATED,
    DELETED
}

data class IssueEvent(override val code: DataEventCode, override val id: UUID): DataEvent()

data class UserEvent(override val code: DataEventCode, override val id: UUID): DataEvent()

data class ProjectEvent(override val code: DataEventCode, override val id: UUID): DataEvent()
