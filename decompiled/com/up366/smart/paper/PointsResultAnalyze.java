package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PointsResultAnalyze {
    private com.up366.smart.paper.PointsResultAnalyze.Callback mCallback;
    private org.opencv.core.Point[] resultPoints = new org.opencv.core.Point[4];
    private java.util.ArrayList<com.up366.smart.paper.AnalyzePointResult> results = new java.util.ArrayList<>();

    public interface Callback {
        void onResult(com.up366.smart.paper.BitmapAnalyzeResult result);
    }

    public void setmCallback(com.up366.smart.paper.PointsResultAnalyze.Callback mCallback) {
        this.mCallback = mCallback;
    }

    public synchronized void add(com.up366.smart.paper.BitmapAnalyzeResult result) {
        if (result.getPoints().size() == 4) {
            if (this.results.size() == 0) {
                this.results.add(new com.up366.smart.paper.AnalyzePointResult(result));
            } else {
                java.util.Iterator<com.up366.smart.paper.AnalyzePointResult> it = this.results.iterator();
                boolean zAddPoints = false;
                while (it.hasNext()) {
                    zAddPoints = it.next().addPoints(result);
                }
                if (zAddPoints) {
                    analyzePoints();
                } else {
                    this.results.add(new com.up366.smart.paper.AnalyzePointResult(result));
                }
            }
        }
    }

    public synchronized void clear() {
        this.results.clear();
    }

    public void analyzePoints() {
        for (com.up366.smart.paper.AnalyzePointResult analyzePointResult : this.results) {
            if (analyzePointResult.times == 6) {
                this.mCallback.onResult(analyzePointResult.getAnalyzeResult());
                clear();
                return;
            }
        }
    }
}
