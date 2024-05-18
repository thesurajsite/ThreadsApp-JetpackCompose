package com.surajverma.wordwave.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.surajverma.wordwave.R
import com.surajverma.wordwave.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun Splash(navHostController: NavHostController){
    Text(text = "Splash Screen")
    
    ConstraintLayout(modifier = Modifier.fillMaxSize()
        .background(Color.White))
    {
        val (image)=createRefs()
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
            modifier = Modifier.constrainAs(image){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.size(70.dp))
    }


    LaunchedEffect(true) {
        delay(2000)
        if(FirebaseAuth.getInstance().currentUser!=null) {
            navHostController.navigate(Routes.BottomNav.routes){
                popUpTo(navHostController.graph.startDestinationId){
                    inclusive=true
                }
                launchSingleTop=true
            }
        }
        else{
            navHostController.navigate(Routes.Login.routes){
                popUpTo(navHostController.graph.startDestinationId){
                    inclusive=true
                }
                launchSingleTop=true
            }
        }
    }

}