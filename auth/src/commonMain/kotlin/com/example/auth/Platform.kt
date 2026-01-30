package com.example.auth

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform