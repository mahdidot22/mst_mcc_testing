package com.mahdid.o.taha.jerusalemguide

import android.app.Application
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class RequestsSingelton : Application() {
    private val TAG = "mdot"
    private var mRequestQueue: RequestQueue? = null

    companion object {
        private var mInstant: RequestsSingelton? = null
        fun getInstant(): RequestsSingelton? {
            return mInstant
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstant = this
    }

    private fun getRequestQueue(): RequestQueue? {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(applicationContext)
        }
        return mRequestQueue
    }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        getRequestQueue()!!.add(request)
    }

    fun <T> addToRequestQueue(request: Request<T>, tag: String?) {
        request.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        getRequestQueue()!!.add(request)
    }

    fun cancelPendingRequests(tag: Any?) {
        if (mRequestQueue != null) {
            mRequestQueue!!.cancelAll(tag)
        }
    }
}
