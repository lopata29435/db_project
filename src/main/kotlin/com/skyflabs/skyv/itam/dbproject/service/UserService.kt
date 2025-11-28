package com.skyflabs.skyv.itam.dbproject.service

import com.skyflabs.skyv.itam.dbproject.entity.User

interface UserService {
    fun findAll(): List<User>
}

