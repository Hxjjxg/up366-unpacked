package com.up366.mobile.common.onlinelog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ActionLogRecord {
    private static final com.up366.mobile.common.onlinelog.ActionLogRecord instance = new com.up366.mobile.common.onlinelog.ActionLogRecord();
    private static final java.util.Map<java.lang.Integer, java.lang.String> hashMap = new java.util.HashMap();
    private static float downPosX = 0.0f;
    private static float downPosY = 0.0f;
    private static float touchSlop = 0.0f;

    private java.lang.String getViewPositionInfo(android.view.View view) {
        return null;
    }

    public static void addModelPath(android.view.View view, java.lang.String str) {
        if (view != null) {
            hashMap.put(java.lang.Integer.valueOf(view.hashCode()), str);
        }
    }

    public static void removeModelPath(java.lang.Object obj) {
        if (obj != null) {
            hashMap.remove(java.lang.Integer.valueOf(obj.hashCode()));
        }
    }

    public static void record(android.app.Activity activity, java.lang.String str) {
        com.up366.mobile.common.onlinelog.ActionLogTool.append(instance.buildLogString("NATIVE", str, null, com.up366.mobile.AppStateMonitor.INSTANCE.getPageName(activity), null));
    }

    public static void record(java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject) {
        com.up366.mobile.common.onlinelog.ActionLogTool.append(instance.buildLogString("NATIVE", str, null, str2, jSONObject));
    }

    public static void record(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alibaba.fastjson.JSONObject jSONObject) {
        com.up366.mobile.common.onlinelog.ActionLogTool.append(instance.buildLogString("NATIVE", str, str3, str2, jSONObject, new com.alibaba.fastjson.JSONObject()));
    }

    public static void recordActionDown(android.view.MotionEvent motionEvent) {
        if (touchSlop == 0.0f) {
            touchSlop = android.view.ViewConfiguration.get(com.up366.common.global.GB.get().getApplicationContext()).getScaledTouchSlop();
        }
        downPosX = motionEvent.getRawX();
        downPosY = motionEvent.getRawY();
    }

    public static void record(android.view.Window window, android.view.MotionEvent motionEvent) {
        android.view.View view;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = downPosX;
        float f2 = (rawX - f) * (rawX - f);
        float f3 = downPosY;
        float f4 = f2 + ((rawY - f3) * (rawY - f3));
        float f5 = touchSlop;
        if (f4 > f5 * f5) {
            return;
        }
        android.view.View decorView = window.getDecorView();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        instance.findClickView(decorView, motionEvent.getRawX(), motionEvent.getRawY(), arrayList);
        if (arrayList.size() == 0 || (view = (android.view.View) arrayList.get(arrayList.size() - 1)) == null) {
            return;
        }
        if (motionEvent.getEventTime() - motionEvent.getDownTime() > 300) {
            record(view, "CLICK_UP");
        } else {
            record(view, com.up366.mobile.common.onlinelog.OpLogData.Event.CLICK);
        }
    }

    public static void record(android.view.View view, java.lang.String str) {
        com.up366.mobile.common.onlinelog.ActionLogRecord actionLogRecord = instance;
        com.up366.mobile.common.onlinelog.ActionLogTool.append(actionLogRecord.buildLogString("NATIVE", str, view, actionLogRecord.findModelPathByView(view), null));
    }

    public static void recordJS(android.view.View view, com.alibaba.fastjson.JSONObject jSONObject) {
        com.up366.mobile.common.onlinelog.ActionLogRecord actionLogRecord = instance;
        com.up366.mobile.common.onlinelog.ActionLogTool.append(actionLogRecord.buildLogString("H5", "js-event", view, actionLogRecord.findModelPathByView(view), jSONObject));
    }

    private java.lang.String findModelPathByView(android.view.View view) {
        if (view == null) {
            return "";
        }
        android.view.View view2 = view;
        while (view2 != null) {
            java.lang.String str = hashMap.get(java.lang.Integer.valueOf(view2.hashCode()));
            if (str != null) {
                return str;
            }
            java.lang.Object parent = view2.getParent();
            view2 = parent instanceof android.view.View ? (android.view.View) parent : null;
        }
        return view.getContext().getClass().getName();
    }

    private java.lang.String buildLogString(java.lang.String str, java.lang.String str2, android.view.View view, java.lang.String str3, com.alibaba.fastjson.JSONObject jSONObject) {
        java.lang.String strReplace = str3.replace(com.up366.mobile.BuildConfig.APPLICATION_ID, "");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        java.lang.String viewText = getViewText(view);
        java.lang.String viewControlInfo = getViewControlInfo(view);
        java.lang.String viewPositionInfo = getViewPositionInfo(view);
        jSONObject2.put("text", viewText);
        jSONObject2.put("pos", viewPositionInfo);
        return buildLogString(str, str2, viewControlInfo, strReplace, jSONObject, jSONObject2);
    }

    private java.lang.String buildLogString(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.alibaba.fastjson.JSONObject jSONObject, com.alibaba.fastjson.JSONObject jSONObject2) {
        java.lang.String strReplace = str4.replace(com.up366.mobile.BuildConfig.APPLICATION_ID, "");
        int iUID = com.up366.mobile.common.logic.Auth.UID();
        java.lang.String username = com.up366.mobile.common.logic.Auth.getUserInfo().getUsername();
        int organId = com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId();
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        java.lang.String appType = com.up366.mobile.common.utils.PlatformUtils.getAppType();
        com.alibaba.fastjson.JSONObject jSONObject3 = new com.alibaba.fastjson.JSONObject();
        jSONObject3.put("uid", java.lang.Integer.valueOf(iUID));
        jSONObject3.put("username", username);
        jSONObject3.put("organId", java.lang.Integer.valueOf(organId));
        jSONObject3.put("appType", appType);
        jSONObject3.put("appVersion", "6.0.1.8b928e8");
        jSONObject3.put("clientId", com.up366.common.global.GB.get().getUniqueDeviceId());
        jSONObject3.put("device", com.up366.mobile.common.utils.DeviceNameUtils.INSTANCE.getFullDeviceName());
        jSONObject3.put("evTime", com.up366.common.TimeUtils.formatTime(currentNtpTimeInMillisecond, "yyyy-MM-dd HH:mm:ss.SSS"));
        jSONObject3.put("source", str);
        jSONObject3.put(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, strReplace);
        jSONObject3.put("event", str2);
        jSONObject3.put("control", str3);
        jSONObject3.put("extData", jSONObject2);
        jSONObject3.put("os", android.os.Build.VERSION.RELEASE);
        jSONObject3.put("batchId", java.lang.Long.valueOf(com.up366.mobile.AppStateMonitor.INSTANCE.getBatchId()));
        if (jSONObject != null) {
            jSONObject3.putAll(jSONObject);
            if (!"NATIVE".equals(str)) {
                jSONObject3.put("evTime", com.up366.common.TimeUtils.formatTime(currentNtpTimeInMillisecond, "yyyy-MM-dd HH:mm:ss.SSS"));
            }
        }
        return jSONObject3.toJSONString();
    }

    private java.lang.String getViewText(android.view.View view) {
        if (view == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        findAllViews(view, arrayList);
        for (android.view.View view2 : arrayList) {
            if (view2 instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) view2;
                if (textView.getText().toString().length() > 0) {
                    sb.append(textView.getText());
                    sb.append("\n");
                }
            } else if (getViewIdName(view2) != null) {
                sb.append(getViewIdName(view2));
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }

    private java.lang.String getViewControlInfo(android.view.View view) {
        if (view == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        findChildViews(view, arrayList);
        for (android.view.View view2 : arrayList) {
            if (view2 instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) view2;
                if (textView.getText().toString().length() > 0) {
                    sb.append(textView.getText());
                    sb.append("\n");
                }
            } else if (getViewIdName(view2) != null) {
                sb.append(getViewIdName(view2));
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }

    private java.lang.String getViewIdName(android.view.View view) {
        java.lang.String resourcePackageName;
        int id = view.getId();
        if (id == -1) {
            return null;
        }
        try {
            android.content.res.Resources resources = view.getResources();
            if (id <= 0 || resources == null) {
                return null;
            }
            int i = (-16777216) & id;
            if (i == 16777216) {
                resourcePackageName = "android";
            } else if (i == 2130706432) {
                resourcePackageName = "app";
            } else {
                resourcePackageName = resources.getResourcePackageName(id);
            }
            return resourcePackageName + ":" + resources.getResourceTypeName(id) + "/" + resources.getResourceEntryName(id);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private void findChildViews(android.view.View view, java.util.List<android.view.View> list) {
        if (view.getVisibility() != 0) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        if (view instanceof android.view.ViewGroup) {
            list.add(view);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                findChildViews(viewGroup.getChildAt(i), list);
            }
            return;
        }
        list.add(view);
    }

    private void findAllViews(android.view.View view, java.util.List<android.view.View> list) {
        if (view.getVisibility() != 0) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            java.lang.Object parent = view.getParent();
            if (parent == null) {
                findChildViews(view, list);
                return;
            } else {
                findChildViews((android.view.View) parent, list);
                list.add(view);
                return;
            }
        }
        findChildViews(view, list);
    }

    private android.view.View findClickView(android.view.View view, float f, float f2, java.util.List<android.view.View> list) {
        if (view != null && view.getVisibility() == 0) {
            view.getLocationInWindow(new int[2]);
            int width = view.getWidth();
            int height = view.getHeight();
            float f3 = f - r1[0];
            float f4 = f2 - r1[1];
            if (f3 > 0.0f && f3 < width && f4 > 0.0f && f4 < height) {
                if (view instanceof android.view.ViewGroup) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    boolean z = false;
                    for (int i = 0; i < childCount; i++) {
                        android.view.View viewFindClickView = findClickView(viewGroup.getChildAt(i), f, f2, list);
                        if (viewFindClickView != null) {
                            list.add(viewFindClickView);
                        } else if (viewGroup.isClickable()) {
                            z = true;
                        }
                    }
                    if (list.size() == 0 ? z : false) {
                        list.add(viewGroup);
                    }
                } else if (view.isClickable()) {
                    list.add(view);
                }
            }
        }
        return null;
    }

    public static java.lang.String getUri(android.app.Activity activity) {
        java.lang.String uri = activity.getIntent().toUri(1);
        android.os.Bundle extras = activity.getIntent().getExtras();
        return extras != null ? extras.toString() : uri;
    }
}
