package com.example.auth

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize

actual object FirebaseInitializer {
    actual fun init() {
        // no-op
        // FirebaseApp.configure() is already called in AppDelegate
        Firebase.initialize()
    }
}