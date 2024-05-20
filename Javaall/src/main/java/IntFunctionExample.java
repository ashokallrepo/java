import java.util.function.IntFunction;
public class IntFunctionExample {
    public static void main(String args[]){
        IntFunction<Double> intF = i -> i * 10.5;
        System.out.println(intF.apply(2));
    }
}
