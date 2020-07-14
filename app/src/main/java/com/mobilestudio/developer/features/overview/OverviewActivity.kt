package com.mobilestudio.developer.features.overview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.mobilestudio.developer.R
import kotlinx.android.synthetic.main.activity_overview.*


class OverviewActivity : AppCompatActivity() {

    private val competencyAdapter = CompetencyAdapter { item, _ ->
        val intent = Intent(this@OverviewActivity, TopicsActivity::class.java).apply {
            putExtra(EXTRA_TOPICS, item)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview)

        val json = getContent()
        val data = Gson().fromJson(json, LocalConfiguration::class.java)
        competencyAdapter.addAll(data.competencies)

        setupComponents()
    }

    private fun setupComponents() {
        competenciesRecyclerView.apply {
            setHasFixedSize(true)
            adapter = competencyAdapter
        }
    }

    private fun getContent(): String {
        return assets.open("data.json").bufferedReader().use { it.readText() }
    }

}
