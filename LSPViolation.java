class Rectangle {
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

    public int calculateArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // Square must have equal width and height
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height); // Square must have equal width and height
        super.setHeight(height);
    }
}

public class LSPViolation {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle area: " + rectangle.calculateArea()); // 50

        // Substituting subclass (Square) in place of base class (Rectangle)
        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(10);

        // Expected area = 5 * 10 = 50 (as per Rectangle behavior)
        // Actual area = 10 * 10 = 100 (Square changed behavior)
        System.out.println("Square area: " + square.calculateArea()); // Unexpected result!
    }
}
