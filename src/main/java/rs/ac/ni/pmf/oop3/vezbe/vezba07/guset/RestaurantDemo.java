package rs.ac.ni.pmf.oop3.vezbe.vezba07.guset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class RestaurantDemo {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService _guestService = Executors.newCachedThreadPool();
        final ScheduledExecutorService _waiterService = Executors.newSingleThreadScheduledExecutor();
        final ExecutorService _chiefService = Executors.newSingleThreadExecutor();

        final List<GuestRunnable> _guests = new ArrayList<>();
        final CyclicBarrier _cyclicBarrier = new CyclicBarrier(3);
        final CyclicBarrier _chiefBarrier = new CyclicBarrier(4);

        final Semaphore notifyChief = new Semaphore(1);
        final Semaphore awaitChief = new Semaphore(1);

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        _guests.add(new GuestRunnable(_cyclicBarrier, _chiefBarrier, "Mika", 1000, 1500, 1000, countDownLatch));
        _guests.add(new GuestRunnable(_cyclicBarrier, _chiefBarrier, "Pera", 3000, 1000, 500, countDownLatch));
        _guests.add(new GuestRunnable(_cyclicBarrier, _chiefBarrier, "Laza", 2000, 1000, 1000, countDownLatch));
        WaiterRunnable waiter = new WaiterRunnable(_cyclicBarrier, 2, notifyChief, awaitChief);
        _waiterService.scheduleWithFixedDelay(waiter, 1, 2, TimeUnit.SECONDS);
        _chiefService.submit(new ChiefRunnable(_chiefBarrier, 2500, waiter, awaitChief));
        for(GuestRunnable guestRunnable : _guests) {
            _guestService.submit(guestRunnable);
        }
        _guestService.shutdown();
        _chiefService.shutdown();

        countDownLatch.await();
        _waiterService.shutdown();
    }
}
