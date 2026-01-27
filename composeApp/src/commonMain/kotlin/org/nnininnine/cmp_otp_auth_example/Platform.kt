package org.nnininnine.cmp_otp_auth_example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform