package com.up366.mobile.cloud.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ServerInfo {

    @com.alibaba.fastjson.annotation.JSONField(name = "organId")
    private long organId;

    @com.alibaba.fastjson.annotation.JSONField(name = "port")
    private int port;
    private int registerStatus;

    @com.alibaba.fastjson.annotation.JSONField(name = "serverId")
    private java.lang.String serverId;

    @com.alibaba.fastjson.annotation.JSONField(name = "serverIp")
    private java.lang.String serverIp;

    public java.lang.String getServerId() {
        return this.serverId;
    }

    public void setServerId(java.lang.String str) {
        this.serverId = str;
    }

    public java.lang.String getServerIp() {
        return this.serverIp;
    }

    public void setServerIp(java.lang.String str) {
        this.serverIp = str;
    }

    public int getRegisterStatus() {
        return this.registerStatus;
    }

    public void setRegisterStatus(int i) {
        this.registerStatus = i;
    }

    public long getOrganId() {
        return this.organId;
    }

    public void setOrganId(long j) {
        this.organId = j;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public java.lang.String toString() {
        return "ServerInfo{serverId='" + this.serverId + "', serverIp='" + this.serverIp + "', registerStatus=" + this.registerStatus + ", organId=" + this.organId + ", port=" + this.port + '}';
    }
}
