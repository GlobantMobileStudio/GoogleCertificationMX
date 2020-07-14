package com.mobilestudio.developer.features.overview

import android.view.View
import com.mobilestudio.developer.core.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.topic_item_list.view.*

class TopicViewHolder(container: View) : BaseViewHolder<CompetencyArea.Topic>(container) {

    private val titleTextView = container.titleTextView
    private val contentTextView = container.contentTextView
    private val startButton = container.startButton

    private lateinit var listener: (item: CompetencyArea.Topic, position: Int) -> Unit

    override fun bind(item: CompetencyArea.Topic) {
        super.bind(item)

        with(item) {
            titleTextView.text = title
            contentTextView.text = link
            startButton.setOnClickListener {
                listener(item, adapterPosition)
            }
        }
    }

    override fun setClickListener(listener: (item: CompetencyArea.Topic, position: Int) -> Unit) {
        this.listener = listener
    }
}