package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CoursePageCountHolder {
    private static final java.lang.String CACHE_KEY = "cache-CoursePageCountHolder";
    private com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult calendarWeekResult;
    private int courseNum;
    private int currentTaskNum;
    private int historyTaskNum;
    private int willExpireTaskNum;
    private int wordNoteNum;
    private int wrongNoteNum;
    private float percent = 101.0f;
    private float maxPercent = 101.0f;
    private float compareLast = 101.0f;
    private float compareGlobal = 101.0f;
    private boolean hasShowAnimPercent = false;

    public interface IUpdateHolder {
        void onUpdate(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder);
    }

    private static class Instance {
        private static final com.up366.mobile.course.task.model.CoursePageCountHolder holder = new com.up366.mobile.course.task.model.CoursePageCountHolder();

        private Instance() {
        }
    }

    public static com.up366.mobile.course.task.model.CoursePageCountHolder load() {
        com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder = (com.up366.mobile.course.task.model.CoursePageCountHolder) com.up366.mobile.common.logic.Auth.cur().cache().loadSync(CACHE_KEY, com.up366.mobile.course.task.model.CoursePageCountHolder.class);
        com.up366.common.log.Logger.info("TAG - CoursePageCountHolder - load - holder");
        if (coursePageCountHolder == null) {
            com.up366.common.log.Logger.info("TAG - CoursePageCountHolder - load - create new holder : UID:" + com.up366.mobile.common.logic.Auth.UID());
            resetHolder(new com.up366.mobile.course.task.model.CoursePageCountHolder());
            com.up366.mobile.common.logic.Auth.cur().cache().put(CACHE_KEY, com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
            return com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder;
        }
        if (!coursePageCountHolder.equals(com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder) || coursePageCountHolder.hashCode() != com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.hashCode()) {
            resetHolder(coursePageCountHolder);
        }
        return com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder;
    }

    public void save() {
        com.up366.mobile.common.logic.Auth.cur().cache().put(CACHE_KEY, this, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.task.model.CoursePageCountHolder$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$save$0(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$save$0(int i) {
        com.up366.common.log.Logger.info("TAG - CoursePageCountHolder - save - " + toString());
    }

    private static void resetHolder(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.courseNum = coursePageCountHolder.courseNum;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.currentTaskNum = coursePageCountHolder.currentTaskNum;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.historyTaskNum = coursePageCountHolder.historyTaskNum;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.willExpireTaskNum = coursePageCountHolder.willExpireTaskNum;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.calendarWeekResult = coursePageCountHolder.calendarWeekResult;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.wordNoteNum = coursePageCountHolder.wordNoteNum;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.wrongNoteNum = coursePageCountHolder.wrongNoteNum;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.percent = coursePageCountHolder.percent;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.maxPercent = coursePageCountHolder.maxPercent;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.compareLast = coursePageCountHolder.compareLast;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.compareGlobal = coursePageCountHolder.compareGlobal;
        com.up366.mobile.course.task.model.CoursePageCountHolder.Instance.holder.hasShowAnimPercent = coursePageCountHolder.hasShowAnimPercent;
    }

    public int getCourseNum() {
        return this.courseNum;
    }

    public void setCourseNum(int i) {
        this.courseNum = i;
    }

    public int getCurrentTaskNum() {
        return this.currentTaskNum;
    }

    public void setCurrentTaskNum(int i) {
        this.currentTaskNum = i;
    }

    public int getHistoryTaskNum() {
        return this.historyTaskNum;
    }

    public int getTotalTaskNum() {
        return this.historyTaskNum + this.currentTaskNum;
    }

    public void setHistoryTaskNum(int i) {
        this.historyTaskNum = i;
    }

    public int getWillExpireTaskNum() {
        return this.willExpireTaskNum;
    }

    public void setWillExpireTaskNum(int i) {
        this.willExpireTaskNum = i;
    }

    public int getWordNoteNum() {
        return this.wordNoteNum;
    }

    public int getTotalNoteNum() {
        return this.wordNoteNum + this.wrongNoteNum;
    }

    public void setWordNoteNum(int i) {
        this.wordNoteNum = i;
    }

    public int getWrongNoteNum() {
        return this.wrongNoteNum;
    }

    public void setWrongNoteNum(int i) {
        this.wrongNoteNum = i;
    }

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

    public boolean isHasShowAnimPercent() {
        return this.hasShowAnimPercent;
    }

    public void setHasShowAnimPercent(boolean z) {
        this.hasShowAnimPercent = z;
    }

    public com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult getCalendarWeekResult() {
        return this.calendarWeekResult;
    }

    public int getCalendarWeekResultSize() {
        com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult calendarWeekResult = this.calendarWeekResult;
        if (calendarWeekResult == null) {
            return 0;
        }
        return calendarWeekResult.getTaskCount();
    }

    public java.lang.String getCalendarWeekDateRangeText() {
        com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult calendarWeekResult = this.calendarWeekResult;
        return calendarWeekResult == null ? "" : calendarWeekResult.getWeekDateRange();
    }

    public void setCalendarWeekResult(com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult calendarWeekResult) {
        this.calendarWeekResult = calendarWeekResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r5.calendarWeekResult == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            r1 = 0
            if (r5 == 0) goto L8a
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L13
            goto L8a
        L13:
            com.up366.mobile.course.task.model.CoursePageCountHolder r5 = (com.up366.mobile.course.task.model.CoursePageCountHolder) r5
            com.up366.mobile.course.task.TaskDataHelper$CalendarWeekResult r2 = r4.calendarWeekResult
            if (r2 == 0) goto L24
            com.up366.mobile.course.task.TaskDataHelper$CalendarWeekResult r3 = r5.calendarWeekResult
            if (r3 == 0) goto L24
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2b
            return r1
        L24:
            if (r2 != 0) goto L8a
            com.up366.mobile.course.task.TaskDataHelper$CalendarWeekResult r2 = r5.calendarWeekResult
            if (r2 == 0) goto L2b
            goto L8a
        L2b:
            int r2 = r4.courseNum
            int r3 = r5.courseNum
            if (r2 == r3) goto L32
            return r1
        L32:
            int r2 = r4.currentTaskNum
            int r3 = r5.currentTaskNum
            if (r2 == r3) goto L39
            return r1
        L39:
            int r2 = r4.historyTaskNum
            int r3 = r5.historyTaskNum
            if (r2 == r3) goto L40
            return r1
        L40:
            int r2 = r4.willExpireTaskNum
            int r3 = r5.willExpireTaskNum
            if (r2 == r3) goto L47
            return r1
        L47:
            int r2 = r4.wordNoteNum
            int r3 = r5.wordNoteNum
            if (r2 == r3) goto L4e
            return r1
        L4e:
            int r2 = r4.wrongNoteNum
            int r3 = r5.wrongNoteNum
            if (r2 == r3) goto L55
            return r1
        L55:
            float r2 = r5.percent
            float r3 = r4.percent
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 == 0) goto L60
            return r1
        L60:
            float r2 = r5.maxPercent
            float r3 = r4.maxPercent
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 == 0) goto L6b
            return r1
        L6b:
            float r2 = r5.compareLast
            float r3 = r4.compareLast
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 == 0) goto L76
            return r1
        L76:
            float r2 = r5.compareGlobal
            float r3 = r4.compareGlobal
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 == 0) goto L81
            return r1
        L81:
            boolean r2 = r4.hasShowAnimPercent
            boolean r5 = r5.hasShowAnimPercent
            if (r2 != r5) goto L88
            goto L89
        L88:
            r0 = r1
        L89:
            return r0
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.course.task.model.CoursePageCountHolder.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = this.courseNum * 31;
        com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult calendarWeekResult = this.calendarWeekResult;
        int iHashCode = (((((((((((i + (calendarWeekResult != null ? calendarWeekResult.hashCode() : 0)) * 31) + this.currentTaskNum) * 31) + this.historyTaskNum) * 31) + this.willExpireTaskNum) * 31) + this.wordNoteNum) * 31) + this.wrongNoteNum) * 31;
        float f = this.percent;
        int iFloatToIntBits = (iHashCode + (f != 0.0f ? java.lang.Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.maxPercent;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 != 0.0f ? java.lang.Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.compareLast;
        int iFloatToIntBits3 = (iFloatToIntBits2 + (f3 != 0.0f ? java.lang.Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.compareGlobal;
        return ((iFloatToIntBits3 + (f4 != 0.0f ? java.lang.Float.floatToIntBits(f4) : 0)) * 31) + (this.hasShowAnimPercent ? 1 : 0);
    }

    public java.lang.String toString() {
        return "CoursePageCountHolder{calendarWeekResult=" + this.calendarWeekResult + ", courseNum=" + this.courseNum + ", currentTaskNum=" + this.currentTaskNum + ", historyTaskNum=" + this.historyTaskNum + ", willExpireTaskNum=" + this.willExpireTaskNum + ", wordNoteNum=" + this.wordNoteNum + ", wrongNoteNum=" + this.wrongNoteNum + ", percent=" + this.percent + ", maxPercent=" + this.maxPercent + ", compareLast=" + this.compareLast + ", compareGlobal=" + this.compareGlobal + ", hasShowAnimPercent=" + this.hasShowAnimPercent + '}';
    }
}
