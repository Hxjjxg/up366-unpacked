package com.up366.common.http;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OkHttpDns implements okhttp3.Dns {
    private static volatile com.up366.common.http.OkHttpDns instance;
    private final com.up366.common.http.OkHttpDns.HostResolver httpDnsResolver;
    private final okhttp3.Dns systemDns;

    interface HostResolver {
        com.up366.common.http.OkHttpDns.ResolveResult lookup(java.lang.String str) throws java.lang.Exception;
    }

    private OkHttpDns(android.content.Context context) {
        com.alibaba.sdk.android.httpdns.HttpDns.init(com.up366.common.BuildConfig.ALI_HTTPDNS_ACCOUNT_ID, new com.alibaba.sdk.android.httpdns.InitConfig.Builder().setEnableHttps(true).setTimeoutMillis(2000).setRegion(com.alibaba.sdk.android.httpdns.Region.DEFAULT).setEnableCacheIp(true).setEnableExpiredIp(true).setPreResolveAfterNetworkChanged(true).setContext(context.getApplicationContext()).setSecretKey(com.up366.common.BuildConfig.ALI_HTTPDNS_SECRET_KEY).buildFor(com.up366.common.BuildConfig.ALI_HTTPDNS_ACCOUNT_ID));
        final com.alibaba.sdk.android.httpdns.HttpDnsService service = com.alibaba.sdk.android.httpdns.HttpDns.getService(com.up366.common.BuildConfig.ALI_HTTPDNS_ACCOUNT_ID);
        this.httpDnsResolver = new com.up366.common.http.OkHttpDns.HostResolver() { // from class: com.up366.common.http.OkHttpDns$$ExternalSyntheticLambda0
            @Override // com.up366.common.http.OkHttpDns.HostResolver
            public final com.up366.common.http.OkHttpDns.ResolveResult lookup(java.lang.String str) {
                return com.up366.common.http.OkHttpDns.resolveByHttpDns(service, str);
            }
        };
        this.systemDns = okhttp3.Dns.SYSTEM;
    }

    OkHttpDns(com.up366.common.http.OkHttpDns.HostResolver hostResolver, okhttp3.Dns dns) {
        if (hostResolver == null) {
            throw new java.lang.NullPointerException("httpDnsResolver == null");
        }
        if (dns == null) {
            throw new java.lang.NullPointerException("systemDns == null");
        }
        this.httpDnsResolver = hostResolver;
        this.systemDns = dns;
    }

    public static com.up366.common.http.OkHttpDns getInstance() {
        if (instance == null) {
            synchronized (com.up366.common.http.OkHttpDns.class) {
                if (instance == null) {
                    instance = new com.up366.common.http.OkHttpDns(com.up366.common.global.GB.get().getApplicationContext());
                }
            }
        }
        return instance;
    }

    public java.util.List<java.net.InetAddress> lookup(java.lang.String str) throws java.net.UnknownHostException {
        com.up366.common.http.OkHttpDns.ResolveResult resolveResult = com.up366.common.http.OkHttpDns.ResolveResult.EMPTY;
        try {
            com.up366.common.http.OkHttpDns.ResolveResult resolveResultLookup = this.httpDnsResolver.lookup(str);
            if (resolveResultLookup != null) {
                resolveResult = resolveResultLookup;
            }
            if (resolveResult.hasAddresses() && !resolveResult.expired) {
                return resolveResult.addresses;
            }
            e = null;
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            java.util.List<java.net.InetAddress> listLookup = this.systemDns.lookup(str);
            if (listLookup != null && !listLookup.isEmpty()) {
                return resolveResult.hasAddresses() ? mergeAddresses(listLookup, resolveResult.addresses) : listLookup;
            }
            if (resolveResult.hasAddresses()) {
                return resolveResult.addresses;
            }
            java.net.UnknownHostException unknownHostException = new java.net.UnknownHostException("System DNS returned no addresses for " + str);
            addSuppressedIfPresent(unknownHostException, e);
            throw unknownHostException;
        } catch (java.net.UnknownHostException e2) {
            if (resolveResult.hasAddresses()) {
                return resolveResult.addresses;
            }
            addSuppressedIfPresent(e2, e);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.up366.common.http.OkHttpDns.ResolveResult resolveByHttpDns(com.alibaba.sdk.android.httpdns.HttpDnsService httpDnsService, java.lang.String str) {
        com.alibaba.sdk.android.httpdns.HTTPDNSResult httpDnsResultForHostSync = httpDnsService.getHttpDnsResultForHostSync(str, com.alibaba.sdk.android.httpdns.RequestIpType.both);
        if (httpDnsResultForHostSync == null) {
            return com.up366.common.http.OkHttpDns.ResolveResult.EMPTY;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        addAddresses(arrayList, httpDnsResultForHostSync.getIps());
        addAddresses(arrayList, httpDnsResultForHostSync.getIpv6s());
        return new com.up366.common.http.OkHttpDns.ResolveResult(arrayList, httpDnsResultForHostSync.isExpired());
    }

    private static void addAddresses(java.util.List<java.net.InetAddress> list, java.lang.String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (java.lang.String str : strArr) {
            if (str != null && !str.isEmpty()) {
                try {
                    list.add(java.net.InetAddress.getByName(str));
                } catch (java.net.UnknownHostException unused) {
                }
            }
        }
    }

    private static void addSuppressedIfPresent(java.net.UnknownHostException unknownHostException, java.lang.Exception exc) {
        if (exc == null || exc == unknownHostException) {
            return;
        }
        unknownHostException.addSuppressed(exc);
    }

    private static java.util.List<java.net.InetAddress> mergeAddresses(java.util.List<java.net.InetAddress> list, java.util.List<java.net.InetAddress> list2) {
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(list.size() + list2.size());
        linkedHashSet.addAll(list);
        linkedHashSet.addAll(list2);
        return new java.util.ArrayList(linkedHashSet);
    }

    static final class ResolveResult {
        static final com.up366.common.http.OkHttpDns.ResolveResult EMPTY = new com.up366.common.http.OkHttpDns.ResolveResult(java.util.Collections.emptyList(), false);
        final java.util.List<java.net.InetAddress> addresses;
        final boolean expired;

        ResolveResult(java.util.List<java.net.InetAddress> list, boolean z) {
            this.addresses = list == null ? java.util.Collections.emptyList() : list;
            this.expired = z;
        }

        boolean hasAddresses() {
            return !this.addresses.isEmpty();
        }
    }
}
