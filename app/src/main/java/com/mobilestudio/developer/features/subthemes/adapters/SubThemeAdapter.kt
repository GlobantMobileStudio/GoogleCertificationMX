package com.mobilestudio.developer.features.subthemes.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.developer.R
import com.mobilestudio.developer.core.adapter.BaseAdapter
import com.mobilestudio.developer.features.subthemes.models.SubThemeViewHolder
import com.mobilestudio.developer.features.theme.presentation.model.SubThemeModel

class SubThemeAdapter : BaseAdapter<SubThemeModel>() {

    var listener: ((item: SubThemeModel, position: Int) -> Unit)? = null

    override fun getLayoutId(position: Int, item: SubThemeModel): Int {
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