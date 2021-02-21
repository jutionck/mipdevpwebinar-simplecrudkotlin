package com.mipdevp.webinar.simplecrud.services

import com.mipdevp.webinar.simplecrud.entities.Student
import com.mipdevp.webinar.simplecrud.utils.ListDataPagination

interface StudentService {

    fun create(student: Student): Student

    fun get(id: String): Student

    fun update(id: String, updateStudent: Student): Student

    fun delete(id: String)

    fun list(listDataPagination: ListDataPagination): List<Student>
}
