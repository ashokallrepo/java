import java.util.function.ObjIntConsumer;
public class ObjIntConsumerExample {
    public static void main(String args[]){
        ObjIntConsumer<Double> o = (i,d) -> System.out.println(i*d);
        o.accept(10.5,5);
    }
}
