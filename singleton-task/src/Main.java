import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
//        List<Thread>threads = new ArrayList<>();
//        for(int i = 0 ;i < 10 ;i++) {
//            Thread thread = new Thread(new SingletonRequester(singleton));
//            thread.start();
//            threads.add(thread);
//        }
//        for(var thread : threads){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("Total" + singleton.getInput());
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SingletonRequester(Singleton.getInstance()));
            thread.start();
        }

    }
}