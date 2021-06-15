package de.thm.mni.microservices.gruppe6.lib.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

/**
 * Exception which maps the HttpStatus and is being handled by the ResponseStatusExceptionResolver to send a HTTP Response
 */
class ServiceException: ResponseStatusException {
    constructor() : this(HttpStatus.INTERNAL_SERVER_ERROR)
    constructor(cause: Throwable) : this(HttpStatus.INTERNAL_SERVER_ERROR, cause)
    constructor(reason: String?) : this(HttpStatus.INTERNAL_SERVER_ERROR, reason)
    constructor(reason: String?, cause: Throwable?) : this(HttpStatus.INTERNAL_SERVER_ERROR, reason, cause)
    constructor(httpStatus: HttpStatus) : super(httpStatus)
    constructor(httpStatus: HttpStatus, cause: Throwable) : this(httpStatus, cause.message, cause)
    constructor(httpStatus: HttpStatus, reason: String?) : super(httpStatus, reason)
    constructor(httpStatus: HttpStatus, reason: String?, cause: Throwable?) : super(httpStatus, reason, cause)
}
