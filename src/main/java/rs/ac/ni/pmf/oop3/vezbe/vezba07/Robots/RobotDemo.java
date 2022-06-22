package rs.ac.ni.pmf.oop3.vezbe.vezba07.Robots;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class RobotDemo {
    public static void main(String[] args) {
        final ExecutorService _executorService = Executors.newCachedThreadPool();
        final DynamicMatrix2D _dynamicMatrix = new DynamicMatrix2D(8, 8);
        final Semaphore _mutex = new Semaphore(1);

        char[] _directions1 = {'L', 'R', 'U', 'L'};
        char[] _directions2 = {'L', 'L', 'R', 'U'};
        char[] _directions3 = {'D', 'U', 'R', 'R'};
        char[] _directions4 = {'U', 'R', 'D', 'L'};

        final List<RobotRunnable> _robots = new ArrayList<>();

        final CountDownLatch countDownLatch = new CountDownLatch(4);
        _robots.add(new RobotRunnable(_dynamicMatrix, 1, 2, 'P', _mutex, _directions1, 4, countDownLatch));
        _robots.add(new RobotRunnable(_dynamicMatrix, 3, 5, 'B', _mutex, _directions2, 4, countDownLatch));
        _robots.add(new RobotRunnable(_dynamicMatrix, 5, 7, 'G', _mutex, _directions3, 4, countDownLatch));
        _robots.add(new RobotRunnable(_dynamicMatrix, 4, 4, 'W', _mutex, _directions4, 4, countDownLatch));

        for(RobotRunnable _robot : _robots) {
            _executorService.submit(_robot);
        }

        _executorService.shutdown();


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i  = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(_dynamicMatrix.get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
