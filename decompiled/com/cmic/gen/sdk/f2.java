package com.cmic.gen.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public interface f2 extends android.os.IInterface {

    public static abstract class a extends android.os.Binder implements com.cmic.gen.sdk.f2 {
        public static final /* synthetic */ int a = 0;

        /* JADX INFO: renamed from: com.cmic.gen.sdk.f2$a$a, reason: collision with other inner class name */
        public static class C0006a implements com.cmic.gen.sdk.f2 {
            public android.os.IBinder a;

            public C0006a(android.os.IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.cmic.gen.sdk.f2
            public void a(com.cmic.gen.sdk.e2 e2Var) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(e2Var != null ? (com.cmic.gen.sdk.e2.a) e2Var : null);
                    if (!this.a.transact(3, parcelObtain, parcelObtain2, 0)) {
                        int i = com.cmic.gen.sdk.f2.a.a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.a;
            }

            @Override // com.cmic.gen.sdk.f2
            public void b(com.cmic.gen.sdk.e2 e2Var) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(e2Var != null ? (com.cmic.gen.sdk.e2.a) e2Var : null);
                    if (!this.a.transact(2, parcelObtain, parcelObtain2, 0)) {
                        int i = com.cmic.gen.sdk.f2.a.a;
                    }
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    void a(com.cmic.gen.sdk.e2 e2Var);

    void b(com.cmic.gen.sdk.e2 e2Var);
}
