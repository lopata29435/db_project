package com.skyflabs.skyv.itam.dbproject.service.impl

import com.skyflabs.skyv.itam.dbproject.entity.Location
import com.skyflabs.skyv.itam.dbproject.repository.LocationRepository
import com.skyflabs.skyv.itam.dbproject.service.LocationService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LocationServiceImpl(private val locationRepository: LocationRepository) : LocationService {
    override fun getAllLocations(): List<Location> = locationRepository.findAll()

    override fun getLocationById(id: Long): Location = locationRepository.findById(id).orElseThrow { RuntimeException("Location not found") }

    @Transactional
    override fun createLocation(location: Location): Location = locationRepository.save(location)

    @Transactional
    override fun updateLocation(id: Long, location: Location): Location {
        val existing = getLocationById(id)
        existing.name = location.name
        return locationRepository.save(existing)
    }

    @Transactional
    override fun deleteLocation(id: Long) = locationRepository.deleteById(id)
}

