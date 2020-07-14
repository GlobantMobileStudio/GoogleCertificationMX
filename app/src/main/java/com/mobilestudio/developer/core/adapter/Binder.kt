package com.mobilestudio.developer.core.adapter

internal interface Binder<in T : Any> {
    fun bind(item: T)
}