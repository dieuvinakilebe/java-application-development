package ru.student.lab2.patterns.factory;

public final class ShapeFactory {
    private ShapeFactory() {
    }

    public static Shape create(ShapeType type, double... params) {
        if (type == null) {
            throw new IllegalArgumentException("Shape type must not be null");
        }

        return switch (type) {
            case CIRCLE -> createCircle(params);
            case RECTANGLE -> createRectangle(params);
            case TRIANGLE -> createTriangle(params);
        };
    }

    private static Shape createCircle(double[] params) {
        checkParamCount(params, 1, "Circle requires radius");
        return new Circle(params[0]);
    }

    private static Shape createRectangle(double[] params) {
        checkParamCount(params, 2, "Rectangle requires width and height");
        return new Rectangle(params[0], params[1]);
    }

    private static Shape createTriangle(double[] params) {
        checkParamCount(params, 2, "Triangle requires base and height");
        return new Triangle(params[0], params[1]);
    }

    private static void checkParamCount(double[] params, int expected, String message) {
        if (params == null || params.length != expected) {
            throw new IllegalArgumentException(message);
        }
    }
}
