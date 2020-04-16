package me.cgrs.dvdlogo
import androidx.preference.PreferenceManager
import processing.android.PWallpaper
import processing.core.PApplet

class WallpaperService : PWallpaper() {

    override fun createSketch(): PApplet {
        val speed = PreferenceManager.getDefaultSharedPreferences(this).getInt("speed", 3).toFloat()
        return Sketch(speed)
    }


}
