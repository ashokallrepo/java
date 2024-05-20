import java.util.function.UnaryOperator;
public class UnaryOperatorExample {
    public static void main(String args[]){
        UnaryOperator<Emp2> uo = e -> {
            e.name = "Hello " + e.name;
            return e;
        };
        Emp2 obj = uo.apply(new Emp2("Java"));
        System.out.println(obj.name);
    }
}

class Emp2{
    String name;
    public Emp2(String name){
        this.name = name;
    }
}
