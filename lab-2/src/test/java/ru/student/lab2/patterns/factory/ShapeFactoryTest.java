package ru.student.lab2.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeFactoryTest {
    @Test
    void factoryCreatesCircle() {
        Shape shape = ShapeFactory.create(ShapeType.CIRCLE, 2.0);

        assertInstanceOf(Circle.class, shape);
        assertEquals("Circle", shape.name());
        assertEquals(Math.PI * 4.0, shape.area(), 0.0001);
    }

    @Test
    void factoryCreatesRectangle() {
        Shape shape = ShapeFactory.create(ShapeType.RECTANGLE, 3.0, 4.0);

        assertInstanceOf(Rectangle.class, shape);
        assertEquals("Rectangle", shape.name());
        assertEquals(12.0, shape.area(), 0.0001);
    }

    @Test
    void factoryCreatesTriangle() {
        Shape shape = ShapeFactory.create(ShapeType.TRIANGLE, 5.0, 6.0);

        assertInstanceOf(Triangle.class, shape);
        assertEquals("Triangle", shape.name());
        assertEquals(15.0, shape.area(), 0.0001);
    }

    @Test
    void invalidParametersThrowException() {
        assertThrows(IllegalArgumentException.class, () -> ShapeFactory.create(ShapeType.CIRCLE));
        assertThrows(IllegalArgumentException.class, () -> ShapeFactory.create(ShapeType.RECTANGLE, 1.0));
        assertThrows(IllegalArgumentException.class, () -> ShapeFactory.create(null, 1.0));
    }

    @Test
    void negativeSizeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> ShapeFactory.create(ShapeType.CIRCLE, -1.0));
        assertThrows(IllegalArgumentException.class, () -> ShapeFactory.create(ShapeType.TRIANGLE, 3.0, 0.0));
    }
}
