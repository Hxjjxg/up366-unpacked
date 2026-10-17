package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskDataHelper {
    private static final long ONE_DAY_TIME = 86400000;

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> filterCurrentTask(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        return (list == null || list.size() == 0) ? new java.util.ArrayList() : sortTaskList(handleListLockState(getAppearList(list)), false);
    }

    private static java.util.List<com.up366.mobile.course.task.TaskInfoV2> getAppearList(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : fillFollowTaskBatchNum(list)) {
            if (taskInfoV2.getBatchNum() <= 3) {
                arrayList.add(taskInfoV2);
            }
        }
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 : list) {
            if (taskInfoV22.isTimingTask() && taskInfoV22.getAriseTime() <= currentNtpTimeInMillisecond && !arrayList.contains(taskInfoV22)) {
                arrayList.add(taskInfoV22);
            }
        }
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.task.TaskDataHelper$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.course.task.TaskInfoV2) obj).getBeginTime(), ((com.up366.mobile.course.task.TaskInfoV2) obj2).getBeginTime());
            }
        });
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV23 : list) {
            if (taskInfoV23.isTimingTask()) {
                if (taskInfoV23.getAriseTime() <= com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() && taskInfoV23.getStudyPlanId() != 0) {
                    arrayMap.put(java.lang.Integer.valueOf(taskInfoV23.getStudyPlanId()), java.lang.Long.valueOf(taskInfoV23.getBeginTime()));
                }
            } else {
                java.lang.Long l = (java.lang.Long) arrayMap.get(java.lang.Integer.valueOf(taskInfoV23.getStudyPlanId()));
                if (l == null) {
                    arrayMap.put(java.lang.Integer.valueOf(taskInfoV23.getStudyPlanId()), java.lang.Long.valueOf(taskInfoV23.getBeginTime()));
                    if (!arrayList.contains(taskInfoV23)) {
                        arrayList.add(taskInfoV23);
                    }
                } else if (taskInfoV23.getBeginTime() <= l.longValue() && !arrayList.contains(taskInfoV23)) {
                    arrayList.add(taskInfoV23);
                }
            }
        }
        return arrayList;
    }

    private static long getDays(long j) {
        return com.up366.common.TimeUtils.parseTime(com.up366.common.TimeUtils.formatTime(j, "yyyy-MM-dd 00:00:00"), "yyyy-MM-dd 00:00:00").getTime() / 86400000;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.up366.mobile.course.task.TaskInfoV2> fillFollowTaskBatchNum(java.util.List<com.up366.mobile.course.task.TaskInfoV2> r11) {
        /*
            com.up366.mobile.course.task.TaskDataHelper$$ExternalSyntheticLambda0 r0 = new com.up366.mobile.course.task.TaskDataHelper$$ExternalSyntheticLambda0
            r0.<init>()
            java.util.Collections.sort(r11, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            androidx.collection.LongSparseArray r1 = new androidx.collection.LongSparseArray
            r1.<init>()
            java.util.Iterator r11 = r11.iterator()
        L16:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L49
            java.lang.Object r2 = r11.next()
            com.up366.mobile.course.task.TaskInfoV2 r2 = (com.up366.mobile.course.task.TaskInfoV2) r2
            int r3 = r2.getStudyPlanId()
            long r3 = (long) r3
            java.lang.Object r3 = r1.get(r3)
            if (r3 != 0) goto L3a
            int r3 = r2.getStudyPlanId()
            long r3 = (long) r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1.put(r3, r5)
        L3a:
            int r3 = r2.getStudyPlanId()
            long r3 = (long) r3
            java.lang.Object r3 = r1.get(r3)
            java.util.List r3 = (java.util.List) r3
            r3.add(r2)
            goto L16
        L49:
            r11 = 0
        L4a:
            int r2 = r1.size()
            if (r11 >= r2) goto Lc6
            com.up366.mobile.course.task.TaskInfoV2 r2 = new com.up366.mobile.course.task.TaskInfoV2
            r2.<init>()
            r3 = -10000(0xffffffffffffd8f0, float:NaN)
            r2.setStudyPlanId(r3)
            long r4 = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()
            r2.setBeginTime(r4)
            r4 = 1
            r2.setBatchNum(r4)
            java.lang.Object r5 = r1.valueAt(r11)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
        L6f:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto Lc3
            java.lang.Object r6 = r5.next()
            com.up366.mobile.course.task.TaskInfoV2 r6 = (com.up366.mobile.course.task.TaskInfoV2) r6
            long r7 = r2.getBeginTime()
            long r7 = getDays(r7)
            long r9 = r6.getBeginTime()
            long r9 = getDays(r9)
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 != 0) goto L97
            int r2 = r2.getBatchNum()
            r6.setBatchNum(r2)
            goto Lb8
        L97:
            if (r7 >= 0) goto La2
            int r7 = r2.getBatchNum()
            int r7 = r7 - r4
            r6.setBatchNum(r7)
            goto Lb9
        La2:
            int r7 = r2.getStudyPlanId()
            if (r7 != r3) goto Lb0
            int r2 = r2.getBatchNum()
            r6.setBatchNum(r2)
            goto Lb8
        Lb0:
            int r2 = r2.getBatchNum()
            int r2 = r2 + r4
            r6.setBatchNum(r2)
        Lb8:
            r2 = r6
        Lb9:
            boolean r7 = r6.isTimingTask()
            if (r7 != 0) goto L6f
            r0.add(r6)
            goto L6f
        Lc3:
            int r11 = r11 + 1
            goto L4a
        Lc6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.course.task.TaskDataHelper.fillFollowTaskBatchNum(java.util.List):java.util.List");
    }

    private static java.util.List<com.up366.mobile.course.task.TaskInfoV2> handleListLockState(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.task.TaskDataHelper$$ExternalSyntheticLambda3
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.course.task.TaskInfoV2) obj).getBeginTime(), ((com.up366.mobile.course.task.TaskInfoV2) obj2).getBeginTime());
            }
        });
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
            taskInfoV2.setHasStart(true);
            if (!taskInfoV2.isTimingTask() || taskInfoV2.getStudyPlanId() == 0) {
                java.lang.Long l = (java.lang.Long) arrayMap.get(java.lang.Integer.valueOf(taskInfoV2.getStudyPlanId()));
                if (l == null) {
                    arrayMap.put(java.lang.Integer.valueOf(taskInfoV2.getStudyPlanId()), java.lang.Long.valueOf(taskInfoV2.getBeginTime()));
                } else if (taskInfoV2.getBeginTime() > com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() && taskInfoV2.getBeginTime() > l.longValue() && (!taskInfoV2.isTimingTask() || taskInfoV2.getAriseTime() > com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond())) {
                    taskInfoV2.setHasStart(false);
                }
            } else if (taskInfoV2.getAriseTime() > com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() && taskInfoV2.getBeginTime() > com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) {
                taskInfoV2.setHasStart(false);
            } else {
                arrayMap.put(java.lang.Integer.valueOf(taskInfoV2.getStudyPlanId()), java.lang.Long.valueOf(taskInfoV2.getBeginTime()));
            }
        }
        return list;
    }

    public static java.util.List<com.up366.mobile.course.task.TaskInfoV2> sortTaskList(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, final boolean z) {
        if (list == null || list.size() == 0) {
            return new java.util.ArrayList();
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.task.TaskDataHelper$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.course.task.TaskDataHelper.lambda$sortTaskList$3(z, (com.up366.mobile.course.task.TaskInfoV2) obj, (com.up366.mobile.course.task.TaskInfoV2) obj2);
            }
        });
        return list;
    }

    static /* synthetic */ int lambda$sortTaskList$3(boolean z, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, com.up366.mobile.course.task.TaskInfoV2 taskInfoV22) {
        int iCompare = java.lang.Long.compare(taskInfoV2.getBeginTime(), taskInfoV22.getBeginTime());
        if (iCompare != 0) {
            return z ? iCompare : -iCompare;
        }
        int iCompare2 = java.lang.Integer.compare(taskInfoV2.getStudyPlanId(), taskInfoV22.getStudyPlanId());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        int iCompare3 = java.lang.Integer.compare(taskInfoV2.getAssignId(), taskInfoV22.getAssignId());
        if (iCompare3 != 0) {
            return iCompare3;
        }
        int iCompare4 = java.lang.Integer.compare(taskInfoV2.getDisplayOrder(), taskInfoV22.getDisplayOrder());
        return iCompare4 != 0 ? iCompare4 : taskInfoV2.getJobNamePinYin().compareTo(taskInfoV22.getJobNamePinYin());
    }

    public static java.lang.String getTimeStampString(long j) {
        return com.up366.common.TimeUtils.formatTime(j, "M月d日的练习");
    }

    private static java.util.List<com.up366.mobile.course.task.TaskInfoV2> getCanDoTask(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() != 0) {
            for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
                if (taskInfoV2 != null) {
                    if (!taskInfoV2.isHistory()) {
                        arrayList.add(taskInfoV2);
                    } else if (taskInfoV2.isHistoryNoAnswer() && taskInfoV2.getExtParam().isPastExerciseCanRetest()) {
                        arrayList.add(taskInfoV2);
                    }
                }
            }
        }
        return arrayList;
    }

    private static java.util.Map<java.lang.Integer, java.util.List<com.up366.mobile.course.task.TaskInfoV2>> getWeekTaskMap(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        java.lang.Integer numCalculateWeekNumber;
        java.util.HashMap map = new java.util.HashMap();
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
            if (taskInfoV2 != null && (numCalculateWeekNumber = calculateWeekNumber(taskInfoV2)) != null) {
                java.util.List arrayList = (java.util.List) map.get(numCalculateWeekNumber);
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                    map.put(numCalculateWeekNumber, arrayList);
                }
                arrayList.add(taskInfoV2);
            }
        }
        return map;
    }

    public static com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult filterCalendarWeekTask(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, java.util.List<com.up366.mobile.course.task.TaskInfoV2> list2) {
        java.lang.String str = "";
        if (!com.up366.mobile.common.logic.Auth.cur().config().isEnableH5TaskList()) {
            return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(new java.util.ArrayList(), str);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null) {
            arrayList.addAll(filterCurrentTask(list));
        }
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> canDoTask = getCanDoTask(arrayList);
        if (canDoTask.isEmpty()) {
            return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(new java.util.ArrayList(), str);
        }
        java.util.Map<java.lang.Integer, java.util.List<com.up366.mobile.course.task.TaskInfoV2>> weekTaskMap = getWeekTaskMap(canDoTask);
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        long todayEndTime = getTodayEndTime(currentNtpTimeInMillisecond);
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(todayEndTime);
        java.lang.Integer numCalculateWeekNumber = calculateWeekNumber(calendar);
        if (numCalculateWeekNumber == null) {
            return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(new java.util.ArrayList(), str);
        }
        if (weekTaskMap.containsKey(numCalculateWeekNumber) && checkContainsTask(weekTaskMap.get(numCalculateWeekNumber), todayEndTime, false)) {
            return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(weekTaskMap.get(numCalculateWeekNumber), getWeekDateRange(numCalculateWeekNumber.intValue()));
        }
        java.util.Iterator<java.lang.Integer> it = weekTaskMap.keySet().iterator();
        int i = -1;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue < numCalculateWeekNumber.intValue() && iIntValue > i) {
                i = iIntValue;
            }
        }
        if (i != -1 && checkContainsTask(weekTaskMap.get(java.lang.Integer.valueOf(i)), preMonthFirstTime(currentNtpTimeInMillisecond), true)) {
            return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(weekTaskMap.get(java.lang.Integer.valueOf(i)), getWeekDateRange(i));
        }
        if (weekTaskMap.get(numCalculateWeekNumber) != null) {
            return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(weekTaskMap.get(numCalculateWeekNumber), getWeekDateRange(numCalculateWeekNumber.intValue()));
        }
        java.util.Iterator<java.lang.Integer> it2 = weekTaskMap.keySet().iterator();
        int i2 = Integer.MAX_VALUE;
        while (it2.hasNext()) {
            int iIntValue2 = it2.next().intValue();
            if (iIntValue2 > numCalculateWeekNumber.intValue() && iIntValue2 < i2) {
                i2 = iIntValue2;
            }
        }
        if (i2 != Integer.MAX_VALUE && checkContainsTask(weekTaskMap.get(java.lang.Integer.valueOf(i2)), nextMonthLastTime(currentNtpTimeInMillisecond), false)) {
            return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(weekTaskMap.get(java.lang.Integer.valueOf(i2)), getWeekDateRange(i2));
        }
        return new com.up366.mobile.course.task.TaskDataHelper.CalendarWeekResult(new java.util.ArrayList(), str);
    }

    private static boolean checkContainsTask(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, long j, boolean z) {
        if (list != null && list.size() != 0) {
            for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
                if (taskInfoV2 != null) {
                    if (z) {
                        if (taskInfoV2.getBeginTime() > j) {
                            return true;
                        }
                    } else if (taskInfoV2.getBeginTime() <= j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static long preMonthFirstTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(2, -1);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long nextMonthLastTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(2, 1);
        calendar.set(5, calendar.getActualMaximum(5));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    private static long getTodayEndTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(j);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    private static java.lang.Integer calculateWeekNumber(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        if (taskInfoV2 == null || taskInfoV2.getBeginTime() <= 0) {
            return null;
        }
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(taskInfoV2.getBeginTime());
        return calculateWeekNumber(calendar);
    }

    private static java.lang.Integer calculateWeekNumber(java.util.Calendar calendar) {
        java.util.Calendar calendar2 = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        calendar2.set(1970, 0, 4, 0, 0, 0);
        calendar2.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis() - calendar2.getTimeInMillis();
        if (timeInMillis == Long.MIN_VALUE) {
            return null;
        }
        long j = timeInMillis / 86400000;
        if (timeInMillis % 86400000 != 0 && timeInMillis < 0) {
            j--;
        }
        return java.lang.Integer.valueOf((int) (j / 7));
    }

    private static java.lang.String getWeekDateRange(int i) {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        calendar.set(1970, 0, 4, 0, 0, 0);
        calendar.set(14, 0);
        java.util.Calendar calendar2 = (java.util.Calendar) calendar.clone();
        calendar2.add(6, i * 7);
        java.util.Calendar calendar3 = (java.util.Calendar) calendar2.clone();
        calendar3.add(6, 6);
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("M月d日", java.util.Locale.getDefault());
        return simpleDateFormat.format(calendar2.getTime()) + "-" + simpleDateFormat.format(calendar3.getTime());
    }

    public static class CalendarWeekResult {
        private java.util.List<com.up366.mobile.course.task.TaskInfoV2> targetTasks;
        private java.lang.String weekDateRange;

        public CalendarWeekResult() {
            this.targetTasks = new java.util.ArrayList();
            this.weekDateRange = "";
        }

        private CalendarWeekResult(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list, java.lang.String str) {
            this.targetTasks = list;
            this.weekDateRange = str;
        }

        public java.util.List<com.up366.mobile.course.task.TaskInfoV2> getTargetTasks() {
            return this.targetTasks;
        }

        public void setTargetTasks(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
            this.targetTasks = list;
        }

        public java.lang.String getWeekDateRange() {
            return this.weekDateRange;
        }

        public void setWeekDateRange(java.lang.String str) {
            this.weekDateRange = str;
        }

        public int getTaskCount() {
            java.util.List<com.up366.mobile.course.task.TaskInfoV2> list = this.targetTasks;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }
}
