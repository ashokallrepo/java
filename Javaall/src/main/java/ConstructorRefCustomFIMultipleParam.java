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



