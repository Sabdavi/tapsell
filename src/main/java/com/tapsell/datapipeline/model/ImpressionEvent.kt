package com.tapsell.datapipeline.model

/**
 * a model for saving ImpressionEvent events that come form kafka
 */
data class ImpressionEvent (
        val requestId : String,
        val adId: String,
        val adTitle: String,
        val advertiserCost: Double,
        val appId: String,
        val appTitle: String,
        val impressionTime: Long)