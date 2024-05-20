import java.util.function.ToDoubleBiFunction;
public class ToDoubleBiFunctionExample {
    public static void main(String args[]){
        ToDoubleBiFunction<Integer,Integer> o = (a,b) -> a * b * 10.5;
        System.out.println(o.applyAsDouble(2,3));
    }
}
