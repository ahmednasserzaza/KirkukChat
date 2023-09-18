package com.fighter.kirkukchat.di

import com.fighter.kirkukchat.domain.ChatRepository
import com.fighter.kirkukchat.domain.ChatRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindChatRepository( repository: ChatRepositoryImpl): ChatRepository

}
