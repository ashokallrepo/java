import java.util.function.ToLongFunction;
public class ToLongFunctionExample {
    public static void main(String args[]){
        ToLongFunction<Integer> tlf = i -> i * 45l;
        System.out.println(tlf.applyAsLong(2));
    }
}
