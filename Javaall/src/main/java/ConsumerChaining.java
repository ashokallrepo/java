import java.util.function.Consumer;

public class ConsumerChaining {
    public static void main(String args[]){
        Consumer<String> c1 = s->System.out.println("c1 " + s);
        Consumer<String> c2 = s->System.out.println("c2 " + s);
        Consumer<String> c3 = s->System.out.println("c3 " + s);
        Consumer<String> c4 = c1.andThen(c2).andThen(c3);

        c4.accept("Java");
    }
}
