package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomSheetDialogTimeRangePicker {
    private static final java.lang.String TAG = "DialogTimeRangePicker";
    private com.up366.mobile.databinding.BottomDatePickerViewBinding b;
    private android.app.Activity context;
    private java.util.Date curDate;
    private long maxRange;
    private java.util.Date minDate = new java.util.Date(curMillis());
    private java.util.Date maxDate = new java.util.Date(curMillis());
    private java.util.Date curMinDate = new java.util.Date(curMillis());
    private java.util.Date curMaxDate = new java.util.Date(curMillis());
    private java.util.Date startDate = new java.util.Date(curMillis());
    private java.util.Date endDate = new java.util.Date(curMillis());
    java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault());

    public interface IOnSelectDateRange {
        void onResult(java.util.Date date, java.util.Date date2);
    }

    public BottomSheetDialogTimeRangePicker(android.app.Activity activity) {
        this.context = activity;
    }

    public com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker setMinDate(java.util.Date date) {
        this.minDate = date;
        this.curMinDate = date;
        return this;
    }

    public com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker setMaxDate(java.util.Date date) {
        this.maxDate = date;
        this.curMaxDate = date;
        return this;
    }

    public com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker setStartDate(java.util.Date date) {
        this.startDate = date;
        return this;
    }

    public com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker setEndDate(java.util.Date date) {
        this.endDate = date;
        return this;
    }

    public com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker setMaxRange(long j) {
        this.maxRange = j;
        return this;
    }

    public void show(final com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.IOnSelectDateRange iOnSelectDateRange) {
        final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(this.context);
        this.b = (com.up366.mobile.databinding.BottomDatePickerViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(this.context), com.up366.mobile.R.layout.bottom_date_picker_view, (android.view.ViewGroup) null, true);
        initView();
        if (this.startDate.before(this.minDate)) {
            this.startDate = this.minDate;
        }
        this.curDate = this.startDate;
        this.curMinDate = this.minDate;
        this.curMaxDate = this.endDate;
        java.util.Calendar.getInstance().setTime(this.curDate);
        this.b.wvSelectYear.setCurrentItem(diffYear(this.curMinDate, this.curDate));
        this.b.wvSelectMonth.setCurrentItem(diffMonth(this.curMinDate, this.curDate));
        this.b.wvSelectDay.setCurrentItem(diffDay(this.curMinDate, this.curDate));
        refreshNowDate();
        this.b.cancel.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                bottomSheetDialog.dismiss();
            }
        });
        this.b.ok.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$show$1(bottomSheetDialog, iOnSelectDateRange, view);
            }
        });
        android.view.View.OnTouchListener onTouchListener = new android.view.View.OnTouchListener() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.lambda$show$2(view, motionEvent);
            }
        };
        this.b.wvSelectYear.setOnTouchListener(onTouchListener);
        this.b.wvSelectMonth.setOnTouchListener(onTouchListener);
        this.b.wvSelectDay.setOnTouchListener(onTouchListener);
        com.contrarywind.adapter.WheelAdapter wheelAdapter = new com.contrarywind.adapter.WheelAdapter() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.1
            @Override // com.contrarywind.adapter.WheelAdapter
            public int indexOf(java.lang.Object obj) {
                return 0;
            }

            @Override // com.contrarywind.adapter.WheelAdapter
            public int getItemsCount() {
                com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker bottomSheetDialogTimeRangePicker = com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this;
                return bottomSheetDialogTimeRangePicker.diffYear(bottomSheetDialogTimeRangePicker.curMinDate, com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this.curMaxDate) + 1;
            }

            @Override // com.contrarywind.adapter.WheelAdapter
            public java.lang.Object getItem(int i) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this.curMinDate);
                calendar.add(1, i);
                return "  " + calendar.get(1);
            }
        };
        com.contrarywind.adapter.WheelAdapter wheelAdapter2 = new com.contrarywind.adapter.WheelAdapter() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.2
            @Override // com.contrarywind.adapter.WheelAdapter
            public int indexOf(java.lang.Object obj) {
                return 0;
            }

            @Override // com.contrarywind.adapter.WheelAdapter
            public int getItemsCount() {
                com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker bottomSheetDialogTimeRangePicker = com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this;
                return bottomSheetDialogTimeRangePicker.diffMonth(bottomSheetDialogTimeRangePicker.curMinDate, com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this.curMaxDate) + 1;
            }

            @Override // com.contrarywind.adapter.WheelAdapter
            public java.lang.Object getItem(int i) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this.curMinDate);
                calendar.add(2, i);
                return java.lang.String.format(java.util.Locale.getDefault(), "  %02d", java.lang.Integer.valueOf(calendar.get(2) + 1));
            }
        };
        com.contrarywind.adapter.WheelAdapter wheelAdapter3 = new com.contrarywind.adapter.WheelAdapter() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.3
            @Override // com.contrarywind.adapter.WheelAdapter
            public int indexOf(java.lang.Object obj) {
                return 0;
            }

            @Override // com.contrarywind.adapter.WheelAdapter
            public int getItemsCount() {
                com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker bottomSheetDialogTimeRangePicker = com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this;
                return bottomSheetDialogTimeRangePicker.diffDay(bottomSheetDialogTimeRangePicker.curMinDate, com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this.curMaxDate) + 1;
            }

            @Override // com.contrarywind.adapter.WheelAdapter
            public java.lang.Object getItem(int i) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.this.curMinDate);
                calendar.add(5, i);
                return java.lang.String.format(java.util.Locale.getDefault(), "  %02d", java.lang.Integer.valueOf(calendar.get(5)));
            }
        };
        this.b.wvSelectYear.setCyclic(false);
        this.b.wvSelectMonth.setCyclic(false);
        this.b.wvSelectDay.setCyclic(false);
        this.b.wvSelectYear.setGravity(3);
        this.b.wvSelectMonth.setGravity(3);
        this.b.wvSelectDay.setGravity(3);
        this.b.wvSelectYear.setAdapter(wheelAdapter);
        this.b.wvSelectMonth.setAdapter(wheelAdapter2);
        this.b.wvSelectDay.setAdapter(wheelAdapter3);
        this.b.wvSelectYear.setOnItemSelectedListener(new com.contrarywind.listener.OnItemSelectedListener() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker$$ExternalSyntheticLambda3
            @Override // com.contrarywind.listener.OnItemSelectedListener
            public final void onItemSelected(int i) {
                this.f$0.lambda$show$3(i);
            }
        });
        this.b.wvSelectMonth.setOnItemSelectedListener(new com.contrarywind.listener.OnItemSelectedListener() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker$$ExternalSyntheticLambda4
            @Override // com.contrarywind.listener.OnItemSelectedListener
            public final void onItemSelected(int i) {
                this.f$0.lambda$show$4(i);
            }
        });
        this.b.wvSelectDay.setOnItemSelectedListener(new com.contrarywind.listener.OnItemSelectedListener() { // from class: com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker$$ExternalSyntheticLambda5
            @Override // com.contrarywind.listener.OnItemSelectedListener
            public final void onItemSelected(int i) {
                this.f$0.lambda$show$5(i);
            }
        });
        this.curDate = this.startDate;
        initWheelView(this.b.wvSelectYear, this.b.wvSelectMonth, this.b.wvSelectDay);
        bottomSheetDialog.setContentView(this.b.getRoot());
        try {
            ((android.view.ViewGroup) this.b.getRoot().getParent()).setBackgroundResource(android.R.color.transparent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog, com.up366.mobile.common.views.BottomSheetDialogTimeRangePicker.IOnSelectDateRange iOnSelectDateRange, android.view.View view) {
        bottomSheetDialog.dismiss();
        java.util.Date time = com.up366.common.TimeUtils.parseTime(com.up366.mobile.common.utils.TimeUtilsApp.formatTime(this.endDate.getTime(), "yyyy-MM-dd") + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
        this.endDate = time;
        iOnSelectDateRange.onResult(this.startDate, time);
    }

    static /* synthetic */ boolean lambda$show$2(android.view.View view, android.view.MotionEvent motionEvent) {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        view.performClick();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$3(int i) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(this.curMinDate);
        calendar.add(1, i);
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTime(this.curMinDate);
        calendar2.add(5, this.b.wvSelectDay.getCurrentItem());
        calendar.set(2, calendar2.get(2));
        calendar.set(5, calendar2.get(5));
        this.curDate = calendar.getTime();
        checkDate();
        this.b.wvSelectMonth.setCurrentItem(diffMonth(this.curMinDate, this.curDate));
        this.b.wvSelectDay.setCurrentItem(diffDay(this.curMinDate, this.curDate));
        refreshNowDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$4(int i) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(this.curMinDate);
        calendar.add(2, i);
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTime(this.curMinDate);
        calendar2.add(5, this.b.wvSelectDay.getCurrentItem());
        calendar.set(5, calendar2.get(5));
        this.curDate = calendar.getTime();
        checkDate();
        this.b.wvSelectYear.setCurrentItem(diffYear(this.curMinDate, this.curDate));
        this.b.wvSelectDay.setCurrentItem(diffDay(this.curMinDate, this.curDate));
        refreshNowDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$5(int i) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(this.curMinDate);
        calendar.add(5, i);
        this.curDate = calendar.getTime();
        checkDate();
        this.b.wvSelectYear.setCurrentItem(diffYear(this.curMinDate, this.curDate));
        this.b.wvSelectMonth.setCurrentItem(diffMonth(this.curMinDate, this.curDate));
        refreshNowDate();
    }

    private void initView() {
        this.b.wvSelectYear.setDividerColor(-1);
        this.b.wvSelectYear.setTextColorCenter(-10715905);
        this.b.wvSelectYear.setTextSize(16.0f);
        this.b.wvSelectYear.setTextColorOut(3355443);
        this.b.wvSelectYear.setCyclic(false);
        this.b.wvSelectYear.setLineSpacingMultiplier(2.0f);
        this.b.wvSelectMonth.setDividerColor(-1);
        this.b.wvSelectMonth.setTextColorCenter(-10715905);
        this.b.wvSelectMonth.setTextSize(16.0f);
        this.b.wvSelectMonth.setTextColorOut(3355443);
        this.b.wvSelectMonth.setLineSpacingMultiplier(2.0f);
        this.b.wvSelectDay.setDividerColor(-1);
        this.b.wvSelectDay.setTextColorCenter(-10715905);
        this.b.wvSelectDay.setTextSize(16.0f);
        this.b.wvSelectDay.setTextColorOut(3355443);
        this.b.wvSelectDay.setLineSpacingMultiplier(2.0f);
    }

    private void checkDate() {
        if (this.curDate.getTime() < this.curMinDate.getTime()) {
            this.curDate = this.curMinDate;
        }
        if (this.curDate.getTime() > this.curMaxDate.getTime()) {
            this.curDate = this.curMaxDate;
        }
    }

    private void initWheelView(com.contrarywind.view.WheelView wheelView, com.contrarywind.view.WheelView wheelView2, com.contrarywind.view.WheelView wheelView3) {
        java.util.Calendar.getInstance().setTime(this.curDate);
        wheelView.setCurrentItem(diffYear(this.curMinDate, this.curDate));
        wheelView2.setCurrentItem(diffMonth(this.curMinDate, this.curDate));
        wheelView3.setCurrentItem(diffDay(this.curMinDate, this.curDate));
        refreshNowDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int diffDay(java.util.Date date, java.util.Date date2) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTime(date2);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return (int) ((((calendar2.getTime().getTime() / 1000) / 24) / 3600) - (((calendar.getTime().getTime() / 1000) / 24) / 3600));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int diffYear(java.util.Date date, java.util.Date date2) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(1);
        calendar.setTime(date2);
        return calendar.get(1) - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int diffMonth(java.util.Date date, java.util.Date date2) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTime(date2);
        int i = calendar.get(1);
        return (((calendar2.get(1) - i) * 12) + calendar2.get(2)) - calendar.get(2);
    }

    private void refreshNowDate() {
        java.util.Date date = this.curDate;
        this.startDate = date;
        this.endDate = date;
        if (this.maxRange > 0) {
            if (date.getTime() - this.startDate.getTime() > this.maxRange) {
                this.endDate = new java.util.Date(this.startDate.getTime() + this.maxRange);
            }
            if (this.endDate.getTime() < this.startDate.getTime()) {
                this.endDate = this.startDate;
            }
            if (this.endDate.getTime() - this.startDate.getTime() > this.maxRange) {
                this.startDate = new java.util.Date(this.endDate.getTime() - this.maxRange);
            }
            if (this.endDate.getTime() < this.startDate.getTime()) {
                this.startDate = this.endDate;
            }
        }
    }

    private long curMillis() {
        return com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }
}
