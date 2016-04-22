import sun.awt.Mutex;

import java.util.List;

/**
 * Created by igoryan on 01.04.16.
 */
public class Producer extends Thread {
    private String message;
    List<Character> buffer;

    public Producer(String message, List<Character> buffer) {
        this.message = message;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < message.length(); ++i) {
            synchronized (buffer) {
                buffer.add(message.charAt(i));
                System.out.println("write:" + message.charAt(i));
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
