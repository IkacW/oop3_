package rs.ac.ni.pmf.oop3.vezbe.vezba07.Robots;

import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.oop3.vezbe.WaitUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

@Slf4j
public class RobotRunnable implements Runnable {
    private final DynamicMatrix2D _dynamicMatrix;
    private int _x;
    private int _y;
    private final char _color;
    private final Semaphore _mutex;
    private final char[] _directions;
    //                                 L   U  R  D
    private final int[] _directionX = {-1, 0, 1, 0};
    private final int[] _directionY = {0, -1, 0, 1};
    private final int _moves;
    private final CountDownLatch _countDownLatch;

    public RobotRunnable(final DynamicMatrix2D dynamicMatrix2D, final int x, final int y, final char color, final Semaphore mutex, final char[] directions, final int moves, final CountDownLatch countDownLatch) {
        _dynamicMatrix = dynamicMatrix2D;
        _x = x;
        _y = y;
        _color = color;
        _mutex = mutex;
        _directions = directions;
        _moves = moves;
        _dynamicMatrix.set(_x, _y, 'R');
        _countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < _moves; i++) {
            log.info("{} robot has arrived to ({},{})", _color, _x, _y);
            WaitUtil.sleep(1000);
            char c = Character.toUpperCase(_directions[i]);
            log.info("Robot is trying to go to {}", c);
            int dirX;
            int dirY;
            switch (c) {
                case 'L':
                  dirX = _directionX[0];
                  dirY = _directionY[0];
                  break;
                case 'U':
                    dirX = _directionX[1];
                    dirY = _directionY[1];
                    break;
                case 'R':
                    dirX = _directionX[2];
                    dirY = _directionY[2];
                    break;
                case 'D':
                    dirX = _directionX[3];
                    dirY = _directionY[3];
                    break;
                default:
                    // error
                    dirX = 0;
                    dirY = 0;
            }
            checkField();
            if (!_dynamicMatrix.isValidField(_x + dirX, _y + dirY)) {
                finishCheckingField();
                log.info("Robot has tried to go out of bounds ({},{})", _x, _y);
                continue;
            }
            char fieldState = Character.toUpperCase(_dynamicMatrix.get(_x + dirX, _y + dirY));
            if(fieldState != 'R') {
                _dynamicMatrix.set(_x, _y, _color);
                _dynamicMatrix.set(_x + dirX, _y + dirY, 'R');
                log.info("{} robot is going to ({}, {})", _color, _x + dirX, _y + dirY);
                _x += dirX;
                _y += dirY;
            }
            finishCheckingField();
        }
        //barijera
        _dynamicMatrix.set(_x, _y, _color);
        _countDownLatch.countDown();
    }

    public void checkField() {
        try {
            _mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finishCheckingField() {
        _mutex.release();
    }
}
