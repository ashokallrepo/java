import java.util.function.BiPredicate;
public class BiPredicateFunctionalInterface {
    public static void main(String args[]){

        BiPredicate<Integer,Integer> bip = (a,b)-> (a*b) > 50;
        System.out.println(bip.test(6,9));
    }
}
