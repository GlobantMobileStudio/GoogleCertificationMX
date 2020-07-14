package com.mobilestudio.developer.features.overview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobilestudio.developer.R
import kotlinx.android.synthetic.main.activity_topics.*

class TopicsActivity : AppCompatActivity() {

    private val topicAdapter = TopicAdapter { item, _ ->
        val intent = Intent().apply {
            setClassName(this@TopicsActivity, item.className)
        }
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topics)

        val competencyArea: CompetencyArea? = intent.getParcelableExtra(EXTRA_TOPICS)

        if (competencyArea?.topics != null) {
            topicAdapter.addAll(competencyArea.topics)
        }

        setupComponents()
    }

    private fun setupComponents() {
        topicsRecyclerView.apply {
            setHasFixedSize(true)
            adapter = topicAdapter
        }
    }

}
