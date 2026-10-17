package com.up366.qmui.skin;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinLayoutInflaterFactory implements android.view.LayoutInflater.Factory2 {
    private static final java.lang.String TAG = "QMUISkin";
    private static final java.lang.String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.app.", "android.view."};
    private static final java.util.HashMap<java.lang.String, java.lang.String> sSuccessClassNamePrefixMap = new java.util.HashMap<>();
    private java.lang.ref.WeakReference<android.app.Activity> mActivityWeakReference;
    private android.content.res.Resources.Theme mEmptyTheme;
    private android.view.LayoutInflater mOriginLayoutInflater;

    public QMUISkinLayoutInflaterFactory(android.app.Activity activity, android.view.LayoutInflater layoutInflater) {
        this.mActivityWeakReference = new java.lang.ref.WeakReference<>(activity);
        this.mOriginLayoutInflater = layoutInflater;
    }

    @Override // android.view.LayoutInflater.Factory2
    public android.view.View onCreateView(android.view.View view, java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        androidx.appcompat.app.AppCompatActivity appCompatActivity = (android.app.Activity) this.mActivityWeakReference.get();
        android.view.View viewCreateView = appCompatActivity instanceof androidx.appcompat.app.AppCompatActivity ? appCompatActivity.getDelegate().createView(view, str, context, attributeSet) : null;
        if (viewCreateView == null) {
            try {
                if (!str.contains(".")) {
                    java.util.HashMap<java.lang.String, java.lang.String> map = sSuccessClassNamePrefixMap;
                    if (map.containsKey(str)) {
                        viewCreateView = android.view.LayoutInflater.from(context).createView(str, map.get(str), attributeSet);
                    } else {
                        java.lang.String[] strArr = sClassPrefixList;
                        int length = strArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            java.lang.String str2 = strArr[i];
                            viewCreateView = this.mOriginLayoutInflater.createView(str, str2, attributeSet);
                            if (viewCreateView != null) {
                                sSuccessClassNamePrefixMap.put(str, str2);
                                break;
                            }
                            i++;
                        }
                    }
                } else {
                    viewCreateView = this.mOriginLayoutInflater.createView(str, null, attributeSet);
                }
            } catch (java.lang.ClassNotFoundException unused) {
            } catch (java.lang.Exception e) {
                com.up366.qmui.QMUILog.e(TAG, "Failed to inflate view " + str + "; error: " + e.getMessage(), new java.lang.Object[0]);
            }
        }
        if (viewCreateView != null) {
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            getSkinValueFromAttributeSet(viewCreateView.getContext(), attributeSet, qMUISkinValueBuilderAcquire);
            if (!qMUISkinValueBuilderAcquire.isEmpty()) {
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue(viewCreateView, qMUISkinValueBuilderAcquire);
            }
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        }
        return viewCreateView;
    }

    @Override // android.view.LayoutInflater.Factory
    public android.view.View onCreateView(java.lang.String str, android.content.Context context, android.util.AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void getSkinValueFromAttributeSet(android.content.Context context, android.util.AttributeSet attributeSet, com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        if (this.mEmptyTheme == null) {
            this.mEmptyTheme = context.getApplicationContext().getResources().newTheme();
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = this.mEmptyTheme.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUISkinDef, 0, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            java.lang.String string = typedArrayObtainStyledAttributes.getString(index);
            if (!com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(string)) {
                if (string.startsWith("?")) {
                    string = string.substring(1);
                }
                int identifier = context.getResources().getIdentifier(string, "attr", context.getPackageName());
                if (identifier != 0) {
                    if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_background) {
                        qMUISkinValueBuilder.background(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_alpha) {
                        qMUISkinValueBuilder.alpha(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_border) {
                        qMUISkinValueBuilder.border(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_text_color) {
                        qMUISkinValueBuilder.textColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_second_text_color) {
                        qMUISkinValueBuilder.secondTextColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_src) {
                        qMUISkinValueBuilder.src(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_tint_color) {
                        qMUISkinValueBuilder.tintColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_separator_top) {
                        qMUISkinValueBuilder.topSeparator(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_separator_right) {
                        qMUISkinValueBuilder.rightSeparator(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_separator_bottom) {
                        qMUISkinValueBuilder.bottomSeparator(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_separator_left) {
                        qMUISkinValueBuilder.leftSeparator(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_bg_tint_color) {
                        qMUISkinValueBuilder.bgTintColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_progress_color) {
                        qMUISkinValueBuilder.progressColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_underline) {
                        qMUISkinValueBuilder.underline(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_more_bg_color) {
                        qMUISkinValueBuilder.moreBgColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_more_text_color) {
                        qMUISkinValueBuilder.moreTextColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_hint_color) {
                        qMUISkinValueBuilder.hintColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_text_compound_tint_color) {
                        qMUISkinValueBuilder.textCompoundTintColor(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_text_compound_src_left) {
                        qMUISkinValueBuilder.textCompoundLeftSrc(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_text_compound_src_top) {
                        qMUISkinValueBuilder.textCompoundTopSrc(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_text_compound_src_right) {
                        qMUISkinValueBuilder.textCompoundRightSrc(identifier);
                    } else if (index == com.qmuiteam.qmui.R.styleable.QMUISkinDef_qmui_skin_text_compound_src_bottom) {
                        qMUISkinValueBuilder.textCompoundBottomSrc(identifier);
                    }
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
