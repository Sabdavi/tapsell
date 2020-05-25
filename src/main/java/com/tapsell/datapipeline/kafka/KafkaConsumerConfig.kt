package com.tapsell.datapipeline.kafka

import com.tapsell.datapipeline.model.ClickEvent
import com.tapsell.datapipeline.model.ImpressionEvent
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import java.util.*

@EnableKafka
@Configuration
open class KafkaConsumerConfig {
    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress: String? = null
    private fun impressionEventConsumerFactory(): ConsumerFactory<String?, ImpressionEvent?>? {
        val props: MutableMap<String?, Any?> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = "impression"
        return DefaultKafkaConsumerFactory(props, StringDeserializer(), JsonDeserializer(ImpressionEvent::class.java))
    }

    @Bean
    open fun impressionEventConcurrentKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String?, ImpressionEvent?>? {
        val factory = ConcurrentKafkaListenerContainerFactory<String?, ImpressionEvent?>()
        factory.consumerFactory = impressionEventConsumerFactory()
        return factory
    }

    private fun clickEventConsumerFactory(): ConsumerFactory<String?, ClickEvent?>? {
        val props: MutableMap<String?, Any?> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        props[ConsumerConfig.GROUP_ID_CONFIG] = "click"
        return DefaultKafkaConsumerFactory(props, StringDeserializer(), JsonDeserializer(ClickEvent::class.java))
    }

    @Bean
    open fun clickEventConcurrentKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String?, ClickEvent?>? {
        val factory = ConcurrentKafkaListenerContainerFactory<String?, ClickEvent?>()
        factory.consumerFactory = clickEventConsumerFactory()
        return factory
    }
}