public class App {
    public static void main(String[] args) throws Exception {
        //Create counter object to be used in different threads
        Counter counter = new Counter();

        // Creates thread1 object with a first int of 0 and last of 20        
        MyThread thread1 = new MyThread(counter, 0, 20);
        // runs thread1
        thread1.start();

        // Creates thread2 object with a first int of 20 and last of 0.
        MyThread thread2 = new MyThread(counter, 20, 0);
        // Runs thread2
        thread2.start();
    }
}

// Thread Object
class MyThread extends Thread {

    Counter counter;
    int first;
    int last;

    public MyThread(Counter counter, int first, int last) {
        this.counter = counter;
        this.first = first;
        this.last = last;
    }

    @Override
    public void run() {
        //Synchronized block to maintain ordered output.
        synchronized (counter) {
        System.out.println("\nThread starting with " + first + " and ending with " + last + ".");
        counter.count(first, last);
        System.out.println("End Thread");
        }
    }
}

// Counter class to hold counter logic.
class Counter {

    // Counter method to count from first to last that is synchronized
    protected void count(int first, int last) {

        try {
            // Validates domain of expectable integers
            if (first > 150 || last > 150) {
                // throw new Exception
            }
        } catch (Exception e) {// catches out of domain error.
            System.out.println(e);
            return;
        }

        // sets i to first and increments i from first to last
        if (first < last) {
            for (int i = first; i <= last; i++) {
                System.out.print(i + ", ");
            }
            System.out.println();
            // sets i to first and increments i from first to last
        } else if (first > last) {
            for (int i = first; i >= last; i--) {
                System.out.print(i + ", ");
            }
            System.out.println("");
            // if first and last are equal print first.
        } else {
            System.out.println(first);
        }

    }

}
