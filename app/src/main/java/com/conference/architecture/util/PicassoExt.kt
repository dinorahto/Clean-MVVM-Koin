package com.conference.architecture.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Dinorah Tovar on 3/20/19.
 */

fun ImageView.setImage (imageUrl: String?) {
    Picasso.get().load(imageUrl).into(this)
}
