package com.mobilestudio.developer.features.overview

import android.view.View
import com.mobilestudio.developer.core.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.competency_item_list.view.*

class CompetencyViewHolder(container: View): BaseViewHolder<CompetencyArea>(container) {

    private val titleTextView = container.titleTextView
    private val progressTextView = container.progressTextView

    override fun bind(item: CompetencyArea) {
        super.bind(item)

        with(item) {
            titleTextView.text = title
            progressTextView.text = "0 / ${this.topics?.size ?: 0}"
        }
    }
}