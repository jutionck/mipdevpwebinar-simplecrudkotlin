package com.mipdevp.webinar.simplecrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication //annotation
class SimplecrudApplication

fun main(args: Array<String>) {
	runApplication<SimplecrudApplication>(*args)
}
