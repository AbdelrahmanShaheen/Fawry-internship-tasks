public final class Singleton {

//    public int input;
    static  private Singleton instance;

    private Singleton() {

    }
//    public void increment(){
//        input++;
//    }

    public static Singleton getInstance() {
        if(instance != null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }

//    public int getInput() {
//        return input;
//    }
}