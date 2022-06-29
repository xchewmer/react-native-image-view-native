package com.nativeimage.samplecomponent

import android.annotation.SuppressLint
import androidx.constraintlayout.widget.ConstraintLayout
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.nativeimage.R

@SuppressLint("ViewConstructor")
class SampleNativeComponent(context: ThemedReactContext) : ConstraintLayout(context) {
    private var rContext: ThemedReactContext = context
    init {
        inflate(rContext, R.layout.sample_layout, this)
        this.setOnClickListener {
            val surfaceId = UIManagerHelper.getSurfaceId(rContext)
            UIManagerHelper.getEventDispatcherForReactTag(rContext, id)
                    ?.dispatchEvent(SampleNativeComponentEvent(surfaceId, id))
        }
    }
}
