public class LambdaExpRunnable {
    public static void main(String args[]){
//        TestRunnable tr = new TestRunnable();
//        Thread th = new Thread(tr);
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

class TestRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=1; i<=3; i++){
            System.out.println(i + " Child Thread: ");
        }
    }
}
