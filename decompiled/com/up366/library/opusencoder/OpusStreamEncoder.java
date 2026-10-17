package com.up366.library.opusencoder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpusStreamEncoder {
    private boolean initialized;
    private final com.up366.library.opusencoder.OpusEncoder opusEncoder;
    private final com.up366.library.opusencoder.OpusParams opusParams;
    private com.up366.library.opusencoder.PcmFrameAssembler pcmAssembler;

    public interface PacketListener {
        void onOpusPacket(byte[] bArr, int i);
    }

    public OpusStreamEncoder() {
        this(new com.up366.library.opusencoder.OpusParams());
    }

    public OpusStreamEncoder(com.up366.library.opusencoder.OpusParams opusParams) {
        this.opusEncoder = new com.up366.library.opusencoder.OpusEncoder();
        this.opusParams = opusParams;
        this.pcmAssembler = new com.up366.library.opusencoder.PcmFrameAssembler(opusParams);
    }

    public boolean init() {
        boolean zInitStreamEncoder = this.opusEncoder.initStreamEncoder(this.opusParams.getSampleRate(), this.opusParams.getChannels(), this.opusParams.getBitrate());
        this.initialized = zInitStreamEncoder;
        return zInitStreamEncoder;
    }

    public void encodePcm(short[] sArr, int i, com.up366.library.opusencoder.OpusStreamEncoder.PacketListener packetListener) {
        if (!this.initialized || sArr == null || i <= 0 || packetListener == null) {
            return;
        }
        emitFrames(this.pcmAssembler.feed(sArr, i), packetListener);
    }

    public void encodePcm(byte[] bArr, int i, com.up366.library.opusencoder.OpusStreamEncoder.PacketListener packetListener) {
        if (!this.initialized || bArr == null || i < 2 || packetListener == null) {
            return;
        }
        int i2 = i - (i % 2);
        int i3 = i2 / 2;
        short[] sArr = new short[i3];
        java.nio.ByteBuffer.wrap(bArr, 0, i2).order(java.nio.ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
        encodePcm(sArr, i3, packetListener);
    }

    public void flush(com.up366.library.opusencoder.OpusStreamEncoder.PacketListener packetListener) {
        if (!this.initialized || packetListener == null) {
            return;
        }
        emitFrames(this.pcmAssembler.flush(), packetListener);
    }

    public void close() {
        if (this.initialized) {
            this.opusEncoder.closeStreamEncoder();
            this.initialized = false;
        }
    }

    public com.up366.library.opusencoder.OpusParams getOpusParams() {
        return this.opusParams;
    }

    private void emitFrames(java.util.List<short[]> list, com.up366.library.opusencoder.OpusStreamEncoder.PacketListener packetListener) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (short[] sArr : list) {
            byte[] bArrEncodeFrameToPacket = this.opusEncoder.encodeFrameToPacket(sArr, sArr.length);
            if (bArrEncodeFrameToPacket != null && bArrEncodeFrameToPacket.length > 0) {
                packetListener.onOpusPacket(bArrEncodeFrameToPacket, sArr.length / this.opusParams.getChannels());
            }
        }
    }
}
