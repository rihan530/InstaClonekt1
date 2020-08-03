package com.coolwhite.instaclonekt1.model

class AlarmDTO {
    var destinationUid : String? = null
    var userId : String? = null
    var uid : String? = null
    var message : String? = null
    var timestamp : Long? = null

    // 좋아요 알림 : 0
    // 댓글 알림 : 1
    // 팔로우 알림 : 2
    var kind : Int? = null
}