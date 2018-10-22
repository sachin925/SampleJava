package src.practice;

public class MethodOverloadingDemo {
    int age;
    String name;
    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public void Display(){
        System.out.println("Name: "+name+"\n"+"Age: "+age);
    }

    public static void main(String args[]){
        MethodOverloadingDemo obj ;
        obj = new MethodOverloadingDemo();
        obj.setAge(26);
        obj.setName("Sachin");
        obj.Display();
    }

}
