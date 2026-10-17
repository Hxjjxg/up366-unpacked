package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class UrlAllCourseJob {
    private java.util.List<com.up366.mobile.course.task.model.UrlAllCourseJob.CourseJobList> courseJobList;
    private java.lang.String version;

    public java.util.List<com.up366.mobile.course.task.TaskInfoV2> getAllTask() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.up366.mobile.course.task.model.UrlAllCourseJob.CourseJobList> list = this.courseJobList;
        if (list != null && !list.isEmpty()) {
            for (com.up366.mobile.course.task.model.UrlAllCourseJob.CourseJobList courseJobList : this.courseJobList) {
                arrayList.addAll(courseJobList.ownerTaskList);
                arrayList.addAll(courseJobList.allTaskList);
            }
        }
        return arrayList;
    }

    public java.util.List<com.up366.mobile.course.mgr.CourseInfo> getAllCourseList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.up366.mobile.course.task.model.UrlAllCourseJob.CourseJobList> list = this.courseJobList;
        if (list != null && !list.isEmpty()) {
            for (com.up366.mobile.course.task.model.UrlAllCourseJob.CourseJobList courseJobList : this.courseJobList) {
                com.up366.mobile.course.mgr.CourseInfo courseInfo = new com.up366.mobile.course.mgr.CourseInfo();
                courseInfo.setCourseId(courseJobList.getCourseId());
                courseInfo.setIsGoods(courseJobList.getCourseIsGoods());
                courseInfo.setCourseName(courseJobList.getCourseName());
                arrayList.add(courseInfo);
            }
        }
        return arrayList;
    }

    public static class CourseJobList {
        private java.util.List<com.up366.mobile.course.task.TaskInfoV2> allTaskList;
        private int courseId;
        private int courseIsGoods;
        private java.lang.String courseName;
        private java.util.List<com.up366.mobile.course.task.TaskInfoV2> ownerTaskList;

        public java.util.List<com.up366.mobile.course.task.TaskInfoV2> getAllTaskList() {
            return this.allTaskList;
        }

        public void setAllTaskList(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
            this.allTaskList = list;
        }

        public java.util.List<com.up366.mobile.course.task.TaskInfoV2> getOwnerTaskList() {
            return this.ownerTaskList;
        }

        public void setOwnerTaskList(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
            this.ownerTaskList = list;
        }

        public int getCourseId() {
            return this.courseId;
        }

        public void setCourseId(int i) {
            this.courseId = i;
        }

        public int getCourseIsGoods() {
            return this.courseIsGoods;
        }

        public void setCourseIsGoods(int i) {
            this.courseIsGoods = i;
        }

        public java.lang.String getCourseName() {
            return this.courseName;
        }

        public void setCourseName(java.lang.String str) {
            this.courseName = str;
        }
    }

    public java.util.List<com.up366.mobile.course.task.model.UrlAllCourseJob.CourseJobList> getCourseJobList() {
        return this.courseJobList;
    }

    public void setCourseJobList(java.util.List<com.up366.mobile.course.task.model.UrlAllCourseJob.CourseJobList> list) {
        this.courseJobList = list;
    }

    public java.lang.String getVersion() {
        return this.version;
    }

    public void setVersion(java.lang.String str) {
        this.version = str;
    }
}
