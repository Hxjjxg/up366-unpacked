package com.up366.asecengine.englishengine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecEngineAsyncHelper {
    private static com.up366.asecengine.englishengine.AsecEngineAsyncHelper helper = null;
    static float scoreFactor = 1.0f;
    private final com.up366.asecengine.jni.AsesJni asesJni;
    private com.up366.asecengine.asecmgr.ISpeechStatCallBack callBack;
    private android.app.Application context;
    private com.up366.asecengine.englishengine.AsecSession curSession;
    private com.up366.asecengine.englishengine.EngineV2Wrapper engineV2Wrapper;
    private final com.up366.common.task.TaskExecutor executorEngine;
    private final com.up366.common.task.TaskExecutor executorRecord;
    private com.up366.asecengine.englishengine.AsecEngineAsyncHelper.IFFTUpdateListener fftUpdateListener;
    private com.up366.asecengine.englishengine.AsecEngineAsyncHelper.IWaveUpdateListener waveUpdateListener;

    public interface IFFTUpdateListener {
        void update(byte[] bArr);
    }

    public interface IWaveUpdateListener {
        void update(byte[] bArr);
    }

    private AsecEngineAsyncHelper(android.content.Context context) {
        com.up366.common.task.TaskExecutor taskExecutorCreateSerialExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("asec_engine_sync");
        this.executorEngine = taskExecutorCreateSerialExecutor;
        this.executorRecord = taskExecutorCreateSerialExecutor;
        com.up366.asecengine.jni.AsesJni asesJni = new com.up366.asecengine.jni.AsesJni();
        this.asesJni = asesJni;
        this.context = (android.app.Application) context;
        this.engineV2Wrapper = new com.up366.asecengine.englishengine.EngineV2Wrapper(context, asesJni, taskExecutorCreateSerialExecutor);
    }

    public static com.up366.asecengine.englishengine.AsecEngineAsyncHelper create(android.content.Context context) {
        if (helper == null) {
            helper = new com.up366.asecengine.englishengine.AsecEngineAsyncHelper(context);
        }
        return helper;
    }

    public void setOnStateChangeListener(com.up366.asecengine.asecmgr.ISpeechStatCallBack iSpeechStatCallBack) {
        this.callBack = iSpeechStatCallBack;
    }

    public void setWaveUpdateListener(com.up366.asecengine.englishengine.AsecEngineAsyncHelper.IWaveUpdateListener iWaveUpdateListener) {
        this.waveUpdateListener = iWaveUpdateListener;
    }

    public void setOnFFTUpdateListener(com.up366.asecengine.englishengine.AsecEngineAsyncHelper.IFFTUpdateListener iFFTUpdateListener) {
        this.fftUpdateListener = iFFTUpdateListener;
    }

    private void writeRecordDataLengthToFile(java.lang.String str, long j) {
        byte[] waveHeader = com.up366.asecengine.asecmgr.MediaUtils.getWaveHeader(j);
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.write(waveHeader);
            randomAccessFile.close();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void forceStopAll() {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.curSession;
        if (asecSession != null) {
            asecSession.destroy();
            this.curSession = null;
        }
    }

    public void startTestSession(final com.up366.asecengine.englishengine.AsecSession asecSession) throws java.lang.Exception {
        com.up366.asecengine.englishengine.AsecSession asecSession2 = this.curSession;
        if (asecSession2 != null) {
            asecSession2.destroy();
            this.curSession = null;
        }
        asecSession.setOnMediaStateChangeListener(this.callBack);
        this.curSession = asecSession;
        this.executorRecord.post(new com.up366.common.task.Task() { // from class: com.up366.asecengine.englishengine.AsecEngineAsyncHelper.1
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                java.io.RandomAccessFile randomAccessFile;
                asecSession.start();
                try {
                    try {
                        randomAccessFile = new java.io.RandomAccessFile(new java.io.File(asecSession.wavPath), "rw");
                        try {
                            randomAccessFile.seek(44L);
                            com.up366.asecengine.utils.AsesMD5 asesMD5 = new com.up366.asecengine.utils.AsesMD5();
                            for (byte[] bArr = new byte[4096]; randomAccessFile.read(bArr) > 0; bArr = new byte[4096]) {
                                asecSession.writeData(bArr);
                                asesMD5.append(bArr);
                            }
                            asecSession.setMd5Str(asesMD5.build());
                        } catch (java.io.IOException e) {
                            e = e;
                            com.up366.common.log.Logger.error("testWav IO error " + e.getMessage(), e);
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.up366.common.IOUtils.close(null);
                        asecSession.setWavCheckerJsonResult(com.up366.asecengine.englishengine.WavCheckerCompat.compat(null));
                        asecSession.stop();
                        asecSession.onRecordStateChange(2);
                        throw th;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.up366.common.IOUtils.close(null);
                    asecSession.setWavCheckerJsonResult(com.up366.asecengine.englishengine.WavCheckerCompat.compat(null));
                    asecSession.stop();
                    asecSession.onRecordStateChange(2);
                    throw th;
                }
                com.up366.common.IOUtils.close(randomAccessFile);
                asecSession.setWavCheckerJsonResult(com.up366.asecengine.englishengine.WavCheckerCompat.compat(null));
                asecSession.stop();
                asecSession.onRecordStateChange(2);
            }
        });
        try {
            int i = asecSession.type;
            if (i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
                this.engineV2Wrapper.startRecord(asecSession);
            } else {
                if (i == 11) {
                    return;
                }
                throw new java.lang.IllegalStateException("未知的评分类型 ：" + asecSession.type);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage(), e);
            asecSession.destroy(-100, e.getMessage());
            throw e;
        }
    }
}
