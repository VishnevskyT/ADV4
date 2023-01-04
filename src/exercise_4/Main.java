package exercise_4;

import static java.lang.Thread.sleep;

/**
 * Завдання 4
 * Створіть потік-демон і виведіть про нього якнайбільше інформації.
 */
public class Main {
    public static void main(String[] args) {

        String aboutDaemonThread = """
                Daemon thread in Java is a low-priority thread that runs in the background\s
                to perform tasks such as garbage collection. Daemon thread in Java is also a service provider\s
                thread that provides services to the user thread. Its life depends on the mercy of user threads\s
                i.e. when all the user threads die, JVM terminates this thread automatically.
                In simple words, we can say that it provides services to user threads for background\s
                supporting tasks. It has no role in life other than to serve user threads.""";

        MyDaemonThread daemon = new MyDaemonThread();
        daemon.start();
        System.out.println(daemon.getName() + " Daemon Thread is started.");



        for (int i = 0; i < aboutDaemonThread.length(); i++) {
            try {
                sleep(5);
                System.out.print(aboutDaemonThread.charAt(i));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\n" + daemon.getName() + " Daemon Thread is finished.");
    }
}
