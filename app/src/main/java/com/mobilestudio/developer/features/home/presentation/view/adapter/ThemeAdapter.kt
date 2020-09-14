package com.mobilestudio.developer.features.home.presentation.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.developer.R
import com.mobilestudio.developer.core.adapter.BaseAdapter
import com.mobilestudio.developer.features.home.presentation.view.adapter.viewholder.ThemeViewHolder
import com.mobilestudio.developer.features.theme.presentation.model.ThemeModel

class ThemeAdapter : BaseAdapter<ThemeModel>() {

    var listener: ((item: ThemeModel, position: Int) -> Unit)? = null

    override fun getLayoutId(position: Int, item: ThemeModel): Int {
        return R.layout.theme_item_list
    }

    override fun getViewHolder(container: View, viewType: Int): RecyclerView.ViewHolder {
        return ThemeViewHolder(
            container
        ).apply {
            listener?.let { setClickListener(it) }
        }
    }

}