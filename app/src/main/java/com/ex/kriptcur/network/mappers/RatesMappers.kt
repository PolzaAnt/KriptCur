package com.ex.kriptcur.network.mappers

import com.ex.kriptcur.network.dto.BitcoinResponse
import com.ex.kriptcur.network.entity.Rates

class RatesMapper {
    fun map(from: BitcoinResponse.Data): Rates {
        return Rates(
            id =  from.id?:0,
            name = from.name.orEmpty(),
            percentChange = from.quote?.uSD?.percentChange1h?:0.0,
            price= from.quote?.uSD?.price?:0.0
        )
    }
}