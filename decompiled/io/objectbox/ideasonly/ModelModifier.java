package io.objectbox.ideasonly;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ModelModifier {

    public class EntityModifier {
        final java.lang.String name;
        final java.lang.String schemaName;

        public void remove() {
        }

        public void renameTo(java.lang.String str) {
        }

        EntityModifier(java.lang.String str, java.lang.String str2) {
            this.schemaName = str;
            this.name = str2;
        }

        public io.objectbox.ideasonly.ModelModifier.PropertyModifier property(java.lang.String str) {
            return io.objectbox.ideasonly.ModelModifier.this.new PropertyModifier(this, str);
        }
    }

    public class PropertyModifier {
        final io.objectbox.ideasonly.ModelModifier.EntityModifier entityModifier;
        final java.lang.String name;

        public void remove() {
        }

        public void renameTo(java.lang.String str) {
        }

        PropertyModifier(io.objectbox.ideasonly.ModelModifier.EntityModifier entityModifier, java.lang.String str) {
            this.entityModifier = entityModifier;
            this.name = str;
        }
    }

    public io.objectbox.ideasonly.ModelModifier.EntityModifier entity(java.lang.String str) {
        return new io.objectbox.ideasonly.ModelModifier.EntityModifier("default", str);
    }
}
