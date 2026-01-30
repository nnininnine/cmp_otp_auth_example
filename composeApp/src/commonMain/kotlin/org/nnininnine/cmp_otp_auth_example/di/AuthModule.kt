package org.nnininnine.cmp_otp_auth_example.di

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import org.nnininnine.cmp_otp_auth_example.AuthRepository
import org.nnininnine.cmp_otp_auth_example.FirebaseAuthRepository
import org.nnininnine.cmp_otp_auth_example.FirebaseInitializer

object AuthModule {
    fun provideAuthRepository(): AuthRepository {
        FirebaseInitializer.init()
        return FirebaseAuthRepository(Firebase.auth)
    }
}