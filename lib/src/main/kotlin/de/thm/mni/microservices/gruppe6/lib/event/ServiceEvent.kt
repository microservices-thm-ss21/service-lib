package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable

data class ServiceEvent(
    val eventCode: EventCode,
    val content: Serializable
    ): Serializable