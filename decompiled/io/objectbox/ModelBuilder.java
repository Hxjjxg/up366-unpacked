package io.objectbox;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ModelBuilder {
    private static final int MODEL_VERSION = 2;
    java.lang.Integer lastEntityId;
    java.lang.Long lastEntityUid;
    java.lang.Integer lastIndexId;
    java.lang.Long lastIndexUid;
    java.lang.Integer lastRelationId;
    java.lang.Long lastRelationUid;
    final io.objectbox.flatbuffers.FlatBufferBuilder fbb = new io.objectbox.flatbuffers.FlatBufferBuilder();
    final java.util.List<java.lang.Integer> entityOffsets = new java.util.ArrayList();
    long version = 1;

    public class PropertyBuilder {
        boolean finished;
        private int flags;
        private int id;
        private int indexId;
        private int indexMaxValueLength;
        private long indexUid;
        private final int propertyNameOffset;
        private int secondaryNameOffset;
        private final int targetEntityOffset;
        private final int type;
        private long uid;
        private final int virtualTargetOffset;

        PropertyBuilder(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, @javax.annotation.Nullable java.lang.String str3, int i) {
            this.type = i;
            this.propertyNameOffset = io.objectbox.ModelBuilder.this.fbb.createString(str);
            this.targetEntityOffset = str2 != null ? io.objectbox.ModelBuilder.this.fbb.createString(str2) : 0;
            this.virtualTargetOffset = str3 != null ? io.objectbox.ModelBuilder.this.fbb.createString(str3) : 0;
        }

        public io.objectbox.ModelBuilder.PropertyBuilder id(int i, long j) {
            checkNotFinished();
            this.id = i;
            this.uid = j;
            return this;
        }

        public io.objectbox.ModelBuilder.PropertyBuilder indexId(int i, long j) {
            checkNotFinished();
            this.indexId = i;
            this.indexUid = j;
            return this;
        }

        public io.objectbox.ModelBuilder.PropertyBuilder indexMaxValueLength(int i) {
            checkNotFinished();
            this.indexMaxValueLength = i;
            return this;
        }

        public io.objectbox.ModelBuilder.PropertyBuilder flags(int i) {
            checkNotFinished();
            this.flags = i;
            return this;
        }

        public io.objectbox.ModelBuilder.PropertyBuilder secondaryName(java.lang.String str) {
            checkNotFinished();
            this.secondaryNameOffset = io.objectbox.ModelBuilder.this.fbb.createString(str);
            return this;
        }

        private void checkNotFinished() {
            if (this.finished) {
                throw new java.lang.IllegalStateException("Already finished");
            }
        }

        public int finish() {
            checkNotFinished();
            this.finished = true;
            io.objectbox.model.ModelProperty.startModelProperty(io.objectbox.ModelBuilder.this.fbb);
            io.objectbox.model.ModelProperty.addName(io.objectbox.ModelBuilder.this.fbb, this.propertyNameOffset);
            if (this.targetEntityOffset != 0) {
                io.objectbox.model.ModelProperty.addTargetEntity(io.objectbox.ModelBuilder.this.fbb, this.targetEntityOffset);
            }
            if (this.virtualTargetOffset != 0) {
                io.objectbox.model.ModelProperty.addVirtualTarget(io.objectbox.ModelBuilder.this.fbb, this.virtualTargetOffset);
            }
            if (this.secondaryNameOffset != 0) {
                io.objectbox.model.ModelProperty.addNameSecondary(io.objectbox.ModelBuilder.this.fbb, this.secondaryNameOffset);
            }
            if (this.id != 0) {
                io.objectbox.model.ModelProperty.addId(io.objectbox.ModelBuilder.this.fbb, io.objectbox.model.IdUid.createIdUid(io.objectbox.ModelBuilder.this.fbb, this.id, this.uid));
            }
            if (this.indexId != 0) {
                io.objectbox.model.ModelProperty.addIndexId(io.objectbox.ModelBuilder.this.fbb, io.objectbox.model.IdUid.createIdUid(io.objectbox.ModelBuilder.this.fbb, this.indexId, this.indexUid));
            }
            if (this.indexMaxValueLength > 0) {
                io.objectbox.model.ModelProperty.addMaxIndexValueLength(io.objectbox.ModelBuilder.this.fbb, this.indexMaxValueLength);
            }
            io.objectbox.model.ModelProperty.addType(io.objectbox.ModelBuilder.this.fbb, this.type);
            if (this.flags != 0) {
                io.objectbox.model.ModelProperty.addFlags(io.objectbox.ModelBuilder.this.fbb, this.flags);
            }
            return io.objectbox.model.ModelProperty.endModelProperty(io.objectbox.ModelBuilder.this.fbb);
        }
    }

    public class EntityBuilder {
        boolean finished;
        java.lang.Integer flags;
        java.lang.Integer id;
        java.lang.Integer lastPropertyId;
        java.lang.Long lastPropertyUid;
        final java.lang.String name;
        io.objectbox.ModelBuilder.PropertyBuilder propertyBuilder;
        final java.util.List<java.lang.Integer> propertyOffsets = new java.util.ArrayList();
        final java.util.List<java.lang.Integer> relationOffsets = new java.util.ArrayList();
        java.lang.Long uid;

        EntityBuilder(java.lang.String str) {
            this.name = str;
        }

        public io.objectbox.ModelBuilder.EntityBuilder id(int i, long j) {
            checkNotFinished();
            this.id = java.lang.Integer.valueOf(i);
            this.uid = java.lang.Long.valueOf(j);
            return this;
        }

        public io.objectbox.ModelBuilder.EntityBuilder lastPropertyId(int i, long j) {
            checkNotFinished();
            this.lastPropertyId = java.lang.Integer.valueOf(i);
            this.lastPropertyUid = java.lang.Long.valueOf(j);
            return this;
        }

        public io.objectbox.ModelBuilder.EntityBuilder flags(int i) {
            this.flags = java.lang.Integer.valueOf(i);
            return this;
        }

        private void checkNotFinished() {
            if (this.finished) {
                throw new java.lang.IllegalStateException("Already finished");
            }
        }

        public io.objectbox.ModelBuilder.PropertyBuilder property(java.lang.String str, int i) {
            return property(str, null, i);
        }

        public io.objectbox.ModelBuilder.PropertyBuilder property(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, int i) {
            return property(str, str2, null, i);
        }

        public io.objectbox.ModelBuilder.PropertyBuilder property(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, @javax.annotation.Nullable java.lang.String str3, int i) {
            checkNotFinished();
            checkFinishProperty();
            io.objectbox.ModelBuilder.PropertyBuilder propertyBuilder = io.objectbox.ModelBuilder.this.new PropertyBuilder(str, str2, str3, i);
            this.propertyBuilder = propertyBuilder;
            return propertyBuilder;
        }

        void checkFinishProperty() {
            io.objectbox.ModelBuilder.PropertyBuilder propertyBuilder = this.propertyBuilder;
            if (propertyBuilder != null) {
                this.propertyOffsets.add(java.lang.Integer.valueOf(propertyBuilder.finish()));
                this.propertyBuilder = null;
            }
        }

        public io.objectbox.ModelBuilder.EntityBuilder relation(java.lang.String str, int i, long j, int i2, long j2) {
            checkNotFinished();
            checkFinishProperty();
            int iCreateString = io.objectbox.ModelBuilder.this.fbb.createString(str);
            io.objectbox.model.ModelRelation.startModelRelation(io.objectbox.ModelBuilder.this.fbb);
            io.objectbox.model.ModelRelation.addName(io.objectbox.ModelBuilder.this.fbb, iCreateString);
            io.objectbox.model.ModelRelation.addId(io.objectbox.ModelBuilder.this.fbb, io.objectbox.model.IdUid.createIdUid(io.objectbox.ModelBuilder.this.fbb, i, j));
            io.objectbox.model.ModelRelation.addTargetEntityId(io.objectbox.ModelBuilder.this.fbb, io.objectbox.model.IdUid.createIdUid(io.objectbox.ModelBuilder.this.fbb, i2, j2));
            this.relationOffsets.add(java.lang.Integer.valueOf(io.objectbox.model.ModelRelation.endModelRelation(io.objectbox.ModelBuilder.this.fbb)));
            return this;
        }

        public io.objectbox.ModelBuilder entityDone() {
            checkNotFinished();
            checkFinishProperty();
            this.finished = true;
            int iCreateString = io.objectbox.ModelBuilder.this.fbb.createString(this.name);
            int iCreateVector = io.objectbox.ModelBuilder.this.createVector(this.propertyOffsets);
            int iCreateVector2 = this.relationOffsets.isEmpty() ? 0 : io.objectbox.ModelBuilder.this.createVector(this.relationOffsets);
            io.objectbox.model.ModelEntity.startModelEntity(io.objectbox.ModelBuilder.this.fbb);
            io.objectbox.model.ModelEntity.addName(io.objectbox.ModelBuilder.this.fbb, iCreateString);
            io.objectbox.model.ModelEntity.addProperties(io.objectbox.ModelBuilder.this.fbb, iCreateVector);
            if (iCreateVector2 != 0) {
                io.objectbox.model.ModelEntity.addRelations(io.objectbox.ModelBuilder.this.fbb, iCreateVector2);
            }
            if (this.id != null && this.uid != null) {
                io.objectbox.model.ModelEntity.addId(io.objectbox.ModelBuilder.this.fbb, io.objectbox.model.IdUid.createIdUid(io.objectbox.ModelBuilder.this.fbb, this.id.intValue(), this.uid.longValue()));
            }
            if (this.lastPropertyId != null) {
                io.objectbox.model.ModelEntity.addLastPropertyId(io.objectbox.ModelBuilder.this.fbb, io.objectbox.model.IdUid.createIdUid(io.objectbox.ModelBuilder.this.fbb, this.lastPropertyId.intValue(), this.lastPropertyUid.longValue()));
            }
            if (this.flags != null) {
                io.objectbox.model.ModelEntity.addFlags(io.objectbox.ModelBuilder.this.fbb, this.flags.intValue());
            }
            io.objectbox.ModelBuilder.this.entityOffsets.add(java.lang.Integer.valueOf(io.objectbox.model.ModelEntity.endModelEntity(io.objectbox.ModelBuilder.this.fbb)));
            return io.objectbox.ModelBuilder.this;
        }
    }

    int createVector(java.util.List<java.lang.Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return this.fbb.createVectorOfTables(iArr);
    }

    public io.objectbox.ModelBuilder version(long j) {
        this.version = j;
        return this;
    }

    public io.objectbox.ModelBuilder.EntityBuilder entity(java.lang.String str) {
        return new io.objectbox.ModelBuilder.EntityBuilder(str);
    }

    public io.objectbox.ModelBuilder lastEntityId(int i, long j) {
        this.lastEntityId = java.lang.Integer.valueOf(i);
        this.lastEntityUid = java.lang.Long.valueOf(j);
        return this;
    }

    public io.objectbox.ModelBuilder lastIndexId(int i, long j) {
        this.lastIndexId = java.lang.Integer.valueOf(i);
        this.lastIndexUid = java.lang.Long.valueOf(j);
        return this;
    }

    public io.objectbox.ModelBuilder lastRelationId(int i, long j) {
        this.lastRelationId = java.lang.Integer.valueOf(i);
        this.lastRelationUid = java.lang.Long.valueOf(j);
        return this;
    }

    public byte[] build() {
        int iCreateString = this.fbb.createString("default");
        int iCreateVector = createVector(this.entityOffsets);
        io.objectbox.model.Model.startModel(this.fbb);
        io.objectbox.model.Model.addName(this.fbb, iCreateString);
        io.objectbox.model.Model.addModelVersion(this.fbb, 2L);
        io.objectbox.model.Model.addVersion(this.fbb, 1L);
        io.objectbox.model.Model.addEntities(this.fbb, iCreateVector);
        if (this.lastEntityId != null) {
            io.objectbox.model.Model.addLastEntityId(this.fbb, io.objectbox.model.IdUid.createIdUid(this.fbb, r0.intValue(), this.lastEntityUid.longValue()));
        }
        if (this.lastIndexId != null) {
            io.objectbox.model.Model.addLastIndexId(this.fbb, io.objectbox.model.IdUid.createIdUid(this.fbb, r0.intValue(), this.lastIndexUid.longValue()));
        }
        if (this.lastRelationId != null) {
            io.objectbox.model.Model.addLastRelationId(this.fbb, io.objectbox.model.IdUid.createIdUid(this.fbb, r0.intValue(), this.lastRelationUid.longValue()));
        }
        this.fbb.finish(io.objectbox.model.Model.endModel(this.fbb));
        return this.fbb.sizedByteArray();
    }
}
