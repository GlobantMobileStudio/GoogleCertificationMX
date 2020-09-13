package com.mobilestudio.developer.features.subthemes.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.developer.R
import com.mobilestudio.developer.core.adapter.BaseAdapter
import com.mobilestudio.developer.features.configuration.data.models.SubTheme
import com.mobilestudio.developer.features.subthemes.models.SubThemeViewHolder

class SubThemeAdapter : BaseAdapter<SubTheme>() {

    var listener: ((item: SubTheme, position: Int) -> Unit)? = null

    override fun getLayoutId(position: Int, item: SubTheme): Int {
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