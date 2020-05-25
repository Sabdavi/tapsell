package com.tapsell.datapipeline.kafka

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin
import java.util.*

@Configuration
open class KafkaTopicConfig {
    @Value(value = "\${kafka.bootstrapAddress}")
    private val bootstrapAddress: String? = null

    @Value(value = "\${impression.topic.name}")
    private val impressionEventTopicName: String? = null

    @Value(value = "\${click.topic.name}")
    private val clickEventTopicName: String? = null

    @Bean
    open fun kafkaAdmin(): KafkaAdmin? {
        val configs: MutableMap<String?, Any?> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configs)
    }

    @Bean
    open fun impressionTopic(): NewTopic? {
        return NewTopic(impressionEventTopicName, 1, 1.toShort())
    }

    @Bean
    open fun clickTopic(): NewTopic? {
        return NewTopic(clickEventTopicName, 1, 1.toShort())
    }
}