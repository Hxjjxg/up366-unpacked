package com.up366.smart.paper.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FrameMetadata {
    private final int height;
    private final int rotation;
    private final int width;

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getRotation() {
        return this.rotation;
    }

    private FrameMetadata(int width, int height, int rotation) {
        this.width = width;
        this.height = height;
        this.rotation = rotation;
    }

    public static class Builder {
        private int height;
        private int rotation;
        private int width;

        public com.up366.smart.paper.utils.FrameMetadata.Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public com.up366.smart.paper.utils.FrameMetadata.Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public com.up366.smart.paper.utils.FrameMetadata.Builder setRotation(int rotation) {
            this.rotation = rotation;
            return this;
        }

        public com.up366.smart.paper.utils.FrameMetadata build() {
            return new com.up366.smart.paper.utils.FrameMetadata(this.width, this.height, this.rotation);
        }
    }
}
