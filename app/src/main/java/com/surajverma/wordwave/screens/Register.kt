package com.surajverma.wordwave.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.surajverma.wordwave.R
import com.surajverma.wordwave.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navHostController: NavHostController){

    var name by remember{
        mutableStateOf("")
    }

    var userName by remember{
        mutableStateOf("")
    }

    var bio by remember{
        mutableStateOf("")
    }

    var email by remember{
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Text(text = "Create Account" ,style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                letterSpacing = 2.sp,
                color = Color.Black
            ))

            Box(modifier = Modifier.height(30.dp))

            Image(painter = painterResource(id = R.drawable.profile_icon), contentDescription = "imagePicker",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .clickable {


                    },
                contentScale = ContentScale.Crop)


            OutlinedTextField(value = name,
                onValueChange = {name=it},
                label = { Text(text = "Name")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedTextColor = Color.Black,
                    disabledTextColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedLabelColor = Color.Black
                ))

            Box(modifier = Modifier.height(5.dp))

            OutlinedTextField(value = userName,
                onValueChange = {userName=it},
                label = { Text(text = "Username")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedTextColor = Color.Black,
                    disabledTextColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedLabelColor = Color.Black
                ))

            Box(modifier = Modifier.height(5.dp))

            OutlinedTextField(value = bio,
                onValueChange = {bio=it},
                label = { Text(text = "Bio")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedTextColor = Color.Black,
                    disabledTextColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedLabelColor = Color.Black
                ))

            Box(modifier = Modifier.height(5.dp))

            OutlinedTextField(value = email,
                onValueChange = {email=it},
                label = { Text(text = "Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedTextColor = Color.Black,
                    disabledTextColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedLabelColor = Color.Black
                ))

            Box(modifier = Modifier.height(5.dp))

            OutlinedTextField(value = password,
                onValueChange = {password=it},
                label = { Text(text = "Password")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedTextColor = Color.Black,
                    disabledTextColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    focusedLabelColor = Color.Black
                ))

            Box(modifier = Modifier.height(30.dp))


            ElevatedButton(onClick = {

            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Create Account",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )

            }

            Box(modifier = Modifier.height(30.dp))

            TextButton(onClick = {

                navHostController.navigate(Routes.Login.routes){
                    popUpTo(Routes.Register.routes){
                        inclusive=true
                    }
                    launchSingleTop=true
                }

            }) {
                Text(text = "Already Registered ? Login here",
                    style = TextStyle(fontSize = 15.sp))
            }
        }

    }



}

@Preview(showBackground = true)
@Composable
fun RegisterView() {
    Register(navHostController = rememberNavController())
}