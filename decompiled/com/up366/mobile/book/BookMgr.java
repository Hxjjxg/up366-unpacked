package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookMgr {
    private static final java.lang.String KEY_TREE_BOOKID_MEMORY = "__bookid__memory__";
    private static final java.lang.String KEY_TREE_TASKID = "__tree__taskid__";
    private static final java.lang.String KEY_TREE_TASKID_MEMORY = "__tree__taskid__memory__";
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;
    private final java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.ProductInfo> productMap = new java.util.HashMap();

    public BookMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
        loadMyProducts();
    }

    public void fetchGoodsCategoryList() {
        loadGoodsCategoryList();
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.market.GoodsCategory>>(com.up366.mobile.common.http.HttpMgrUtils.goodsCategoryList) { // from class: com.up366.mobile.book.BookMgr.1
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.market.GoodsCategory> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                com.up366.mobile.common.utils.PreferenceUtils.putText("GoodsCategoryList", str);
                return com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.market.GoodsCategory.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.market.GoodsCategory> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.GoodsCategoryListRefresh(list, response));
            }
        });
    }

    public void loadGoodsCategoryList() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.BookMgr.lambda$loadGoodsCategoryList$0();
            }
        });
    }

    static /* synthetic */ void lambda$loadGoodsCategoryList$0() throws java.lang.Exception {
        java.lang.String text = com.up366.mobile.common.utils.PreferenceUtils.getText("GoodsCategoryList", "");
        if (com.up366.common.StringUtils.isEmptyOrNull(text)) {
            return;
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.GoodsCategoryListRefresh(com.alibaba.fastjson.JSON.parseArray(text, com.up366.mobile.market.GoodsCategory.class)));
    }

    public void fetchRecommendGoodList() {
        int schoolType = com.up366.mobile.common.logic.Auth.getUserInfo().getSchoolType();
        if (schoolType != 2 && schoolType != 3) {
            schoolType = 3;
        }
        com.up366.mobile.common.logic.Auth.cur().book().fetchGoodsList(schoolType * (-1), 2);
    }

    public void fetchGoodsListByPage(final int i, final int i2, final int i3, final int i4) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.market.GoodsInfo>>(com.up366.mobile.common.http.HttpMgrUtils.goodsListPager) { // from class: com.up366.mobile.book.BookMgr.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("categoryId", java.lang.Integer.valueOf(i));
                map.put("pager.pageSize", java.lang.Integer.valueOf(i3));
                map.put("pager.currentPage", java.lang.Integer.valueOf(i2));
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.market.GoodsInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                java.util.List<com.up366.mobile.market.GoodsInfo> pagerList = com.up366.mobile.common.utils.ResponseUtil.parsePagerList(str, com.up366.mobile.market.GoodsInfo.class);
                com.up366.mobile.book.BookMgr.this.db.getGoodsInfoDao().insertOrReplaceInTx(pagerList);
                for (com.up366.mobile.market.GoodsInfo goodsInfo : pagerList) {
                    goodsInfo.setHasBuy(com.up366.mobile.book.BookMgr.this.hasBuy(0, goodsInfo.getSpGoodsId(), true));
                }
                return pagerList;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.market.GoodsInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.GoodsListRefresh(response, list, i4, i));
            }
        });
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.BookMgr$3, reason: invalid class name */
    class AnonymousClass3 extends com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.market.GoodsInfo>> {
        final /* synthetic */ int val$categoryId;
        final /* synthetic */ int val$type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(java.lang.String str, int i, int i2) {
            super(str);
            this.val$categoryId = i;
            this.val$type = i2;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            map.put("categoryId", java.lang.Integer.valueOf(this.val$categoryId));
            map.put(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, 0);
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.List<com.up366.mobile.market.GoodsInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            final java.util.List<com.up366.mobile.market.GoodsInfo> pagerList = com.up366.mobile.common.utils.ResponseUtil.parsePagerList(str, com.up366.mobile.market.GoodsInfo.class);
            java.util.List<com.up366.mobile.market.GoodsInfo> list = com.up366.mobile.book.BookMgr.this.db.getGoodsInfoDao().queryBuilder().where(com.up366.greendao.GoodsInfoDao.Properties.RecommentId.lt(0), new org.greenrobot.greendao.query.WhereCondition[0]).list();
            android.util.SparseArray sparseArray = new android.util.SparseArray(list.size());
            for (com.up366.mobile.market.GoodsInfo goodsInfo : list) {
                sparseArray.put(goodsInfo.getGoodsId(), goodsInfo);
            }
            for (com.up366.mobile.market.GoodsInfo goodsInfo2 : pagerList) {
                int recommentId = this.val$categoryId;
                com.up366.mobile.market.GoodsInfo goodsInfo3 = (com.up366.mobile.market.GoodsInfo) sparseArray.get(goodsInfo2.getGoodsId());
                if (this.val$categoryId > 0 && goodsInfo3 != null) {
                    recommentId = goodsInfo3.getRecommentId();
                }
                goodsInfo2.setRecommentId(recommentId);
                goodsInfo2.setGuid(goodsInfo2.getGoodsId() + "-" + recommentId);
            }
            java.util.Collections.sort(pagerList, new java.util.Comparator() { // from class: com.up366.mobile.book.BookMgr$3$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return com.up366.mobile.book.BookMgr.AnonymousClass3.lambda$handleResponse$0((com.up366.mobile.market.GoodsInfo) obj, (com.up366.mobile.market.GoodsInfo) obj2);
                }
            });
            com.up366.greendao.DaoSession daoSession = com.up366.mobile.book.BookMgr.this.db;
            final int i = this.val$categoryId;
            daoSession.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.book.BookMgr$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleResponse$1(i, pagerList);
                }
            });
            return pagerList;
        }

        static /* synthetic */ int lambda$handleResponse$0(com.up366.mobile.market.GoodsInfo goodsInfo, com.up366.mobile.market.GoodsInfo goodsInfo2) {
            return goodsInfo2.getSortOrder() - goodsInfo.getSortOrder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleResponse$1(int i, java.util.List list) {
            com.up366.mobile.book.BookMgr.this.db.getGoodsInfoDao().queryBuilder().where(com.up366.greendao.GoodsInfoDao.Properties.CategoryId.eq(java.lang.Integer.valueOf(i)), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
            com.up366.mobile.book.BookMgr.this.db.getGoodsInfoDao().insertOrReplaceInTx(list);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.market.GoodsInfo> list) {
            super.onResponse(response, list);
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.GoodsListRefresh(response, this.val$type, list));
        }
    }

    public void fetchGoodsList(int i, int i2) {
        loadGoodsList(i, i2);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.book.BookMgr.AnonymousClass3(com.up366.mobile.common.http.HttpMgrUtils.goodsList, i, i2));
    }

    public void loadGoodsList(final int i, final int i2) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda32
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadGoodsList$2(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGoodsList$2(int i, int i2) throws java.lang.Exception {
        java.util.List list;
        if (i < 0) {
            list = this.db.getGoodsInfoDao().queryBuilder().where(com.up366.greendao.GoodsInfoDao.Properties.RecommentId.eq(java.lang.Integer.valueOf(i)), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        } else {
            list = this.db.getGoodsInfoDao().queryBuilder().where(com.up366.greendao.GoodsInfoDao.Properties.CategoryId.eq(java.lang.Integer.valueOf(i)), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda18
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.book.BookMgr.lambda$loadGoodsList$1((com.up366.mobile.market.GoodsInfo) obj, (com.up366.mobile.market.GoodsInfo) obj2);
            }
        });
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.GoodsListRefresh(list, i2));
    }

    static /* synthetic */ int lambda$loadGoodsList$1(com.up366.mobile.market.GoodsInfo goodsInfo, com.up366.mobile.market.GoodsInfo goodsInfo2) {
        return goodsInfo2.getSortOrder() - goodsInfo.getSortOrder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEtParamIfNeeded(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (com.up366.mobile.common.logic.Auth.cur() == null || com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr() == null || com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().isPrivateCloudState(null)) {
            return;
        }
        map.put("et", "1");
    }

    public void fetchGoodsDesc(final int i) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.market.GoodsDescInfo>(com.up366.mobile.common.http.HttpMgrUtils.goodsDesc) { // from class: com.up366.mobile.book.BookMgr.4
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("goodsId", java.lang.Integer.valueOf(i));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.market.GoodsDescInfo handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return (com.up366.mobile.market.GoodsDescInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.market.GoodsDescInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.market.GoodsDescInfo goodsDescInfo) {
                super.onResponse(response, goodsDescInfo);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.GoodsDescRefresh(response, goodsDescInfo));
            }
        });
    }

    public void fetchFileInfo(java.lang.String str, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.book.model.FileInfo> iCallbackResponse) {
        final java.lang.String strTrim = com.up366.mobile.common.utils.HmacSHA1Signature.computeSignature("au66ssoI3nGr6DxCHk8KcpVsQ1wYNQId", "GETOBJECTschool" + str).trim();
        final java.lang.String str2 = "school";
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.book.model.FileInfo>(com.up366.mobile.common.http.HttpMgrUtils.fileInfo + str) { // from class: com.up366.mobile.book.BookMgr.5
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("app", str2);
                map.put("auth", strTrim);
                com.up366.mobile.book.BookMgr.this.addEtParamIfNeeded(map);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.book.model.FileInfo handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                com.up366.common.log.Logger.info("TAG - BookMgr - handleResponse - resp = [" + response + "], result = [" + str3 + "]");
                return (com.up366.mobile.book.model.FileInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str3, com.up366.mobile.book.model.FileInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.book.model.FileInfo fileInfo) {
                super.onResponse(response, fileInfo);
                iCallbackResponse.onResult(response, fileInfo);
            }
        });
    }

    public void fetchFileInfoBatch(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.book.model.FileInfo>> iCallbackResponse) {
        final java.lang.String strTrim = com.up366.mobile.common.utils.HmacSHA1Signature.computeSignature("au66ssoI3nGr6DxCHk8KcpVsQ1wYNQId", "GETOBJECTschool" + str).trim();
        final java.lang.String str2 = "school";
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.book.model.FileInfo>>(com.up366.mobile.common.http.HttpMgrUtils.fileInfoBatch) { // from class: com.up366.mobile.book.BookMgr.6
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("fileids", str);
                map.put("app", str2);
                map.put("auth", strTrim);
                com.up366.mobile.book.BookMgr.this.addEtParamIfNeeded(map);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.book.model.FileInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                com.up366.common.log.Logger.info("TAG - BookMgr - handleResponse - resp = [" + response + "], result = [" + str3 + "]");
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str3, com.up366.mobile.book.model.FileInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.book.model.FileInfo> list) {
                super.onResponse(response, list);
                iCallbackResponse.onResult(response, list);
            }
        });
    }

    public void fetchMyProducts() {
        loadMyProducts();
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            fetchMyProducts(null);
        }
    }

    public void fetchMyProducts(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.common.logic.model.ProductInfo>> iCallbackResponse) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda26
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchMyProducts$4(iCallbackResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchMyProducts$4(final com.up366.common.callback.ICallbackResponse iCallbackResponse) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.ProductInfo>> netHolderFetchMyProductsSync = fetchMyProductsSync();
        if (iCallbackResponse == null) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.HasBuyProductRefresh(netHolderFetchMyProductsSync.resp));
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                    com.up366.common.http.NetHolder netHolder = netHolderFetchMyProductsSync;
                    iCallbackResponse2.onResult(netHolder.resp, (java.util.List) netHolder.info);
                }
            });
        }
    }

    public com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.ProductInfo>> fetchMyProductsSync() throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.common.logic.model.ProductInfo>> netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.getMyBooks).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda5
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return this.f$0.lambda$fetchMyProductsSync$6(response, str);
            }
        }));
        if (netHolderPostSync.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - BookMgr - fetchMyProductsSync - error " + netHolderPostSync.resp.toString());
        }
        return netHolderPostSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.util.List lambda$fetchMyProductsSync$6(com.up366.common.http.Response response, java.lang.String str) {
        final java.util.List<com.up366.mobile.common.logic.model.ProductInfo> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.common.logic.model.ProductInfo.class);
        fillProductMap(array);
        fillProductLastStudyTime(array);
        setUpNewStatus(array);
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchMyProductsSync$5(array);
            }
        });
        com.up366.common.log.Logger.info("TAG - BookMgr - fetchMyProductsSync  success ");
        this.manager.cache().putMemorySync("fetchMyProductsSync", true, 86400000L);
        return new java.util.ArrayList(array);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchMyProductsSync$5(java.util.List list) {
        this.db.deleteAll(com.up366.mobile.common.logic.model.ProductInfo.class);
        this.db.getProductInfoDao().insertInTx(list);
    }

    public void loadMyProducts() {
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMyProducts$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMyProducts$8() {
        final java.util.List listLoadAll = this.db.getProductInfoDao().loadAll();
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            this.db.deleteAll(com.up366.mobile.common.logic.model.ProductInfo.class);
            listLoadAll = new java.util.ArrayList();
        }
        fillProductMap(listLoadAll);
        fillProductLastStudyTime(listLoadAll);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadMyProducts$7(listLoadAll);
            }
        });
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.HasBuyProductRefresh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMyProducts$7(java.util.List list) throws java.lang.Exception {
        setUpNewStatus(new java.util.ArrayList(list));
    }

    private void fillProductMap(java.util.List<com.up366.mobile.common.logic.model.ProductInfo> list) {
        synchronized (this.productMap) {
            this.productMap.clear();
            for (com.up366.mobile.common.logic.model.ProductInfo productInfo : list) {
                this.productMap.put(productInfo.getBookId(), productInfo);
            }
        }
    }

    private void fillProductLastStudyTime(java.util.List<com.up366.mobile.common.logic.model.ProductInfo> list) {
        if (this.manager.bookProgress() == null) {
            return;
        }
        for (com.up366.mobile.common.logic.model.ProductInfo productInfo : list) {
            productInfo.setLastStudyTime(this.manager.bookProgress().get(productInfo.getBookId()).getLastStudyTime());
        }
    }

    private void setUpNewStatus(java.util.List<com.up366.mobile.common.logic.model.ProductInfo> list) {
        if (list == null) {
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        for (com.up366.mobile.common.logic.model.ProductInfo productInfo : list) {
            java.lang.String str = (java.lang.String) this.manager.cache().loadSync("book-cached-version-" + productInfo.getBookId(), java.lang.String.class);
            if (str != null && !str.equals(productInfo.getMobileRevision())) {
                productInfo.setNew(true);
            } else {
                productInfo.setNew(false);
            }
        }
        com.up366.common.log.Logger.debug("count BookMgr.setUpNewStatus time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
    }

    public boolean hasBuy(int i, java.lang.String str, boolean z) {
        com.up366.mobile.course.mgr.CourseBookInfo next;
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            return !z;
        }
        com.up366.mobile.course.mgr.CourseInfo courseInfo = this.manager.course().getCourseInfo(i);
        if (courseInfo != null) {
            if (courseInfo.isGoods()) {
                return true;
            }
            if (courseInfo.getBooks() != null) {
                java.util.Iterator<com.up366.mobile.course.mgr.CourseBookInfo> it = courseInfo.getBooks().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.getBookId().equals(str)) {
                        break;
                    }
                }
                if (next != null && (next.getGoodsPrice() == 0.0f || !next.isGoods())) {
                    return true;
                }
            }
        }
        if (!z) {
            return true;
        }
        com.up366.mobile.common.logic.model.ProductInfo productInfo = getProductInfo(str);
        if (productInfo == null) {
            if (!com.up366.mobile.common.compat.SpecialUserUtils.isNanTongUser()) {
                return false;
            }
            com.up366.mobile.common.onlinelog.OpLog.report("hasBuy-getProductInfo", "get ProductInfo is null, userInfo " + com.alibaba.fastjson.JSON.toJSONString(com.up366.mobile.common.logic.Auth.getUserInfo()));
            return true;
        }
        long endDate = productInfo.getEndDate();
        return endDate < 1 || com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() < endDate;
    }

    public com.up366.mobile.common.logic.model.ProductInfo getProductInfo(java.lang.String str) {
        com.up366.mobile.common.logic.model.ProductInfo productInfo;
        synchronized (this.productMap) {
            productInfo = this.productMap.get(str);
        }
        return productInfo;
    }

    public void fetchBookDetail(java.lang.String str, int i) {
        fetchBookDetail(str, i, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda28
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.ProductInfoUpdate(response, (com.up366.mobile.book.model.BookDetailInfo) obj));
            }
        });
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> fetchBookDetailSync(java.lang.String str, int i) throws java.lang.InterruptedException {
        return fetchBookDetailSync(str, null, i);
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> fetchBookDetailSync(java.lang.String str, java.lang.String str2, int i) throws java.lang.InterruptedException {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolder = new com.up366.common.http.NetHolder<>();
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            fetchBookDetail(str, i, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda30
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.book.BookMgr.lambda$fetchBookDetailSync$10(netHolder, countDownLatch, response, (com.up366.mobile.book.model.BookDetailInfo) obj);
                }
            });
        } else {
            fetchBookDetail(str, str2, i, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda31
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.book.BookMgr.lambda$fetchBookDetailSync$11(netHolder, countDownLatch, response, (com.up366.mobile.book.model.BookDetailInfo) obj);
                }
            });
        }
        countDownLatch.await();
        return netHolder;
    }

    static /* synthetic */ void lambda$fetchBookDetailSync$10(com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        netHolder.initWith(response, bookDetailInfo);
        countDownLatch.countDown();
    }

    static /* synthetic */ void lambda$fetchBookDetailSync$11(com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch, com.up366.common.http.Response response, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo) {
        netHolder.initWith(response, bookDetailInfo);
        countDownLatch.countDown();
    }

    public com.up366.mobile.book.model.BookDetailInfo loadBookDetailInfo(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return (com.up366.mobile.book.model.BookDetailInfo) this.db.getBookDetailInfoDao().queryBuilder().where(com.up366.greendao.BookDetailInfoDao.Properties.BookId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
    }

    public void loadChapterPlanAndFinishedTaskSync(final com.up366.mobile.book.model.TreeBookChapter treeBookChapter, final boolean z) {
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadChapterPlanAndFinishedTaskSync$12(treeBookChapter, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadChapterPlanAndFinishedTaskSync$12(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, boolean z) {
        com.up366.mobile.book.model.BookInfoStudy book = treeBookChapter.getBook();
        java.lang.String bookId = book.getBookId();
        int courseId = book.getCourseId();
        com.up366.mobile.book.model.BookDetailInfo bookDetailInfo = (com.up366.mobile.book.model.BookDetailInfo) this.db.getBookDetailInfoDao().queryBuilder().where(com.up366.greendao.BookDetailInfoDao.Properties.BookId.eq(bookId), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        if (bookDetailInfo == null) {
            return;
        }
        book.initWithBookDetailInfo(bookDetailInfo);
        book.initHasBuy();
        java.util.List<com.up366.mobile.book.model.ChapterInfo> list = this.db.getChapterInfoDao().queryBuilder().where(com.up366.greendao.ChapterInfoDao.Properties.BookId.eq(bookId), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        java.util.List<com.up366.mobile.book.model.BookTaskFinishedInfo> list2 = this.db.getBookTaskFinishedInfoDao().queryBuilder().where(com.up366.greendao.BookTaskFinishedInfoDao.Properties.BookId.eq(bookId), new org.greenrobot.greendao.query.WhereCondition[0]).list();
        java.util.HashMap map = new java.util.HashMap();
        java.util.HashMap map2 = new java.util.HashMap();
        if (!z) {
            for (com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo : list2) {
                map.put(bookTaskFinishedInfo.getTaskId(), bookTaskFinishedInfo);
            }
            for (com.up366.mobile.book.model.CourseBookPlan courseBookPlan : this.db.getCourseBookPlanDao().queryBuilder().where(com.up366.greendao.CourseBookPlanDao.Properties.CourseId.eq(java.lang.Integer.valueOf(courseId)), new org.greenrobot.greendao.query.WhereCondition[]{com.up366.greendao.CourseBookPlanDao.Properties.BookId.eq(bookId)}).list()) {
                map2.put(courseBookPlan.getChapterId(), courseBookPlan);
            }
        }
        if (bookDetailInfo.hasCustomTask()) {
            treeBookChapter.setCustomChapterList((java.util.List) this.manager.cache().loadSync("custom-tasks-" + courseId + "-" + bookId, new com.alibaba.fastjson.TypeReference<java.util.List<com.up366.mobile.book.model.CustomChapterInfo>>() { // from class: com.up366.mobile.book.BookMgr.7
            }));
        }
        treeBookChapter.setPlanAndTaskMap(map2, map);
        treeBookChapter.init(list);
        if (list.size() > 0) {
            treeBookChapter.setHasLoadTreeChapterData(true);
        }
    }

    public void tempCacheBookDetailByBookId(java.lang.String str, java.lang.String str2) {
        this.manager.cache().putMemorySync(KEY_TREE_BOOKID_MEMORY + str, str2, com.igexin.push.config.c.s);
    }

    public void fetchBookDetail(java.lang.String str, int i, com.up366.common.callback.ICallbackResponse<com.up366.mobile.book.model.BookDetailInfo> iCallbackResponse) {
        fetchBookDetail(str, null, i, iCallbackResponse);
    }

    public void fetchBookDetail(final java.lang.String str, final java.lang.String str2, final int i, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.book.model.BookDetailInfo> iCallbackResponse) {
        java.lang.String str3;
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            str3 = com.up366.mobile.common.http.HttpMgrUtils.bookInfo;
        } else {
            str3 = com.up366.mobile.common.http.HttpMgrUtils.bookInfoAuth;
        }
        java.lang.String str4 = str3;
        com.up366.common.log.Logger.info("TAG - BookMgr - fetchBookDetail - bookId:" + str + " originalBookId = " + str2 + " bookType:" + i);
        com.up366.mobile.common.logic.AppCacheMgr appCacheMgrCache = this.manager.cache();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(KEY_TREE_BOOKID_MEMORY);
        sb.append(str);
        java.lang.String str5 = (java.lang.String) appCacheMgrCache.loadMemorySync(sb.toString());
        if (str5 != null) {
            com.up366.mobile.book.model.BookDetailInfo bookDetailInfo = (com.up366.mobile.book.model.BookDetailInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str5, com.up366.mobile.book.model.BookDetailInfo.class);
            this.db.getBookDetailInfoDao().insertOrReplace(bookDetailInfo);
            com.up366.common.http.Response response = new com.up366.common.http.Response();
            response.setCode(0);
            iCallbackResponse.onResult(response, bookDetailInfo);
            return;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.book.model.BookDetailInfo>(str4) { // from class: com.up366.mobile.book.BookMgr.8
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
                map.put("bookType", java.lang.Integer.valueOf(i));
                if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
                    return;
                }
                map.put("originalBookId", str2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.book.model.BookDetailInfo handleResponse(com.up366.common.http.Response response2, java.lang.String str6) {
                com.up366.common.log.Logger.info("TAG - BookMgr - fetchBookDetail - handleResponse - " + str6);
                com.up366.mobile.book.model.BookDetailInfo bookDetailInfo2 = (com.up366.mobile.book.model.BookDetailInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str6, com.up366.mobile.book.model.BookDetailInfo.class);
                com.up366.mobile.book.BookMgr.this.db.getBookDetailInfoDao().insertOrReplace(bookDetailInfo2);
                return bookDetailInfo2;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response2, com.up366.mobile.book.model.BookDetailInfo bookDetailInfo2) {
                super.onResponse(response2, bookDetailInfo2);
                if (response2.isError()) {
                    com.up366.common.log.Logger.error("TAG - BookMgr - fetchBookDetail - onResponse - " + response2);
                }
                iCallbackResponse.onResult(response2, bookDetailInfo2);
            }
        });
    }

    public void fetchTreeChapters(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.book.model.ChapterInfo>> iCallbackResponse) {
        java.lang.String str;
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            str = com.up366.mobile.common.http.HttpMgrUtils.bookTree;
        } else {
            str = com.up366.mobile.common.http.HttpMgrUtils.bookTreeAuth;
        }
        java.lang.String str2 = str;
        com.up366.mobile.book.model.BookInfoStudy book = treeBookChapter.getBook();
        java.lang.String bookId = book.getBookId();
        int bookType = book.getBookType();
        book.getCourseId();
        java.lang.String str3 = (java.lang.String) this.manager.cache().loadSync("book-tree-version-" + bookId, java.lang.String.class);
        com.up366.common.log.Logger.info("TAG - BookMgr - fetchTreeChapters - param : " + book.toString());
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.book.BookMgr.AnonymousClass9(str2, bookId, bookType, str3, treeBookChapter, iCallbackResponse));
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.BookMgr$9, reason: invalid class name */
    class AnonymousClass9 extends com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.book.model.ChapterInfo>> {
        final /* synthetic */ java.lang.String val$bookId;
        final /* synthetic */ int val$bookType;
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
        final /* synthetic */ com.up366.mobile.book.model.TreeBookChapter val$treeBookChapter;
        final /* synthetic */ java.lang.String val$version;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$bookId = str2;
            this.val$bookType = i;
            this.val$version = str3;
            this.val$treeBookChapter = treeBookChapter;
            this.val$callback = iCallbackResponse;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.val$bookId);
            map.put("bookType", java.lang.Integer.valueOf(this.val$bookType));
            java.lang.String str = this.val$version;
            if (str != null) {
                map.put("version", str);
            }
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.List<com.up366.mobile.book.model.ChapterInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            com.alibaba.fastjson.JSONObject object = com.up366.mobile.common.utils.ResponseUtil.parseObject(str);
            java.lang.String string = object.getString("version");
            java.lang.String str2 = this.val$version;
            if (str2 != null && str2.equals(string)) {
                java.lang.String str3 = (java.lang.String) com.up366.mobile.book.BookMgr.this.manager.cache().loadSync("book-tree-version-fileId-" + this.val$bookId, java.lang.String.class);
                if (str3 != null) {
                    this.val$treeBookChapter.getBook().setFileId(com.up366.mobile.book.BookMgr.this.manager.config().convertBookFileId(this.val$bookId, str3));
                }
                com.up366.common.log.Logger.info("TAG - BookMgr - fetchTreeChapters - handleResponse - cached version:" + this.val$version + " fileId:" + str3);
                return com.up366.mobile.book.BookMgr.this.db.getChapterInfoDao().queryBuilder().where(com.up366.greendao.ChapterInfoDao.Properties.BookId.eq(this.val$bookId), new org.greenrobot.greendao.query.WhereCondition[0]).list();
            }
            java.util.List array = com.up366.mobile.common.utils.ResponseUtil.parseArray(object.getString(com.up366.mobile.book.helper.V9ResourceHelper.DIR_CHAPTERS), com.up366.mobile.book.model.ChapterInfo.class);
            java.util.List array2 = com.up366.mobile.common.utils.ResponseUtil.parseArray(object.getString("pages"), com.up366.mobile.book.model.ChapterInfo.class);
            java.util.List array3 = com.up366.mobile.common.utils.ResponseUtil.parseArray(object.getString("tasks"), com.up366.mobile.book.model.ChapterInfo.class);
            java.lang.String string2 = object.getJSONObject("book") != null ? object.getJSONObject("book").getString("fileId") : null;
            com.up366.common.log.Logger.info("TAG - BookMgr - fetchTreeChapters - handleResponse - no cached version:" + string + " old version:" + this.val$version + " fileId:" + string2 + " chapters.size:" + array.size() + " pages.size:" + array2.size() + " tasks.size:" + array3.size());
            final java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(array);
            arrayList.addAll(array2);
            arrayList.addAll(array3);
            final java.lang.String bookId = this.val$treeBookChapter.getBook().getBookId();
            this.val$treeBookChapter.getBook().setFileId(com.up366.mobile.book.BookMgr.this.manager.config().convertBookFileId(bookId, string2));
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.up366.mobile.book.model.ChapterInfo) it.next()).setBookId(bookId);
            }
            com.up366.mobile.book.BookMgr.this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.book.BookMgr$9$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleResponse$0(bookId, arrayList);
                }
            });
            long jCount = com.up366.mobile.book.BookMgr.this.db.getChapterInfoDao().queryBuilder().where(com.up366.greendao.ChapterInfoDao.Properties.BookId.eq(bookId), new org.greenrobot.greendao.query.WhereCondition[0]).count();
            if (jCount == arrayList.size()) {
                if (!com.up366.common.StringUtils.isEmptyOrNull(string2)) {
                    com.up366.mobile.book.BookMgr.this.manager.cache().put("book-tree-version-fileId-" + bookId, string2, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
                }
                com.up366.mobile.book.BookMgr.this.manager.cache().put("book-tree-version-" + bookId, string, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
            } else {
                com.up366.mobile.common.onlinelog.OpLog.report("ERROR_bookMgr_no_chapter", " bookId:" + bookId + " oldVersion:" + this.val$version + " newVersion:" + string + " chapters.size:" + array.size() + " pages.size:" + array2.size() + " tasks.size:" + array3.size() + " chapterInfos.size:" + arrayList.size() + " count:" + jCount);
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleResponse$0(java.lang.String str, java.util.List list) {
            com.up366.mobile.book.BookMgr.this.db.getChapterInfoDao().queryBuilder().where(com.up366.greendao.ChapterInfoDao.Properties.BookId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
            com.up366.mobile.book.BookMgr.this.db.getChapterInfoDao().insertInTx(list);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.book.model.ChapterInfo> list) {
            if (response.isError()) {
                com.up366.common.log.Logger.error("TAG - BookMgr - fetchBookDetail - onResponse - " + response);
            }
            this.val$callback.onResult(response, list);
        }
    }

    public void fetchBookFinishedTask(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, final com.up366.common.callback.ICallbackResponse<java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo>> iCallbackResponse) {
        final java.lang.String bookId = treeBookChapter.getBook().getBookId();
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            iCallbackResponse.onResult(new com.up366.common.http.Response(0, "", "", 0, null), new java.util.HashMap());
        } else {
            com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo>>(com.up366.mobile.common.http.HttpMgrUtils.bookFinishedTask) { // from class: com.up366.mobile.book.BookMgr.10
                @Override // com.up366.common.http.RequestParams
                public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                    map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookId);
                }

                @Override // com.up366.common.http.RequestParams
                public java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                    java.util.List<com.up366.mobile.book.model.BookTaskFinishedInfo> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.book.model.BookTaskFinishedInfo.class);
                    java.util.HashMap map = new java.util.HashMap();
                    for (com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo : array) {
                        map.put(bookTaskFinishedInfo.getTaskId(), bookTaskFinishedInfo);
                    }
                    for (com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo2 : com.up366.mobile.book.BookMgr.this.db.getBookTaskFinishedInfoDao().queryBuilder().where(com.up366.greendao.BookTaskFinishedInfoDao.Properties.BookId.eq(bookId), new org.greenrobot.greendao.query.WhereCondition[0]).list()) {
                        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo3 = (com.up366.mobile.book.model.BookTaskFinishedInfo) map.get(bookTaskFinishedInfo2.getTaskId());
                        if (bookTaskFinishedInfo3 != null && bookTaskFinishedInfo3.getStudyDate() < bookTaskFinishedInfo2.getStudyDate()) {
                            bookTaskFinishedInfo3.setStudyDate(bookTaskFinishedInfo2.getStudyDate());
                            bookTaskFinishedInfo3.setPercent(bookTaskFinishedInfo2.getPercent());
                            bookTaskFinishedInfo3.setScore(bookTaskFinishedInfo2.getScore());
                            bookTaskFinishedInfo3.setAddDate(bookTaskFinishedInfo2.getAddDate());
                        }
                    }
                    com.up366.mobile.book.BookMgr.this.db.getBookTaskFinishedInfoDao().insertOrReplaceInTx(array);
                    return map;
                }

                @Override // com.up366.common.http.RequestParams
                public void onResponse(com.up366.common.http.Response response, java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> map) {
                    if (response.isError()) {
                        com.up366.common.log.Logger.error("TAG - BookMgr - fetchBookFinishedTask - onResponse - " + response.toString());
                    }
                    iCallbackResponse.onResult(response, map);
                }
            });
        }
    }

    public void fetchCourseBookPlan(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.common.callback.ICallbackResponse<java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan>> iCallbackResponse) {
        com.up366.mobile.book.model.BookInfoStudy book = treeBookChapter.getBook();
        java.lang.String bookId = book.getBookId();
        int courseId = book.getCourseId();
        if (courseId < 1) {
            iCallbackResponse.onResult(new com.up366.common.http.Response(0, "", "", 0, null), new java.util.HashMap());
        } else {
            com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.book.BookMgr.AnonymousClass11(com.up366.mobile.common.http.HttpMgrUtils.courseBookPlan, courseId, bookId, iCallbackResponse));
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.BookMgr$11, reason: invalid class name */
    class AnonymousClass11 extends com.up366.common.http.RequestParams<java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan>> {
        final /* synthetic */ java.lang.String val$bookId;
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
        final /* synthetic */ int val$courseId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(java.lang.String str, int i, java.lang.String str2, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$courseId = i;
            this.val$bookId = str2;
            this.val$callback = iCallbackResponse;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(this.val$courseId));
            map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.val$bookId);
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            final java.util.List<com.up366.mobile.book.model.CourseBookPlan> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.book.model.CourseBookPlan.class);
            for (com.up366.mobile.book.model.CourseBookPlan courseBookPlan : array) {
                courseBookPlan.setCourseId(this.val$courseId);
                courseBookPlan.setBookId(this.val$bookId);
                courseBookPlan.initGuid();
            }
            com.up366.greendao.DaoSession daoSession = com.up366.mobile.book.BookMgr.this.db;
            final int i = this.val$courseId;
            final java.lang.String str2 = this.val$bookId;
            daoSession.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.book.BookMgr$11$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleResponse$0(i, str2, array);
                }
            });
            java.util.HashMap map = new java.util.HashMap();
            for (com.up366.mobile.book.model.CourseBookPlan courseBookPlan2 : array) {
                map.put(courseBookPlan2.getChapterId(), courseBookPlan2);
            }
            return map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleResponse$0(int i, java.lang.String str, java.util.List list) {
            com.up366.mobile.book.BookMgr.this.db.getCourseBookPlanDao().queryBuilder().where(com.up366.greendao.CourseBookPlanDao.Properties.CourseId.eq(java.lang.Integer.valueOf(i)), new org.greenrobot.greendao.query.WhereCondition[]{com.up366.greendao.CourseBookPlanDao.Properties.BookId.eq(str)}).buildDelete().executeDeleteWithoutDetachingEntities();
            com.up366.mobile.book.BookMgr.this.db.getCourseBookPlanDao().insertInTx(list);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> map) {
            if (response.isError()) {
                com.up366.common.log.Logger.error("TAG - BookMgr - fetchCourseBookPlan - onResponse - " + response.toString());
            }
            this.val$callback.onResult(response, map);
        }
    }

    public void fetchChapterPlanAndFinishedTask(final com.up366.mobile.book.model.TreeBookChapter treeBookChapter, final boolean z) {
        java.lang.System.currentTimeMillis();
        final com.up366.mobile.book.model.BookInfoStudy book = treeBookChapter.getBook();
        com.up366.mobile.common.utils.TaskChainTool taskChainToolQuery = new com.up366.mobile.common.utils.TaskChainTool().query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda19
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                this.f$0.lambda$fetchChapterPlanAndFinishedTask$13(book, iReturnOps);
            }
        }).query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda20
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                this.f$0.lambda$fetchChapterPlanAndFinishedTask$14(treeBookChapter, iReturnOps);
            }
        });
        if (!z) {
            taskChainToolQuery.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda21
                @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
                public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                    this.f$0.lambda$fetchChapterPlanAndFinishedTask$15(treeBookChapter, iReturnOps);
                }
            }).query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda23
                @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
                public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                    this.f$0.lambda$fetchChapterPlanAndFinishedTask$16(treeBookChapter, iReturnOps);
                }
            });
        }
        taskChainToolQuery.doQueryParallel();
        taskChainToolQuery.onSuccess(new com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda24
            @Override // com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback
            public final void success(int i, java.lang.String str, java.lang.Object[] objArr) {
                this.f$0.lambda$fetchChapterPlanAndFinishedTask$18(book, z, treeBookChapter, i, str, objArr);
            }
        });
        taskChainToolQuery.onError(new com.up366.mobile.common.utils.TaskChainTool.IErrorCallback() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda25
            @Override // com.up366.mobile.common.utils.TaskChainTool.IErrorCallback
            public final void error(int i, java.lang.String str) {
                com.up366.mobile.book.BookMgr.lambda$fetchChapterPlanAndFinishedTask$19(treeBookChapter, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTask$13(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        java.lang.String bookId = bookInfoStudy.getBookId();
        int bookType = bookInfoStudy.getBookType();
        java.util.Objects.requireNonNull(iReturnOps);
        fetchBookDetail(bookId, bookType, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda29(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTask$14(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        java.util.Objects.requireNonNull(iReturnOps);
        fetchTreeChapters(treeBookChapter, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda11(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTask$15(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        java.util.Objects.requireNonNull(iReturnOps);
        fetchBookFinishedTask(treeBookChapter, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda27(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTask$16(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        java.util.Objects.requireNonNull(iReturnOps);
        fetchCourseBookPlan(treeBookChapter, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda27(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTask$18(final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, final boolean z, final com.up366.mobile.book.model.TreeBookChapter treeBookChapter, final int i, final java.lang.String str, final java.lang.Object[] objArr) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda22
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchChapterPlanAndFinishedTask$17(objArr, bookInfoStudy, z, treeBookChapter, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTask$17(java.lang.Object[] objArr, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, boolean z, com.up366.mobile.book.model.TreeBookChapter treeBookChapter, int i, java.lang.String str) throws java.lang.Exception {
        java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> map;
        java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> map2;
        com.up366.mobile.book.model.BookDetailInfo bookDetailInfo = (com.up366.mobile.book.model.BookDetailInfo) objArr[0];
        bookInfoStudy.initWithBookDetailInfo(bookDetailInfo);
        bookInfoStudy.initHasBuy();
        java.util.List<com.up366.mobile.book.model.ChapterInfo> list = (java.util.List) objArr[1];
        if (z) {
            map = new java.util.HashMap<>();
            map2 = new java.util.HashMap<>();
        } else {
            map = (java.util.Map) objArr[2];
            map2 = (java.util.Map) objArr[3];
        }
        if (bookDetailInfo.hasCustomTask()) {
            com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.book.model.CustomChapterInfo>> netHolderFetchCustomChapter = fetchCustomChapter(bookInfoStudy.getCourseId(), bookInfoStudy.getBookId());
            if (netHolderFetchCustomChapter.resp.isError()) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.BookChapterRefresh(netHolderFetchCustomChapter.resp, treeBookChapter));
                treeBookChapter.setHasLoadTreeChapterData(true);
                return;
            }
            treeBookChapter.setCustomChapterList(netHolderFetchCustomChapter.info);
        }
        treeBookChapter.setPlanAndTaskMap(map2, map);
        treeBookChapter.init(list);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.BookChapterRefresh(new com.up366.common.http.Response(i, "", str, 0, null), treeBookChapter));
        treeBookChapter.setHasLoadTreeChapterData(true);
    }

    static /* synthetic */ void lambda$fetchChapterPlanAndFinishedTask$19(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, int i, java.lang.String str) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.BookChapterRefresh(new com.up366.common.http.Response(i, "", str, 0, null), treeBookChapter));
        treeBookChapter.setHasLoadTreeChapterData(true);
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.book.model.TreeBookChapter> fetchChapterPlanAndFinishedTaskSync(final com.up366.mobile.book.model.TreeBookChapter treeBookChapter, final boolean z, @javax.annotation.Nonnull final com.up366.common.http.NetHolder<com.up366.mobile.book.model.BookDetailInfo> netHolder) throws java.lang.InterruptedException {
        java.lang.System.currentTimeMillis();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.http.NetHolder<com.up366.mobile.book.model.TreeBookChapter> netHolder2 = new com.up366.common.http.NetHolder<>();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchChapterPlanAndFinishedTaskSync$27(treeBookChapter, netHolder, z, netHolder2, countDownLatch);
            }
        });
        countDownLatch.await();
        return netHolder2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$27(final com.up366.mobile.book.model.TreeBookChapter treeBookChapter, final com.up366.common.http.NetHolder netHolder, final boolean z, final com.up366.common.http.NetHolder netHolder2, final java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        final com.up366.mobile.book.model.BookInfoStudy book = treeBookChapter.getBook();
        com.up366.mobile.common.utils.TaskChainTool taskChainToolQuery = new com.up366.mobile.common.utils.TaskChainTool().query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                this.f$0.lambda$fetchChapterPlanAndFinishedTaskSync$20(netHolder, book, iReturnOps);
            }
        }).query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                this.f$0.lambda$fetchChapterPlanAndFinishedTaskSync$21(treeBookChapter, iReturnOps);
            }
        });
        if (!z) {
            taskChainToolQuery.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda9
                @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
                public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                    this.f$0.lambda$fetchChapterPlanAndFinishedTaskSync$22(treeBookChapter, iReturnOps);
                }
            }).query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda10
                @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
                public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                    this.f$0.lambda$fetchChapterPlanAndFinishedTaskSync$23(treeBookChapter, iReturnOps);
                }
            });
        }
        taskChainToolQuery.doQueryParallel();
        taskChainToolQuery.onSuccess(new com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda12
            @Override // com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback
            public final void success(int i, java.lang.String str, java.lang.Object[] objArr) {
                this.f$0.lambda$fetchChapterPlanAndFinishedTaskSync$25(book, z, treeBookChapter, netHolder2, countDownLatch, i, str, objArr);
            }
        });
        taskChainToolQuery.onError(new com.up366.mobile.common.utils.TaskChainTool.IErrorCallback() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.utils.TaskChainTool.IErrorCallback
            public final void error(int i, java.lang.String str) {
                com.up366.mobile.book.BookMgr.lambda$fetchChapterPlanAndFinishedTaskSync$26(treeBookChapter, netHolder2, countDownLatch, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$20(com.up366.common.http.NetHolder netHolder, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        if (netHolder.resp == null) {
            java.lang.String bookId = bookInfoStudy.getBookId();
            int bookType = bookInfoStudy.getBookType();
            java.util.Objects.requireNonNull(iReturnOps);
            fetchBookDetail(bookId, bookType, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda29(iReturnOps));
            return;
        }
        iReturnOps.onResponse(netHolder.resp, netHolder.info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$21(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        java.util.Objects.requireNonNull(iReturnOps);
        fetchTreeChapters(treeBookChapter, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda11(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$22(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        java.util.Objects.requireNonNull(iReturnOps);
        fetchBookFinishedTask(treeBookChapter, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda27(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$23(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        java.util.Objects.requireNonNull(iReturnOps);
        fetchCourseBookPlan(treeBookChapter, new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda27(iReturnOps));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$25(final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, final boolean z, final com.up366.mobile.book.model.TreeBookChapter treeBookChapter, final com.up366.common.http.NetHolder netHolder, final java.util.concurrent.CountDownLatch countDownLatch, final int i, final java.lang.String str, final java.lang.Object[] objArr) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchChapterPlanAndFinishedTaskSync$24(objArr, bookInfoStudy, z, treeBookChapter, netHolder, countDownLatch, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$24(java.lang.Object[] objArr, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, boolean z, com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch, int i, java.lang.String str) throws java.lang.Exception {
        java.util.Map<java.lang.String, com.up366.mobile.book.model.BookTaskFinishedInfo> map;
        java.util.Map<java.lang.String, com.up366.mobile.book.model.CourseBookPlan> map2;
        com.up366.mobile.book.model.BookDetailInfo bookDetailInfo = (com.up366.mobile.book.model.BookDetailInfo) objArr[0];
        bookInfoStudy.initWithBookDetailInfo(bookDetailInfo);
        bookInfoStudy.initHasBuy();
        java.util.List<com.up366.mobile.book.model.ChapterInfo> list = (java.util.List) objArr[1];
        if (z) {
            map = new java.util.HashMap<>();
            map2 = new java.util.HashMap<>();
        } else {
            map = (java.util.Map) objArr[2];
            map2 = (java.util.Map) objArr[3];
        }
        if (bookDetailInfo.hasCustomTask()) {
            com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.book.model.CustomChapterInfo>> netHolderFetchCustomChapter = fetchCustomChapter(bookInfoStudy.getCourseId(), bookInfoStudy.getBookId());
            if (netHolderFetchCustomChapter.resp.isError()) {
                treeBookChapter.setHasLoadTreeChapterData(true);
                netHolder.initWith(netHolderFetchCustomChapter.resp, treeBookChapter);
                countDownLatch.countDown();
                return;
            }
            treeBookChapter.setCustomChapterList(netHolderFetchCustomChapter.info);
        }
        treeBookChapter.setPlanAndTaskMap(map2, map);
        treeBookChapter.init(list);
        com.up366.common.http.Response response = new com.up366.common.http.Response(i, "", str, 0, null);
        treeBookChapter.setHasLoadTreeChapterData(true);
        netHolder.initWith(response, treeBookChapter);
        countDownLatch.countDown();
    }

    static /* synthetic */ void lambda$fetchChapterPlanAndFinishedTaskSync$26(com.up366.mobile.book.model.TreeBookChapter treeBookChapter, com.up366.common.http.NetHolder netHolder, java.util.concurrent.CountDownLatch countDownLatch, int i, java.lang.String str) {
        com.up366.common.http.Response response = new com.up366.common.http.Response(i, "", str, 0, null);
        treeBookChapter.setHasLoadTreeChapterData(true);
        netHolder.initWith(response, treeBookChapter);
        countDownLatch.countDown();
    }

    public com.up366.common.http.NetHolder<java.util.List<java.lang.String>> fetchQuestionsResource(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) throws java.lang.InterruptedException {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final com.up366.common.http.NetHolder<java.util.List<java.lang.String>> netHolder = new com.up366.common.http.NetHolder<>();
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<java.lang.String>>(com.up366.mobile.common.http.HttpMgrUtils.listQuestionFile) { // from class: com.up366.mobile.book.BookMgr.12
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map map) {
                super.initParams(map);
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
                map.put("fileId", str2);
                map.put("chapterId", str3);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<java.lang.String> handleResponse(com.up366.common.http.Response response, java.lang.String str4) {
                com.up366.common.log.Logger.info("TAG - BookMgr - fetchQuestionsResource - handleResponse - resp = [" + response + "], result = [" + str4 + "]");
                java.lang.String[] dirQuestions = ((com.up366.mobile.book.model.QuestionInfo) com.alibaba.fastjson.JSON.parseObject(str4, com.up366.mobile.book.model.QuestionInfo.class)).getDirQuestions();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.String str5 : dirQuestions) {
                    arrayList.add(str5);
                }
                return arrayList;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<java.lang.String> list) {
                super.onResponse(response, list);
                netHolder.initWith(response, list);
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        return netHolder;
    }

    public com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.book.model.CustomChapterInfo>> fetchCustomChapter(final int i, final java.lang.String str) throws java.lang.InterruptedException {
        final com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.book.model.CustomChapterInfo>> netHolder = new com.up366.common.http.NetHolder<>();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.book.model.CustomChapterInfo>>(com.up366.mobile.common.http.HttpMgrUtils.getCustomChapters) { // from class: com.up366.mobile.book.BookMgr.13
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map map) {
                super.initParams(map);
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(i));
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.book.model.CustomChapterInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                com.alibaba.fastjson.JSONObject object = com.up366.mobile.common.utils.ResponseUtil.parseObject(str2);
                java.util.List array = com.up366.mobile.common.utils.ResponseUtil.parseArray(object.getString(com.up366.mobile.book.helper.V9ResourceHelper.DIR_CHAPTERS), com.up366.mobile.book.model.CustomChapterInfo.class);
                java.util.List array2 = com.up366.mobile.common.utils.ResponseUtil.parseArray(object.getString("tasks"), com.up366.mobile.book.model.CustomChapterInfo.class);
                java.util.List array3 = com.up366.mobile.common.utils.ResponseUtil.parseArray(object.getString("pages"), com.up366.mobile.book.model.CustomChapterInfo.class);
                java.util.Iterator it = array.iterator();
                while (it.hasNext()) {
                    ((com.up366.mobile.book.model.CustomChapterInfo) it.next()).setType(1);
                }
                java.util.Iterator it2 = array3.iterator();
                while (it2.hasNext()) {
                    ((com.up366.mobile.book.model.CustomChapterInfo) it2.next()).setType(2);
                }
                java.util.Iterator it3 = array2.iterator();
                while (it3.hasNext()) {
                    ((com.up366.mobile.book.model.CustomChapterInfo) it3.next()).setType(3);
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.addAll(array);
                arrayList.addAll(array3);
                arrayList.addAll(array2);
                com.up366.mobile.book.BookMgr.this.manager.cache().put("custom-tasks-" + i + "-" + str, arrayList, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_6);
                return arrayList;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.book.model.CustomChapterInfo> list) {
                super.onResponse(response, list);
                netHolder.initWith(response, list);
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        return netHolder;
    }

    public java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.ProductInfo> getProductMap() {
        return new java.util.HashMap(this.productMap);
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> fetchSimpleTreeByTaskId(final java.lang.String str, final java.lang.String str2, final int i) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<com.up366.mobile.book.helper.Tools.SimpleTreeInfo> netHolder = new com.up366.common.http.NetHolder<>();
        java.lang.String str3 = (java.lang.String) this.manager.cache().loadMemorySync(KEY_TREE_TASKID_MEMORY + str2);
        if (str3 != null) {
            netHolder.initWith(new com.up366.common.http.Response(0, "", "", 0, null), parseToSimpleTreeInfo(str, str3));
            return netHolder;
        }
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.bookTreeSingleTask).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda14
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.book.BookMgr.lambda$fetchSimpleTreeByTaskId$28(str, str2, i, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda15
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str4) {
                return this.f$0.lambda$fetchSimpleTreeByTaskId$29(str, str2, response, str4);
            }
        }));
    }

    static /* synthetic */ void lambda$fetchSimpleTreeByTaskId$28(java.lang.String str, java.lang.String str2, int i, java.util.Map map) {
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, str2);
        map.put("type", java.lang.Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.up366.mobile.book.helper.Tools.SimpleTreeInfo lambda$fetchSimpleTreeByTaskId$29(java.lang.String str, java.lang.String str2, com.up366.common.http.Response response, java.lang.String str3) {
        com.up366.mobile.book.helper.Tools.SimpleTreeInfo toSimpleTreeInfo = parseToSimpleTreeInfo(str, str3);
        tempCacheSimpleTreeByTaskId(str2, str3);
        return toSimpleTreeInfo;
    }

    public void tempCacheSimpleTreeByTaskId(java.lang.String str, java.lang.String str2) {
        this.manager.cache().put(KEY_TREE_TASKID + str, str2);
        this.manager.cache().putMemorySync(KEY_TREE_TASKID_MEMORY + str, str2, com.igexin.push.config.c.s);
    }

    public com.up366.mobile.book.helper.Tools.SimpleTreeInfo parseToSimpleTreeInfo(java.lang.String str, java.lang.String str2) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str2);
        com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray(com.up366.mobile.book.helper.V9ResourceHelper.DIR_CHAPTERS);
        if (jSONArray == null) {
            jSONArray = new com.alibaba.fastjson.JSONArray();
        }
        com.alibaba.fastjson.JSONArray jSONArray2 = object.getJSONArray("tasks");
        if (jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.size(); i++) {
                jSONArray2.getJSONObject(i).put("type", 3);
            }
            jSONArray.addAll(jSONArray2);
        }
        java.util.HashMap map = new java.util.HashMap();
        java.lang.String str3 = "";
        java.lang.String str4 = null;
        java.lang.String str5 = "";
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            com.alibaba.fastjson.JSONObject jSONObject = jSONArray.getJSONObject(i2);
            java.lang.String string = jSONObject.getString(com.igexin.push.core.b.C);
            map.put(string, jSONObject);
            if (jSONObject.getIntValue("type") == 3) {
                str4 = string;
            }
            if (jSONObject.getBooleanValue("isContent")) {
                java.lang.String string2 = jSONObject.getString("fileId");
                if (!android.text.TextUtils.isEmpty(string2)) {
                    str5 = string2;
                }
            }
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) map.get(str4);
        while (true) {
            if (jSONObject2 == null) {
                break;
            }
            java.lang.String openTypeFromExtParams = getOpenTypeFromExtParams(jSONObject2.getString("extendParams"));
            if (!android.text.TextUtils.isEmpty(openTypeFromExtParams)) {
                str3 = openTypeFromExtParams;
                break;
            }
            java.lang.String string3 = jSONObject2.getString("parentId");
            if (android.text.TextUtils.isEmpty(string3)) {
                break;
            }
            jSONObject2 = (com.alibaba.fastjson.JSONObject) map.get(string3);
        }
        return new com.up366.mobile.book.helper.Tools.SimpleTreeInfo(str, str2, str5, str3);
    }

    private java.lang.String getOpenTypeFromExtParams(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
            if (object != null && object.containsKey("extend4")) {
                return com.alibaba.fastjson.JSON.parseObject(object.getString("extend4")).getString("openType");
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public com.up366.mobile.book.helper.Tools.SimpleTreeInfo loadSimpleTreeInfo(com.up366.mobile.book.helper.Tools.PendingInfo pendingInfo) {
        if (pendingInfo == null) {
            return null;
        }
        java.lang.String str = pendingInfo.taskId;
        java.lang.String str2 = (java.lang.String) this.manager.cache().loadSync(KEY_TREE_TASKID + str, java.lang.String.class);
        if (str2 == null) {
            return null;
        }
        return parseToSimpleTreeInfo(pendingInfo.bookId, str2);
    }

    public com.up366.mobile.book.helper.Tools.SimpleTreeInfo loadSimpleTreeInfo(java.lang.String str, java.lang.String str2) {
        if (str2 == null || str == null) {
            return null;
        }
        java.lang.String str3 = (java.lang.String) this.manager.cache().loadSync(KEY_TREE_TASKID + str2, java.lang.String.class);
        if (str3 == null) {
            return null;
        }
        return parseToSimpleTreeInfo(str, str3);
    }

    public boolean isZeroPrice(int i, java.lang.String str) {
        com.up366.mobile.common.logic.model.ProductInfo productInfo = getProductInfo(str);
        if (productInfo != null) {
            return productInfo.getGoodsPrice() == 0.0f;
        }
        com.up366.mobile.course.mgr.CourseInfo courseInfo = this.manager.course().getCourseInfo(i);
        if (courseInfo != null && courseInfo.getBooks() != null) {
            for (com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo : courseInfo.getBooks()) {
                if (courseBookInfo.getBookId().equals(str)) {
                    return courseBookInfo.getGoodsPrice() == 0.0f;
                }
            }
        }
        return true;
    }

    public int loadTempCacheCanUse(java.lang.String str) {
        java.lang.Boolean bool = (java.lang.Boolean) this.manager.cache().loadSync("book-can-use-" + str, java.lang.Boolean.class);
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : -1;
    }

    public void tempCacheCanUse(java.lang.String str, boolean z) {
        this.manager.cache().putMemorySync("book-can-use-" + str, java.lang.Boolean.valueOf(z), com.igexin.push.config.c.s);
    }
}
