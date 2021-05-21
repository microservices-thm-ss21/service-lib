package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable

abstract class DomainEvent : Serializable {

    abstract val code: DomainEventCode

}

enum class DomainEventCode {
    /** Issue-Events */
    ISSUE_CHANGED_MESSAGE,
    ISSUE_CHANGED_DEADLINE,
    ISSUE_ASSIGNED_USER,
    ISSUE_REMOVED_USER,

    /** User-Events*/
    USER_JOINED_PROJECT,
    USER_LEFT_PROJECT,
    USER_ASSIGNED_ISSUE,

    /** Project-Events */
}

data class IssueDomainEvent(override val code: DomainEventCode) : DomainEvent()

data class UserDomainEvent(override val code: DomainEventCode) : DomainEvent()

data class ProjectDomainEvent(override val code: DomainEventCode) : DomainEvent()

