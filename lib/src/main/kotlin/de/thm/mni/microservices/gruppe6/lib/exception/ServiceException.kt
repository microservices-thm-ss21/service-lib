package de.thm.mni.microservices.gruppe6.lib.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

/**
 * Exception which maps the HttpStatus and is being handled by the ResponseStatusExceptionResolver to send a HTTP Response
 */
class ServiceException(
    httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    reason: String? = null,
    cause: Throwable? = null
) : ResponseStatusException(httpStatus, reason, cause)
