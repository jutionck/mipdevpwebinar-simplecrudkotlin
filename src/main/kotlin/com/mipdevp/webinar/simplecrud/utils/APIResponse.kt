package com.mipdevp.webinar.simplecrud.utils

import org.springframework.http.HttpStatus

data class APIResponse<T>(

    val code: Int,
    val status: HttpStatus,
    val data: T
)
