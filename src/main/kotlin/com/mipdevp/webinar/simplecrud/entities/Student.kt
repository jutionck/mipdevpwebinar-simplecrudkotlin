package com.mipdevp.webinar.simplecrud.entities

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "students")
data class Student(

    @Id //Primary Key
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false, length = 64)
    var id: String?,

    @Column(name = "name", length = 30)
    var name: String,

    @Column(name = "npm", length = 10)
    var npm: String,

    @Column(name = "email", length = 60)
    var email: String
)
