package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ErrorMessageTool {
    public static java.lang.String convert(com.up366.common.http.Response response) {
        com.up366.common.log.Logger.info("TAG - ErrorMessageTool - convert - resp = [" + response + "]");
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            return "网络好像走丢了\n请稍后重试!";
        }
        if (response.getCode() == 0) {
            return "SUCCESS";
        }
        int code = response.getCode();
        if (code == -10004 || code == -99) {
            return "服务器异常，请稍后重试";
        }
        if (code != -27) {
            switch (code) {
                case com.up366.common.http.Response.FAIL_NETWORK_TIME_OUT /* -10002 */:
                case com.up366.common.http.Response.FAIL_NETWORK_NO_CONNECT /* -10000 */:
                    return "网络好像走丢了\n请稍后重试!";
                case -10001:
                    return "服务器异常，请稍后重试";
                default:
                    if (response.getInfo().contains("无效token")) {
                        com.up366.common.log.Logger.info("logout");
                        com.up366.common.task.TaskUtils.postMainTaskDelay(2000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ErrorMessageTool$$ExternalSyntheticLambda0
                            @Override // com.up366.common.task.Task
                            public final void run() {
                                com.up366.mobile.common.logic.Auth.logout();
                            }
                        });
                        return response.getInfo() + ",请重新登录";
                    }
                    return response.getInfo();
            }
        }
        return "账号或密码错误";
    }

    public static boolean isPoorNetwork(com.up366.common.http.Response response) {
        if (response == null) {
            return false;
        }
        return !com.up366.common.NetworkUtilsUp.isConnected() || -10002 == response.getCode() || -10000 == response.getCode();
    }
}
