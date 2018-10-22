package src.practice;

class Hard{
    Hard(){
        System.out.println("Called Constructor");
    }
    Hard(int i){
        System.out.println("Parameterised Constructor"+i);
    }
    Hard(Character ch){
        System.out.println(ch);
    }
}

public class ConstructorDemo {
    public static void main(String[] args){
        Hard obj = new Hard();
        Hard obj2 = new Hard(10);
        Hard obj3 = new Hard(new Character('S'));
    }
}
