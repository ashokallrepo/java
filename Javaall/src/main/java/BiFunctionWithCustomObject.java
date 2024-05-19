import java.util.ArrayList;
import java.util.function.BiFunction;

public class BiFunctionWithCustomObject {

    public static void main(String args[]){
        BiFunction<String,Integer, Emp1> bif = (s,i)-> new Emp1(s,i);
        ArrayList<Emp1> ar = new ArrayList<>();
        ar.add(bif.apply("Raj",40));
        ar.add(bif.apply("Sunil",30));
        ar.add(bif.apply("Avik",50));

        System.out.println(ar);
    }
}

class Emp1{
    String name;
    int age;

    public Emp1(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
