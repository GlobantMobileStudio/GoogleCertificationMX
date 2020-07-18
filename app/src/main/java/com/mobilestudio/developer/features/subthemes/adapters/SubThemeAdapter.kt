package com.mobilestudio.developer.features.subthemes.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.developer.R
import com.mobilestudio.developer.core.adapter.BaseAdapter
import com.mobilestudio.developer.features.home.models.Theme
import com.mobilestudio.developer.features.subthemes.models.SubThemeViewHolder

class SubThemeAdapter : BaseAdapter<Theme.SubTheme>() {

    var listener: ((item: Theme.SubTheme, position: Int) -> Unit)? = null

    override fun getLayoutId(position: Int, item: Theme.SubTheme): Int {
        return R.layout.subtheme_item_list
    }

    override fun getViewHolder(container: View, viewType: Int): RecyclerView.ViewHolder {
        return SubThemeViewHolder(
            container
        )
            .apply {
                listener?.let { setClickListener(it) }
            }
    }

}