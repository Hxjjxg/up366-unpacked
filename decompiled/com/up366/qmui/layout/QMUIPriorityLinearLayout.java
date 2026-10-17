package com.up366.qmui.layout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIPriorityLinearLayout extends com.up366.qmui.layout.QMUILinearLayout {
    private java.util.ArrayList<android.view.View> mTempDisposableChildList;
    private java.util.ArrayList<android.view.View> mTempMiniWidthChildList;

    public QMUIPriorityLinearLayout(android.content.Context context) {
        super(context);
        this.mTempMiniWidthChildList = new java.util.ArrayList<>();
        this.mTempDisposableChildList = new java.util.ArrayList<>();
    }

    public QMUIPriorityLinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempMiniWidthChildList = new java.util.ArrayList<>();
        this.mTempDisposableChildList = new java.util.ArrayList<>();
    }

    @Override // com.up366.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getOrientation() == 0) {
            handleHorizontal(i, i2);
        } else {
            handleVertical(i, i2);
        }
        super.onMeasure(i, i2);
    }

    private void handleHorizontal(int i, int i2) {
        int size = (android.view.View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int mode = android.view.View.MeasureSpec.getMode(i);
        int visibleChildCount = getVisibleChildCount();
        if (mode == 0 || visibleChildCount == 0 || size <= 0) {
            return;
        }
        int iHandlePriorityIncompressible = handlePriorityIncompressible(i, i2);
        if (iHandlePriorityIncompressible >= size) {
            for (android.view.View view : this.mTempMiniWidthChildList) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) view.getLayoutParams();
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.miniContentProtectionSize, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), i2);
                layoutParams.width = view.getMeasuredWidth();
            }
            java.util.Iterator<android.view.View> it = this.mTempDisposableChildList.iterator();
            while (it.hasNext()) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams2 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) it.next().getLayoutParams();
                layoutParams2.width = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
            }
            return;
        }
        int i3 = size - iHandlePriorityIncompressible;
        int iMin = 0;
        int measuredWidth = 0;
        for (android.view.View view2 : this.mTempMiniWidthChildList) {
            com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams3 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) view2.getLayoutParams();
            view2.measure(android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), i2);
            int i4 = layoutParams3.leftMargin + layoutParams3.rightMargin;
            measuredWidth += view2.getMeasuredWidth() + i4;
            iMin += java.lang.Math.min(view2.getMeasuredWidth(), layoutParams3.miniContentProtectionSize) + i4;
        }
        if (iMin >= i3) {
            for (android.view.View view3 : this.mTempMiniWidthChildList) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams4 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) view3.getLayoutParams();
                layoutParams4.width = java.lang.Math.min(view3.getMeasuredWidth(), layoutParams4.miniContentProtectionSize);
            }
            java.util.Iterator<android.view.View> it2 = this.mTempDisposableChildList.iterator();
            while (it2.hasNext()) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams5 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) it2.next().getLayoutParams();
                layoutParams5.width = 0;
                layoutParams5.leftMargin = 0;
                layoutParams5.rightMargin = 0;
            }
            return;
        }
        if (measuredWidth < i3) {
            if (this.mTempDisposableChildList.isEmpty()) {
                return;
            }
            dispatchSpaceToDisposableChildList(this.mTempDisposableChildList, i, i2, i3 - measuredWidth);
            return;
        }
        java.util.Iterator<android.view.View> it3 = this.mTempDisposableChildList.iterator();
        while (it3.hasNext()) {
            com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams6 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) it3.next().getLayoutParams();
            layoutParams6.width = 0;
            layoutParams6.leftMargin = 0;
            layoutParams6.rightMargin = 0;
        }
        if (i3 >= measuredWidth || this.mTempMiniWidthChildList.isEmpty()) {
            return;
        }
        dispatchSpaceToMiniWidthChildList(this.mTempMiniWidthChildList, i3, measuredWidth);
    }

    private void handleVertical(int i, int i2) {
        int size = (android.view.View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int visibleChildCount = getVisibleChildCount();
        if (mode == 0 || visibleChildCount == 0 || size <= 0) {
            return;
        }
        int iHandlePriorityIncompressible = handlePriorityIncompressible(i, i2);
        if (iHandlePriorityIncompressible >= size) {
            for (android.view.View view : this.mTempMiniWidthChildList) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) view.getLayoutParams();
                view.measure(i, android.view.View.MeasureSpec.makeMeasureSpec(layoutParams.miniContentProtectionSize, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER));
                layoutParams.height = view.getMeasuredHeight();
            }
            java.util.Iterator<android.view.View> it = this.mTempDisposableChildList.iterator();
            while (it.hasNext()) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams2 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) it.next().getLayoutParams();
                layoutParams2.height = 0;
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
            }
            return;
        }
        int i3 = size - iHandlePriorityIncompressible;
        int iMin = 0;
        int measuredHeight = 0;
        for (android.view.View view2 : this.mTempMiniWidthChildList) {
            com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams3 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) view2.getLayoutParams();
            view2.measure(i, android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER));
            int i4 = layoutParams3.topMargin + layoutParams3.bottomMargin;
            measuredHeight += view2.getMeasuredHeight() + i4;
            iMin += java.lang.Math.min(view2.getMeasuredHeight(), layoutParams3.miniContentProtectionSize) + i4;
        }
        if (iMin >= i3) {
            for (android.view.View view3 : this.mTempMiniWidthChildList) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams4 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) view3.getLayoutParams();
                layoutParams4.height = java.lang.Math.min(view3.getMeasuredHeight(), layoutParams4.miniContentProtectionSize);
            }
            java.util.Iterator<android.view.View> it2 = this.mTempDisposableChildList.iterator();
            while (it2.hasNext()) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams5 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) it2.next().getLayoutParams();
                layoutParams5.height = 0;
                layoutParams5.topMargin = 0;
                layoutParams5.bottomMargin = 0;
            }
            return;
        }
        if (measuredHeight < i3) {
            if (this.mTempDisposableChildList.isEmpty()) {
                return;
            }
            dispatchSpaceToDisposableChildList(this.mTempDisposableChildList, i, i2, i3 - measuredHeight);
            return;
        }
        java.util.Iterator<android.view.View> it3 = this.mTempDisposableChildList.iterator();
        while (it3.hasNext()) {
            com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams6 = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) it3.next().getLayoutParams();
            layoutParams6.width = 0;
            layoutParams6.topMargin = 0;
            layoutParams6.bottomMargin = 0;
        }
        if (i3 >= measuredHeight || this.mTempMiniWidthChildList.isEmpty()) {
            return;
        }
        dispatchSpaceToMiniWidthChildList(this.mTempMiniWidthChildList, i3, measuredHeight);
    }

    private int handlePriorityIncompressible(int i, int i2) {
        int i3;
        int i4;
        int measuredHeight;
        int size = (android.view.View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (android.view.View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        this.mTempMiniWidthChildList.clear();
        this.mTempDisposableChildList.clear();
        int orientation = getOrientation();
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            android.view.View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.backupOrRestore();
                int priority = layoutParams.getPriority(orientation);
                if (orientation == 0) {
                    i3 = layoutParams.leftMargin;
                    i4 = layoutParams.rightMargin;
                } else {
                    i3 = layoutParams.topMargin;
                    i4 = layoutParams.bottomMargin;
                }
                int i7 = i3 + i4;
                if (priority == 3) {
                    if (orientation == 0) {
                        if (layoutParams.width >= 0) {
                            measuredHeight = layoutParams.width;
                        } else {
                            childAt.measure(android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), i2);
                            measuredHeight = childAt.getMeasuredWidth();
                        }
                    } else if (layoutParams.height >= 0) {
                        measuredHeight = layoutParams.height;
                    } else {
                        childAt.measure(i, android.view.View.MeasureSpec.makeMeasureSpec(size2, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER));
                        measuredHeight = childAt.getMeasuredHeight();
                    }
                    i5 += measuredHeight + i7;
                } else if (priority == 2) {
                    this.mTempMiniWidthChildList.add(childAt);
                } else if (layoutParams.weight == 0.0f) {
                    this.mTempDisposableChildList.add(childAt);
                }
            }
        }
        return i5;
    }

    protected void dispatchSpaceToDisposableChildList(java.util.ArrayList<android.view.View> arrayList, int i, int i2, int i3) {
        int measuredWidth;
        for (android.view.View view : arrayList) {
            com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) view.getLayoutParams();
            if (getOrientation() == 0) {
                if (i3 <= 0) {
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.width = 0;
                }
                i3 -= layoutParams.leftMargin - layoutParams.rightMargin;
                if (i3 > 0) {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i3, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                    if (view.getMeasuredWidth() >= i3) {
                        layoutParams.width = i3;
                        i3 = 0;
                    } else {
                        measuredWidth = view.getMeasuredWidth();
                        i3 -= measuredWidth;
                    }
                } else {
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.width = 0;
                }
            } else {
                if (i3 <= 0) {
                    layoutParams.topMargin = 0;
                    layoutParams.bottomMargin = 0;
                    layoutParams.height = 0;
                }
                i3 -= layoutParams.topMargin - layoutParams.bottomMargin;
                if (i3 > 0) {
                    view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), android.view.View.MeasureSpec.makeMeasureSpec(i3, com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER));
                    if (view.getMeasuredHeight() >= i3) {
                        layoutParams.height = i3;
                        i3 = 0;
                    } else {
                        measuredWidth = view.getMeasuredHeight();
                        i3 -= measuredWidth;
                    }
                } else {
                    layoutParams.topMargin = 0;
                    layoutParams.bottomMargin = 0;
                    layoutParams.height = 0;
                }
            }
        }
    }

    protected void dispatchSpaceToMiniWidthChildList(java.util.ArrayList<android.view.View> arrayList, int i, int i2) {
        int i3 = i2 - i;
        if (i3 > 0) {
            java.util.Iterator<android.view.View> it = arrayList.iterator();
            while (it.hasNext()) {
                com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams layoutParams = (com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) it.next().getLayoutParams();
                if (getOrientation() == 0) {
                    layoutParams.width = java.lang.Math.max(0, (int) (r0.getMeasuredWidth() - (i3 * ((((r0.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) * 1.0f) / i2))));
                } else {
                    layoutParams.height = java.lang.Math.max(0, (int) (r0.getMeasuredHeight() - (i3 * ((((r0.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) * 1.0f) / i2))));
                }
            }
        }
    }

    private int getVisibleChildCount() {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public android.widget.LinearLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof com.up366.qmui.layout.QMUIPriorityLinearLayout.LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        static final int PRIORITY_DISPOSABLE = 1;
        static final int PRIORITY_INCOMPRESSIBLE = 3;
        static final int PRIORITY_MINI_CONTENT_PROTECTION = 2;
        private int backupBottomMargin;
        private int backupHeight;
        private int backupLeftMargin;
        private int backupRightMargin;
        private int backupTopMargin;
        private int backupWidth;
        public int miniContentProtectionSize;
        private int priority;

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupHeight = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIPriorityLinearLayout_Layout);
            this.priority = typedArrayObtainStyledAttributes.getInteger(com.qmuiteam.qmui.R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_priority, 2);
            this.miniContentProtectionSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_miniContentProtectionSize, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupHeight = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupHeight = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupHeight = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupHeight = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupHeight = com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public void setPriority(int i) {
            this.priority = i;
        }

        public int getPriority(int i) {
            if (this.weight > 0.0f) {
                return 1;
            }
            if (i == 0) {
                if (this.width >= 0) {
                    return 3;
                }
            } else if (this.height >= 0) {
                return 3;
            }
            return this.priority;
        }

        void backupOrRestore() {
            int i = this.backupWidth;
            if (i == Integer.MIN_VALUE) {
                this.backupWidth = this.width;
                this.backupLeftMargin = this.leftMargin;
                this.backupRightMargin = this.rightMargin;
            } else {
                this.width = i;
                this.leftMargin = this.backupLeftMargin;
                this.rightMargin = this.backupRightMargin;
            }
            int i2 = this.backupHeight;
            if (i2 == Integer.MIN_VALUE) {
                this.backupHeight = this.height;
                this.backupTopMargin = this.topMargin;
                this.backupBottomMargin = this.bottomMargin;
            } else {
                this.height = i2;
                this.topMargin = this.backupTopMargin;
                this.bottomMargin = this.backupBottomMargin;
            }
        }
    }
}
