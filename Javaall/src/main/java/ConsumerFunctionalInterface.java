import java.util.function.Consumer;
public class ConsumerFunctionalInterface {
    public static void main(String args[]){
        Consumer<String> con = s->System.out.println("Hello " + s);
        con.accept("Java");
    }
}
