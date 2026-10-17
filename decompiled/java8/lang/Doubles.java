package java8.lang;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Doubles {
    public static double sum(double d, double d2) {
        return d + d2;
    }

    public static int hashCode(double d) {
        long jDoubleToLongBits = java.lang.Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public static double max(double d, double d2) {
        return java.lang.Math.max(d, d2);
    }

    public static double min(double d, double d2) {
        return java.lang.Math.min(d, d2);
    }

    public static boolean isFinite(double d) {
        return java.lang.Math.abs(d) <= Double.MAX_VALUE;
    }

    private Doubles() {
    }
}
