package com.mobilestudio.developer.features.subthemes.models

import android.view.View
import com.mobilestudio.developer.core.adapter.BaseViewHolder
import com.mobilestudio.developer.features.configuration.data.models.SubTheme
import kotlinx.android.synthetic.main.subtheme_item_list.view.*

class SubThemeViewHolder(container: View) : BaseViewHolder<SubTheme>(container) {

    private val titleTextView = container.titleTextView
    private val contentTextView = container.contentTextView
    private val startButton = container.startButton

    private lateinit var listener: (item: SubTheme, position: Int) -> Unit

    override fun bind(item: SubTheme) {
        super.bind(item)

        with(item) {
            titleTextView.text = title
            contentTextView.text = link
            startButton.setOnClickListener {
                listener(item, adapterPosition)
            }
        }
    }

    override fun setClickListener(listener: (item: SubTheme, position: Int) -> Unit) {
        this.listener = listener
    }

}