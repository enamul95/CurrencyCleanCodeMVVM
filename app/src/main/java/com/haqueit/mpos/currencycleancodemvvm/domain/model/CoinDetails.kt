package com.haqueit.mpos.currencycleancodemvvm.domain.model

import com.haqueit.mpos.currencycleancodemvvm.data.remote.dto.TeamMember

data class CoinDetails(

    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
