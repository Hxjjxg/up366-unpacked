package com.up366.mobile.course.mgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CourseInfo {
    public static final int DEFAULT_COURSE_ID = -1;
    private java.lang.String courseCode;
    private int courseId;
    private java.lang.String courseName;
    private int displayOrder;
    private int isGoods;
    private int isShelf;
    private int organId;
    private java.lang.Long rowId;
    private int stageId;
    private int subjectId;
    private transient boolean isFold = false;
    private transient boolean isCheck = false;
    private java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> books = new java.util.ArrayList();

    public CourseInfo(java.lang.Long l, int i, java.lang.String str, java.lang.String str2, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.rowId = l;
        this.courseId = i;
        this.courseCode = str;
        this.courseName = str2;
        this.isShelf = i2;
        this.organId = i3;
        this.stageId = i4;
        this.subjectId = i5;
        this.displayOrder = i6;
        this.isGoods = i7;
    }

    public CourseInfo() {
    }

    public CourseInfo(int i, java.lang.String str) {
        this.courseId = i;
        this.courseName = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public boolean isFold() {
        return this.isFold;
    }

    public void setIsFold(boolean z) {
        this.isFold = z;
    }

    public java.lang.String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(java.lang.String str) {
        this.courseName = str;
    }

    public java.lang.String getCourseCode() {
        return this.courseCode;
    }

    public void setCourseCode(java.lang.String str) {
        this.courseCode = str;
    }

    public int getStageId() {
        return this.stageId;
    }

    public void setStageId(int i) {
        this.stageId = i;
    }

    public int getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(int i) {
        this.subjectId = i;
    }

    public int getOrganId() {
        return this.organId;
    }

    public void setOrganId(int i) {
        this.organId = i;
    }

    public int getIsShelf() {
        return this.isShelf;
    }

    public void setIsShelf(int i) {
        this.isShelf = i;
    }

    public boolean isShelf() {
        return this.isShelf == 1;
    }

    public java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> getBooks() {
        return this.books;
    }

    public void setBooks(java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> list) {
        this.books = list;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public int getIsGoods() {
        return this.isGoods;
    }

    public void setIsGoods(int i) {
        this.isGoods = i;
    }

    public boolean isGoods() {
        return this.isGoods == 1;
    }

    public void setUpBookBuyStatus() {
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> list = this.books;
        if (list == null) {
            return;
        }
        java.util.Collections.sort(list, new java.util.Comparator<com.up366.mobile.course.mgr.CourseBookInfo>() { // from class: com.up366.mobile.course.mgr.CourseInfo.1
            @Override // java.util.Comparator
            public int compare(com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo, com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo2) {
                long lastStudyTime = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(courseBookInfo.getBookId()).getLastStudyTime();
                long lastStudyTime2 = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(courseBookInfo2.getBookId()).getLastStudyTime();
                return java.lang.Long.compare(java.lang.Math.max(lastStudyTime2, courseBookInfo2.getAddCourseTime()), java.lang.Math.max(lastStudyTime, courseBookInfo.getAddCourseTime()));
            }
        });
        for (com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo : this.books) {
            if (getIsShelf() == 1) {
                courseBookInfo.setEndTime(0L);
            } else if (com.up366.mobile.common.logic.Auth.cur().book().hasBuy(this.courseId, courseBookInfo.getBookId(), courseBookInfo.isGoods())) {
                com.up366.mobile.common.logic.model.ProductInfo productInfo = com.up366.mobile.common.logic.Auth.cur().book().getProductInfo(courseBookInfo.getBookId());
                if (productInfo != null) {
                    courseBookInfo.setEndTime(productInfo.getEndDate());
                } else {
                    courseBookInfo.setEndTime(0L);
                }
            } else {
                courseBookInfo.setEndTime(0L);
            }
        }
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public void setFold(boolean z) {
        this.isFold = z;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.mgr.CourseInfo courseInfo = (com.up366.mobile.course.mgr.CourseInfo) obj;
        if (this.courseId != courseInfo.courseId || this.isShelf != courseInfo.isShelf || this.organId != courseInfo.organId || this.stageId != courseInfo.stageId || this.subjectId != courseInfo.subjectId || this.displayOrder != courseInfo.displayOrder || this.isGoods != courseInfo.isGoods || this.isFold != courseInfo.isFold || this.isCheck != courseInfo.isCheck) {
            return false;
        }
        java.lang.Long l = this.rowId;
        if (l == null ? courseInfo.rowId != null : !l.equals(courseInfo.rowId)) {
            return false;
        }
        java.lang.String str = this.courseCode;
        if (str == null ? courseInfo.courseCode != null : !str.equals(courseInfo.courseCode)) {
            return false;
        }
        java.lang.String str2 = this.courseName;
        if (str2 == null ? courseInfo.courseName != null : !str2.equals(courseInfo.courseName)) {
            return false;
        }
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> list = this.books;
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> list2 = courseInfo.books;
        return list != null ? list.equals(list2) : list2 == null;
    }

    public int hashCode() {
        java.lang.Long l = this.rowId;
        int iHashCode = (((l != null ? l.hashCode() : 0) * 31) + this.courseId) * 31;
        java.lang.String str = this.courseCode;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.courseName;
        int iHashCode3 = (((((((((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.isShelf) * 31) + this.organId) * 31) + this.stageId) * 31) + this.subjectId) * 31) + this.displayOrder) * 31) + this.isGoods) * 31) + (this.isFold ? 1 : 0)) * 31) + (this.isCheck ? 1 : 0)) * 31;
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> list = this.books;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }
}
