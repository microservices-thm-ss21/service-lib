package de.thm.mni.microservices.gruppe6.lib.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ServiceException: ResponseStatusException {
    constructor() : super(HttpStatus.INTERNAL_SERVER_ERROR)
    constructor(cause: Throwable) : super(HttpStatus.INTERNAL_SERVER_ERROR, cause.message, cause)
    constructor(reason: String?) : super(HttpStatus.INTERNAL_SERVER_ERROR, reason)
    constructor(reason: String?, cause: Throwable?) : super(HttpStatus.INTERNAL_SERVER_ERROR, reason, cause)
}
