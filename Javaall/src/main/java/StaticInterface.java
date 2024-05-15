
interface Int4{
    public static void fun(){
        System.out.println("Interface 4");
    }
}

interface Int5{
    public static void fun(){
        System.out.println("Interface 5");
    }
}

public class StaticInterface {
    public static void main(String args[]){
        Int4.fun();
        Int5.fun();
    }
}
