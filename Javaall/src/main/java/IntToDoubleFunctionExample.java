import java.util.function.IntToDoubleFunction;
public class IntToDoubleFunctionExample {
    public static void main(String args[]){
        IntToDoubleFunction ob = i -> i * 10.4;
        System.out.println(ob.applyAsDouble(2));
    }
}
