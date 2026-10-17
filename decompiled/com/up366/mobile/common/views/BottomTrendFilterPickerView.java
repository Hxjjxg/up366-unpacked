package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomTrendFilterPickerView extends android.widget.FrameLayout {
    public static final int TYPE_FILTER_END = 2;
    public static final int TYPE_FILTER_START = 1;
    private static final long yearLength = 31536000000L;
    private com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding binding;
    private java.lang.String endMonth;
    private java.lang.String endYear;
    private int filterType;
    private com.up366.mobile.common.views.BottomTrendFilterPickerView.SelectFilterCallback mCallback;
    private com.up366.view.wheelview.adapter.WheelAdapter<java.lang.String> monthAdapter;
    private java.lang.String[] months;
    private java.lang.String startMonth;
    private java.lang.String startYear;
    private com.up366.view.wheelview.adapter.WheelAdapter<java.lang.String> yearAdapter;
    private java.util.List<java.lang.String> years;

    public interface SelectFilterCallback {
        void onSelectFilter(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);
    }

    public BottomTrendFilterPickerView(android.content.Context context) {
        this(context, null);
    }

    public BottomTrendFilterPickerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomTrendFilterPickerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.filterType = 0;
        this.years = new java.util.ArrayList();
        this.months = new java.lang.String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        this.binding = (com.up366.mobile.databinding.ViewTrendFilterDayPickerBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.view_trend_filter_day_picker, this, true);
        initYears();
        initAdapter();
        initView();
    }

    private void initView() {
        this.binding.wvYear.setCyclic(false);
        this.binding.wvYear.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        this.binding.wvYear.setItemsVisibleCount(5);
        this.binding.wvYear.setTextRightPadding(com.up366.qmui.util.QMUIDisplayHelper.dpToPx(40));
        this.binding.wvYear.setAdapter(this.yearAdapter);
        this.binding.wvMonth.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        this.binding.wvMonth.setItemsVisibleCount(5);
        this.binding.wvMonth.setTextLiftPadding(com.up366.qmui.util.QMUIDisplayHelper.dpToPx(40));
        this.binding.wvMonth.setAdapter(this.monthAdapter);
        this.binding.btStartTime.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.BottomTrendFilterPickerView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        this.binding.btEndTime.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.BottomTrendFilterPickerView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.binding.bottomConfirm.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.BottomTrendFilterPickerView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
        this.binding.wvYear.setOnItemSelectedListener(new com.up366.view.wheelview.listener.OnItemSelectedListener() { // from class: com.up366.mobile.common.views.BottomTrendFilterPickerView$$ExternalSyntheticLambda3
            @Override // com.up366.view.wheelview.listener.OnItemSelectedListener
            public final void onItemSelected(int i) {
                this.f$0.lambda$initView$3(i);
            }
        });
        this.binding.wvMonth.setOnItemSelectedListener(new com.up366.view.wheelview.listener.OnItemSelectedListener() { // from class: com.up366.mobile.common.views.BottomTrendFilterPickerView$$ExternalSyntheticLambda4
            @Override // com.up366.view.wheelview.listener.OnItemSelectedListener
            public final void onItemSelected(int i) {
                this.f$0.lambda$initView$4(i);
            }
        });
        java.lang.String time = com.up366.common.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM");
        java.lang.String[] strArrSplit = time.split("-");
        java.lang.String str = strArrSplit[0];
        this.startYear = str;
        java.lang.String str2 = strArrSplit[1];
        this.startMonth = str2;
        this.endYear = str;
        this.endMonth = str2;
        this.binding.btStartTime.setText(time);
        this.binding.btEndTime.setText(time);
        this.binding.btStartTime.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        setCurrentFilterData(1, this.binding.btStartTime.getText().toString(), this.binding.btEndTime.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        setCurrentFilterData(2, this.binding.btStartTime.getText().toString(), this.binding.btEndTime.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        if (this.mCallback != null) {
            try {
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM");
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                java.util.Calendar calendar2 = java.util.Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(this.startYear + "-" + this.startMonth));
                calendar2.setTime(simpleDateFormat.parse(this.endYear + "-" + this.endMonth));
                if (calendar.getTimeInMillis() > calendar2.getTimeInMillis()) {
                    com.up366.mobile.common.utils.ToastPopupUtil.setParentView(this.binding.getRoot());
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.binding.bottomConfirm, "结束时间不能小于开始时间");
                    com.up366.mobile.common.utils.ToastPopupUtil.clearParentView();
                    return;
                }
                calendar.add(2, 5);
                if (calendar.getTimeInMillis() < calendar2.getTimeInMillis()) {
                    com.up366.mobile.common.utils.ToastPopupUtil.setParentView(this.binding.getRoot());
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.binding.bottomConfirm, "开始时间和结束时间\n的间隔不得大于6个月");
                    com.up366.mobile.common.utils.ToastPopupUtil.clearParentView();
                    return;
                }
                this.mCallback.onSelectFilter(this.startYear, this.startMonth, this.endYear, this.endMonth);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(int i) {
        handTimeSelect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(int i) {
        handTimeSelect();
    }

    private void handTimeSelect() {
        if (this.filterType == 1) {
            this.startYear = this.years.get(this.binding.wvYear.getCurrentItem());
            this.startMonth = this.months[this.binding.wvMonth.getCurrentItem()];
            if (com.up366.common.StringUtils.isEmptyOrNull(this.endYear) || com.up366.common.StringUtils.isEmptyOrNull(this.endMonth)) {
                this.endYear = this.startYear;
                this.endMonth = this.startMonth;
                this.binding.btEndTime.setText(this.endYear + "-" + this.endMonth);
            }
            this.binding.btStartTime.setText(this.startYear + "-" + this.startMonth);
            return;
        }
        this.endYear = this.years.get(this.binding.wvYear.getCurrentItem());
        this.endMonth = this.months[this.binding.wvMonth.getCurrentItem()];
        this.binding.btEndTime.setText(this.endYear + "-" + this.endMonth);
    }

    public void resetTaskTab() {
        this.binding.btStartTime.setTextColor(getResources().getColor(com.up366.mobile.R.color.c12));
        this.binding.btStartTime.setBackgroundResource(com.up366.mobile.R.drawable.btn_gray_background_5_radius);
        this.binding.btEndTime.setTextColor(getResources().getColor(com.up366.mobile.R.color.c12));
        this.binding.btEndTime.setBackgroundResource(com.up366.mobile.R.drawable.btn_gray_background_5_radius);
    }

    private void initYears() {
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        for (int i = 0; i < 19; i++) {
            this.years.add(com.up366.common.TimeUtils.formatTime(currentNtpTimeInMillisecond - (((long) i) * yearLength), "yyyy"));
        }
    }

    private void initAdapter() {
        this.yearAdapter = new com.up366.view.wheelview.adapter.WheelAdapter<java.lang.String>() { // from class: com.up366.mobile.common.views.BottomTrendFilterPickerView.1
            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public int indexOf(java.lang.String str) {
                return 0;
            }

            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public int getItemsCount() {
                return com.up366.mobile.common.views.BottomTrendFilterPickerView.this.years.size();
            }

            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public java.lang.String getItem(int i) {
                return (java.lang.String) com.up366.mobile.common.views.BottomTrendFilterPickerView.this.years.get(i);
            }
        };
        this.monthAdapter = new com.up366.view.wheelview.adapter.WheelAdapter<java.lang.String>() { // from class: com.up366.mobile.common.views.BottomTrendFilterPickerView.2
            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public int indexOf(java.lang.String str) {
                return 0;
            }

            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public int getItemsCount() {
                return com.up366.mobile.common.views.BottomTrendFilterPickerView.this.months.length;
            }

            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public java.lang.String getItem(int i) {
                return com.up366.mobile.common.views.BottomTrendFilterPickerView.this.months[i];
            }
        };
    }

    public void setCurrentFilterData(int i, java.lang.String str, java.lang.String str2) {
        java.lang.String[] strArrSplit;
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return;
        }
        if (i == 1) {
            strArrSplit = str.split("-");
        } else {
            strArrSplit = str2.split("-");
        }
        if (strArrSplit.length < 2) {
            return;
        }
        int i2 = 0;
        java.lang.String str3 = strArrSplit[0];
        java.lang.String str4 = strArrSplit[1];
        java.util.Iterator<java.lang.String> it = this.years.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            java.lang.String next = it.next();
            if (android.text.TextUtils.equals(str3, next)) {
                this.binding.wvYear.setCurrentItem(this.years.indexOf(next));
                break;
            }
        }
        while (true) {
            java.lang.String[] strArr = this.months;
            if (i2 >= strArr.length) {
                break;
            }
            if (android.text.TextUtils.equals(str4, strArr[i2])) {
                this.binding.wvMonth.setCurrentItem(i2);
                break;
            }
            i2++;
        }
        resetTaskTab();
        this.filterType = i;
        if (i == 1) {
            this.binding.btStartTime.setText(str);
            this.binding.btEndTime.setText(str2);
            this.binding.btStartTime.setTextColor(getResources().getColor(com.up366.mobile.R.color.c1));
        } else if (i == 2) {
            this.binding.btStartTime.setText(str);
            this.binding.btEndTime.setText(str2);
            this.binding.btEndTime.setTextColor(getResources().getColor(com.up366.mobile.R.color.c1));
        }
        this.binding.wvYear.onItemSelected();
    }

    public void setSelectFilterCallback(com.up366.mobile.common.views.BottomTrendFilterPickerView.SelectFilterCallback selectFilterCallback) {
        this.mCallback = selectFilterCallback;
    }

    public void setCloseViewListener(android.view.View.OnClickListener onClickListener) {
        this.binding.ibClose.setOnClickListener(onClickListener);
    }
}
