package ru.gb.lesson_1.dz_oop.exercise_3;

public class MainFigures {
    public static void main(String[] args) {
        Figures square = new Square("red",5d);
        Figures rectangle = new Rectangle("black",4d,10d);
        Figures circle = new Сircle("blue",2.2);

        System.out.println(square.squareFigure());
        System.out.println(rectangle.squareFigure());
        System.out.println(circle.squareFigure());

    }
}

abstract class Figures {
    String color;

    public Figures(String color){
        this.color = color;
    }

    abstract double squareFigure();

}

class Square extends Figures{
    double side;

public Square (String color, double side){
    super(color);
    this.side = side;
    }

    @Override
    double squareFigure() {
        return 4*this.side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "color='" + color + '\'' +
                ", side=" + side +
                '}';
    }
}

class Rectangle extends Figures{
    double side1;
    double side2;

    public Rectangle (String color, double side1, double side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }

    double squareFigure() {
        return 2*side1*side2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color='" + color + '\'' +
                ", side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }
}

class Сircle extends Figures {
    double radius;

    public Сircle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double squareFigure() {
        return 2*3.14*radius*radius;
    }
}