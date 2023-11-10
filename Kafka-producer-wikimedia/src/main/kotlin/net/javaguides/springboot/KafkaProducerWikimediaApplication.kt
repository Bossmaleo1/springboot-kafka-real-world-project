package net.javaguides.springboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaProducerWikimediaApplication : CommandLineRunner {

    @Autowired
    lateinit var wikimediaChangesProducer: WikimediaChangesProducer

    override fun run(vararg args: String?) {
        wikimediaChangesProducer.sendMessage()
    }
}

fun main(args: Array<String>) {
    runApplication<KafkaProducerWikimediaApplication>(*args)
}
