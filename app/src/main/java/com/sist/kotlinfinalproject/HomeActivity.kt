package com.sist.kotlinfinalproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
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
}
