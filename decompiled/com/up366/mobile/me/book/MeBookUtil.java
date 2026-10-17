package com.up366.mobile.me.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeBookUtil {
    public static void skip(android.view.View view, com.up366.mobile.common.logic.model.MyBook myBook) {
        int curCourseId = myBook.getCurCourseId();
        com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo = myBook.getBookInfoMap().get(java.lang.Integer.valueOf(curCourseId));
        if (courseBookInfo == null) {
            com.up366.common.log.Logger.error("skip error bookInfo is null : " + curCourseId + " " + myBook);
            return;
        }
        android.content.Context context = view.getContext();
        if (myBook.getToMobile() != 1) {
            com.up366.mobile.common.dialog.DialogOkCancleV2.create(context).setCancelable(false).hideCancel().title("提示").message(context.getResources().getString(com.up366.mobile.R.string.go_to_pc_client_study)).ok("确定", null).show();
            return;
        }
        if (myBook.getIsShelf() != 1 && !myBook.isHasBuy()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(view, context.getString(com.up366.mobile.R.string.go_to_no_shelf_client_study));
            return;
        }
        if (!myBook.isHasBuy()) {
            if (com.up366.mobile.common.logic.Auth.cur().info().isInStudyCard(courseBookInfo.getBookId())) {
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.open(context, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.STUDY_CARD_URL) + "?userId=" + com.up366.mobile.common.logic.Auth.UID());
                return;
            }
            java.lang.String str = "您《" + myBook.getBookName() + "》的权益已经过期，请联系教学顾问。";
            if (myBook.getEndDate() == 0) {
                str = "您没有权限使用《" + myBook.getBookName() + "》，请联系教学顾问。";
            }
            com.up366.mobile.common.dialog.DialogOkCancleV2.create(context).setCancelable(false).hideCancel().title("温馨提示").message(str).ok("我知道了", null).show();
            return;
        }
        openStudyPage(context, new com.up366.mobile.book.model.BookInfoStudy(courseBookInfo), myBook);
    }

    public static void skip(android.view.View view, com.up366.mobile.common.logic.model.MyBook myBook, java.util.List<com.up366.mobile.course.mgr.CourseInfo> list) {
        android.content.Context context = view.getContext();
        if (myBook.getToMobile() != 1) {
            com.up366.mobile.common.dialog.DialogOkCancleV2.create(context).setCancelable(false).hideCancel().title("提示").message(context.getResources().getString(com.up366.mobile.R.string.go_to_pc_client_study)).ok("确定", null).show();
            return;
        }
        if (!myBook.isHasBuy()) {
            if (com.up366.mobile.common.logic.Auth.cur().info().isInStudyCard(myBook.getBookId())) {
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.open(context, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.STUDY_CARD_URL) + "?userId=" + com.up366.mobile.common.logic.Auth.UID());
                return;
            }
            java.lang.String str = "您《" + myBook.getBookName() + "》的权益已经过期，请联系教学顾问。";
            if (myBook.getEndDate() == 0) {
                str = "您没有权限使用《" + myBook.getBookName() + "》，请联系教学顾问。";
            }
            com.up366.mobile.common.dialog.DialogOkCancleV2.create(context).setCancelable(false).hideCancel().title("温馨提示").message(str).ok("我知道了", null).show();
            return;
        }
        if (myBook.getIsShelf() != 1 && !myBook.isHasBuy()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(view, context.getString(com.up366.mobile.R.string.go_to_no_shelf_client_study));
        } else if (checkCourseBookLoadStatus(context, myBook, list)) {
            openPage(context, myBook, list);
        }
    }

    private static void openPage(final android.content.Context context, final com.up366.mobile.common.logic.model.MyBook myBook, java.util.List<com.up366.mobile.course.mgr.CourseInfo> list) {
        java.util.List<java.lang.String> withInCourseBooks = com.up366.mobile.common.logic.Auth.cur().config().getWithInCourseBooks();
        if (withInCourseBooks != null && withInCourseBooks.contains(myBook.getBookId())) {
            openStudyPage(context, new com.up366.mobile.book.model.BookInfoStudy(myBook), myBook);
            return;
        }
        int size = myBook.getBookInfoMap().size();
        if (size == 0) {
            openStudyPage(context, new com.up366.mobile.book.model.BookInfoStudy(myBook), myBook);
            return;
        }
        if (size == 1) {
            com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo = new com.up366.mobile.course.mgr.CourseBookInfo();
            java.util.Iterator<com.up366.mobile.course.mgr.CourseBookInfo> it = myBook.getBookInfoMap().values().iterator();
            if (it.hasNext()) {
                courseBookInfo = it.next();
            }
            openStudyPage(context, new com.up366.mobile.book.model.BookInfoStudy(courseBookInfo), myBook);
            return;
        }
        if (list == null || list.size() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("未获取到课程信息，请下拉刷新后再操作");
        } else {
            showBottomSheetDialog(context, myBook, list, new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda5
                @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
                public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
                    com.up366.mobile.common.logic.model.MyBook myBook2 = myBook;
                    com.up366.mobile.me.book.MeBookUtil.openStudyPage(context, new com.up366.mobile.book.model.BookInfoStudy((com.up366.mobile.course.mgr.CourseBookInfo) java.util.Objects.requireNonNull(myBook2.getBookInfoMap().get(java.lang.Integer.valueOf(((com.up366.mobile.course.mgr.CourseInfo) bottomSheetModel.getData()).getCourseId())))), myBook2);
                }
            });
        }
    }

    private static boolean checkCourseBookLoadStatus(final android.content.Context context, final com.up366.mobile.common.logic.model.MyBook myBook, final java.util.List<com.up366.mobile.course.mgr.CourseInfo> list) {
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> listLoadCourseBookInfoS = com.up366.mobile.common.logic.Auth.cur().course().loadCourseBookInfoS();
        if ((listLoadCourseBookInfoS != null && listLoadCourseBookInfoS.size() > 0) || !com.up366.common.NetworkUtilsUp.isConnected()) {
            return true;
        }
        com.up366.mobile.common.logic.Auth.cur().course().fetchCourseList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.me.book.MeBookUtil.lambda$checkCourseBookLoadStatus$1(myBook, context, list, response, (java.util.List) obj);
            }
        });
        return false;
    }

    static /* synthetic */ void lambda$checkCourseBookLoadStatus$1(com.up366.mobile.common.logic.model.MyBook myBook, android.content.Context context, java.util.List list, com.up366.common.http.Response response, java.util.List list2) {
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> listLoadCourseBookInfoSByBookId = com.up366.mobile.common.logic.Auth.cur().course().loadCourseBookInfoSByBookId(myBook.getBookId());
        if (listLoadCourseBookInfoSByBookId != null && listLoadCourseBookInfoSByBookId.size() > 0) {
            java.util.Iterator<com.up366.mobile.course.mgr.CourseBookInfo> it = listLoadCourseBookInfoSByBookId.iterator();
            while (it.hasNext()) {
                myBook.addCourseBookInfo(it.next());
            }
        }
        openPage(context, myBook, list);
    }

    private static void showBottomSheetDialog(android.content.Context context, com.up366.mobile.common.logic.model.MyBook myBook, java.util.List<com.up366.mobile.course.mgr.CourseInfo> list, com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener<com.up366.mobile.course.mgr.CourseInfo> onClickListener) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.course.mgr.CourseInfo courseInfo : list) {
            if (myBook.containsCourseId(courseInfo.getCourseId())) {
                com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
                bottomSheetModel.setContent(courseInfo.getCourseName());
                bottomSheetModel.setData(courseInfo);
                bottomSheetModel.setSelected(false);
                arrayList.add(bottomSheetModel);
            }
        }
        new com.up366.mobile.common.helper.BottomSheetHelper(context).setTitle("选择班级").setContents(arrayList).setItemClickListener(onClickListener).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void openStudyPage(android.content.Context context, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.common.logic.model.MyBook myBook) {
        myBook.setNew(false);
        com.up366.mobile.common.logic.Auth.cur().cache().put("book-cached-version-" + bookInfoStudy.getBookId(), myBook.getMobileVersion(), com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("scenario", "_STANDARD_BOOK_");
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(bookInfoStudy.getCourseId()));
        jSONObject.put("bookType", java.lang.Integer.valueOf(bookInfoStudy.getBookType()));
        bookInfoStudy.setJumpCommonParams(jSONObject.toJSONString());
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("book", bookInfoStudy);
        context.startActivity(intent);
    }

    public static void showCourseCheckSheet(android.content.Context context, java.util.List<com.up366.mobile.course.mgr.CourseInfo> list, com.up366.mobile.course.mgr.CourseInfo courseInfo, com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener<com.up366.mobile.course.mgr.CourseInfo> onClickListener) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.course.mgr.CourseInfo courseInfo2 : list) {
            com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
            bottomSheetModel.setContent(courseInfo2.getCourseName());
            bottomSheetModel.setData(courseInfo2);
            bottomSheetModel.setSelected(courseInfo.getCourseId() == courseInfo2.getCourseId());
            arrayList.add(bottomSheetModel);
        }
        new com.up366.mobile.common.helper.BottomSheetHelper(context).setTitle("选择班级").setContents(arrayList).setItemClickListener(onClickListener).show();
    }

    public static void filterData(final int i, java.util.List<com.up366.mobile.common.logic.model.MyBook> list, com.up366.common.callback.ICallbackCodeInfoObj<java.util.List<com.up366.mobile.common.logic.model.MyBook>> iCallbackCodeInfoObj) {
        if (i == 0) {
            iCallbackCodeInfoObj.onResult(0, "", new java.util.ArrayList(list));
            return;
        }
        java.util.List<com.up366.mobile.common.logic.model.MyBook> list2 = (java.util.List) java8.util.stream.StreamSupport.stream(list).filter(new java8.util.function.Predicate() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda6
            @Override // java8.util.function.Predicate
            public final boolean test(java.lang.Object obj) {
                return com.up366.mobile.me.book.MeBookUtil.lambda$filterData$2(i, (com.up366.mobile.common.logic.model.MyBook) obj);
            }
        }).collect(java8.util.stream.Collectors.toList());
        java.util.Collections.sort(list2, new java.util.Comparator() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda7
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.me.book.MeBookUtil.lambda$filterData$3((com.up366.mobile.common.logic.model.MyBook) obj, (com.up366.mobile.common.logic.model.MyBook) obj2);
            }
        });
        iCallbackCodeInfoObj.onResult(0, "", list2);
    }

    static /* synthetic */ boolean lambda$filterData$2(int i, com.up366.mobile.common.logic.model.MyBook myBook) {
        boolean zContainsCourseId = myBook.containsCourseId(i);
        if (!zContainsCourseId) {
            i = 0;
        }
        myBook.setCurCourseId(i);
        return zContainsCourseId;
    }

    static /* synthetic */ int lambda$filterData$3(com.up366.mobile.common.logic.model.MyBook myBook, com.up366.mobile.common.logic.model.MyBook myBook2) {
        return (int) (myBook.getLastStudyTime() - myBook2.getLastStudyTime());
    }

    public static java.util.List<com.up366.mobile.common.logic.model.MyBook> filterPadData(java.util.List<com.up366.mobile.common.logic.model.MyBook> list) {
        return !com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? list : (java.util.List) java8.util.stream.StreamSupport.stream(list).filter(new java8.util.function.Predicate() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda1
            @Override // java8.util.function.Predicate
            public final boolean test(java.lang.Object obj) {
                return com.up366.mobile.me.book.MeBookUtil.lambda$filterPadData$4((com.up366.mobile.common.logic.model.MyBook) obj);
            }
        }).filter(new java8.util.function.Predicate() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda2
            @Override // java8.util.function.Predicate
            public final boolean test(java.lang.Object obj) {
                return com.up366.mobile.me.book.MeBookUtil.lambda$filterPadData$5((com.up366.mobile.common.logic.model.MyBook) obj);
            }
        }).filter(new java8.util.function.Predicate() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda3
            @Override // java8.util.function.Predicate
            public final boolean test(java.lang.Object obj) {
                return com.up366.mobile.me.book.MeBookUtil.lambda$filterPadData$6((com.up366.mobile.common.logic.model.MyBook) obj);
            }
        }).filter(new java8.util.function.Predicate() { // from class: com.up366.mobile.me.book.MeBookUtil$$ExternalSyntheticLambda4
            @Override // java8.util.function.Predicate
            public final boolean test(java.lang.Object obj) {
                return com.up366.mobile.me.book.MeBookUtil.lambda$filterPadData$7((com.up366.mobile.common.logic.model.MyBook) obj);
            }
        }).collect(java8.util.stream.Collectors.toList());
    }

    static /* synthetic */ boolean lambda$filterPadData$4(com.up366.mobile.common.logic.model.MyBook myBook) {
        return !"DC608A039962D060BBB4C8D6314C994D".equals(myBook.getBookId());
    }

    static /* synthetic */ boolean lambda$filterPadData$5(com.up366.mobile.common.logic.model.MyBook myBook) {
        return !"D2F0DC15224FE05EF5CDEBC1D23E7D39".equals(myBook.getBookId());
    }

    static /* synthetic */ boolean lambda$filterPadData$6(com.up366.mobile.common.logic.model.MyBook myBook) {
        return !"FE37AFE4A9520F4FAC70BB89CE1E9CF7".equals(myBook.getBookId());
    }

    static /* synthetic */ boolean lambda$filterPadData$7(com.up366.mobile.common.logic.model.MyBook myBook) {
        return !"B97FB79E06266CAF7BBF81FE77B70A47".equals(myBook.getBookId());
    }

    public static java.util.List<com.up366.mobile.common.logic.model.MyBook> getMyBooksFromCacheEvent() {
        com.up366.mobile.common.event.MyBookListEvent myBookListEvent = (com.up366.mobile.common.event.MyBookListEvent) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.MINE_BOOK_LIST_EVENT);
        if (myBookListEvent == null || myBookListEvent.books == null) {
            return new java.util.ArrayList();
        }
        return myBookListEvent.books;
    }

    public static java.util.List<com.up366.mobile.course.mgr.CourseInfo> getCourseListFromCacheEvent() {
        com.up366.mobile.common.event.MyBookListEvent myBookListEvent = (com.up366.mobile.common.event.MyBookListEvent) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.MINE_BOOK_LIST_EVENT);
        if (myBookListEvent == null || myBookListEvent.courseInfoS == null) {
            return new java.util.ArrayList();
        }
        return myBookListEvent.courseInfoS;
    }
}
