package com.igexin.c.a.d;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class e<E extends com.igexin.c.a.d.f> {
    static final /* synthetic */ boolean h = true;
    private static final java.lang.String i = "ScheduleQueue";
    final transient java.util.concurrent.locks.ReentrantLock a;
    final transient java.util.concurrent.locks.Condition b;
    final java.util.TreeSet<E> c;
    final java.util.concurrent.atomic.AtomicInteger d;
    int e;
    com.igexin.c.a.d.g f;
    public final java.util.concurrent.atomic.AtomicLong g;
    private long j;

    public e(java.util.Comparator<? super E> comparator, com.igexin.c.a.d.g gVar) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.d = new java.util.concurrent.atomic.AtomicInteger(0);
        this.g = new java.util.concurrent.atomic.AtomicLong(-1L);
        this.c = new java.util.TreeSet<>(comparator);
        this.f = gVar;
    }

    private E b() {
        try {
            return this.c.first();
        } catch (java.util.NoSuchElementException unused) {
            return null;
        }
    }

    private E c() {
        E e = (E) b();
        if (e == null) {
            return null;
        }
        if (this.c.remove(e)) {
            return e;
        }
        com.igexin.c.a.c.a.a(i, "Queue Poll Error@");
        return null;
    }

    private E d() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            com.igexin.c.a.d.f fVarB = b();
            if (fVarB != null) {
                if (fVarB.a(java.util.concurrent.TimeUnit.MILLISECONDS) > 0) {
                    fVarB.N |= 134217728;
                } else {
                    fVarB.N &= 1090519038;
                }
                if (fVarB.N >= 0) {
                    E e = (E) c();
                    if (!h && e == null) {
                        throw new java.lang.AssertionError();
                    }
                    if (!e()) {
                        this.b.signalAll();
                    }
                    return e;
                }
            }
            reentrantLock.unlock();
            return null;
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean e() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            return this.c.isEmpty();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void f() {
        this.c.clear();
    }

    public final int a(E e, long j, java.util.concurrent.TimeUnit timeUnit) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            if (!this.c.contains(e)) {
                reentrantLock.unlock();
                return -1;
            }
            this.c.remove(e);
            e.w = java.lang.System.currentTimeMillis() + java.util.concurrent.TimeUnit.MILLISECONDS.convert(j, timeUnit);
            e.getClass().getSimpleName();
            e.hashCode();
            e.a(java.util.concurrent.TimeUnit.SECONDS);
            return a(e) ? 1 : -2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E a() throws java.lang.InterruptedException {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                com.igexin.c.a.d.f fVarB = b();
                if (fVarB != null) {
                    long jA = fVarB.a(java.util.concurrent.TimeUnit.NANOSECONDS);
                    boolean z = fVarB.m || fVarB.n;
                    if (jA <= 0 || z) {
                        break;
                    }
                    fVarB.getClass().getSimpleName();
                    fVarB.hashCode();
                    java.util.concurrent.TimeUnit.SECONDS.convert(jA, java.util.concurrent.TimeUnit.NANOSECONDS);
                    this.g.set(fVarB.w);
                    boolean z2 = this.f.D;
                    fVarB.getClass().getName();
                    fVarB.hashCode();
                    if (this.f.D) {
                        this.f.a(fVarB.w);
                    }
                    this.b.awaitNanos(jA);
                } else {
                    this.d.set(1);
                    this.e = 0;
                    this.b.await();
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        E e = (E) c();
        if (!h && e == null) {
            throw new java.lang.AssertionError();
        }
        if (!e()) {
            this.b.signalAll();
        }
        if (this.j > 0) {
            java.lang.System.currentTimeMillis();
        }
        this.g.set(-1L);
        return e;
    }

    public final boolean a(E e) {
        if (e == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            com.igexin.c.a.d.f fVarB = b();
            int i2 = this.e + 1;
            this.e = i2;
            e.x = i2;
            if (!this.c.add(e)) {
                e.x--;
                return false;
            }
            e.N++;
            e.N &= 1090519038;
            if (fVarB == null || this.c.comparator().compare(e, fVarB) < 0) {
                this.b.signalAll();
            }
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("ScheduleQueue|offer|error", new java.lang.Object[0]);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean a(java.lang.Class cls) {
        if (cls == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            cls.getName();
            for (E e : this.c) {
                if (e.getClass() == cls) {
                    arrayList.add(e);
                }
            }
            cls.getName();
            arrayList.size();
            this.c.removeAll(arrayList);
            reentrantLock.unlock();
            return true;
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean b(E e) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            if (this.c.contains(e) && this.c.remove(e)) {
                return a(e);
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean c(E e) {
        if (e == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            e.getClass().getName();
            if (!this.c.contains(e) || !this.c.remove(e)) {
                return false;
            }
            e.getClass().getName();
            e.hashCode();
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
