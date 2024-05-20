import java.util.function.IntPredicate;
public class IntPredicateExample {
    public static void main(String args[]){
        IntPredicate ip = i-> i%10 == 0;
        System.out.println(ip.test(10));
    }
}
