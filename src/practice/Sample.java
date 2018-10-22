package src.practice;

public class Sample {
    int var = 10;
    static int stat = 20;

    public static void Const(){
        System.out.println(stat);
    }

    public void setVal(int val){
        int value = val;
        System.out.println(value);
    }

    public static void main(String ... args){
        System.out.println("Hello JAVA");
        Sample obj = new Sample();
        Sample.Const();
        System.out.println(++obj.var);
    }
}
