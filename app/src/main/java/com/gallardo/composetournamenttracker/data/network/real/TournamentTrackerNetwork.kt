package com.gallardo.composetournamenttracker.data.network

import com.gallardo.composetournamenttracker.BuildConfig
import com.gallardo.composetournamenttracker.BuildConfig.BACKEND_URL
import com.gallardo.composetournamenttracker.data.network.model.*
import retrofit2.Converter.Factory
import retrofit2.Retrofit
import retrofit2.http.Headers
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = BACKEND_URL

private interface TournamentTrackerApi {
    @Headers(
        BuildConfig.API_KEY
    )
    @POST("group/query")
    suspend fun getGroups() : GroupResponse

    @Headers(
        BuildConfig.API_KEY
    )
    @POST("card/query")
    suspend fun getCards() : CardResponse

    @Headers(
        BuildConfig.API_KEY
    )
    @POST("goal/query")
    suspend fun getGoals() : GoalResponse

    @Headers(
        BuildConfig.API_KEY
    )
    @POST("match/query")
    suspend fun getMatches() : MatchResponse

    @Headers(
        BuildConfig.API_KEY
    )
    @POST("squad/query")
    suspend fun getSquads() : SquadResponse

    @Headers(
        BuildConfig.API_KEY
    )
    @POST("stadium/query")
    suspend fun getStadiums() : StadiumResponse

    @Headers(
        BuildConfig.API_KEY
    )
    @POST("team/query")
    suspend fun getTeams() : TeamResponse

}

@Singleton
class TournamentTrackerNetwork @Inject constructor(
    converterFactory: Factory
) : TournamentTrackerNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .addConverterFactory(converterFactory)
        .baseUrl(BASE_URL)
        .build()
        .create(TournamentTrackerApi::class.java)

    override suspend fun getGroups(): GroupResponse {
        return networkApi.getGroups()
    }

    override suspend fun getCards(): CardResponse {
        return networkApi.getCards()
    }

    override suspend fun getGoals(): GoalResponse {
        return networkApi.getGoals()
    }

    override suspend fun getMatches(): MatchResponse {
        return networkApi.getMatches()
    }

    override suspend fun getSquads(): SquadResponse {
        return networkApi.getSquads()
    }

    override suspend fun getStadiums(): StadiumResponse {
        return networkApi.getStadiums()
    }

    override suspend fun getTeams(): TeamResponse {
        return networkApi.getTeams()
    }
}