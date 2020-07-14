package com.mobilestudio.developer.core.adapter

import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView


@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class BaseViewHolder<T : Any>(
    private val container: View
): RecyclerView.ViewHolder(container), Binder<T> {

    protected val context: Context = container.context
    lateinit var item: T

    @Throws(Exception::class)
    override fun bind(item: T) {
        this.item = item
    }

    open fun setClickListener(listener: (item: T, position: Int) -> Unit) {
        container.setOnClickListener {
            listener(item, adapterPosition)
        }
    }

    fun <T : View> findViewById(@IdRes id: Int): T? {
        return container.findViewById(id)
    }
}