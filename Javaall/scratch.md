<h1>Java 1.8 [concise code]</h1>



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


**To invoke Lambda expression: [WITHOUT Functional Interface LAMBDA EXPRESSION CANNOT BE POSSIBLE]** 
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

**Difference between Interface with default method and Abstract classes**

| Sl. | Interface with default method                                                                           | Abstract Class                                                                                 |
|-----|---------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| 1   | Interface never talks about state of object                                                             | Abstract class can talk about state of object                                                  |
| 2   | Inside interface we cannot declare constructor                                                          | Inside abstract class we can declare constructor                                               |
| 3   | Inside interface we cannot declare instance and static blocks                                           | Inside abstract class we can declare instance and static blocks                                |
| 4   | Functional interface with default methods can refer Lambda expression                                   | Abstract class can’t refer Lambda expression                                                   |
| 5   | Inside interface we can’t override object class method                                                  | Inside abstract class we can override object class methods.                                    |
| 6   | Inside interface every variable is always public, static, and final we cannot declare instance varibale | Inside Abstract class we can declare instance variables, which are required to the child class |

**NOTE**: Interface with default method  is not equals to Abstract class

