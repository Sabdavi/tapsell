
package com.tapsell.datapipeline.repository

import com.tapsell.datapipeline.entity.AdEvent
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.*

interface AdEventRepository : CassandraRepository<AdEvent?, UUID?> {
    fun findAdEventByRequestId(id:String) : AdEvent
}
