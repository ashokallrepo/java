public class LambdaExpSimple {
    int x = 10;
    public void f2(){
        int y = 20;
        IEmp iObj = () -> {
            System.out.println(x);
            System.out.println(y);
            x = 11; // this is possible because this is not a local variable.
           // y = 21; // this is not possible as local variable of lambda expression is always becomes final by default.
        };

        iObj.f1();
    }

    public static void main(String[] args) {
        LambdaExpSimple sObj = new LambdaExpSimple();
        sObj.f2();
    }

}

interface IEmp
{
    public void f1();
}

