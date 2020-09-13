package com.mobilestudio.developer.features.home.presentation.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.developer.R
import com.mobilestudio.developer.core.adapter.BaseAdapter
import com.mobilestudio.developer.features.configuration.data.models.Theme
import com.mobilestudio.developer.features.home.presentation.view.adapter.viewholder.ThemeViewHolder

class ThemeAdapter : BaseAdapter<Theme>() {

    var listener: ((item: Theme, position: Int) -> Unit)? = null

    override fun getLayoutId(position: Int, item: Theme): Int {
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