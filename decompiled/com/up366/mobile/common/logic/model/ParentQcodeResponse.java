package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ParentQcodeResponse {
    public final com.up366.common.http.Response resp;
    public final com.up366.mobile.common.logic.model.ParentQcode result;

    public ParentQcodeResponse(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.ParentQcode parentQcode) {
        this.resp = response;
        this.result = parentQcode;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.ParentQcodeResponse parentQcodeResponse = (com.up366.mobile.common.logic.model.ParentQcodeResponse) obj;
        com.up366.mobile.common.logic.model.ParentQcode parentQcode = this.result;
        if (parentQcode == null ? parentQcodeResponse.result != null : !parentQcode.equals(parentQcodeResponse.result)) {
            return false;
        }
        com.up366.common.http.Response response = this.resp;
        if (response != null) {
            if (response.getCode() == parentQcodeResponse.resp.getCode()) {
                return true;
            }
        } else if (parentQcodeResponse.resp == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        com.up366.mobile.common.logic.model.ParentQcode parentQcode = this.result;
        int iHashCode = (parentQcode != null ? parentQcode.hashCode() : 0) * 31;
        com.up366.common.http.Response response = this.resp;
        return iHashCode + (response != null ? response.hashCode() : 0);
    }
}
