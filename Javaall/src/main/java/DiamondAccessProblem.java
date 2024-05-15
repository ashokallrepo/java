
interface Int1{
    default void fun(){
        System.out.println("Interface 1");
    }
}

interface Int2{
    default void fun(){
        System.out.println("Interface 2");
    }
}

public class DiamondAccessProblem implements Int1,Int2{

    @Override
    public void fun() {
        Int1.super.fun();
        Int2.super.fun();
    }
    public static void main(String args[]){
        System.out.println("Main Method");

        DiamondAccessProblem ob = new DiamondAccessProblem();
        ob.fun();
    }
}

