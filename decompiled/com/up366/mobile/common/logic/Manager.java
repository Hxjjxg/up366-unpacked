package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Manager {
    private final io.objectbox.BoxStore boxStore;
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.AppCacheMgr appCacheMgr = new com.up366.mobile.common.logic.AppCacheMgr(this);
    private final com.up366.mobile.book.BookMgr bookMgr = new com.up366.mobile.book.BookMgr(this);
    private final com.up366.mobile.common.logic.PersonalMgr personalMgr = new com.up366.mobile.common.logic.PersonalMgr(this);
    private final com.up366.mobile.course.mgr.CourseMgr courseMgr = new com.up366.mobile.course.mgr.CourseMgr(this);
    private final com.up366.mobile.course.homework.HomeworkMgr homeworkMgr = new com.up366.mobile.course.homework.HomeworkMgr(this);
    private final com.up366.mobile.course.wrongnote.WrongNoteMgr wrongNoteMgr = new com.up366.mobile.course.wrongnote.WrongNoteMgr(this);
    private final com.up366.mobile.common.logic.FeedbackMgr feedbackMgr = new com.up366.mobile.common.logic.FeedbackMgr(this);
    private final com.up366.mobile.common.logic.log.LogMgr logMgr = new com.up366.mobile.common.logic.log.LogMgr(this);
    private final com.up366.mobile.jump.JumpMgr jumpMgr = new com.up366.mobile.jump.JumpMgr(this);
    private final com.up366.mobile.user.setting.clearcache.CacheMgr cacheMgr = new com.up366.mobile.user.setting.clearcache.CacheMgr(this);
    private final com.up366.mobile.common.logic.PicFlowMgr flowMgr = new com.up366.mobile.common.logic.PicFlowMgr();
    private final com.up366.mobile.book.BookLogMgr bookLogMgr = new com.up366.mobile.book.BookLogMgr(this);
    private final com.up366.mobile.book.BookProgressMgr bookProgressMgr = new com.up366.mobile.book.BookProgressMgr(this);
    private final com.up366.mobile.course.task.TaskMgr taskMgr = new com.up366.mobile.course.task.TaskMgr(this);
    private final com.up366.mobile.common.logic.TeachingClassMgr teachingClassMgr = new com.up366.mobile.common.logic.TeachingClassMgr(this);
    private final com.up366.mobile.common.logic.AppConfigMgr appConfigMgr = new com.up366.mobile.common.logic.AppConfigMgr(this);
    private final com.up366.mobile.common.logic.MeBookMgr meBookMgr = new com.up366.mobile.common.logic.MeBookMgr(this);
    private final com.up366.mobile.cloud.PrivateCloudMgr privateCloudMgr = new com.up366.mobile.cloud.PrivateCloudMgr(this);
    private final com.up366.mobile.common.utils.alifile.FileMgr fileMgr = new com.up366.mobile.common.utils.alifile.FileMgr(this);

    Manager(int i) {
        this.db = new com.up366.greendao.DaoMaster(com.up366.mobile.common.logic.db.DbConfig.getDb(i)) { // from class: com.up366.mobile.common.logic.Manager.1
            @Override // com.up366.greendao.DaoMaster
            /* JADX INFO: renamed from: newSession, reason: merged with bridge method [inline-methods] */
            public com.up366.greendao.DaoSession mo103newSession() {
                return new com.up366.greendao.DaoSession(this.db, org.greenrobot.greendao.identityscope.IdentityScopeType.Session, this.daoConfigMap) { // from class: com.up366.mobile.common.logic.Manager.1.1
                    public void runInTx(java.lang.Runnable runnable) {
                        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
                        super.runInTx(runnable);
                        long jUptimeMillis2 = android.os.SystemClock.uptimeMillis() - jUptimeMillis;
                        if (jUptimeMillis2 > com.igexin.push.config.c.s) {
                            com.up366.mobile.common.onlinelog.OpLog.report("runInTx-timeout", "runInTx - used time : " + jUptimeMillis2 + "\n\n" + android.util.Log.getStackTraceString(new java.lang.Throwable()));
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - Manager - runInTx - used time : ");
                            sb.append(jUptimeMillis2);
                            com.up366.common.log.Logger.warn(sb.toString(), new java.lang.Throwable());
                        }
                    }
                };
            }
        }.mo103newSession();
        this.boxStore = init(i);
    }

    public static io.objectbox.BoxStore init(int i) {
        return com.up366.mobile.book.MyObjectBox.builder().androidContext(com.up366.common.global.GB.get().getApplicationContext()).name(i + ".db").build();
    }

    public io.objectbox.BoxStore boxStore() {
        return this.boxStore;
    }

    public <T> io.objectbox.Box<T> getBox(java.lang.Class<T> cls) {
        return this.boxStore.boxFor(cls);
    }

    public com.up366.greendao.DaoSession db() {
        return this.db;
    }

    public com.up366.mobile.common.logic.DBUtil db1() {
        return new com.up366.mobile.common.logic.DBUtil(this.boxStore);
    }

    public com.up366.mobile.book.BookMgr book() {
        return this.bookMgr;
    }

    public com.up366.mobile.common.logic.PersonalMgr info() {
        return this.personalMgr;
    }

    public com.up366.mobile.course.mgr.CourseMgr course() {
        return this.courseMgr;
    }

    public com.up366.mobile.course.homework.HomeworkMgr homework() {
        return this.homeworkMgr;
    }

    public com.up366.mobile.course.wrongnote.WrongNoteMgr wrongnote() {
        return this.wrongNoteMgr;
    }

    public com.up366.mobile.common.logic.FeedbackMgr feedback() {
        return this.feedbackMgr;
    }

    public com.up366.mobile.common.logic.log.LogMgr logMgr() {
        return this.logMgr;
    }

    public com.up366.mobile.jump.JumpMgr getJumpMgr() {
        return this.jumpMgr;
    }

    public com.up366.mobile.user.setting.clearcache.CacheMgr getCacheMgr() {
        return this.cacheMgr;
    }

    public com.up366.mobile.common.logic.PicFlowMgr getFlowMgr() {
        return this.flowMgr;
    }

    public com.up366.mobile.book.BookLogMgr bookLog() {
        return this.bookLogMgr;
    }

    public com.up366.mobile.book.BookProgressMgr bookProgress() {
        return this.bookProgressMgr;
    }

    public com.up366.mobile.course.task.TaskMgr taskMgr() {
        return this.taskMgr;
    }

    public com.up366.mobile.common.logic.TeachingClassMgr teachingClassMgr() {
        return this.teachingClassMgr;
    }

    public com.up366.mobile.common.logic.AppCacheMgr cache() {
        return this.appCacheMgr;
    }

    public com.up366.mobile.common.logic.AppConfigMgr config() {
        return this.appConfigMgr;
    }

    public com.up366.mobile.common.logic.MeBookMgr meBookMgr() {
        return this.meBookMgr;
    }

    public com.up366.mobile.cloud.PrivateCloudMgr getPrivateCloudMgr() {
        return this.privateCloudMgr;
    }

    public com.up366.mobile.common.utils.alifile.FileMgr fileMgr() {
        return this.fileMgr;
    }
}
