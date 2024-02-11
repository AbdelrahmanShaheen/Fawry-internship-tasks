
class SingletonRequester implements Runnable {


    public SingletonRequester() {

    }

    @Override
    public void run() {
//        System.out.println("Thread start: " + Thread.currentThread().getName());
//        for(int i = 0 ;i < 10_000 ;i++) {
//            System.out.println(i);
//            singleton.increment();
//        }
//        System.out.println("Thread end: " + Thread.currentThread().getName());
        System.out.println(Singleton.getInstance());
    }
}