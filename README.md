# Kotlin design patterns

This repository contains a collection of design patterns implemented in Kotlin programming language. Design patterns are
reusable solutions to common software design problems that have been identified and refined over time. They provide a
way to solve common problems and improve the overall quality, maintainability, and flexibility of software systems.

## Table contents

- [Creational Patterns](#creational-patterns)
    - [Factory Method](#factory-method)
    - [Abstract Factory](#abstract-factory)
- [Structural Patterns](#structural-patterns)
- [Behavioral Patterns](#behavioral-patterns)

## Creational Patterns

Creational patterns are design patterns that deal with object creation mechanisms, trying to create objects in a manner
suitable to the situation.

### Factory method

The factory pattern takes out the responsibility of instantiating a object from the class to a Factory class.

#### Example

````kotlin
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
````

#### Usage

````kotlin
val circle = CircleFactory.createShape()
val square = SquareFactory.createShape()
````

### Abstract Factory

Creational design pattern that lets you produce families of related objects without specifying their concrete classes.

#### Example

````kotlin
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
````

#### Usage

````kotlin
val winFactory = GUIFactory.createFactory(System.Windows)
val button = winFactory.createButton()
val checkbox = winFactory.creteCheckbox()
````

## Structural Patterns

Structural patterns are design patterns that ease the design by identifying a simple way to realize relationships
between entities.

## Behavioral Patterns

Behavioral patterns are design patterns that identify common communication patterns between objects and realize these
patterns.
