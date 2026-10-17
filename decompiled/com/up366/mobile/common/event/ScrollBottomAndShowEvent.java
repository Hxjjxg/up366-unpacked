package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ScrollBottomAndShowEvent {
    public final com.up366.mobile.common.event.ScrollBottomAndShowEvent.ShowEvent showEvent;

    public ScrollBottomAndShowEvent(int i) {
        this.showEvent = new com.up366.mobile.common.event.ScrollBottomAndShowEvent.ShowEvent(i);
    }

    public static final class ShowEvent {
        public final int type;

        private ShowEvent(int i) {
            this.type = i;
        }
    }
}
