package io.objectbox.android;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AndroidScheduler extends android.os.Handler implements io.objectbox.reactive.Scheduler {
    private static io.objectbox.android.AndroidScheduler MAIN_THREAD;
    private final java.util.Deque<io.objectbox.android.AndroidScheduler.Runner> freeRunners;

    public static synchronized io.objectbox.reactive.Scheduler mainThread() {
        if (MAIN_THREAD == null) {
            MAIN_THREAD = new io.objectbox.android.AndroidScheduler(android.os.Looper.getMainLooper());
        }
        return MAIN_THREAD;
    }

    public AndroidScheduler(android.os.Looper looper) {
        super(looper);
        this.freeRunners = new java.util.ArrayDeque();
    }

    @Override // io.objectbox.reactive.Scheduler
    public <T> void run(io.objectbox.reactive.RunWithParam<T> runWithParam, T t) {
        io.objectbox.android.AndroidScheduler.Runner runnerPoll;
        synchronized (this.freeRunners) {
            runnerPoll = this.freeRunners.poll();
        }
        if (runnerPoll == null) {
            runnerPoll = new io.objectbox.android.AndroidScheduler.Runner();
        }
        runnerPoll.runWithParam = runWithParam;
        runnerPoll.param = t;
        post(runnerPoll);
    }

    class Runner implements java.lang.Runnable {
        java.lang.Object param;
        io.objectbox.reactive.RunWithParam<java.lang.Object> runWithParam;

        Runner() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runWithParam.run(this.param);
            this.runWithParam = null;
            this.param = null;
            synchronized (io.objectbox.android.AndroidScheduler.this.freeRunners) {
                if (io.objectbox.android.AndroidScheduler.this.freeRunners.size() < 20) {
                    io.objectbox.android.AndroidScheduler.this.freeRunners.add(this);
                }
            }
        }
    }
}
