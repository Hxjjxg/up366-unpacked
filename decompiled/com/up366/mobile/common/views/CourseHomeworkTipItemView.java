package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseHomeworkTipItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding b;

    public CourseHomeworkTipItemView(android.content.Context context) {
        this(context, null);
    }

    public CourseHomeworkTipItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CourseHomeworkTipItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.CourseHomeworkTipItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_homework_tip_item_view_layout, this, true);
        setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return this.f$0.lambda$new$0(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("circular-layout", new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()}, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS);
            performClick();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (com.up366.mobile.common.helper.GuideDialogHelper.getInst().isHasShow()) {
            return;
        }
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    public void setData(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        android.content.Context context = getContext();
        com.up366.mobile.common.utils.ViewUtil.gone(this.b.count, this.b.countSub, this.b.text, this.b.tip, this.b.tipArrow, this.b.textTip, this.b.btnStart);
        this.b.textTip.getLayoutParams().leftMargin = com.up366.common.DpUtilsUp.dp2px(120.0f);
        setOnClickListener(null);
        if (coursePageCountHolder.getCourseNum() == 0) {
            state1(context, coursePageCountHolder);
        } else if (coursePageCountHolder.getTotalTaskNum() > 0) {
            if (com.up366.mobile.common.logic.Auth.cur().config().isEnableH5TaskList()) {
                if (coursePageCountHolder.getCalendarWeekResultSize() > 0) {
                    state8(context, coursePageCountHolder);
                } else {
                    state4(context, coursePageCountHolder);
                }
            } else if (coursePageCountHolder.getCurrentTaskNum() > 0) {
                if (coursePageCountHolder.getWillExpireTaskNum() > 0) {
                    state2(context, coursePageCountHolder);
                } else {
                    state3(context, coursePageCountHolder);
                }
            } else if (coursePageCountHolder.getTotalNoteNum() > 0) {
                state4(context, coursePageCountHolder);
            } else {
                state5(context, coursePageCountHolder);
            }
        } else if (coursePageCountHolder.getTotalNoteNum() > 0 || com.up366.mobile.common.logic.Auth.cur().config().isEnableH5TaskList()) {
            state6(context, coursePageCountHolder);
        } else {
            state7(context, coursePageCountHolder);
        }
        if (com.up366.mobile.common.logic.Auth.isTourist()) {
            setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$setData$1(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$1(android.view.View view) {
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, com.up366.mobile.R.string.tip_tourist);
    }

    private void state1(android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.textTip, this.b.btnStart);
        this.b.textTip.setText("你当前还没有教学班请加入教学班哦~");
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.btnStart);
        } else {
            this.b.btnStart.setText("点击加入");
            setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$state1$2(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$state1$2(android.view.View view) {
        com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.openPage(getContext());
    }

    private void state2(android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.count, this.b.countSub, this.b.text);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.tip, this.b.tipArrow);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.btnStart);
        this.b.tip.setText(com.up366.common.StringUtils.format("有%d份练习快过期，请尽快作答!", java.lang.Integer.valueOf(coursePageCountHolder.getWillExpireTaskNum())));
        this.b.count.setText(java.lang.String.valueOf(coursePageCountHolder.getCurrentTaskNum()));
        this.b.btnStart.setText("开始学习");
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipTaskActivityEvent(0));
            }
        });
    }

    private void state3(android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.count, this.b.countSub, this.b.text);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.btnStart);
        this.b.btnStart.setText("开始学习");
        this.b.text.setText("待完成练习");
        this.b.count.setText(java.lang.String.valueOf(coursePageCountHolder.getCurrentTaskNum()));
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipTaskActivityEvent(0));
            }
        });
    }

    private void state4(android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.textTip);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.btnStart);
        this.b.textTip.setText("恭喜你！练习已完成~ 记得清空错题生词本哦~");
        this.b.btnStart.setText("开始学习");
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipTaskActivityEvent(0));
            }
        });
    }

    private void state5(android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.textTip);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.btnStart);
        this.b.textTip.setText("恭喜你！已经完成所有练习~ 错题本和生词本已空空如也~");
        this.b.btnStart.setText("查看历史");
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipTaskActivityEvent(1));
            }
        });
    }

    private void state6(final android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.textTip);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.btnStart);
        this.b.textTip.setText("当前还没有练习~ 去清空错题生词本吧！");
        this.b.btnStart.setText("开始学习");
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.task.TaskActivity.startTaskActivity(context);
            }
        });
    }

    private void state7(android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.textTip);
        this.b.textTip.setText("当前还没有练习~去瞅瞅同学们都在学习什么吧！");
    }

    private void state8(android.content.Context context, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.count, this.b.countSub, this.b.text);
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.btnStart);
        this.b.text.setText(coursePageCountHolder.getCalendarWeekDateRangeText() + "待完成练习");
        this.b.btnStart.setText("开始学习");
        this.b.count.setText(java.lang.String.valueOf(coursePageCountHolder.getCalendarWeekResultSize()));
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseHomeworkTipItemView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SkipTaskActivityEvent(0));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.StartShowGuideTipEvent startShowGuideTipEvent) {
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().addHomeWorkTip(this.b.itemBg);
        com.up366.mobile.common.helper.GuideDialogHelper.getInst().show(1);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AddGuideTipMaskEvent());
    }
}
