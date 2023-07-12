package entities;

public class Rectangle {
    public double widgh;
    public double height;

    public double area(){
        return widgh * height;
    }
    public double perimeter(){
        return 2 * (widgh + height);
    }
    public double diagonal(){
        return Math.sqrt(Math.pow(widgh,2) + Math.pow(height, 2));
    }

    public String toString() {
        return "AREA = " + String.format("%.2f", area()) + "\n" +
                "PERIMETER = " + String.format("%.2f", perimeter()) + "\n" +
                "DIAGONAL = " + String.format("%.2f", diagonal()) + "\n";
    }
}
