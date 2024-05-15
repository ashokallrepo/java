public class DefaultMethodOverrideImp implements XyzI{
    public static void main(String args[]){
        System.out.println("Main Method");
        XyzI o =new DefaultMethodOverrideImp();
        o.fun();
    }

    public void fun(){
        System.out.println("Overriding Default Method");
    }
}

interface XyzI
{
    default void fun(){
        System.out.println("Default Method !!");
    }
}
