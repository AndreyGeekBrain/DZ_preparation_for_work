package ru.gb.lesson_1.dz_oop.exercise_2;

/*Оптимизировал из двух интерфейсов сделал один,
так как сематически это все движение автомобиля (одно без другого не бывает)*/
interface Movable {
    void move();
    void stop();
}


/* Ошибка: не было класса Engine
Оптимизировал убрав лишний метод из Car в Engine (запуск двигателя) !*/

class Engine {
    public void start() {
        System.out.println("Engine starting");
    }
}

abstract class Car {
    public Engine engine;
    private String color;
    private String name;

    abstract void open();

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class LightWeightCar extends Car implements Movable {
    @Override
    void open() {
        System.out.println("LightWeightCar is open");
    }
    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }

    @Override
    public void stop() {
        System.out.println("LightWeightCar is stop");
    }
}
class Lorry extends Car implements Movable {

    //Ошибка: Не был реализован абстрактный метод
    void open() {
        System.out.println("Lorry is open");
    }

    public void move(){
        System.out.println("Lorry is moving");
    }
    public void stop(){
        System.out.println("Lorry is stop");
    }
}
