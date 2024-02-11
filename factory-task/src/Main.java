public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        // Create Circle
        Shape circle = factory.createShape("Circle");
        circle.draw();

        // Create Rectangle
        Shape rectangle = factory.createShape("Rectangle");
        rectangle.draw();
    }
}