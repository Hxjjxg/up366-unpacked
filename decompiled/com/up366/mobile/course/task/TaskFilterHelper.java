package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskFilterHelper {

    public class FilterResult {
        public java.util.List<com.up366.mobile.course.task.TaskInfoV2> currentTasks = new java.util.ArrayList();
        public java.util.List<com.up366.mobile.course.task.TaskInfoV2> historyTasks = new java.util.ArrayList();

        public FilterResult() {
        }
    }

    public com.up366.mobile.course.task.TaskFilterHelper.FilterResult filter(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan completedTaskAndStudyPlan) {
        java.util.ArrayList<com.up366.mobile.course.task.TaskInfoV2> arrayList = new java.util.ArrayList(list);
        com.up366.mobile.course.task.TaskFilterHelper.FilterResult filterResult = new com.up366.mobile.course.task.TaskFilterHelper.FilterResult();
        if (arrayList.isEmpty()) {
            return filterResult;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((com.up366.mobile.course.task.TaskInfoV2) it.next()).getExtParam().isHiddenTask()) {
                it.remove();
            }
        }
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> taskList = com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList();
        if (completedTaskAndStudyPlan == null) {
            for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : arrayList) {
                if (taskInfoV2.getEndTime() < com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) {
                    resetTaskState(taskInfoV2, null, taskList);
                    filterResult.currentTasks.add(taskInfoV2);
                } else {
                    filterResult.historyTasks.add(taskInfoV2);
                }
            }
            return filterResult;
        }
        java.util.List<com.up366.mobile.course.task.model.TaskCompletedInfo> finishedList = completedTaskAndStudyPlan.getFinishedList();
        java.util.List<com.up366.mobile.course.task.model.StudyPlanInfo> studyPlanList = completedTaskAndStudyPlan.getStudyPlanList();
        java.util.List<com.up366.mobile.course.task.model.ReturnedInfo> returnedList = completedTaskAndStudyPlan.getReturnedList();
        if (returnedList != null && !returnedList.isEmpty()) {
            for (com.up366.mobile.course.task.model.ReturnedInfo returnedInfo : returnedList) {
                java.util.Iterator it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 = (com.up366.mobile.course.task.TaskInfoV2) it2.next();
                        if (android.text.TextUtils.equals(returnedInfo.getStudyTaskId(), taskInfoV22.getJobId())) {
                            taskInfoV22.setReturnState(1);
                            taskInfoV22.setReturnCode(returnedInfo.getReturnCode());
                            break;
                        }
                    }
                }
            }
        }
        if (finishedList != null && !finishedList.isEmpty()) {
            java.util.Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                com.up366.mobile.course.task.TaskInfoV2 taskInfoV23 = (com.up366.mobile.course.task.TaskInfoV2) it3.next();
                com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfoFindCompletedInfo = findCompletedInfo(taskInfoV23, finishedList);
                if (taskCompletedInfoFindCompletedInfo != null && taskInfoV23.getReturnState() != 1) {
                    resetTaskState(taskInfoV23, taskCompletedInfoFindCompletedInfo, taskList);
                    filterResult.historyTasks.add(taskInfoV23);
                    it3.remove();
                } else {
                    resetTaskState(taskInfoV23, null, taskList);
                }
            }
        }
        java.util.Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV24 = (com.up366.mobile.course.task.TaskInfoV2) it4.next();
            if (taskInfoV24.getFlevel() != 0 && batchHasCompletedTask(taskInfoV24, filterResult.historyTasks)) {
                it4.remove();
            }
        }
        java.util.Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV25 = (com.up366.mobile.course.task.TaskInfoV2) it5.next();
            if (taskInfoV25.getFlevel() != 0) {
                com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfoFindPlan = findPlan(taskInfoV25, studyPlanList);
                if (studyPlanInfoFindPlan == null) {
                    it5.remove();
                } else {
                    if (taskInfoV25.getFlevel() == studyPlanInfoFindPlan.getFlevel()) {
                        filterResult.currentTasks.add(taskInfoV25);
                    }
                    it5.remove();
                }
            }
        }
        filterResult.currentTasks.addAll(arrayList);
        java.util.Iterator<com.up366.mobile.course.task.TaskInfoV2> it6 = filterResult.currentTasks.iterator();
        while (it6.hasNext()) {
            com.up366.mobile.course.task.TaskInfoV2 next = it6.next();
            if (next.getEndTime() < com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) {
                filterResult.historyTasks.add(next);
                it6.remove();
            }
        }
        java.util.Collections.sort(filterResult.currentTasks, new java.util.Comparator() { // from class: com.up366.mobile.course.task.TaskFilterHelper$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.course.task.TaskInfoV2) obj).getBeginTime(), ((com.up366.mobile.course.task.TaskInfoV2) obj2).getBeginTime());
            }
        });
        androidx.collection.LongSparseArray longSparseArray = new androidx.collection.LongSparseArray();
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV26 : filterResult.currentTasks) {
            if (longSparseArray.get(taskInfoV26.getStudyPlanId()) == null) {
                longSparseArray.put(taskInfoV26.getStudyPlanId(), new java.util.ArrayList());
            }
            ((java.util.List) longSparseArray.get(taskInfoV26.getStudyPlanId())).add(taskInfoV26);
        }
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        for (int i = 0; i < longSparseArray.size(); i++) {
            java.util.List list2 = (java.util.List) longSparseArray.valueAt(i);
            if (list2.size() != 1) {
                java.util.Iterator it7 = list2.iterator();
                boolean z = false;
                while (it7.hasNext()) {
                    com.up366.mobile.course.task.TaskInfoV2 taskInfoV27 = (com.up366.mobile.course.task.TaskInfoV2) it7.next();
                    if (taskInfoV27.isTimingTask()) {
                        if (taskInfoV27.getAriseTime() > currentNtpTimeInMillisecond) {
                            z = true;
                        }
                    } else if (z) {
                        it7.remove();
                    }
                }
            }
        }
        filterResult.currentTasks.clear();
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            filterResult.currentTasks.addAll((java.util.Collection) longSparseArray.valueAt(i2));
        }
        java.util.Collections.sort(filterResult.historyTasks, new java.util.Comparator() { // from class: com.up366.mobile.course.task.TaskFilterHelper$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.course.task.TaskInfoV2) obj2).getSubmitTime(), ((com.up366.mobile.course.task.TaskInfoV2) obj).getSubmitTime());
            }
        });
        if (filterResult.historyTasks.size() > 0) {
            com.up366.mobile.course.task.TaskInfoV2 taskInfoV28 = filterResult.historyTasks.get(0);
            if (taskInfoV28.getSubmitTime() > 0) {
                com.up366.mobile.course.task.TaskInfoV2.saveSubmitTaskId(taskInfoV28.getJobId());
            } else {
                com.up366.mobile.course.task.TaskInfoV2.saveSubmitTaskId("");
            }
        } else {
            com.up366.mobile.course.task.TaskInfoV2.saveSubmitTaskId("");
        }
        initNoAnswerStatus(filterResult.historyTasks);
        return filterResult;
    }

    public static void initNoAnswerStatus(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
            if (!taskInfoV2.isFinish() && taskInfoV2.getEndTime() < com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) {
                taskInfoV2.setHistoryNoAnswer(true);
            }
        }
    }

    private void resetTaskState(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo, java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> list) {
        if (taskInfoV2 == null) {
            return;
        }
        if (taskCompletedInfo != null) {
            taskInfoV2.setSubmitTime(taskCompletedInfo.getAddDate());
            taskInfoV2.setJobScore(taskCompletedInfo.getJobScore());
            taskInfoV2.setMarkStatus(taskCompletedInfo.getMarkStatus());
            taskInfoV2.setUploadStatus(2);
            taskInfoV2.getExtParam().setUid(taskCompletedInfo.getUid());
            taskInfoV2.getExtParam().setTaskStatus(1);
            taskInfoV2.getExtParam().setStuStatus(2);
            return;
        }
        taskInfoV2.setJobScore("");
        taskInfoV2.getExtParam().setTaskStatus(0);
        taskInfoV2.getExtParam().setStuStatus(0);
        taskInfoV2.setMarkStatus(0);
        taskInfoV2.setUploadStatus(-100);
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : list) {
            java.lang.String studyTaskId = batchUploadLog.getStudyTaskId();
            if (android.text.TextUtils.isEmpty(studyTaskId)) {
                if (android.text.TextUtils.equals(batchUploadLog.getRefKey(), taskInfoV2.getContentId()) && batchUploadLog.getState() == -1) {
                    taskInfoV2.setUploadStatus(-1);
                }
            } else if (android.text.TextUtils.equals(studyTaskId, taskInfoV2.getJobId()) && batchUploadLog.getState() == -1) {
                taskInfoV2.setUploadStatus(-1);
            }
        }
    }

    private boolean batchHasCompletedTask(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        if (list != null && !list.isEmpty()) {
            java.util.Iterator<com.up366.mobile.course.task.TaskInfoV2> it = list.iterator();
            while (it.hasNext()) {
                if (android.text.TextUtils.equals(it.next().getStudyTaskPid(), taskInfoV2.getStudyTaskPid())) {
                    return true;
                }
            }
        }
        return false;
    }

    private com.up366.mobile.course.task.model.StudyPlanInfo findPlan(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, java.util.List<com.up366.mobile.course.task.model.StudyPlanInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (com.up366.mobile.course.task.model.StudyPlanInfo studyPlanInfo : list) {
                if (taskInfoV2.getStudyPlanId() == studyPlanInfo.getStudyPlanId()) {
                    return studyPlanInfo;
                }
            }
        }
        return null;
    }

    private static com.up366.mobile.course.task.model.TaskCompletedInfo findCompletedInfo(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, java.util.List<com.up366.mobile.course.task.model.TaskCompletedInfo> list) {
        if (list != null && !list.isEmpty()) {
            for (com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo : list) {
                if (android.text.TextUtils.equals(taskInfoV2.getJobId(), taskCompletedInfo.getStudyTaskId())) {
                    return taskCompletedInfo;
                }
            }
        }
        return null;
    }

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> filterByCourseId(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, int i) {
        return filterByCourseInfo(list, new com.up366.mobile.course.mgr.CourseInfo(i, ""));
    }

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> filterByCourseInfo(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        if (list == null || list.isEmpty() || courseInfo == null) {
            return new java.util.ArrayList();
        }
        if (courseInfo.getCourseId() == -1) {
            return list;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((com.up366.mobile.course.task.TaskInfoV2) it.next()).getCourseId() != courseInfo.getCourseId()) {
                it.remove();
            }
        }
        return arrayList;
    }

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> filterByBookId(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, java.lang.String str) {
        if (list == null || list.isEmpty() || com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return new java.util.ArrayList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!android.text.TextUtils.equals(((com.up366.mobile.course.task.TaskInfoV2) it.next()).getExtParam().getBookId(), str)) {
                it.remove();
            }
        }
        return arrayList;
    }

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> filterByMonth(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, java.lang.String str) {
        if (list == null || list.isEmpty()) {
            return new java.util.ArrayList();
        }
        if (str == null || str.length() == 0) {
            str = com.up366.mobile.common.utils.TimeUtilsApp.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!android.text.TextUtils.equals(com.up366.mobile.common.utils.TimeUtilsApp.formatTime(((com.up366.mobile.course.task.TaskInfoV2) it.next()).getBeginTime(), "yyyy-MM"), str)) {
                it.remove();
            }
        }
        return arrayList;
    }

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> filterByTime(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, long j, long j2) {
        if (list == null || list.isEmpty()) {
            return new java.util.ArrayList();
        }
        if (j == 0 && j2 == 0) {
            return list;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
            if (taskInfoV2.getBeginTime() >= j && taskInfoV2.getBeginTime() <= j2) {
                arrayList.add(taskInfoV2);
            }
        }
        return arrayList;
    }

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> filterByCondition(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, com.up366.mobile.commonui.condition.ConditionModel conditionModel) {
        if (list == null || list.isEmpty()) {
            return new java.util.ArrayList();
        }
        if (conditionModel == null) {
            return list;
        }
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listSortTaskList = com.up366.mobile.course.task.TaskDataHelper.sortTaskList(filterByCourseId(list, conditionModel.getCourseId()), true);
        if (conditionModel.getBeginTime() == 0) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (listSortTaskList.size() != 0) {
                jCurrentTimeMillis = listSortTaskList.get(listSortTaskList.size() - 1).getBeginTime();
            }
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTimeInMillis(jCurrentTimeMillis);
            int i = calendar.get(2);
            calendar.set(5, calendar.getActualMaximum(5));
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(2, i - 2);
            calendar.set(5, 1);
            long timeInMillis2 = calendar.getTimeInMillis();
            conditionModel.setBeginTime(timeInMillis2);
            conditionModel.setResetBeginTime(timeInMillis2);
            conditionModel.setEndTime(timeInMillis);
            conditionModel.setResetEndTime(timeInMillis);
        }
        return filterByTime(listSortTaskList, conditionModel.getBeginTime(), conditionModel.getEndTime());
    }
}
