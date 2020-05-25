package com.tapsell.datapipeline.kafka

import com.tapsell.datapipeline.model.ClickEvent
import com.tapsell.datapipeline.model.ImpressionEvent
import com.tapsell.datapipeline.service.AdEventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener

/**
 * we register listeners for listening to both topics including click and impression
 */

class KafkaMessageListener {
    @Autowired
    var adEventService: AdEventService? = null

    @KafkaListener(topics = ["impression"], containerFactory = "impressionEventConcurrentKafkaListenerContainerFactory")
    fun impressionListener(impressionEvent: ImpressionEvent) {
        println("Received impression message$impressionEvent")
        adEventService?.saveAdEvent(impressionEvent)
    }

    @KafkaListener(topics = ["click"], containerFactory = "clickEventConcurrentKafkaListenerContainerFactory")
    fun clickListener(clickEvent: ClickEvent) {
        println("Received click message:$clickEvent")
        var adEvent = adEventService?.findAddByRequestId(clickEvent.requestId)
        adEvent?.clickTime = clickEvent.requestTime
        adEventService?.updateAdEvent(adEvent)
    }
}