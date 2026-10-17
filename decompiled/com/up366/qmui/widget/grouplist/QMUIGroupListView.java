package com.up366.qmui.widget.grouplist;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIGroupListView extends android.widget.LinearLayout {
    private android.util.SparseArray<com.up366.qmui.widget.grouplist.QMUIGroupListView.Section> mSections;

    public QMUIGroupListView(android.content.Context context) {
        this(context, null);
    }

    public QMUIGroupListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIGroupListView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSections = new android.util.SparseArray<>();
        setOrientation(1);
    }

    public static com.up366.qmui.widget.grouplist.QMUIGroupListView.Section newSection(android.content.Context context) {
        return new com.up366.qmui.widget.grouplist.QMUIGroupListView.Section(context);
    }

    public int getSectionCount() {
        return this.mSections.size();
    }

    public com.up366.qmui.widget.grouplist.QMUICommonListItemView createItemView(android.graphics.drawable.Drawable drawable, java.lang.CharSequence charSequence, java.lang.String str, int i, int i2, int i3) {
        com.up366.qmui.widget.grouplist.QMUICommonListItemView qMUICommonListItemView = new com.up366.qmui.widget.grouplist.QMUICommonListItemView(getContext());
        qMUICommonListItemView.setOrientation(i);
        qMUICommonListItemView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, i3));
        qMUICommonListItemView.setImageDrawable(drawable);
        qMUICommonListItemView.setText(charSequence);
        qMUICommonListItemView.setDetailText(str);
        qMUICommonListItemView.setAccessoryType(i2);
        return qMUICommonListItemView;
    }

    public com.up366.qmui.widget.grouplist.QMUICommonListItemView createItemView(android.graphics.drawable.Drawable drawable, java.lang.CharSequence charSequence, java.lang.String str, int i, int i2) {
        if (i == 0) {
            return createItemView(drawable, charSequence, str, i, i2, com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_list_item_height_higher));
        }
        return createItemView(drawable, charSequence, str, i, i2, com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_list_item_height));
    }

    public com.up366.qmui.widget.grouplist.QMUICommonListItemView createItemView(java.lang.CharSequence charSequence) {
        return createItemView(null, charSequence, null, 1, 0);
    }

    public com.up366.qmui.widget.grouplist.QMUICommonListItemView createItemView(int i) {
        return createItemView(null, null, null, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSection(com.up366.qmui.widget.grouplist.QMUIGroupListView.Section section) {
        android.util.SparseArray<com.up366.qmui.widget.grouplist.QMUIGroupListView.Section> sparseArray = this.mSections;
        sparseArray.append(sparseArray.size(), section);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSection(com.up366.qmui.widget.grouplist.QMUIGroupListView.Section section) {
        for (int i = 0; i < this.mSections.size(); i++) {
            if (this.mSections.valueAt(i) == section) {
                this.mSections.remove(i);
            }
        }
    }

    public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section getSection(int i) {
        return this.mSections.get(i);
    }

    public static class Section {
        private android.content.Context mContext;
        private com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView mDescriptionView;
        private com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView mTitleView;
        private boolean mUseDefaultTitleIfNone;
        private boolean mUseTitleViewForSectionSpace = true;
        private int mSeparatorColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_common_list_separator_color;
        private boolean mHandleSeparatorCustom = false;
        private boolean mShowSeparator = true;
        private boolean mOnlyShowStartEndSeparator = false;
        private boolean mOnlyShowMiddleSeparator = false;
        private int mMiddleSeparatorInsetLeft = 0;
        private int mMiddleSeparatorInsetRight = 0;
        private int mBgAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_s_common_list_bg;
        private int mLeftIconWidth = -2;
        private int mLeftIconHeight = -2;
        private android.util.SparseArray<com.up366.qmui.widget.grouplist.QMUICommonListItemView> mItemViews = new android.util.SparseArray<>();

        public Section(android.content.Context context) {
            this.mContext = context;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section addItemView(com.up366.qmui.widget.grouplist.QMUICommonListItemView qMUICommonListItemView, android.view.View.OnClickListener onClickListener) {
            return addItemView(qMUICommonListItemView, onClickListener, null);
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section addItemView(com.up366.qmui.widget.grouplist.QMUICommonListItemView qMUICommonListItemView, android.view.View.OnClickListener onClickListener, android.view.View.OnLongClickListener onLongClickListener) {
            if (onClickListener != null) {
                qMUICommonListItemView.setOnClickListener(onClickListener);
            }
            if (onLongClickListener != null) {
                qMUICommonListItemView.setOnLongClickListener(onLongClickListener);
            }
            android.util.SparseArray<com.up366.qmui.widget.grouplist.QMUICommonListItemView> sparseArray = this.mItemViews;
            sparseArray.append(sparseArray.size(), qMUICommonListItemView);
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setTitle(java.lang.CharSequence charSequence) {
            this.mTitleView = createSectionHeader(charSequence);
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setDescription(java.lang.CharSequence charSequence) {
            this.mDescriptionView = createSectionFooter(charSequence);
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setUseDefaultTitleIfNone(boolean z) {
            this.mUseDefaultTitleIfNone = z;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setUseTitleViewForSectionSpace(boolean z) {
            this.mUseTitleViewForSectionSpace = z;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setLeftIconSize(int i, int i2) {
            this.mLeftIconHeight = i2;
            this.mLeftIconWidth = i;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setSeparatorColorAttr(int i) {
            this.mSeparatorColorAttr = i;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setHandleSeparatorCustom(boolean z) {
            this.mHandleSeparatorCustom = z;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setShowSeparator(boolean z) {
            this.mShowSeparator = z;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setOnlyShowStartEndSeparator(boolean z) {
            this.mOnlyShowStartEndSeparator = z;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setOnlyShowMiddleSeparator(boolean z) {
            this.mOnlyShowMiddleSeparator = z;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setMiddleSeparatorInset(int i, int i2) {
            this.mMiddleSeparatorInsetLeft = i;
            this.mMiddleSeparatorInsetRight = i2;
            return this;
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListView.Section setBgAttr(int i) {
            this.mBgAttr = i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v2, types: [android.view.View, com.up366.qmui.widget.grouplist.QMUICommonListItemView] */
        public void addTo(com.up366.qmui.widget.grouplist.QMUIGroupListView qMUIGroupListView) {
            if (this.mTitleView == null) {
                if (this.mUseDefaultTitleIfNone) {
                    setTitle("Section " + qMUIGroupListView.getSectionCount());
                } else if (this.mUseTitleViewForSectionSpace) {
                    setTitle("");
                }
            }
            com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView qMUIGroupListSectionHeaderFooterView = this.mTitleView;
            if (qMUIGroupListSectionHeaderFooterView != null) {
                qMUIGroupListView.addView(qMUIGroupListSectionHeaderFooterView);
            }
            int size = this.mItemViews.size();
            com.up366.qmui.widget.grouplist.QMUICommonListItemView.LayoutParamConfig layoutParamConfig = new com.up366.qmui.widget.grouplist.QMUICommonListItemView.LayoutParamConfig() { // from class: com.up366.qmui.widget.grouplist.QMUIGroupListView.Section.1
                @Override // com.up366.qmui.widget.grouplist.QMUICommonListItemView.LayoutParamConfig
                public androidx.constraintlayout.widget.ConstraintLayout.LayoutParams onConfig(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams) {
                    layoutParams.width = com.up366.qmui.widget.grouplist.QMUIGroupListView.Section.this.mLeftIconWidth;
                    layoutParams.height = com.up366.qmui.widget.grouplist.QMUIGroupListView.Section.this.mLeftIconHeight;
                    return layoutParams;
                }
            };
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            java.lang.String strBuild = qMUISkinValueBuilderAcquire.background(this.mBgAttr).topSeparator(this.mSeparatorColorAttr).bottomSeparator(this.mSeparatorColorAttr).build();
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            int attrColor = com.up366.qmui.util.QMUIResHelper.getAttrColor(qMUIGroupListView.getContext(), this.mSeparatorColorAttr);
            for (int i = 0; i < size; i++) {
                com.up366.qmui.widget.grouplist.QMUICommonListItemView qMUICommonListItemView = this.mItemViews.get(i);
                android.graphics.drawable.Drawable skinDrawable = com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(qMUIGroupListView, this.mBgAttr);
                com.up366.qmui.util.QMUIViewHelper.setBackgroundKeepingPadding((android.view.View) qMUICommonListItemView, skinDrawable == null ? null : skinDrawable.mutate());
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUICommonListItemView, strBuild);
                if (!this.mHandleSeparatorCustom && this.mShowSeparator) {
                    if (size == 1) {
                        qMUICommonListItemView.updateTopDivider(0, 0, 1, attrColor);
                        qMUICommonListItemView.updateBottomDivider(0, 0, 1, attrColor);
                    } else if (i == 0) {
                        if (!this.mOnlyShowMiddleSeparator) {
                            qMUICommonListItemView.updateTopDivider(0, 0, 1, attrColor);
                        }
                        if (!this.mOnlyShowStartEndSeparator) {
                            qMUICommonListItemView.updateBottomDivider(this.mMiddleSeparatorInsetLeft, this.mMiddleSeparatorInsetRight, 1, attrColor);
                        }
                    } else if (i == size - 1) {
                        if (!this.mOnlyShowMiddleSeparator) {
                            qMUICommonListItemView.updateBottomDivider(0, 0, 1, attrColor);
                        }
                    } else if (!this.mOnlyShowStartEndSeparator) {
                        qMUICommonListItemView.updateBottomDivider(this.mMiddleSeparatorInsetLeft, this.mMiddleSeparatorInsetRight, 1, attrColor);
                    }
                }
                qMUICommonListItemView.updateImageViewLp(layoutParamConfig);
                qMUIGroupListView.addView(qMUICommonListItemView);
            }
            com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView qMUIGroupListSectionHeaderFooterView2 = this.mDescriptionView;
            if (qMUIGroupListSectionHeaderFooterView2 != null) {
                qMUIGroupListView.addView(qMUIGroupListSectionHeaderFooterView2);
            }
            qMUIGroupListView.addSection(this);
        }

        public void removeFrom(com.up366.qmui.widget.grouplist.QMUIGroupListView qMUIGroupListView) {
            com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView qMUIGroupListSectionHeaderFooterView = this.mTitleView;
            if (qMUIGroupListSectionHeaderFooterView != null && qMUIGroupListSectionHeaderFooterView.getParent() == qMUIGroupListView) {
                qMUIGroupListView.removeView(this.mTitleView);
            }
            for (int i = 0; i < this.mItemViews.size(); i++) {
                qMUIGroupListView.removeView((com.up366.qmui.widget.grouplist.QMUICommonListItemView) this.mItemViews.get(i));
            }
            com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView qMUIGroupListSectionHeaderFooterView2 = this.mDescriptionView;
            if (qMUIGroupListSectionHeaderFooterView2 != null && qMUIGroupListSectionHeaderFooterView2.getParent() == qMUIGroupListView) {
                qMUIGroupListView.removeView(this.mDescriptionView);
            }
            qMUIGroupListView.removeSection(this);
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView createSectionHeader(java.lang.CharSequence charSequence) {
            return new com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView(this.mContext, charSequence);
        }

        public com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView createSectionFooter(java.lang.CharSequence charSequence) {
            return new com.up366.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView(this.mContext, charSequence, true);
        }
    }
}
