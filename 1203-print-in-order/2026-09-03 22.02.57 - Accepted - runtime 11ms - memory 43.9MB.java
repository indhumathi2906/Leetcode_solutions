class Foo {

    CountDownLatch cd1;
    CountDownLatch cd2;

    public Foo() {
        cd1 = new CountDownLatch(1);
        cd2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        cd1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        cd1.await();
        printSecond.run();
        cd2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        cd2.await();
        printThird.run();
    }
}