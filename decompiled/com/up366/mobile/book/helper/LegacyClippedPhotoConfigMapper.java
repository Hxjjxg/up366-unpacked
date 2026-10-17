package com.up366.mobile.book.helper;

/* JADX INFO: compiled from: PhotoPickerClippedPhotoV2Helper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u001a\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010&H\u0002J$\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010(H\u0002J$\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010+H\u0002J\u001c\u0010,\u001a\u00020+2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010+H\u0002J\u001c\u0010-\u001a\u00020(2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010(H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/up366/mobile/book/helper/LegacyClippedPhotoConfigMapper;", "", "<init>", "()V", "KEY_CAMERA_PAGE_SETTING", "", "KEY_CLIP_PAGE_SETTING", "KEY_RECT_SETTING", "KEY_GUIDE_SETTING", "KEY_TOP", "KEY_BOTTOM", "KEY_LEFT", "KEY_RIGHT", "KEY_URL", "KEY_IS_GUIDE_AUTO_SHOWN", "KEY_SHOWN_TYPE", "KEY_IS_GUIDE_BUTTON_HIDDEN", "KEY_DESCRIPTION", "KEY_INDEX_DESCRIPTION", "KEY_IS_MULTIPLY_AVAILABLE", "KEY_MAX_PAGE", "KEY_IS_RECT_HIDDEN", "KEY_IS_CLIP_GUIDE_BUTTON_HIDDEN", "KEY_CLIPPED_TITLE", "KEY_CLIPPED_DESC", "KEY_CLIP_GUIDE_URL", "KEY_CROP_RECT_INIT_WIDTH_RATIO", "KEY_CROP_RECT_INIT_HEIGHT_RATIO", "fromJson", "Lcom/up366/photopicker/config/PhotoPickerConfig;", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON, "fromJsonObject", "source", "Lcom/alibaba/fastjson/JSONObject;", "buildCameraPageSetting", "Lcom/up366/photopicker/config/CameraPageSetting;", "current", "buildClipPageSetting", "Lcom/up366/photopicker/config/ClipPageSetting;", "buildClipGuideSetting", "Lcom/up366/photopicker/config/GuideSetting;", "clipSource", "buildClipRectSetting", "Lcom/up366/photopicker/config/RectSetting;", "buildRectSetting", "buildGuideSetting", "defaultVisibleRatio", "", "startInset", "endInset", "MIN_RATIO", "MAX_RATIO", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LegacyClippedPhotoConfigMapper {
    public static final com.up366.mobile.book.helper.LegacyClippedPhotoConfigMapper INSTANCE = new com.up366.mobile.book.helper.LegacyClippedPhotoConfigMapper();
    private static final java.lang.String KEY_BOTTOM = "bottom";
    private static final java.lang.String KEY_CAMERA_PAGE_SETTING = "cameraPageSetting";
    private static final java.lang.String KEY_CLIPPED_DESC = "clippedDesc";
    private static final java.lang.String KEY_CLIPPED_TITLE = "clippedTitle";
    private static final java.lang.String KEY_CLIP_GUIDE_URL = "clipGuideUrl";
    private static final java.lang.String KEY_CLIP_PAGE_SETTING = "clipPageSetting";
    private static final java.lang.String KEY_CROP_RECT_INIT_HEIGHT_RATIO = "mCropRectInitHeightRatio";
    private static final java.lang.String KEY_CROP_RECT_INIT_WIDTH_RATIO = "mCropRectInitWidthRatio";
    private static final java.lang.String KEY_DESCRIPTION = "description";
    private static final java.lang.String KEY_GUIDE_SETTING = "guideSetting";
    private static final java.lang.String KEY_INDEX_DESCRIPTION = "indexDescription";
    private static final java.lang.String KEY_IS_CLIP_GUIDE_BUTTON_HIDDEN = "isClipGuideButtonHidden";
    private static final java.lang.String KEY_IS_GUIDE_AUTO_SHOWN = "isGuideAutoShown";
    private static final java.lang.String KEY_IS_GUIDE_BUTTON_HIDDEN = "isGuideButtonHidden";
    private static final java.lang.String KEY_IS_MULTIPLY_AVAILABLE = "isMultiplyAvailable";
    private static final java.lang.String KEY_IS_RECT_HIDDEN = "isRectHidden";
    private static final java.lang.String KEY_LEFT = "left";
    private static final java.lang.String KEY_MAX_PAGE = "maxPage";
    private static final java.lang.String KEY_RECT_SETTING = "rectSetting";
    private static final java.lang.String KEY_RIGHT = "right";
    private static final java.lang.String KEY_SHOWN_TYPE = "shownType";
    private static final java.lang.String KEY_TOP = "top";
    private static final java.lang.String KEY_URL = "url";
    private static final float MAX_RATIO = 1.0f;
    private static final float MIN_RATIO = 0.01f;

    private LegacyClippedPhotoConfigMapper() {
    }

    public final com.up366.photopicker.config.PhotoPickerConfig fromJson(java.lang.String json) {
        java.lang.Object obj;
        try {
            kotlin.Result.Companion companion = kotlin.Result.Companion;
            com.up366.mobile.book.helper.LegacyClippedPhotoConfigMapper legacyClippedPhotoConfigMapper = this;
            java.lang.String str = json;
            obj = kotlin.Result.constructor-impl((str == null || kotlin.text.StringsKt.isBlank(str)) ? new com.alibaba.fastjson.JSONObject() : com.alibaba.fastjson.JSON.parseObject(json));
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (kotlin.Result.isFailure-impl(obj)) {
            obj = jSONObject;
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) obj;
        kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject2);
        return fromJsonObject(jSONObject2);
    }

    private final com.up366.photopicker.config.PhotoPickerConfig fromJsonObject(com.alibaba.fastjson.JSONObject source) {
        com.up366.photopicker.config.PhotoPickerConfig photoPickerConfig = new com.up366.photopicker.config.PhotoPickerConfig();
        photoPickerConfig.setCameraPageSetting(buildCameraPageSetting(source, photoPickerConfig.getCameraPageSetting()));
        photoPickerConfig.setClipPageSetting(buildClipPageSetting(source, photoPickerConfig.getClipPageSetting()));
        if (source.containsKey("productType")) {
            photoPickerConfig.setProductType(source.getIntValue("productType"));
        }
        if (source.containsKey("isReshoot")) {
            photoPickerConfig.setIsReshoot(source.getBooleanValue("isReshoot"));
        }
        return photoPickerConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.up366.photopicker.config.CameraPageSetting buildCameraPageSetting(com.alibaba.fastjson.JSONObject r4, com.up366.photopicker.config.CameraPageSetting r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L7
            com.up366.photopicker.config.CameraPageSetting r5 = new com.up366.photopicker.config.CameraPageSetting
            r5.<init>()
        L7:
            java.lang.String r0 = "cameraPageSetting"
            com.alibaba.fastjson.JSONObject r4 = r4.getJSONObject(r0)
            if (r4 != 0) goto L14
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
            r4.<init>()
        L14:
            java.lang.String r0 = "description"
            java.lang.String r0 = r4.getString(r0)
            r1 = 0
            if (r0 == 0) goto L2c
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            r2 = r2 ^ 1
            if (r2 == 0) goto L29
            goto L2a
        L29:
            r0 = r1
        L2a:
            if (r0 != 0) goto L30
        L2c:
            java.lang.String r0 = r5.getDescription()
        L30:
            r5.setDescription(r0)
            java.lang.String r0 = "indexDescription"
            java.lang.String r0 = r4.getString(r0)
            if (r0 == 0) goto L49
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            r2 = r2 ^ 1
            if (r2 == 0) goto L47
            r1 = r0
        L47:
            if (r1 != 0) goto L4d
        L49:
            java.lang.String r1 = r5.getIndexDescription()
        L4d:
            r5.setIndexDescription(r1)
            java.lang.String r0 = "isMultiplyAvailable"
            boolean r1 = r4.containsKey(r0)
            if (r1 == 0) goto L5d
            boolean r0 = r4.getBooleanValue(r0)
            goto L5e
        L5d:
            r0 = 0
        L5e:
            r5.setMultiplyAvailable(r0)
            java.lang.String r0 = "maxPage"
            int r0 = r4.getIntValue(r0)
            if (r0 <= 0) goto L6c
            r5.setMaxPage(r0)
        L6c:
            java.lang.String r0 = "isRectHidden"
            boolean r1 = r4.containsKey(r0)
            if (r1 == 0) goto L7b
            boolean r0 = r4.getBooleanValue(r0)
            r5.setRectHidden(r0)
        L7b:
            java.lang.String r0 = "rectSetting"
            com.alibaba.fastjson.JSONObject r0 = r4.getJSONObject(r0)
            com.up366.photopicker.config.RectSetting r1 = r5.getRectSetting()
            com.up366.photopicker.config.RectSetting r0 = r3.buildRectSetting(r0, r1)
            r5.setRectSetting(r0)
            java.lang.String r0 = "guideSetting"
            com.alibaba.fastjson.JSONObject r4 = r4.getJSONObject(r0)
            com.up366.photopicker.config.GuideSetting r0 = r5.getGuideSetting()
            com.up366.photopicker.config.GuideSetting r4 = r3.buildGuideSetting(r4, r0)
            r5.setGuideSetting(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.LegacyClippedPhotoConfigMapper.buildCameraPageSetting(com.alibaba.fastjson.JSONObject, com.up366.photopicker.config.CameraPageSetting):com.up366.photopicker.config.CameraPageSetting");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.up366.photopicker.config.ClipPageSetting buildClipPageSetting(com.alibaba.fastjson.JSONObject r5, com.up366.photopicker.config.ClipPageSetting r6) {
        /*
            r4 = this;
            if (r6 != 0) goto L7
            com.up366.photopicker.config.ClipPageSetting r6 = new com.up366.photopicker.config.ClipPageSetting
            r6.<init>()
        L7:
            java.lang.String r0 = "clipPageSetting"
            com.alibaba.fastjson.JSONObject r0 = r5.getJSONObject(r0)
            java.lang.String r1 = "clippedDesc"
            java.lang.String r1 = r5.getString(r1)
            r2 = 0
            if (r1 == 0) goto L25
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ 1
            if (r3 == 0) goto L22
            goto L23
        L22:
            r1 = r2
        L23:
            if (r1 != 0) goto L5a
        L25:
            java.lang.String r1 = "clippedTitle"
            java.lang.String r1 = r5.getString(r1)
            if (r1 == 0) goto L39
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ 1
            if (r3 == 0) goto L39
            goto L3a
        L39:
            r1 = r2
        L3a:
            if (r1 != 0) goto L5a
            if (r0 == 0) goto L52
            java.lang.String r1 = "description"
            java.lang.String r1 = r0.getString(r1)
            if (r1 == 0) goto L52
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ 1
            if (r3 == 0) goto L52
            r2 = r1
        L52:
            if (r2 != 0) goto L59
            java.lang.String r1 = r6.getDescription()
            goto L5a
        L59:
            r1 = r2
        L5a:
            com.up366.photopicker.config.GuideSetting r2 = r6.getGuideSetting()
            com.up366.photopicker.config.GuideSetting r2 = r4.buildClipGuideSetting(r5, r0, r2)
            com.up366.photopicker.config.RectSetting r3 = r6.getRectSetting()
            com.up366.photopicker.config.RectSetting r5 = r4.buildClipRectSetting(r5, r0, r3)
            r6.setDescription(r1)
            r6.setGuideSetting(r2)
            r6.setRectSetting(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.LegacyClippedPhotoConfigMapper.buildClipPageSetting(com.alibaba.fastjson.JSONObject, com.up366.photopicker.config.ClipPageSetting):com.up366.photopicker.config.ClipPageSetting");
    }

    private final com.up366.photopicker.config.GuideSetting buildClipGuideSetting(com.alibaba.fastjson.JSONObject source, com.alibaba.fastjson.JSONObject clipSource, com.up366.photopicker.config.GuideSetting current) {
        java.lang.String string = source.getString(KEY_CLIP_GUIDE_URL);
        if (string == null) {
            string = "";
        }
        boolean booleanValue = source.getBooleanValue(KEY_IS_CLIP_GUIDE_BUTTON_HIDDEN);
        com.up366.photopicker.config.GuideSetting guideSettingBuildGuideSetting = buildGuideSetting(clipSource != null ? clipSource.getJSONObject(KEY_GUIDE_SETTING) : null, current);
        if (source.containsKey(KEY_IS_CLIP_GUIDE_BUTTON_HIDDEN)) {
            guideSettingBuildGuideSetting.setGuideButtonHidden(booleanValue);
        }
        if (!kotlin.text.StringsKt.isBlank(string)) {
            guideSettingBuildGuideSetting.setUrl(string);
            guideSettingBuildGuideSetting.setShownType(2);
        }
        return guideSettingBuildGuideSetting;
    }

    private final com.up366.photopicker.config.RectSetting buildClipRectSetting(com.alibaba.fastjson.JSONObject source, com.alibaba.fastjson.JSONObject clipSource, com.up366.photopicker.config.RectSetting current) {
        java.lang.Float f = null;
        com.up366.photopicker.config.RectSetting rectSettingBuildRectSetting = buildRectSetting(clipSource != null ? clipSource.getJSONObject(KEY_RECT_SETTING) : null, current);
        java.lang.Float fValueOf = java.lang.Float.valueOf(source.getFloatValue(KEY_CROP_RECT_INIT_WIDTH_RATIO));
        float fFloatValue = fValueOf.floatValue();
        if (MIN_RATIO > fFloatValue || fFloatValue > MAX_RATIO) {
            fValueOf = null;
        }
        java.lang.Float fValueOf2 = java.lang.Float.valueOf(source.getFloatValue(KEY_CROP_RECT_INIT_HEIGHT_RATIO));
        float fFloatValue2 = fValueOf2.floatValue();
        if (MIN_RATIO <= fFloatValue2 && fFloatValue2 <= MAX_RATIO) {
            f = fValueOf2;
        }
        if (fValueOf == null && f == null) {
            return rectSettingBuildRectSetting;
        }
        float fFloatValue3 = fValueOf != null ? fValueOf.floatValue() : defaultVisibleRatio(rectSettingBuildRectSetting.getLeft(), rectSettingBuildRectSetting.getRight());
        float fFloatValue4 = f != null ? f.floatValue() : defaultVisibleRatio(rectSettingBuildRectSetting.getTop(), rectSettingBuildRectSetting.getBottom());
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn((MAX_RATIO - fFloatValue3) / 2.0f, 0.0f, 0.5f);
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn((MAX_RATIO - fFloatValue4) / 2.0f, 0.0f, 0.5f);
        rectSettingBuildRectSetting.setLeft(fCoerceIn);
        rectSettingBuildRectSetting.setRight(fCoerceIn);
        rectSettingBuildRectSetting.setTop(fCoerceIn2);
        rectSettingBuildRectSetting.setBottom(fCoerceIn2);
        rectSettingBuildRectSetting.setExplicit(true);
        return rectSettingBuildRectSetting;
    }

    private final com.up366.photopicker.config.RectSetting buildRectSetting(com.alibaba.fastjson.JSONObject source, com.up366.photopicker.config.RectSetting current) {
        boolean z;
        if (current == null) {
            current = new com.up366.photopicker.config.RectSetting();
        }
        if (source == null) {
            return current;
        }
        if (source.containsKey("top")) {
            current.setTop(kotlin.ranges.RangesKt.coerceIn(source.getFloatValue("top"), 0.0f, 0.95f));
            z = true;
        } else {
            z = false;
        }
        if (source.containsKey("bottom")) {
            current.setBottom(kotlin.ranges.RangesKt.coerceIn(source.getFloatValue("bottom"), 0.0f, 0.95f));
            z = true;
        }
        if (source.containsKey("left")) {
            current.setLeft(kotlin.ranges.RangesKt.coerceIn(source.getFloatValue("left"), 0.0f, 0.95f));
            z = true;
        }
        if (source.containsKey("right")) {
            current.setRight(kotlin.ranges.RangesKt.coerceIn(source.getFloatValue("right"), 0.0f, 0.95f));
            z = true;
        }
        if (z) {
            current.setExplicit(true);
        }
        return current;
    }

    private final com.up366.photopicker.config.GuideSetting buildGuideSetting(com.alibaba.fastjson.JSONObject source, com.up366.photopicker.config.GuideSetting current) {
        if (current == null) {
            current = new com.up366.photopicker.config.GuideSetting();
        }
        if (source == null) {
            return current;
        }
        if (source.containsKey("url")) {
            java.lang.String string = source.getString("url");
            if (string == null) {
                string = "";
            }
            current.setUrl(string);
        }
        if (source.containsKey(KEY_IS_GUIDE_AUTO_SHOWN)) {
            current.setGuideAutoShown(source.getBooleanValue(KEY_IS_GUIDE_AUTO_SHOWN));
        }
        if (source.containsKey(KEY_SHOWN_TYPE)) {
            current.setShownType(source.getIntValue(KEY_SHOWN_TYPE));
        }
        if (source.containsKey(KEY_IS_GUIDE_BUTTON_HIDDEN)) {
            current.setGuideButtonHidden(source.getBooleanValue(KEY_IS_GUIDE_BUTTON_HIDDEN));
        }
        return current;
    }

    private final float defaultVisibleRatio(float startInset, float endInset) {
        return kotlin.ranges.RangesKt.coerceIn((MAX_RATIO - startInset) - endInset, MIN_RATIO, MAX_RATIO);
    }
}
