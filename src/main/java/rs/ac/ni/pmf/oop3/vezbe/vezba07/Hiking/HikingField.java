package rs.ac.ni.pmf.oop3.vezbe.vezba07.Hiking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HikingField {

    private BlockingQueue<String> _blockingQueue;

    public HikingField(final int _capacity) {
        _blockingQueue = new ArrayBlockingQueue(_capacity);
    }

    public BlockingQueue<String> getQueue() {
        return _blockingQueue;
    }
}
