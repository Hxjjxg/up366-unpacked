package java8.util.concurrent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class TLRandom {
    private static final long CCL;
    private static final long GAMMA = -7046029254386353131L;
    private static final long INHERITABLETHREADLOCALS;
    private static final long INHERITEDACCESSCONTROLCONTEXT;
    private static final boolean IS_ANDROID;
    private static final boolean IS_PRE8_IBM;
    private static final int PROBE_INCREMENT = -1640531527;
    private static final long SEEDER_INCREMENT = -4942790177534073029L;
    private static final long THREADLOCALS;
    private static final sun.misc.Unsafe U;
    private static final java.lang.ThreadLocal<java8.util.concurrent.TLRandom.SeedsHolder> localSeeds;
    private static final java.util.concurrent.atomic.AtomicInteger probeGenerator;
    private static final java.util.concurrent.atomic.AtomicLong seeder;

    static int mix32(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        return (int) (((j2 ^ (j2 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    static long mix64(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private TLRandom() {
    }

    static final void localInit() {
        int iAddAndGet = probeGenerator.addAndGet(PROBE_INCREMENT);
        if (iAddAndGet == 0) {
            iAddAndGet = 1;
        }
        setThreadLocalRandomSeed(mix64(seeder.getAndAdd(SEEDER_INCREMENT)));
        setThreadLocalRandomProbe(iAddAndGet);
    }

    static final long nextSeed() {
        long threadLocalRandomSeed = getThreadLocalRandomSeed() + GAMMA;
        setThreadLocalRandomSeed(threadLocalRandomSeed);
        return threadLocalRandomSeed;
    }

    static final int getProbe() {
        return getThreadLocalRandomProbe();
    }

    static final int advanceProbe(int i) {
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        setThreadLocalRandomProbe(i4);
        return i4;
    }

    static final int nextSecondarySeed() {
        int iMix32;
        int threadLocalRandomSecondarySeed = getThreadLocalRandomSecondarySeed();
        if (threadLocalRandomSecondarySeed != 0) {
            int i = threadLocalRandomSecondarySeed ^ (threadLocalRandomSecondarySeed << 13);
            int i2 = i ^ (i >>> 17);
            iMix32 = i2 ^ (i2 << 5);
        } else {
            iMix32 = mix32(seeder.getAndAdd(SEEDER_INCREMENT));
            if (iMix32 == 0) {
                iMix32 = 1;
            }
        }
        setThreadLocalRandomSecondarySeed(iMix32);
        return iMix32;
    }

    private static final class SeedsHolder {
        int threadProbe;
        int threadSecondarySeed;
        long threadSeed;

        private SeedsHolder() {
        }
    }

    static long getThreadLocalRandomSeed() {
        return localSeeds.get().threadSeed;
    }

    private static void setThreadLocalRandomSeed(long j) {
        localSeeds.get().threadSeed = j;
    }

    static int getThreadLocalRandomProbe() {
        return localSeeds.get().threadProbe;
    }

    private static void setThreadLocalRandomProbe(int i) {
        localSeeds.get().threadProbe = i;
    }

    private static int getThreadLocalRandomSecondarySeed() {
        return localSeeds.get().threadSecondarySeed;
    }

    private static void setThreadLocalRandomSecondarySeed(int i) {
        localSeeds.get().threadSecondarySeed = i;
    }

    static final void eraseThreadLocals(java.lang.Thread thread) {
        if (IS_ANDROID) {
            return;
        }
        sun.misc.Unsafe unsafe = U;
        unsafe.putObject(thread, THREADLOCALS, (java.lang.Object) null);
        unsafe.putObject(thread, INHERITABLETHREADLOCALS, (java.lang.Object) null);
    }

    static final void setInheritedAccessControlContext(java.lang.Thread thread, java.security.AccessControlContext accessControlContext) {
        if (IS_ANDROID) {
            return;
        }
        U.putOrderedObject(thread, INHERITEDACCESSCONTROLCONTEXT, accessControlContext);
    }

    static final void setContextClassLoader(java.lang.Thread thread, java.lang.ClassLoader classLoader) {
        if (IS_ANDROID) {
            return;
        }
        U.putObject(thread, CCL, classLoader);
    }

    private static boolean isAndroid() {
        if (isClassPresent("android.util.DisplayMetrics")) {
            return true;
        }
        return isClassPresent("org.robovm.rt.bro.Bro");
    }

    private static boolean isIBMPre8() {
        java.lang.String property;
        return isClassPresent("com.ibm.misc.JarVersion") && (property = java.lang.System.getProperty("java.class.version", "45")) != null && property.length() >= 2 && "52".compareTo(property.substring(0, 2)) > 0;
    }

    private static boolean isClassPresent(java.lang.String str) {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName(str, false, java8.util.concurrent.TLRandom.class.getClassLoader());
        } catch (java.lang.Throwable unused) {
            cls = null;
        }
        return cls != null;
    }

    static {
        sun.misc.Unsafe unsafe = java8.util.concurrent.UnsafeAccess.unsafe;
        U = unsafe;
        try {
            boolean zIsIBMPre8 = isIBMPre8();
            IS_PRE8_IBM = zIsIBMPre8;
            boolean zIsAndroid = isAndroid();
            IS_ANDROID = zIsAndroid;
            if (!zIsAndroid) {
                THREADLOCALS = unsafe.objectFieldOffset(java.lang.Thread.class.getDeclaredField("threadLocals"));
                INHERITABLETHREADLOCALS = unsafe.objectFieldOffset(java.lang.Thread.class.getDeclaredField("inheritableThreadLocals"));
                INHERITEDACCESSCONTROLCONTEXT = unsafe.objectFieldOffset(java.lang.Thread.class.getDeclaredField(zIsIBMPre8 ? "accessControlContext" : "inheritedAccessControlContext"));
                CCL = unsafe.objectFieldOffset(java.lang.Thread.class.getDeclaredField("contextClassLoader"));
            } else {
                THREADLOCALS = 0L;
                INHERITABLETHREADLOCALS = 0L;
                INHERITEDACCESSCONTROLCONTEXT = 0L;
                CCL = 0L;
            }
            localSeeds = new java.lang.ThreadLocal<java8.util.concurrent.TLRandom.SeedsHolder>() { // from class: java8.util.concurrent.TLRandom.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public java8.util.concurrent.TLRandom.SeedsHolder initialValue() {
                    return new java8.util.concurrent.TLRandom.SeedsHolder();
                }
            };
            probeGenerator = new java.util.concurrent.atomic.AtomicInteger();
            seeder = new java.util.concurrent.atomic.AtomicLong(mix64(java.lang.System.currentTimeMillis()) ^ mix64(java.lang.System.nanoTime()));
            if (((java.lang.Boolean) java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java.lang.Boolean>() { // from class: java8.util.concurrent.TLRandom.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public java.lang.Boolean run() {
                    return java.lang.Boolean.valueOf(java.lang.Boolean.getBoolean("java.util.secureRandomSeed"));
                }
            })).booleanValue()) {
                byte[] seed = java.security.SecureRandom.getSeed(8);
                long j = ((long) seed[0]) & 255;
                for (int i = 1; i < 8; i++) {
                    j = (j << 8) | (((long) seed[i]) & 255);
                }
                seeder.set(j);
            }
        } catch (java.lang.Exception e) {
            throw new java.lang.ExceptionInInitializerError(e);
        }
    }
}
