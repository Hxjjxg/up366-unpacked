package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MyObjectBox {
    public static io.objectbox.BoxStoreBuilder builder() {
        io.objectbox.BoxStoreBuilder boxStoreBuilder = new io.objectbox.BoxStoreBuilder(getModel());
        boxStoreBuilder.entity(com.up366.mobile.common.logic.model.AppCacheInfo_.__INSTANCE);
        boxStoreBuilder.entity(com.up366.mobile.book.model.BookResourceMapInfo_.__INSTANCE);
        boxStoreBuilder.entity(com.up366.mobile.common.utils.alifile.FileCacheInfo_.__INSTANCE);
        boxStoreBuilder.entity(com.up366.mobile.book.helper.recorder.RecordResultHistory_.__INSTANCE);
        boxStoreBuilder.entity(com.up366.mobile.book.model.StudyTaskJsonMapInfo_.__INSTANCE);
        return boxStoreBuilder;
    }

    private static byte[] getModel() {
        io.objectbox.ModelBuilder modelBuilder = new io.objectbox.ModelBuilder();
        modelBuilder.lastEntityId(13, 5210586757304004159L);
        modelBuilder.lastIndexId(13, 8494728913232479855L);
        modelBuilder.lastRelationId(0, 0L);
        buildEntityAppCacheInfo(modelBuilder);
        buildEntityBookResourceMapInfo(modelBuilder);
        buildEntityFileCacheInfo(modelBuilder);
        buildEntityRecordResultHistory(modelBuilder);
        buildEntityStudyTaskJsonMapInfo(modelBuilder);
        return modelBuilder.build();
    }

    private static void buildEntityAppCacheInfo(io.objectbox.ModelBuilder modelBuilder) {
        io.objectbox.ModelBuilder.EntityBuilder entityBuilderEntity = modelBuilder.entity("AppCacheInfo");
        entityBuilderEntity.id(1, 1715521174564017177L).lastPropertyId(7, 6995512537726001917L);
        entityBuilderEntity.flags(1);
        entityBuilderEntity.property("rowId", 6).id(1, 6824838776685008414L).flags(1);
        entityBuilderEntity.property("key", 9).id(2, 3703485236650161963L).flags(34848).indexId(1, 3448080607750817887L);
        entityBuilderEntity.property("expireTime", 6).id(3, 2440635054531065920L);
        entityBuilderEntity.property("addTime", 6).id(4, 1941762139123158704L);
        entityBuilderEntity.property(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_UPDATE_TIME, 6).id(5, 6971284165759848045L);
        entityBuilderEntity.property("updateCount", 6).id(6, 6566622033993679990L);
        entityBuilderEntity.property("info", 9).id(7, 6995512537726001917L);
        entityBuilderEntity.entityDone();
    }

    private static void buildEntityBookResourceMapInfo(io.objectbox.ModelBuilder modelBuilder) {
        io.objectbox.ModelBuilder.EntityBuilder entityBuilderEntity = modelBuilder.entity("BookResourceMapInfo");
        entityBuilderEntity.id(11, 6219896701197836690L).lastPropertyId(7, 2671225363862533887L);
        entityBuilderEntity.flags(1);
        entityBuilderEntity.property("rowId", 6).id(1, 4980168169386837369L).flags(1);
        entityBuilderEntity.property(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, 9).id(2, 4965635119194914531L).flags(34848).indexId(11, 5447619106697524783L);
        entityBuilderEntity.property(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, 9).id(3, 8679811104336478551L);
        entityBuilderEntity.property("fileId", 9).id(4, 7238899967714752714L);
        entityBuilderEntity.property("key", 9).id(5, 8065822137173523055L);
        entityBuilderEntity.property("expireTime", 6).id(6, 7213751497226227075L);
        entityBuilderEntity.property("addTime", 6).id(7, 2671225363862533887L);
        entityBuilderEntity.entityDone();
    }

    private static void buildEntityFileCacheInfo(io.objectbox.ModelBuilder modelBuilder) {
        io.objectbox.ModelBuilder.EntityBuilder entityBuilderEntity = modelBuilder.entity("FileCacheInfo");
        entityBuilderEntity.id(10, 338484485965915163L).lastPropertyId(5, 5002308571256345867L);
        entityBuilderEntity.flags(1);
        entityBuilderEntity.property("rowId", 6).id(1, 1306392127744436486L).flags(1);
        entityBuilderEntity.property("key", 9).id(2, 4356667461883448749L).flags(34848).indexId(10, 6085589336940580910L);
        entityBuilderEntity.property("expireTime", 6).id(3, 3231484065996951569L);
        entityBuilderEntity.property("addTime", 6).id(4, 7471909748150553754L);
        entityBuilderEntity.property(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, 9).id(5, 5002308571256345867L);
        entityBuilderEntity.entityDone();
    }

    private static void buildEntityRecordResultHistory(io.objectbox.ModelBuilder modelBuilder) {
        io.objectbox.ModelBuilder.EntityBuilder entityBuilderEntity = modelBuilder.entity("RecordResultHistory");
        entityBuilderEntity.id(9, 1845287881253169586L).lastPropertyId(3, 3465865555350921871L);
        entityBuilderEntity.flags(1);
        entityBuilderEntity.property("rowId", 6).id(1, 7681090056716718602L).flags(1);
        entityBuilderEntity.property("objectId", 9).id(2, 1757710175087911013L).flags(34848).indexId(9, 1049939053612529272L);
        entityBuilderEntity.property("buffer", 23).id(3, 3465865555350921871L);
        entityBuilderEntity.entityDone();
    }

    private static void buildEntityStudyTaskJsonMapInfo(io.objectbox.ModelBuilder modelBuilder) {
        io.objectbox.ModelBuilder.EntityBuilder entityBuilderEntity = modelBuilder.entity("StudyTaskJsonMapInfo");
        entityBuilderEntity.id(12, 8018074238227340066L).lastPropertyId(5, 5134960940976578271L);
        entityBuilderEntity.flags(1);
        entityBuilderEntity.property("rowId", 6).id(1, 4728092235392720235L).flags(1);
        entityBuilderEntity.property("jobId", 9).id(2, 7645519421766965458L).flags(34848).indexId(12, 309320302540178087L);
        entityBuilderEntity.property(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON, 9).id(3, 2501712983178023048L);
        entityBuilderEntity.property("expireTime", 6).id(4, 718555527990930292L);
        entityBuilderEntity.property("addTime", 6).id(5, 5134960940976578271L);
        entityBuilderEntity.entityDone();
    }
}
