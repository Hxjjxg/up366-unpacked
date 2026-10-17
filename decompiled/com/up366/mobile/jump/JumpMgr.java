package com.up366.mobile.jump;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class JumpMgr {
    private com.up366.mobile.common.logic.Manager mManager;

    public JumpMgr(com.up366.mobile.common.logic.Manager manager) {
        this.mManager = manager;
    }

    public void getSkipPathFromWeb(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.getJumpPathInfo) { // from class: com.up366.mobile.jump.JumpMgr.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, str);
                super.initParams(map);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                iCallbackResponse.onResult(response, str2);
            }
        });
    }

    public void getDailySentenceCourseID(com.up366.common.callback.ICallbackResponse<java.lang.Integer> iCallbackResponse) {
        if (!com.up366.mobile.common.logic.Auth.isAuth() && iCallbackResponse != null) {
            iCallbackResponse.onResult(null, -1);
        } else {
            com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.jump.JumpMgr.AnonymousClass2(com.up366.mobile.common.http.HttpMgrUtils.getCourseListOfMy, iCallbackResponse));
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.jump.JumpMgr$2, reason: invalid class name */
    class AnonymousClass2 extends com.up366.common.http.RequestParams<java.lang.Integer> {
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(java.lang.String str, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$callback = iCallbackResponse;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.up366.common.http.RequestParams
        public java.lang.Integer handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            java.util.List array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.user.setting.MeTeachingClass.class);
            int iMax = -1;
            if (array.size() <= 0) {
                return -1;
            }
            java.util.Iterator it = array.iterator();
            while (it.hasNext()) {
                iMax = java.lang.Math.max(((com.up366.mobile.user.setting.MeTeachingClass) it.next()).getCourseId(), iMax);
            }
            return java.lang.Integer.valueOf(iMax);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(final com.up366.common.http.Response response, java.lang.Integer num) {
            super.onResponse(response, num);
            if (this.val$callback == null) {
                return;
            }
            if (!response.isError()) {
                this.val$callback.onResult(response, num);
            } else {
                final com.up366.common.callback.ICallbackResponse iCallbackResponse = this.val$callback;
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpMgr$2$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$onResponse$1(iCallbackResponse, response);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$1(final com.up366.common.callback.ICallbackResponse iCallbackResponse, final com.up366.common.http.Response response) throws java.lang.Exception {
            java.util.List listLoadAll = com.up366.mobile.jump.JumpMgr.this.mManager.db().getCourseInfoDao().loadAll();
            final int iMax = -1;
            if (listLoadAll.size() > 0) {
                java.util.Iterator it = listLoadAll.iterator();
                while (it.hasNext()) {
                    iMax = java.lang.Math.max(((com.up366.mobile.course.mgr.CourseInfo) it.next()).getCourseId(), iMax);
                }
            }
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpMgr$2$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackResponse.onResult(response, java.lang.Integer.valueOf(iMax));
                }
            });
        }
    }
}
