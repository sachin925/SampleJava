package src.practice;

public class Audi implements Vehicle{

    @Override
    public void speed() {
        System.out.println("Speed = 140 KMPL");
    }

    @Override
    public void color() {
        System.out.println("Color = Red");
    }

    @Override
    public void engine() {
        System.out.println("Engine Capacity = 2000 CC");
    }

    @Override
    public void price() {
        System.out.println("Price is 20 Lacs");
    }


}
