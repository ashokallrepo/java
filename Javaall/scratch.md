Java lambda expressions are particularly useful in scenarios where you need to:

* **Define Inline Behavior:** Lambda expressions allow you to define behavior inline at the point where it's needed, which can make your code more readable and concise, especially for short and simple operations.
* **Pass Behavior as Parameters:** If a method expects behavior as a parameter (for example, in sorting methods or event listeners), lambda expressions provide a compact and expressive way to pass that behavior without the need for verbose anonymous inner classes.
* **Functional Interfaces:** Lambda expressions shine when working with functional interfaces, which have a single abstract method. They allow you to create instances of these interfaces more easily and with less boilerplate code.
* **Stream API:** Lambda expressions are extensively used with the Stream API introduced in Java 8. They enable concise and expressive transformations and operations on streams of elements, such as mapping, filtering, and reducing.
* **Asynchronous Programming:** In asynchronous programming, lambda expressions are commonly used with interfaces like Runnable and Callable to define tasks that can be executed concurrently.
In essence, use lambda expressions in Java when you want to simplify your code by expressing behavior concisely, especially in situations where you need to pass behavior as a parameter or work with functional interfaces and streams. They are particularly beneficial for improving code readability and reducing boilerplate.


1. **Java 1.8** `[concise code]`
2. **new features** – `[REASONS : 1 - to simplify programming, 2 – to utilize functional programming benefits in java, 3 – to enable parallel programming ]`
3. **Lambda Exxpression**
4. **Functional Interfaces**
5. **Default methods in interfaces**
6. **Static method in interfaces**
7. **Predicate** [pre-defined functional interface]
8. **Function** [pre-defined functional interface]
9. **Consumer** [pre-defined functional interface]
10. **Supplier**
11. **Method refrence & Constructor refrence by double colon (::) operator**
12. **Stream API**
13. **Date & Time API** (Joda API & joda.org)
14. **Optional Class**
15. **Nashron Javascript Engine**

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

# Lambda Expression ---- `[It is an anonymous function Nameless, without return type without modifers]`

**Benefits :**
1. 	To enable functional progrmming in java
2. 	Write more readable, maintainable & concise code
3. 	To use APIs very easily and effectively
4. 	To enable parallel processing

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

