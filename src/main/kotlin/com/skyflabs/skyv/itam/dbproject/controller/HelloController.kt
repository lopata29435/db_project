package com.skyflabs.skyv.itam.dbproject.controller

import com.skyflabs.skyv.itam.dbproject.dto.HelloDto
import com.skyflabs.skyv.itam.dbproject.dto.UserDto
import com.skyflabs.skyv.itam.dbproject.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloController(private val userService: UserService) {

    @GetMapping("/hello")
    fun hello(): HelloDto = HelloDto("ok")

    @GetMapping("/users")
    fun users(): List<UserDto> = userService.findAll().map { UserDto(it.id, it.name) }
}

