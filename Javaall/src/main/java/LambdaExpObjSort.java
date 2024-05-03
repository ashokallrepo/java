import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpObjSort {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("John",22));
        emps.add(new Employee("Alice",21));
        emps.add(new Employee("Bob",20));
        emps.add(new Employee("Charlie",24));

        // Sorting using a lambda expression. Using compareTo method of Comparable which is only use for String type
        Collections.sort(emps, (o1, o2) -> o1.name.compareTo(o2.name));

        // Printing the sorted list
        System.out.println("Sorted by names: " + emps);

        // Sorting using a lambda expression. Using compare method of Comparator which is only use for String type
        Collections.sort(emps, (o1, o2) -> o1.age<o2.age ? -1 : o1.age > o2.age ? 1 : 0);

        // Printing the sorted list
        System.out.println("Sorted by ages: " + emps);
    }
}

class Employee{
     String name;
     int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
