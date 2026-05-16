package ru.student.lab2.patterns.factory;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String name() {
        return "Circle";
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
