import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

interface Button

class WinButton : Button
class MacButton : Button

interface Checkbox

class WinCheckbox : Checkbox
class MacCheckbox : Checkbox

enum class System {
    Mac,
    Windows
}

interface GUIFactory {
    fun createButton(): Button
    fun creteCheckbox(): Checkbox

    companion object {
        fun createFactory(os: System) = when (os) {
            System.Mac -> MacFactory()
            System.Windows -> WinFactory()
        }
    }
}

class WinFactory : GUIFactory {
    override fun createButton() = WinButton()
    override fun creteCheckbox() = WinCheckbox()
}

class MacFactory : GUIFactory {
    override fun createButton(): Button = MacButton()
    override fun creteCheckbox(): Checkbox = MacCheckbox()
}


class AbstractFactoryTest {

    @Test
    fun `Abstract Factory`() {
        val winFactory = GUIFactory.createFactory(System.Windows)
        val button = winFactory.createButton()
        val checkbox = winFactory.creteCheckbox()

        assertEquals(WinButton::class, button::class)
        assertEquals(WinCheckbox::class, checkbox::class)
    }
}