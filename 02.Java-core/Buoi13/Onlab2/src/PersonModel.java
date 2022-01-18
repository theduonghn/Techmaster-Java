import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

public class PersonModel<T> {
    private ArrayList<T> al = new ArrayList<>();

    public void add(T obj) {
        al.add(obj);
    }

    public void display() {
        for (T object : al) {
            System.out.println(object);
        }
    }
}
