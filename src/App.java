import java.util.ArrayList;
import java.util.List;

/**
 * Created by igoryan on 01.04.16.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        List<Character> buffer = new ArrayList<>();
        Producer producer = new Producer("Я живу, пока не сдохну, а как сдохну, досвидос \n" +
                "И жара мне не впилася, и мне пох*ю мороз \n" +
                "Я упрямый, как Гагарин, и красив я так, как он \n" +
                "Не слуга я и не барин, всех миров я чемпион \n" +
                "Я п*здец какой толковый, я вменяем, как никто \n" +
                "Тут и Гегель, тут и Бабель, тут и дедушка Пихто.", buffer);
        Consumer consumer = new Consumer(buffer);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
