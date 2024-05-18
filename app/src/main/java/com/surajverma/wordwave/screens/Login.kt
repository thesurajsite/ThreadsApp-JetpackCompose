package com.surajverma.wordwave.screens

import android.view.Gravity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Login(){

    var email by remember{
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Login" ,style = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            letterSpacing = 2.sp
        ))

        Box(modifier = Modifier.height(30.dp))

        OutlinedTextField(value = email,
            onValueChange = {email=it},
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth())

        Box(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password,
            onValueChange = {password=it},
            label = { Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            modifier = Modifier.fillMaxWidth())

        Box(modifier = Modifier.height(30.dp))


        ElevatedButton(onClick = {


        },
            modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
            
        }

        Box(modifier = Modifier.height(30.dp))

        TextButton(onClick = {

        }) {
            Text(text = "New user ? Register here",
                style = TextStyle(fontSize = 15.sp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginView(){
    Login()
}