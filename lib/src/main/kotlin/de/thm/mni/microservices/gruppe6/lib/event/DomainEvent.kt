package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable
import java.time.LocalDate
import java.util.*

abstract class DomainEvent : Serializable {

    abstract val code: DomainEventCode

}

enum class DomainEventCode {
    /** Issue-Events */
    ISSUE_CHANGED_MESSAGE,
    ISSUE_CHANGED_DEADLINE,
    ISSUE_CHANGED_USER,

    /** User-Events*/
    USER_JOINED_PROJECT,
    USER_LEFT_PROJECT,
    USER_ASSIGNED_ISSUE,

    /** Project-Events */
}

//data class IssueDomainEvent(override val code: DomainEventCode) : DomainEvent()

data class DomainEventChangedString(
    override val code: DomainEventCode,
    val id: UUID,
    val oldData: String?,
    val newData: String?
): DomainEvent()

data class DomainEventChangedUUID(
    override val code: DomainEventCode,
    val id: UUID,
    val oldData: UUID?,
    val newData: UUID?
        ): DomainEvent()

data class DomainEventChangedDate(
    override val code: DomainEventCode,
    val id: UUID,
    val oldData: LocalDate?,
    val newData: LocalDate?
): DomainEvent()

data class UserDomainEvent(override val code: DomainEventCode) : DomainEvent()

data class ProjectDomainEvent(override val code: DomainEventCode) : DomainEvent()

