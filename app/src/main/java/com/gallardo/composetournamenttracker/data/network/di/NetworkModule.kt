package com.gallardo.composetournamenttracker.data.network.di

import com.gallardo.composetournamenttracker.data.network.JsonAdapters
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter.Factory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesMoshiFactory() : Factory = MoshiConverterFactory.create(Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(JsonAdapters())
        .build())
}