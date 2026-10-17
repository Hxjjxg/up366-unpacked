package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ResultStatistics {
    private static final int RADIUS = 20;
    private static final int TIMES = 6;
    private com.up366.smart.paper.ResultStatistics.Callback mCallback;
    private com.up366.smart.paper.BitmapAnalyzeResult mResult;
    private int radiusRange;
    private long startTime;
    private int timeLimit;
    private int times;
    private int timesLimit;

    public interface Callback {
        void onResult(com.up366.smart.paper.BitmapAnalyzeResult result);
    }

    public ResultStatistics() {
        this.times = 0;
        this.startTime = 0L;
        this.timesLimit = 6;
        this.radiusRange = 20;
    }

    public ResultStatistics(int timesLimit, int radiusRange) {
        this.times = 0;
        this.startTime = 0L;
        this.timesLimit = timesLimit;
        this.radiusRange = radiusRange;
    }

    public int getTimesLimit() {
        return this.timesLimit;
    }

    public void setTimesLimit(int timesLimit) {
        this.timesLimit = timesLimit;
    }

    public int getRadiusRange() {
        return this.radiusRange;
    }

    public void setRadiusRange(int radiusRange) {
        this.radiusRange = radiusRange;
    }

    public int getTimeLimit() {
        return this.timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setCallback(com.up366.smart.paper.ResultStatistics.Callback mCallback) {
        this.mCallback = mCallback;
    }

    public synchronized java.lang.Boolean addAnalyzeResult(com.up366.smart.paper.BitmapAnalyzeResult result) {
        if (this.mResult == null) {
            this.mResult = result;
            this.times = 1;
            return false;
        }
        if (isNearResult(result)) {
            int i = this.times + 1;
            this.times = i;
            if (i == this.timesLimit) {
                com.up366.smart.paper.ResultStatistics.Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onResult(result);
                }
                this.times = 0;
                this.mResult = null;
                return true;
            }
        } else {
            this.times = 1;
            this.mResult = result;
        }
        return false;
    }

    public synchronized void clear() {
        this.mResult = null;
    }

    public synchronized java.lang.Boolean addAnalyzeResultByTime(com.up366.smart.paper.BitmapAnalyzeResult result) {
        if (this.mResult == null) {
            this.mResult = result;
            this.startTime = java.lang.System.currentTimeMillis();
            return false;
        }
        if (isNearResult(result)) {
            this.times++;
            if (java.lang.System.currentTimeMillis() - this.startTime > this.timeLimit) {
                this.startTime = 0L;
                this.mResult = null;
                com.up366.smart.paper.ResultStatistics.Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onResult(result);
                }
                return true;
            }
        } else {
            this.startTime = java.lang.System.currentTimeMillis();
            this.mResult = result;
        }
        return false;
    }

    private boolean isNearResult(com.up366.smart.paper.BitmapAnalyzeResult result) {
        java.util.List<org.opencv.core.Point> points = result.getPoints();
        java.util.List<org.opencv.core.Point> points2 = this.mResult.getPoints();
        return com.up366.smart.paper.opencv.PointUtil.pointDistance(points2.get(0), points.get(0)) <= ((double) this.radiusRange) && com.up366.smart.paper.opencv.PointUtil.pointDistance(points2.get(1), points.get(1)) <= ((double) this.radiusRange) && com.up366.smart.paper.opencv.PointUtil.pointDistance(points2.get(2), points.get(2)) <= ((double) this.radiusRange) && com.up366.smart.paper.opencv.PointUtil.pointDistance(points2.get(3), points.get(3)) <= ((double) this.radiusRange);
    }
}
