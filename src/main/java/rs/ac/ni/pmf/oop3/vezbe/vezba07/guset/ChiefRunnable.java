package rs.ac.ni.pmf.oop3.vezbe.vezba07.guset;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.vezbe.WaitUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


@Slf4j
public class ChiefRunnable implements Runnable {
    private final CyclicBarrier _mealPreparedBarrier;
    private final int _timeout;
    private final WaiterRunnable _waiter;
    private final Semaphore _waitForWaiter;

    public ChiefRunnable(final CyclicBarrier mealPreparedBarrier, int timeout, final WaiterRunnable waiter, Semaphore s) throws InterruptedException {
        _mealPreparedBarrier = mealPreparedBarrier;
        _timeout = timeout;
        _waiter = waiter;

        _waitForWaiter = s;
        _waitForWaiter.acquire();
    }

    @Override
    public void run() {
        int counter = 2;
        while (counter > 0) {
            try {
                _waitForWaiter.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("Chief is notified to prepare next meal");
            WaitUtil.sleep(_timeout);
            log.info("Chief finished preparing meal");
            try {
                int waiting = _mealPreparedBarrier.await();
                if(waiting == 0) {
                    _mealPreparedBarrier.reset();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            _waiter.continueChecking();
            counter--;
        }
    }


}
