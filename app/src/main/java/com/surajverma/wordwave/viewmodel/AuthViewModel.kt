package com.surajverma.wordwave.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.storage
import com.surajverma.wordwave.model.userModel
import com.surajverma.wordwave.utils.SharefPref
import java.util.UUID

class AuthViewModel: ViewModel(){

    val auth=FirebaseAuth.getInstance()
    val db=FirebaseDatabase.getInstance()
    val userRef=db.getReference("users")
    private val storageRef= Firebase.storage.reference
    private val imageRef= storageRef.child("users/{${UUID.randomUUID()}.jpg}")

    val _firebaseUser= MutableLiveData<FirebaseUser>()
    val firebaseUser: LiveData<FirebaseUser> = _firebaseUser

    val _error= MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        _firebaseUser.value=auth.currentUser
    }

    fun login(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    _firebaseUser.postValue(auth.currentUser)
                }
                else{
                    _error.postValue("Something went wrong")
                }

            }

    }

    fun register(email: String, password: String, name: String, bio: String, username: String, imageUri: Uri, context: Context){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {

                    if (it.isSuccessful) {
                        _firebaseUser.postValue(auth.currentUser)
//                        Toast.makeText(context, "Registering", Toast.LENGTH_SHORT).show()
                        saveImage(email, password, name, bio, username, imageUri, auth.currentUser?.uid, context)
                    } else {
//                        Toast.makeText(context, "RegistrationError: ${it.exception?.message}", Toast.LENGTH_SHORT).show()
//                        Log.e("RegistrationError", "Error during registration: ${it.exception?.message}")
                        _error.postValue("Something went wrong")
                    }


            }

    }

    private fun saveImage(email: String, password: String, name: String, bio: String, userName: String, imageUri: Uri, uid: String?, context: Context) {
        val uploadTask=imageRef.putFile(imageUri)
        uploadTask.addOnSuccessListener {

            imageRef.downloadUrl.addOnSuccessListener {
                saveData(email, password, name, bio, userName, it.toString(), uid, context)
            }
        }
    }

    private fun saveData(email: String, password: String, name: String, bio: String, userName: String, toString: String, uid: String?, context: Context) {

        val userData=userModel(email, password, name, bio, userName, toString)

        userRef.child(uid!!).setValue(userData)
            .addOnSuccessListener {

                // toString is the imageUrl here
                SharefPref.storeData(name, email, bio, userName, toString, context)

            }

    }

}