package design_patterns

/**
 *
 * An abstract factory is a generative design pattern that allows
 *
 * you to create families of related objects without being tied to
 *
 * the specific classes of objects you create.
 *
 */

interface Button {
    fun draw() {}
}

class AndroidButton : Button
class IOSButton : Button

interface Text {
    fun draw() {}
}

class AndroidText : Text
class IOSText : Text

interface ButtonFactory {
    fun createButton() : Button
    fun createText() : Text
}

class AndroidButtonFactory : ButtonFactory {
    override fun createButton() : Button = AndroidButton()
    override fun createText(): Text = AndroidText()
}

class IOSButtonFactory : ButtonFactory {
    override fun createButton() : Button = IOSButton()
    override fun createText(): Text = IOSText()
}
