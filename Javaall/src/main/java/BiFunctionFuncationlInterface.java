import java.util.function.BiFunction;
public class BiFunctionFuncationlInterface {
    public static void main(String args[]){
        BiFunction<Integer,Double, Double> bif = (i,d) -> (d / 100) * i;
        System.out.println(bif.apply(10,50.0));
    }
}
