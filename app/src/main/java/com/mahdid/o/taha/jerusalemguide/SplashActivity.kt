package com.mahdid.o.taha.jerusalemguide

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.JsonObjectRequest
import com.mahdid.o.taha.jerusalemguide.DBHelper.DBHelper
import com.mahdid.o.taha.jerusalemguide.introSlider.IntroSliderActivity
import kotlin.properties.Delegates
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*
import org.json.JSONArray

class SplashActivity : AppCompatActivity() {

    lateinit var dbHelper: DBHelper
    var oldSize by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        dbHelper = DBHelper(this)
        oldSize = dbHelper.get_news().size
        Handler(Looper.getMainLooper()).postDelayed({
            getNews()
            startActivity(Intent(this@SplashActivity, IntroSliderActivity::class.java))
            finish()
        }, 7000)
    }

    fun getNews(){
        val url =
            "https://newsapi.org/v2/everything?q=القدس&sortBy=date&apiKey=cc836b680e57439da2082777518dd196&language=ar"
        val jsonObjectRequest = object : JsonObjectRequest(
            Method.GET, url, null,
            { response ->
                val articles = response.getJSONArray("articles")
                for (x in 0 until articles.length()) {
                    val title = articles.getJSONObject(x).getString("title")
                    val publishedAt = articles.getJSONObject(x).getString("publishedAt")
                    val description = articles.getJSONObject(x).getString("description")
                    val urlToImage = articles.getJSONObject(x).getString("urlToImage")
                    val src_url = articles.getJSONObject(x).getString("url")

                    Thread {
                        Handler(Looper.getMainLooper()).postDelayed({
                            dbHelper.add_news(title, publishedAt, description, urlToImage, src_url)
                            if (articles.length() <= oldSize) {
                                dbHelper.update_news(title, publishedAt, description, urlToImage, src_url)
                            }
                        }, 7000)
                    }.start()
                }
            },
            {
                Log.e("mdot", it.toString())
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"] = "Mozilla/5.0"
                headers["Accept-Language"] = "ar"
                return headers
            }
        }
        RequestsSingelton.getInstant()!!.addToRequestQueue(jsonObjectRequest)
    }
}
