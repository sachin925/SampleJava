package src.practice;

class Parent{
    int age;
    String name;
    String address;

    public Parent(){
        this.age = 55;
        this.name = "Ashok";
        this.address = "Beed";
    }
    public void display(){
        System.out.println("Name: "+name +"\nAge: "+age+"\nAddress: "+address);
    }
}

class Child extends Parent{
    int age;
    String name;
    String address;

    public Child(){
        this.age = 19;
        this.name = "Sachin";
        this.address = "Nagpur";
    }
    public void display(){
        System.out.println("Name: "+name +"\nAge: "+age+"\nAddress: "+address);
    }
}

public class MethodOverriding {
    public static void main(String ar[]){
//    Parent obj = new Parent();
//    obj.display();
    Child childObj = new Child();
    childObj.display();
}}
