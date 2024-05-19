import java.util.function.Function;
public class FunctionExmaple {
    public static void main(String args[]){
//        Function<Integer, Integer> fu = i -> i + i;
//        System.out.println("Addition: " +fu.apply(10));

        Function<Integer,Double> fu = i -> (50.0 / 100.0) * i;
        System.out.println("Percentage: " + fu.apply(20));

    }
}
