
class Test {

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    taskQueue.add(Thread.currentThread().getName() + "任务" + i);
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    taskQueue.add(Thread.currentThread().getName() + "任务" + i);
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    taskQueue.add(Thread.currentThread().getName() + "任务" + i);
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    taskQueue.add(Thread.currentThread().getName() + "任务" + i);
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    taskQueue.add(Thread.currentThread().getName() + "任务" + i);
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    taskQueue.execute();
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    taskQueue.execute();
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    taskQueue.execute();
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    taskQueue.execute();
                }
            }
        });
        thread.start();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    taskQueue.execute();
                }
            }
        });
        thread.start();

    }

}