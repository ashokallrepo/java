/*
To resolve default method interfaces multiple inheritence implementation we have to
override the same method and call the Interface method whichever is required.

 */

public class DefaultMethodIntMultipleInhertenceSolution implements Left1,Right1{

    public void f1(){
        Left1.super.f1();
    }

    public static void main(String args[]){
        DefaultMethodIntMultipleInhertenceProblem obj = new DefaultMethodIntMultipleInhertenceProblem();
    }
}

interface Left1
{
    default void f1(){
        System.out.println("Left");
    }
}

interface Right1
{
    default void f1(){
        System.out.println("Right");
    }
}
