package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable

abstract class DomainEvent: Serializable {

    abstract val eventCode: EventCode

}

enum class EventCode {
    USER_JOINED_PROJECT,
    USER_ASSIGNED_ISSUE
}
