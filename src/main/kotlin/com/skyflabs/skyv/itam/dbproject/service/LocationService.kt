package com.skyflabs.skyv.itam.dbproject.service

import com.skyflabs.skyv.itam.dbproject.entity.Location

interface LocationService {
    fun getAllLocations(): List<Location>
    fun getLocationById(id: Long): Location
    fun createLocation(location: Location): Location
    fun updateLocation(id: Long, location: Location): Location
    fun deleteLocation(id: Long)
}

