import java.util.function.IntSupplier;
public class IntSupplierExample {
    public static void main(String args[]){
        IntSupplier is = ()-> 10 * 10;
        System.out.println(is.getAsInt());
    }
}
