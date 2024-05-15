public class DefaultMethodImp implements AbcI{
    public static void main(String args[]){
        System.out.println("Main Method");
    }
}

interface AbcI
{
    default void fun(){
        System.out.println("Default Method !!");
    }
}
