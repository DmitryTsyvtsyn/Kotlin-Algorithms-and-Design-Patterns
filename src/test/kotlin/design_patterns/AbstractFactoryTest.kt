package design_patterns

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Test

internal class AbstractFactoryTest {

    @Test
    fun test() {
        val iosFactory = IOSButtonFactory()

        val iosButton = iosFactory.createButton()
        val iosText = iosFactory.createText()

        assertThat(iosButton, instanceOf(IOSButton::class.java))
        assertThat(iosText, instanceOf(IOSText::class.java))

        val androidFactory = AndroidButtonFactory()

        val androidButton = androidFactory.createButton()
        val androidText = androidFactory.createText()

        assertThat(androidButton, instanceOf(AndroidButton::class.java))
        assertThat(androidText, instanceOf(AndroidText::class.java))
    }

}