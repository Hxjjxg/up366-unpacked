package com.up366.qmui.skin;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class QMUISkinManager {
    private static final java.lang.String DEFAULT_NAME = "default";
    public static final int DEFAULT_SKIN = -1;
    private static final java.lang.String TAG = "QMUISkinManager";
    private static android.view.ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private static android.view.View.OnLayoutChangeListener mOnLayoutChangeListener;
    private java.lang.String mName;
    private java.lang.String mPackageName;
    private android.content.res.Resources mResources;
    private static final java.lang.String[] EMPTY_ITEMS = new java.lang.String[0];
    private static android.util.ArrayMap<java.lang.String, com.up366.qmui.skin.QMUISkinManager> sInstances = new android.util.ArrayMap<>();
    private static java.util.HashMap<java.lang.String, com.up366.qmui.skin.handler.IQMUISkinRuleHandler> sRuleHandlers = new java.util.HashMap<>();
    private static java.util.HashMap<java.lang.Integer, android.content.res.Resources.Theme> sStyleIdThemeMap = new java.util.HashMap<>();
    private android.util.SparseArray<com.up366.qmui.skin.QMUISkinManager.SkinItem> mSkins = new android.util.SparseArray<>();
    private int mCurrentSkin = -1;
    private final java.util.List<java.lang.ref.WeakReference<?>> mSkinObserverList = new java.util.ArrayList();
    private final java.util.List<java.lang.ref.WeakReference<com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener>> mSkinChangeListeners = new java.util.ArrayList();

    public interface OnSkinChangeListener {
        void onSkinChange(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, int i2);
    }

    static {
        sRuleHandlers.put("background", new com.up366.qmui.skin.handler.QMUISkinRuleBackgroundHandler());
        com.up366.qmui.skin.handler.QMUISkinRuleTextColorHandler qMUISkinRuleTextColorHandler = new com.up366.qmui.skin.handler.QMUISkinRuleTextColorHandler();
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, qMUISkinRuleTextColorHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.SECOND_TEXT_COLOR, qMUISkinRuleTextColorHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.SRC, new com.up366.qmui.skin.handler.QMUISkinRuleSrcHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.BORDER, new com.up366.qmui.skin.handler.QMUISkinRuleBorderHandler());
        com.up366.qmui.skin.handler.QMUISkinRuleSeparatorHandler qMUISkinRuleSeparatorHandler = new com.up366.qmui.skin.handler.QMUISkinRuleSeparatorHandler();
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TOP_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.RIGHT_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.BOTTOM_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.LEFT_SEPARATOR, qMUISkinRuleSeparatorHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TINT_COLOR, new com.up366.qmui.skin.handler.QMUISkinRuleTintColorHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.ALPHA, new com.up366.qmui.skin.handler.QMUISkinRuleAlphaHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.BG_TINT_COLOR, new com.up366.qmui.skin.handler.QMUISkinRuleBgTintColorHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.PROGRESS_COLOR, new com.up366.qmui.skin.handler.QMUISkinRuleProgressColorHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_TINT_COLOR, new com.up366.qmui.skin.handler.QMUISkinRuleTextCompoundTintColorHandler());
        com.up366.qmui.skin.handler.QMUISkinRuleTextCompoundSrcHandler qMUISkinRuleTextCompoundSrcHandler = new com.up366.qmui.skin.handler.QMUISkinRuleTextCompoundSrcHandler();
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_LEFT_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_TOP_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_RIGHT_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COMPOUND_BOTTOM_SRC, qMUISkinRuleTextCompoundSrcHandler);
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.HINT_COLOR, new com.up366.qmui.skin.handler.QMUISkinRuleHintColorHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.UNDERLINE, new com.up366.qmui.skin.handler.QMUISkinRuleUnderlineHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.MORE_TEXT_COLOR, new com.up366.qmui.skin.handler.QMUISkinRuleMoreTextColorHandler());
        sRuleHandlers.put(com.up366.qmui.skin.QMUISkinValueBuilder.MORE_BG_COLOR, new com.up366.qmui.skin.handler.QMUISkinRuleMoreBgColorHandler());
        mOnLayoutChangeListener = new android.view.View.OnLayoutChangeListener() { // from class: com.up366.qmui.skin.QMUISkinManager.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                android.view.ViewGroup viewGroup;
                int childCount;
                com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent;
                if (!(view instanceof android.view.ViewGroup) || (childCount = (viewGroup = (android.view.ViewGroup) view).getChildCount()) <= 0 || (viewSkinCurrent = com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(viewGroup)) == null) {
                    return;
                }
                for (int i9 = 0; i9 < childCount; i9++) {
                    android.view.View childAt = viewGroup.getChildAt(i9);
                    if (!viewSkinCurrent.equals(com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(childAt))) {
                        com.up366.qmui.skin.QMUISkinManager.of(viewSkinCurrent.managerName, childAt.getContext()).dispatch(childAt, viewSkinCurrent.index);
                    }
                }
            }
        };
        mOnHierarchyChangeListener = new android.view.ViewGroup.OnHierarchyChangeListener() { // from class: com.up366.qmui.skin.QMUISkinManager.2
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(android.view.View view, android.view.View view2) {
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(android.view.View view, android.view.View view2) {
                com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(view);
                if (viewSkinCurrent == null || viewSkinCurrent.equals(com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(view2))) {
                    return;
                }
                com.up366.qmui.skin.QMUISkinManager.of(viewSkinCurrent.managerName, view2.getContext()).dispatch(view2, viewSkinCurrent.index);
            }
        };
    }

    public static com.up366.qmui.skin.QMUISkinManager defaultInstance(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        return of(DEFAULT_NAME, applicationContext.getResources(), applicationContext.getPackageName());
    }

    public static com.up366.qmui.skin.QMUISkinManager of(java.lang.String str, android.content.res.Resources resources, java.lang.String str2) {
        com.up366.qmui.skin.QMUISkinManager qMUISkinManager = sInstances.get(str);
        if (qMUISkinManager != null) {
            return qMUISkinManager;
        }
        com.up366.qmui.skin.QMUISkinManager qMUISkinManager2 = new com.up366.qmui.skin.QMUISkinManager(str, resources, str2);
        sInstances.put(str, qMUISkinManager2);
        return qMUISkinManager2;
    }

    public static com.up366.qmui.skin.QMUISkinManager of(java.lang.String str, android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        return of(str, applicationContext.getResources(), applicationContext.getPackageName());
    }

    public static void setRuleHandler(java.lang.String str, com.up366.qmui.skin.handler.IQMUISkinRuleHandler iQMUISkinRuleHandler) {
        sRuleHandlers.put(str, iQMUISkinRuleHandler);
    }

    public QMUISkinManager(java.lang.String str, android.content.res.Resources resources, java.lang.String str2) {
        this.mName = str;
        this.mResources = resources;
        this.mPackageName = str2;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public android.content.res.Resources.Theme getTheme(int i) {
        com.up366.qmui.skin.QMUISkinManager.SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            return skinItem.getTheme();
        }
        return null;
    }

    public android.content.res.Resources.Theme getCurrentTheme() {
        com.up366.qmui.skin.QMUISkinManager.SkinItem skinItem = this.mSkins.get(this.mCurrentSkin);
        if (skinItem != null) {
            return skinItem.getTheme();
        }
        return null;
    }

    public void addSkin(int i, int i2) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("index must greater than 0");
        }
        com.up366.qmui.skin.QMUISkinManager.SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            if (skinItem.getStyleRes() == i2) {
                return;
            }
            throw new java.lang.RuntimeException("already exist the theme item for " + i);
        }
        this.mSkins.append(i, new com.up366.qmui.skin.QMUISkinManager.SkinItem(i2));
    }

    static com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent getViewSkinCurrent(android.view.View view) {
        java.lang.Object tag = view.getTag(com.qmuiteam.qmui.R.id.qmui_skin_current);
        if (tag instanceof com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent) {
            return (com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent) tag;
        }
        return null;
    }

    public void dispatch(android.view.View view, int i) {
        android.content.res.Resources.Theme theme;
        if (view == null) {
            return;
        }
        com.up366.qmui.skin.QMUISkinManager.SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            theme = skinItem.getTheme();
        } else {
            if (i != -1) {
                throw new java.lang.IllegalArgumentException("The skin " + i + " does not exist");
            }
            theme = view.getContext().getTheme();
        }
        runDispatch(view, i, theme);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void runDispatch(android.view.View view, int i, android.content.res.Resources.Theme theme) {
        java.lang.CharSequence text;
        com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = getViewSkinCurrent(view);
        if (viewSkinCurrent != null && viewSkinCurrent.index == i && java.util.Objects.equals(viewSkinCurrent.managerName, this.mName)) {
            return;
        }
        view.setTag(com.qmuiteam.qmui.R.id.qmui_skin_current, new com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent(this.mName, i));
        if ((view instanceof com.up366.qmui.skin.IQMUISkinDispatchInterceptor) && ((com.up366.qmui.skin.IQMUISkinDispatchInterceptor) view).intercept(i, theme)) {
            return;
        }
        applyTheme(view, i, theme);
        int i2 = 0;
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (useHierarchyChangeListener(viewGroup)) {
                viewGroup.setOnHierarchyChangeListener(mOnHierarchyChangeListener);
            } else {
                viewGroup.addOnLayoutChangeListener(mOnLayoutChangeListener);
            }
            while (i2 < viewGroup.getChildCount()) {
                runDispatch(viewGroup.getChildAt(i2), i, theme);
                i2++;
            }
            return;
        }
        boolean z = view instanceof android.widget.TextView;
        if (z || (view instanceof com.up366.qmui.qqface.QMUIQQFaceView)) {
            if (z) {
                text = ((android.widget.TextView) view).getText();
            } else {
                text = ((com.up366.qmui.qqface.QMUIQQFaceView) view).getText();
            }
            if (text instanceof android.text.Spanned) {
                com.up366.qmui.skin.IQMUISkinHandlerSpan[] iQMUISkinHandlerSpanArr = (com.up366.qmui.skin.IQMUISkinHandlerSpan[]) ((android.text.Spanned) text).getSpans(0, text.length(), com.up366.qmui.skin.IQMUISkinHandlerSpan.class);
                if (iQMUISkinHandlerSpanArr != null) {
                    while (i2 < iQMUISkinHandlerSpanArr.length) {
                        iQMUISkinHandlerSpanArr[i2].handle(view, this, i, theme);
                        i2++;
                    }
                }
                view.invalidate();
            }
        }
    }

    private boolean useHierarchyChangeListener(android.view.ViewGroup viewGroup) {
        return (viewGroup instanceof androidx.recyclerview.widget.RecyclerView) || (viewGroup instanceof androidx.viewpager.widget.ViewPager) || (viewGroup instanceof android.widget.AdapterView) || viewGroup.getClass().isAnnotationPresent(com.up366.qmui.skin.annotation.QMUISkinListenWithHierarchyChange.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void applyTheme(android.view.View view, int i, android.content.res.Resources.Theme theme) {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> skinAttrs = getSkinAttrs(view);
        try {
            if (view instanceof com.up366.qmui.skin.IQMUISkinHandlerView) {
                ((com.up366.qmui.skin.IQMUISkinHandlerView) view).handle(this, i, theme, skinAttrs);
            } else {
                defaultHandleSkinAttrs(view, theme, skinAttrs);
            }
            if (view instanceof androidx.recyclerview.widget.RecyclerView) {
                androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view;
                int itemDecorationCount = recyclerView.getItemDecorationCount();
                for (int i2 = 0; i2 < itemDecorationCount; i2++) {
                    com.up366.qmui.skin.IQMUISkinHandlerDecoration itemDecorationAt = recyclerView.getItemDecorationAt(i2);
                    if (itemDecorationAt instanceof com.up366.qmui.skin.IQMUISkinHandlerDecoration) {
                        itemDecorationAt.handle(recyclerView, this, i, theme);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("catch error when apply theme: ");
            sb.append(view.getClass().getSimpleName());
            sb.append("; ");
            sb.append(i);
            sb.append("; attrs = ");
            sb.append(skinAttrs == null ? com.igexin.push.core.b.m : skinAttrs.toString());
            com.up366.qmui.QMUILog.printErrStackTrace(TAG, th, sb.toString(), new java.lang.Object[0]);
        }
    }

    void refreshRecyclerDecoration(androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.qmui.skin.IQMUISkinHandlerDecoration iQMUISkinHandlerDecoration, int i) {
        com.up366.qmui.skin.QMUISkinManager.SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            iQMUISkinHandlerDecoration.handle(recyclerView, this, i, skinItem.getTheme());
        }
    }

    void refreshTheme(android.view.View view, int i) {
        com.up366.qmui.skin.QMUISkinManager.SkinItem skinItem = this.mSkins.get(i);
        if (skinItem != null) {
            applyTheme(view, i, skinItem.getTheme());
        }
    }

    public void defaultHandleSkinAttrs(android.view.View view, android.content.res.Resources.Theme theme, androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap) {
        if (simpleArrayMap != null) {
            for (int i = 0; i < simpleArrayMap.size(); i++) {
                java.lang.String str = (java.lang.String) simpleArrayMap.keyAt(i);
                java.lang.Integer num = (java.lang.Integer) simpleArrayMap.valueAt(i);
                if (num != null) {
                    defaultHandleSkinAttr(view, theme, str, num.intValue());
                }
            }
        }
    }

    public void defaultHandleSkinAttr(android.view.View view, android.content.res.Resources.Theme theme, java.lang.String str, int i) {
        if (i == 0) {
            return;
        }
        com.up366.qmui.skin.handler.IQMUISkinRuleHandler iQMUISkinRuleHandler = sRuleHandlers.get(str);
        if (iQMUISkinRuleHandler == null) {
            com.up366.qmui.QMUILog.w(TAG, "Do not find handler for skin attr name: " + str, new java.lang.Object[0]);
            return;
        }
        iQMUISkinRuleHandler.handle(this, view, theme, str, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getSkinAttrs(android.view.View view) {
        java.lang.String[] strArrSplit;
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> defaultSkinAttrs;
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> defaultSkinAttrs2;
        java.lang.String str = (java.lang.String) view.getTag(com.qmuiteam.qmui.R.id.qmui_skin_value);
        if (str == null || str.isEmpty()) {
            strArrSplit = EMPTY_ITEMS;
        } else {
            strArrSplit = str.split("[|]");
        }
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = (!(view instanceof com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider) || (defaultSkinAttrs2 = ((com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider) view).getDefaultSkinAttrs()) == null || defaultSkinAttrs2.isEmpty()) ? null : new androidx.collection.SimpleArrayMap<>(defaultSkinAttrs2);
        com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider iQMUISkinDefaultAttrProvider = (com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider) view.getTag(com.qmuiteam.qmui.R.id.qmui_skin_default_attr_provider);
        if (iQMUISkinDefaultAttrProvider != null && (defaultSkinAttrs = iQMUISkinDefaultAttrProvider.getDefaultSkinAttrs()) != null && !defaultSkinAttrs.isEmpty()) {
            if (simpleArrayMap != null) {
                simpleArrayMap.putAll(defaultSkinAttrs);
            } else {
                simpleArrayMap = new androidx.collection.SimpleArrayMap<>(defaultSkinAttrs);
            }
        }
        if (simpleArrayMap == null) {
            if (strArrSplit.length <= 0) {
                return null;
            }
            simpleArrayMap = new androidx.collection.SimpleArrayMap<>(strArrSplit.length);
        }
        for (java.lang.String str2 : strArrSplit) {
            java.lang.String[] strArrSplit2 = str2.split(":");
            if (strArrSplit2.length == 2) {
                java.lang.String strTrim = strArrSplit2[0].trim();
                if (!com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(strTrim)) {
                    int attrFromName = getAttrFromName(strArrSplit2[1].trim());
                    if (attrFromName == 0) {
                        com.up366.qmui.QMUILog.w(TAG, "Failed to get attr id from name: " + strArrSplit2[1], new java.lang.Object[0]);
                    } else {
                        simpleArrayMap.put(strTrim, java.lang.Integer.valueOf(attrFromName));
                    }
                }
            }
        }
        return simpleArrayMap;
    }

    public int getAttrFromName(java.lang.String str) {
        return this.mResources.getIdentifier(str, "attr", this.mPackageName);
    }

    class SkinItem {
        private int styleRes;

        SkinItem(int i) {
            this.styleRes = i;
        }

        public int getStyleRes() {
            return this.styleRes;
        }

        android.content.res.Resources.Theme getTheme() {
            android.content.res.Resources.Theme theme = (android.content.res.Resources.Theme) com.up366.qmui.skin.QMUISkinManager.sStyleIdThemeMap.get(java.lang.Integer.valueOf(this.styleRes));
            if (theme != null) {
                return theme;
            }
            android.content.res.Resources.Theme themeNewTheme = com.up366.qmui.skin.QMUISkinManager.this.mResources.newTheme();
            themeNewTheme.applyStyle(this.styleRes, true);
            com.up366.qmui.skin.QMUISkinManager.sStyleIdThemeMap.put(java.lang.Integer.valueOf(this.styleRes), themeNewTheme);
            return themeNewTheme;
        }
    }

    public void register(android.app.Activity activity) {
        if (!containSkinObserver(activity)) {
            this.mSkinObserverList.add(new java.lang.ref.WeakReference<>(activity));
        }
        dispatch(activity.findViewById(android.R.id.content), this.mCurrentSkin);
    }

    public void unRegister(android.app.Activity activity) {
        removeSkinObserver(activity);
    }

    public void register(androidx.fragment.app.Fragment fragment) {
        if (!containSkinObserver(fragment)) {
            this.mSkinObserverList.add(new java.lang.ref.WeakReference<>(fragment));
        }
        dispatch(fragment.getView(), this.mCurrentSkin);
    }

    public void unRegister(androidx.fragment.app.Fragment fragment) {
        removeSkinObserver(fragment);
    }

    public void register(android.view.View view) {
        if (!containSkinObserver(view)) {
            this.mSkinObserverList.add(new java.lang.ref.WeakReference<>(view));
        }
        dispatch(view, this.mCurrentSkin);
    }

    public void unRegister(android.view.View view) {
        removeSkinObserver(view);
    }

    public void register(android.app.Dialog dialog) {
        if (!containSkinObserver(dialog)) {
            this.mSkinObserverList.add(new java.lang.ref.WeakReference<>(dialog));
        }
        android.view.Window window = dialog.getWindow();
        if (window != null) {
            dispatch(window.getDecorView(), this.mCurrentSkin);
        }
    }

    public void unRegister(android.app.Dialog dialog) {
        removeSkinObserver(dialog);
    }

    public void register(android.widget.PopupWindow popupWindow) {
        if (!containSkinObserver(popupWindow)) {
            this.mSkinObserverList.add(new java.lang.ref.WeakReference<>(popupWindow));
        }
        dispatch(popupWindow.getContentView(), this.mCurrentSkin);
    }

    public void unRegister(android.widget.PopupWindow popupWindow) {
        removeSkinObserver(popupWindow);
    }

    public void register(android.view.Window window) {
        if (!containSkinObserver(window)) {
            this.mSkinObserverList.add(new java.lang.ref.WeakReference<>(window));
        }
        dispatch(window.getDecorView(), this.mCurrentSkin);
    }

    public void unRegister(android.view.Window window) {
        removeSkinObserver(window);
    }

    private void removeSkinObserver(java.lang.Object obj) {
        for (int size = this.mSkinObserverList.size() - 1; size >= 0; size--) {
            java.lang.Object obj2 = this.mSkinObserverList.get(size).get();
            if (obj2 == obj) {
                this.mSkinObserverList.remove(size);
                return;
            } else {
                if (obj2 == null) {
                    this.mSkinObserverList.remove(size);
                }
            }
        }
    }

    private boolean containSkinObserver(java.lang.Object obj) {
        for (int size = this.mSkinObserverList.size() - 1; size >= 0; size--) {
            java.lang.Object obj2 = this.mSkinObserverList.get(size).get();
            if (obj2 == obj) {
                return true;
            }
            if (obj2 == null) {
                this.mSkinObserverList.remove(size);
            }
        }
        return false;
    }

    public void changeSkin(int i) {
        int i2 = this.mCurrentSkin;
        if (i2 == i) {
            return;
        }
        this.mCurrentSkin = i;
        for (int size = this.mSkinObserverList.size() - 1; size >= 0; size--) {
            java.lang.Object obj = this.mSkinObserverList.get(size).get();
            if (obj == null) {
                this.mSkinObserverList.remove(size);
            } else if (obj instanceof android.app.Activity) {
                android.app.Activity activity = (android.app.Activity) obj;
                activity.getWindow().setBackgroundDrawable(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(activity, this.mSkins.get(i).getTheme(), com.qmuiteam.qmui.R.attr.qmui_skin_support_activity_background));
                dispatch(activity.findViewById(android.R.id.content), i);
            } else if (obj instanceof androidx.fragment.app.Fragment) {
                dispatch(((androidx.fragment.app.Fragment) obj).getView(), i);
            } else if (obj instanceof android.app.Dialog) {
                android.view.Window window = ((android.app.Dialog) obj).getWindow();
                if (window != null) {
                    dispatch(window.getDecorView(), i);
                }
            } else if (obj instanceof android.widget.PopupWindow) {
                dispatch(((android.widget.PopupWindow) obj).getContentView(), i);
            } else if (obj instanceof android.view.Window) {
                dispatch(((android.view.Window) obj).getDecorView(), i);
            } else if (obj instanceof android.view.View) {
                dispatch((android.view.View) obj, i);
            }
        }
        for (int size2 = this.mSkinChangeListeners.size() - 1; size2 >= 0; size2--) {
            com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener onSkinChangeListener = this.mSkinChangeListeners.get(size2).get();
            if (onSkinChangeListener == null) {
                this.mSkinChangeListeners.remove(size2);
            } else {
                onSkinChangeListener.onSkinChange(this, i2, this.mCurrentSkin);
            }
        }
    }

    public void addSkinChangeListener(com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener onSkinChangeListener) {
        java.util.Iterator<java.lang.ref.WeakReference<com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener>> it = this.mSkinChangeListeners.iterator();
        while (it.hasNext()) {
            if (it.next().get() != null) {
                return;
            } else {
                it.remove();
            }
        }
        this.mSkinChangeListeners.add(new java.lang.ref.WeakReference<>(onSkinChangeListener));
    }

    public void removeSkinChangeListener(com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener onSkinChangeListener) {
        java.util.Iterator<java.lang.ref.WeakReference<com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener>> it = this.mSkinChangeListeners.iterator();
        while (it.hasNext()) {
            com.up366.qmui.skin.QMUISkinManager.OnSkinChangeListener onSkinChangeListener2 = it.next().get();
            if (onSkinChangeListener2 == null) {
                it.remove();
            } else if (onSkinChangeListener2 == onSkinChangeListener) {
                it.remove();
            }
        }
    }

    public int getCurrentSkin() {
        return this.mCurrentSkin;
    }

    class ViewSkinCurrent {
        int index;
        java.lang.String managerName;

        ViewSkinCurrent(java.lang.String str, int i) {
            this.managerName = str;
            this.index = i;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = (com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent) obj;
            return this.index == viewSkinCurrent.index && java.util.Objects.equals(this.managerName, viewSkinCurrent.managerName);
        }

        public int hashCode() {
            return java.util.Objects.hash(this.managerName, java.lang.Integer.valueOf(this.index));
        }
    }
}
