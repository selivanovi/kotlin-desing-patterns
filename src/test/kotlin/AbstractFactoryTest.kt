import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AbstractFactoryTest {

    @Test
    fun `Abstract Factory`() {
        val plantFactory = PlantFactory.createFactory<OrangePlant>()
        val plant = plantFactory.makePlant()
        println("Created plant: $plant")

        assertEquals(OrangePlant::class, plant::class)
    }
}