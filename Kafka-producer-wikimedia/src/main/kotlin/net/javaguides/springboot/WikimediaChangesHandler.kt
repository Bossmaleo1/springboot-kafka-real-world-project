package net.javaguides.springboot

import com.launchdarkly.eventsource.EventHandler
import com.launchdarkly.eventsource.MessageEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate


class WikimediaChangesHandler(
    val kafkaTemplate: KafkaTemplate<String, String>,
    val topic: String
):EventHandler {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(WikimediaChangesProducer::class.java)
    }

    override fun onOpen() {}

    override fun onClosed() {}

    override fun onMessage(event: String?, messageEvent: MessageEvent?) {
            LOGGER.info(String.format("Message sent %s", messageEvent!!.data))
            kafkaTemplate.send(topic, messageEvent.data)
    }

    override fun onComment(comment: String?) {}

    override fun onError(t: Throwable?) {}
}