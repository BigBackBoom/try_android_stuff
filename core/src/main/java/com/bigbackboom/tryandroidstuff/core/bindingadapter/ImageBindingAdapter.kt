package com.bigbackboom.tryandroidstuff.core.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bigbackboom.tryandroidstuff.core.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl

object ImageBindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        if (url == null) {
            return
        }
        val glideUrl = GlideUrl(url)
        Glide.with(view.context)
            .load(glideUrl)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_image_24)
            .dontAnimate()
            .optionalCircleCrop()
            .into(view)
    }

}
