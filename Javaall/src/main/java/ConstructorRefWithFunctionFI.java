import java.util.function.Function;
public class ConstructorRefWithFunctionFI {
    public static void main(String args[]){
        Function<String,Sample> fi1 = (a) -> new Sample(a);
        Sample obj1 = fi1.apply("Hello");
        obj1.show();

        Function<String,Sample> fi3 = Sample::new;
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


