package net.javaguides.springboot.kafkaconsumerdatabase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaConsumerDatabaseApplication

fun main(args: Array<String>) {
	runApplication<KafkaConsumerDatabaseApplication>(*args)
}
