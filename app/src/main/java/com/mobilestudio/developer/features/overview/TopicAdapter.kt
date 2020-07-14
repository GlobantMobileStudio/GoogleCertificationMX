package com.mobilestudio.developer.features.overview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.developer.R
import com.mobilestudio.developer.core.adapter.BaseAdapter

class TopicAdapter(
    private val listener: (item: CompetencyArea.Topic, position: Int) -> Unit
) : BaseAdapter<CompetencyArea.Topic>() {
    override fun getLayoutId(position: Int, item: CompetencyArea.Topic): Int {
        return R.layout.topic_item_list
    }

    override fun getViewHolder(container: View, viewType: Int): RecyclerView.ViewHolder {
        return TopicViewHolder(container).apply {
            setClickListener(listener)
        }
    }

}