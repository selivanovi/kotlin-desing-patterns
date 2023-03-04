import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Draw circle")
    }
}

class Square : Shape {
    override fun draw() {
        println("Draw square")
    }
}

abstract class ShapeFactory {
    abstract fun createShape(): Shape
}

object CircleFactory : ShapeFactory() {
    override fun createShape() = Circle()

}

object SquareFactory : ShapeFactory() {
    override fun createShape() = Square()
}

class FactoryMethodTest {

    @Test
    fun `Circle Factory`() {
        val circle = CircleFactory.createShape()

        assertEquals(Circle::class, circle::class)
    }

    @Test
    fun `Square Factory`() {
        val square = SquareFactory.createShape()

        assertEquals(Square::class, square::class)
    }
}