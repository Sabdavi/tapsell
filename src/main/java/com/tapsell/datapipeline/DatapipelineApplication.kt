package com.tapsell.datapipeline

import com.tapsell.datapipeline.kafka.KafkaMessageListener
import com.tapsell.datapipeline.kafka.KafkaProducer
import com.tapsell.datapipeline.kafka.Produce
import com.tapsell.datapipeline.service.AdEventService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class DatapipelineApplication {

    @Bean
    open fun getAdEventService(): AdEventService? {
        return AdEventService()
    }

    @Bean
    open fun getKafkaProducer(): KafkaProducer? {
        return KafkaProducer()
    }

    @Bean
    open fun getKafkaConsumer(): KafkaMessageListener? {
        return KafkaMessageListener()
    }
}


fun main(args: Array<String>) {

    val context = runApplication<DatapipelineApplication>(*args)
    val kafkaProducer = context.getBean(KafkaProducer::class.java, *args);
    val produce = Produce(kafkaProducer)
    produce.produceImpressionEvent()
    produce.produceClickEvent()
}