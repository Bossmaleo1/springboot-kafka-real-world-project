package net.javaguides.springboot

import com.launchdarkly.eventsource.EventHandler
import com.launchdarkly.eventsource.EventSource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.net.URI
import java.util.concurrent.TimeUnit

@Service
class WikimediaChangesProducer(
    val kafkaTemplate: KafkaTemplate<String, String>
) {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(WikimediaChangesProducer::class.java)
    }

    fun sendMessage() {
        val topic: String = "wikimedia_recentchange"

        //to read real time stream data from wikimedia, we use event source
        val eventHandler: EventHandler = WikimediaChangesHandler(kafkaTemplate, topic)
        val url: String = "https://stream.wikimedia.org/v2/stream/recentchange"
        //val url = "https://4206121f-64a1-4256-a73d-2ac541b3efe4.mock.pstmn.io/products/search?keyword=samsung"
        val builder: EventSource.Builder = EventSource.Builder(eventHandler, URI.create(url))
        val eventSource: EventSource = builder.build()
        eventSource.start()

        TimeUnit.MINUTES.sleep(10)
    }
}