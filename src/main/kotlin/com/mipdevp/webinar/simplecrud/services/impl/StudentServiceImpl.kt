package com.mipdevp.webinar.simplecrud.services.impl

import com.mipdevp.webinar.simplecrud.entities.Student
import com.mipdevp.webinar.simplecrud.repositories.StudentRepository
import com.mipdevp.webinar.simplecrud.services.StudentService
import com.mipdevp.webinar.simplecrud.utils.ListDataPagination
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.stream.Collectors

@Service
class StudentServiceImpl(
    val studentRepository: StudentRepository
): StudentService {

    override fun create(student: Student): Student {
        studentRepository.save(student)
        return convertStudentResponse(student)
    }

    override fun get(id: String): Student {
        val student = findStudentById(id)
        return convertStudentResponse(student)
    }

    override fun update(id: String, updateStudent: Student): Student {
        val student = findStudentById(id)
        student.apply {
            name = updateStudent.name
            npm = updateStudent.npm
            email = updateStudent.email
        }
        return convertStudentResponse(student)
    }
    override fun delete(id: String) {
        val student = findStudentById(id)
        studentRepository.delete(student)
    }

    override fun list(listDataPagination: ListDataPagination): List<Student> {
        val page = studentRepository.findAll(PageRequest.of(listDataPagination.page, listDataPagination.size))
        val listStudent: List<Student> = page.get().collect(Collectors.toList())
        return listStudent.map {
            convertStudentResponse(it)
        }
    }

    private fun convertStudentResponse(student: Student): Student {
        return Student(
            id = student.id!!,
            name = student.name,
            npm = student.npm,
            email = student.email
        )
    }

    private fun findStudentById(id: String): Student {
        val student = studentRepository.getOne(id)
        if(student == null) {
            throw Exception()
        } else {
            return student
        }
    }

}
