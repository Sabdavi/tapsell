package com.tapsell.datapipeline.kafka

import com.tapsell.datapipeline.model.ClickEvent
import com.tapsell.datapipeline.model.ImpressionEvent
import org.springframework.stereotype.Component

@Component
class Produce(kafkaProducer: KafkaProducer) {
    private val kafkaProducer: KafkaProducer
    private val impressionEvents: List<ImpressionEvent>
    private val clickEvents: List<ClickEvent>
    fun produceImpressionEvent() {
        for (event in impressionEvents) kafkaProducer.sendImpressionMessage(event)
    }

    fun produceClickEvent() {
        for (event in clickEvents) kafkaProducer.sendClickMessage(event)
    }

    init {
        val dataUtils = DataUtils()
        this.kafkaProducer = kafkaProducer
        impressionEvents = dataUtils.generateEmpressionEvent()
        clickEvents = dataUtils.generateClickEvent()
    }
}