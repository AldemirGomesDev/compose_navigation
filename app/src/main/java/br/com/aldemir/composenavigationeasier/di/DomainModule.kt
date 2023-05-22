package br.com.aldemir.composenavigationeasier.di

import br.com.aldemir.composenavigationeasier.navigation.ComposeCustomNavigator
import br.com.aldemir.composenavigationeasier.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideComposeNavigator(navigator: ComposeCustomNavigator): Navigator = navigator
}