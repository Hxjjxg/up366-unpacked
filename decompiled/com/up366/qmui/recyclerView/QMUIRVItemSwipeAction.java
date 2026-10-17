package com.up366.qmui.recyclerView;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIRVItemSwipeAction extends androidx.recyclerview.widget.RecyclerView.ItemDecoration implements androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener {
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_SWIPE_ACTION = 3;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 2;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 1;
    private static final boolean DEBUG = false;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int SWIPE_DOWN = 4;
    public static final int SWIPE_LEFT = 1;
    public static final int SWIPE_NONE = 0;
    public static final int SWIPE_RIGHT = 2;
    private static final int SWIPE_TRIGGERED_IMMEDIATELY = -1;
    public static final int SWIPE_UP = 3;
    private static final java.lang.String TAG = "QMUIRVItemSwipeAction";
    private com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.Callback mCallback;
    private android.view.MotionEvent mCurrentDownEvent;
    float mDx;
    float mDy;
    float mInitialTouchX;
    float mInitialTouchY;
    private float mMaxSwipeVelocity;
    androidx.recyclerview.widget.RecyclerView mRecyclerView;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private boolean mSwipeDeleteWhenOnlyOneAction;
    int mSwipeDirection;
    private float mSwipeEscapeVelocity;
    android.view.VelocityTracker mVelocityTracker;
    final java.util.List<android.view.View> mPendingCleanup = new java.util.ArrayList();
    private final float[] mTmpPosition = new float[2];
    long mDownTimeMillis = 0;
    int mActivePointerId = -1;
    java.util.List<com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation> mRecoverAnimations = new java.util.ArrayList();
    private long mPressTimeToSwipe = -1;
    private java.lang.Runnable mLongPressToSwipe = new java.lang.Runnable() { // from class: com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.1
        @Override // java.lang.Runnable
        public void run() {
            int iFindPointerIndex;
            if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCurrentDownEvent == null || (iFindPointerIndex = com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCurrentDownEvent.findPointerIndex(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId)) < 0) {
                return;
            }
            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction qMUIRVItemSwipeAction = com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this;
            qMUIRVItemSwipeAction.checkSelectForSwipe(qMUIRVItemSwipeAction.mCurrentDownEvent.getAction(), com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCurrentDownEvent, iFindPointerIndex, true);
        }
    };
    androidx.recyclerview.widget.RecyclerView.ViewHolder mSelected = null;
    private final androidx.recyclerview.widget.RecyclerView.OnItemTouchListener mOnItemTouchListener = new androidx.recyclerview.widget.RecyclerView.OnItemTouchListener() { // from class: com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.2
        public boolean onInterceptTouchEvent(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
            int iFindPointerIndex;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCurrentDownEvent != null) {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCurrentDownEvent.recycle();
                }
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCurrentDownEvent = android.view.MotionEvent.obtain(motionEvent);
                if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mPressTimeToSwipe > 0 && com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelected == null) {
                    recyclerView.postDelayed(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mLongPressToSwipe, com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mPressTimeToSwipe);
                }
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId = motionEvent.getPointerId(0);
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchX = motionEvent.getX();
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchY = motionEvent.getY();
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.obtainVelocityTracker();
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mDownTimeMillis = java.lang.System.currentTimeMillis();
                if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelected == null) {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimationFindAnimation = com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.findAnimation(motionEvent);
                    if (recoverAnimationFindAnimation != null) {
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchX -= recoverAnimationFindAnimation.mX;
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchY -= recoverAnimationFindAnimation.mY;
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.endRecoverAnimation(recoverAnimationFindAnimation.mViewHolder, true);
                        if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mPendingCleanup.remove(recoverAnimationFindAnimation.mViewHolder.itemView)) {
                            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCallback.clearView(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView, recoverAnimationFindAnimation.mViewHolder);
                        }
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.select(recoverAnimationFindAnimation.mViewHolder);
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction qMUIRVItemSwipeAction = com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this;
                        qMUIRVItemSwipeAction.updateDxDy(motionEvent, qMUIRVItemSwipeAction.mSwipeDirection, 0);
                    }
                } else if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelected instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder) {
                    if (!((com.up366.qmui.recyclerView.QMUISwipeViewHolder) com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelected).checkDown(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchX, com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchY)) {
                        if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.hitTest(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelected.itemView, com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchX, com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchY, com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelectedStartX + com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mDx, com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelectedStartY + com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mDy)) {
                            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchX -= com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mDx;
                            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchY -= com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mDy;
                        } else {
                            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.select(null);
                            return true;
                        }
                    } else {
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchX -= com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mDx;
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchY -= com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mDy;
                    }
                }
            } else if (actionMasked == 3) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId = -1;
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.select(null);
            } else if (actionMasked == 1) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.handleActionUp(motionEvent.getX(), motionEvent.getY(), com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSlop);
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId = -1;
            } else if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId)) >= 0) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.checkSelectForSwipe(actionMasked, motionEvent, iFindPointerIndex, false);
            }
            if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker.addMovement(motionEvent);
            }
            return com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelected != null;
        }

        public void onTouchEvent(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
            if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId);
            if (iFindPointerIndex >= 0) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.checkSelectForSwipe(actionMasked, motionEvent, iFindPointerIndex, false);
            }
            if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSelected == null) {
                return;
            }
            if (actionMasked == 1) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.handleActionUp(motionEvent.getX(), motionEvent.getY(), com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSlop);
                if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker.clear();
                }
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId = -1;
                return;
            }
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction qMUIRVItemSwipeAction = com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this;
                    qMUIRVItemSwipeAction.updateDxDy(motionEvent, qMUIRVItemSwipeAction.mSwipeDirection, iFindPointerIndex);
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.invalidate();
                    float x = motionEvent.getX(iFindPointerIndex);
                    float y = motionEvent.getY(iFindPointerIndex);
                    if (java.lang.Math.abs(x - com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchX) > com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSlop || java.lang.Math.abs(y - com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mInitialTouchY) > com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mSlop) {
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                        return;
                    }
                    return;
                }
                return;
            }
            if (actionMasked == 3) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.select(null);
                if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mVelocityTracker.clear();
                }
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId = -1;
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex) == com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction qMUIRVItemSwipeAction2 = com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this;
                qMUIRVItemSwipeAction2.updateDxDy(motionEvent, qMUIRVItemSwipeAction2.mSwipeDirection, actionIndex);
            }
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.select(null);
            }
        }
    };

    public void onChildViewAttachedToWindow(android.view.View view) {
    }

    public QMUIRVItemSwipeAction(boolean z, com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.Callback callback) {
        this.mCallback = callback;
        this.mSwipeDeleteWhenOnlyOneAction = z;
    }

    public void attachToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            android.content.res.Resources resources = recyclerView.getResources();
            this.mSwipeEscapeVelocity = resources.getDimension(com.qmuiteam.qmui.R.dimen.qmui_rv_swipe_action_escape_velocity);
            this.mMaxSwipeVelocity = resources.getDimension(com.qmuiteam.qmui.R.dimen.qmui_rv_swipe_action_escape_max_velocity);
            setupCallbacks();
        }
    }

    public void setPressTimeToSwipe(long j) {
        this.mPressTimeToSwipe = j;
    }

    private void setupCallbacks() {
        this.mSlop = android.view.ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        releaseVelocityTracker();
    }

    public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        float f;
        float f2;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, f, f2);
    }

    public void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        float f;
        float f2;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, f, f2, this.mSwipeDirection);
    }

    public void onChildViewDetachedFromWindow(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, childViewHolder);
        }
    }

    void updateDxDy(android.view.MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        if (i == 2) {
            this.mDx = java.lang.Math.max(0.0f, x - this.mInitialTouchX);
            this.mDy = 0.0f;
            return;
        }
        if (i == 1) {
            this.mDx = java.lang.Math.min(0.0f, x - this.mInitialTouchX);
            this.mDy = 0.0f;
        } else if (i == 4) {
            this.mDx = 0.0f;
            this.mDy = java.lang.Math.max(0.0f, y - this.mInitialTouchY);
        } else if (i == 3) {
            this.mDx = 0.0f;
            this.mDy = java.lang.Math.min(0.0f, y - this.mInitialTouchY);
        }
    }

    void checkSelectForSwipe(int i, android.view.MotionEvent motionEvent, int i2, boolean z) {
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolderFindSwipedView;
        int swipeDirection;
        if (this.mSelected == null) {
            if ((this.mPressTimeToSwipe == -1 && i != 2) || this.mRecyclerView.getScrollState() == 1 || (viewHolderFindSwipedView = findSwipedView(motionEvent, z)) == null || (swipeDirection = this.mCallback.getSwipeDirection(this.mRecyclerView, viewHolderFindSwipedView)) == 0) {
                return;
            }
            long j = this.mPressTimeToSwipe;
            if (j == -1) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                float f = x - this.mInitialTouchX;
                float f2 = y - this.mInitialTouchY;
                float fAbs = java.lang.Math.abs(f);
                float fAbs2 = java.lang.Math.abs(f2);
                if (swipeDirection == 1) {
                    if (fAbs < this.mSlop || f >= 0.0f) {
                        return;
                    }
                } else if (swipeDirection == 2) {
                    if (fAbs < this.mSlop || f <= 0.0f) {
                        return;
                    }
                } else if (swipeDirection == 3) {
                    if (fAbs2 < this.mSlop || f2 >= 0.0f) {
                        return;
                    }
                } else if (swipeDirection == 4 && (fAbs2 < this.mSlop || f2 <= 0.0f)) {
                    return;
                }
            } else if (j >= java.lang.System.currentTimeMillis() - this.mDownTimeMillis) {
                return;
            }
            this.mRecyclerView.removeCallbacks(this.mLongPressToSwipe);
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            this.mActivePointerId = motionEvent.getPointerId(0);
            android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            viewHolderFindSwipedView.itemView.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            select(viewHolderFindSwipedView);
        }
    }

    public void clear() {
        select(null, false);
    }

    void handleActionUp(float f, float f2, int i) {
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            if (viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder) {
                com.up366.qmui.recyclerView.QMUISwipeViewHolder qMUISwipeViewHolder = (com.up366.qmui.recyclerView.QMUISwipeViewHolder) viewHolder;
                if (!qMUISwipeViewHolder.hasAction()) {
                    select(null, true);
                    return;
                }
                if (qMUISwipeViewHolder.mSwipeActions.size() == 1 && this.mSwipeDeleteWhenOnlyOneAction) {
                    if (this.mCallback.isOverThreshold(this.mRecyclerView, this.mSelected, this.mDx, this.mDy, this.mSwipeDirection)) {
                        select(null, true);
                        return;
                    } else {
                        handleSwipeActionActionUp(qMUISwipeViewHolder, f, f2, i);
                        return;
                    }
                }
                handleSwipeActionActionUp(qMUISwipeViewHolder, f, f2, i);
                return;
            }
            select(null, true);
        }
    }

    void handleSwipeActionActionUp(com.up366.qmui.recyclerView.QMUISwipeViewHolder qMUISwipeViewHolder, float f, float f2, int i) {
        int i2;
        float f3;
        float f4;
        int i3;
        com.up366.qmui.recyclerView.QMUISwipeAction qMUISwipeActionCheckUp = qMUISwipeViewHolder.checkUp(f, f2, i);
        if (qMUISwipeActionCheckUp != null) {
            this.mCallback.onClickAction(this, this.mSelected, qMUISwipeActionCheckUp);
            qMUISwipeViewHolder.clearTouchInfo();
            return;
        }
        qMUISwipeViewHolder.clearTouchInfo();
        int iCheckSwipe = checkSwipe(this.mSelected, this.mSwipeDirection, true);
        if (iCheckSwipe == 0) {
            select(null, true);
            return;
        }
        getSelectedDxDy(this.mTmpPosition);
        float[] fArr = this.mTmpPosition;
        float f5 = fArr[0];
        float f6 = fArr[1];
        if (iCheckSwipe == 1) {
            i2 = -qMUISwipeViewHolder.mActionTotalWidth;
        } else if (iCheckSwipe == 2) {
            i2 = qMUISwipeViewHolder.mActionTotalWidth;
        } else {
            if (iCheckSwipe == 3) {
                i3 = -qMUISwipeViewHolder.mActionTotalHeight;
            } else if (iCheckSwipe == 4) {
                i3 = qMUISwipeViewHolder.mActionTotalHeight;
            } else {
                f3 = 0.0f;
                f4 = 0.0f;
                float f7 = f3 - f5;
                this.mDx += f7;
                float f8 = f4 - f6;
                this.mDy += f8;
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation = new com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation(qMUISwipeViewHolder, f5, f6, f3, f4, this.mCallback.getInterpolator(3));
                recoverAnimation.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, 3, f7, f8));
                this.mRecoverAnimations.add(recoverAnimation);
                recoverAnimation.start();
                this.mRecyclerView.invalidate();
            }
            f4 = i3;
            f3 = 0.0f;
            float f72 = f3 - f5;
            this.mDx += f72;
            float f82 = f4 - f6;
            this.mDy += f82;
            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation2 = new com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation(qMUISwipeViewHolder, f5, f6, f3, f4, this.mCallback.getInterpolator(3));
            recoverAnimation2.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, 3, f72, f82));
            this.mRecoverAnimations.add(recoverAnimation2);
            recoverAnimation2.start();
            this.mRecyclerView.invalidate();
        }
        f3 = i2;
        f4 = 0.0f;
        float f722 = f3 - f5;
        this.mDx += f722;
        float f822 = f4 - f6;
        this.mDy += f822;
        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation22 = new com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation(qMUISwipeViewHolder, f5, f6, f3, f4, this.mCallback.getInterpolator(3));
        recoverAnimation22.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, 3, f722, f822));
        this.mRecoverAnimations.add(recoverAnimation22);
        recoverAnimation22.start();
        this.mRecyclerView.invalidate();
    }

    void select(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        select(viewHolder, false);
    }

    void select(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, boolean z) {
        boolean z2;
        float fSignum;
        float fSignum2;
        if (viewHolder == this.mSelected) {
            return;
        }
        endRecoverAnimation(viewHolder, true);
        final androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder2 = this.mSelected;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                endRecoverAnimation(viewHolder2, true);
                final int iCheckSwipe = z ? checkSwipe(this.mSelected, this.mSwipeDirection, false) : 0;
                getSelectedDxDy(this.mTmpPosition);
                float[] fArr = this.mTmpPosition;
                float f = fArr[0];
                float f2 = fArr[1];
                if (iCheckSwipe == 1 || iCheckSwipe == 2) {
                    fSignum = 0.0f;
                    fSignum2 = java.lang.Math.signum(this.mDx) * this.mRecyclerView.getWidth();
                } else if (iCheckSwipe == 3 || iCheckSwipe == 4) {
                    fSignum2 = 0.0f;
                    fSignum = java.lang.Math.signum(this.mDy) * this.mRecyclerView.getHeight();
                } else {
                    fSignum2 = 0.0f;
                    fSignum = 0.0f;
                }
                int i = iCheckSwipe > 0 ? 1 : 2;
                if (iCheckSwipe > 0) {
                    this.mCallback.onStartSwipeAnimation(this.mSelected, iCheckSwipe);
                }
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation = new com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation(viewHolder2, f, f2, fSignum2, fSignum, this.mCallback.getInterpolator(3)) { // from class: com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.3
                    @Override // com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(android.animation.Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.mOverridden) {
                            return;
                        }
                        if (iCheckSwipe == 0) {
                            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCallback.clearView(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView, viewHolder2);
                            return;
                        }
                        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mPendingCleanup.add(viewHolder2.itemView);
                        this.mIsPendingCleanup = true;
                        int i2 = iCheckSwipe;
                        if (i2 > 0) {
                            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.postDispatchSwipe(this, i2);
                        }
                    }
                };
                recoverAnimation.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i, fSignum2 - f, fSignum - f2));
                this.mRecoverAnimations.add(recoverAnimation);
                recoverAnimation.start();
                z2 = true;
            } else {
                this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                z2 = false;
            }
            this.mSelected = null;
        } else {
            z2 = false;
        }
        if (viewHolder != null) {
            this.mSwipeDirection = this.mCallback.getSwipeDirection(this.mRecyclerView, viewHolder);
            this.mSelectedStartX = viewHolder.itemView.getLeft();
            this.mSelectedStartY = viewHolder.itemView.getTop();
            this.mSelected = viewHolder;
            if (viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder) {
                ((com.up366.qmui.recyclerView.QMUISwipeViewHolder) viewHolder).setup(this.mSwipeDirection, this.mSwipeDeleteWhenOnlyOneAction);
            }
        }
        android.view.ViewParent parent = this.mRecyclerView.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.mSelected != null);
        }
        if (!z2) {
            this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        this.mCallback.onSelectedChanged(this.mSelected);
        this.mRecyclerView.invalidate();
    }

    private void getSelectedDxDy(float[] fArr) {
        int i = this.mSwipeDirection;
        if (i == 1 || i == 2) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
        } else {
            fArr[0] = this.mSelected.itemView.getTranslationX();
        }
        int i2 = this.mSwipeDirection;
        if (i2 == 3 || i2 == 4) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        } else {
            fArr[1] = this.mSelected.itemView.getTranslationY();
        }
    }

    void postDispatchSwipe(final com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation, final int i) {
        this.mRecyclerView.post(new java.lang.Runnable() { // from class: com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.4
            @Override // java.lang.Runnable
            public void run() {
                if (com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView == null || !com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.isAttachedToWindow() || recoverAnimation.mOverridden || recoverAnimation.mViewHolder.getAdapterPosition() == -1) {
                    return;
                }
                androidx.recyclerview.widget.RecyclerView.ItemAnimator itemAnimator = com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.isRunning((androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener) null)) && !com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.hasRunningRecoverAnim()) {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i);
                } else {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.this.mRecyclerView.post(this);
                }
            }
        });
    }

    boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i = 0; i < size; i++) {
            if (!this.mRecoverAnimations.get(i).mEnded) {
                return true;
            }
        }
        return false;
    }

    private int checkSwipe(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i, boolean z) {
        float swipeThreshold;
        float swipeThreshold2;
        if (i == 1 || i == 2) {
            int i2 = this.mDx > 0.0f ? 2 : 1;
            android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null && this.mActivePointerId > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                int i3 = xVelocity <= 0.0f ? 1 : 2;
                float fAbs = java.lang.Math.abs(xVelocity);
                if (i2 == i3 && fAbs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) {
                    return i3;
                }
            }
            if (z && (viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder)) {
                swipeThreshold = ((com.up366.qmui.recyclerView.QMUISwipeViewHolder) viewHolder).mActionTotalWidth;
            } else {
                swipeThreshold = this.mCallback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getWidth();
            }
            if (java.lang.Math.abs(this.mDx) >= swipeThreshold) {
                return i2;
            }
            return 0;
        }
        if (i != 3 && i != 4) {
            return 0;
        }
        int i4 = this.mDy > 0.0f ? 4 : 3;
        android.view.VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null && this.mActivePointerId > -1) {
            velocityTracker2.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            int i5 = yVelocity <= 0.0f ? 3 : 4;
            float fAbs2 = java.lang.Math.abs(yVelocity);
            if (i5 == i4 && fAbs2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) {
                return i5;
            }
        }
        if (z && (viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder)) {
            swipeThreshold2 = ((com.up366.qmui.recyclerView.QMUISwipeViewHolder) viewHolder).mActionTotalHeight;
        } else {
            swipeThreshold2 = this.mCallback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getHeight();
        }
        if (java.lang.Math.abs(this.mDy) >= swipeThreshold2) {
            return i4;
        }
        return 0;
    }

    private androidx.recyclerview.widget.RecyclerView.ViewHolder findSwipedView(android.view.MotionEvent motionEvent, boolean z) {
        android.view.View viewFindChildView;
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i = this.mActivePointerId;
        if (i == -1 || layoutManager == null) {
            return null;
        }
        if (z) {
            android.view.View viewFindChildView2 = findChildView(motionEvent);
            if (viewFindChildView2 == null) {
                return null;
            }
            return this.mRecyclerView.getChildViewHolder(viewFindChildView2);
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(iFindPointerIndex) - this.mInitialTouchX;
        float y = motionEvent.getY(iFindPointerIndex) - this.mInitialTouchY;
        float fAbs = java.lang.Math.abs(x);
        float fAbs2 = java.lang.Math.abs(y);
        int i2 = this.mSlop;
        if (fAbs < i2 && fAbs2 < i2) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.canScrollVertically()) && (viewFindChildView = findChildView(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(viewFindChildView);
        }
        return null;
    }

    void endRecoverAnimation(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return;
            }
        }
    }

    android.view.View findChildView(android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            android.view.View view = viewHolder.itemView;
            if (hitTest(view, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            android.view.View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x, y, recoverAnimation.mX, recoverAnimation.mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation findAnimation(android.view.MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        android.view.View viewFindChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == viewFindChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    void obtainVelocityTracker() {
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = android.view.VelocityTracker.obtain();
    }

    private void releaseVelocityTracker() {
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hitTest(android.view.View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    private static class RecoverAnimation implements android.animation.Animator.AnimatorListener {
        private float mFraction;
        boolean mIsPendingCleanup;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final android.animation.ValueAnimator mValueAnimator;
        final androidx.recyclerview.widget.RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;
        boolean mOverridden = false;
        boolean mEnded = false;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        RecoverAnimation(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float f, float f2, float f3, float f4, android.animation.TimeInterpolator timeInterpolator) {
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            valueAnimatorOfFloat.setTarget(viewHolder.itemView);
            valueAnimatorOfFloat.addListener(this);
            valueAnimatorOfFloat.setInterpolator(timeInterpolator);
            setFraction(0.0f);
        }

        public void setDuration(long j) {
            this.mValueAnimator.setDuration(j);
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public void update() {
            float f = this.mStartDx;
            float f2 = this.mTargetX;
            if (f == f2) {
                this.mX = this.mViewHolder.itemView.getTranslationX();
            } else {
                this.mX = f + (this.mFraction * (f2 - f));
            }
            float f3 = this.mStartDy;
            float f4 = this.mTargetY;
            if (f3 == f4) {
                this.mY = this.mViewHolder.itemView.getTranslationY();
            } else {
                this.mY = f3 + (this.mFraction * (f4 - f3));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
            setFraction(1.0f);
        }
    }

    public static abstract class Callback {
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        public long getAnimationDuration(androidx.recyclerview.widget.RecyclerView recyclerView, int i, float f, float f2) {
            return 250L;
        }

        public android.animation.TimeInterpolator getInterpolator(int i) {
            return null;
        }

        public int getSwipeDirection(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            return 0;
        }

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public void onChildDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z) {
        }

        public void onClickAction(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction qMUIRVItemSwipeAction, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, com.up366.qmui.recyclerView.QMUISwipeAction qMUISwipeAction) {
        }

        public void onSelectedChanged(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        }

        public void onStartSwipeAnimation(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        }

        public void onSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        }

        public void clearView(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
            android.view.View view = viewHolder.itemView;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            if (viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder) {
                ((com.up366.qmui.recyclerView.QMUISwipeViewHolder) viewHolder).clearTouchInfo();
            }
        }

        void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, java.util.List<com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation> list, float f, float f2, int i) {
            int size = list.size();
            float f3 = f;
            float f4 = f2;
            for (int i2 = 0; i2 < size; i2++) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.update();
                if (recoverAnimation.mViewHolder == viewHolder) {
                    float f5 = recoverAnimation.mX;
                    f4 = recoverAnimation.mY;
                    f3 = f5;
                } else {
                    int iSave = canvas.save();
                    onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, false, i);
                    canvas.restoreToCount(iSave);
                }
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f3, f4, true, i);
                canvas.restoreToCount(iSave2);
            }
        }

        void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, java.util.List<com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation> list, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation = list.get(i);
                int iSave = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation recoverAnimation2 = list.get(i2);
                if (recoverAnimation2.mEnded && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(i2);
                } else if (!recoverAnimation2.mEnded) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        protected boolean isOverThreshold(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float f, float f2, int i) {
            return (i == 1 || i == 2) ? java.lang.Math.abs(f) >= ((float) recyclerView.getWidth()) * getSwipeThreshold(viewHolder) : java.lang.Math.abs(f2) >= ((float) recyclerView.getHeight()) * getSwipeThreshold(viewHolder);
        }

        public void onChildDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z, int i) {
            android.view.View view = viewHolder.itemView;
            view.setTranslationX(f);
            view.setTranslationY(f2);
            if (!(viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder) || i == 0) {
                return;
            }
            ((com.up366.qmui.recyclerView.QMUISwipeViewHolder) viewHolder).draw(canvas, isOverThreshold(recyclerView, viewHolder, f, f2, i), f, f2);
        }
    }
}
