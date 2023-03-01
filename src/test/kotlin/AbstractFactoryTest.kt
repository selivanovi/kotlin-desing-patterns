import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

interface Plant

class OrangePlant : Plant

class ApplePlant : Plant

abstract class PlantFactory {

    abstract fun makePlant(): Plant

    companion object {
        inline fun <reified T : Plant> createFactory(): PlantFactory =
            when (T::class) {
                OrangePlant::class -> OrangeFactory()
                ApplePlant::class -> AppleFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

class AppleFactory : PlantFactory() {
    override fun makePlant(): Plant = ApplePlant()
}

class OrangeFactory : PlantFactory() {
    override fun makePlant(): Plant = OrangePlant()
}

class AbstractFactoryTest {

    @Test
    fun `Abstract Factory`() {
        val plantFactory = PlantFactory.createFactory<OrangePlant>()
        val plant = plantFactory.makePlant()

        assertEquals(OrangePlant::class, plant::class)
    }
}