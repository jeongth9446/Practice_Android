package com.example.di

import android.content.Context
import com.example.repository.LocalStorage
import com.example.repository.RemoteStorage
import com.example.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideLocalSource(@ApplicationContext context: Context) = LocalStorage(context)

    @Provides
    fun provideRemoteSource(@ApplicationContext context: Context) = RemoteStorage(context)

    @Provides
    fun provideRepository(localStorage: LocalStorage, remoteStorage: RemoteStorage) = Repository(localStorage, remoteStorage)
}