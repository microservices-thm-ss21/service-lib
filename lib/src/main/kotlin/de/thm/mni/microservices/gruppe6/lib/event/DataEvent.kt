package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable
import java.util.*

/**
 * Event used for data-changing information's which are required for most services to update their internal database.
 * @property code DataEventcode whether the object was created, updated or deleted.
 * @property id the unique UUID of the object issuing this event
 */
abstract class DataEvent: Serializable {
    abstract val code: DataEventCode
    abstract val id: UUID
}

/**
 * General Eventcode for Dataevents, whether the object was created, updated or deleted
 */
enum class DataEventCode {
    CREATED,
    UPDATED,
    DELETED
}

/**
 * Special Event for the IssueService, issued when creating/updating/deleting an issue so other services can update their DB.
 * @param code The cause of the Event: update, delete, create
 * @param id the unique UUID of the object issuing this event
 * @param projectId Optional issue-specific param, the project associated with this issue
 */
data class IssueDataEvent(override val code: DataEventCode, override val id: UUID, val projectId: UUID? = null): DataEvent()
/**
 * Special Event for the UserServices, issued when creating/updating/deleting a user so other services can update their DB.
 * @param code The cause of the Event: update, delete, create
 * @param id the unique UUID of the object issuing this event
 */
data class UserDataEvent(override val code: DataEventCode, override val id: UUID): DataEvent()
/**
 * Special Event for the ProjectService, issued when creating/updating/deleting a project so other services can update their DB.
 * @param code The cause of the Event: update, delete, create
 * @param id the unique UUID of the object issuing this event
 */
data class ProjectDataEvent(override val code: DataEventCode, override val id: UUID): DataEvent()
