package com.tapsell.datapipeline.kafka

import com.tapsell.datapipeline.model.ClickEvent
import com.tapsell.datapipeline.model.ImpressionEvent
import java.util.*


/**
 * In this utils class we generate some sample data in order to push in Kafka brockers.
  */
class DataUtils {
    fun generateEmpressionEvent(): List<ImpressionEvent> {
        val impressionEvents: MutableList<ImpressionEvent> = ArrayList()
        /*kafkaProducer.sendImpressionMessage();*/impressionEvents.add(ImpressionEvent("1232", "55", "QuizLand",
                1254.toDouble(), "77", "QuizeLand", 1365L))
        impressionEvents.add(ImpressionEvent("1233", "55", "Amirza",
                1254.toDouble(), "77", "Amirza", 1365L))
        impressionEvents.add(ImpressionEvent("1234", "55", "Clash",
                1254.toDouble(), "77", "Clash", 1365L))
        impressionEvents.add(ImpressionEvent("1235", "55", "CarRide",
                1254.toDouble(), "77", "CarRide", 1365L))
        return impressionEvents
    }

    fun generateClickEvent(): List<ClickEvent> {
        val clickEvents: MutableList<ClickEvent> = ArrayList()
        clickEvents.add(ClickEvent("1232", 1200L))
        clickEvents.add(ClickEvent("1272", 200L))
        clickEvents.add(ClickEvent("1252", 300L))
        clickEvents.add(ClickEvent("1235", 500L))
        return clickEvents
    }
}