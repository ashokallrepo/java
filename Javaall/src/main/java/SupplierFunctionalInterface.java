import java.util.Date;
import java.util.function.Supplier;

public class SupplierFunctionalInterface {
    public static void main(String args[]){
        Supplier<Date> sup = ()->new Date();
        System.out.println(sup.get());
    }
}
