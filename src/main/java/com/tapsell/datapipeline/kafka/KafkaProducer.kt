package com.tapsell.datapipeline.kafka

import com.tapsell.datapipeline.model.ClickEvent
import com.tapsell.datapipeline.model.ImpressionEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate

/**
 * use Producer Api for publishing data to Kafka topics
 */
class KafkaProducer {
    @Autowired
    private val impressionEventKafkaTemplate: KafkaTemplate<String?, ImpressionEvent?>? = null

    @Autowired
    private val clickEventKafkaTemplate: KafkaTemplate<String?, ClickEvent?>? = null

    @Value(value = "\${impression.topic.name}")
    private val impressionTopicName: String? = null

    @Value(value = "\${click.topic.name}")
    private val clickTopicName: String? = null
    fun sendImpressionMessage(impressionEvent: ImpressionEvent?) {
        impressionEventKafkaTemplate?.send(impressionTopicName, impressionEvent)
    }

    fun sendClickMessage(clickEvent: ClickEvent?) {
        clickEventKafkaTemplate?.send(clickTopicName, clickEvent)
    }
}