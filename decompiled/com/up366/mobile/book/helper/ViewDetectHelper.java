package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ViewDetectHelper {
    private static final int PAGE_STATE_PAUSE = 0;
    private static final int PAGE_STATE_RESUME = 1;
    private com.up366.mobile.book.studyviews.ChapterHtmlView chapterHtmlView;
    private com.up366.mobile.book.studyviews.ChapterListView chapterListView;
    private final com.up366.mobile.book.StudyActivity context;
    private boolean controlPageEventByOther;
    private int currentPageState = 1;
    private com.up366.mobile.book.dict.DictHtmlView dictHtmlView;
    private com.up366.mobile.book.exercise.ExerciseHtmlView exercisePage;
    private com.up366.mobile.book.exercise.ExerciseHtmlView schoolExercisePage;
    private com.up366.mobile.book.studyviews.StudyV1View studyV1View;
    private com.up366.mobile.book.studyviews.StudyV4View studyV4View;
    private com.up366.mobile.book.studyviews.StudyV6View studyV6View;
    private com.up366.mobile.book.studyviews.StudyV7View studyV7View;
    private com.up366.mobile.book.studyviews.StudyV8View studyV8View;
    private com.up366.mobile.book.studyviews.StudyV9View studyV9View;
    private com.up366.mobile.book.exercise.ExerciseHtmlView testChapterPage;

    public ViewDetectHelper(com.up366.mobile.book.StudyActivity studyActivity) {
        this.context = studyActivity;
    }

    public void onResume() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(10L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.ViewDetectHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onResume$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$0() throws java.lang.Exception {
        if (this.controlPageEventByOther) {
            return;
        }
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View == null || studyV6View.getRealVisibility() == 0) {
            com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
            if (studyV7View == null || studyV7View.getRealVisibility() == 0) {
                com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
                if (studyV8View == null || studyV8View.getRealVisibility() == 0) {
                    com.up366.mobile.book.studyviews.StudyV9View studyV9View = this.studyV9View;
                    if (studyV9View == null || studyV9View.getRealVisibility() == 0) {
                        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView = this.testChapterPage;
                        if (exerciseHtmlView == null || exerciseHtmlView.getRealVisibility() == 0) {
                            com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView2 = this.schoolExercisePage;
                            if (exerciseHtmlView2 == null || exerciseHtmlView2.getRealVisibility() == 0) {
                                com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView3 = this.exercisePage;
                                if (exerciseHtmlView3 == null || exerciseHtmlView3.getRealVisibility() == 0) {
                                    com.up366.mobile.book.dict.DictHtmlView dictHtmlView = this.dictHtmlView;
                                    if ((dictHtmlView == null || dictHtmlView.getRealVisibility() == 0) && this.currentPageState != 1) {
                                        this.currentPageState = 1;
                                        com.up366.mobile.book.studyviews.ChapterListView chapterListView = this.chapterListView;
                                        if (chapterListView != null) {
                                            chapterListView.refreshData();
                                        }
                                        com.up366.mobile.book.studyviews.ChapterHtmlView chapterHtmlView = this.chapterHtmlView;
                                        if (chapterHtmlView != null) {
                                            chapterHtmlView.onResumeBack();
                                        }
                                        com.up366.mobile.book.studyviews.StudyV1View studyV1View = this.studyV1View;
                                        if (studyV1View != null) {
                                            studyV1View.onResume();
                                        }
                                        com.up366.mobile.book.studyviews.StudyV4View studyV4View = this.studyV4View;
                                        if (studyV4View != null) {
                                            studyV4View.onResume();
                                        }
                                        com.up366.mobile.book.studyviews.StudyV6View studyV6View2 = this.studyV6View;
                                        if (studyV6View2 != null) {
                                            studyV6View2.onResume();
                                        }
                                        com.up366.mobile.book.studyviews.StudyV7View studyV7View2 = this.studyV7View;
                                        if (studyV7View2 != null) {
                                            studyV7View2.onResume();
                                        }
                                        com.up366.mobile.book.studyviews.StudyV8View studyV8View2 = this.studyV8View;
                                        if (studyV8View2 != null) {
                                            studyV8View2.onResume();
                                        }
                                        com.up366.mobile.book.studyviews.StudyV9View studyV9View2 = this.studyV9View;
                                        if (studyV9View2 != null) {
                                            studyV9View2.onResume();
                                        }
                                        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView4 = this.testChapterPage;
                                        if (exerciseHtmlView4 != null) {
                                            exerciseHtmlView4.onResume();
                                        }
                                        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView5 = this.schoolExercisePage;
                                        if (exerciseHtmlView5 != null) {
                                            exerciseHtmlView5.onResume();
                                        }
                                        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView6 = this.exercisePage;
                                        if (exerciseHtmlView6 != null) {
                                            exerciseHtmlView6.onResume();
                                        }
                                        com.up366.mobile.book.dict.DictHtmlView dictHtmlView2 = this.dictHtmlView;
                                        if (dictHtmlView2 != null) {
                                            dictHtmlView2.onResume();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void onPause() {
        if (com.up366.mobile.common.utils.PermissionUtils.onRequestPermissions || this.currentPageState == 0 || this.controlPageEventByOther) {
            return;
        }
        this.currentPageState = 0;
        com.up366.mobile.book.studyviews.ChapterHtmlView chapterHtmlView = this.chapterHtmlView;
        if (chapterHtmlView != null) {
            chapterHtmlView.onPause();
        }
        com.up366.mobile.book.studyviews.StudyV1View studyV1View = this.studyV1View;
        if (studyV1View != null) {
            studyV1View.onPause();
        }
        com.up366.mobile.book.studyviews.StudyV4View studyV4View = this.studyV4View;
        if (studyV4View != null) {
            studyV4View.onPause();
        }
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View != null) {
            studyV6View.onPause();
        }
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View != null) {
            studyV7View.onPause();
        }
        com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
        if (studyV8View != null) {
            studyV8View.onPause();
        }
        com.up366.mobile.book.studyviews.StudyV9View studyV9View = this.studyV9View;
        if (studyV9View != null) {
            studyV9View.onPause();
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView = this.testChapterPage;
        if (exerciseHtmlView != null) {
            exerciseHtmlView.onPause();
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView2 = this.schoolExercisePage;
        if (exerciseHtmlView2 != null) {
            exerciseHtmlView2.onPause();
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView3 = this.exercisePage;
        if (exerciseHtmlView3 != null) {
            exerciseHtmlView3.onPause();
        }
        com.up366.mobile.book.dict.DictHtmlView dictHtmlView = this.dictHtmlView;
        if (dictHtmlView != null) {
            dictHtmlView.onPause();
        }
    }

    public void onTopResumedActivityChanged(boolean z) {
        if (com.up366.mobile.common.utils.PermissionUtils.onRequestPermissions) {
            return;
        }
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View != null) {
            studyV6View.onTopResumedActivityChanged(z);
        }
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View != null) {
            studyV7View.onTopResumedActivityChanged(z);
        }
        com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
        if (studyV8View != null) {
            studyV8View.onTopResumedActivityChanged(z);
        }
        com.up366.mobile.book.studyviews.StudyV9View studyV9View = this.studyV9View;
        if (studyV9View != null) {
            studyV9View.onTopResumedActivityChanged(z);
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView = this.testChapterPage;
        if (exerciseHtmlView != null) {
            exerciseHtmlView.onTopResumedActivityChanged(z);
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView2 = this.schoolExercisePage;
        if (exerciseHtmlView2 != null) {
            exerciseHtmlView2.onTopResumedActivityChanged(z);
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView3 = this.exercisePage;
        if (exerciseHtmlView3 != null) {
            exerciseHtmlView3.onTopResumedActivityChanged(z);
        }
    }

    public boolean onBackPressed() {
        com.up366.mobile.book.studyviews.ChapterHtmlView chapterHtmlView = this.chapterHtmlView;
        if (chapterHtmlView != null) {
            return chapterHtmlView.onBackPressed();
        }
        com.up366.mobile.book.studyviews.StudyV1View studyV1View = this.studyV1View;
        if (studyV1View != null) {
            return studyV1View.onBackPress();
        }
        com.up366.mobile.book.studyviews.StudyV4View studyV4View = this.studyV4View;
        if (studyV4View != null) {
            return studyV4View.onBackPress();
        }
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View != null) {
            return studyV6View.onBackPress();
        }
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View != null) {
            return studyV7View.onBackPress();
        }
        com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
        if (studyV8View != null) {
            return studyV8View.onBackPress();
        }
        com.up366.mobile.book.studyviews.StudyV9View studyV9View = this.studyV9View;
        if (studyV9View != null) {
            return studyV9View.onBackPress();
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView = this.testChapterPage;
        if (exerciseHtmlView != null) {
            return exerciseHtmlView.onBackPress();
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView2 = this.schoolExercisePage;
        if (exerciseHtmlView2 != null) {
            return exerciseHtmlView2.onBackPress();
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView3 = this.exercisePage;
        if (exerciseHtmlView3 != null) {
            return exerciseHtmlView3.onBackPress();
        }
        com.up366.mobile.book.dict.DictHtmlView dictHtmlView = this.dictHtmlView;
        if (dictHtmlView != null) {
            return dictHtmlView.onBackPress();
        }
        return false;
    }

    public void onPageDestroy() {
        com.up366.mobile.book.studyviews.ChapterHtmlView chapterHtmlView = this.chapterHtmlView;
        if (chapterHtmlView != null) {
            chapterHtmlView.onPageDestroy();
            this.chapterHtmlView = null;
        }
        com.up366.mobile.book.studyviews.StudyV1View studyV1View = this.studyV1View;
        if (studyV1View != null) {
            studyV1View.onPageDestroy();
            this.studyV1View = null;
        }
        com.up366.mobile.book.studyviews.StudyV4View studyV4View = this.studyV4View;
        if (studyV4View != null) {
            studyV4View.onPageDestroy();
            this.studyV4View = null;
        }
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View != null) {
            studyV6View.onPageDestroy();
            this.studyV6View = null;
        }
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View != null) {
            studyV7View.onPageDestroy();
            this.studyV7View = null;
        }
        com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
        if (studyV8View != null) {
            studyV8View.onPageDestroy();
            this.studyV8View = null;
        }
        com.up366.mobile.book.studyviews.StudyV9View studyV9View = this.studyV9View;
        if (studyV9View != null) {
            studyV9View.onPageDestroy();
            this.studyV9View = null;
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView = this.testChapterPage;
        if (exerciseHtmlView != null) {
            exerciseHtmlView.onPageDestroy();
            this.testChapterPage = null;
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView2 = this.schoolExercisePage;
        if (exerciseHtmlView2 != null) {
            exerciseHtmlView2.onPageDestroy();
            this.schoolExercisePage = null;
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView3 = this.exercisePage;
        if (exerciseHtmlView3 != null) {
            exerciseHtmlView3.onPageDestroy();
            this.exercisePage = null;
        }
        com.up366.mobile.book.dict.DictHtmlView dictHtmlView = this.dictHtmlView;
        if (dictHtmlView != null) {
            dictHtmlView.onPageDestroy();
            this.dictHtmlView = null;
        }
    }

    public void show2016HtmlCatalog() {
        com.up366.mobile.book.studyviews.ChapterHtmlView chapterHtmlView = this.chapterHtmlView;
        if (chapterHtmlView == null) {
            this.chapterHtmlView = new com.up366.mobile.book.studyviews.ChapterHtmlView(this.context);
            this.context.container.addView(this.chapterHtmlView);
        } else {
            chapterHtmlView.refreshData();
        }
    }

    public void showStudyV6ExercisePage() {
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View == null) {
            this.studyV6View = new com.up366.mobile.book.studyviews.StudyV6View(this.context);
            this.context.container.addView(this.studyV6View);
        } else {
            studyV6View.refreshData();
        }
    }

    public void showAppCatalog() {
        com.up366.mobile.book.studyviews.ChapterListView chapterListView = this.chapterListView;
        if (chapterListView == null) {
            this.chapterListView = new com.up366.mobile.book.studyviews.ChapterListView(this.context);
            this.context.container.addView(this.chapterListView);
        } else {
            chapterListView.refreshData();
        }
    }

    public void show2019HtmlCatalog() {
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View == null) {
            this.studyV7View = new com.up366.mobile.book.studyviews.StudyV7View(this.context);
            this.context.container.addView(this.studyV7View);
        } else {
            studyV7View.refreshData();
        }
    }

    public void showStudyV7ExercisePage() {
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View == null) {
            this.studyV7View = new com.up366.mobile.book.studyviews.StudyV7View(this.context);
            this.context.container.addView(this.studyV7View);
        } else {
            studyV7View.refreshData();
        }
    }

    public void showStudyV1ExercisePage() {
        if (this.studyV1View == null) {
            this.studyV1View = new com.up366.mobile.book.studyviews.StudyV1View(this.context);
            this.context.container.addView(this.studyV1View);
        }
    }

    public void showStudyV4ExercisePage() {
        com.up366.mobile.book.studyviews.StudyV4View studyV4View = this.studyV4View;
        if (studyV4View == null) {
            this.studyV4View = new com.up366.mobile.book.studyviews.StudyV4View(this.context);
            this.context.container.addView(this.studyV4View);
        } else {
            studyV4View.refreshData();
        }
    }

    public void showTestChapterPage() {
        if (this.testChapterPage == null) {
            this.testChapterPage = new com.up366.mobile.book.exercise.ExerciseHtmlView(this.context);
            this.context.container.addView(this.testChapterPage);
            this.testChapterPage.setParams(1);
        }
    }

    public void showSchoolPage() {
        if (this.schoolExercisePage == null) {
            this.schoolExercisePage = new com.up366.mobile.book.exercise.ExerciseHtmlView(this.context);
            this.context.container.addView(this.schoolExercisePage);
            this.schoolExercisePage.setParams(0);
        }
    }

    public void showExercisePage() {
        if (this.exercisePage == null) {
            this.exercisePage = new com.up366.mobile.book.exercise.ExerciseHtmlView(this.context);
            this.context.container.addView(this.exercisePage);
            this.exercisePage.setParams();
        }
    }

    public void show2023CommonPage() {
        com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
        if (studyV8View == null) {
            this.studyV8View = new com.up366.mobile.book.studyviews.StudyV8View(this.context);
            this.context.container.addView(this.studyV8View);
        } else {
            studyV8View.refreshData();
        }
    }

    public void show2025CommonPage() {
        com.up366.mobile.book.studyviews.StudyV9View studyV9View = this.studyV9View;
        if (studyV9View == null) {
            this.studyV9View = new com.up366.mobile.book.studyviews.StudyV9View(this.context);
            this.context.container.addView(this.studyV9View);
        } else {
            studyV9View.refreshData();
        }
    }

    public void showDictPage() {
        com.up366.mobile.book.dict.DictHtmlView dictHtmlView = this.dictHtmlView;
        if (dictHtmlView == null) {
            this.dictHtmlView = new com.up366.mobile.book.dict.DictHtmlView(this.context);
            this.context.container.addView(this.dictHtmlView);
        } else {
            dictHtmlView.refreshData();
        }
    }

    public void resetPage() {
        if (this.chapterHtmlView != null) {
            this.context.container.removeView(this.chapterHtmlView);
            this.chapterHtmlView = null;
        }
        if (this.chapterListView != null) {
            this.context.container.removeView(this.chapterListView);
            this.chapterListView = null;
        }
        com.up366.mobile.book.studyviews.StudyV1View studyV1View = this.studyV1View;
        if (studyV1View != null) {
            studyV1View.onPause();
            this.studyV1View.onPageDestroy();
            this.context.container.removeView(this.studyV1View);
            this.studyV1View = null;
        }
        com.up366.mobile.book.studyviews.StudyV4View studyV4View = this.studyV4View;
        if (studyV4View != null) {
            studyV4View.onPause();
            this.studyV4View.onPageDestroy();
            this.context.container.removeView(this.studyV4View);
            this.studyV4View = null;
        }
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View != null) {
            studyV6View.onPause();
            this.studyV6View.onPageDestroy();
            this.context.container.removeView(this.studyV6View);
            this.studyV6View = null;
        }
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View != null) {
            studyV7View.onPause();
            this.studyV7View.onPageDestroy();
            this.context.container.removeView(this.studyV7View);
            this.studyV7View = null;
        }
        com.up366.mobile.book.studyviews.StudyV8View studyV8View = this.studyV8View;
        if (studyV8View != null) {
            studyV8View.onPause();
            this.studyV8View.onPageDestroy();
            this.context.container.removeView(this.studyV8View);
            this.studyV8View = null;
        }
        com.up366.mobile.book.studyviews.StudyV9View studyV9View = this.studyV9View;
        if (studyV9View != null) {
            studyV9View.onPause();
            this.studyV9View.onPageDestroy();
            this.context.container.removeView(this.studyV9View);
            this.studyV9View = null;
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView = this.testChapterPage;
        if (exerciseHtmlView != null) {
            exerciseHtmlView.onPause();
            this.testChapterPage.onPageDestroy();
            this.context.container.removeView(this.testChapterPage);
            this.testChapterPage = null;
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView2 = this.schoolExercisePage;
        if (exerciseHtmlView2 != null) {
            exerciseHtmlView2.onPause();
            this.schoolExercisePage.onPageDestroy();
            this.context.container.removeView(this.schoolExercisePage);
            this.schoolExercisePage = null;
        }
        com.up366.mobile.book.exercise.ExerciseHtmlView exerciseHtmlView3 = this.exercisePage;
        if (exerciseHtmlView3 != null) {
            exerciseHtmlView3.onPause();
            this.exercisePage.onPageDestroy();
            this.context.container.removeView(this.exercisePage);
            this.exercisePage = null;
        }
        com.up366.mobile.book.dict.DictHtmlView dictHtmlView = this.dictHtmlView;
        if (dictHtmlView != null) {
            dictHtmlView.onPause();
            this.dictHtmlView.onPageDestroy();
            this.context.container.removeView(this.dictHtmlView);
            this.dictHtmlView = null;
        }
    }

    public void controlPageEventByOther(boolean z) {
        this.controlPageEventByOther = z;
    }

    public boolean checkPageChangeV6() {
        com.up366.mobile.book.studyviews.StudyV6View studyV6View = this.studyV6View;
        if (studyV6View == null) {
            return false;
        }
        return studyV6View.checkPageChange();
    }

    public boolean checkPageChangeV7() {
        com.up366.mobile.book.studyviews.StudyV7View studyV7View = this.studyV7View;
        if (studyV7View == null) {
            return false;
        }
        return studyV7View.checkPageChange();
    }
}
