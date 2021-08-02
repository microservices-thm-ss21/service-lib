package de.thm.mni.microservices.gruppe6.lib.event

import java.io.Serializable
import java.time.LocalDate
import java.util.*

/**
 * DomainEvents are used for Project-Specific messages which often have more detail and are not relevant for every other service.
 * These Events should be indivisible, rather use two events instead of one.
 * @param code Specifies what kind of action caused the event and thus what kind of message can be displayed
 */
abstract class DomainEvent : Serializable {

    /**
     * Specifies what kind of action caused the event and thus what kind of message can be displayed
     */
    abstract val code: DomainEventCode

}

/**
 * Specifies all kind of domain events to allow a distinct display of different event messages
 */
enum class DomainEventCode {
    /** Issue-Events */
    ISSUE_CHANGED_MESSAGE,
    ISSUE_CHANGED_DEADLINE,
    ISSUE_CHANGED_USER,
    ISSUE_CHANGED_STATUS,

    /** User-Events*/
    USER_CHANGED_USERNAME,
    USER_CHANGED_LASTNAME,
    USER_CHANGED_NAME,
    USER_CHANGED_EMAIL,
    USER_CHANGED_DATEOFBIRTH,
    USER_CHANGED_GLOBALROLE,

    /** Project-Events */
    PROJECT_CHANGED_NAME,
    PROJECT_CHANGED_MEMBER,
    PROJECT_CHANGED_ALL_MEMBERS
}

/**
 * Used generic for any Domain event which changes of one object (with ID) one String value to another String value.
 * @param code specifies what was the issuing event, allowing the display of a distinct event message.
 * @param id unique UUID of the object changed
 * @param oldData the old String value for message display purposes. None if old data was unset
 * @param newData the new String value for message display purposes. None if new data is unset
 */
data class DomainEventChangedString(
    override val code: DomainEventCode,
    val id: UUID,
    val oldData: String?,
    val newData: String?
): DomainEvent()

/**
 * Used generic for any Domain event which changes of one object (with ID) one UUID value to another UUID value.
 * @param code specifies what was the issuing event, allowing the display of a distinct event message.
 * @param id unique UUID of the object changed
 * @param oldData the old UUID value for message display purposes. None if old value was unset
 * @param newData the new UUID value for message display purposes. None if new value is unset
 */
data class DomainEventChangedUUID(
    override val code: DomainEventCode,
    val id: UUID,
    val oldData: UUID?,
    val newData: UUID?
        ): DomainEvent()

/**
 * Used generic for any Domain event which changes of one object (with ID) one date value to another date value.
 * @param code specifies what was the issuing event, allowing the display of a distinct event message.
 * @param id unique UUID of the object changed
 * @param oldData the old date value for message display purposes. None if old value was unset
 * @param newData the new date value for message display purposes. None if new value is unset
 */
data class DomainEventChangedDate(
    override val code: DomainEventCode,
    val id: UUID,
    val oldData: LocalDate?,
    val newData: LocalDate?
): DomainEvent()

/**
 * Used generic for any Domain event which changes of one object (with ID) and an additional affected id one date value to another date value.
 * @param code specifies what was the issuing event, allowing the display of a distinct event message.
 * @param id unique UUID of the object changed
 * @param id unique UUID of an additional object changed
 * @param oldData the old date value for message display purposes. None if old value was unset
 * @param newData the new date value for message display purposes. None if new value is unset
 */
data class DomainEventChangedStringUUID(
    override val code: DomainEventCode,
    val id: UUID,
    val affectedId: UUID?,
    val oldDataString: String?,
    val newDataString: String?
): DomainEvent()
