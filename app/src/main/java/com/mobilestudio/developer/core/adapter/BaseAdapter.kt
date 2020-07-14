package com.mobilestudio.developer.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class BaseAdapter<T : Any> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: MutableList<T> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false),
            viewType)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<T>).bind(data[position])
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    fun addItem(item: T) {
        data.add(item)
        notifyItemInserted(data.size)
    }

    fun addAll(items: List<T>) {
        val previousPosition = data.size
        data.addAll(items)
        notifyItemRangeInserted(previousPosition, items.size)
    }

    fun remove(item: T) {
        val position = data.indexOf(item)
        remove(position)
    }

    fun remove(index: Int) {
        if (index == -1) return

        data.removeAt(index)
        notifyItemRemoved(index)
        notifyDataSetChanged()
    }

    @LayoutRes
    protected abstract fun getLayoutId(position: Int, item: T): Int

    protected abstract fun getViewHolder(container: View, viewType: Int): RecyclerView.ViewHolder
}


/*


var data: MutableList<T> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /**
     * Gets size of data set. If data is empty getItemCount returns 0.
     */
    override fun getItemCount() = data.size

    /**
     * Gets view type based on his layout id
     */
    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, data[position])
    }

    /**
     * Creates new views for adapter
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false),
            viewType)
    }

    /**
     * Replaces the contents of a view
     */
    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<T>).bind(data[position])
    }

    /**
     * Clears the data and notify the change
     */
    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    /**
     * Adds an item to data set
     * @param item item of [T]
     */
    fun addItem(item: T) {
        data.add(item)
        notifyItemInserted(data.size)
    }

    /**
     * Adds or updates an item to data set
     * @param item item of [T]
     */
    fun addOrUpdateItem(item: T) {
        val position = data.indexOf(item)
        if (position == -1) {
            addItem(item)
        } else {
            data[position] = item
            notifyDataSetChanged()
        }
    }

    /**
     * Adds or update an item to data set based on his predicate
     * @param item item of [T]
     * @param predicate criteria of [T] item
     */
    fun addOrUpdateItem(item: T, predicate: (T) -> Boolean) {
        val position = data.indexOfFirst(predicate)
        if (position == -1) {
            addItem(item)
        } else {
            data[position] = item
            notifyDataSetChanged()
        }
    }

    /**
     * Adds a collection of [T] items to data set
     * @param items [T] items collection
     */
    fun addAll(items: List<T>) {
        val previousPosition = data.size
        data.addAll(items)
        notifyItemRangeInserted(previousPosition, items.size)
    }

    /**
     * Removes [T] item from data set
     * @param item of [T] to be removed
     */
    fun remove(item: T) {
        val position = data.indexOf(item)
        remove(position)
    }

    /**
     * Removes [T] item from data set based on his index
     * @param index of data set
     */
    fun remove(index: Int) {
        if (index == -1) return

        data.removeAt(index)
        notifyItemRemoved(index)
        notifyDataSetChanged()
    }



 */