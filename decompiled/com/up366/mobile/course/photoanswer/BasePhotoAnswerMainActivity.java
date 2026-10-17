package com.up366.mobile.course.photoanswer;

/* JADX INFO: compiled from: BasePhotoAnswerMainActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\tH&¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/course/photoanswer/BasePhotoAnswerMainActivity;", "Lcom/up366/mobile/common/base/BaseActivity;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "getCurrentPageName", "", "onPageSelectedShow", "", "position", "", com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "setActivityIsShowing", "isShowing", "", "closePageImageShow", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BasePhotoAnswerMainActivity extends com.up366.mobile.common.base.BaseActivity implements com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback, android.view.View.OnClickListener {
    public abstract void closePageImageShow();

    public abstract void onPageSelectedShow(int position, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo page);

    public abstract void setActivityIsShowing(boolean isShowing);

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "smartroom_take_picture";
    }
}
