package com.up366.library.opusencoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpusHelper {
    private final com.up366.library.opusencoder.OpusEncoder opusEncoder;
    private boolean opusInited = false;
    private final com.up366.library.opusencoder.OpusParams opusParams;
    private com.up366.library.opusencoder.PcmFrameAssembler pcmAssembler;

    public OpusHelper() {
        com.up366.library.opusencoder.OpusParams opusParams = new com.up366.library.opusencoder.OpusParams();
        this.opusParams = opusParams;
        this.opusEncoder = new com.up366.library.opusencoder.OpusEncoder();
        this.pcmAssembler = new com.up366.library.opusencoder.PcmFrameAssembler(opusParams);
    }

    public void updateOpusParams(com.up366.library.opusencoder.OpusParams opusParams) {
        if (opusParams == null) {
            return;
        }
        this.opusParams.setEnable(opusParams.isEnable());
        this.opusParams.setSampleRate(opusParams.getSampleRate());
        this.opusParams.setChannels(opusParams.getChannels());
        this.opusParams.setBitrate(opusParams.getBitrate());
        this.opusParams.setFrameMs(opusParams.getFrameMs());
        this.pcmAssembler = new com.up366.library.opusencoder.PcmFrameAssembler(this.opusParams);
    }

    public void opusInit(java.lang.String str) {
        if (!this.opusParams.isEnable()) {
            com.up366.common.log.Logger.info("OpusEncoder 未启用");
            return;
        }
        try {
            this.opusInited = this.opusEncoder.initEncoder(str, this.opusParams.getSampleRate(), this.opusParams.getChannels(), this.opusParams.getBitrate());
            com.up366.common.log.Logger.info("OpusEncoder 参数: " + this.opusParams.toString());
            if (this.opusInited) {
                com.up366.common.log.Logger.info("OpusEncoder 初始化成功, 输出路径: " + str);
            } else {
                com.up366.common.log.Logger.error("OpusEncoder 初始化失败");
            }
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("OpusEncoder 初始化异常", th);
        }
    }

    public void feedOpusData(byte[] bArr, int i) {
        if (this.opusInited && this.opusParams.isEnable()) {
            try {
                int i2 = i / 2;
                short[] sArr = new short[i2];
                java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                java.util.List<short[]> listFeed = this.pcmAssembler.feed(sArr, i2);
                if (listFeed.isEmpty()) {
                    return;
                }
                for (short[] sArr2 : listFeed) {
                    try {
                        this.opusEncoder.encodeFrame(sArr2, sArr2.length);
                    } catch (java.lang.Throwable th) {
                        com.up366.common.log.Logger.error("OpusEncoder 编码失败 (单帧)", th);
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.up366.common.log.Logger.error("OpusEncoder 编码失败", th2);
            }
        }
    }

    public void flushToEnd() {
        if (this.opusInited && this.opusParams.isEnable()) {
            try {
                java.util.List<short[]> listFlush = this.pcmAssembler.flush();
                if (listFlush.isEmpty()) {
                    return;
                }
                for (short[] sArr : listFlush) {
                    try {
                        this.opusEncoder.encodeFrame(sArr, sArr.length);
                    } catch (java.lang.Throwable th) {
                        com.up366.common.log.Logger.error("OpusEncoder 编码尾帧失败", th);
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.up366.common.log.Logger.error("OpusEncoder flush 编码失败", th2);
            }
        }
    }

    public void opusClose() {
        if (this.opusInited && this.opusParams.isEnable()) {
            try {
                this.opusEncoder.closeEncoder();
                this.opusInited = false;
                com.up366.common.log.Logger.info("OpusEncoder 关闭成功");
            } catch (java.lang.Throwable th) {
                com.up366.common.log.Logger.error("OpusEncoder 关闭异常", th);
            }
        }
    }
}
