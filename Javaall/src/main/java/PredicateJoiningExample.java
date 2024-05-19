import java.util.function.Predicate;

public class PredicateJoiningExample {
    public static void main(String args[]){
        int s[] = {5,4,56,34,22,30};
        Predicate<Integer> p1 = i -> i%2 == 0;
        Predicate<Integer> p2 = i -> i > 10;

        for(Integer i : s){
            if(p1.and(p2).test(i))
                System.out.println("Even and Greater than 10 "+ i);
            if(p1.or(p2).test(i))
                System.out.println("Even or Greater than 10 "+ i);
            if(p1.negate().test(i))
                System.out.println("Not even "+ i);
        }

    }
}
