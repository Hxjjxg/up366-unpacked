package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class StudyTaskPercentInfo {
    public static final float DEFAULT_PERCENT = 101.0f;
    private float percent = 101.0f;
    private float maxPercent = 101.0f;
    private float compareLast = 101.0f;
    private float compareGlobal = 101.0f;

    public float getPercent() {
        return this.percent;
    }

    public void setPercent(float f) {
        this.percent = f;
    }

    public float getMaxPercent() {
        return this.maxPercent;
    }

    public void setMaxPercent(float f) {
        this.maxPercent = f;
    }

    public float getCompareLast() {
        return this.compareLast;
    }

    public void setCompareLast(float f) {
        this.compareLast = f;
    }

    public float getCompareGlobal() {
        return this.compareGlobal;
    }

    public void setCompareGlobal(float f) {
        this.compareGlobal = f;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.task.model.StudyTaskPercentInfo studyTaskPercentInfo = (com.up366.mobile.course.task.model.StudyTaskPercentInfo) obj;
        return java.lang.Float.compare(studyTaskPercentInfo.percent, this.percent) == 0 && java.lang.Float.compare(studyTaskPercentInfo.maxPercent, this.maxPercent) == 0 && java.lang.Float.compare(studyTaskPercentInfo.compareLast, this.compareLast) == 0 && java.lang.Float.compare(studyTaskPercentInfo.compareGlobal, this.compareGlobal) == 0;
    }

    public int hashCode() {
        float f = this.percent;
        int iFloatToIntBits = (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0) * 31;
        float f2 = this.maxPercent;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 != 0.0f ? java.lang.Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.compareLast;
        int iFloatToIntBits3 = (iFloatToIntBits2 + (f3 != 0.0f ? java.lang.Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.compareGlobal;
        return iFloatToIntBits3 + (f4 != 0.0f ? java.lang.Float.floatToIntBits(f4) : 0);
    }
}
