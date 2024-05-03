public class AnonymusClassWithRunnable {
    public static void main(String args[]){
        Runnable r = new Runnable() {   //anonymous class which does not have class name and implemented Runnable interface
            @Override
            public void run() {
                for(int i=1;i<=3;i++){
                    System.out.println(i + " Child Thread");
                }
            }
        };
        Thread t = new Thread(r);
        t.start();

        for(int i=1;i<=3;i++){
            System.out.println(i + " Main Thread");
        }

    }
}

