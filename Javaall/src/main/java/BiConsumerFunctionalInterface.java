import java.util.function.BiConsumer;

public class BiConsumerFunctionalInterface {
    public static void main(String args[]){
        BiConsumer<Integer,Double> bic = (i,d) -> System.out.println(i+d);
        bic.accept(10,50.8);
    }
}
