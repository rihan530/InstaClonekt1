package com.coolwhite.instaclonekt1.navigation

import com.coolwhite.instaclonekt1.model.PushDTO
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.IOException

class FcmPush {
    var JSON = "application/json; charset=utf-8".toMediaTypeOrNull()
    var url = "https://fcm.googleapis.com/fcm/send"
    var serverKey = "AAAACBGNppY:APA91bGKcMyVQfSbpXR0IDK9jE8Ck3OgJE54lh4bGAmiqXYRlXFuSVOv0Q-4vVQ1ihvTSpx0qW5aurdpGBSAvrw1q1VXe8vvAWGXLPVKy6K7Pi164fmFE9PsWWhEyA5wg8QLNhl29852"
    var gson : Gson? = null
    var okHttpClient : OkHttpClient? = null

    companion object{
        var instance = FcmPush()
    }

    init {
        gson = Gson()
        okHttpClient = OkHttpClient()
    }

    fun sendMessage(destinationUid : String, title : String, message : String) {
        FirebaseFirestore.getInstance().collection("pushtokens").document(destinationUid).get().addOnCompleteListener {
                task ->
            if (task.isSuccessful) {
                var token = task?.result?.get("pushtoken").toString()

                var pushDTO = PushDTO()
                pushDTO.to = token
                pushDTO.notification.title = title
                pushDTO.notification.body = message

                var body = RequestBody.create(JSON, gson?.toJson(pushDTO)!!)
                var request = Request.Builder().addHeader("Content-Type", "application/json").addHeader("Authorization", "key="+serverKey).url(url).post(body).build()

                okHttpClient?.newCall(request)?.enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call, response: Response) {
                        println(response?.body?.string())
                    }

                })
            }
        }
    }
}

