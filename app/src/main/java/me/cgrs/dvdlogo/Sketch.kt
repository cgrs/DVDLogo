package me.cgrs.dvdlogo

import processing.core.PApplet
import processing.core.PConstants
import processing.core.PImage

class Sketch(var speed: Float) : PApplet() {

    var x = 0f
    var y = 0f
    var dx = 0
    var dy = 0
    lateinit var img: PImage
    var padding = 10

    override fun setup() {
        frameRate(60f)
        img = loadImage("dvdlogo.png")
        img.filter(PConstants.INVERT)
        tint(randomColor())
        x = random(0 + padding.toFloat(), width - img.width - padding.toFloat())
        y = random(0 + padding.toFloat(), height - img.height - padding.toFloat())
        dx = 1
        dy = 1
    }

    override fun draw() {
        background(0)
        x += speed * dx
        y += speed * dy
        bounce()
        image(img, x, y)
    }

    private fun bounce() {
        if (x > width - img.width - padding || x < 0 + padding) {
            dx *= -1
            tint(randomColor())
        }
        if (y > height - img.height - padding || y < 0 + padding) {
            dy *= -1
            tint(randomColor())
        }
    }

    private fun randomColor(): Int {
        val colors = intArrayOf(
            color(255, 0, 0),
            color(255, 127, 0),
            color(255, 255, 0),
            color(0, 255, 0),
            color(0, 255, 255),
            color(0, 0, 255),
            color(255, 0, 255),
            color(127, 0, 255),
            color(255, 255, 255)
        )
        return colors[random(colors.size.toFloat()).toInt()]
    }

    override fun settings() {
        fullScreen()
    }
}
