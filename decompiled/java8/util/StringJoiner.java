package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class StringJoiner {
    private final java.lang.String delimiter;
    private java.lang.String emptyValue;
    private final java.lang.String prefix;
    private final java.lang.String suffix;
    private java.lang.StringBuilder value;

    public StringJoiner(java.lang.CharSequence charSequence) {
        this(charSequence, "", "");
    }

    public StringJoiner(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        java8.util.Objects.requireNonNull(charSequence2, "The prefix must not be null");
        java8.util.Objects.requireNonNull(charSequence, "The delimiter must not be null");
        java8.util.Objects.requireNonNull(charSequence3, "The suffix must not be null");
        java.lang.String string = charSequence2.toString();
        this.prefix = string;
        this.delimiter = charSequence.toString();
        java.lang.String string2 = charSequence3.toString();
        this.suffix = string2;
        this.emptyValue = string + string2;
    }

    public java8.util.StringJoiner setEmptyValue(java.lang.CharSequence charSequence) {
        this.emptyValue = ((java.lang.CharSequence) java8.util.Objects.requireNonNull(charSequence, "The empty value must not be null")).toString();
        return this;
    }

    public java.lang.String toString() {
        if (this.value == null) {
            return this.emptyValue;
        }
        if (this.suffix.equals("")) {
            return this.value.toString();
        }
        int length = this.value.length();
        java.lang.StringBuilder sb = this.value;
        sb.append(this.suffix);
        java.lang.String string = sb.toString();
        this.value.setLength(length);
        return string;
    }

    public java8.util.StringJoiner add(java.lang.CharSequence charSequence) {
        prepareBuilder().append(charSequence);
        return this;
    }

    public java8.util.StringJoiner merge(java8.util.StringJoiner stringJoiner) {
        java8.util.Objects.requireNonNull(stringJoiner);
        java.lang.StringBuilder sb = stringJoiner.value;
        if (sb != null) {
            prepareBuilder().append((java.lang.CharSequence) stringJoiner.value, stringJoiner.prefix.length(), sb.length());
        }
        return this;
    }

    private java.lang.StringBuilder prepareBuilder() {
        java.lang.StringBuilder sb = this.value;
        if (sb != null) {
            sb.append(this.delimiter);
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(this.prefix);
            this.value = sb2;
        }
        return this.value;
    }

    public int length() {
        java.lang.StringBuilder sb = this.value;
        return sb != null ? sb.length() + this.suffix.length() : this.emptyValue.length();
    }
}
