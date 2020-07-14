package com.mobilestudio.developer.features.overview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.developer.R
import com.mobilestudio.developer.core.adapter.BaseAdapter

class CompetencyAdapter(
    private val listener: (item: CompetencyArea, position: Int) -> Unit
) : BaseAdapter<CompetencyArea>() {
    override fun getLayoutId(position: Int, item: CompetencyArea): Int {
        return R.layout.competency_item_list
    }

    override fun getViewHolder(container: View, viewType: Int): RecyclerView.ViewHolder {
        return CompetencyViewHolder(container).apply {
            setClickListener(listener)
        }
    }
}