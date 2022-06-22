package rs.ac.ni.pmf.oop3.vezbe.vezba07.guset;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


@Slf4j
public class WaiterRunnable implements Runnable {
    private final CyclicBarrier _cyclicBarrier;
    private final int _limit;
    private final Semaphore _awaitChief;
    private final Semaphore _notifyChief;

    public WaiterRunnable(final CyclicBarrier cyclicBarrier, final int limit, final Semaphore semaphore, final Semaphore chiefSemaphore) throws InterruptedException {
        _cyclicBarrier = cyclicBarrier;
        _limit = limit;
        _notifyChief = chiefSemaphore;
        _awaitChief = semaphore;

        _awaitChief.acquire();
    }

    @Override
    public void run() {
        log.info("Waiter is checking on guests");
        if(_cyclicBarrier.getNumberWaiting() >= _limit) {
            log.info("Waiter is notifying cook to prepare lunch");
            try {
                _notifyChief.release();
                _awaitChief.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void continueChecking() {
        _awaitChief.release();
    }
}
