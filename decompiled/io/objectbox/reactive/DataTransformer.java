package io.objectbox.reactive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface DataTransformer<FROM, TO> {
    TO transform(FROM from) throws java.lang.Exception;
}
