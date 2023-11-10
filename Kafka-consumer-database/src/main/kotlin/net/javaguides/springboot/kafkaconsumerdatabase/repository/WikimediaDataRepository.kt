package net.javaguides.springboot.kafkaconsumerdatabase.repository

import net.javaguides.springboot.kafkaconsumerdatabase.entity.WikimediaData
import org.springframework.data.jpa.repository.JpaRepository

interface WikimediaDataRepository : JpaRepository<WikimediaData, Long> {
}