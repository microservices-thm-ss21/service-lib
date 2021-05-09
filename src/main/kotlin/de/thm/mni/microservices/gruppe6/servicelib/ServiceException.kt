package de.thm.mni.microservices.gruppe6.servicelib

import org.springframework.http.HttpStatus

class ServiceException(message: String) : Exception(message) {

    val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR

}