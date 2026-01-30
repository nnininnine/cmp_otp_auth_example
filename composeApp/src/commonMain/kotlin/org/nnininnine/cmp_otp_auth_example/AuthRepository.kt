package org.nnininnine.cmp_otp_auth_example

import dev.gitlive.firebase.auth.FirebaseAuth

interface AuthRepository {
    suspend fun signIn(email: String, pwd: String)
    suspend fun signOut()
    fun isLoggedIn(): Boolean
}

class FirebaseAuthRepository(
    private val auth: FirebaseAuth
) : AuthRepository {
    override suspend fun signIn(email: String, pwd: String) {
        auth.signInWithEmailAndPassword(email, pwd)
    }

    override suspend fun signOut() {
        auth.signOut()
    }

    override fun isLoggedIn(): Boolean =
        auth.currentUser != null
}