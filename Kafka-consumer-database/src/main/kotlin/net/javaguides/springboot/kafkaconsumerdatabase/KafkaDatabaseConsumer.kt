package net.javaguides.springboot.kafkaconsumerdatabase

import net.javaguides.springboot.kafkaconsumerdatabase.entity.WikimediaData
import net.javaguides.springboot.kafkaconsumerdatabase.repository.WikimediaDataRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaDatabaseConsumer(
    val dataRepository: WikimediaDataRepository
) {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(KafkaDatabaseConsumer::class.java)
    }

    @KafkaListener(
        topics = ["wikimedia_recentchange"],
        groupId = "myGroup"
    )
    fun consume(eventMessage: String) {
        LOGGER.info(String.format("Event message received -> %s", eventMessage))
        /*val wikimediaData = WikimediaData()
        wikimediaData.wikiEventData = eventMessage*/

val wikimediaData = WikimediaData(eventMessage.split("/")[0])

        dataRepository.save(
            wikimediaData
        )

    }
}