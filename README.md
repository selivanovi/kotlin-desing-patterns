# Kotlin design patterns

This repository contains a collection of design patterns implemented in Kotlin programming language. Design patterns are
reusable solutions to common software design problems that have been identified and refined over time. They provide a
way to solve common problems and improve the overall quality, maintainability, and flexibility of software systems.

## Table contents

- [Creational Patterns](#creational-patterns)
    - [Factory Method](#factory-method)
- [Structural Patterns](#structural-patterns)
- [Behavioral Patterns](#behavioral-patterns)

## Creational Patterns

Creational patterns are design patterns that deal with object creation mechanisms, trying to create objects in a manner
suitable to the situation.

### Factory method

The factory pattern takes out the responsibility of instantiating a object from the class to a Factory class.

````kotlin
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
````

## Structural Patterns

Structural patterns are design patterns that ease the design by identifying a simple way to realize relationships
between entities.

## Behavioral Patterns

Behavioral patterns are design patterns that identify common communication patterns between objects and realize these
patterns.
