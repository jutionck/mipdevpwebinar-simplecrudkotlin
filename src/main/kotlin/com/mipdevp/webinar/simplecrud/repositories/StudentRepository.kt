package com.mipdevp.webinar.simplecrud.repositories

import com.mipdevp.webinar.simplecrud.entities.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: JpaRepository<Student, String>
