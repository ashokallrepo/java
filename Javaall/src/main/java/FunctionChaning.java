import java.util.function.Function;
public class FunctionChaning {
    public static void main(String args[]){
        Function<Integer,Integer> f1 = i->2*i;
        Function<Integer,Integer> f2 = i->i*i*i;
        System.out.println(f1.andThen(f2).apply(3));
        System.out.println(f1.compose(f2).apply(3));
    }
}
