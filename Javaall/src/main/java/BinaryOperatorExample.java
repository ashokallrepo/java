import java.util.function.BinaryOperator;
public class BinaryOperatorExample {
    public static void main(String args[]){
        BinaryOperator<Person> bo = (brother, sister) -> brother.age > sister.age ? brother : sister;
        Person brother = new Person(35);
        Person sister = new Person(30);
        Person elder = bo.apply(brother,sister);
        System.out.println("Elder's age is : " + elder.age);
    }
}

class Person{
    int age;
    public Person(int age){
        this.age = age;
    }
}