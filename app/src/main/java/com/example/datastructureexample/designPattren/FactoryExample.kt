package com.example.datastructureexample.designPattren

import android.util.Log


interface Notification {
    fun notifyUser()
}


class SmsNotification : Notification {
    override fun notifyUser() {
        println("notifyUser: sms notification")
    }
}

class EmailNotification : Notification {
    override fun notifyUser() {
        println("notifyUser: email notification")
    }

}

class PushNotification : Notification {
    override fun notifyUser() {
        println("notifyUser: push notification")
    }
}


class NotificationFactory {

    fun createNotification(type: String): Notification {
        return when (type) {
            "sms" -> SmsNotification()
            "email" -> EmailNotification()
            "push" -> PushNotification()
            else -> throw IllegalArgumentException("Unknown notification type")
        }
    }
}



fun main(){

    val smsNotification = NotificationFactory().createNotification("sms")
    smsNotification.notifyUser()

    val emailNotification = NotificationFactory().createNotification("email")
    emailNotification.notifyUser()


}