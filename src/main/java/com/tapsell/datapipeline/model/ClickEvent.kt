package com.tapsell.datapipeline.model

/**
 * a model for saving click events that come form kafka
 */
data class ClickEvent (
    val requestId: String,
    val requestTime: Long)
