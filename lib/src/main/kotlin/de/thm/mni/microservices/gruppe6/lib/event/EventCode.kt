package de.thm.mni.microservices.gruppe6.lib.event

enum class EventCode {
    ISSUE_CREATED,
    ISSUE_UPDATED,
    ISSUE_DELETED,

    PROJECT_CREATED,
    PROJECT_UPDATED,
    PROJECT_DELETED,

    USER_CREATED,
    USER_UPDATED,
    USER_DELETED,

    USER_GOT_ROLE,
    USER_JOINED_PROJECT
}