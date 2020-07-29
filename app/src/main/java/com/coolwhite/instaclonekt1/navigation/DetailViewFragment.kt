package com.coolwhite.instaclonekt1.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.coolwhite.instaclonekt1.MainActivity
import com.coolwhite.instaclonekt1.R
import com.coolwhite.instaclonekt1.model.ContentDTO
import com.coolwhite.instaclonekt1.model.FollowDTO
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.squareup.okhttp.OkHttpClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailViewFragment : Fragment() {

    var firestore: FirebaseFirestore? = null
    var user: FirebaseAuth? = null
    var fcmPush :FcmPush? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        firestore = FirebaseFirestore.getInstance()
        user = FirebaseAuth.getInstance()
        fcmPush = FcmPush()
        var view = LayoutInflater.from(inflater.context).inflate(R.layout.fragment_detail, container, false)
//        view.detailviewfragment_recyclerview.adapter = DetailRecyclerviewAdapter()
        view.detailviewfragment_recyclerview.layoutManager = LinearLayoutManager(activity)

        return view
    }


}
