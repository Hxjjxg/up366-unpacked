package com.igexin.push.d.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class c extends com.igexin.c.a.b.d {
    public static final java.lang.String a = "com.igexin.push.d.a.c";
    public static int b = -1;
    private byte[] g;

    private c(java.lang.String str) {
        super(str, (byte) 0);
    }

    private static byte a(com.igexin.c.a.b.a.a.h hVar) throws java.io.IOException {
        return (byte) b(hVar, 1);
    }

    public static com.igexin.c.a.b.d a() {
        com.igexin.push.d.a.c cVar = new com.igexin.push.d.a.c("socketProtocol");
        new com.igexin.push.d.a.a("command", cVar);
        return cVar;
    }

    private static com.igexin.push.d.c.e a(com.igexin.push.d.c.a aVar) {
        com.igexin.push.d.c.e eVar = new com.igexin.push.d.c.e();
        eVar.b = com.igexin.push.d.c.e.a;
        eVar.a(aVar.c);
        eVar.f = aVar.b > 0 ? 1 : 0;
        eVar.d = 7;
        eVar.c = 11;
        eVar.g = aVar.d;
        eVar.c += com.igexin.push.g.g.c().length;
        if (aVar.a <= 0) {
            if (eVar.i == 0) {
                eVar.p = 0;
            }
            com.igexin.c.a.b.e.c();
            return eVar;
        }
        eVar.q = com.igexin.push.g.g.e();
        eVar.r = (int) (java.lang.System.currentTimeMillis() / 1000);
        eVar.o = com.igexin.push.g.g.a(aVar, eVar.q, eVar.r);
        eVar.p = eVar.o.length;
        eVar.c += eVar.p;
        com.igexin.c.a.b.e.c();
        return eVar;
    }

    private static java.lang.Object a(com.igexin.c.a.b.a.a.h hVar, com.igexin.push.d.c.e eVar) throws java.lang.Exception {
        if (eVar.i == 48) {
            com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x30, return");
            return null;
        }
        byte b2 = (byte) b(hVar, 1);
        if (b2 > 0) {
            a(hVar, b2);
        }
        eVar.g = (byte) b(hVar, 1);
        eVar.p = (byte) b(hVar, 1);
        if (eVar.p > 0) {
            eVar.o = a(hVar, eVar.p);
        }
        if (eVar.f == 0) {
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] bArrA = a(hVar, 11);
        int iC = com.igexin.c.a.b.g.c(bArrA, 0);
        if (iC <= b) {
            b = -1;
            throw new java.lang.Exception("server packetId can't be less than previous");
        }
        b = iC;
        int iC2 = com.igexin.c.a.b.g.c(bArrA, 4);
        short sA = com.igexin.c.a.b.g.a(bArrA, 8);
        int i = bArrA[10] & 255;
        com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
        aVar2.a = sA;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        aVar2.g = eVar.i;
        if (sA > 0) {
            byte[] bArrA2 = a(hVar, sA);
            if (eVar.i == 16) {
                bArrA2 = com.igexin.push.g.g.d(bArrA2, com.igexin.push.g.g.b(com.igexin.c.a.b.g.b(iC2)));
            } else if (eVar.i == 32) {
                if (i != 26) {
                    return null;
                }
                com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x20, special");
                bArrA2 = com.igexin.push.g.g.e(bArrA2, com.igexin.c.a.b.g.b(iC2));
            } else if (eVar.i != 0) {
                byte b3 = eVar.i;
                return null;
            }
            if (eVar.h == -128) {
                bArrA2 = com.igexin.c.a.b.g.b(bArrA2);
            } else if (eVar.h != 0) {
                return null;
            }
            aVar2.a(bArrA2);
            if (!java.util.Arrays.equals(eVar.o, com.igexin.push.g.g.a(aVar2, iC, iC2))) {
                java.lang.String str = a;
                com.igexin.c.a.c.a.a(str, "decode signature error!!!!");
                com.igexin.c.a.c.a.a(str + "|decode signature error!!!!", new java.lang.Object[0]);
                return null;
            }
        } else if (aVar2.a < 0) {
            java.lang.String str2 = a;
            com.igexin.c.a.c.a.a(str2, "data len < 0, error");
            com.igexin.c.a.c.a.a(str2 + "|data len < 0, error", new java.lang.Object[0]);
            return null;
        }
        return aVar2;
    }

    private static byte[] a(com.igexin.c.a.b.a.a.h hVar, int i) throws java.io.IOException {
        byte[] bArr = new byte[i];
        hVar.a(bArr);
        return bArr;
    }

    private static int b(com.igexin.c.a.b.a.a.h hVar, int i) throws java.io.IOException {
        byte[] bArrA = a(hVar, i);
        if (i == 1) {
            return bArrA[0] & 255;
        }
        if (i == 2) {
            return com.igexin.c.a.b.g.a(bArrA, 0);
        }
        if (i == 4) {
            return com.igexin.c.a.b.g.c(bArrA, 0);
        }
        return 0;
    }

    private java.lang.Object b(com.igexin.c.a.b.a.a.h hVar, com.igexin.push.d.c.e eVar) throws java.lang.Exception {
        byte b2;
        if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
            this.g = a(hVar, b2);
        }
        if (eVar.f == 0) {
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.f = eVar.d;
            aVar.b = (byte) 0;
            return aVar;
        }
        byte[] bArrA = a(hVar, 3);
        short sA = com.igexin.c.a.b.g.a(bArrA, 0);
        int i = bArrA[2] & 255;
        com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
        aVar2.a = sA;
        aVar2.b = (byte) i;
        aVar2.f = eVar.d;
        if (i != 26) {
            com.igexin.c.a.c.a.a(a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
            return null;
        }
        if (aVar2.a > 0) {
            byte[] bArrA2 = a(hVar, sA);
            if (eVar.i == 48) {
                byte[] bArr = this.g;
                bArrA2 = com.igexin.c.a.a.a.a(bArrA2, bArr == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr));
            }
            if (eVar.h == -128) {
                bArrA2 = com.igexin.c.a.b.g.b(bArrA2);
            } else if (eVar.h != 0) {
                return null;
            }
            aVar2.a(bArrA2);
        }
        return aVar2;
    }

    private static short b(com.igexin.c.a.b.a.a.h hVar) throws java.io.IOException {
        return (short) b(hVar, 2);
    }

    private static int c(com.igexin.c.a.b.a.a.h hVar) throws java.io.IOException {
        return b(hVar, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c0  */
    @Override // com.igexin.c.a.b.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r12) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.a.c.a(java.lang.Object):java.lang.Object");
    }

    @Override // com.igexin.c.a.b.d
    public final java.lang.Object b(java.lang.Object obj) throws java.lang.Exception {
        com.igexin.push.d.c.a aVar;
        byte b2;
        com.igexin.c.a.b.a.a.h hVar = obj instanceof com.igexin.c.a.b.a.a.h ? (com.igexin.c.a.b.a.a.h) obj : null;
        if (hVar == null) {
            java.lang.String str = a;
            com.igexin.c.a.c.a.a(str, "syncIns is null");
            com.igexin.c.a.c.a.a(str + "|syncIns is null", new java.lang.Object[0]);
            return null;
        }
        byte[] bArrA = a(hVar, 8);
        if (com.igexin.c.a.b.g.c(bArrA, 0) != 1944742139) {
            return null;
        }
        com.igexin.push.d.c.e eVar = new com.igexin.push.d.c.e();
        eVar.c = bArrA[4] & 255;
        eVar.d = bArrA[5] & 255;
        eVar.a(bArrA[6]);
        eVar.f = bArrA[7] & 255;
        if (eVar.d == 7) {
            if (eVar.i == 48) {
                com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x30, return");
                return null;
            }
            byte b3 = (byte) b(hVar, 1);
            if (b3 > 0) {
                a(hVar, b3);
            }
            eVar.g = (byte) b(hVar, 1);
            eVar.p = (byte) b(hVar, 1);
            if (eVar.p > 0) {
                eVar.o = a(hVar, eVar.p);
            }
            if (eVar.f != 0) {
                byte[] bArrA2 = a(hVar, 11);
                int iC = com.igexin.c.a.b.g.c(bArrA2, 0);
                if (iC <= b) {
                    b = -1;
                    throw new java.lang.Exception("server packetId can't be less than previous");
                }
                b = iC;
                int iC2 = com.igexin.c.a.b.g.c(bArrA2, 4);
                short sA = com.igexin.c.a.b.g.a(bArrA2, 8);
                int i = bArrA2[10] & 255;
                com.igexin.push.d.c.a aVar2 = new com.igexin.push.d.c.a();
                aVar2.a = sA;
                aVar2.b = (byte) i;
                aVar2.f = eVar.d;
                aVar2.g = eVar.i;
                if (sA > 0) {
                    byte[] bArrA3 = a(hVar, sA);
                    if (eVar.i == 16) {
                        bArrA3 = com.igexin.push.g.g.d(bArrA3, com.igexin.push.g.g.b(com.igexin.c.a.b.g.b(iC2)));
                    } else if (eVar.i == 32) {
                        if (i != 26) {
                            return null;
                        }
                        com.igexin.c.a.c.a.a(a, "decodeAes, encryptType = 0x20, special");
                        bArrA3 = com.igexin.push.g.g.e(bArrA3, com.igexin.c.a.b.g.b(iC2));
                    } else if (eVar.i != 0) {
                        byte b4 = eVar.i;
                        return null;
                    }
                    if (eVar.h == -128) {
                        bArrA3 = com.igexin.c.a.b.g.b(bArrA3);
                    } else if (eVar.h != 0) {
                        return null;
                    }
                    aVar2.a(bArrA3);
                    if (!java.util.Arrays.equals(eVar.o, com.igexin.push.g.g.a(aVar2, iC, iC2))) {
                        java.lang.String str2 = a;
                        com.igexin.c.a.c.a.a(str2, "decode signature error!!!!");
                        com.igexin.c.a.c.a.a(str2 + "|decode signature error!!!!", new java.lang.Object[0]);
                        return null;
                    }
                } else if (aVar2.a < 0) {
                    java.lang.String str3 = a;
                    com.igexin.c.a.c.a.a(str3, "data len < 0, error");
                    com.igexin.c.a.c.a.a(str3 + "|data len < 0, error", new java.lang.Object[0]);
                    return null;
                }
                return aVar2;
            }
            aVar = new com.igexin.push.d.c.a();
        } else {
            if (eVar.d != 1) {
                java.lang.String str4 = a;
                com.igexin.c.a.c.a.a(str4, "server socket resp version = " + eVar.d + ", not support!!!");
                com.igexin.c.a.c.a.a(str4 + "|server socket resp version = " + eVar.d + ", not support !!!", new java.lang.Object[0]);
                return null;
            }
            if (eVar.i == 48 && (b2 = (byte) b(hVar, 1)) > 0) {
                this.g = a(hVar, b2);
            }
            if (eVar.f != 0) {
                byte[] bArrA4 = a(hVar, 3);
                short sA2 = com.igexin.c.a.b.g.a(bArrA4, 0);
                int i2 = bArrA4[2] & 255;
                com.igexin.push.d.c.a aVar3 = new com.igexin.push.d.c.a();
                aVar3.a = sA2;
                aVar3.b = (byte) i2;
                aVar3.f = eVar.d;
                if (i2 != 26) {
                    com.igexin.c.a.c.a.a(a, "decodeRC4, cmd != MsgFormatedReceive.COMMAND, return");
                    return null;
                }
                if (aVar3.a > 0) {
                    byte[] bArrA5 = a(hVar, sA2);
                    if (eVar.i == 48) {
                        byte[] bArr = this.g;
                        bArrA5 = com.igexin.c.a.a.a.a(bArrA5, bArr == null ? com.igexin.c.a.b.e.a().f : com.igexin.c.b.a.a(bArr));
                    }
                    if (eVar.h == -128) {
                        bArrA5 = com.igexin.c.a.b.g.b(bArrA5);
                    } else if (eVar.h != 0) {
                        return null;
                    }
                    aVar3.a(bArrA5);
                }
                return aVar3;
            }
            aVar = new com.igexin.push.d.c.a();
        }
        aVar.f = eVar.d;
        aVar.b = (byte) 0;
        return aVar;
    }
}
