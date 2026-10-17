package com.up366.mobile.user.account.switchaccount;

/* JADX INFO: compiled from: SwitchAccountHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/user/account/switchaccount/SwitchAccountHelper;", "", "<init>", "()V", "accountList", "", "Lcom/up366/mobile/user/account/switchaccount/SwitchAccountData;", "getAccountList", "", "deleteAccount", "", "data", "switchEditState", "isEdit", "", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwitchAccountHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.Companion INSTANCE = new com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.Companion(null);
    private static final java.lang.String SWITCH_SAVE_ACCOUNT = "switch_save_account";
    private final java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> accountList;

    public SwitchAccountHelper() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.accountList = arrayList;
        arrayList.addAll(INSTANCE.loadAccountList());
    }

    /* JADX INFO: compiled from: SwitchAccountHelper.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ.\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/up366/mobile/user/account/switchaccount/SwitchAccountHelper$Companion;", "", "<init>", "()V", "SWITCH_SAVE_ACCOUNT", "", "saveAccount", "", "password", "userInfo", "Lcom/up366/mobile/common/logic/user/UserInfo;", "authType", "", "openId", "updateAccount", "uid", "userName", "deleteAccountPhysics", "deleteAccount", "loadAccountList", "", "Lcom/up366/mobile/user/account/switchaccount/SwitchAccountData;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void saveAccount(java.lang.String password, com.up366.mobile.common.logic.user.UserInfo userInfo, int authType, java.lang.String openId) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData = new com.up366.mobile.user.account.switchaccount.SwitchAccountData();
            switchAccountData.setUid(userInfo.getUid());
            switchAccountData.setPasswd(password);
            switchAccountData.setUserName(userInfo.getUsername());
            switchAccountData.setRealName(userInfo.getRealname());
            switchAccountData.setUserPhoto(userInfo.getPhotoUrl());
            switchAccountData.setAuthType(authType);
            switchAccountData.setOpenId(openId);
            java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> listLoadAccountList = loadAccountList();
            java.util.Iterator<com.up366.mobile.user.account.switchaccount.SwitchAccountData> it = listLoadAccountList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (kotlin.jvm.internal.Intrinsics.areEqual(it.next().getUserName(), switchAccountData.getUserName())) {
                    it.remove();
                    break;
                }
            }
            listLoadAccountList.add(switchAccountData);
            com.up366.mobile.common.utils.PreferenceUtils.putText(com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.SWITCH_SAVE_ACCOUNT, com.alibaba.fastjson.JSON.toJSONString(listLoadAccountList));
        }

        public final void updateAccount(com.up366.mobile.common.logic.user.UserInfo userInfo) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> listLoadAccountList = loadAccountList();
            java.util.Iterator<com.up366.mobile.user.account.switchaccount.SwitchAccountData> it = listLoadAccountList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.up366.mobile.user.account.switchaccount.SwitchAccountData next = it.next();
                if (next.getUid() == userInfo.getUid()) {
                    next.setRealName(userInfo.getRealname());
                    next.setUserPhoto(userInfo.getPhotoUrl());
                    next.setUserName(userInfo.getUsername());
                    break;
                }
            }
            com.up366.mobile.common.utils.PreferenceUtils.putText(com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.SWITCH_SAVE_ACCOUNT, com.alibaba.fastjson.JSON.toJSONString(listLoadAccountList));
        }

        public final void updateAccount(int uid, java.lang.String password, java.lang.String userName, int authType, java.lang.String openId) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(password, "password");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(userName, "userName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(openId, "openId");
            java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> listLoadAccountList = loadAccountList();
            java.util.Iterator<com.up366.mobile.user.account.switchaccount.SwitchAccountData> it = listLoadAccountList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.up366.mobile.user.account.switchaccount.SwitchAccountData next = it.next();
                if (next.getUid() == uid) {
                    next.setUserName(userName);
                    next.setPasswd(password);
                    next.setAuthType(authType);
                    next.setOpenId(openId);
                    break;
                }
            }
            com.up366.mobile.common.utils.PreferenceUtils.putText(com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.SWITCH_SAVE_ACCOUNT, com.alibaba.fastjson.JSON.toJSONString(listLoadAccountList));
        }

        public final void deleteAccountPhysics(int uid) {
            java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> listLoadAccountList = loadAccountList();
            java.util.Iterator<com.up366.mobile.user.account.switchaccount.SwitchAccountData> it = listLoadAccountList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.up366.mobile.user.account.switchaccount.SwitchAccountData next = it.next();
                if (next.getUid() == uid) {
                    com.up366.common.log.Logger.info("SwitchAccount , delete " + next.getUserName() + " , " + next.getUid());
                    it.remove();
                    break;
                }
            }
            com.up366.mobile.common.utils.PreferenceUtils.putText(com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.SWITCH_SAVE_ACCOUNT, com.alibaba.fastjson.JSON.toJSONString(listLoadAccountList));
        }

        public final void deleteAccount(int uid) {
            java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> listLoadAccountList = loadAccountList();
            java.util.Iterator<com.up366.mobile.user.account.switchaccount.SwitchAccountData> it = listLoadAccountList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.up366.mobile.user.account.switchaccount.SwitchAccountData next = it.next();
                if (next.getUid() == uid) {
                    com.up366.common.log.Logger.info("SwitchAccount , logout " + next.getUserName() + " , " + next.getUid());
                    next.setDelete(true);
                    break;
                }
            }
            com.up366.mobile.common.utils.PreferenceUtils.putText(com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.SWITCH_SAVE_ACCOUNT, com.alibaba.fastjson.JSON.toJSONString(listLoadAccountList));
        }

        public final java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> loadAccountList() {
            java.util.List array = com.alibaba.fastjson.JSON.parseArray(com.up366.mobile.common.utils.PreferenceUtils.getText(com.up366.mobile.user.account.switchaccount.SwitchAccountHelper.SWITCH_SAVE_ACCOUNT, "[]"), com.up366.mobile.user.account.switchaccount.SwitchAccountData.class);
            java.util.Iterator it = array.iterator();
            while (it.hasNext()) {
                if (com.up366.mobile.common.logic.Auth.mgr().isTouristUsername(((com.up366.mobile.user.account.switchaccount.SwitchAccountData) it.next()).getUserName())) {
                    it.remove();
                }
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(array);
            return kotlin.collections.CollectionsKt.toMutableList(array);
        }
    }

    public final java.util.List<com.up366.mobile.user.account.switchaccount.SwitchAccountData> getAccountList() {
        return kotlin.collections.CollectionsKt.sortedWith(this.accountList, new java.util.Comparator() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountHelper$getAccountList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.ComparisonsKt.compareValues(((com.up366.mobile.user.account.switchaccount.SwitchAccountData) t).sortKey(), ((com.up366.mobile.user.account.switchaccount.SwitchAccountData) t2).sortKey());
            }
        });
    }

    public final void deleteAccount(com.up366.mobile.user.account.switchaccount.SwitchAccountData data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        this.accountList.remove(data);
        INSTANCE.deleteAccountPhysics(data.getUid());
    }

    public final void switchEditState(boolean isEdit) {
        java.util.Iterator<T> it = this.accountList.iterator();
        while (it.hasNext()) {
            ((com.up366.mobile.user.account.switchaccount.SwitchAccountData) it.next()).setEditing(isEdit);
        }
    }
}
