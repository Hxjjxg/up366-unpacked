package com.up366.greendao;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DaoSession extends org.greenrobot.greendao.AbstractDaoSession {
    private final com.up366.greendao.AsecSessionModelDao asecSessionModelDao;
    private final org.greenrobot.greendao.internal.DaoConfig asecSessionModelDaoConfig;
    private final com.up366.greendao.BatchUploadItemDao batchUploadItemDao;
    private final org.greenrobot.greendao.internal.DaoConfig batchUploadItemDaoConfig;
    private final com.up366.greendao.BatchUploadLogDao batchUploadLogDao;
    private final org.greenrobot.greendao.internal.DaoConfig batchUploadLogDaoConfig;
    private final com.up366.greendao.BookDetailInfoDao bookDetailInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig bookDetailInfoDaoConfig;
    private final com.up366.greendao.BookScheduleInfoDao bookScheduleInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig bookScheduleInfoDaoConfig;
    private final com.up366.greendao.BookTaskFinishedInfoDao bookTaskFinishedInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig bookTaskFinishedInfoDaoConfig;
    private final com.up366.greendao.BookTaskLogHistoryDao bookTaskLogHistoryDao;
    private final org.greenrobot.greendao.internal.DaoConfig bookTaskLogHistoryDaoConfig;
    private final com.up366.greendao.BookTaskLogV2Dao bookTaskLogV2Dao;
    private final org.greenrobot.greendao.internal.DaoConfig bookTaskLogV2DaoConfig;
    private final com.up366.greendao.ChapterInfoDao chapterInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig chapterInfoDaoConfig;
    private final com.up366.greendao.CourseBookInfoDao courseBookInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig courseBookInfoDaoConfig;
    private final com.up366.greendao.CourseBookPlanDao courseBookPlanDao;
    private final org.greenrobot.greendao.internal.DaoConfig courseBookPlanDaoConfig;
    private final com.up366.greendao.CourseInfoDao courseInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig courseInfoDaoConfig;
    private final com.up366.greendao.ExerciseDataDao exerciseDataDao;
    private final org.greenrobot.greendao.internal.DaoConfig exerciseDataDaoConfig;
    private final com.up366.greendao.FileMapInfoDao fileMapInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig fileMapInfoDaoConfig;
    private final com.up366.greendao.GoodsInfoDao goodsInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig goodsInfoDaoConfig;
    private final com.up366.greendao.MeTeachingClassDao meTeachingClassDao;
    private final org.greenrobot.greendao.internal.DaoConfig meTeachingClassDaoConfig;
    private final com.up366.greendao.MessagesDao messagesDao;
    private final org.greenrobot.greendao.internal.DaoConfig messagesDaoConfig;
    private final com.up366.greendao.ProductInfoDao productInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig productInfoDaoConfig;
    private final com.up366.greendao.RequestTimeObjectDao requestTimeObjectDao;
    private final org.greenrobot.greendao.internal.DaoConfig requestTimeObjectDaoConfig;
    private final com.up366.greendao.ReturnedInfoDao returnedInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig returnedInfoDaoConfig;
    private final com.up366.greendao.SpeechDataInfoDao speechDataInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig speechDataInfoDaoConfig;
    private final com.up366.greendao.StudyPlanInfoDao studyPlanInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig studyPlanInfoDaoConfig;
    private final com.up366.greendao.StudyTaskHistoryDao studyTaskHistoryDao;
    private final org.greenrobot.greendao.internal.DaoConfig studyTaskHistoryDaoConfig;
    private final com.up366.greendao.TaskCompletedInfoDao taskCompletedInfoDao;
    private final org.greenrobot.greendao.internal.DaoConfig taskCompletedInfoDaoConfig;
    private final com.up366.greendao.TaskInfoV2Dao taskInfoV2Dao;
    private final org.greenrobot.greendao.internal.DaoConfig taskInfoV2DaoConfig;
    private final com.up366.greendao.UserOrderDao userOrderDao;
    private final org.greenrobot.greendao.internal.DaoConfig userOrderDaoConfig;

    public DaoSession(org.greenrobot.greendao.database.Database database, org.greenrobot.greendao.identityscope.IdentityScopeType identityScopeType, java.util.Map<java.lang.Class<? extends org.greenrobot.greendao.AbstractDao<?, ?>>, org.greenrobot.greendao.internal.DaoConfig> map) {
        super(database);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone = map.get(com.up366.greendao.ExerciseDataDao.class).clone();
        this.exerciseDataDaoConfig = daoConfigClone;
        daoConfigClone.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone2 = map.get(com.up366.greendao.AsecSessionModelDao.class).clone();
        this.asecSessionModelDaoConfig = daoConfigClone2;
        daoConfigClone2.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone3 = map.get(com.up366.greendao.BookDetailInfoDao.class).clone();
        this.bookDetailInfoDaoConfig = daoConfigClone3;
        daoConfigClone3.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone4 = map.get(com.up366.greendao.BookScheduleInfoDao.class).clone();
        this.bookScheduleInfoDaoConfig = daoConfigClone4;
        daoConfigClone4.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone5 = map.get(com.up366.greendao.BookTaskFinishedInfoDao.class).clone();
        this.bookTaskFinishedInfoDaoConfig = daoConfigClone5;
        daoConfigClone5.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone6 = map.get(com.up366.greendao.BookTaskLogHistoryDao.class).clone();
        this.bookTaskLogHistoryDaoConfig = daoConfigClone6;
        daoConfigClone6.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone7 = map.get(com.up366.greendao.BookTaskLogV2Dao.class).clone();
        this.bookTaskLogV2DaoConfig = daoConfigClone7;
        daoConfigClone7.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone8 = map.get(com.up366.greendao.ChapterInfoDao.class).clone();
        this.chapterInfoDaoConfig = daoConfigClone8;
        daoConfigClone8.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone9 = map.get(com.up366.greendao.CourseBookPlanDao.class).clone();
        this.courseBookPlanDaoConfig = daoConfigClone9;
        daoConfigClone9.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone10 = map.get(com.up366.greendao.SpeechDataInfoDao.class).clone();
        this.speechDataInfoDaoConfig = daoConfigClone10;
        daoConfigClone10.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone11 = map.get(com.up366.greendao.StudyTaskHistoryDao.class).clone();
        this.studyTaskHistoryDaoConfig = daoConfigClone11;
        daoConfigClone11.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone12 = map.get(com.up366.greendao.RequestTimeObjectDao.class).clone();
        this.requestTimeObjectDaoConfig = daoConfigClone12;
        daoConfigClone12.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone13 = map.get(com.up366.greendao.BatchUploadItemDao.class).clone();
        this.batchUploadItemDaoConfig = daoConfigClone13;
        daoConfigClone13.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone14 = map.get(com.up366.greendao.BatchUploadLogDao.class).clone();
        this.batchUploadLogDaoConfig = daoConfigClone14;
        daoConfigClone14.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone15 = map.get(com.up366.greendao.MessagesDao.class).clone();
        this.messagesDaoConfig = daoConfigClone15;
        daoConfigClone15.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone16 = map.get(com.up366.greendao.ProductInfoDao.class).clone();
        this.productInfoDaoConfig = daoConfigClone16;
        daoConfigClone16.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone17 = map.get(com.up366.greendao.UserOrderDao.class).clone();
        this.userOrderDaoConfig = daoConfigClone17;
        daoConfigClone17.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone18 = map.get(com.up366.greendao.FileMapInfoDao.class).clone();
        this.fileMapInfoDaoConfig = daoConfigClone18;
        daoConfigClone18.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone19 = map.get(com.up366.greendao.CourseBookInfoDao.class).clone();
        this.courseBookInfoDaoConfig = daoConfigClone19;
        daoConfigClone19.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone20 = map.get(com.up366.greendao.CourseInfoDao.class).clone();
        this.courseInfoDaoConfig = daoConfigClone20;
        daoConfigClone20.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone21 = map.get(com.up366.greendao.TaskInfoV2Dao.class).clone();
        this.taskInfoV2DaoConfig = daoConfigClone21;
        daoConfigClone21.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone22 = map.get(com.up366.greendao.ReturnedInfoDao.class).clone();
        this.returnedInfoDaoConfig = daoConfigClone22;
        daoConfigClone22.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone23 = map.get(com.up366.greendao.StudyPlanInfoDao.class).clone();
        this.studyPlanInfoDaoConfig = daoConfigClone23;
        daoConfigClone23.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone24 = map.get(com.up366.greendao.TaskCompletedInfoDao.class).clone();
        this.taskCompletedInfoDaoConfig = daoConfigClone24;
        daoConfigClone24.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone25 = map.get(com.up366.greendao.GoodsInfoDao.class).clone();
        this.goodsInfoDaoConfig = daoConfigClone25;
        daoConfigClone25.initIdentityScope(identityScopeType);
        org.greenrobot.greendao.internal.DaoConfig daoConfigClone26 = map.get(com.up366.greendao.MeTeachingClassDao.class).clone();
        this.meTeachingClassDaoConfig = daoConfigClone26;
        daoConfigClone26.initIdentityScope(identityScopeType);
        com.up366.greendao.ExerciseDataDao exerciseDataDao = new com.up366.greendao.ExerciseDataDao(daoConfigClone, this);
        this.exerciseDataDao = exerciseDataDao;
        com.up366.greendao.AsecSessionModelDao asecSessionModelDao = new com.up366.greendao.AsecSessionModelDao(daoConfigClone2, this);
        this.asecSessionModelDao = asecSessionModelDao;
        com.up366.greendao.BookDetailInfoDao bookDetailInfoDao = new com.up366.greendao.BookDetailInfoDao(daoConfigClone3, this);
        this.bookDetailInfoDao = bookDetailInfoDao;
        com.up366.greendao.BookScheduleInfoDao bookScheduleInfoDao = new com.up366.greendao.BookScheduleInfoDao(daoConfigClone4, this);
        this.bookScheduleInfoDao = bookScheduleInfoDao;
        com.up366.greendao.BookTaskFinishedInfoDao bookTaskFinishedInfoDao = new com.up366.greendao.BookTaskFinishedInfoDao(daoConfigClone5, this);
        this.bookTaskFinishedInfoDao = bookTaskFinishedInfoDao;
        com.up366.greendao.BookTaskLogHistoryDao bookTaskLogHistoryDao = new com.up366.greendao.BookTaskLogHistoryDao(daoConfigClone6, this);
        this.bookTaskLogHistoryDao = bookTaskLogHistoryDao;
        com.up366.greendao.BookTaskLogV2Dao bookTaskLogV2Dao = new com.up366.greendao.BookTaskLogV2Dao(daoConfigClone7, this);
        this.bookTaskLogV2Dao = bookTaskLogV2Dao;
        com.up366.greendao.ChapterInfoDao chapterInfoDao = new com.up366.greendao.ChapterInfoDao(daoConfigClone8, this);
        this.chapterInfoDao = chapterInfoDao;
        com.up366.greendao.CourseBookPlanDao courseBookPlanDao = new com.up366.greendao.CourseBookPlanDao(daoConfigClone9, this);
        this.courseBookPlanDao = courseBookPlanDao;
        com.up366.greendao.SpeechDataInfoDao speechDataInfoDao = new com.up366.greendao.SpeechDataInfoDao(daoConfigClone10, this);
        this.speechDataInfoDao = speechDataInfoDao;
        com.up366.greendao.StudyTaskHistoryDao studyTaskHistoryDao = new com.up366.greendao.StudyTaskHistoryDao(daoConfigClone11, this);
        this.studyTaskHistoryDao = studyTaskHistoryDao;
        com.up366.greendao.RequestTimeObjectDao requestTimeObjectDao = new com.up366.greendao.RequestTimeObjectDao(daoConfigClone12, this);
        this.requestTimeObjectDao = requestTimeObjectDao;
        com.up366.greendao.BatchUploadItemDao batchUploadItemDao = new com.up366.greendao.BatchUploadItemDao(daoConfigClone13, this);
        this.batchUploadItemDao = batchUploadItemDao;
        com.up366.greendao.BatchUploadLogDao batchUploadLogDao = new com.up366.greendao.BatchUploadLogDao(daoConfigClone14, this);
        this.batchUploadLogDao = batchUploadLogDao;
        com.up366.greendao.MessagesDao messagesDao = new com.up366.greendao.MessagesDao(daoConfigClone15, this);
        this.messagesDao = messagesDao;
        com.up366.greendao.ProductInfoDao productInfoDao = new com.up366.greendao.ProductInfoDao(daoConfigClone16, this);
        this.productInfoDao = productInfoDao;
        com.up366.greendao.UserOrderDao userOrderDao = new com.up366.greendao.UserOrderDao(daoConfigClone17, this);
        this.userOrderDao = userOrderDao;
        com.up366.greendao.FileMapInfoDao fileMapInfoDao = new com.up366.greendao.FileMapInfoDao(daoConfigClone18, this);
        this.fileMapInfoDao = fileMapInfoDao;
        com.up366.greendao.CourseBookInfoDao courseBookInfoDao = new com.up366.greendao.CourseBookInfoDao(daoConfigClone19, this);
        this.courseBookInfoDao = courseBookInfoDao;
        com.up366.greendao.CourseInfoDao courseInfoDao = new com.up366.greendao.CourseInfoDao(daoConfigClone20, this);
        this.courseInfoDao = courseInfoDao;
        com.up366.greendao.TaskInfoV2Dao taskInfoV2Dao = new com.up366.greendao.TaskInfoV2Dao(daoConfigClone21, this);
        this.taskInfoV2Dao = taskInfoV2Dao;
        com.up366.greendao.ReturnedInfoDao returnedInfoDao = new com.up366.greendao.ReturnedInfoDao(daoConfigClone22, this);
        this.returnedInfoDao = returnedInfoDao;
        com.up366.greendao.StudyPlanInfoDao studyPlanInfoDao = new com.up366.greendao.StudyPlanInfoDao(daoConfigClone23, this);
        this.studyPlanInfoDao = studyPlanInfoDao;
        com.up366.greendao.TaskCompletedInfoDao taskCompletedInfoDao = new com.up366.greendao.TaskCompletedInfoDao(daoConfigClone24, this);
        this.taskCompletedInfoDao = taskCompletedInfoDao;
        com.up366.greendao.GoodsInfoDao goodsInfoDao = new com.up366.greendao.GoodsInfoDao(daoConfigClone25, this);
        this.goodsInfoDao = goodsInfoDao;
        com.up366.greendao.MeTeachingClassDao meTeachingClassDao = new com.up366.greendao.MeTeachingClassDao(daoConfigClone26, this);
        this.meTeachingClassDao = meTeachingClassDao;
        registerDao(com.up366.mobile.book.exercise.model.ExerciseData.class, exerciseDataDao);
        registerDao(com.up366.mobile.book.helper.recorder.AsecSessionModel.class, asecSessionModelDao);
        registerDao(com.up366.mobile.book.model.BookDetailInfo.class, bookDetailInfoDao);
        registerDao(com.up366.mobile.book.model.BookScheduleInfo.class, bookScheduleInfoDao);
        registerDao(com.up366.mobile.book.model.BookTaskFinishedInfo.class, bookTaskFinishedInfoDao);
        registerDao(com.up366.mobile.book.model.BookTaskLogHistory.class, bookTaskLogHistoryDao);
        registerDao(com.up366.mobile.book.model.BookTaskLogV2.class, bookTaskLogV2Dao);
        registerDao(com.up366.mobile.book.model.ChapterInfo.class, chapterInfoDao);
        registerDao(com.up366.mobile.book.model.CourseBookPlan.class, courseBookPlanDao);
        registerDao(com.up366.mobile.book.model.SpeechDataInfo.class, speechDataInfoDao);
        registerDao(com.up366.mobile.book.model.StudyTaskHistory.class, studyTaskHistoryDao);
        registerDao(com.up366.mobile.common.http.RequestTimeObject.class, requestTimeObjectDao);
        registerDao(com.up366.mobile.common.logic.log.model.BatchUploadItem.class, batchUploadItemDao);
        registerDao(com.up366.mobile.common.logic.log.model.BatchUploadLog.class, batchUploadLogDao);
        registerDao(com.up366.mobile.common.logic.model.Messages.class, messagesDao);
        registerDao(com.up366.mobile.common.logic.model.ProductInfo.class, productInfoDao);
        registerDao(com.up366.mobile.common.logic.model.UserOrder.class, userOrderDao);
        registerDao(com.up366.mobile.common.utils.alifile.FileMapInfo.class, fileMapInfoDao);
        registerDao(com.up366.mobile.course.mgr.CourseBookInfo.class, courseBookInfoDao);
        registerDao(com.up366.mobile.course.mgr.CourseInfo.class, courseInfoDao);
        registerDao(com.up366.mobile.course.task.TaskInfoV2.class, taskInfoV2Dao);
        registerDao(com.up366.mobile.course.task.model.ReturnedInfo.class, returnedInfoDao);
        registerDao(com.up366.mobile.course.task.model.StudyPlanInfo.class, studyPlanInfoDao);
        registerDao(com.up366.mobile.course.task.model.TaskCompletedInfo.class, taskCompletedInfoDao);
        registerDao(com.up366.mobile.market.GoodsInfo.class, goodsInfoDao);
        registerDao(com.up366.mobile.user.setting.MeTeachingClass.class, meTeachingClassDao);
    }

    public void clear() {
        this.exerciseDataDaoConfig.clearIdentityScope();
        this.asecSessionModelDaoConfig.clearIdentityScope();
        this.bookDetailInfoDaoConfig.clearIdentityScope();
        this.bookScheduleInfoDaoConfig.clearIdentityScope();
        this.bookTaskFinishedInfoDaoConfig.clearIdentityScope();
        this.bookTaskLogHistoryDaoConfig.clearIdentityScope();
        this.bookTaskLogV2DaoConfig.clearIdentityScope();
        this.chapterInfoDaoConfig.clearIdentityScope();
        this.courseBookPlanDaoConfig.clearIdentityScope();
        this.speechDataInfoDaoConfig.clearIdentityScope();
        this.studyTaskHistoryDaoConfig.clearIdentityScope();
        this.requestTimeObjectDaoConfig.clearIdentityScope();
        this.batchUploadItemDaoConfig.clearIdentityScope();
        this.batchUploadLogDaoConfig.clearIdentityScope();
        this.messagesDaoConfig.clearIdentityScope();
        this.productInfoDaoConfig.clearIdentityScope();
        this.userOrderDaoConfig.clearIdentityScope();
        this.fileMapInfoDaoConfig.clearIdentityScope();
        this.courseBookInfoDaoConfig.clearIdentityScope();
        this.courseInfoDaoConfig.clearIdentityScope();
        this.taskInfoV2DaoConfig.clearIdentityScope();
        this.returnedInfoDaoConfig.clearIdentityScope();
        this.studyPlanInfoDaoConfig.clearIdentityScope();
        this.taskCompletedInfoDaoConfig.clearIdentityScope();
        this.goodsInfoDaoConfig.clearIdentityScope();
        this.meTeachingClassDaoConfig.clearIdentityScope();
    }

    public com.up366.greendao.ExerciseDataDao getExerciseDataDao() {
        return this.exerciseDataDao;
    }

    public com.up366.greendao.AsecSessionModelDao getAsecSessionModelDao() {
        return this.asecSessionModelDao;
    }

    public com.up366.greendao.BookDetailInfoDao getBookDetailInfoDao() {
        return this.bookDetailInfoDao;
    }

    public com.up366.greendao.BookScheduleInfoDao getBookScheduleInfoDao() {
        return this.bookScheduleInfoDao;
    }

    public com.up366.greendao.BookTaskFinishedInfoDao getBookTaskFinishedInfoDao() {
        return this.bookTaskFinishedInfoDao;
    }

    public com.up366.greendao.BookTaskLogHistoryDao getBookTaskLogHistoryDao() {
        return this.bookTaskLogHistoryDao;
    }

    public com.up366.greendao.BookTaskLogV2Dao getBookTaskLogV2Dao() {
        return this.bookTaskLogV2Dao;
    }

    public com.up366.greendao.ChapterInfoDao getChapterInfoDao() {
        return this.chapterInfoDao;
    }

    public com.up366.greendao.CourseBookPlanDao getCourseBookPlanDao() {
        return this.courseBookPlanDao;
    }

    public com.up366.greendao.SpeechDataInfoDao getSpeechDataInfoDao() {
        return this.speechDataInfoDao;
    }

    public com.up366.greendao.StudyTaskHistoryDao getStudyTaskHistoryDao() {
        return this.studyTaskHistoryDao;
    }

    public com.up366.greendao.RequestTimeObjectDao getRequestTimeObjectDao() {
        return this.requestTimeObjectDao;
    }

    public com.up366.greendao.BatchUploadItemDao getBatchUploadItemDao() {
        return this.batchUploadItemDao;
    }

    public com.up366.greendao.BatchUploadLogDao getBatchUploadLogDao() {
        return this.batchUploadLogDao;
    }

    public com.up366.greendao.MessagesDao getMessagesDao() {
        return this.messagesDao;
    }

    public com.up366.greendao.ProductInfoDao getProductInfoDao() {
        return this.productInfoDao;
    }

    public com.up366.greendao.UserOrderDao getUserOrderDao() {
        return this.userOrderDao;
    }

    public com.up366.greendao.FileMapInfoDao getFileMapInfoDao() {
        return this.fileMapInfoDao;
    }

    public com.up366.greendao.CourseBookInfoDao getCourseBookInfoDao() {
        return this.courseBookInfoDao;
    }

    public com.up366.greendao.CourseInfoDao getCourseInfoDao() {
        return this.courseInfoDao;
    }

    public com.up366.greendao.TaskInfoV2Dao getTaskInfoV2Dao() {
        return this.taskInfoV2Dao;
    }

    public com.up366.greendao.ReturnedInfoDao getReturnedInfoDao() {
        return this.returnedInfoDao;
    }

    public com.up366.greendao.StudyPlanInfoDao getStudyPlanInfoDao() {
        return this.studyPlanInfoDao;
    }

    public com.up366.greendao.TaskCompletedInfoDao getTaskCompletedInfoDao() {
        return this.taskCompletedInfoDao;
    }

    public com.up366.greendao.GoodsInfoDao getGoodsInfoDao() {
        return this.goodsInfoDao;
    }

    public com.up366.greendao.MeTeachingClassDao getMeTeachingClassDao() {
        return this.meTeachingClassDao;
    }
}
