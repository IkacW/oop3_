package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.wait;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class SharedStorageMine {
    String _message;
    boolean _empty = true;

    public synchronized String get() {
        log.info("Waiting to set a message");
        while(_empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _empty = true;
        String message = _message;
        notifyAll();
        return message;
    }

    public synchronized void set(final String message) {
        log.info("Waiting to set a message");
        while(!_empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _empty = false;
        _message = message;
        notifyAll();
    }
}
