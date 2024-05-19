import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionCustomObject {
    public static void main(String args[]){
        List<AccEmp> list = new ArrayList<>();
        list.add(new AccEmp("Suresh",30000,34));
        list.add(new AccEmp("Anil",50000,40));
        list.add(new AccEmp("Idhant",80000,50));
        list.add(new AccEmp("Raj",25000,33));

        Predicate<AccEmp> pd = o -> o.salary > 40000 && o.age > 40;
        Function<AccEmp, Double> fu = o -> {
            if(pd.test(o)){
                return (40.0 / 100.0) * o.salary;
            }
            else{
                return (30.0 / 100.0) * o.salary;
            }
        };

//        Function<AccEmp, Double> fu = o -> {
//            if(o.salary > 40000 && o.age > 40){
//                return (40.0 / 100.0) * o.salary;
//            }
//            else{
//                return (30.0 / 100.0) * o.salary;
//            }
//        };



        for(AccEmp ae : list){
            System.out.println("Bonus of " + ae.name + " : " + fu.apply(ae));
        }
    }
}


class AccEmp{
    double salary;
    int age;

    String name;
    public AccEmp(String name, double salary, int age){
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
