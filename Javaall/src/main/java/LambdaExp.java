/**
 * Java lambda expressions are particularly useful in scenarios where you need to:
 *
 * 1 - Define Inline Behavior: Lambda expressions allow you to define behavior inline at the point where it's needed,
 * which can make your code more readable and concise, especially for short and simple operations.
 *
 * 2 - Pass Behavior as Parameters: If a method expects behavior as a parameter (for example, in sorting methods or event listeners),
 * lambda expressions provide a compact and expressive way to pass that behavior without the need for verbose anonymous inner classes.
 *
 * 3 - Functional Interfaces: Lambda expressions shine when working with functional interfaces, which have a single abstract method.
 * They allow you to create instances of these interfaces more easily and with less boilerplate code.
 *
 * 4 - Stream API: Lambda expressions are extensively used with the Stream API introduced in Java 8.
 * They enable concise and expressive transformations and operations on streams of elements, such as mapping, filtering, and reducing.
 *
 * 5 - Asynchronous Programming: In asynchronous programming, lambda expressions are commonly used with interfaces like
 * Runnable and Callable to define tasks that can be executed concurrently.
 *
 * In essence, use lambda expressions in Java when you want to simplify your code by expressing behavior concisely,
 * especially in situations where you need to pass behavior as a parameter or work with functional interfaces and streams.
 * They are particularly beneficial for improving code readability and reducing boilerplate.
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExp {
    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        names.add("John");
//        names.add("Alice");
//        names.add("Bob");
//        names.add("Charlie");
//
//        // Sorting using a lambda expression
//        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
//
//        // Printing the sorted list
//        System.out.println("Sorted names: " + names);

        AbcInt ab = (a,b) -> System.out.println(a+b);
        ab.f1(10,20);
        ab.f1(40,30);
    }
}

interface AbcInt //this will consider as FI because it has only one abstract method.
{
    public void f1(int a, int b);
}

