package com.up366.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DownloadEvent {
    private final long current;
    private final int downType;
    private final int errCode;
    private final java.lang.String errInfo;
    private final java.lang.String key;
    private final java.lang.String name;
    private final int state;
    private final long total;

    public DownloadEvent(java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
        java.lang.String str4;
        if (i == 2) {
            com.up366.common.log.Logger.debug("TAG - DownloadEvent - key = [" + str + "], downType = [" + i2 + "], state = [" + getStateName(i) + "], current = [" + j + "], total = [" + j2 + "], errCode = [" + i3 + "], errInfo = [" + str3 + "]");
            str4 = str3;
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - DownloadEvent - key = [");
            sb.append(str);
            sb.append("], downType = [");
            sb.append(i2);
            sb.append("], state = [");
            sb.append(getStateName(i));
            sb.append("], current = [");
            sb.append(j);
            sb.append("], total = [");
            sb.append(j2);
            sb.append("], errCode = [");
            sb.append(i3);
            sb.append("], errInfo = [");
            str4 = str3;
            sb.append(str4);
            sb.append("]");
            com.up366.common.log.Logger.info(sb.toString());
        }
        this.key = str;
        this.state = i;
        this.downType = i2;
        this.name = str2;
        this.current = j;
        this.total = j2;
        this.errCode = i3;
        this.errInfo = str4;
    }

    private java.lang.String getStateName(int i) {
        switch (i) {
            case 0:
                return "STATE_NOT_DOWN";
            case 1:
                return "STATE_WAIT";
            case 2:
                return "STATE_DOWN_ING";
            case 3:
                return "STATE_UNZIP_ING";
            case 4:
                return "STATE_SUCCESS";
            case 5:
                return "STATE_FAILED";
            case 6:
                return "STATE_CANCEL";
            case 7:
                return "STATE_RETRY";
            case 8:
                return "STATE_REPLACE";
            default:
                return "state:" + i;
        }
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public int getState() {
        return this.state;
    }

    public int getDownType() {
        return this.downType;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public long getCurrent() {
        return this.current;
    }

    public long getTotal() {
        return this.total;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public java.lang.String getErrInfo() {
        return this.errInfo;
    }

    public int getPercent() {
        long j = this.total;
        if (j == 0) {
            return 0;
        }
        return (int) ((this.current * 100) / j);
    }

    public java.lang.String toString() {
        return "DownloadEvent{key='" + this.key + "', state=" + this.state + ", downType=" + this.downType + ", name='" + this.name + "', current=" + this.current + ", total=" + this.total + ", errCode=" + this.errCode + ", errInfo='" + this.errInfo + "'}";
    }
}
