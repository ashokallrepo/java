
/*
if default method of two interfaces are same name then implementing class will give compiler error.
"unrelated default for f1() from types Left and Right interfaces.
So, in multiple inheritence we cannot implement two interfaces having same default method.

Above issue can be resolved if implemented class overrides the same function within it.
 */
public class DefaultMethodIntMultipleInhertenceProblem implements Left,Right{

    public void f1(){
        Left.super.f1();
    }

    public static void main(String args[]){
        DefaultMethodIntMultipleInhertenceProblem obj = new DefaultMethodIntMultipleInhertenceProblem();
    }
}

interface Left
{
    default void f1(){
        System.out.println("Left");
    }
}

interface Right
{
    default void f1(){
        System.out.println("Right");
    }
}
