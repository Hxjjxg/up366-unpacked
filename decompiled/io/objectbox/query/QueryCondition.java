package io.objectbox.query;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface QueryCondition<T> {
    io.objectbox.query.QueryCondition<T> and(io.objectbox.query.QueryCondition<T> queryCondition);

    io.objectbox.query.QueryCondition<T> or(io.objectbox.query.QueryCondition<T> queryCondition);
}
