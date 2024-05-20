import java.util.function.IntBinaryOperator;
public class IntBinaryOperatorExample {
    public static void main(String args[]){
        IntBinaryOperator o = (a,b) -> a * b;
        System.out.println(o.applyAsInt(5,2));
    }
}
