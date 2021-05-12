package de.thm.mni.microservices.gruppe6.lib.event

data class ServiceEvent (
    val eventCode: EventCode,
    val message: String
    )