package io.objectbox.relation;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RelationInfo<SOURCE, TARGET> implements java.io.Serializable {
    private static final long serialVersionUID = 7412962174183812632L;
    public final io.objectbox.internal.ToManyGetter<TARGET, SOURCE> backlinkToManyGetter;
    public final io.objectbox.internal.ToOneGetter<TARGET, SOURCE> backlinkToOneGetter;
    public final int relationId;
    public final io.objectbox.EntityInfo<SOURCE> sourceInfo;
    public final io.objectbox.Property<?> targetIdProperty;
    public final io.objectbox.EntityInfo<TARGET> targetInfo;
    public final int targetRelationId;
    public final io.objectbox.internal.ToManyGetter<SOURCE, TARGET> toManyGetter;
    public final io.objectbox.internal.ToOneGetter<SOURCE, TARGET> toOneGetter;

    /* JADX WARN: Multi-variable type inference failed */
    public RelationInfo(io.objectbox.EntityInfo<SOURCE> entityInfo, io.objectbox.EntityInfo<TARGET> entityInfo2, io.objectbox.Property<SOURCE> property, io.objectbox.internal.ToOneGetter<SOURCE, TARGET> toOneGetter) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.targetIdProperty = property;
        this.toOneGetter = toOneGetter;
        this.targetRelationId = 0;
        this.backlinkToOneGetter = null;
        this.backlinkToManyGetter = null;
        this.toManyGetter = null;
        this.relationId = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RelationInfo(io.objectbox.EntityInfo<SOURCE> entityInfo, io.objectbox.EntityInfo<TARGET> entityInfo2, io.objectbox.internal.ToManyGetter<SOURCE, TARGET> toManyGetter, io.objectbox.Property<TARGET> property, io.objectbox.internal.ToOneGetter<TARGET, SOURCE> toOneGetter) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.targetIdProperty = property;
        this.toManyGetter = toManyGetter;
        this.backlinkToOneGetter = toOneGetter;
        this.targetRelationId = 0;
        this.toOneGetter = null;
        this.backlinkToManyGetter = null;
        this.relationId = 0;
    }

    public RelationInfo(io.objectbox.EntityInfo<SOURCE> entityInfo, io.objectbox.EntityInfo<TARGET> entityInfo2, io.objectbox.internal.ToManyGetter<SOURCE, TARGET> toManyGetter, io.objectbox.internal.ToManyGetter<TARGET, SOURCE> toManyGetter2, int i) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.toManyGetter = toManyGetter;
        this.targetRelationId = i;
        this.backlinkToManyGetter = toManyGetter2;
        this.targetIdProperty = null;
        this.toOneGetter = null;
        this.backlinkToOneGetter = null;
        this.relationId = 0;
    }

    public RelationInfo(io.objectbox.EntityInfo<SOURCE> entityInfo, io.objectbox.EntityInfo<TARGET> entityInfo2, io.objectbox.internal.ToManyGetter<SOURCE, TARGET> toManyGetter, int i) {
        this.sourceInfo = entityInfo;
        this.targetInfo = entityInfo2;
        this.toManyGetter = toManyGetter;
        this.relationId = i;
        this.targetRelationId = 0;
        this.targetIdProperty = null;
        this.toOneGetter = null;
        this.backlinkToOneGetter = null;
        this.backlinkToManyGetter = null;
    }

    public boolean isBacklink() {
        return (this.backlinkToManyGetter == null && this.backlinkToOneGetter == null) ? false : true;
    }

    public java.lang.String toString() {
        return "RelationInfo from " + this.sourceInfo.getEntityClass() + " to " + this.targetInfo.getEntityClass();
    }

    public io.objectbox.query.QueryCondition<SOURCE> relationCount(int i) {
        if (this.targetIdProperty == null) {
            throw new java.lang.IllegalStateException("The relation count condition is only supported for 1:N (ToMany using @Backlink) relations.");
        }
        return new io.objectbox.query.RelationCountCondition(this, i);
    }
}
