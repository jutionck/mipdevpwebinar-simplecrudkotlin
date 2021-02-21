package com.mipdevp.webinar.simplecrud.controllers

import com.mipdevp.webinar.simplecrud.entities.Student
import com.mipdevp.webinar.simplecrud.services.StudentService
import com.mipdevp.webinar.simplecrud.utils.APIResponse
import com.mipdevp.webinar.simplecrud.utils.ListDataPagination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/student"])
class StudentController {

    @Autowired
    lateinit var studentService: StudentService

    @PostMapping(
        value = [""],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun create(@RequestBody body: Student) : APIResponse<Student> {
        val studentResponse = studentService.create(body)
        return APIResponse(
            code = 200,
            status = HttpStatus.OK,
            data = studentResponse
        )
    }

    @GetMapping(
        value = ["/{id}"],
        produces = ["application/json"],
    )
    fun get(@PathVariable("id") id: String): APIResponse<Student> {
        val studentResponse = studentService.get(id)
        return APIResponse(
            code = 200,
            status = HttpStatus.OK,
            data = studentResponse
        )
    }

    @PutMapping(
        value = ["/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun update(
        @PathVariable("id") id: String,
        @RequestBody body: Student): APIResponse<Student> {
        val studentResponse = studentService.update(id, body)
        return APIResponse(
            code = 200,
            status = HttpStatus.OK,
            data = studentResponse
        )
    }

    @DeleteMapping(
        value = ["/{id}"],
        produces = ["application/json"],
    )
    fun delete(@PathVariable("id") id: String): APIResponse<String> {
        studentService.delete(id)
        return APIResponse(
            code = 200,
            status = HttpStatus.OK,
            data = "$id Success deleted!"
        )
    }

    @GetMapping(
        value = [""],
        produces = ["application/json"],
    )
    fun list(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): APIResponse<List<Student>> {
        val request = ListDataPagination(page = page, size = size)
        val response = studentService.list(request)
        return APIResponse(
            code = 200,
            status = HttpStatus.OK,
            data = response
        )
    }

}
