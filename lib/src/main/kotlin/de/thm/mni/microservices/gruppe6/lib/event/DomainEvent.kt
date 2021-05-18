package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable

abstract class DomainEvent: Serializable {

    abstract val eventCode: EventCode

}

enum class EventCode {
    ISSUE_CHANGED_MESSAGE,
    ISSUE_CHANGED_DEADLINE,
    ISSUE_ASSIGNED_USER,
    ISSUE_REMOVED_USER,





    USER_JOINED_PROJECT,
    USER_LEFT_PROJECT,
    USER_ASSIGNED_ISSUE
}
