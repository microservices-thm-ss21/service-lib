package de.thm.mni.microservices.gruppe6.lib.event

/**
 * Enum-Alike, but compiler constant class for defining event topics. Used within the sender and receiver
 */
sealed class EventTopic {
    object DataEvents {
        const val topic = "microservices.dataEvents"
    }

    object DomainEvents_IssueService {
        const val topic = "microservices.domainEvents.issueService"
    }

    object DomainEvents_ProjectService {
        const val topic = "microservices.domainEvents.projectService"
    }

    object DomainEvents_UserService {
        const val topic = "microservices.domainEvents.userService"
    }

    object DomainEvents_NewsService {
        const val topic = "microservices.domainEvents.newsService"
    }

    object SagaEvents {
        const val topic = "microservices.sagaEvents"
    }
}
