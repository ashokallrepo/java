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