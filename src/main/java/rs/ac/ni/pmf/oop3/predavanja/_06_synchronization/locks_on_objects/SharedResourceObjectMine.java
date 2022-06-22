package rs.ac.ni.pmf.oop3.predavanja._06_synchronization.locks_on_objects;

public class SharedResourceObjectMine {
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    private int valueA;
    private int valueB;
    private int valueC;

    public int methodA() {
        int currentValue;

        synchronized (lockA) {
            System.out.println("Executing methodA()");
            sleepFor(2000);
            currentValue = this.valueA;
            this.valueA++;
            System.out.println("Finished methodB()");
        }
        return currentValue;
    }

    public int methodB() {
        int currentValue;

        synchronized (lockB) {
            System.out.println("Executing methodB()");
            sleepFor(2000);
            currentValue = this.valueB;
            this.valueB++;
            System.out.println("Finished methodB()");
        }

        return currentValue;
    }

    public int methodC() {
        System.out.println("Executing method C");
        sleepFor(2000);
        System.out.println("Finished method C");
        return this.valueC;
    }

    private static void sleepFor(int timeout)   {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}