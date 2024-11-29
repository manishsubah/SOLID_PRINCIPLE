interface Shape {
    int calculateArea();
}

class Rectangle1 implements Shape {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int calculateArea() {
        return width * height;
    }
}

class Square1 implements Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public int calculateArea() {
        return side * side;
    }
}

public class LSPCorrect {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle1();
        ((Rectangle1) rectangle).setWidth(5);
        ((Rectangle1) rectangle).setHeight(10);
        System.out.println("Rectangle area: " + rectangle.calculateArea()); // 50

        Shape square = new Square1();
        ((Square1) square).setSide(5);
        System.out.println("Square area: " + square.calculateArea()); // 25
    }
}
