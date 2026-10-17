package io.objectbox.relation;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface ListFactory extends java.io.Serializable {
    <T> java.util.List<T> createList();

    public static class ArrayListFactory implements io.objectbox.relation.ListFactory {
        private static final long serialVersionUID = 8247662514375611729L;

        @Override // io.objectbox.relation.ListFactory
        public <T> java.util.List<T> createList() {
            return new java.util.ArrayList();
        }
    }

    public static class CopyOnWriteArrayListFactory implements io.objectbox.relation.ListFactory {
        private static final long serialVersionUID = 1888039726372206411L;

        @Override // io.objectbox.relation.ListFactory
        public <T> java.util.List<T> createList() {
            return new java.util.concurrent.CopyOnWriteArrayList();
        }
    }
}
