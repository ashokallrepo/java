import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerFunctionPredicateCustomObject {
    public static void main(String args[]) {
        List<AccEmp1> list = new ArrayList<>();
        list.add(new AccEmp1("Suresh", 30000, 34));
        list.add(new AccEmp1("Anil", 50000, 40));
        list.add(new AccEmp1("Idhant", 80000, 50));
        list.add(new AccEmp1("Raj", 25000, 33));

        Predicate<AccEmp1> pd = o -> o.salary > 40000 && o.age > 40;
        Function<AccEmp1, Double> fu = o -> {
            if (pd.test(o)) {
                return (40.0 / 100.0) * o.salary;
            } else {
                return (30.0 / 100.0) * o.salary;
            }
        };
        Consumer<AccEmp1> con = o -> System.out.println("Bonus of " + o.name + " : " + fu.apply(o));
        for (AccEmp1 ae : list) {
            con.accept(ae);
        }
    }
}

class AccEmp1 {
    double salary;
    int age;

    String name;

    public AccEmp1(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
