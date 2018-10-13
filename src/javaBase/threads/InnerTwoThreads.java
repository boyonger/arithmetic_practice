package javaBase.threads;

public class InnerTwoThreads {
    private static int state = 1;
    private static int num1 = 1;
    private static int num2 = 2;

    public static void main(String[] args) {
        final InnerTwoThreads t = new InnerTwoThreads();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (num1 < 100) {
                    synchronized (t) {
                        if (state != 1) {
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            System.out.println(num1 + ".....");
                            num1 += 2;
                        }
                        state = 2;
                        t.notifyAll();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (t) {
                    while (num2 < 100) {
                        if (state != 2) {
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            System.out.println(num2 + ".....");
                            num2 += 2;
                        }
                        state = 1;
                        t.notifyAll();
                    }
                }
            }
        }).start();
    }
}

