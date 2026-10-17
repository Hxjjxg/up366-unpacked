package com.up366.mobile.common.logic.user;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserInfo {
    public static final short USER_TYPE_STUDENT = 102;
    public static final short USER_TYPE_TEACHER = 101;
    private int areaId;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private int cityId;
    private java.lang.String classCode;
    private int classId;
    private java.lang.String className;
    private int countryId;
    private int deviceWhiteListFlag;
    private java.lang.String email;
    private int gender;
    private java.lang.String mobile;
    private int newDeviceFlag;
    private int organId;
    private java.lang.String organName;

    @com.alibaba.fastjson.annotation.JSONField(name = "headPhoto")
    private java.lang.String photoUrl;
    private int provinceId;
    private java.lang.String qqOpenid;
    private java.lang.String realname;
    private long recordTime;
    private java.lang.String reserved1;
    private int tempPwdFlag;
    private int tutorFlag;
    private java.lang.String username;
    private java.lang.String uuid;
    private int weakPwdFlag;
    private java.lang.String weixinOpenid;
    private int uid = 0;
    private int utype = 102;
    private int schoolType = 3;
    private int fromChannelCenter = 0;

    public UserInfo() {
    }

    public UserInfo(java.lang.String str) {
        initWithJSONStr(str);
    }

    public void updateJson() {
        initWithJSONStr(com.alibaba.fastjson.JSON.toJSONString(this));
    }

    public void initWithJSONStr(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        com.up366.mobile.common.utils.PreferenceUtils.putText("user-info", str);
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        this.birthDay = object.getIntValue("birthDay");
        this.birthMonth = object.getIntValue("birthMonth");
        this.birthYear = object.getIntValue("birthYear");
        this.email = object.getString("email");
        this.gender = object.getIntValue("gender");
        this.photoUrl = object.getString("headPhoto");
        this.mobile = object.getString("mobile");
        this.organId = object.getIntValue("organId");
        this.organName = object.getString("organName");
        this.realname = object.getString(com.up366.mobile.common.event.WrongNoteRankOrderRefresh.RANK_TYPE_NAME);
        this.schoolType = object.getIntValue("schoolType");
        this.uid = object.getIntValue("uid");
        this.username = object.getString("username");
        this.utype = object.getIntValue("utype");
        this.uuid = object.getString("uuid");
        this.reserved1 = object.getString("reserved1");
        this.qqOpenid = object.getString("qqOpenid");
        this.weixinOpenid = object.getString("weixinOpenid");
        this.recordTime = object.getLongValue("recordTime");
        this.cityId = object.getIntValue("cityId");
        this.countryId = object.getIntValue("countryId");
        this.provinceId = object.getIntValue("provinceId");
        this.areaId = object.getIntValue("areaId");
        this.weakPwdFlag = object.getIntValue("weakPwdFlag");
        this.newDeviceFlag = object.getIntValue("newDeviceFlag");
        this.tempPwdFlag = object.getIntValue("tempPwdFlag");
        this.tutorFlag = object.getIntValue("tutorFlag");
        this.deviceWhiteListFlag = object.getIntValue("deviceWhiteListFlag");
        this.fromChannelCenter = object.getIntValue("fromChannelCenter");
        com.up366.mobile.common.logic.user.UserClassInfo userClassInfo = (com.up366.mobile.common.logic.user.UserClassInfo) com.alibaba.fastjson.JSON.parseObject(com.up366.mobile.common.utils.PreferenceUtils.getText("UserClassInfo_" + this.uid, "{}"), com.up366.mobile.common.logic.user.UserClassInfo.class);
        if (userClassInfo != null) {
            this.classCode = userClassInfo.getClassCode();
            this.classId = userClassInfo.getClassId();
            this.className = userClassInfo.getClassName();
        }
    }

    public long getRecordTime() {
        return this.recordTime;
    }

    public void setRecordTime(long j) {
        this.recordTime = j;
    }

    public java.lang.String getClassCode() {
        return this.classCode;
    }

    public void setClassCode(java.lang.String str) {
        this.classCode = str;
    }

    public void setBirthDay(int i) {
        this.birthDay = i;
    }

    public int getBirthDay() {
        return this.birthDay;
    }

    public void setBirthMonth(int i) {
        this.birthMonth = i;
    }

    public int getBirthMonth() {
        return this.birthMonth;
    }

    public void setBirthYear(int i) {
        this.birthYear = i;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setEmail(java.lang.String str) {
        this.email = str;
    }

    public java.lang.String getEmail() {
        return this.email;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public int getGender() {
        return this.gender;
    }

    public void setOrganId(int i) {
        this.organId = i;
    }

    public int getOrganId() {
        return this.organId;
    }

    public void setOrganName(java.lang.String str) {
        this.organName = str;
    }

    public java.lang.String getOrganName() {
        return this.organName;
    }

    public void setRealname(java.lang.String str) {
        this.realname = str;
    }

    public java.lang.String getRealname() {
        return this.realname;
    }

    public void setSchoolType(int i) {
        this.schoolType = i;
    }

    public int getSchoolType() {
        return this.schoolType;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUsername(java.lang.String str) {
        this.username = str;
    }

    public java.lang.String getUsername() {
        return this.username;
    }

    public void setUtype(int i) {
        this.utype = i;
    }

    public int getUtype() {
        return this.utype;
    }

    public void setUuid(java.lang.String str) {
        this.uuid = str;
    }

    public java.lang.String getUuid() {
        return this.uuid;
    }

    public java.lang.String getPhotoUrl() {
        return this.photoUrl;
    }

    public int getClassId() {
        return this.classId;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public java.lang.String getMaskMobile() {
        if (android.text.TextUtils.isEmpty(this.mobile)) {
            return this.mobile;
        }
        return this.mobile.replaceFirst("(\\d{4})\\d{3}(\\d{4})", "$1***$2");
    }

    public void setMobile(java.lang.String str) {
        this.mobile = str;
    }

    public void setPhotoUrl(java.lang.String str) {
        this.photoUrl = str;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public void setClassName(java.lang.String str) {
        this.className = str;
    }

    public java.lang.String getClassName() {
        return this.className;
    }

    public java.lang.String getReserved1() {
        return this.reserved1;
    }

    public void setReserved1(java.lang.String str) {
        this.reserved1 = str;
    }

    public boolean isTeacher() {
        return this.utype == 101;
    }

    public java.lang.String getQqOpenid() {
        return this.qqOpenid;
    }

    public void setQqOpenid(java.lang.String str) {
        this.qqOpenid = str;
    }

    public java.lang.String getWeixinOpenid() {
        return this.weixinOpenid;
    }

    public void setWeixinOpenid(java.lang.String str) {
        this.weixinOpenid = str;
    }

    public boolean isVoiceSetted() {
        return this.recordTime != 0;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setCityId(int i) {
        this.cityId = i;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public void setCountryId(int i) {
        this.countryId = i;
    }

    public int getProvinceId() {
        return this.provinceId;
    }

    public void setProvinceId(int i) {
        this.provinceId = i;
    }

    public int getAreaId() {
        return this.areaId;
    }

    public void setAreaId(int i) {
        this.areaId = i;
    }

    public int getWeakPwdFlag() {
        return this.weakPwdFlag;
    }

    public void setWeakPwdFlag(int i) {
        this.weakPwdFlag = i;
    }

    public int getNewDeviceFlag() {
        return this.newDeviceFlag;
    }

    public void setNewDeviceFlag(int i) {
        this.newDeviceFlag = i;
    }

    public int getTempPwdFlag() {
        return this.tempPwdFlag;
    }

    public void setTempPwdFlag(int i) {
        this.tempPwdFlag = i;
    }

    public int getTutorFlag() {
        return this.tutorFlag;
    }

    public void setTutorFlag(int i) {
        this.tutorFlag = i;
    }

    public int getDeviceWhiteListFlag() {
        return this.deviceWhiteListFlag;
    }

    public void setDeviceWhiteListFlag(int i) {
        this.deviceWhiteListFlag = i;
    }

    public int getFromChannelCenter() {
        return this.fromChannelCenter;
    }

    public void setFromChannelCenter(int i) {
        this.fromChannelCenter = i;
    }

    public boolean isBackUpPassword() {
        return this.tempPwdFlag == 1;
    }

    public boolean isWeakPassword() {
        return this.weakPwdFlag == 1;
    }

    public boolean isQuDaoUser() {
        return this.fromChannelCenter == 1;
    }
}
