package com.up366.qmui.skin;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinHelper {
    public static com.up366.qmui.skin.QMUISkinValueBuilder sSkinValueBuilder = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();

    public static android.content.res.Resources.Theme getSkinTheme(android.view.View view) {
        com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(view);
        if (viewSkinCurrent == null || viewSkinCurrent.index < 0) {
            return view.getContext().getTheme();
        }
        return com.up366.qmui.skin.QMUISkinManager.of(viewSkinCurrent.managerName, view.getContext()).getTheme(viewSkinCurrent.index);
    }

    public static int getSkinColor(android.view.View view, int i) {
        return com.up366.qmui.util.QMUIResHelper.getAttrColor(getSkinTheme(view), i);
    }

    public static android.content.res.ColorStateList getSkinColorStateList(android.view.View view, int i) {
        return com.up366.qmui.util.QMUIResHelper.getAttrColorStateList(view.getContext(), getSkinTheme(view), i);
    }

    public static android.graphics.drawable.Drawable getSkinDrawable(android.view.View view, int i) {
        return com.up366.qmui.util.QMUIResHelper.getAttrDrawable(view.getContext(), getSkinTheme(view), i);
    }

    public static void setSkinValue(android.view.View view, com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        setSkinValue(view, qMUISkinValueBuilder.build());
    }

    public static void setSkinValue(android.view.View view, java.lang.String str) {
        view.setTag(com.qmuiteam.qmui.R.id.qmui_skin_value, str);
        refreshViewSkin(view);
    }

    public static void setSkinValue(android.view.View view, com.up366.qmui.skin.SkinWriter skinWriter) {
        skinWriter.write(sSkinValueBuilder);
        setSkinValue(view, sSkinValueBuilder.build());
        sSkinValueBuilder.clear();
    }

    public static void refreshRVItemDecoration(androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.qmui.skin.IQMUISkinHandlerDecoration iQMUISkinHandlerDecoration) {
        com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(recyclerView);
        if (viewSkinCurrent != null) {
            com.up366.qmui.skin.QMUISkinManager.of(viewSkinCurrent.managerName, recyclerView.getContext()).refreshRecyclerDecoration(recyclerView, iQMUISkinHandlerDecoration, viewSkinCurrent.index);
        }
    }

    public static int getCurrentSkinIndex(android.view.View view) {
        com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(view);
        if (viewSkinCurrent != null) {
            return viewSkinCurrent.index;
        }
        return -1;
    }

    public static void refreshViewSkin(android.view.View view) {
        com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(view);
        if (viewSkinCurrent != null) {
            com.up366.qmui.skin.QMUISkinManager.of(viewSkinCurrent.managerName, view.getContext()).refreshTheme(view, viewSkinCurrent.index);
        }
    }

    public static void syncViewSkin(android.view.View view, android.view.View view2) {
        com.up366.qmui.skin.QMUISkinManager.ViewSkinCurrent viewSkinCurrent = com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(view2);
        if (viewSkinCurrent == null || viewSkinCurrent.equals(com.up366.qmui.skin.QMUISkinManager.getViewSkinCurrent(view))) {
            return;
        }
        com.up366.qmui.skin.QMUISkinManager.of(viewSkinCurrent.managerName, view.getContext()).dispatch(view, viewSkinCurrent.index);
    }

    public static void setSkinDefaultProvider(android.view.View view, com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider iQMUISkinDefaultAttrProvider) {
        view.setTag(com.qmuiteam.qmui.R.id.qmui_skin_default_attr_provider, iQMUISkinDefaultAttrProvider);
    }

    public static void warnRuleNotSupport(android.view.View view, java.lang.String str) {
        com.up366.qmui.QMUILog.w("QMUISkinManager", view.getClass().getSimpleName() + " does't support " + str, new java.lang.Object[0]);
    }
}
