package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable
import java.util.*

enum class SagaReferenceType {
    PROJECT,
    ISSUE,
    USER
}

enum class ProjectSagaStatus {
    BEGIN,
    ISSUES_DELETED,
    COMPLETE
}

abstract class SagaEvent: Serializable {
    abstract val referenceType: SagaReferenceType
    abstract val referenceValue: UUID
    abstract val success: Boolean
}

data class ProjectSagaEvent(
    override val referenceValue: UUID,
    val projectSagaStatus: ProjectSagaStatus,
    override val success: Boolean,
    override val referenceType: SagaReferenceType = SagaReferenceType.PROJECT
    ): SagaEvent()