package exercise_4;

public class MyDaemonThread extends Thread {
    public MyDaemonThread() {
        setDaemon(true);
    }

}
