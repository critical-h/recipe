package com.sist.kotlinfinalproject

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_news.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        findBtn.setOnClickListener {
            var fd:String=editText2.text.toString()
            if(fd.length<1)
            {
                Toast.makeText(this,"검색어 입력",Toast.LENGTH_SHORT)
            }
            else
            {
                NewsTask().execute(fd)
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId)
        {
            R.id.home_menu -> {
                var intent= Intent(this,HomeActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.recipe_menu -> {
                var intent= Intent(this,RecipeActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.chef_menu ->{
                var intent= Intent(this,ChefActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.rank_menu ->{
                var intent= Intent(this,RankActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.news_menu ->{
                var intent= Intent(this,NewsActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.recommand_menu -> {
                var intent= Intent(this,RecommandActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    inner class NewsTask:AsyncTask<String,String,String>(){
        override fun doInBackground(vararg params: String?): String {
            var fd=params[0]
            var url="http://211.238.142.209:3355/news_data?fd=${fd}"
            var obj=URL(url)
            with(obj.openConnection() as HttpURLConnection){
                requestMethod="GET"
                println("responseCode=${responseCode}")
                /*
                     responseCode
                     200 404 500
                 */
                // 정상 수행
                if(responseCode==200)
                {
                    BufferedReader(InputStreamReader(inputStream)).use{
                        var response=it.readText()
                        println("response=${response}")
                        return response
                    }
                }
            }
            return ""
        }

        override fun onPostExecute(result: String?) {

            println("결과:${result}")
            val gson = GsonBuilder().setPrettyPrinting().create()
            // ArrayList<Movie> arr=new List<Movie>
            // String s=new Object()
            var newsList: List<NewsData> = gson.fromJson(result,
                object : TypeToken<List<NewsData>>() {}.type)


            //println(newsList)
            // 데이터 전송
            var listView:ListView=findViewById(R.id.listView)
            listView.adapter=NewsAdapter(this@NewsActivity,newsList)
            // ListView , RecylcerView => Adapter
           // var textView:TextView=findViewById(R.id.textView8)
           /* button.setOnClickListener {
                //var site:String=textView8.text.toString()
                Toast.makeText(this@NewsActivity,"aaa",Toast.LENGTH_SHORT)
            }*/
            super.onPostExecute(result)
        }
    }
}
data class NewsData(var title:String,var link:String,var description: String,var author:String)
