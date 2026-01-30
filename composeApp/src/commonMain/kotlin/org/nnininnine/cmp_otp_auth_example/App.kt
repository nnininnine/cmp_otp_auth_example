package org.nnininnine.cmp_otp_auth_example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cmp_otp_auth_example.composeapp.generated.resources.Res
import cmp_otp_auth_example.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.nnininnine.cmp_otp_auth_example.di.AuthModule

@Composable
@Preview
fun App() {
    MaterialTheme {
        val coroutineScope = rememberCoroutineScope()
        var showContent by remember { mutableStateOf(false) }
        val emailState = rememberTextFieldState()
        val pwdState = rememberTextFieldState()

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }

            TextField(
                state = emailState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 8.dp),
                label = { Text("Email") })
            TextField(
                state = pwdState,
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Password") })

            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = {
                    coroutineScope.launch {
                        try {
                            val email = emailState.text.toString()
                            val pwd = pwdState.text.toString()
                            print("login using: $email, $pwd")
                            val authRepository = AuthModule.provideAuthRepository()
                            authRepository.signIn(email, pwd)
                        } catch (e: Exception) {
                            println(e)
                        }
                    }
                }) {
                Text("Login")
            }
        }
    }
}