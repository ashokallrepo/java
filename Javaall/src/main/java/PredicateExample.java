import java.util.function.Predicate;

public class PredicateExample {
    //Custom function return true or false based on condition.
    public static boolean customTest(Integer t){
        if(t%2 == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        //calling custom function
//        System.out.println(customTest(10));

        //same condition through Predicate Functional Interface. No need to define any custom function.
//        Predicate<Integer> pr = i -> i%10 == 0;
//        System.out.println(pr.test(10));

        //Custom Object to check age through lambda expression and predicate functional interface
        Emp obj = new Emp(30);
        Predicate<Emp> pe = e -> e.age > 40;
        System.out.println(pe.test(new Emp(30)));
    }
}

class Emp{
    int age;
    public Emp(int age){
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}


