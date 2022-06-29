package com.nativeimage.samplecomponent

import android.widget.ImageView
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewProps
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.annotations.ReactPropGroup
import com.nativeimage.R

class SampleNativeComponentViewManager : SimpleViewManager<SampleNativeComponent>() {
  private var propWidth: Int? = null
  private var propHeight: Int? = null
  private var propScale: Int? = null
  var imageView: ImageView? = null

  override fun getName(): String {
    return "SampleComponent"
  }

  override fun createViewInstance(reactContext: ThemedReactContext): SampleNativeComponent {
    imageView = ImageView(reactContext)
    imageView!!.setImageResource(R.drawable.bootsplash)
    imageView!!.scaleType = ImageView.ScaleType.CENTER_CROP

    val obj = SampleNativeComponent(reactContext)
    obj.addView(imageView)
    return obj
  }

  @ReactPropGroup(names = ["width", "height", "scale"], customType = "Style")
  fun setMyColor(view: SampleNativeComponent, index: Int, value: Int) {
    if (index == 0) propWidth = value
    if (index == 1) propHeight = value
    if (index == 2) propScale = value
  }

  @ReactProp(name = ViewProps.RESIZE_MODE)
  fun setResizeMode(view: SampleNativeComponent, resizeMode: String?) {
    imageView!!.scaleType = ImageView.ScaleType.FIT_CENTER
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
    return MapBuilder.of("onUpdate", MapBuilder.of("registrationName", "onUpdate"))
  }
}
