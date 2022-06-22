package rs.ac.ni.pmf.oop3.vezbe.vezba07.guset;

import com.google.common.util.concurrent.MoreExecutors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.vezbe.WaitUtil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

@RequiredArgsConstructor
@Slf4j
public class GuestRunnable implements Runnable {
    private final CyclicBarrier _cyclicBarrier;
    private final CyclicBarrier _chiefBarrier;
    private final String _name;
    private final long _appetizerTimeout;
    private final long _mainCourseTimeout;
    private final long _desertTimeout;
    private final CountDownLatch _latch;

    @Override
    public void run() {
        log.info("Guest {} is starting to eat appetizer", _name);
        WaitUtil.sleep(_appetizerTimeout);
        log.info("Guest {} have finished the appetizer", _name);

        try {
            int waiting = _cyclicBarrier.await();

            if (waiting == 0) {
                _cyclicBarrier.reset();
            }

            waiting = _chiefBarrier.await();
            if(waiting == 0) {
                _chiefBarrier.reset();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        log.info("Guest {} is starting to the main course", _name);
        WaitUtil.sleep(_mainCourseTimeout);
        log.info("Guest {} have finished the main course", _name);

        try {
            int waiting = _cyclicBarrier.await();
            if(waiting == 0) {
                _cyclicBarrier.reset();
            }


            waiting = _chiefBarrier.await();
            if(waiting == 0) {
                _chiefBarrier.reset();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        log.info("Guest {} is starting to the desert", _name);
        WaitUtil.sleep(_desertTimeout);
        log.info("Guest {} have finished the desert", _name);
        _latch.countDown();
    }
}


//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import rs.ac.ni.pmf.oop3.vezbe.WaitUtil;
//
//import java.util.concurrent.BrokenBarrierException;
//import java.util.concurrent.CyclicBarrier;
//
//@RequiredArgsConstructor
//@Slf4j
//public class GuestRunnable implements Runnable {
//    private final CyclicBarrier _barrier;
//    private final CyclicBarrier _chiefBarrier;
//    private final String _name;
//    private final long _appetizerTimeout;
//    private final long _mainCourseTimeout;
//    private final long _desertTimeout;
//    @Override
//    public void run() {
//        log.info("Guest {} starting the appetizer ", _name);
//        WaitUtil.sleep(_appetizerTimeout);
//        log.info("Guest {} finished the appetizer", _name);
//
//        try {
//            int toWait = _barrier.await();
//
//            if(toWait == 0) {
//                _barrier.reset();
//            }
//
//            _chiefBarrier.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//
//        log.info("Guest {} starting the main course ", _name);
//        WaitUtil.sleep(_appetizerTimeout);
//        log.info("Guest {} finished the main course", _name);
//
//        try {
//            log.info("Guest {} is waiting for others to finish", _name);
//            int toWait = _barrier.await();
//
//            if (toWait == 0) {
//                _barrier.reset();
//            }
//
//            _chiefBarrier.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//
//        log.info("Guest {} starting the desert ", _name);
//        WaitUtil.sleep(_mainCourseTimeout);
//        log.info("Guest {} finished the desert", _name);
//    }
//}
