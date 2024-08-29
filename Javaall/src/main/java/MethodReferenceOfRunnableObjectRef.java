public class MethodReferenceOfRunnableObjectRef {
    public  void fun1(){
        for(int i=1; i<=3; i++){
            System.out.println(i + " Child Thread: ");
        }
    }
    public static void main(String args[]){
        MethodReferenceOfRunnableObjectRef obj = new MethodReferenceOfRunnableObjectRef();
        Runnable r = obj::fun1;
        Thread th = new Thread(r);
        th.start();
        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }
    }
}
