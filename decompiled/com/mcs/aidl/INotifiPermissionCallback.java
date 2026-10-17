package com.mcs.aidl;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface INotifiPermissionCallback extends android.os.IInterface {

    public static class Default implements com.mcs.aidl.INotifiPermissionCallback {
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return null;
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onFail(int i, java.lang.String str) {
        }

        @Override // com.mcs.aidl.INotifiPermissionCallback
        public void onSuccess() {
        }
    }

    public static abstract class Stub extends android.os.Binder implements com.mcs.aidl.INotifiPermissionCallback {
        private static final java.lang.String DESCRIPTOR = "com.mcs.aidl.INotifiPermissionCallback";
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        private static class Proxy implements com.mcs.aidl.INotifiPermissionCallback {
            public static com.mcs.aidl.INotifiPermissionCallback sDefaultImpl;
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this.mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return com.mcs.aidl.INotifiPermissionCallback.Stub.DESCRIPTOR;
            }

            @Override // com.mcs.aidl.INotifiPermissionCallback
            public void onFail(int i, java.lang.String str) {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.mcs.aidl.INotifiPermissionCallback.Stub.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    if (this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) || com.mcs.aidl.INotifiPermissionCallback.Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        com.mcs.aidl.INotifiPermissionCallback.Stub.getDefaultImpl().onFail(i, str);
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.mcs.aidl.INotifiPermissionCallback
            public void onSuccess() {
                android.os.Parcel parcelObtain = android.os.Parcel.obtain();
                android.os.Parcel parcelObtain2 = android.os.Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(com.mcs.aidl.INotifiPermissionCallback.Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) || com.mcs.aidl.INotifiPermissionCallback.Stub.getDefaultImpl() == null) {
                        parcelObtain2.readException();
                    } else {
                        com.mcs.aidl.INotifiPermissionCallback.Stub.getDefaultImpl().onSuccess();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static com.mcs.aidl.INotifiPermissionCallback asInterface(android.os.IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            android.os.IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.mcs.aidl.INotifiPermissionCallback)) ? new com.mcs.aidl.INotifiPermissionCallback.Stub.Proxy(iBinder) : (com.mcs.aidl.INotifiPermissionCallback) iInterfaceQueryLocalInterface;
        }

        public static com.mcs.aidl.INotifiPermissionCallback getDefaultImpl() {
            return com.mcs.aidl.INotifiPermissionCallback.Stub.Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(com.mcs.aidl.INotifiPermissionCallback iNotifiPermissionCallback) {
            if (com.mcs.aidl.INotifiPermissionCallback.Stub.Proxy.sDefaultImpl != null || iNotifiPermissionCallback == null) {
                return false;
            }
            com.mcs.aidl.INotifiPermissionCallback.Stub.Proxy.sDefaultImpl = iNotifiPermissionCallback;
            return true;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess();
            } else {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                onFail(parcel.readInt(), parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onFail(int i, java.lang.String str);

    void onSuccess();
}
