package com.mobilestudio.developer.features.home.presentation.view.adapter.viewholder

import android.view.View
import com.mobilestudio.developer.core.adapter.BaseViewHolder
import com.mobilestudio.developer.features.theme.presentation.model.ThemeModel
import kotlinx.android.synthetic.main.theme_item_list.view.*

class ThemeViewHolder(container: View) : BaseViewHolder<ThemeModel>(container) {

    private val titleTextView = container.titleTextView
    private val progressTextView = container.progressTextView

    override fun bind(item: ThemeModel) {
        super.bind(item)

        with(item) {
            titleTextView.text = title
            progressTextView.text = "0 / ${this.topics?.size ?: 0}"
        }
    }

}