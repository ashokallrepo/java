Ref: Youtube for Blog in Google Search Engine- https://www.youtube.com/watch?v=RLYxWOBA_Vw&t=506s
<br/>Ref: Youtube for Durga sir class -- https://www.youtube.com/watch?v=Tm2BpKlv1rU&list=PLd3UqWTnYXOlrKZWFTbgguqNRA_uVyeBl&index=1
<br/>Ref: Youtube for Durga sir class (Streams) -- https://www.youtube.com/watch?v=5duxFiseLRE&t=240s

<h1>Java 1.8 [concise code] </h1>



**new features** – `[REASONS : 1 - to simplify programming, 2 – to utilize functional programming benefits in java, 3 – to enable parallel programming ]`
1. **Lambda Exxpression**
2. **Functional Interfaces**
3. **Default methods in interfaces**
4. **Static method in interfaces**
5. **Predicate** [pre-defined functional interface]
6. **Function** [pre-defined functional interface]
7. **Consumer** [pre-defined functional interface]
8. **Supplier**
9. **Method refrence & Constructor refrence by double colon (::) operator**
10. **Stream API**
11. **Date & Time API** (Joda API & joda.org)
12. **Optional Class**
13. **Nashron Javascript Engine**


**Java version**
* **1.0	major**
* 1.1	minor
* **1.2	major**
* 1.3	minor
* 1.4	minor
* **1.5	major**
* 1.6	minor
* 1.7	minor
* **1.8	major**

# Lambda Expression ---- 
_It is an anonymous function_ 
1. Namless
2. without return type
3. without modifiers

**Syntax and Program to understand :**

//**Example 1**: </br>
//function which will display "Hello"</br>
public void f1()</br>
{</br>
  System.out.println("Hello");</br>
}

//Same above function can be written in Lambda. No function name, no return type, no modifier </br>
~~public~~ ~~void~~ ~~f1~~() </br>
{ </br>
System.out.println("Hello"); </br>
}

//The above function written in Lambda expression </br>
() -> { System.out.println("Hello"); }</br>
() -> System.out.println("Hello"); //curley braces for single line is optional.

//**Example 2**: </br>
//function with input parameters
public void f1(int a, int b)</br>
{</br>
System.out.println(a+b);</br>
}

//the above code in Lambda expression</br>
(int a, int b) -> System.out.println(a+b);</br>

//in the above code we can avoid parameter type as compiler can guess the type automatically. How does compiler gues this, we will come to know later examples.</br>
(a,b) -> System.out.println(a+b);


//Example 3: </br>
//return type and 'return' keyword</br>
public int f1(int a)</br>
{</br>
    return a*a;</br>
}

//the above function in Lambda expression below</br>
(int a) -> { return a*a; } //here we can't remove the braces even if it is a single statement because 'return' keyword cannot be without braces.</br>
(a) -> a * a; //we can write the statement without 'return' keyword also. In that case no brace is required.</br>
a -> a * a; //single input parameter, brackets are optional.

//invalid statment for the above</br>
(int a) -> return a*a; //invalid 'return' without braces</br>
a -> {a * a};//invalid as one statement without return, so cumpolsory no brace.


**To invoke Lambda expression: [<font color='red'>WITHOUT Functional Interface LAMBDA EXPRESSION CANNOT BE POSSIBLE</font>]** 
we have to have **Functional Interface(FI)**. FI is interface which is having SAM (Single Abstract Method). Only one method. </br>
Few inbuild FI are:</br>
1. Runnable        --- run()
2. Comparable      --- compareTo()
3. Comparator      --- compare()
4. ActionListener  --- actionPerformed()
5. Callable        --- call()


**Functional Interface (FI) :** it should contains atleast one SAM (Single Abstract Method) along with zero or one or more 'default'/'static' methods.
</br>Example of FI:
```java
/*
 this annotation denotes that the interface is functional interface. which must have a SAM 
 otherwise it will have compiler error. If annotation is not there then SAM is optional
*/
@FunctionalInterface
interface AbcInt
{
    public void f1(); //SAM
    default void f2(){
    }
    public static void f3(){
    }
}

```
**Parent and Child @FunctionalInterface**
```java
/*
        extended interface also contains SAM automatically when its extends parent interface. so the below example is correct.
 */
@FunctionalInterface
interface AbcInt
{
    public void f1();
}

@FunctionalInterface
interface XyzInt extends AbcInt
{
}
```
**Parent and Child @FunctionalInterface, invalid example**

```java
/*
        extended interface also contains SAM automatically when its extends parent interface. so the below example is correct.
 */
@FunctionalInterface
interface AbcInt
{
    public void f1();
}

@FunctionalInterface
interface XyzInt extends AbcInt
{
    public void f2(); // invalid, as it has already have SAM in parent but it is defining another SAM, which is incorrect.
}
```
**Parent and Child example with @FunctionalInterface and without @FunctionalInterface**

```java
/*
        extended interface also contains SAM automatically when its extends parent interface. so the below example is correct.
 */
@FunctionalInterface
interface AbcInt
{
    public void f1();
}

interface XyzInt extends AbcInt //this is correct as it has not mentioned @FunctionalInterface. So, multiple abstract method can be possible.
{
    public void f2(); 
}

```

**Invoking Lambda expression by FI** 
```java
/*
        This example is showing polymorphisam. Child object assinged runtime to interface and invoked child method.
 */
interface AbcInt //this will consider as FI because it has only one abstract method.
{
    public void f1();
}
class Child implements  AbcInt
{
    public void f1()
    {
        System.out.println("Hello....");
    }
}
class Test
{
    public static void main(String[] args){
        AbcInt ab = new Child();
        ab.f1();
    }
}
```
**Same above example but using Lambda expression. Here Child class is not required at all. This is one of the advantage of Lambda expression**
```java
interface AbcInt //this will consider as FI because it has only one abstract method.
{
    public void f1();
}
class Test
{
    public static void main(String[] args){
        AbcInt ab = () -> System.out.println("Hello..."); //this is the child method same as shown in above example.
        ab.f1();
    }
}
```

**Example to pass parameter. Sample shown in above Example 2:** 
```java
interface AbcInt //this will consider as FI because it has only one abstract method.
{
    public void f1(int a, int b);
}
class Test
{
    public static void main(String[] args){
        AbcInt ab = (a,b) -> System.out.println(a+b); 
        ab.f1(10,20);
    }
}
```

**Example to pass parameter and return value.** 

```java
interface AbcInt //this will consider as FI because it has only one abstract method.
{
    public int f1(int a, int b);
}
class Test
{
    public static void main(String[] args){
        AbcInt ab = (a,b) -> System.out.println(a+b); 
        System.out.println(ab.f1(10,20));
    }
}
```

_NOTE: Lambda expression never generates any .class file. As per the above example it will creates AbcInt.class and Test.class & Test.java files._ 


**Example: Using Runnable interface (FI) without Lambda expression.**

```java
class TestRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=1; i<=3; i++){
            System.out.println(i + " Child Thread: ");
        }
    }
}

class LambdaExpRunnable{
    public static void main(String args[]){
        TestRunnable tr = new TestRunnable();
        Thread th = new Thread(tr);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}
```
**Same above example without extra class. Using Runnable interface (FI) implementing Lambda expression.**

```java
public class LambdaExpRunnable {
    public static void main(String args[]){
        Runnable r = () -> {
            for(int i=1; i<=3; i++){
                System.out.println(i + " Child Thread: ");
            }
        };
        Thread th = new Thread(r);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}
```
**Same above example with Anonymous Class. Anonymous class implements Runnable interface. Anonymous class is more powerfull than Lambda expression.**
```java
public class AnonymusClassWithRunnable {
    public static void main(String args[]){
        Runnable r = new Runnable() {   //anonymous class which does not have class name and implemented Runnable interface
            @Override
            public void run() {
                for(int i=1;i<=3;i++){
                    System.out.println(i + " Child Thread");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();

        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }

    }
}
```
_NOTE: Anonymous class is not same like Lambda expression. Lambda expression can replace Anonymous class when an Interface is having only one Abstract method (i.e. SAM). But, if Interface is having more than one Abstract method then Lambda expression is not applicable instead we can write Anonymous class. Hence Anonymous class is more powerfull than Lambda expression._  


**Example: sorting using Comparator FI without Lambda expression**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpComparator {
    public static void main(String args[]){
        List<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(1);
        al.add(0);
        al.add(3);
        System.out.println("Before Sort: " + al);
        Collections.sort(al,new TestComparator());
        System.out.println("After Sort: " + al);

    }
}

class TestComparator implements  Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1<o2 ? -1 : o1>o2 ? 1 : 0;
    }
}

```

**Example: sorting using Comparator FI with Lambda expression. Not using any extra class**
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpComparator {
    public static void main(String args[]){
        List<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(1);
        al.add(0);
        al.add(3);
        System.out.println("Before Sort: " + al);
        Comparator<Integer> cm = (o1,o2) -> o1<o2 ? -1 : o1>o2 ? 1 : 0;
        Collections.sort(al,cm);
        System.out.println("After Sort: " + al);
    }
}
```

**Example: sorting custom object's age with Comparator class and object's name with Comparable class**
```java
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

        // Sorting using a lambda expression. Using compare method of Comparator which is only use for non String type
        Collections.sort(emps, (o1, o2) -> o1.age<o2.age ? -1 : o1.age > o2.age ? 1 : 0);

        // Printing the sorted list
        System.out.println("Sorted by age: " + emps);
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

```

**Benefits :**
1. 	To enable functional progrmming in java
2. 	Write more readable, maintainable & concise code
3. 	To use APIs very easily and effectively
4. 	To enable parallel processing

**Java lambda expressions are particularly useful in scenarios where you need to:**

* **Define Inline Behavior:** Lambda expressions allow you to define behavior inline at the point where it's needed, which can make your code more readable and concise, especially for short and simple operations.
* **Pass Behavior as Parameters:** If a method expects behavior as a parameter (for example, in sorting methods or event listeners), lambda expressions provide a compact and expressive way to pass that behavior without the need for verbose anonymous inner classes.
* **Functional Interfaces:** Lambda expressions shine when working with functional interfaces, which have a single abstract method. They allow you to create instances of these interfaces more easily and with less boilerplate code.
* **Stream API:** Lambda expressions are extensively used with the Stream API introduced in Java 8. They enable concise and expressive transformations and operations on streams of elements, such as mapping, filtering, and reducing.
* **Asynchronous Programming:** In asynchronous programming, lambda expressions are commonly used with interfaces like Runnable and Callable to define tasks that can be executed concurrently.
  In essence, use lambda expressions in Java when you want to simplify your code by expressing behavior concisely, especially in situations where you need to pass behavior as a parameter or work with functional interfaces and streams. They are particularly beneficial for improving code readability and reducing boilerplate.


**Difference between Anonymus Inner Class and Lambda Expression :**

| Sl.No | Anaonymus Inner Class                                                                                            | Lambda Expression                                                                                                              |
|-------|------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| 1     | It is a class without name                                                                                       | It is a function without name (Anonymus function)                                                                              |
| 2     | can extend abstract and concrete class                                                                           | can extend abstract and concrete class                                                                                         |
| 3     | can implements an interface that contains any number of abstract method                                          | can implement an interface which contains single abstract method (Functional Interface)                                        |
| 4     | Inside Anonymus Inner Class, we can declare instance variable                                                    | Inside Lambda expression we can’t  declare instance variables. Whatever variables declared, are considered as local variables. |
| 5     | can be intantiated                                                                                               | cannot be intantiated                                                                                                          |
| 6     | Inside Anonymus Inner Class, ‘this’ always refers current anonymus Inner class object but not outer class object | Inside Lambda expression, ‘this’ always refers current outer class object, i.e. enclosing class object                         |
| 7     | Anonymus Inner Class is best choice if we want handle multiple methods                                           | Lambda expression is the best choice if we want to handle interface with Single Abstract method (Functional Inteface)          |
| 8     | For the Anonymus Inner Class, at the time of compilation, a seprate class file will be generated                 | For the Lambda expression, at the time of compilation, no seprate class file will be generated                                 |
| 9     | Memory will be allocated on demand whenever, we are  creating object.                                            | Lambda expression will reside in permanent memory of JVM (method Area)                                                         |


**Simple Example** ---<br/>
//value ‘hello’ assinging to s variable.<br/>
`String s = “hello”;`<br/>
//same like above function/procedure assigning to ‘obj’ IntEmp.<br/>
`IntEmp obj = () -> System.out.println(“hello”);`<br/>
//A function or procedure passing as an argument<br/>
`new Thread( () -> {	System.out.println(“Child thread”); } );`

**Advantages of Lambda** ---
1. We can enable functional programing in java
2. We can handle procedure/function just like values.
3. We can pass procedure/function as arguments.
4. Easier to use updated APIs and Libraries like stream api.
5. Enable support for parallel processing. Utilizing cpu processor capabilities like dual core, octa core etc.


# Default Method of an Interface----

#### Without effecting implementation classes if we want to add new method to the interface then we should used Default Method.

java version 1.7 : only public abstract methods.<br/>
java version 1.8 : 1.7v + default methods and static methods<br/>
java version 1.9 : 1.8v + private methods<br/>

Default Methods are also called Virtual Extension Method and Defender Method.<br/>

**Why default method?** <br/>
interface A{ <br/>
    void f1();<br/>
    void f2();<br/>
}<br/>
class C1 implements A<br/>
{<br/>
    void f1(){}<br/>
    void f2(){}<br/>
}<br/>
class C2 implements A<br/>
{<br/>
void f1(){}<br/>
void f2(){}<br/>
}<br/>
class C3 implements A<br/>
{<br/>
void f1(){}<br/>
void f2(){}<br/>
}<br/>

_Now all the above classes C1, C2, C3 has implemented function f1 and f2. Now if we add a new abstract method in interface A then again all the classes need to implement this new method. Which is cumbersome, so default method introduced in java 1.8. This default method is optional for all the classes, means C1, C2, C3 can implement or cannot._
<br/>interface A{ <br/>
void f1();<br/>
void f2();<br/>
default void f3()<br/>
    {<br/>
    }<br/>
}<br/>

**Restrication in default method :** 

**1** - While overriding this method in any class we should not use the keyword 'default' as it is already defined in java for switch case.
To override default method we have to use 'public' keyword instead of 'default'

<br/>class C3 implements A<br/>
{<br/>
    void f1(){}<br/>
    void f2(){}<br/>
    default void f3(){} //this is invalid. compiler error. <br/>
    public void f3(){} //this is valid. no compiler error. <br/>
}<br/>

**2** - We should not define any default method which are a part of Object class like 'hashCode' etc becuase Object class implemented by default by any new class. 

**Difference between Interface with default method and Abstract classes**

| Sl. | Interface with default method                                                                           | Abstract Class                                                                                 |
|-----|---------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| 1   | Interface never talks about state of object                                                             | Abstract class can talk about state of object                                                  |
| 2   | Inside interface we cannot declare constructor                                                          | Inside abstract class we can declare constructor                                               |
| 3   | Inside interface we cannot declare instance and static blocks                                           | Inside abstract class we can declare instance and static blocks                                |
| 4   | Functional interface with default methods can refer Lambda expression                                   | Abstract class can’t refer Lambda expression                                                   |
| 5   | Inside interface we can’t override object class method                                                  | Inside abstract class we can override object class methods.                                    |
| 6   | Inside interface every variable is always public, static, and final we cannot declare instance varibale | Inside Abstract class we can declare instance variables, which are required to the child class |

**NOTE**: Interface with default method is not equals to Abstract class

**Example 1:** Implemented interface without defining "Default Method"
```java
public class DefaultMethodImp implements AbcI{
    public static void main(String args[]){
        System.out.println("Main Method");
    }
}

interface AbcI
{
    default void fun(){
        System.out.println("Default Method !!");
    }
}
```

**Example 2:** Overriding "Default Method"

```java
public class DefaultMethodOverrideImp implements XyzI{
    public static void main(String args[]){
        System.out.println("Main Method");
        XyzI o =new DefaultMethodOverrideImp();
        o.fun();
    }

    public void fun(){
        System.out.println("Overriding Default Method");
    }
}

interface XyzI
{
    default void fun(){
        System.out.println("Default Method !!");
    }
}

```


#### Ambiguity or Diamond Access Problem. Multiple Inheritance is not poissble---
**Example 3:** Below example will throw a compiler error, Class cannot extend multiple classes.
```java

class AbcClz{
    public void fun(){
     System.out.println("Abc Class Method");
    }
}

class XyzClz{
    public void fun(){
        System.out.println("Xyz Class Method");
    }
}

public class DiamondAccessProblem extends XyzClz, AbcClz //this is not possible it will show compiler error. Multiple inheritance not possible
{
    public static void main(String args[]){
        System.out.println("Main Method");
    }

}
```

**Example 3.1:** Multiple inheritance problem can be resolved by default method.

```java
interface Int1{
    default void fun(){
        System.out.println("Interface 1");
    }
}
interface Int2{
    default void fun(){
        System.out.println("Interface 2");
    }
}

public class DiamondAccessProblem implements Int1,Int2{
    @Override
    public void fun() {
        Int1.super.fun();
        Int2.super.fun();
    }
    public static void main(String args[]){
        System.out.println("Main Method");
        DiamondAccessProblem ob = new DiamondAccessProblem();
        ob.fun();
    }
}
```

# Static Method of an Interface----

#### If we want to implement a utility class which will contains only Static Method then instead of defining static method within Class we can define the same in Interface---

**Example 1:** Interface having static method. Using these static method without implementing the Interfaces. 
```java

interface Int4{
    public static void fun(){
        System.out.println("Interface 4");
    }
}

interface Int5{
    public static void fun(){
        System.out.println("Interface 5");
    }
}

public class StaticInterface {
    public static void main(String args[]){
        Int4.fun();
        Int5.fun();
    }
}

```

**Example 2:** Interface having main static method.

```java
public class MainStaticInterface {
    public static void main(String args[]){
        System.out.println("Main method in Interface");
    }
}
```

# Predefined Functional Interfaces----

**_Package: java.util.function_**

Predicate<br/>
Function<br/>
Consumer<br/>
Suppiler<br/>

**Two argument Predefined Functional Interfaces**

BiPredicate<br/>
BiFunction<br/>
BiConsumer<br/>

**Primitive Predefined Functional Interfaces**

IntPredicate<br/>
IntFunction<br/>
IntConsumer<br/>
...

**Child Interfaces of Function and BiFunction Functional Interface**

UnaryOperator<br/>
IntUnaryOperator<br/>
BinaryOperator<br/>
IntBinaryOperator<br/>
...

### Predicate Functional Interface. Predicate mostly used when we check condition and return boolean.

```java
interface Predicate<T>
{
    public boolean test(T t);
}
```
**Example 1:** Condition check with custom function
```java
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
        System.out.println(customTest(10));
    }
}
```
**Example 1.1:** Same above functionality with Lambda Expression and Predicate Functional Interface
```java
import java.util.function.Predicate;
public class PredicateExample {
    public static void main(String args[]){
        Predicate<Integer> pr = i -> i%10 == 0;
        System.out.println(pr.test(10));
        System.out.println(pr.test(15));
    }
}
```
**Example 1.2:** Predicate Functional Interface & Lambda Expression with Custom Object
```java
import java.util.function.Predicate;
public class PredicateExample {
    public static void main(String args[]){
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
```

**Example 1.3:** Predicate Joining with 'and()', 'or()', 'negate()'.
```java
import java.util.function.Predicate;
public class PredicateJoiningExample {
    public static void main(String args[]){
        int s[] = {5,4,56,34,22,30};
        Predicate<Integer> p1 = i -> i%2 == 0;
        Predicate<Integer> p2 = i -> i > 10;

        for(Integer i : s){
            if(p1.and(p2).test(i))
                System.out.println("Even and Greater than 10 "+ i);
            if(p1.or(p2).test(i))
                System.out.println("Even or Greater than 10 "+ i);
            if(p1.negate().test(i))
                System.out.println("Not even "+ i);
        }
    }
}
```

### Function Functional Interface. Function mostly used when we pass a parameter + perform some operation + return value. In short, use this Function when we want to return such data types which is not boolean. For boolean, we will use Predicate.

```java
interface Function<T,R>
{
    public R apply(T t);
}
```

**Example 2:** Function simple example. Input a number and return the addition of the same number
```java
import java.util.function.Function;
public class FunctionExmaple {
    public static void main(String args[]){
        Function<Integer, Integer> fu = i -> i + i;
        System.out.println("Addition: " +fu.apply(10));
    }
}
```
**Example 3:** Function to input integer value and return double
```java
import java.util.function.Function;
public class FunctionExmaple {
    public static void main(String args[]){
        Function<Integer,Double> fu = i -> (50.0 / 100.0) * i;
        System.out.println("Percentage: " + fu.apply(20));
    }
}
```
**Example 4:** Function to input Custom object and calculate bonus based on some condition and return the bonus.
```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public class FunctionCustomObject {
    public static void main(String args[]){
        List<AccEmp> list = new ArrayList<>();
        list.add(new AccEmp("Suresh",30000,34));
        list.add(new AccEmp("Anil",50000,40));
        list.add(new AccEmp("Idhant",80000,50));
        list.add(new AccEmp("Raj",25000,33));

        Function<AccEmp, Double> fu = o -> {
            if(o.salary > 40000 && o.age > 40){
                return (40.0 / 100.0) * o.salary;
            }
            else{
                return (30.0 / 100.0) * o.salary;
            }
        };
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
```
**Example 4.1:** Same above program by using Function & Predicate both.

```java
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
```

### Function chaining, Two functions combined to perform complex operations. 
#### Ex: 'f1.andThen(f2).apply(i)'. First f1 performs operation with i and then return value will be as input to f2 to perform another operation. 
#### Ex: 'f1.compose(f2).apply(i)'. First f2 performs operation with i and then return value will be as input to f1 to perform another operation. 

**Example 5:** Function chaining example showing 'andThen' & 'compose'.
```java
import java.util.function.Function;
public class FunctionChaning {
    public static void main(String args[]){
        Function<Integer,Integer> f1 = i->2*i;
        Function<Integer,Integer> f2 = i->i*i*i;
        System.out.println(f1.andThen(f2).apply(3));
        System.out.println(f1.compose(f2).apply(3));
    }
}
```
<div style="background-color: lightgrey;border: 1px solid green;padding: 5px;">
output:<br/>
216<br/>
54
</div>

### Consumer Functional Interface always takes input and perform operation and does not return anything.
```java
interface Consumer<T>
{
    public void accept(T t);
}
```

**Example 6:** Simple Consumer Functional Interface program.
```java
import java.util.function.Consumer;
public class ConsumerFunctionalInterface {
    public static void main(String args[]){
        Consumer<String> con = s->System.out.println("Hello " + s);
        con.accept("Java");
    }
}
```

**Example 7:** Custom Object with Consumer, Function & Predicate Functional Interfaces.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionCustomObject {
    public static void main(String args[]) {
        List<AccEmp> list = new ArrayList<>();
        list.add(new AccEmp("Suresh", 30000, 34));
        list.add(new AccEmp("Anil", 50000, 40));
        list.add(new AccEmp("Idhant", 80000, 50));
        list.add(new AccEmp("Raj", 25000, 33));
        
        Predicate<AccEmp> pd = o -> o.salary > 40000 && o.age > 40;
        Function<AccEmp, Double> fu = o -> {
            if (pd.test(o)) {
                return (40.0 / 100.0) * o.salary;
            } else {
                return (30.0 / 100.0) * o.salary;
            }
        };
        Consumer<AccEmp> con = o -> System.out.println("Bonus of " + o.name + " : " + fu.apply(o));
        for (AccEmp ae : list) {
            con.accept(ae);
        }
    }
}

class AccEmp {
    double salary;
    int age;
    String name;

    public AccEmp(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
```

#### Consumer chaning with 'andThen' function.

**Example 8:** Simple Consumer chaining eample.
```java
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
```
<div style="background-color: lightgrey;border: 1px solid green;padding: 5px;">
output:<br/>
c1 Java<br/>
c2 Java<br/>
c3 Java<br/>
</div>


### Supplier Functional Interface never takes any input parameters it always returns an Object.
```java
interface Supplier<R>
{
    public R get();
}
```

**Example 9:** Simple Supplier Functional Interface example.
```java
import java.util.Date;
import java.util.function.Supplier;

public class SupplierFunctionalInterface {
    public static void main(String args[]){
        Supplier<Date> sup = ()->new Date();
        System.out.println(sup.get());
    }
}
```

**Example 10:** Generates OTP through Supplier Functional Interface.
```java
import java.util.function.Supplier;
public class SupplierToGeneratesOTP {
    public static void main(String args[]){
        Supplier<String> sup = () ->{
            String otp = "";
            for(int i=1;i<=6;i++){
                otp += (int)(Math.random()*10);
            }
            return otp;
        };
        System.out.println(sup.get());
    }
}
```

### Accept Two input parameters Functional Interfaces.
#### BiPredicate Functional Interfaces. Same like Predicate except it accept two arguments.
```java
interface BiPredicate<T1, T2>
{
    public boolean test(T1 t1, T2 t2);
}
```

**Example 11:** Simple example of BiPredicate.
```java
import java.util.function.BiPredicate;
public class BiPredicateFunctionalInterface {
    public static void main(String args[]){

        BiPredicate<Integer,Integer> bip = (a,b)-> (a*b) > 50;
        System.out.println(bip.test(6,9));
    }
}
```
#### BiFunction Functional Interfaces. Same like Function except it accept two arguments.
```java
interface BiFunction<T,U,R>
{
    public R apply(T t,U u);
}
```

**Example 12:** BiFunction example, it will take an integer and a double as a percentage to calculate percentage of an integer and return the double value.
```java
import java.util.function.BiFunction;
public class BiFunctionFuncationlInterface {
    public static void main(String args[]){
        BiFunction<Integer,Double,Double> bif = (i,d) -> (d / 100) * i;
        System.out.println(bif.apply(10,50.0));
    }
}
```
**Example 13:** BiFunction example to accept string and int as name and age respectively and return custom object.
```java
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
```

#### BiConsumer Functional Interfaces. Same like Consumer except it accept two arguments.

**Example 14:** BiConsumer example, it will take two numbers integer and double and then print the sum.

```java
import java.util.function.BiConsumer;

public class BiConsumerFunctionalInterface {
    public static void main(String args[]){
        BiConsumer<Integer,Double> bic = (i,d) -> System.out.println(i+d);
        bic.accept(10,50.8);
    }
}
```

### Predefined primitive data type Functional Interfaces.
#### Why we need Primitive data type Functional Interfaces? Understand by below examples. 

**Example 15:** Below example showing Predicate Functional Interface taking Integer value to checking even or odd.
```java
import java.util.function.Predicate;
public class PredicateExample {
    public static void main(String args[]){
        Predicate<Integer> pr = i -> i%10 == 0;
        System.out.println(pr.test(10));
    }
}
```
<p>Above example is taking an primitive int as an argument and converting it to wrapper class called Integer and then again it is converting into int primitive type to calculate. 
This process is like: int --> Integer --> int means first autoboxing int to Integer and then auto unboxing from Integer to int. Java will do this 
process everytime whenever we use wrapper class Integer and passing primitive int data type. This will impact performance. So, to overcome this 
perfomance we can use Primitive version of Functional Interfaces.</p> 

#### IntPredicate, DoublePredicate ... Functional Interfaces for Predicate.

**Example 16:** Same above example showing in IntPredicate. This example will not do any autoboxing and auto unboxing.

```java
import java.util.function.IntPredicate;
public class IntPredicateExample {
    public static void main(String args[]){
        IntPredicate ip = i-> i%10 == 0;
        System.out.println(ip.test(10));
    }
}
```

#### IntFunction, ToLongFunction, IntToDoubleFunction, ToDoubleBiFunction ... Functional Interfaces for Function.

**Example 17:** Example of IntFunction. Input will be primitive type but return will be Object.
```java
import java.util.function.IntFunction;
public class IntFunctionExample {
    public static void main(String args[]){
        IntFunction<Double> intF = i -> i * 10.5;
        System.out.println(intF.apply(2));
    }
}
```

**Example 18:** Example of IntToDoubleFunction. Same above example but input and return type both will be primitive type.
```java
import java.util.function.IntToDoubleFunction;
public class IntToDoubleFunctionExample {
    public static void main(String args[]){
        IntToDoubleFunction ob = i -> i * 10.4;
        System.out.println(ob.applyAsDouble(2));
    }
}
```

**Example 19:** Example of ToLongFunction. Input will be an Object but return will be primitive type.
```java
import java.util.function.ToLongFunction;
public class ToLongFunctionExample {
    public static void main(String args[]){
        ToLongFunction<Integer> tlf = i -> i * 45l;
        System.out.println(tlf.applyAsLong(2));
    }
}
```

**Example 20:** Example of ToDoubleBiFunction. Input two Objects and return primitive type.
```java
import java.util.function.ToDoubleBiFunction;
public class ToDoubleBiFunctionExample {
    public static void main(String args[]){
        ToDoubleBiFunction<Integer,Integer> o = (a,b) -> a * b * 10.5;
        System.out.println(o.applyAsDouble(2,3));
    }
}
```

#### IntConsumer, LongConsumer, ObjIntConsumer ... Functional Interfaces for Consumer.

**Example 21** Example of IntConsumer. It will take primitive input and print the same.
```java
import java.util.function.IntConsumer;
public class IntConsumerExample {
    public static void main(String args[]){
        IntConsumer ic = i -> System.out.println("Consume : " + i);
        ic.accept(10);
    }
}
```

**Example 22** Example of ObjIntConsumer. It will take first parameter as Object and second as primitive type. Similar like 'Bi' class.
```java
import java.util.function.ObjIntConsumer;
public class ObjIntConsumerExample {
    public static void main(String args[]){
        ObjIntConsumer<Double> o = (i,d) -> System.out.println(i*d);
        o.accept(10.5,5);
    }
}
```

#### IntSupplier, BooleanSupplier, ... Functional Interfaces for Consumer.

**Example 23** Example of IntSupplier. It will return int primitive type only.
```java
import java.util.function.IntSupplier;
public class IntSupplierExample {
    public static void main(String args[]){
        IntSupplier is = ()-> 10 * 10;
        System.out.println(is.getAsInt());
    }
}
```

**Example 24** Example of BooleanSupplier. It will return boolean primitive type only.
```java
import java.util.function.BooleanSupplier;
public class BooleanSupplierExample {
    public static void main(String args[]){
        BooleanSupplier bs = ()-> 10 > 5;
        System.out.println(bs.getAsBoolean());
    }
}
```

### UnaryOperator Interface, It is a child of Function Interface. If Function Interface is taking input as same type and returning the same type then we should go with UnaryOperator class.

**Example 25** Example of UnaryOperator. It will take same input type and return type.
```java
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
```

#### IntUnaryOperator, DoubleUnaryOperator... . This will be used for primitive type only.

**Example 26** Example of IntUnaryOperator. It will take int primitive type input and returns int primitive type only.
```java
import java.util.function.IntUnaryOperator;
public class IntUnaryOperatorExample {
    public static void main(String args[]){
        IntUnaryOperator o = i -> i * i;
        System.out.println(o.applyAsInt(2));
    }
}
```

### BinaryOperator<T> Interface, It is a child of BiFunction<T,T,T> Interface. Taking two same type argument and returning also same type.

**Example 27** Example of BinaryOperator. It will take input of two same custom object and return same custom object. 
```java
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
```
#### IntBinaryOperator, DoubleBinaryOperator... . This will be used for primitive type only.

**Example 28** Example of IntBinaryOperator. It will take input of two same primitive type and return same primitive type.  
```java
import java.util.function.IntBinaryOperator;
public class IntBinaryOperatorExample {
    public static void main(String args[]){
        IntBinaryOperator o = (a,b) -> a * b;
        System.out.println(o.applyAsInt(5,2));
    }
}
```

# Method and Constructor reference by double colon ("::") operator.

#### Method and constructor references are alternatives to lambda expressions. If a method of a functional interface (FI) has already been implemented, we can reuse the same method as a reference using the double colon (::) operator. This approach enhances code reusability. If the implementation of the method is not available, you can use a lambda expression instead. One limitation is that we must adhere to the argument structure of the functional interface method, although specifying modifiers and return types is optional.

**Example 29** Runnable example showing Lambda expression. 

```java
public class LambdaExpRunnable {
    public static void main(String args[]){
        Runnable r = () -> {
            for(int i=1; i<=3; i++){
                System.out.println(i + " Child Thread: ");
            }
        };
        Thread th = new Thread(r);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}
```
**Example 30** The same example as in Example 29 will be shown using Method Reference. Instead of a Lambda expression, Method Reference will be used. This example will show static reference. 

```java
public class MethodReferenceOfRunnable {
    public static void fun1(){
        for(int i=1; i<=3; i++){
            System.out.println(i + " Child Thread: ");
        }
    }
    public static void main(String args[]){
        Runnable r = MethodReferenceOfRunnable::fun1; //static reference
        Thread th = new Thread(r);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}
```

**Example 31** Similar to Example 30, but showing with Instance reference.

```java
public class MethodReferenceOfRunnableObjectRef {
    public  void fun1(){
        for(int i=1; i<=3; i++){
            System.out.println(i + " Child Thread: ");
        }
    }
    public static void main(String args[]){
        MethodReferenceOfRunnableObjectRef obj = new MethodReferenceOfRunnableObjectRef();
        Runnable r = obj::fun1; //instance reference
        Thread th = new Thread(r);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}
```

**Example 32** Method references follow the argument structure of the Functional Interface but do not require matching modifiers or return types. In this example Functional Interface method is 'public void run()' of Runnable FI.

```java
public class MethodReferenceOfRunnableObjectRef {
    private  int fun1(){
        for(int i=1; i<=3; i++){
            System.out.println(i + " Child Thread: ");
        }
        return 10;
    }
    public static void main(String args[]){
        MethodReferenceOfRunnableObjectRef obj = new MethodReferenceOfRunnableObjectRef();
        Runnable r = obj::fun1; //METHOD IS RETURNING int BUT run() METHOD OF RUNNABLE DOES NOT HAVE ANY RETURN TYPE. THIS IS CORRECT BECAUSE ITS ARGUMENT IS SIMILAR TO run() METHOD.  
        Thread th = new Thread(r);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}

```
**Example 33** Similar to Example 32, but demonstrating an incorrect argument type, which will result in a compiler error.

```java
public class MethodReferenceOfRunnableObjectRef {
    public  void fun1(int x){
        for(int i=1; i<=3; i++){
            System.out.println(i + " Child Thread: ");
        }
        return 10;
    }
    public static void main(String args[]){
        MethodReferenceOfRunnableObjectRef obj = new MethodReferenceOfRunnableObjectRef();
        Runnable r = obj::fun1; //There will be a compiler error because it does not follow the argument type of the run() method of Runnable FI"  
        Thread th = new Thread(r);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}
```

**Example 34** Simple custom define FI with static Method reference example.

```java
public class MethodRefCustomFI {
    public static void sum(int x, int y){
        System.out.println("Sum: " + (x+y));
    }
    public static void main(String args[]){
        ABCInf abi = MethodRefCustomFI::sum;
        abi.add(10,20);
    }
}

interface ABCInf{
    public void add(int x, int y);
}
```


#### Constructor references : Constructor references are particularly useful in scenarios where you want to instantiate objects based on functional interfaces or lambda expressions. When we have functional interfaces (such as Supplier, Function, BiFunction, etc.) that need to create instances of classes, constructor references provide a concise way to instantiate objects.

**Example 35** Below is an example demonstrating the use of the Function functional interface using a lambda expression to instantiate a custom class, and the same using constructor reference.

```java
import java.util.function.Function;
public class ConstructorRefWithFunctionFI {
    public static void main(String args[]){
        Function<String,Sample> fi1 = (a) -> new Sample(a); //INSTANTIATE WITH LAMBDA EXPRESSION
        Sample obj1 = fi1.apply("Hello");
        obj1.show();

        Function<String,Sample> fi3 = Sample::new; //INSTANTIATE WITH CONSTRUCTOR REFERENCE
        Sample obj2 = fi3.apply("World");
        obj2.show();
    }
}

class Sample{
    String name;

    Sample(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("Name: " + name);
    }
}
```

**Example 36** Below is an example of creating a custom FI with multiple parameters to instantiate a custom class.

```java
interface ObjectCreateIntf<R,A,B,C>{
    R getObject(A a, B b, C c);
}
class SampleClz{
    String name;
    int age;
    double salary;
    
    SampleClz(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "SampleClz{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
public class ConstructorRefCustomFIMultipleParam {
    public static void main(String args[]){
        ObjectCreateIntf<SampleClz, String,Integer, Double> oi = SampleClz::new;
        SampleClz sobj1 = oi.getObject("Java", 38, 34999.00);
        System.out.println(sobj1);
        SampleClz sobj2 = oi.getObject("C++", 45, 58599.09);
        System.out.println(sobj2);
    }
}
```

