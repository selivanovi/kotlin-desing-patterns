import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

interface Shape {

    val type: String

    fun draw()
}

abstract class ShapeFactory {
    abstract fun createShape(): Shape
}

class CircleFactory : ShapeFactory() {

    private class Circle : Shape {

        override val type: String = "CIRCLE"

        override fun draw() {
            println("Draw circle")
        }
    }

    override fun createShape(): Shape = Circle()
}

class SquareFactory : ShapeFactory() {

    private class Square : Shape {

        override val type: String = "SQUARE"

        override fun draw() {
            println("Draw square")
        }
    }

    override fun createShape(): Shape = Square()
}

class FactoryMethodTest {

    @Test
    fun `Circle Factory`() {
        val circle = CircleFactory().createShape()

        assertEquals("CIRCLE", circle.type)
    }

    @Test
    fun `Square Factory`() {
        val square = SquareFactory().createShape()

        assertEquals("SQUARE", square.type)
    }
}