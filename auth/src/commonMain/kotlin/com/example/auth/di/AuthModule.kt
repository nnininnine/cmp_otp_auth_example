package com.example.auth.di

import com.example.auth.AuthRepository
import com.example.auth.FirebaseAuthRepository
import com.example.auth.FirebaseInitializer
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth

object AuthModule {
    fun provideAuthRepository(): AuthRepository {
        FirebaseInitializer.init()
        return FirebaseAuthRepository(Firebase.auth)
    }
}