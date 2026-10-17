package com.up366.qmui.recyclerView;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISwipeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    float mActionDownX;
    float mActionDownY;
    int mActionTotalHeight;
    int mActionTotalWidth;
    private com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.Callback mCallback;
    com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper mCurrentTouchAction;
    int mSetupDirection;
    java.util.List<com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper> mSwipeActions;

    public QMUISwipeViewHolder(android.view.View view) {
        super(view);
        this.mActionTotalWidth = 0;
        this.mActionTotalHeight = 0;
        this.mSetupDirection = 0;
        this.mCurrentTouchAction = null;
        this.mActionDownX = 0.0f;
        this.mActionDownY = 0.0f;
        this.mCallback = new com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.Callback() { // from class: com.up366.qmui.recyclerView.QMUISwipeViewHolder.1
            @Override // com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.Callback
            public void invalidate() {
                androidx.recyclerview.widget.RecyclerView parent = com.up366.qmui.recyclerView.QMUISwipeViewHolder.this.itemView.getParent();
                if (parent instanceof androidx.recyclerview.widget.RecyclerView) {
                    parent.invalidate();
                }
            }
        };
    }

    public void addSwipeAction(com.up366.qmui.recyclerView.QMUISwipeAction qMUISwipeAction) {
        if (this.mSwipeActions == null) {
            this.mSwipeActions = new java.util.ArrayList();
        }
        this.mSwipeActions.add(new com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper(qMUISwipeAction, this.mCallback));
    }

    public void clearActions() {
        java.util.List<com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper> list = this.mSwipeActions;
        if (list != null) {
            list.clear();
        }
    }

    public boolean hasAction() {
        java.util.List<com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper> list = this.mSwipeActions;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void clearTouchInfo() {
        this.mCurrentTouchAction = null;
        this.mActionDownY = -1.0f;
        this.mActionDownX = -1.0f;
    }

    void setup(int i, boolean z) {
        int i2 = 0;
        this.mActionTotalWidth = 0;
        this.mActionTotalHeight = 0;
        java.util.List<com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper> list = this.mSwipeActions;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mSetupDirection = i;
        for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper : this.mSwipeActions) {
            com.up366.qmui.recyclerView.QMUISwipeAction qMUISwipeAction = actionWrapper.action;
            if (i == 1 || i == 2) {
                actionWrapper.measureWidth = java.lang.Math.max(qMUISwipeAction.mSwipeDirectionMiniSize, qMUISwipeAction.contentWidth + (qMUISwipeAction.mPaddingStartEnd * 2));
                actionWrapper.measureHeight = this.itemView.getHeight();
                this.mActionTotalWidth = (int) (this.mActionTotalWidth + actionWrapper.measureWidth);
            } else if (i == 3 || i == 4) {
                actionWrapper.measureHeight = java.lang.Math.max(qMUISwipeAction.mSwipeDirectionMiniSize, qMUISwipeAction.contentHeight + (qMUISwipeAction.mPaddingStartEnd * 2));
                actionWrapper.measureWidth = this.itemView.getWidth();
                this.mActionTotalHeight = (int) (this.mActionTotalHeight + actionWrapper.measureHeight);
            }
        }
        if (this.mSwipeActions.size() == 1 && z) {
            this.mSwipeActions.get(0).swipeDeleteMode = true;
        } else {
            java.util.Iterator<com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper> it = this.mSwipeActions.iterator();
            while (it.hasNext()) {
                it.next().swipeDeleteMode = false;
            }
        }
        if (i == 1) {
            int right = this.itemView.getRight() - this.mActionTotalWidth;
            for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper2 : this.mSwipeActions) {
                actionWrapper2.initLeft = this.itemView.getRight();
                float top = this.itemView.getTop();
                actionWrapper2.targetTop = top;
                actionWrapper2.initTop = top;
                float f = right;
                actionWrapper2.targetLeft = f;
                right = (int) (f + actionWrapper2.measureWidth);
            }
            return;
        }
        if (i == 2) {
            for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper3 : this.mSwipeActions) {
                actionWrapper3.initLeft = this.itemView.getLeft() - actionWrapper3.measureWidth;
                float top2 = this.itemView.getTop();
                actionWrapper3.targetTop = top2;
                actionWrapper3.initTop = top2;
                float f2 = i2;
                actionWrapper3.targetLeft = f2;
                i2 = (int) (f2 + actionWrapper3.measureWidth);
            }
            return;
        }
        if (i == 3) {
            int bottom = this.itemView.getBottom() - this.mActionTotalHeight;
            for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper4 : this.mSwipeActions) {
                float left = this.itemView.getLeft();
                actionWrapper4.targetLeft = left;
                actionWrapper4.initLeft = left;
                actionWrapper4.initTop = this.itemView.getBottom();
                float f3 = bottom;
                actionWrapper4.targetTop = f3;
                bottom = (int) (f3 + actionWrapper4.measureHeight);
            }
            return;
        }
        if (i == 4) {
            for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper5 : this.mSwipeActions) {
                float left2 = this.itemView.getLeft();
                actionWrapper5.targetLeft = left2;
                actionWrapper5.initLeft = left2;
                actionWrapper5.initTop = this.itemView.getTop() - actionWrapper5.measureHeight;
                float f4 = i2;
                actionWrapper5.targetTop = f4;
                i2 = (int) (f4 + actionWrapper5.measureHeight);
            }
        }
    }

    boolean checkDown(float f, float f2) {
        for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper : this.mSwipeActions) {
            if (actionWrapper.hitTest(f, f2)) {
                this.mCurrentTouchAction = actionWrapper;
                this.mActionDownX = f;
                this.mActionDownY = f2;
                return true;
            }
        }
        return false;
    }

    com.up366.qmui.recyclerView.QMUISwipeAction checkUp(float f, float f2, int i) {
        com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper = this.mCurrentTouchAction;
        if (actionWrapper == null || !actionWrapper.hitTest(f, f2)) {
            return null;
        }
        float f3 = i;
        if (java.lang.Math.abs(f - this.mActionDownX) >= f3 || java.lang.Math.abs(f2 - this.mActionDownY) >= f3) {
            return null;
        }
        return this.mCurrentTouchAction.action;
    }

    void draw(android.graphics.Canvas canvas, boolean z, float f, float f2) {
        java.util.List<com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper> list = this.mSwipeActions;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.mActionTotalWidth > 0) {
            float fAbs = java.lang.Math.abs(f);
            int i = this.mActionTotalWidth;
            if (fAbs <= i) {
                float f3 = fAbs / i;
                for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper : this.mSwipeActions) {
                    actionWrapper.width = actionWrapper.measureWidth;
                    actionWrapper.left = actionWrapper.initLeft + ((actionWrapper.targetLeft - actionWrapper.initLeft) * f3);
                }
            } else {
                float size = (fAbs - i) / this.mSwipeActions.size();
                float left = f > 0.0f ? this.itemView.getLeft() : f + this.itemView.getRight();
                for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper2 : this.mSwipeActions) {
                    actionWrapper2.width = actionWrapper2.measureWidth + size;
                    actionWrapper2.left = left;
                    left += actionWrapper2.width;
                }
            }
        } else {
            for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper3 : this.mSwipeActions) {
                actionWrapper3.width = actionWrapper3.measureWidth;
                actionWrapper3.left = actionWrapper3.initLeft;
            }
        }
        if (this.mActionTotalHeight > 0) {
            float fAbs2 = java.lang.Math.abs(f2);
            int i2 = this.mActionTotalHeight;
            if (fAbs2 <= i2) {
                float f4 = fAbs2 / i2;
                for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper4 : this.mSwipeActions) {
                    actionWrapper4.height = actionWrapper4.measureHeight;
                    actionWrapper4.top = actionWrapper4.initTop + ((actionWrapper4.targetTop - actionWrapper4.initTop) * f4);
                }
            } else {
                float size2 = (fAbs2 - i2) / this.mSwipeActions.size();
                float top = f2 > 0.0f ? this.itemView.getTop() : f2 + this.itemView.getBottom();
                for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper5 : this.mSwipeActions) {
                    actionWrapper5.height = actionWrapper5.measureHeight + size2 + 0.5f;
                    actionWrapper5.top = top;
                    top += actionWrapper5.height;
                }
            }
        } else {
            for (com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper actionWrapper6 : this.mSwipeActions) {
                actionWrapper6.height = actionWrapper6.measureHeight;
                actionWrapper6.top = actionWrapper6.initTop;
            }
        }
        java.util.Iterator<com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper> it = this.mSwipeActions.iterator();
        while (it.hasNext()) {
            it.next().draw(canvas, z, this.mSetupDirection);
        }
    }

    static class ActionWrapper {
        static int MAX_SWIPE_MOVE_DURATION = 250;
        static int SWIPE_DELETE_AFTER = 3;
        static int SWIPE_DELETE_ANIMATING_TO_AFTER = 1;
        static int SWIPE_DELETE_ANIMATING_TO_BEFORE = 2;
        static int SWIPE_DELETE_BEFORE;
        final com.up366.qmui.recyclerView.QMUISwipeAction action;
        private android.animation.ValueAnimator animator;
        final com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.Callback callback;
        float height;
        float initLeft;
        float initTop;
        float left;
        float measureHeight;
        float measureWidth;
        float targetLeft;
        float targetTop;
        float top;
        float width;
        boolean swipeDeleteMode = false;
        private int swipeDeleteState = SWIPE_DELETE_BEFORE;
        private float currentAnimationProgress = 0.0f;
        private android.animation.ValueAnimator.AnimatorUpdateListener listener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.this.currentAnimationProgress = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.this.callback.invalidate();
            }
        };
        private float lastLeft = -1.0f;
        private float lastTop = -1.0f;
        private float animStartLeft = -1.0f;
        private float animStartTop = -1.0f;

        interface Callback {
            void invalidate();
        }

        private boolean isVer(int i) {
            return i == 4 || i == 3;
        }

        public ActionWrapper(com.up366.qmui.recyclerView.QMUISwipeAction qMUISwipeAction, com.up366.qmui.recyclerView.QMUISwipeViewHolder.ActionWrapper.Callback callback) {
            this.action = qMUISwipeAction;
            this.callback = callback;
        }

        boolean hitTest(float f, float f2) {
            float f3 = this.left;
            if (f > f3 && f < f3 + this.width) {
                float f4 = this.top;
                if (f2 > f4 && f2 < f4 + this.height) {
                    return true;
                }
            }
            return false;
        }

        void draw(android.graphics.Canvas canvas, boolean z, int i) {
            canvas.save();
            canvas.translate(this.left, this.top);
            this.action.paint.setStyle(android.graphics.Paint.Style.FILL);
            this.action.paint.setColor(this.action.mBackgroundColor);
            canvas.drawRect(0.0f, 0.0f, this.width, this.height, this.action.paint);
            if (!this.swipeDeleteMode) {
                canvas.translate((this.width - this.action.contentWidth) / 2.0f, (this.height - this.action.contentHeight) / 2.0f);
            } else {
                float anchorDrawLeft = getAnchorDrawLeft(i);
                float anchorDrawTop = getAnchorDrawTop(i);
                float followDrawLeft = getFollowDrawLeft(i);
                float followDrawTop = getFollowDrawTop(i);
                if (!z) {
                    int i2 = this.swipeDeleteState;
                    if (i2 != SWIPE_DELETE_BEFORE) {
                        if (i2 == SWIPE_DELETE_AFTER) {
                            this.swipeDeleteState = SWIPE_DELETE_ANIMATING_TO_BEFORE;
                            startAnimator(followDrawLeft, followDrawTop, anchorDrawLeft, anchorDrawTop, i);
                            anchorDrawLeft = followDrawLeft;
                            anchorDrawTop = followDrawTop;
                        } else if (i2 == SWIPE_DELETE_ANIMATING_TO_AFTER) {
                            this.swipeDeleteState = SWIPE_DELETE_ANIMATING_TO_BEFORE;
                            float f = this.lastLeft;
                            float f2 = this.lastTop;
                            startAnimator(f, f2, anchorDrawLeft, anchorDrawTop, i);
                            anchorDrawLeft = f;
                            anchorDrawTop = f2;
                        } else {
                            if (isVer(i)) {
                                float f3 = this.animStartTop;
                                anchorDrawTop = ((anchorDrawTop - f3) * this.currentAnimationProgress) + f3;
                            } else {
                                float f4 = this.animStartLeft;
                                anchorDrawLeft = ((anchorDrawLeft - f4) * this.currentAnimationProgress) + f4;
                            }
                            if (this.currentAnimationProgress >= 1.0f) {
                                this.swipeDeleteState = SWIPE_DELETE_BEFORE;
                            }
                        }
                    }
                    canvas.translate(anchorDrawLeft - this.left, anchorDrawTop - this.top);
                    this.lastLeft = anchorDrawLeft;
                    this.lastTop = anchorDrawTop;
                } else {
                    int i3 = this.swipeDeleteState;
                    if (i3 == SWIPE_DELETE_AFTER) {
                        anchorDrawLeft = followDrawLeft;
                        anchorDrawTop = followDrawTop;
                    } else if (i3 == SWIPE_DELETE_ANIMATING_TO_BEFORE) {
                        this.swipeDeleteState = SWIPE_DELETE_ANIMATING_TO_AFTER;
                        anchorDrawLeft = this.lastLeft;
                        anchorDrawTop = this.lastTop;
                        startAnimator(anchorDrawLeft, anchorDrawTop, followDrawLeft, followDrawTop, i);
                    } else if (i3 == SWIPE_DELETE_BEFORE) {
                        this.swipeDeleteState = SWIPE_DELETE_ANIMATING_TO_AFTER;
                        startAnimator(anchorDrawLeft, anchorDrawTop, followDrawLeft, followDrawTop, i);
                    } else {
                        if (isVer(i)) {
                            float f5 = this.animStartTop;
                            anchorDrawTop = f5 + ((followDrawTop - f5) * this.currentAnimationProgress);
                            anchorDrawLeft = followDrawLeft;
                        } else {
                            float f6 = this.animStartLeft;
                            anchorDrawLeft = f6 + ((followDrawLeft - f6) * this.currentAnimationProgress);
                            anchorDrawTop = followDrawTop;
                        }
                        if (this.currentAnimationProgress >= 1.0f) {
                            this.swipeDeleteState = SWIPE_DELETE_AFTER;
                        }
                    }
                    canvas.translate(anchorDrawLeft - this.left, anchorDrawTop - this.top);
                    this.lastLeft = anchorDrawLeft;
                    this.lastTop = anchorDrawTop;
                }
            }
            this.action.paint.setColor(this.action.mTextColor);
            this.action.draw(canvas);
            canvas.restore();
        }

        private void startAnimator(float f, float f2, float f3, float f4, int i) {
            com.up366.qmui.util.QMUIViewHelper.clearValueAnimator(this.animator);
            if (isVer(i)) {
                this.animator = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
                this.animStartTop = f2;
            } else {
                this.animator = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
                this.animStartLeft = f;
            }
            this.animator.setDuration(java.lang.Math.min(MAX_SWIPE_MOVE_DURATION, (int) ((isVer(i) ? java.lang.Math.abs(f4 - f2) : java.lang.Math.abs(f3 - f)) / this.action.mSwipePxPerMS)));
            this.animator.setInterpolator(this.action.mSwipeMoveInterpolator);
            this.animator.addUpdateListener(this.listener);
            this.animator.start();
        }

        private float getAnchorDrawLeft(int i) {
            if (i == 1) {
                if (this.left > this.targetLeft) {
                    return getFollowDrawLeft(i);
                }
            } else if (i == 2 && this.left < this.targetLeft) {
                return getFollowDrawLeft(i);
            }
            return this.targetLeft + ((this.measureWidth - this.action.contentWidth) / 2.0f);
        }

        private float getAnchorDrawTop(int i) {
            if (i == 3) {
                if (this.top > this.targetTop) {
                    return getFollowDrawTop(i);
                }
            } else if (i == 4 && this.top < this.targetTop) {
                return getFollowDrawTop(i);
            }
            return this.targetTop + ((this.measureHeight - this.action.contentHeight) / 2.0f);
        }

        private float getFollowDrawLeft(int i) {
            float f;
            float f2 = (this.measureWidth - this.action.contentWidth) / 2.0f;
            if (i == 1) {
                f = this.left;
            } else if (i == 2) {
                f = (this.left + this.width) - this.measureWidth;
            } else {
                f = this.left;
                f2 = (this.width - this.action.contentWidth) / 2.0f;
            }
            return f + f2;
        }

        private float getFollowDrawTop(int i) {
            float f;
            float f2 = (this.measureHeight - this.action.contentHeight) / 2.0f;
            if (i == 3) {
                f = this.top;
            } else if (i == 4) {
                f = (this.top + this.height) - this.measureHeight;
            } else {
                f = this.top;
                f2 = (this.height - this.action.contentHeight) / 2.0f;
            }
            return f + f2;
        }
    }
}
