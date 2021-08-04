package de.thm.mni.microservices.gruppe6.lib.exception

import org.springframework.http.HttpStatus

/**
 * Covers all unexpected exceptions.
 * Removes the error message and changaes httpStatus to internalServerError.
 * A Exception is unexpected if it is not an instance of ServiceException.
 * @param exception
 * @return coveredException
 */
fun coverUnexpectedException(exception: Throwable): Throwable {
    return if (exception !is ServiceException) {
        ServiceException(HttpStatus.INTERNAL_SERVER_ERROR)
    } else {
        exception
    }
}
