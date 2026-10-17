package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SimpleCodeHandle {
    public <T> void preHandleRequest(com.up366.common.http.RequestParams<T> requestParams) {
    }

    public <T> void handle(com.up366.common.http.RequestParams<T> requestParams, com.up366.common.http.Response response) {
        response.getCode();
        postErrResponse(requestParams, response);
    }

    protected <T> void postErrResponse(final com.up366.common.http.RequestParams<T> requestParams, final com.up366.common.http.Response response) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.common.http.SimpleCodeHandle.1
            @Override // com.up366.common.task.Task
            public void run() {
                requestParams.onResponse(response, null);
            }
        });
    }
}
