package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrongDetailItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.CourseWrongDetailItemViewBinding binding;

    public WrongDetailItemView(android.content.Context context) {
        super(context);
        init();
    }

    public WrongDetailItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WrongDetailItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.binding = (com.up366.mobile.databinding.CourseWrongDetailItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_wrong_detail_item_view, this, true);
    }

    public void setInfo(final com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo, final com.up366.mobile.commonui.condition.ConditionModel conditionModel) {
        this.binding.typeName.setText(wrongNoteKnowledgeInfo.getqTypeName());
        this.binding.knowledgeName.setText(wrongNoteKnowledgeInfo.getKnowledgeName());
        this.binding.wrongCount.setText(java.lang.String.valueOf(wrongNoteKnowledgeInfo.getWrongTimes()));
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.WrongDetailItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setInfo$0(wrongNoteKnowledgeInfo, conditionModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setInfo$0(com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo wrongNoteKnowledgeInfo, com.up366.mobile.commonui.condition.ConditionModel conditionModel, android.view.View view) {
        android.content.Intent intent = new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("stageId", java.lang.Integer.valueOf(wrongNoteKnowledgeInfo.getStageId()));
        jSONObject.put("subjectId", java.lang.Integer.valueOf(wrongNoteKnowledgeInfo.getSubjectId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, wrongNoteKnowledgeInfo.getBookId());
        jSONObject.put("qtypeId", wrongNoteKnowledgeInfo.getqTypeId());
        jSONObject.put("knowledgeId", wrongNoteKnowledgeInfo.getKnowledgeId());
        jSONObject.put("knowledgeName", wrongNoteKnowledgeInfo.getKnowledgeName());
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        jSONObject.put("isKill", 0);
        jSONObject.put("killFlag", 0);
        jSONObject.put("fromJob", java.lang.Boolean.valueOf(wrongNoteKnowledgeInfo.getFromType() == 1));
        jSONObject.put("isCurJob", java.lang.Boolean.valueOf(wrongNoteKnowledgeInfo.isCurJob()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(wrongNoteKnowledgeInfo.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, wrongNoteKnowledgeInfo.getStudyTaskId());
        jSONObject.put("startTime", 0 == conditionModel.getBeginTime() ? "" : java.lang.Long.valueOf(conditionModel.getBeginTime()));
        jSONObject.put("endTime", 0 != conditionModel.getEndTime() ? java.lang.Long.valueOf(conditionModel.getEndTime()) : "");
        if (wrongNoteKnowledgeInfo.getAssignId() > 0) {
            jSONObject.put("assignId", java.lang.Integer.valueOf(wrongNoteKnowledgeInfo.getAssignId()));
        }
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.WRONG_NOTE_REVIEW);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        getContext().startActivity(intent);
    }
}
