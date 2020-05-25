package com.tapsell.datapipeline.service

import com.tapsell.datapipeline.entity.AdEvent
import com.tapsell.datapipeline.model.ImpressionEvent
import com.tapsell.datapipeline.repository.AdEventRepository
import org.springframework.beans.factory.annotation.Autowired

class AdEventService {
    @Autowired
    var adEventRepository: AdEventRepository? = null

    fun saveAdEvent(impressionEvent: ImpressionEvent) {
        val addEvent = AdEvent(impressionEvent.requestId,
                impressionEvent.adId,
                impressionEvent.adTitle,
                impressionEvent.advertiserCost,
                impressionEvent.appId,
                impressionEvent.appTitle,
                impressionEvent.impressionTime,
                0L)
        adEventRepository?.save<AdEvent>(addEvent)
    }

    fun updateAdEvent(adEvent: AdEvent?) {
        adEventRepository?.save(adEvent)
    }

    fun findAddByRequestId(id:String): AdEvent? {
        return adEventRepository?.findAdEventByRequestId(id)
    }
}
