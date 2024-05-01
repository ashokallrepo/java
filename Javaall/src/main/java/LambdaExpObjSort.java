import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpObjSort {
    public static void main(String[] args) {
        List<Employee> names = new ArrayList<>();
        names.add(new Employee("John"));
        names.add(new Employee("Alice"));
        names.add(new Employee("Bob"));
        names.add(new Employee("Charlie"));

        // Sorting using a lambda expression
        Collections.sort(names, (s1, s2) -> s1.getName().compareTo(s2.getName()));

        // Printing the sorted list
        System.out.println("Sorted names: " + names);
    }
}

class Employee{
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
