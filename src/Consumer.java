import sun.awt.Mutex;

import java.util.List;

/**
 * Created by igoryan on 01.04.16.
 */
public class Consumer extends Thread {
    private List<Character> buffer;
    private StringBuilder result = new StringBuilder();

    public Consumer(List<Character> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        boolean finish = false;
        while (!finish) {
            synchronized (buffer) {
                for (int i = 0; i < buffer.size(); ++i) {
                    result.append(buffer.get(i));
                    if (buffer.get(i).charValue() == '.') {
                        finish = true;
                        break;
                    }
                    System.out.println("read:" + buffer.get(i));
                }
                buffer.clear();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("finish read:" + result.toString());
    }
}
