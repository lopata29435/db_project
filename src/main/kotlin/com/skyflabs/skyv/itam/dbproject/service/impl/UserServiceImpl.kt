package com.skyflabs.skyv.itam.dbproject.service.impl

import com.skyflabs.skyv.itam.dbproject.entity.User
import com.skyflabs.skyv.itam.dbproject.repository.UserRepository
import com.skyflabs.skyv.itam.dbproject.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun findAll(): List<User> = userRepository.findAll()
}

