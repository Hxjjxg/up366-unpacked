package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DifficultyLevelDialog implements android.view.View.OnClickListener {
    com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding binding;
    private com.up366.common.callback.ICallbackResponse<java.lang.Integer> mCallback;
    private androidx.appcompat.app.AlertDialog mDialog;
    private int mDifficultyLevel = 1;
    private int stageId;

    public DifficultyLevelDialog(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        this.stageId = 0;
        this.stageId = taskInfoV2.getExtParam().getStageId();
    }

    public void show(android.content.Context context, com.up366.common.callback.ICallbackResponse<java.lang.Integer> iCallbackResponse) {
        this.mCallback = iCallbackResponse;
        com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding difficultyLevelDialogLayoutBinding = (com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.difficulty_level_dialog_layout, (android.view.ViewGroup) null, false);
        this.binding = difficultyLevelDialogLayoutBinding;
        int i = this.stageId;
        if (i == 11321 || i == 2) {
            difficultyLevelDialogLayoutBinding.levelText1.setText("七年级上");
            this.binding.levelText2.setText("七年级下");
            this.binding.levelText3.setText("八年级上");
            this.binding.levelText4.setText("八年级下");
            this.binding.levelText5.setText("中考难度");
        }
        androidx.appcompat.app.AlertDialog alertDialogCreate = new androidx.appcompat.app.AlertDialog.Builder(context, 2132017829).create();
        this.mDialog = alertDialogCreate;
        android.view.Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable());
        }
        this.mDialog.setView(this.binding.getRoot());
        this.mDialog.show();
        initView();
    }

    private void initView() {
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.difficultyLevel1, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.difficultyLevel2, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.difficultyLevel3, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.difficultyLevel4, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.difficultyLevel5, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.radioButton1, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.radioButton2, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.radioButton3, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.radioButton4, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.radioButton5, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.btnConfirm, this);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.btnClose, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1067)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r3) {
        /*
            r2 = this;
            int r3 = r3.getId()
            r0 = 2131362020(0x7f0a00e4, float:1.8343809E38)
            if (r3 == r0) goto L96
            r0 = 2131362022(0x7f0a00e6, float:1.8343813E38)
            if (r3 == r0) goto L82
            r0 = -1575169(0xffffffffffe7f6ff, float:NaN)
            r1 = 1
            switch(r3) {
                case 2131362280: goto L6e;
                case 2131362281: goto L59;
                case 2131362282: goto L44;
                case 2131362283: goto L2f;
                case 2131362284: goto L1a;
                default: goto L15;
            }
        L15:
            switch(r3) {
                case 2131363053: goto L6e;
                case 2131363054: goto L59;
                case 2131363055: goto L44;
                case 2131363056: goto L2f;
                case 2131363057: goto L1a;
                default: goto L18;
            }
        L18:
            goto L9b
        L1a:
            r2.resetView()
            r3 = 5
            r2.mDifficultyLevel = r3
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RelativeLayout r3 = r3.difficultyLevel5
            r3.setBackgroundColor(r0)
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RadioButton r3 = r3.radioButton5
            r3.setChecked(r1)
            goto L9b
        L2f:
            r2.resetView()
            r3 = 4
            r2.mDifficultyLevel = r3
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RelativeLayout r3 = r3.difficultyLevel4
            r3.setBackgroundColor(r0)
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RadioButton r3 = r3.radioButton4
            r3.setChecked(r1)
            goto L9b
        L44:
            r2.resetView()
            r3 = 3
            r2.mDifficultyLevel = r3
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RelativeLayout r3 = r3.difficultyLevel3
            r3.setBackgroundColor(r0)
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RadioButton r3 = r3.radioButton3
            r3.setChecked(r1)
            goto L9b
        L59:
            r2.resetView()
            r3 = 2
            r2.mDifficultyLevel = r3
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RelativeLayout r3 = r3.difficultyLevel2
            r3.setBackgroundColor(r0)
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RadioButton r3 = r3.radioButton2
            r3.setChecked(r1)
            goto L9b
        L6e:
            r2.resetView()
            r2.mDifficultyLevel = r1
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RelativeLayout r3 = r3.difficultyLevel1
            r3.setBackgroundColor(r0)
            com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding r3 = r2.binding
            android.widget.RadioButton r3 = r3.radioButton1
            r3.setChecked(r1)
            goto L9b
        L82:
            com.up366.common.callback.ICallbackResponse<java.lang.Integer> r3 = r2.mCallback
            if (r3 == 0) goto L90
            int r0 = r2.mDifficultyLevel
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = 0
            r3.onResult(r1, r0)
        L90:
            androidx.appcompat.app.AlertDialog r3 = r2.mDialog
            r3.dismiss()
            goto L9b
        L96:
            androidx.appcompat.app.AlertDialog r3 = r2.mDialog
            r3.dismiss()
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.views.DifficultyLevelDialog.onClick(android.view.View):void");
    }

    private void resetView() {
        this.binding.radioButton1.setChecked(false);
        this.binding.radioButton2.setChecked(false);
        this.binding.radioButton3.setChecked(false);
        this.binding.radioButton4.setChecked(false);
        this.binding.radioButton5.setChecked(false);
        this.binding.difficultyLevel1.setBackgroundColor(-1);
        this.binding.difficultyLevel2.setBackgroundColor(-1);
        this.binding.difficultyLevel3.setBackgroundColor(-1);
        this.binding.difficultyLevel4.setBackgroundColor(-1);
        this.binding.difficultyLevel5.setBackgroundColor(-1);
    }
}
