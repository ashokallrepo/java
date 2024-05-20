import java.util.function.IntConsumer;
public class IntConsumerExample {
    public static void main(String args[]){
        IntConsumer ic = i -> System.out.println("Consume : " + i);
        ic.accept(10);
    }
}
