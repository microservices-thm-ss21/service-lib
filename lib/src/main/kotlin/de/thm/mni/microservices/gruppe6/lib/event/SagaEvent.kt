package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable
import java.util.*

enum class SagaReferenceType {
    PROJECT,
    ISSUE,
    USER
}

abstract class SagaEvent: Serializable {
    abstract val referenceType: SagaReferenceType
    abstract val referenceValue: UUID
    abstract val success: Boolean
}

data class DeletedIssuesSagaEvent(
    override val referenceType: SagaReferenceType = SagaReferenceType.PROJECT,
    override val referenceValue: UUID,
    override val success: Boolean,
): SagaEvent()