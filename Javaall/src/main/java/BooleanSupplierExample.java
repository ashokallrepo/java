import java.util.function.BooleanSupplier;
public class BooleanSupplierExample {
    public static void main(String args[]){
        BooleanSupplier bs = ()-> 10 > 5;
        System.out.println(bs.getAsBoolean());
    }
}
