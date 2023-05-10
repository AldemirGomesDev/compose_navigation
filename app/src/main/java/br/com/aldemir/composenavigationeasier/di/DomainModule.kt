package br.com.aldemir.composenavigationeasier.di

import br.com.aldemir.composenavigationeasier.ComposeCustomNavigator
import br.com.aldemir.composenavigationeasier.Navigator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideComposeNavigator(navigator: ComposeCustomNavigator): Navigator = navigator
}