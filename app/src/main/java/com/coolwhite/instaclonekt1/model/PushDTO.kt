package com.coolwhite.instaclonekt1.model



class PushDTO(
    var to: String? = null,
    var notification: Notification = Notification()
) {
    class Notification (
        var body: String? = null,
        var title: String? = null
    )
}


