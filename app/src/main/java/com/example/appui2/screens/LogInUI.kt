package com.example.appui2.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LogInUI(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFB3E5FC),
                        Color(0xFFD1C4E9),
                        Color(0xFF7986CB)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//Intro
            Text(
                "A S H",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                color = Color(0xFF37474F)
            )

            Spacer(modifier = Modifier.height(16.dp))
//Username
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                placeholder = {
                    Text("Enter your username", color = Color(0xFF37474F))
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(RoundedCornerShape(12.dp)),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "Person Icon")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF37474F),
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color(0xFF37474F),
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.Black,
                    focusedTextColor = Color(0xFF37474F),
                    unfocusedTextColor = Color(0xFF37474F)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))
//Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = {
                    Text("Enter Password", color = Color(0xFF37474F))
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(RoundedCornerShape(12.dp)),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")
                },
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF37474F),
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color(0xFF37474F),
                    unfocusedLabelColor = Color.DarkGray,
                    cursorColor = Color.Black,
                    focusedTextColor = Color(0xFF37474F),
                    unfocusedTextColor = Color(0xFF37474F)
                )
            )
//LogIn
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    if (username.isNotEmpty() && password.isNotEmpty()) {
                        Toast.makeText(
                            context,
                            "WelCome $username",
                            Toast.LENGTH_LONG
                        ).show()
                        navController.navigate("welcome")
                    } else {
                        Toast.makeText(
                            context,
                            "Please fill all the fields",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .size(50.dp)
            ) {
                Text(
                    "Log In",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}
