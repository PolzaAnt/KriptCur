package com.ex.kriptcur.network.dto

import com.google.gson.annotations.SerializedName

data class BitcoinResponse(
    @SerializedName("data")
    var data: List<Data>? = null,
    @SerializedName("status")
    var status: Status? = null
) {
    data class Data(
        @SerializedName("circulating_supply")
        var circulatingSupply: Double? = null,
        @SerializedName("cmc_rank")
        var cmcRank: Int? = null,
        @SerializedName("date_added")
        var dateAdded: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("last_updated")
        var lastUpdated: String? = null,
        @SerializedName("max_supply")
        var maxSupply: Double? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("num_market_pairs")
        var numMarketPairs: Int? = null,
        @SerializedName("platform")
        var platform: Any? = null,
        @SerializedName("quote")
        var quote: Quote? = null,
        @SerializedName("slug")
        var slug: String? = null,
        @SerializedName("symbol")
        var symbol: String? = null,
        @SerializedName("tags")
        var tags: List<String?>? = null,
        @SerializedName("total_supply")
        var totalSupply: Double? = null
    ) {
        data class Quote(
            @SerializedName("USD")
            var uSD: USD? = null
        ) {
            data class USD(
                @SerializedName("last_updated")
                var lastUpdated: String? = null,
                @SerializedName("market_cap")
                var marketCap: Double? = null,
                @SerializedName("percent_change_1h")
                var percentChange1h: Double? = null,
                @SerializedName("percent_change_24h")
                var percentChange24h: Double? = null,
                @SerializedName("percent_change_7d")
                var percentChange7d: Double? = null,
                @SerializedName("price")
                var price: Double? = null,
                @SerializedName("volume_24h")
                var volume24h: Double? = null
            )
        }
    }

    data class Status(
        @SerializedName("credit_count")
        var creditCount: Int? = null,
        @SerializedName("elapsed")
        var elapsed: Int? = null,
        @SerializedName("error_code")
        var errorCode: Int? = null,
        @SerializedName("error_message")
        var errorMessage: Any? = null,
        @SerializedName("notice")
        var notice: Any? = null,
        @SerializedName("timestamp")
        var timestamp: String? = null,
        @SerializedName("total_count")
        var totalCount: Int? = null
    )
}