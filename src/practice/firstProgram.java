package src.practice;
public class firstProgram{
    static public void main(String[] args){
        System.out.println(10+20+"Welcome");
        String pali;
        float floatVal =  12.2f;
        int intVal = 30;
        String stringVal = "Sachin";
        pali = String.format( "This is float value %f while the value of integer is %d and at last string is %s", floatVal, intVal, stringVal);
        System.out.println(pali);

//        System.out.println(pali.charAt(18));
        String str1 =  new String();
        System.out.println(pali.compareTo(stringVal));
    }
}