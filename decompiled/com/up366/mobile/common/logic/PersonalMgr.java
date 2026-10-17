package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PersonalMgr {
    public static final java.lang.String STUDY_CARD_COUNT_NEW = "STUDY_CARD_COUNT_NEW";
    public static final int TYPE_RECORD_CHECK = 2;
    public static final int TYPE_RECORD_UPLOAD = 1;
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;

    public PersonalMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public void fetchPersonInfo() {
        fetchPersonInfo(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RefreshUserInfo(response, com.up366.mobile.common.logic.Auth.getUserInfo()));
            }
        });
    }

    public void fetchPersonInfo(final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.GET_USER_INFO) { // from class: com.up366.mobile.common.logic.PersonalMgr.1
            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str) {
                com.up366.mobile.common.logic.user.UserInfo userInfo = com.up366.mobile.common.logic.Auth.getUserInfo();
                if (!response.isError()) {
                    userInfo.initWithJSONStr(str);
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RefreshUserInfo(response, userInfo));
                com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.INSTANCE.updateAccount(userInfo);
                iCallbackResponse.onResult(response, str);
            }
        });
    }

    public void fetchUserClassInfo() {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.common.logic.user.UserClassInfo>(com.up366.mobile.common.http.HttpMgrUtils.getUserClassInfo) { // from class: com.up366.mobile.common.logic.PersonalMgr.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.common.logic.user.UserClassInfo handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                com.up366.mobile.common.logic.user.UserClassInfo userClassInfo = (com.up366.mobile.common.logic.user.UserClassInfo) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.common.logic.user.UserClassInfo.class);
                com.up366.mobile.common.utils.PreferenceUtils.putText("UserClassInfo_" + userClassInfo.getUid(), str);
                com.up366.mobile.common.logic.Auth.getUserInfo().setClassName(userClassInfo.getClassName());
                com.up366.mobile.common.logic.Auth.getUserInfo().setClassId(userClassInfo.getClassId());
                com.up366.mobile.common.logic.Auth.getUserInfo().setClassCode(userClassInfo.getClassCode());
                return userClassInfo;
            }
        });
    }

    public void getVerificationCode(final java.lang.String str, final int i, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        final java.lang.String ut = com.up366.common.StringUtils.getUt(str, 33);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.SEND_VERIFY_CODE) { // from class: com.up366.mobile.common.logic.PersonalMgr.3
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put("ut", ut);
                map.put("checkExists", java.lang.Integer.valueOf(i));
                map.put("utype", java.lang.Short.valueOf(com.up366.mobile.common.logic.user.UserInfo.USER_TYPE_STUDENT));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                if (response.isError()) {
                    com.up366.common.log.Logger.error("TAG - PersonalMgr - onResponse - " + response);
                }
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void updateUserPhone(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.BINDING_PHONE) { // from class: com.up366.mobile.common.logic.PersonalMgr.4
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put("verifyCode", str2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void unBindUserPhone(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.UNBIND_PHONE) { // from class: com.up366.mobile.common.logic.PersonalMgr.5
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("mobile", str);
                map.put("verifyCode", str2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.common.log.Logger.info("TAG - PersonalMgr - onResponse - resp = [" + response + "], result = [" + obj + "]");
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void updateUserRealName(final java.lang.String str) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_USER_INFO) { // from class: com.up366.mobile.common.logic.PersonalMgr.6
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME, str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                if (!response.isError()) {
                    com.up366.mobile.common.logic.Auth.getUserInfo().setRealname(str);
                    com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.INSTANCE.updateAccount(com.up366.mobile.common.logic.Auth.getUserInfo());
                    com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
                }
                return super.handleResponse(response, str2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                if (response.getCode() == -9) {
                    com.up366.mobile.common.logic.Auth.getUserInfo().setRealname(str);
                    com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MeRealNameUpdateEvent(response));
            }
        });
    }

    public void loadMessageList() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadMessageList$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMessageList$1() throws java.lang.Exception {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MessageLoad(this.db.getMessagesDao().queryBuilder().orderDesc(new org.greenrobot.greendao.Property[]{com.up366.greendao.MessagesDao.Properties.SendTime}).list()));
    }

    public void fetchUserMessageList() {
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("fetchUserMessageList", new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchUserMessageList$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchUserMessageList$2() throws java.lang.Exception {
        loadMessageList();
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.Messages>>(com.up366.mobile.common.http.HttpMgrUtils.SELECT_MESSAGE_LIST) { // from class: com.up366.mobile.common.logic.PersonalMgr.7
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.Messages> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                com.up366.common.log.Logger.info("PersonalMgr fetchUserMessageList result = " + str);
                java.util.List array = com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.common.logic.model.Messages.class);
                com.up366.mobile.common.onlinelog.LocalLogTool.onReceiveMessages(array);
                if (array != null) {
                    com.up366.mobile.common.logic.PersonalMgr.this.db.getMessagesDao().insertOrReplaceInTx(array);
                }
                return com.up366.mobile.common.logic.PersonalMgr.this.db.getMessagesDao().queryBuilder().orderDesc(new org.greenrobot.greendao.Property[]{com.up366.greendao.MessagesDao.Properties.SendTime}).list();
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MessageLoad(response, list));
            }
        });
    }

    private void loadMessageInfo(final java.lang.String str, int i) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadMessageInfo$3(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMessageInfo$3(java.lang.String str) throws java.lang.Exception {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MessageInfoLoad((com.up366.mobile.common.logic.model.Messages) this.db.getMessagesDao().queryBuilder().where(com.up366.greendao.MessagesDao.Properties.PushId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).unique()));
    }

    public void fetchUserMessageInfo(final java.lang.String str, final int i) {
        loadMessageInfo(str, i);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.common.logic.model.Messages>(com.up366.mobile.common.http.HttpMgrUtils.SELECT_MESSAGE_INFO) { // from class: com.up366.mobile.common.logic.PersonalMgr.8
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("msgId", str);
                map.put("type", java.lang.Integer.valueOf(i));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.common.logic.model.Messages handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return (com.up366.mobile.common.logic.model.Messages) com.alibaba.fastjson.JSON.parseObject(str2, com.up366.mobile.common.logic.model.Messages.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.Messages messages) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MessageInfoLoad(response, messages));
            }
        });
    }

    public void updateMessage(final com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateMessage$4(messages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMessage$4(com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Exception {
        this.db.insertOrReplace(messages);
        updateMarkRead(messages);
    }

    public void updateMarkRead(final com.up366.mobile.common.logic.model.Messages messages) {
        if (messages == null) {
            return;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_ONE_MESSAGE_READED) { // from class: com.up366.mobile.common.logic.PersonalMgr.9
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("msgId", messages.getMsgId());
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                if (response.isError()) {
                    com.up366.common.log.Logger.error("updateMarkRead error:" + response.getInfo());
                }
            }
        });
    }

    public void updateMarkReadAllMessage(final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_ALL_MESSAGE_READED) { // from class: com.up366.mobile.common.logic.PersonalMgr.10
            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void saveUserMessage(com.up366.mobile.common.logic.model.Messages messages) {
        this.db.insertOrReplace(messages);
    }

    public void uploadClientId() {
        java.lang.String uuid = com.up366.mobile.common.logic.Auth.getUserInfo().getUuid();
        final java.lang.String clientid = com.igexin.sdk.PushManager.getInstance().getClientid(com.up366.common.global.GB.get().getApplicationContext());
        if (com.up366.common.StringUtils.isEmptyOrNull(uuid) || com.up366.common.StringUtils.isEmptyOrNull(clientid)) {
            com.up366.common.log.Logger.error("upload user clientid error " + uuid + "  clientId " + clientid);
            return;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_USER_CLIENT_ID) { // from class: com.up366.mobile.common.logic.PersonalMgr.11
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("clientType", 1);
                map.put("clientId", clientid);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str) {
                if (response.isError()) {
                    com.up366.common.log.Logger.error("uploadClientId error:" + response.getInfo() + " client id " + clientid);
                    return;
                }
                com.up366.mobile.common.utils.PreferenceUtils.putLong("uploadClientId", com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            }
        });
    }

    public long getLastUploadClientTime() {
        return com.up366.mobile.common.utils.PreferenceUtils.getLong("uploadClientId", com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
    }

    public void deleteMessages(final com.up366.mobile.common.logic.model.Messages messages) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$deleteMessages$5(messages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteMessages$5(com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Exception {
        this.db.getMessagesDao().deleteInTx(new com.up366.mobile.common.logic.model.Messages[]{messages});
        loadMessageList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAll$6(java.util.List list) throws java.lang.Exception {
        this.db.getMessagesDao().insertOrReplaceInTx(list);
    }

    public void updateAll(final java.util.List<com.up366.mobile.common.logic.model.Messages> list) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateAll$6(list);
            }
        });
    }

    public java.util.List<com.up366.mobile.common.logic.model.UserParent> loadParentList() {
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("UserParent" + com.up366.mobile.common.logic.Auth.UID(), "");
        if (android.text.TextUtils.isEmpty(string)) {
            return new java.util.ArrayList();
        }
        return com.alibaba.fastjson.JSON.parseArray(string, com.up366.mobile.common.logic.model.UserParent.class);
    }

    public void fetchBindingParentList(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.UserParent>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.UserParent>>(com.up366.mobile.common.http.HttpMgrUtils.GET_BINDING_PARENT) { // from class: com.up366.mobile.common.logic.PersonalMgr.12
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.UserParent> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                com.up366.mobile.common.utils.PreferenceUtils.putStringSync("UserParent" + com.up366.mobile.common.logic.Auth.UID(), str);
                return com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.common.logic.model.UserParent.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.UserParent> list) {
                response.setCode(0);
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                if (iCallbackResponse2 != null) {
                    iCallbackResponse2.onResult(response, list);
                }
            }
        });
    }

    public void fetchParentQcode() {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.ParentQcode>>(com.up366.mobile.common.http.HttpMgrUtils.WECHRT_QCODE) { // from class: com.up366.mobile.common.logic.PersonalMgr.13
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.ParentQcode> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.common.logic.model.ParentQcode.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.ParentQcode> list) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (list != null) {
                    arrayList.add(new com.up366.mobile.common.logic.model.ParentQcodeResponse(response, list.get(0).initDefaultData()));
                    arrayList.add(new com.up366.mobile.common.logic.model.ParentQcodeResponse(response, list.get(1).initDefaultData()));
                } else {
                    arrayList.add(new com.up366.mobile.common.logic.model.ParentQcodeResponse(response, new com.up366.mobile.common.logic.model.ParentQcode(1).initDefaultData()));
                    arrayList.add(new com.up366.mobile.common.logic.model.ParentQcodeResponse(response, new com.up366.mobile.common.logic.model.ParentQcode(2).initDefaultData()));
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.LoadParentQcodeEvent(response, arrayList));
            }
        });
    }

    public void applyCancelAccount(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.USER_CANCLE_APPLY) { // from class: com.up366.mobile.common.logic.PersonalMgr.14
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("verifyCode", str);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void fetchApplyCancelAccountStatus(final com.up366.common.callback.ICallbackResponse<java.lang.Integer> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Integer>(com.up366.mobile.common.http.HttpMgrUtils.GET_USER_CANCLE_STATUS) { // from class: com.up366.mobile.common.logic.PersonalMgr.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public java.lang.Integer handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return java.lang.Integer.valueOf(java.lang.Integer.parseInt(str));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Integer num) {
                iCallbackResponse.onResult(response, num);
            }
        });
    }

    public void bindWechatOrQq(final java.lang.String str, final int i, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.bindWechatOrQq) { // from class: com.up366.mobile.common.logic.PersonalMgr.16
            @Override // com.up366.common.http.RequestParams
            public java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return str2;
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("openId", str);
                map.put("type", java.lang.Integer.valueOf(i));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void unBindWechatOrQq(final int i, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.unBindWechatOrQq) { // from class: com.up366.mobile.common.logic.PersonalMgr.17
            @Override // com.up366.common.http.RequestParams
            public java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return str;
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("type", java.lang.Integer.valueOf(i));
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }

    public void updateUserPhoto(final java.lang.String str) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.UPDATE_USER_HEAD_PHOTO) { // from class: com.up366.mobile.common.logic.PersonalMgr.18
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("headPhoto", str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.lang.String handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                com.up366.mobile.common.logic.Auth.getUserInfo().setPhotoUrl(str);
                com.up366.mobile.common.logic.Auth.getUserInfo().updateJson();
                com.up366.mobile.common.utils.ViewDataInvalidRecord.$("headPhotoUpdate").invalid();
                return (java.lang.String) super.handleResponse(response, str2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MeHeadPhotoUpdateEvent(response, str));
            }
        });
    }

    public void fetchPhotoList(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.UserPhoto>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.common.logic.model.UserPhoto>>(com.up366.mobile.common.http.HttpMgrUtils.FETCH_USER_PHOTO_LIST) { // from class: com.up366.mobile.common.logic.PersonalMgr.19
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.common.logic.model.UserPhoto> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                java.util.List<com.up366.mobile.common.logic.model.UserPhoto> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.common.logic.model.UserPhoto.class);
                java.util.Iterator<com.up366.mobile.common.logic.model.UserPhoto> it = array.iterator();
                while (it.hasNext()) {
                    it.next().initState();
                }
                com.up366.mobile.common.utils.PreferenceUtils.putString("fetchPhotoListData", str);
                return array;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.logic.model.UserPhoto> list) {
                iCallbackResponse.onResult(response, list);
            }
        });
    }

    public void loadUserPhotoList(com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.UserPhoto>> iCallbackResponse) {
        java.util.List<com.up366.mobile.common.logic.model.UserPhoto> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(com.up366.mobile.common.utils.PreferenceUtils.getString("fetchPhotoListData", "[]"), com.up366.mobile.common.logic.model.UserPhoto.class);
        java.util.Iterator<com.up366.mobile.common.logic.model.UserPhoto> it = array.iterator();
        while (it.hasNext()) {
            it.next().initState();
        }
        iCallbackResponse.onResult(null, array);
    }

    public boolean isPlainPassword() {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.common.utils.PreferenceUtils.getText("auth-info-v2", ""));
        if (object == null) {
            return false;
        }
        return com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5("123456").toLowerCase() + "fa&s*l%$k!fq$k!ld@fjlk").toLowerCase().equals(object.getString("password"));
    }

    public void saveCustomPhoto(final java.lang.String str) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.saveUserCustomPhoto) { // from class: com.up366.mobile.common.logic.PersonalMgr.20
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("headPhoto", str);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                com.up366.mobile.common.logic.model.UserCustomPhotoStatus userCustomPhotoStatus = new com.up366.mobile.common.logic.model.UserCustomPhotoStatus();
                userCustomPhotoStatus.setHeadPhoto(str);
                userCustomPhotoStatus.setStatus(0);
                userCustomPhotoStatus.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
                com.up366.mobile.common.utils.PreferenceUtils.putString("UserCustomPhotoStatus" + com.up366.mobile.common.logic.Auth.UID(), com.alibaba.fastjson.JSON.toJSONString(userCustomPhotoStatus));
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MeHeadPhotoUpdateEvent(response, str));
            }
        });
    }

    public void fetchCustomPhotoStatus(final com.up366.common.callback.ICallbackResponse<com.up366.mobile.common.logic.model.UserCustomPhotoStatus> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.common.logic.model.UserCustomPhotoStatus>(com.up366.mobile.common.http.HttpMgrUtils.loadUserCustomStatus) { // from class: com.up366.mobile.common.logic.PersonalMgr.21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.common.logic.model.UserCustomPhotoStatus handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                if (!response.isError()) {
                    com.up366.mobile.common.utils.PreferenceUtils.putString("UserCustomPhotoStatus" + com.up366.mobile.common.logic.Auth.UID(), str);
                }
                return (com.up366.mobile.common.logic.model.UserCustomPhotoStatus) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.common.logic.model.UserCustomPhotoStatus.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.UserCustomPhotoStatus userCustomPhotoStatus) {
                response.setCode(0);
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                if (iCallbackResponse2 != null) {
                    iCallbackResponse2.onResult(response, userCustomPhotoStatus);
                }
            }
        });
    }

    public com.up366.mobile.common.logic.model.UserCustomPhotoStatus loadCustomPhotoStatus() {
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("UserCustomPhotoStatus" + com.up366.mobile.common.logic.Auth.UID(), "");
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            return new com.up366.mobile.common.logic.model.UserCustomPhotoStatus();
        }
        try {
            return (com.up366.mobile.common.logic.model.UserCustomPhotoStatus) com.alibaba.fastjson.JSON.parseObject(string, com.up366.mobile.common.logic.model.UserCustomPhotoStatus.class);
        } catch (java.lang.Exception unused) {
            return new com.up366.mobile.common.logic.model.UserCustomPhotoStatus();
        }
    }

    public com.up366.common.http.NetHolder<java.lang.Object> cleanUserData(final java.util.List<java.lang.String> list) throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.cleanUserData).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("types", android.text.TextUtils.join(com.igexin.push.core.b.an, list));
            }
        }));
    }

    public void uploadRecordAliyun(final int i, java.lang.String str, final com.up366.common.callback.ICallbackResponse iCallbackResponse) {
        com.up366.mobile.common.logic.Auth.cur().fileMgr().save(str, null, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, new com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult() { // from class: com.up366.mobile.common.logic.PersonalMgr$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.utils.alifile.FileMgr.ISaveResult
            public final void onResult(com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
                this.f$0.lambda$uploadRecordAliyun$8(i, iCallbackResponse, fileMapInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$uploadRecordAliyun$8(final int i, final com.up366.common.callback.ICallbackResponse iCallbackResponse, final com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo) {
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfo, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.common.logic.PersonalMgr.22
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long j, long j2) {
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                com.up366.mobile.common.logic.PersonalMgr.this.uploadRecord(i, fileMapInfo.getUrl(), iCallbackResponse);
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int i2, java.lang.String str) {
                com.up366.common.log.Logger.error("upload image error code=" + i2 + " info=" + str);
                com.up366.common.http.Response response = new com.up366.common.http.Response();
                response.setCode(i2);
                response.setInfo(str);
                iCallbackResponse.onResult(response, str);
            }
        });
    }

    public void uploadRecord(int i, final java.lang.String str, final com.up366.common.callback.ICallbackResponse iCallbackResponse) {
        java.lang.String str2;
        if (i != 2) {
            str2 = com.up366.mobile.common.http.HttpMgrUtils.uploadRecord;
        } else {
            str2 = com.up366.mobile.common.http.HttpMgrUtils.checkRecord;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(str2) { // from class: com.up366.mobile.common.logic.PersonalMgr.23
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str3) {
                super.onResponse(response, str3);
                iCallbackResponse.onResult(response, str3);
            }
        });
    }

    public void fetchStudyCardCount(final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.getStudyCardCount) { // from class: com.up366.mobile.common.logic.PersonalMgr.24
            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str) {
                if (str != null) {
                    com.up366.mobile.common.utils.PreferenceUtils.putStringSync(com.up366.mobile.common.logic.PersonalMgr.STUDY_CARD_COUNT_NEW + com.up366.mobile.common.logic.Auth.UID(), str);
                }
                iCallbackResponse.onResult(response, str);
            }
        });
    }

    public com.up366.mobile.common.logic.model.StudyCardInfo loadStudyCardInfo() {
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString(STUDY_CARD_COUNT_NEW + com.up366.mobile.common.logic.Auth.UID(), "");
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            return new com.up366.mobile.common.logic.model.StudyCardInfo();
        }
        try {
            return (com.up366.mobile.common.logic.model.StudyCardInfo) com.alibaba.fastjson.JSON.parseObject(string, com.up366.mobile.common.logic.model.StudyCardInfo.class);
        } catch (java.lang.Exception unused) {
            return new com.up366.mobile.common.logic.model.StudyCardInfo();
        }
    }

    public boolean isInStudyCard(java.lang.String str) {
        java.util.List<java.lang.String> spGoodsIds;
        com.up366.mobile.common.logic.model.StudyCardInfo studyCardInfoLoadStudyCardInfo = loadStudyCardInfo();
        if (studyCardInfoLoadStudyCardInfo == null || (spGoodsIds = studyCardInfoLoadStudyCardInfo.getSpGoodsIds()) == null) {
            return false;
        }
        return spGoodsIds.contains(str);
    }
}
