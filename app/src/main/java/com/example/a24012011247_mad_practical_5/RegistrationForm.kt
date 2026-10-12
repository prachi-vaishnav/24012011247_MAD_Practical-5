package com.example.a24012011247_mad_practical_5

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

fun navigatetoregistrationScreen(navController: NavController) {
    navController.navigate("login")
}

@Composable
fun RegisterScreen(context: Context, navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            RegisterUI(navController = navController)
        }
    }
}

@Composable
fun RegisterUI(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F5F8))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "GUNI Logo",
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFECE6F0)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                FormField(
                    label = "Name",
                    textState = name,
                    onTextChange = { name = it },
                    placeholder = "Enter Name"
                )

                FormField(
                    label = "Phone Number",
                    textState = phoneNumber,
                    onTextChange = { phoneNumber = it },
                    isNumber = true,
                    placeholder = "Enter Phone Number"
                )

                FormField(
                    label = "City",
                    textState = city,
                    onTextChange = { city = it },
                    placeholder = "Enter City"
                )

                FormField(
                    label = "Email",
                    textState = email,
                    onTextChange = { email = it },
                    placeholder = "Enter Email"
                )

                FormField(
                    label = "Password",
                    textState = password,
                    onTextChange = { password = it },
                    isPasswordField = true,
                    placeholder = "Enter Password"
                )

                FormField(
                    label = "Confirm Password",
                    textState = confirmPassword,
                    onTextChange = { confirmPassword = it },
                    isPasswordField = true,
                    placeholder = "Enter Confirm Password"
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                    Text(
                        text = "Register",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Do you have an account?",
                fontSize = 14.sp,
                color = Color(0xFF333333)
            )
            Spacer(modifier = Modifier.width(6.dp))
            TextButton(
                onClick = {
                    navigatetoregistrationScreen(navController)
                }
            ) {
                Text(
                    text = "LOGIN",
                    color = Color(0xFFE91E63),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    val navController = rememberNavController()
    RegisterUI(navController)
}