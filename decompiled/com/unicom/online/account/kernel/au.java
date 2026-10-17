package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class au {
    public static int b = 1;
    public static int c;

    public static java.lang.String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "no info" : com.unicom.online.account.kernel.as.i.toString() : com.unicom.online.account.kernel.as.h.toString() : com.unicom.online.account.kernel.as.f.toString() : com.unicom.online.account.kernel.as.g.toString();
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(new java.lang.String(com.unicom.online.account.kernel.aq.b("U0hBMjU2")));
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("");
            for (int i = 0; i < bArrDigest.length; i++) {
                int i2 = bArrDigest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(java.lang.Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            com.unicom.online.account.kernel.as.b(e);
            return "";
        }
    }

    public static java.lang.String b(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(new java.lang.String(com.unicom.online.account.kernel.aq.b("TUQ1")));
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("");
            for (int i = 0; i < bArrDigest.length; i++) {
                int i2 = bArrDigest[i];
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(java.lang.Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            com.unicom.online.account.kernel.as.b(e);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(android.content.Context r9) {
        /*
            android.content.Context r0 = r9.getApplicationContext()     // Catch: java.lang.Exception -> La0
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> La0
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Exception -> La0
            android.net.NetworkInfo r1 = r0.getActiveNetworkInfo()     // Catch: java.lang.Exception -> La0
            if (r1 == 0) goto La4
            boolean r2 = r1.isAvailable()     // Catch: java.lang.Exception -> La0
            if (r2 != 0) goto L1a
            goto La4
        L1a:
            int r2 = r1.getType()     // Catch: java.lang.Exception -> La0
            r3 = 0
            r4 = 1
            if (r2 != r4) goto L6f
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> La0
            java.lang.String r2 = "phone"
            r5 = 26
            if (r1 <= r5) goto L39
            java.lang.Object r6 = r9.getSystemService(r2)     // Catch: java.lang.Exception -> La0
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch: java.lang.Exception -> La0
            int r6 = r6.getSimState()     // Catch: java.lang.Exception -> La0
            if (r4 == r6) goto L6d
            if (r6 != 0) goto L39
            goto L6d
        L39:
            java.lang.Class<android.net.ConnectivityManager> r6 = android.net.ConnectivityManager.class
            java.lang.String r7 = "getMobileDataEnabled"
            r8 = 0
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r7, r8)     // Catch: java.lang.Exception -> L64
            r6.setAccessible(r4)     // Catch: java.lang.Exception -> L64
            java.lang.Object r0 = r6.invoke(r0, r8)     // Catch: java.lang.Exception -> L64
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L64
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L64
            if (r0 == 0) goto L62
            if (r1 <= r5) goto L68
            java.lang.Object r9 = r9.getSystemService(r2)     // Catch: java.lang.Exception -> L64
            android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9     // Catch: java.lang.Exception -> L64
            int r9 = r9.getSimState()     // Catch: java.lang.Exception -> L64
            if (r4 == r9) goto L69
            if (r9 != 0) goto L68
            goto L69
        L62:
            r3 = r0
            goto L69
        L64:
            r9 = move-exception
            com.unicom.online.account.kernel.as.b(r9)     // Catch: java.lang.Exception -> La0
        L68:
            r3 = r4
        L69:
            if (r3 == 0) goto L6d
            r3 = r4
            goto La5
        L6d:
            r3 = 2
            goto La5
        L6f:
            int r9 = r1.getType()     // Catch: java.lang.Exception -> La0
            if (r9 != 0) goto La4
            java.lang.String r9 = "Only Data"
            com.unicom.online.account.kernel.as.b(r9)     // Catch: java.lang.Exception -> La0
            java.lang.String r9 = r1.getExtraInfo()     // Catch: java.lang.Exception -> La0
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Exception -> La0
            if (r0 != 0) goto La5
            java.lang.String r0 = com.unicom.online.account.kernel.ao.b     // Catch: java.lang.Exception -> La0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La0
            java.lang.String r1 = "APN:"
            r0.<init>(r1)     // Catch: java.lang.Exception -> La0
            r0.append(r9)     // Catch: java.lang.Exception -> La0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> La0
            com.unicom.online.account.kernel.as.b(r0)     // Catch: java.lang.Exception -> La0
            com.unicom.online.account.kernel.ao.t = r9     // Catch: java.lang.Exception -> La0
            java.lang.String r9 = com.unicom.online.account.kernel.ao.b(r9)     // Catch: java.lang.Exception -> La0
            com.unicom.online.account.kernel.ao.r = r9     // Catch: java.lang.Exception -> La0
            goto La5
        La0:
            r9 = move-exception
            com.unicom.online.account.kernel.as.b(r9)
        La4:
            r3 = -1
        La5:
            com.unicom.online.account.kernel.ao.q = r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unicom.online.account.kernel.au.c(android.content.Context):int");
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.pm.PackageInfo packageInfo;
        try {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (java.lang.Exception e) {
                com.unicom.online.account.kernel.as.b(e);
            }
            byte[] byteArray = packageInfo.packageName.equals(str) ? packageInfo.signatures[0].toByteArray() : null;
            try {
                return b(java.security.MessageDigest.getInstance(str2.toLowerCase()).digest(byteArray));
            } catch (java.lang.Exception e2) {
                com.unicom.online.account.kernel.as.b(e2);
                return "";
            }
        } catch (java.lang.Exception e3) {
            com.unicom.online.account.kernel.as.b(e3);
            return "";
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        try {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (java.lang.Exception e) {
                com.unicom.online.account.kernel.as.b(e);
            }
            byte[] byteArray = packageInfo.packageName.equals(str) ? packageInfo.signatures[0].toByteArray() : null;
            try {
                org.bouncycastle.crypto.digests.SM3Digest sM3Digest = new org.bouncycastle.crypto.digests.SM3Digest();
                sM3Digest.update(byteArray, 0, byteArray.length);
                byte[] bArr = new byte[sM3Digest.getDigestSize()];
                sM3Digest.doFinal(bArr, 0);
                return b(bArr);
            } catch (java.lang.Exception e2) {
                com.unicom.online.account.kernel.as.b(e2);
                return "";
            }
        } catch (java.lang.Exception e3) {
            com.unicom.online.account.kernel.as.b(e3);
            return "";
        }
    }

    public static java.lang.String b(byte[] bArr) {
        java.lang.String str = "";
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                str = str + ":";
            }
            java.lang.String hexString = java.lang.Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }

    public static java.util.ArrayList c() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.util.Enumeration<java.net.NetworkInterface> networkInterfaces = java.net.NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                while (networkInterfaces.hasMoreElements()) {
                    java.net.NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    java.lang.String lowerCase = networkInterfaceNextElement.getName().toLowerCase();
                    if (lowerCase.startsWith("rmnet") || lowerCase.startsWith("ccmni")) {
                        java.util.Enumeration<java.net.InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                        if (inetAddresses != null) {
                            while (inetAddresses.hasMoreElements()) {
                                java.net.InetAddress inetAddressNextElement = inetAddresses.nextElement();
                                if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress() && !inetAddressNextElement.isMulticastAddress() && !inetAddressNextElement.isAnyLocalAddress() && ((inetAddressNextElement instanceof java.net.Inet4Address) || (inetAddressNextElement instanceof java.net.Inet6Address))) {
                                    arrayList.add(inetAddressNextElement.getHostAddress());
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.net.SocketException e) {
            com.unicom.online.account.kernel.as.b(e);
        }
        return arrayList;
    }

    public static void b(android.content.Context context) {
        try {
        } catch (java.lang.Exception unused) {
        }
    }

    public static java.lang.String b() {
        try {
            return b(c());
        } catch (org.json.JSONException unused) {
            return "{\"privateIp\":\"0.0.0.0\"}";
        }
    }

    public static java.lang.String b(java.util.ArrayList arrayList) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        if (arrayList.size() == 0) {
            return "{\"privateIp\":\"0.0.0.0\"}";
        }
        for (int i = 0; i < arrayList.size(); i++) {
            java.lang.String str = (java.lang.String) arrayList.get(i);
            java.lang.String strSubstring = str.substring(0, 3);
            try {
                byte[] address = java.net.InetAddress.getByName(str).getAddress();
                if (str.length() != 0) {
                    if (address.length == 4) {
                        if (!strSubstring.equals("127") && !strSubstring.equals("192")) {
                            stringBuffer.append(str).append("-");
                        }
                    } else if (!str.contains("%") && !"::1".equals(str)) {
                        stringBuffer2.append(str).append("-");
                    }
                }
            } catch (java.net.UnknownHostException e) {
                com.unicom.online.account.kernel.as.b(e);
                return "{\"privateIp\":\"0.0.0.0\"}";
            }
        }
        if (stringBuffer.length() != 0 && '-' == stringBuffer.charAt(stringBuffer.length() - 1)) {
            java.lang.StringBuffer stringBufferDeleteCharAt = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            int iMin = java.lang.Math.min(stringBuffer.length(), 5);
            for (int i2 = 0; i2 < iMin; i2++) {
                jSONObject.put("privateIp", stringBufferDeleteCharAt);
            }
        }
        if (stringBuffer2.length() != 0 && '-' == stringBuffer2.charAt(stringBuffer2.length() - 1)) {
            java.lang.StringBuffer stringBufferDeleteCharAt2 = stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            int iMin2 = java.lang.Math.min(stringBuffer2.length(), 5);
            for (int i3 = 0; i3 < iMin2; i3++) {
                jSONObject.put("privateIp_v6", stringBufferDeleteCharAt2);
            }
        }
        return jSONObject.length() >= 1 ? jSONObject.toString() : "{\"privateIp\":\"0.0.0.0\"}";
    }
}
