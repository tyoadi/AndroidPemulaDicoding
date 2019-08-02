package com.sulistyolabs.submisionandroidpemula

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<FilmModel> = mutableListOf()
    private lateinit var filmAdapter: FilmAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        filmAdapter = FilmAdapter(this, items) {
            startActivity<DetailsFilm>("item" to it)
        }

        rv_film.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_film.adapter = filmAdapter

    }

    private fun initData() {
        val name = resources.getStringArray(R.array.film_name)
        val desc = resources.getStringArray(R.array.film_desc)
        val quotes = resources.getStringArray(R.array.film_quotes)
        val img = resources.getStringArray(R.array.film_img)
        items.clear()
        for (i in name.indices) {
            items.add(FilmModel(name[i],desc[i],quotes[i],img[i]))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about -> startActivity<AboutActivity>()
        }
        return super.onOptionsItemSelected(item)
    }
}
