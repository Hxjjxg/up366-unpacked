package java8.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class DualPivotQuicksort {
    private static final int DELTA = 6;
    private static final int MAX_BYTE_INDEX = 384;
    private static final int MAX_INSERTION_SORT_SIZE = 44;
    private static final int MAX_MIXED_INSERTION_SORT_SIZE = 65;
    private static final int MAX_RECURSION_DEPTH = 384;
    private static final int MAX_RUN_CAPACITY = 5120;
    private static final int MAX_SHORT_INDEX = 98304;
    private static final int MIN_BYTE_COUNTING_SORT_SIZE = 64;
    private static final int MIN_FIRST_RUNS_FACTOR = 7;
    private static final int MIN_FIRST_RUN_SIZE = 16;
    private static final int MIN_PARALLEL_MERGE_PARTS_SIZE = 4096;
    private static final int MIN_PARALLEL_SORT_SIZE = 4096;
    private static final int MIN_RUN_COUNT = 4;
    private static final int MIN_SHORT_OR_CHAR_COUNTING_SORT_SIZE = 1750;
    private static final int MIN_TRY_MERGE_SIZE = 4096;
    private static final int NUM_BYTE_VALUES = 256;
    private static final int NUM_CHAR_VALUES = 65536;
    private static final int NUM_SHORT_VALUES = 65536;

    private static int getDepth(int i, int i2) {
        int i3 = 0;
        while (true) {
            i >>= 3;
            if (i <= 0 || (i2 = i2 >> 2) <= 0) {
                break;
            }
            i3 -= 2;
        }
        return i3;
    }

    private DualPivotQuicksort() {
    }

    static void sort(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 - i2;
        if (i > 1 && i4 > 4096) {
            int depth = getDepth(i, i4 >> 12);
            new java8.util.DualPivotQuicksort.Sorter(null, iArr, depth == 0 ? null : new int[i4], i2, i4, i2, depth).invoke();
        } else {
            sort((java8.util.DualPivotQuicksort.Sorter) null, iArr, 0, i2, i3);
        }
    }

    static void sort(java8.util.DualPivotQuicksort.Sorter sorter, int[] iArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        while (true) {
            int i8 = i3 - 1;
            int i9 = i3 - i2;
            if (i9 < i + 65 && (i & 1) > 0) {
                mixedInsertionSort(iArr, i2, i3 - (((i9 >> 5) << 3) * 3), i3);
                return;
            }
            if (i9 < 44) {
                insertionSort(iArr, i2, i3);
                return;
            }
            if ((i == 0 || (i9 > 4096 && (i & 1) > 0)) && tryMergeRuns(sorter, iArr, i2, i9)) {
                return;
            }
            i += 6;
            if (i > 384) {
                heapSort(iArr, i2, i3);
                return;
            }
            int i10 = ((i9 >> 3) * 3) + 3;
            int i11 = i2 + i10;
            int i12 = i8 - i10;
            int i13 = (i11 + i12) >>> 1;
            int i14 = (i11 + i13) >>> 1;
            int i15 = (i13 + i12) >>> 1;
            int i16 = iArr[i13];
            int i17 = iArr[i12];
            int i18 = iArr[i14];
            if (i17 < i18) {
                iArr[i12] = i18;
                iArr[i14] = i17;
            }
            int i19 = iArr[i15];
            int i20 = iArr[i11];
            if (i19 < i20) {
                iArr[i15] = i20;
                iArr[i11] = i19;
            }
            int i21 = iArr[i12];
            int i22 = iArr[i15];
            if (i21 < i22) {
                iArr[i12] = i22;
                iArr[i15] = i21;
            }
            int i23 = iArr[i14];
            int i24 = iArr[i11];
            if (i23 < i24) {
                iArr[i14] = i24;
                iArr[i11] = i23;
            }
            int i25 = iArr[i15];
            int i26 = iArr[i14];
            if (i25 < i26) {
                iArr[i15] = i26;
                iArr[i14] = i25;
            }
            int i27 = iArr[i14];
            if (i16 < i27) {
                if (i16 < iArr[i11]) {
                    iArr[i13] = i27;
                    iArr[i14] = iArr[i11];
                    iArr[i11] = i16;
                } else {
                    iArr[i13] = i27;
                    iArr[i14] = i16;
                }
            } else {
                int i28 = iArr[i15];
                if (i16 > i28) {
                    if (i16 > iArr[i12]) {
                        iArr[i13] = i28;
                        iArr[i15] = iArr[i12];
                        iArr[i12] = i16;
                    } else {
                        iArr[i13] = i28;
                        iArr[i15] = i16;
                    }
                }
            }
            int i29 = iArr[i11];
            int i30 = iArr[i14];
            if (i29 < i30 && i30 < (i5 = iArr[i13]) && i5 < (i6 = iArr[i15]) && i6 < (i7 = iArr[i12])) {
                iArr[i11] = iArr[i2];
                iArr[i12] = iArr[i8];
                int i31 = i2;
                while (true) {
                    int i32 = i31 + 1;
                    if (iArr[i32] >= i29) {
                        break;
                    } else {
                        i31 = i32;
                    }
                }
                int i33 = i8;
                while (true) {
                    int i34 = i33 - 1;
                    if (iArr[i34] <= i7) {
                        break;
                    } else {
                        i33 = i34;
                    }
                }
                int i35 = i33;
                while (true) {
                    i33--;
                    if (i33 <= i31) {
                        break;
                    }
                    int i36 = iArr[i33];
                    if (i36 < i29) {
                        while (true) {
                            if (i31 >= i33) {
                                break;
                            }
                            i31++;
                            int i37 = iArr[i31];
                            if (i37 >= i29) {
                                if (i37 > i7) {
                                    i35--;
                                    iArr[i33] = iArr[i35];
                                    iArr[i35] = iArr[i31];
                                } else {
                                    iArr[i33] = i37;
                                }
                                iArr[i31] = i36;
                            }
                        }
                    } else if (i36 > i7) {
                        i35--;
                        iArr[i33] = iArr[i35];
                        iArr[i35] = i36;
                    }
                }
                iArr[i2] = iArr[i31];
                iArr[i31] = i29;
                iArr[i8] = iArr[i35];
                iArr[i35] = i7;
                if (i9 > 4096 && sorter != null) {
                    int i38 = i | 1;
                    sorter.forkSorter(i38, i31 + 1, i35);
                    sorter.forkSorter(i38, i35 + 1, i3);
                } else {
                    int i39 = i | 1;
                    sort(sorter, iArr, i39, i31 + 1, i35);
                    sort(sorter, iArr, i39, i35 + 1, i3);
                }
                i3 = i31;
            } else {
                int i40 = iArr[i13];
                iArr[i13] = iArr[i2];
                int i41 = i2;
                int i42 = i3;
                int i43 = i42;
                while (true) {
                    i42--;
                    if (i42 <= i41) {
                        break;
                    }
                    int i44 = iArr[i42];
                    if (i44 != i40) {
                        iArr[i42] = i40;
                        if (i44 < i40) {
                            do {
                                i41++;
                                i4 = iArr[i41];
                            } while (i4 < i40);
                            if (i4 > i40) {
                                i43--;
                                iArr[i43] = i4;
                            }
                            iArr[i41] = i44;
                        } else {
                            i43--;
                            iArr[i43] = i44;
                        }
                    }
                }
                iArr[i2] = iArr[i41];
                iArr[i41] = i40;
                if (i9 > 4096 && sorter != null) {
                    sorter.forkSorter(i | 1, i43, i3);
                } else {
                    sort(sorter, iArr, i | 1, i43, i3);
                }
                i3 = i41;
            }
        }
    }

    private static void mixedInsertionSort(int[] iArr, int i, int i2, int i3) {
        int i4;
        int i5;
        if (i2 != i3) {
            int i6 = iArr[i2];
            int i7 = i3;
            while (true) {
                i4 = i + 1;
                if (i4 >= i2) {
                    break;
                }
                int i8 = iArr[i4];
                if (i8 < iArr[i]) {
                    iArr[i4] = iArr[i];
                    while (true) {
                        int i9 = i - 1;
                        int i10 = iArr[i9];
                        if (i8 >= i10) {
                            break;
                        }
                        iArr[i] = i10;
                        i = i9;
                    }
                    iArr[i] = i8;
                } else if (i7 > i4 && i8 > i6) {
                    do {
                        i7--;
                        i5 = iArr[i7];
                    } while (i5 > i6);
                    if (i7 > i4) {
                        iArr[i7] = iArr[i4];
                        i8 = i5;
                    }
                    int i11 = i4;
                    while (true) {
                        int i12 = i11 - 1;
                        int i13 = iArr[i12];
                        if (i8 >= i13) {
                            break;
                        }
                        iArr[i11] = i13;
                        i11 = i12;
                    }
                    iArr[i11] = i8;
                }
                i = i4;
            }
            while (i4 < i3) {
                int i14 = iArr[i4];
                int i15 = iArr[i4 + 1];
                if (i14 > i15) {
                    int i16 = i4;
                    while (true) {
                        int i17 = i16 - 1;
                        int i18 = iArr[i17];
                        if (i14 >= i18) {
                            break;
                        }
                        iArr[i16 + 1] = i18;
                        i16 = i17;
                    }
                    iArr[i16 + 1] = i14;
                    while (true) {
                        int i19 = i16 - 1;
                        int i20 = iArr[i19];
                        if (i15 >= i20) {
                            break;
                        }
                        iArr[i16] = i20;
                        i16 = i19;
                    }
                    iArr[i16] = i15;
                } else if (i14 < iArr[i4 - 1]) {
                    int i21 = i4;
                    while (true) {
                        int i22 = i21 - 1;
                        int i23 = iArr[i22];
                        if (i15 >= i23) {
                            break;
                        }
                        iArr[i21 + 1] = i23;
                        i21 = i22;
                    }
                    iArr[i21 + 1] = i15;
                    while (true) {
                        int i24 = i21 - 1;
                        int i25 = iArr[i24];
                        if (i14 >= i25) {
                            break;
                        }
                        iArr[i21] = i25;
                        i21 = i24;
                    }
                    iArr[i21] = i14;
                }
                i4 += 2;
            }
            return;
        }
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            int i26 = iArr[i];
            int i27 = i;
            while (true) {
                int i28 = i27 - 1;
                int i29 = iArr[i28];
                if (i26 < i29) {
                    iArr[i27] = i29;
                    i27 = i28;
                }
            }
            iArr[i27] = i26;
        }
    }

    private static void insertionSort(int[] iArr, int i, int i2) {
        int i3;
        int i4 = i;
        while (true) {
            int i5 = i4 + 1;
            if (i5 >= i2) {
                return;
            }
            int i6 = iArr[i5];
            if (i6 < iArr[i4]) {
                int i7 = i5;
                while (true) {
                    int i8 = i7 - 1;
                    if (i8 < i || i6 >= (i3 = iArr[i8])) {
                        break;
                    }
                    iArr[i7] = i3;
                    i7 = i8;
                }
                iArr[i7] = i6;
            }
            i4 = i5;
        }
    }

    private static void heapSort(int[] iArr, int i, int i2) {
        int i3 = (i + i2) >>> 1;
        while (i3 > i) {
            i3--;
            pushDown(iArr, i3, iArr[i3], i, i2);
        }
        while (true) {
            i2--;
            if (i2 <= i) {
                return;
            }
            int i4 = iArr[i];
            pushDown(iArr, i, iArr[i2], i, i2);
            iArr[i2] = i4;
        }
    }

    private static void pushDown(int[] iArr, int i, int i2, int i3, int i4) {
        while (true) {
            int i5 = (i << 1) - i3;
            int i6 = i5 + 2;
            if (i6 > i4) {
                break;
            }
            int i7 = (i6 == i4 || iArr[i6] < iArr[i5 + 1]) ? i5 + 1 : i6;
            int i8 = iArr[i7];
            if (i8 <= i2) {
                break;
            }
            iArr[i] = i8;
            i = i7;
        }
        iArr[i] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean tryMergeRuns(java8.util.DualPivotQuicksort.Sorter r12, int[] r13, int r14, int r15) {
        /*
            int r0 = r14 + r15
            int r1 = r14 + 1
            r2 = 0
            r3 = 1
            r9 = r2
            r11 = r3
            r2 = r14
        L9:
            r4 = 0
            if (r1 >= r0) goto L8b
            int r5 = r1 + (-1)
            r5 = r13[r5]
            r6 = r13[r1]
            if (r5 >= r6) goto L22
        L14:
            int r5 = r1 + 1
            if (r5 >= r0) goto L20
            r1 = r13[r1]
            r6 = r13[r5]
            if (r1 > r6) goto L20
            r1 = r5
            goto L14
        L20:
            r1 = r5
            goto L4e
        L22:
            if (r5 <= r6) goto L43
        L24:
            int r5 = r1 + 1
            if (r5 >= r0) goto L30
            r1 = r13[r1]
            r6 = r13[r5]
            if (r1 < r6) goto L30
            r1 = r5
            goto L24
        L30:
            int r1 = r2 + (-1)
            r6 = r5
        L33:
            int r1 = r1 + r3
            int r6 = r6 + (-1)
            if (r1 >= r6) goto L20
            r7 = r13[r1]
            r8 = r13[r6]
            if (r7 <= r8) goto L20
            r13[r1] = r8
            r13[r6] = r7
            goto L33
        L43:
            int r1 = r1 + r3
            if (r1 >= r0) goto L4b
            r5 = r13[r1]
            if (r6 != r5) goto L4b
            goto L43
        L4b:
            if (r1 >= r0) goto L4e
            goto L9
        L4e:
            if (r9 != 0) goto L66
            if (r1 != r0) goto L53
            return r3
        L53:
            int r2 = r1 - r14
            r5 = 16
            if (r2 >= r5) goto L5a
            return r4
        L5a:
            int r2 = r15 >> 10
            r2 = r2 | 127(0x7f, float:1.78E-43)
            r2 = r2 & 1023(0x3ff, float:1.434E-42)
            int[] r2 = new int[r2]
            r2[r4] = r14
        L64:
            r9 = r2
            goto L86
        L66:
            int r5 = r2 + (-1)
            r5 = r13[r5]
            r2 = r13[r2]
            if (r5 <= r2) goto L86
            int r2 = r1 - r14
            int r2 = r2 >> 7
            if (r11 <= r2) goto L75
            return r4
        L75:
            int r11 = r11 + 1
            r2 = 5120(0x1400, float:7.175E-42)
            if (r11 != r2) goto L7c
            return r4
        L7c:
            int r2 = r9.length
            if (r11 != r2) goto L86
            int r2 = r11 << 1
            int[] r2 = java.util.Arrays.copyOf(r9, r2)
            goto L64
        L86:
            r9[r11] = r1
            r2 = r1
            goto L9
        L8b:
            if (r11 <= r3) goto Lac
            if (r12 == 0) goto L9d
            java.lang.Object r0 = r12.b
            int[] r0 = (int[]) r0
            int[] r0 = (int[]) r0
            if (r0 != 0) goto L98
            goto L9d
        L98:
            int r14 = r12.offset
            r6 = r14
            r5 = r0
            goto La1
        L9d:
            int[] r15 = new int[r15]
            r6 = r14
            r5 = r15
        La1:
            if (r12 == 0) goto La5
            r8 = r3
            goto La6
        La5:
            r8 = r4
        La6:
            r10 = 0
            r7 = 1
            r4 = r13
            mergeRuns(r4, r5, r6, r7, r8, r9, r10, r11)
        Lac:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.DualPivotQuicksort.tryMergeRuns(java8.util.DualPivotQuicksort$Sorter, int[], int, int):boolean");
    }

    static int[] mergeRuns(int[] iArr, int[] iArr2, int i, int i2, boolean z, int[] iArr3, int i3, int i4) {
        int i5;
        int[] iArrMergeRuns;
        int[] iArrMergeRuns2;
        int i6 = i4 - i3;
        if (i6 == 1) {
            if (i2 >= 0) {
                return iArr;
            }
            int i7 = iArr3[i4];
            int i8 = i7 - i;
            int i9 = iArr3[i3];
            while (i7 > i9) {
                i8--;
                i7--;
                iArr2[i8] = iArr[i7];
            }
            return iArr2;
        }
        int i10 = i3;
        while (true) {
            i5 = i10 + 1;
            if (iArr3[i10 + 2] > ((iArr3[i3] + iArr3[i4]) >>> 1)) {
                break;
            }
            i10 = i5;
        }
        if (z && i6 > 4) {
            java8.util.DualPivotQuicksort.RunMerger runMergerForkMe = new java8.util.DualPivotQuicksort.RunMerger(iArr, iArr2, i, 0, iArr3, i5, i4).forkMe();
            int[] iArrMergeRuns3 = mergeRuns(iArr, iArr2, i, -i2, true, iArr3, i3, i5);
            iArrMergeRuns2 = (int[]) runMergerForkMe.getDestination();
            iArrMergeRuns = iArrMergeRuns3;
        } else {
            iArrMergeRuns = mergeRuns(iArr, iArr2, i, -i2, false, iArr3, i3, i5);
            iArrMergeRuns2 = mergeRuns(iArr, iArr2, i, 0, false, iArr3, i5, i4);
        }
        int[] iArr4 = iArrMergeRuns == iArr ? iArr2 : iArr;
        int i11 = iArrMergeRuns == iArr ? iArr3[i3] - i : iArr3[i3];
        int i12 = iArrMergeRuns == iArr2 ? iArr3[i3] - i : iArr3[i3];
        int i13 = iArrMergeRuns == iArr2 ? iArr3[i5] - i : iArr3[i5];
        int i14 = iArrMergeRuns2 == iArr2 ? iArr3[i5] - i : iArr3[i5];
        int i15 = iArrMergeRuns2 == iArr2 ? iArr3[i4] - i : iArr3[i4];
        if (z) {
            new java8.util.DualPivotQuicksort.Merger(null, iArr4, i11, iArrMergeRuns, i12, i13, iArrMergeRuns2, i14, i15).invoke();
        } else {
            mergeParts((java8.util.DualPivotQuicksort.Merger) null, iArr4, i11, iArrMergeRuns, i12, i13, iArrMergeRuns2, i14, i15);
        }
        return iArr4;
    }

    static void mergeParts(java8.util.DualPivotQuicksort.Merger merger, int[] iArr, int i, int[] iArr2, int i2, int i3, int[] iArr3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (merger == null || iArr2 != iArr3) {
            i6 = i;
            i7 = i2;
            i8 = i3;
            i9 = i4;
            i10 = i5;
        } else {
            int i11 = i2;
            int i12 = i3;
            int i13 = i4;
            int i14 = i5;
            while (true) {
                if (i12 - i11 < i14 - i13) {
                    i9 = i11;
                    i10 = i12;
                    i7 = i13;
                    i8 = i14;
                } else {
                    i7 = i11;
                    i8 = i12;
                    i9 = i13;
                    i10 = i14;
                }
                if (i8 - i7 < 4096) {
                    break;
                }
                int i15 = (i7 + i8) >>> 1;
                int i16 = iArr2[i15];
                int i17 = i10;
                int i18 = i9;
                while (i18 < i17) {
                    int i19 = (i18 + i17) >>> 1;
                    if (i16 > iArr3[i19]) {
                        i18 = i19 + 1;
                    } else {
                        i17 = i19;
                    }
                }
                merger.forkMerger(iArr, i + (((i17 - i9) + i15) - i7), iArr2, i15, i8, iArr3, i17, i10);
                i11 = i7;
                i13 = i9;
                i12 = i15;
                i14 = i17;
            }
            i6 = i;
        }
        while (i7 < i8 && i9 < i10) {
            int i20 = i6 + 1;
            int i21 = iArr2[i7];
            int i22 = iArr3[i9];
            if (i21 < i22) {
                i7++;
            } else {
                i9++;
                i21 = i22;
            }
            iArr[i6] = i21;
            i6 = i20;
        }
        if (iArr != iArr2 || i6 < i7) {
            while (i7 < i8) {
                iArr[i6] = iArr2[i7];
                i6++;
                i7++;
            }
        }
        if (iArr != iArr3 || i6 < i9) {
            while (i9 < i10) {
                iArr[i6] = iArr3[i9];
                i6++;
                i9++;
            }
        }
    }

    static void sort(long[] jArr, int i, int i2, int i3) {
        int i4 = i3 - i2;
        if (i > 1 && i4 > 4096) {
            int depth = getDepth(i, i4 >> 12);
            new java8.util.DualPivotQuicksort.Sorter(null, jArr, depth == 0 ? null : new long[i4], i2, i4, i2, depth).invoke();
        } else {
            sort((java8.util.DualPivotQuicksort.Sorter) null, jArr, 0, i2, i3);
        }
    }

    static void sort(java8.util.DualPivotQuicksort.Sorter sorter, long[] jArr, int i, int i2, int i3) {
        long j;
        int i4 = i;
        int i5 = i3;
        while (true) {
            int i6 = i5 - 1;
            int i7 = i5 - i2;
            if (i7 < i4 + 65 && (i4 & 1) > 0) {
                mixedInsertionSort(jArr, i2, i5 - (((i7 >> 5) << 3) * 3), i5);
                return;
            }
            if (i7 < 44) {
                insertionSort(jArr, i2, i5);
                return;
            }
            if ((i4 == 0 || (i7 > 4096 && (i4 & 1) > 0)) && tryMergeRuns(sorter, jArr, i2, i7)) {
                return;
            }
            i4 += 6;
            if (i4 > 384) {
                heapSort(jArr, i2, i5);
                return;
            }
            int i8 = ((i7 >> 3) * 3) + 3;
            int i9 = i2 + i8;
            int i10 = i6 - i8;
            int i11 = (i9 + i10) >>> 1;
            int i12 = (i9 + i11) >>> 1;
            int i13 = (i11 + i10) >>> 1;
            long j2 = jArr[i11];
            long j3 = jArr[i10];
            long j4 = jArr[i12];
            if (j3 < j4) {
                jArr[i10] = j4;
                jArr[i12] = j3;
            }
            long j5 = jArr[i13];
            long j6 = jArr[i9];
            if (j5 < j6) {
                jArr[i13] = j6;
                jArr[i9] = j5;
            }
            long j7 = jArr[i10];
            long j8 = jArr[i13];
            if (j7 < j8) {
                jArr[i10] = j8;
                jArr[i13] = j7;
            }
            long j9 = jArr[i12];
            long j10 = jArr[i9];
            if (j9 < j10) {
                jArr[i12] = j10;
                jArr[i9] = j9;
            }
            long j11 = jArr[i13];
            long j12 = jArr[i12];
            if (j11 < j12) {
                jArr[i13] = j12;
                jArr[i12] = j11;
            }
            long j13 = jArr[i12];
            if (j2 >= j13) {
                long j14 = jArr[i13];
                if (j2 > j14) {
                    if (j2 > jArr[i10]) {
                        jArr[i11] = j14;
                        jArr[i13] = jArr[i10];
                        jArr[i10] = j2;
                    } else {
                        jArr[i11] = j14;
                        jArr[i13] = j2;
                    }
                }
            } else if (j2 < jArr[i9]) {
                jArr[i11] = j13;
                jArr[i12] = jArr[i9];
                jArr[i9] = j2;
            } else {
                jArr[i11] = j13;
                jArr[i12] = j2;
            }
            long j15 = jArr[i9];
            long j16 = jArr[i12];
            if (j15 < j16) {
                long j17 = jArr[i11];
                if (j16 < j17) {
                    long j18 = jArr[i13];
                    if (j17 < j18) {
                        long j19 = jArr[i10];
                        if (j18 < j19) {
                            jArr[i9] = jArr[i2];
                            jArr[i10] = jArr[i6];
                            int i14 = i2;
                            while (true) {
                                int i15 = i14 + 1;
                                if (jArr[i15] >= j15) {
                                    break;
                                } else {
                                    i14 = i15;
                                }
                            }
                            int i16 = i6;
                            while (true) {
                                int i17 = i16 - 1;
                                if (jArr[i17] <= j19) {
                                    break;
                                } else {
                                    i16 = i17;
                                }
                            }
                            int i18 = i16;
                            while (true) {
                                i16--;
                                if (i16 <= i14) {
                                    break;
                                }
                                long j20 = jArr[i16];
                                if (j20 < j15) {
                                    while (true) {
                                        if (i14 < i16) {
                                            i14++;
                                            long j21 = jArr[i14];
                                            if (j21 >= j15) {
                                                if (j21 > j19) {
                                                    i18--;
                                                    jArr[i16] = jArr[i18];
                                                    jArr[i18] = jArr[i14];
                                                } else {
                                                    jArr[i16] = j21;
                                                }
                                                jArr[i14] = j20;
                                            }
                                        }
                                    }
                                } else if (j20 > j19) {
                                    i18--;
                                    jArr[i16] = jArr[i18];
                                    jArr[i18] = j20;
                                }
                            }
                            jArr[i2] = jArr[i14];
                            jArr[i14] = j15;
                            jArr[i6] = jArr[i18];
                            jArr[i18] = j19;
                            if (i7 > 4096 && sorter != null) {
                                int i19 = i4 | 1;
                                sorter.forkSorter(i19, i14 + 1, i18);
                                sorter.forkSorter(i19, i18 + 1, i5);
                            } else {
                                int i20 = i4 | 1;
                                sort(sorter, jArr, i20, i14 + 1, i18);
                                sort(sorter, jArr, i20, i18 + 1, i5);
                            }
                            i5 = i14;
                        }
                    }
                }
            }
            long j22 = jArr[i11];
            jArr[i11] = jArr[i2];
            int i21 = i2;
            int i22 = i5;
            int i23 = i22;
            while (true) {
                i22--;
                if (i22 <= i21) {
                    break;
                }
                long j23 = jArr[i22];
                if (j23 != j22) {
                    jArr[i22] = j22;
                    if (j23 < j22) {
                        do {
                            i21++;
                            j = jArr[i21];
                        } while (j < j22);
                        if (j > j22) {
                            i23--;
                            jArr[i23] = j;
                        }
                        jArr[i21] = j23;
                    } else {
                        i23--;
                        jArr[i23] = j23;
                    }
                }
            }
            jArr[i2] = jArr[i21];
            jArr[i21] = j22;
            if (i7 > 4096 && sorter != null) {
                sorter.forkSorter(i4 | 1, i23, i5);
            } else {
                sort(sorter, jArr, i4 | 1, i23, i5);
            }
            i5 = i21;
        }
    }

    private static void mixedInsertionSort(long[] jArr, int i, int i2, int i3) {
        int i4;
        long j;
        int i5;
        if (i2 != i3) {
            long j2 = jArr[i2];
            int i6 = i3;
            while (true) {
                i4 = i + 1;
                if (i4 >= i2) {
                    break;
                }
                long j3 = jArr[i4];
                if (j3 < jArr[i]) {
                    jArr[i4] = jArr[i];
                    while (true) {
                        int i7 = i - 1;
                        long j4 = jArr[i7];
                        if (j3 >= j4) {
                            break;
                        }
                        jArr[i] = j4;
                        i = i7;
                    }
                    jArr[i] = j3;
                } else if (i6 > i4 && j3 > j2) {
                    do {
                        i6--;
                        j = jArr[i6];
                    } while (j > j2);
                    if (i6 > i4) {
                        jArr[i6] = jArr[i4];
                        i5 = i4;
                        j3 = j;
                    } else {
                        i5 = i4;
                    }
                    while (true) {
                        int i8 = i5 - 1;
                        long j5 = jArr[i8];
                        if (j3 >= j5) {
                            break;
                        }
                        jArr[i5] = j5;
                        i5 = i8;
                    }
                    jArr[i5] = j3;
                }
                i = i4;
            }
            while (i4 < i3) {
                long j6 = jArr[i4];
                long j7 = jArr[i4 + 1];
                if (j6 > j7) {
                    int i9 = i4;
                    while (true) {
                        int i10 = i9 - 1;
                        long j8 = jArr[i10];
                        if (j6 >= j8) {
                            break;
                        }
                        jArr[i9 + 1] = j8;
                        i9 = i10;
                    }
                    jArr[i9 + 1] = j6;
                    while (true) {
                        int i11 = i9 - 1;
                        long j9 = jArr[i11];
                        if (j7 >= j9) {
                            break;
                        }
                        jArr[i9] = j9;
                        i9 = i11;
                    }
                    jArr[i9] = j7;
                } else if (j6 < jArr[i4 - 1]) {
                    int i12 = i4;
                    while (true) {
                        int i13 = i12 - 1;
                        long j10 = jArr[i13];
                        if (j7 >= j10) {
                            break;
                        }
                        jArr[i12 + 1] = j10;
                        i12 = i13;
                    }
                    jArr[i12 + 1] = j7;
                    while (true) {
                        int i14 = i12 - 1;
                        long j11 = jArr[i14];
                        if (j6 >= j11) {
                            break;
                        }
                        jArr[i12] = j11;
                        i12 = i14;
                    }
                    jArr[i12] = j6;
                }
                i4 += 2;
            }
            return;
        }
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            long j12 = jArr[i];
            int i15 = i;
            while (true) {
                int i16 = i15 - 1;
                long j13 = jArr[i16];
                if (j12 < j13) {
                    jArr[i15] = j13;
                    i15 = i16;
                }
            }
            jArr[i15] = j12;
        }
    }

    private static void insertionSort(long[] jArr, int i, int i2) {
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return;
            }
            long j = jArr[i4];
            if (j < jArr[i3]) {
                int i5 = i4;
                while (true) {
                    int i6 = i5 - 1;
                    if (i6 < i) {
                        break;
                    }
                    long j2 = jArr[i6];
                    if (j >= j2) {
                        break;
                    }
                    jArr[i5] = j2;
                    i5 = i6;
                }
                jArr[i5] = j;
            }
            i3 = i4;
        }
    }

    private static void heapSort(long[] jArr, int i, int i2) {
        int i3 = (i + i2) >>> 1;
        while (i3 > i) {
            i3--;
            pushDown(jArr, i3, jArr[i3], i, i2);
        }
        while (true) {
            i2--;
            if (i2 <= i) {
                return;
            }
            long j = jArr[i];
            pushDown(jArr, i, jArr[i2], i, i2);
            jArr[i2] = j;
        }
    }

    private static void pushDown(long[] jArr, int i, long j, int i2, int i3) {
        while (true) {
            int i4 = (i << 1) - i2;
            int i5 = i4 + 2;
            if (i5 > i3) {
                break;
            }
            int i6 = (i5 == i3 || jArr[i5] < jArr[i4 + 1]) ? i4 + 1 : i5;
            long j2 = jArr[i6];
            if (j2 <= j) {
                break;
            }
            jArr[i] = j2;
            i = i6;
        }
        jArr[i] = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean tryMergeRuns(java8.util.DualPivotQuicksort.Sorter r17, long[] r18, int r19, int r20) {
        /*
            r0 = r17
            r1 = r20
            int r2 = r19 + r1
            int r3 = r19 + 1
            r4 = 0
            r8 = 1
            r5 = r4
            r7 = r8
            r4 = r19
        Le:
            r6 = 0
            if (r3 >= r2) goto L9c
            int r9 = r3 + (-1)
            r9 = r18[r9]
            r11 = r18[r3]
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L2b
        L1b:
            int r9 = r3 + 1
            if (r9 >= r2) goto L29
            r10 = r18[r3]
            r12 = r18[r9]
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 > 0) goto L29
            r3 = r9
            goto L1b
        L29:
            r3 = r9
            goto L5f
        L2b:
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L52
        L2f:
            int r9 = r3 + 1
            if (r9 >= r2) goto L3d
            r10 = r18[r3]
            r12 = r18[r9]
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 < 0) goto L3d
            r3 = r9
            goto L2f
        L3d:
            int r3 = r4 + (-1)
            r10 = r9
        L40:
            int r3 = r3 + r8
            int r10 = r10 + (-1)
            if (r3 >= r10) goto L29
            r11 = r18[r3]
            r13 = r18[r10]
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L29
            r18[r3] = r13
            r18[r10] = r11
            goto L40
        L52:
            int r3 = r3 + r8
            if (r3 >= r2) goto L5c
            r9 = r18[r3]
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 != 0) goto L5c
            goto L52
        L5c:
            if (r3 >= r2) goto L5f
            goto Le
        L5f:
            if (r5 != 0) goto L76
            if (r3 != r2) goto L64
            return r8
        L64:
            int r4 = r3 - r19
            r5 = 16
            if (r4 >= r5) goto L6b
            return r6
        L6b:
            int r4 = r1 >> 10
            r4 = r4 | 127(0x7f, float:1.78E-43)
            r4 = r4 & 1023(0x3ff, float:1.434E-42)
            int[] r5 = new int[r4]
            r5[r6] = r19
            goto L97
        L76:
            int r9 = r4 + (-1)
            r9 = r18[r9]
            r11 = r18[r4]
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 <= 0) goto L97
            int r4 = r3 - r19
            int r4 = r4 >> 7
            if (r7 <= r4) goto L87
            return r6
        L87:
            int r7 = r7 + 1
            r4 = 5120(0x1400, float:7.175E-42)
            if (r7 != r4) goto L8e
            return r6
        L8e:
            int r4 = r5.length
            if (r7 != r4) goto L97
            int r4 = r7 << 1
            int[] r5 = java.util.Arrays.copyOf(r5, r4)
        L97:
            r5[r7] = r3
            r4 = r3
            goto Le
        L9c:
            if (r7 <= r8) goto Lc1
            if (r0 == 0) goto Lb1
            java.lang.Object r2 = r0.b
            long[] r2 = (long[]) r2
            long[] r2 = (long[]) r2
            if (r2 != 0) goto La9
            goto Lb1
        La9:
            int r1 = r0.offset
            r16 = r2
            r2 = r1
            r1 = r16
            goto Lb5
        Lb1:
            long[] r1 = new long[r1]
            r2 = r19
        Lb5:
            if (r0 == 0) goto Lb9
            r4 = r8
            goto Lba
        Lb9:
            r4 = r6
        Lba:
            r6 = 0
            r3 = 1
            r0 = r18
            mergeRuns(r0, r1, r2, r3, r4, r5, r6, r7)
        Lc1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.DualPivotQuicksort.tryMergeRuns(java8.util.DualPivotQuicksort$Sorter, long[], int, int):boolean");
    }

    static long[] mergeRuns(long[] jArr, long[] jArr2, int i, int i2, boolean z, int[] iArr, int i3, int i4) {
        int i5;
        long[] jArrMergeRuns;
        long[] jArrMergeRuns2;
        int i6 = i4 - i3;
        if (i6 == 1) {
            if (i2 >= 0) {
                return jArr;
            }
            int i7 = iArr[i4];
            int i8 = i7 - i;
            int i9 = iArr[i3];
            while (i7 > i9) {
                i8--;
                i7--;
                jArr2[i8] = jArr[i7];
            }
            return jArr2;
        }
        int i10 = i3;
        while (true) {
            i5 = i10 + 1;
            if (iArr[i10 + 2] > ((iArr[i3] + iArr[i4]) >>> 1)) {
                break;
            }
            i10 = i5;
        }
        if (z && i6 > 4) {
            java8.util.DualPivotQuicksort.RunMerger runMergerForkMe = new java8.util.DualPivotQuicksort.RunMerger(jArr, jArr2, i, 0, iArr, i5, i4).forkMe();
            long[] jArrMergeRuns3 = mergeRuns(jArr, jArr2, i, -i2, true, iArr, i3, i5);
            jArrMergeRuns2 = (long[]) runMergerForkMe.getDestination();
            jArrMergeRuns = jArrMergeRuns3;
        } else {
            jArrMergeRuns = mergeRuns(jArr, jArr2, i, -i2, false, iArr, i3, i5);
            jArrMergeRuns2 = mergeRuns(jArr, jArr2, i, 0, false, iArr, i5, i4);
        }
        long[] jArr3 = jArrMergeRuns == jArr ? jArr2 : jArr;
        int i11 = jArrMergeRuns == jArr ? iArr[i3] - i : iArr[i3];
        int i12 = jArrMergeRuns == jArr2 ? iArr[i3] - i : iArr[i3];
        int i13 = jArrMergeRuns == jArr2 ? iArr[i5] - i : iArr[i5];
        int i14 = jArrMergeRuns2 == jArr2 ? iArr[i5] - i : iArr[i5];
        int i15 = jArrMergeRuns2 == jArr2 ? iArr[i4] - i : iArr[i4];
        if (z) {
            new java8.util.DualPivotQuicksort.Merger(null, jArr3, i11, jArrMergeRuns, i12, i13, jArrMergeRuns2, i14, i15).invoke();
        } else {
            mergeParts((java8.util.DualPivotQuicksort.Merger) null, jArr3, i11, jArrMergeRuns, i12, i13, jArrMergeRuns2, i14, i15);
        }
        return jArr3;
    }

    static void mergeParts(java8.util.DualPivotQuicksort.Merger merger, long[] jArr, int i, long[] jArr2, int i2, int i3, long[] jArr3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (merger == null || jArr2 != jArr3) {
            i6 = i;
            i7 = i2;
            i8 = i3;
            i9 = i4;
            i10 = i5;
        } else {
            int i11 = i2;
            int i12 = i3;
            int i13 = i4;
            int i14 = i5;
            while (true) {
                if (i12 - i11 < i14 - i13) {
                    i9 = i11;
                    i10 = i12;
                    i7 = i13;
                    i8 = i14;
                } else {
                    i7 = i11;
                    i8 = i12;
                    i9 = i13;
                    i10 = i14;
                }
                if (i8 - i7 < 4096) {
                    break;
                }
                int i15 = (i7 + i8) >>> 1;
                long j = jArr2[i15];
                int i16 = i10;
                int i17 = i9;
                while (i17 < i16) {
                    int i18 = (i17 + i16) >>> 1;
                    if (j > jArr3[i18]) {
                        i17 = i18 + 1;
                    } else {
                        i16 = i18;
                    }
                }
                merger.forkMerger(jArr, i + (((i16 - i9) + i15) - i7), jArr2, i15, i8, jArr3, i16, i10);
                i11 = i7;
                i13 = i9;
                i12 = i15;
                i14 = i16;
            }
            i6 = i;
        }
        while (i7 < i8 && i9 < i10) {
            int i19 = i6 + 1;
            long j2 = jArr2[i7];
            long j3 = jArr3[i9];
            if (j2 < j3) {
                i7++;
            } else {
                i9++;
                j2 = j3;
            }
            jArr[i6] = j2;
            i6 = i19;
        }
        if (jArr != jArr2 || i6 < i7) {
            while (i7 < i8) {
                jArr[i6] = jArr2[i7];
                i6++;
                i7++;
            }
        }
        if (jArr != jArr3 || i6 < i9) {
            while (i9 < i10) {
                jArr[i6] = jArr3[i9];
                i6++;
                i9++;
            }
        }
    }

    static void sort(byte[] bArr, int i, int i2) {
        if (i2 - i > 64) {
            countingSort(bArr, i, i2);
        } else {
            insertionSort(bArr, i, i2);
        }
    }

    private static void insertionSort(byte[] bArr, int i, int i2) {
        byte b;
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return;
            }
            byte b2 = bArr[i4];
            if (b2 < bArr[i3]) {
                int i5 = i4;
                while (true) {
                    int i6 = i5 - 1;
                    if (i6 < i || b2 >= (b = bArr[i6])) {
                        break;
                    }
                    bArr[i5] = b;
                    i5 = i6;
                }
                bArr[i5] = b2;
            }
            i3 = i4;
        }
    }

    private static void countingSort(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int[] iArr = new int[256];
        int i5 = i2;
        while (i5 > i) {
            i5--;
            int i6 = bArr[i5] & 255;
            iArr[i6] = iArr[i6] + 1;
        }
        int i7 = 384;
        if (i2 - i <= 256) {
            while (i2 > i) {
                do {
                    i7--;
                    i3 = i7 & 255;
                    i4 = iArr[i3];
                } while (i4 == 0);
                do {
                    i2--;
                    bArr[i2] = (byte) i3;
                    i4--;
                } while (i4 > 0);
            }
            return;
        }
        while (true) {
            i7--;
            if (i7 <= 127) {
                return;
            }
            int i8 = i7 & 255;
            int i9 = i2 - iArr[i8];
            while (i2 > i9) {
                i2--;
                bArr[i2] = (byte) i8;
            }
        }
    }

    static void sort(char[] cArr, int i, int i2) {
        if (i2 - i > MIN_SHORT_OR_CHAR_COUNTING_SORT_SIZE) {
            countingSort(cArr, i, i2);
        } else {
            sort(cArr, 0, i, i2);
        }
    }

    static void sort(char[] cArr, int i, int i2, int i3) {
        char c;
        char c2;
        char c3;
        char c4;
        while (true) {
            int i4 = i3 - 1;
            int i5 = i3 - i2;
            if (i5 < 44) {
                insertionSort(cArr, i2, i3);
                return;
            }
            i += 6;
            if (i > 384) {
                countingSort(cArr, i2, i3);
                return;
            }
            int i6 = ((i5 >> 3) * 3) + 3;
            int i7 = i2 + i6;
            int i8 = i4 - i6;
            int i9 = (i7 + i8) >>> 1;
            int i10 = (i7 + i9) >>> 1;
            int i11 = (i9 + i8) >>> 1;
            char c5 = cArr[i9];
            char c6 = cArr[i8];
            char c7 = cArr[i10];
            if (c6 < c7) {
                cArr[i8] = c7;
                cArr[i10] = c6;
            }
            char c8 = cArr[i11];
            char c9 = cArr[i7];
            if (c8 < c9) {
                cArr[i11] = c9;
                cArr[i7] = c8;
            }
            char c10 = cArr[i8];
            char c11 = cArr[i11];
            if (c10 < c11) {
                cArr[i8] = c11;
                cArr[i11] = c10;
            }
            char c12 = cArr[i10];
            char c13 = cArr[i7];
            if (c12 < c13) {
                cArr[i10] = c13;
                cArr[i7] = c12;
            }
            char c14 = cArr[i11];
            char c15 = cArr[i10];
            if (c14 < c15) {
                cArr[i11] = c15;
                cArr[i10] = c14;
            }
            char c16 = cArr[i10];
            if (c5 < c16) {
                if (c5 < cArr[i7]) {
                    cArr[i9] = c16;
                    cArr[i10] = cArr[i7];
                    cArr[i7] = c5;
                } else {
                    cArr[i9] = c16;
                    cArr[i10] = c5;
                }
            } else {
                char c17 = cArr[i11];
                if (c5 > c17) {
                    if (c5 > cArr[i8]) {
                        cArr[i9] = c17;
                        cArr[i11] = cArr[i8];
                        cArr[i8] = c5;
                    } else {
                        cArr[i9] = c17;
                        cArr[i11] = c5;
                    }
                }
            }
            char c18 = cArr[i7];
            char c19 = cArr[i10];
            if (c18 < c19 && c19 < (c2 = cArr[i9]) && c2 < (c3 = cArr[i11]) && c3 < (c4 = cArr[i8])) {
                cArr[i7] = cArr[i2];
                cArr[i8] = cArr[i4];
                int i12 = i2;
                while (true) {
                    int i13 = i12 + 1;
                    if (cArr[i13] >= c18) {
                        break;
                    } else {
                        i12 = i13;
                    }
                }
                int i14 = i4;
                while (true) {
                    int i15 = i14 - 1;
                    if (cArr[i15] <= c4) {
                        break;
                    } else {
                        i14 = i15;
                    }
                }
                int i16 = i14;
                while (true) {
                    i14--;
                    if (i14 <= i12) {
                        break;
                    }
                    char c20 = cArr[i14];
                    if (c20 < c18) {
                        while (true) {
                            if (i12 >= i14) {
                                break;
                            }
                            i12++;
                            char c21 = cArr[i12];
                            if (c21 >= c18) {
                                if (c21 > c4) {
                                    i16--;
                                    cArr[i14] = cArr[i16];
                                    cArr[i16] = cArr[i12];
                                } else {
                                    cArr[i14] = c21;
                                }
                                cArr[i12] = c20;
                            }
                        }
                    } else if (c20 > c4) {
                        i16--;
                        cArr[i14] = cArr[i16];
                        cArr[i16] = c20;
                    }
                }
                cArr[i2] = cArr[i12];
                cArr[i12] = c18;
                cArr[i4] = cArr[i16];
                cArr[i16] = c4;
                int i17 = i | 1;
                sort(cArr, i17, i12 + 1, i16);
                sort(cArr, i17, i16 + 1, i3);
                i3 = i12;
            } else {
                char c22 = cArr[i9];
                cArr[i9] = cArr[i2];
                int i18 = i2;
                int i19 = i3;
                int i20 = i19;
                while (true) {
                    i19--;
                    if (i19 <= i18) {
                        break;
                    }
                    char c23 = cArr[i19];
                    if (c23 != c22) {
                        cArr[i19] = c22;
                        if (c23 < c22) {
                            do {
                                i18++;
                                c = cArr[i18];
                            } while (c < c22);
                            if (c > c22) {
                                i20--;
                                cArr[i20] = c;
                            }
                            cArr[i18] = c23;
                        } else {
                            i20--;
                            cArr[i20] = c23;
                        }
                    }
                }
                cArr[i2] = cArr[i18];
                cArr[i18] = c22;
                sort(cArr, i | 1, i20, i3);
                i3 = i18;
            }
        }
    }

    private static void insertionSort(char[] cArr, int i, int i2) {
        char c;
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return;
            }
            char c2 = cArr[i4];
            if (c2 < cArr[i3]) {
                int i5 = i4;
                while (true) {
                    int i6 = i5 - 1;
                    if (i6 < i || c2 >= (c = cArr[i6])) {
                        break;
                    }
                    cArr[i5] = c;
                    i5 = i6;
                }
                cArr[i5] = c2;
            }
            i3 = i4;
        }
    }

    private static void countingSort(char[] cArr, int i, int i2) {
        int i3;
        int i4 = 65536;
        int[] iArr = new int[65536];
        int i5 = i2;
        while (i5 > i) {
            i5--;
            char c = cArr[i5];
            iArr[c] = iArr[c] + 1;
        }
        if (i2 - i > 65536) {
            while (i4 > 0) {
                i4--;
                int i6 = i2 - iArr[i4];
                while (i2 > i6) {
                    i2--;
                    cArr[i2] = (char) i4;
                }
            }
            return;
        }
        while (i2 > i) {
            do {
                i4--;
                i3 = iArr[i4];
            } while (i3 == 0);
            do {
                i2--;
                cArr[i2] = (char) i4;
                i3--;
            } while (i3 > 0);
        }
    }

    static void sort(short[] sArr, int i, int i2) {
        if (i2 - i > MIN_SHORT_OR_CHAR_COUNTING_SORT_SIZE) {
            countingSort(sArr, i, i2);
        } else {
            sort(sArr, 0, i, i2);
        }
    }

    static void sort(short[] sArr, int i, int i2, int i3) {
        short s;
        short s2;
        short s3;
        short s4;
        while (true) {
            int i4 = i3 - 1;
            int i5 = i3 - i2;
            if (i5 < 44) {
                insertionSort(sArr, i2, i3);
                return;
            }
            i += 6;
            if (i > 384) {
                countingSort(sArr, i2, i3);
                return;
            }
            int i6 = ((i5 >> 3) * 3) + 3;
            int i7 = i2 + i6;
            int i8 = i4 - i6;
            int i9 = (i7 + i8) >>> 1;
            int i10 = (i7 + i9) >>> 1;
            int i11 = (i9 + i8) >>> 1;
            short s5 = sArr[i9];
            short s6 = sArr[i8];
            short s7 = sArr[i10];
            if (s6 < s7) {
                sArr[i8] = s7;
                sArr[i10] = s6;
            }
            short s8 = sArr[i11];
            short s9 = sArr[i7];
            if (s8 < s9) {
                sArr[i11] = s9;
                sArr[i7] = s8;
            }
            short s10 = sArr[i8];
            short s11 = sArr[i11];
            if (s10 < s11) {
                sArr[i8] = s11;
                sArr[i11] = s10;
            }
            short s12 = sArr[i10];
            short s13 = sArr[i7];
            if (s12 < s13) {
                sArr[i10] = s13;
                sArr[i7] = s12;
            }
            short s14 = sArr[i11];
            short s15 = sArr[i10];
            if (s14 < s15) {
                sArr[i11] = s15;
                sArr[i10] = s14;
            }
            short s16 = sArr[i10];
            if (s5 < s16) {
                if (s5 < sArr[i7]) {
                    sArr[i9] = s16;
                    sArr[i10] = sArr[i7];
                    sArr[i7] = s5;
                } else {
                    sArr[i9] = s16;
                    sArr[i10] = s5;
                }
            } else {
                short s17 = sArr[i11];
                if (s5 > s17) {
                    if (s5 > sArr[i8]) {
                        sArr[i9] = s17;
                        sArr[i11] = sArr[i8];
                        sArr[i8] = s5;
                    } else {
                        sArr[i9] = s17;
                        sArr[i11] = s5;
                    }
                }
            }
            short s18 = sArr[i7];
            short s19 = sArr[i10];
            if (s18 < s19 && s19 < (s2 = sArr[i9]) && s2 < (s3 = sArr[i11]) && s3 < (s4 = sArr[i8])) {
                sArr[i7] = sArr[i2];
                sArr[i8] = sArr[i4];
                int i12 = i2;
                while (true) {
                    int i13 = i12 + 1;
                    if (sArr[i13] >= s18) {
                        break;
                    } else {
                        i12 = i13;
                    }
                }
                int i14 = i4;
                while (true) {
                    int i15 = i14 - 1;
                    if (sArr[i15] <= s4) {
                        break;
                    } else {
                        i14 = i15;
                    }
                }
                int i16 = i14;
                while (true) {
                    i14--;
                    if (i14 <= i12) {
                        break;
                    }
                    short s20 = sArr[i14];
                    if (s20 < s18) {
                        while (true) {
                            if (i12 >= i14) {
                                break;
                            }
                            i12++;
                            short s21 = sArr[i12];
                            if (s21 >= s18) {
                                if (s21 > s4) {
                                    i16--;
                                    sArr[i14] = sArr[i16];
                                    sArr[i16] = sArr[i12];
                                } else {
                                    sArr[i14] = s21;
                                }
                                sArr[i12] = s20;
                            }
                        }
                    } else if (s20 > s4) {
                        i16--;
                        sArr[i14] = sArr[i16];
                        sArr[i16] = s20;
                    }
                }
                sArr[i2] = sArr[i12];
                sArr[i12] = s18;
                sArr[i4] = sArr[i16];
                sArr[i16] = s4;
                int i17 = i | 1;
                sort(sArr, i17, i12 + 1, i16);
                sort(sArr, i17, i16 + 1, i3);
                i3 = i12;
            } else {
                short s22 = sArr[i9];
                sArr[i9] = sArr[i2];
                int i18 = i2;
                int i19 = i3;
                int i20 = i19;
                while (true) {
                    i19--;
                    if (i19 <= i18) {
                        break;
                    }
                    short s23 = sArr[i19];
                    if (s23 != s22) {
                        sArr[i19] = s22;
                        if (s23 < s22) {
                            do {
                                i18++;
                                s = sArr[i18];
                            } while (s < s22);
                            if (s > s22) {
                                i20--;
                                sArr[i20] = s;
                            }
                            sArr[i18] = s23;
                        } else {
                            i20--;
                            sArr[i20] = s23;
                        }
                    }
                }
                sArr[i2] = sArr[i18];
                sArr[i18] = s22;
                sort(sArr, i | 1, i20, i3);
                i3 = i18;
            }
        }
    }

    private static void insertionSort(short[] sArr, int i, int i2) {
        short s;
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return;
            }
            short s2 = sArr[i4];
            if (s2 < sArr[i3]) {
                int i5 = i4;
                while (true) {
                    int i6 = i5 - 1;
                    if (i6 < i || s2 >= (s = sArr[i6])) {
                        break;
                    }
                    sArr[i5] = s;
                    i5 = i6;
                }
                sArr[i5] = s2;
            }
            i3 = i4;
        }
    }

    private static void countingSort(short[] sArr, int i, int i2) {
        int i3;
        int i4;
        int[] iArr = new int[65536];
        int i5 = i2;
        while (i5 > i) {
            i5--;
            int i6 = 65535 & sArr[i5];
            iArr[i6] = iArr[i6] + 1;
        }
        int i7 = i2 - i;
        int i8 = MAX_SHORT_INDEX;
        if (i7 <= 65536) {
            while (i2 > i) {
                do {
                    i8--;
                    i3 = i8 & 65535;
                    i4 = iArr[i3];
                } while (i4 == 0);
                do {
                    i2--;
                    sArr[i2] = (short) i3;
                    i4--;
                } while (i4 > 0);
            }
            return;
        }
        while (true) {
            i8--;
            if (i8 <= 32767) {
                return;
            }
            int i9 = i8 & 65535;
            int i10 = i2 - iArr[i9];
            while (i2 > i10) {
                i2--;
                sArr[i2] = (short) i9;
            }
        }
    }

    static void sort(float[] fArr, int i, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        int i6 = i5;
        int i7 = 0;
        while (i5 > i4) {
            i5--;
            float f = fArr[i5];
            if (f == 0.0f && java.lang.Float.floatToRawIntBits(f) < 0) {
                i7++;
                fArr[i5] = 0.0f;
            } else if (f != f) {
                i6--;
                fArr[i5] = fArr[i6];
                fArr[i6] = f;
            }
        }
        int i8 = i6 - i4;
        if (i > 1 && i8 > 4096) {
            int depth = getDepth(i, i8 >> 12);
            new java8.util.DualPivotQuicksort.Sorter(null, fArr, depth == 0 ? null : new float[i8], i2, i8, i2, depth).invoke();
        } else {
            sort((java8.util.DualPivotQuicksort.Sorter) null, fArr, 0, i4, i6);
        }
        int i9 = i7 + 1;
        if (i9 == 1) {
            return;
        }
        while (i4 <= i6) {
            int i10 = (i4 + i6) >>> 1;
            if (fArr[i10] < 0.0f) {
                i4 = i10 + 1;
            } else {
                i6 = i10 - 1;
            }
        }
        while (true) {
            i9--;
            if (i9 <= 0) {
                return;
            }
            i6++;
            fArr[i6] = -0.0f;
        }
    }

    static void sort(java8.util.DualPivotQuicksort.Sorter sorter, float[] fArr, int i, int i2, int i3) {
        float f;
        int i4 = i;
        int i5 = i3;
        while (true) {
            int i6 = i5 - 1;
            int i7 = i5 - i2;
            if (i7 < i4 + 65 && (i4 & 1) > 0) {
                mixedInsertionSort(fArr, i2, i5 - (((i7 >> 5) << 3) * 3), i5);
                return;
            }
            if (i7 < 44) {
                insertionSort(fArr, i2, i5);
                return;
            }
            if ((i4 == 0 || (i7 > 4096 && (i4 & 1) > 0)) && tryMergeRuns(sorter, fArr, i2, i7)) {
                return;
            }
            i4 += 6;
            if (i4 > 384) {
                heapSort(fArr, i2, i5);
                return;
            }
            int i8 = ((i7 >> 3) * 3) + 3;
            int i9 = i2 + i8;
            int i10 = i6 - i8;
            int i11 = (i9 + i10) >>> 1;
            int i12 = (i9 + i11) >>> 1;
            int i13 = (i11 + i10) >>> 1;
            float f2 = fArr[i11];
            float f3 = fArr[i10];
            float f4 = fArr[i12];
            if (f3 < f4) {
                fArr[i10] = f4;
                fArr[i12] = f3;
            }
            float f5 = fArr[i13];
            float f6 = fArr[i9];
            if (f5 < f6) {
                fArr[i13] = f6;
                fArr[i9] = f5;
            }
            float f7 = fArr[i10];
            float f8 = fArr[i13];
            if (f7 < f8) {
                fArr[i10] = f8;
                fArr[i13] = f7;
            }
            float f9 = fArr[i12];
            float f10 = fArr[i9];
            if (f9 < f10) {
                fArr[i12] = f10;
                fArr[i9] = f9;
            }
            float f11 = fArr[i13];
            float f12 = fArr[i12];
            if (f11 < f12) {
                fArr[i13] = f12;
                fArr[i12] = f11;
            }
            float f13 = fArr[i12];
            if (f2 >= f13) {
                float f14 = fArr[i13];
                if (f2 > f14) {
                    if (f2 > fArr[i10]) {
                        fArr[i11] = f14;
                        fArr[i13] = fArr[i10];
                        fArr[i10] = f2;
                    } else {
                        fArr[i11] = f14;
                        fArr[i13] = f2;
                    }
                }
            } else if (f2 < fArr[i9]) {
                fArr[i11] = f13;
                fArr[i12] = fArr[i9];
                fArr[i9] = f2;
            } else {
                fArr[i11] = f13;
                fArr[i12] = f2;
            }
            float f15 = fArr[i9];
            float f16 = fArr[i12];
            if (f15 < f16) {
                float f17 = fArr[i11];
                if (f16 < f17) {
                    float f18 = fArr[i13];
                    if (f17 < f18) {
                        float f19 = fArr[i10];
                        if (f18 < f19) {
                            fArr[i9] = fArr[i2];
                            fArr[i10] = fArr[i6];
                            int i14 = i2;
                            while (true) {
                                int i15 = i14 + 1;
                                if (fArr[i15] >= f15) {
                                    break;
                                } else {
                                    i14 = i15;
                                }
                            }
                            int i16 = i6;
                            while (true) {
                                int i17 = i16 - 1;
                                if (fArr[i17] <= f19) {
                                    break;
                                } else {
                                    i16 = i17;
                                }
                            }
                            int i18 = i16;
                            while (true) {
                                i16--;
                                if (i16 <= i14) {
                                    break;
                                }
                                float f20 = fArr[i16];
                                if (f20 < f15) {
                                    while (true) {
                                        if (i14 < i16) {
                                            i14++;
                                            float f21 = fArr[i14];
                                            if (f21 >= f15) {
                                                if (f21 > f19) {
                                                    i18--;
                                                    fArr[i16] = fArr[i18];
                                                    fArr[i18] = fArr[i14];
                                                } else {
                                                    fArr[i16] = f21;
                                                }
                                                fArr[i14] = f20;
                                            }
                                        }
                                    }
                                } else if (f20 > f19) {
                                    i18--;
                                    fArr[i16] = fArr[i18];
                                    fArr[i18] = f20;
                                }
                            }
                            fArr[i2] = fArr[i14];
                            fArr[i14] = f15;
                            fArr[i6] = fArr[i18];
                            fArr[i18] = f19;
                            if (i7 > 4096 && sorter != null) {
                                int i19 = i4 | 1;
                                sorter.forkSorter(i19, i14 + 1, i18);
                                sorter.forkSorter(i19, i18 + 1, i5);
                            } else {
                                int i20 = i4 | 1;
                                sort(sorter, fArr, i20, i14 + 1, i18);
                                sort(sorter, fArr, i20, i18 + 1, i5);
                            }
                            i5 = i14;
                        }
                    }
                }
            }
            float f22 = fArr[i11];
            fArr[i11] = fArr[i2];
            int i21 = i2;
            int i22 = i5;
            int i23 = i22;
            while (true) {
                i22--;
                if (i22 <= i21) {
                    break;
                }
                float f23 = fArr[i22];
                if (f23 != f22) {
                    fArr[i22] = f22;
                    if (f23 < f22) {
                        do {
                            i21++;
                            f = fArr[i21];
                        } while (f < f22);
                        if (f > f22) {
                            i23--;
                            fArr[i23] = f;
                        }
                        fArr[i21] = f23;
                    } else {
                        i23--;
                        fArr[i23] = f23;
                    }
                }
            }
            fArr[i2] = fArr[i21];
            fArr[i21] = f22;
            if (i7 > 4096 && sorter != null) {
                sorter.forkSorter(i4 | 1, i23, i5);
            } else {
                sort(sorter, fArr, i4 | 1, i23, i5);
            }
            i5 = i21;
        }
    }

    private static void mixedInsertionSort(float[] fArr, int i, int i2, int i3) {
        int i4;
        float f;
        if (i2 != i3) {
            float f2 = fArr[i2];
            int i5 = i3;
            while (true) {
                i4 = i + 1;
                if (i4 >= i2) {
                    break;
                }
                float f3 = fArr[i4];
                if (f3 < fArr[i]) {
                    fArr[i4] = fArr[i];
                    while (true) {
                        int i6 = i - 1;
                        float f4 = fArr[i6];
                        if (f3 >= f4) {
                            break;
                        }
                        fArr[i] = f4;
                        i = i6;
                    }
                    fArr[i] = f3;
                } else if (i5 > i4 && f3 > f2) {
                    do {
                        i5--;
                        f = fArr[i5];
                    } while (f > f2);
                    if (i5 > i4) {
                        fArr[i5] = fArr[i4];
                        f3 = f;
                    }
                    int i7 = i4;
                    while (true) {
                        int i8 = i7 - 1;
                        float f5 = fArr[i8];
                        if (f3 >= f5) {
                            break;
                        }
                        fArr[i7] = f5;
                        i7 = i8;
                    }
                    fArr[i7] = f3;
                }
                i = i4;
            }
            while (i4 < i3) {
                float f6 = fArr[i4];
                float f7 = fArr[i4 + 1];
                if (f6 > f7) {
                    int i9 = i4;
                    while (true) {
                        int i10 = i9 - 1;
                        float f8 = fArr[i10];
                        if (f6 >= f8) {
                            break;
                        }
                        fArr[i9 + 1] = f8;
                        i9 = i10;
                    }
                    fArr[i9 + 1] = f6;
                    while (true) {
                        int i11 = i9 - 1;
                        float f9 = fArr[i11];
                        if (f7 >= f9) {
                            break;
                        }
                        fArr[i9] = f9;
                        i9 = i11;
                    }
                    fArr[i9] = f7;
                } else if (f6 < fArr[i4 - 1]) {
                    int i12 = i4;
                    while (true) {
                        int i13 = i12 - 1;
                        float f10 = fArr[i13];
                        if (f7 >= f10) {
                            break;
                        }
                        fArr[i12 + 1] = f10;
                        i12 = i13;
                    }
                    fArr[i12 + 1] = f7;
                    while (true) {
                        int i14 = i12 - 1;
                        float f11 = fArr[i14];
                        if (f6 >= f11) {
                            break;
                        }
                        fArr[i12] = f11;
                        i12 = i14;
                    }
                    fArr[i12] = f6;
                }
                i4 += 2;
            }
            return;
        }
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            float f12 = fArr[i];
            int i15 = i;
            while (true) {
                int i16 = i15 - 1;
                float f13 = fArr[i16];
                if (f12 < f13) {
                    fArr[i15] = f13;
                    i15 = i16;
                }
            }
            fArr[i15] = f12;
        }
    }

    private static void insertionSort(float[] fArr, int i, int i2) {
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return;
            }
            float f = fArr[i4];
            if (f < fArr[i3]) {
                int i5 = i4;
                while (true) {
                    int i6 = i5 - 1;
                    if (i6 < i) {
                        break;
                    }
                    float f2 = fArr[i6];
                    if (f >= f2) {
                        break;
                    }
                    fArr[i5] = f2;
                    i5 = i6;
                }
                fArr[i5] = f;
            }
            i3 = i4;
        }
    }

    private static void heapSort(float[] fArr, int i, int i2) {
        int i3 = (i + i2) >>> 1;
        while (i3 > i) {
            i3--;
            pushDown(fArr, i3, fArr[i3], i, i2);
        }
        while (true) {
            i2--;
            if (i2 <= i) {
                return;
            }
            float f = fArr[i];
            pushDown(fArr, i, fArr[i2], i, i2);
            fArr[i2] = f;
        }
    }

    private static void pushDown(float[] fArr, int i, float f, int i2, int i3) {
        while (true) {
            int i4 = (i << 1) - i2;
            int i5 = i4 + 2;
            if (i5 > i3) {
                break;
            }
            int i6 = (i5 == i3 || fArr[i5] < fArr[i4 + 1]) ? i4 + 1 : i5;
            float f2 = fArr[i6];
            if (f2 <= f) {
                break;
            }
            fArr[i] = f2;
            i = i6;
        }
        fArr[i] = f;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean tryMergeRuns(java8.util.DualPivotQuicksort.Sorter r12, float[] r13, int r14, int r15) {
        /*
            int r0 = r14 + r15
            int r1 = r14 + 1
            r2 = 0
            r3 = 1
            r9 = r2
            r11 = r3
            r2 = r14
        L9:
            r4 = 0
            if (r1 >= r0) goto L99
            int r5 = r1 + (-1)
            r5 = r13[r5]
            r6 = r13[r1]
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 >= 0) goto L26
        L16:
            int r5 = r1 + 1
            if (r5 >= r0) goto L24
            r1 = r13[r1]
            r6 = r13[r5]
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 > 0) goto L24
            r1 = r5
            goto L16
        L24:
            r1 = r5
            goto L5a
        L26:
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L4d
        L2a:
            int r5 = r1 + 1
            if (r5 >= r0) goto L38
            r1 = r13[r1]
            r6 = r13[r5]
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L38
            r1 = r5
            goto L2a
        L38:
            int r1 = r2 + (-1)
            r6 = r5
        L3b:
            int r1 = r1 + r3
            int r6 = r6 + (-1)
            if (r1 >= r6) goto L24
            r7 = r13[r1]
            r8 = r13[r6]
            int r10 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r10 <= 0) goto L24
            r13[r1] = r8
            r13[r6] = r7
            goto L3b
        L4d:
            int r1 = r1 + r3
            if (r1 >= r0) goto L57
            r5 = r13[r1]
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 != 0) goto L57
            goto L4d
        L57:
            if (r1 >= r0) goto L5a
            goto L9
        L5a:
            if (r9 != 0) goto L72
            if (r1 != r0) goto L5f
            return r3
        L5f:
            int r2 = r1 - r14
            r5 = 16
            if (r2 >= r5) goto L66
            return r4
        L66:
            int r2 = r15 >> 10
            r2 = r2 | 127(0x7f, float:1.78E-43)
            r2 = r2 & 1023(0x3ff, float:1.434E-42)
            int[] r2 = new int[r2]
            r2[r4] = r14
        L70:
            r9 = r2
            goto L94
        L72:
            int r5 = r2 + (-1)
            r5 = r13[r5]
            r2 = r13[r2]
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 <= 0) goto L94
            int r2 = r1 - r14
            int r2 = r2 >> 7
            if (r11 <= r2) goto L83
            return r4
        L83:
            int r11 = r11 + 1
            r2 = 5120(0x1400, float:7.175E-42)
            if (r11 != r2) goto L8a
            return r4
        L8a:
            int r2 = r9.length
            if (r11 != r2) goto L94
            int r2 = r11 << 1
            int[] r2 = java.util.Arrays.copyOf(r9, r2)
            goto L70
        L94:
            r9[r11] = r1
            r2 = r1
            goto L9
        L99:
            if (r11 <= r3) goto Lba
            if (r12 == 0) goto Lab
            java.lang.Object r0 = r12.b
            float[] r0 = (float[]) r0
            float[] r0 = (float[]) r0
            if (r0 != 0) goto La6
            goto Lab
        La6:
            int r14 = r12.offset
            r6 = r14
            r5 = r0
            goto Laf
        Lab:
            float[] r15 = new float[r15]
            r6 = r14
            r5 = r15
        Laf:
            if (r12 == 0) goto Lb3
            r8 = r3
            goto Lb4
        Lb3:
            r8 = r4
        Lb4:
            r10 = 0
            r7 = 1
            r4 = r13
            mergeRuns(r4, r5, r6, r7, r8, r9, r10, r11)
        Lba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.DualPivotQuicksort.tryMergeRuns(java8.util.DualPivotQuicksort$Sorter, float[], int, int):boolean");
    }

    static float[] mergeRuns(float[] fArr, float[] fArr2, int i, int i2, boolean z, int[] iArr, int i3, int i4) {
        int i5;
        float[] fArrMergeRuns;
        float[] fArrMergeRuns2;
        int i6 = i4 - i3;
        if (i6 == 1) {
            if (i2 >= 0) {
                return fArr;
            }
            int i7 = iArr[i4];
            int i8 = i7 - i;
            int i9 = iArr[i3];
            while (i7 > i9) {
                i8--;
                i7--;
                fArr2[i8] = fArr[i7];
            }
            return fArr2;
        }
        int i10 = i3;
        while (true) {
            i5 = i10 + 1;
            if (iArr[i10 + 2] > ((iArr[i3] + iArr[i4]) >>> 1)) {
                break;
            }
            i10 = i5;
        }
        if (z && i6 > 4) {
            java8.util.DualPivotQuicksort.RunMerger runMergerForkMe = new java8.util.DualPivotQuicksort.RunMerger(fArr, fArr2, i, 0, iArr, i5, i4).forkMe();
            float[] fArrMergeRuns3 = mergeRuns(fArr, fArr2, i, -i2, true, iArr, i3, i5);
            fArrMergeRuns2 = (float[]) runMergerForkMe.getDestination();
            fArrMergeRuns = fArrMergeRuns3;
        } else {
            fArrMergeRuns = mergeRuns(fArr, fArr2, i, -i2, false, iArr, i3, i5);
            fArrMergeRuns2 = mergeRuns(fArr, fArr2, i, 0, false, iArr, i5, i4);
        }
        float[] fArr3 = fArrMergeRuns == fArr ? fArr2 : fArr;
        int i11 = fArrMergeRuns == fArr ? iArr[i3] - i : iArr[i3];
        int i12 = fArrMergeRuns == fArr2 ? iArr[i3] - i : iArr[i3];
        int i13 = fArrMergeRuns == fArr2 ? iArr[i5] - i : iArr[i5];
        int i14 = fArrMergeRuns2 == fArr2 ? iArr[i5] - i : iArr[i5];
        int i15 = fArrMergeRuns2 == fArr2 ? iArr[i4] - i : iArr[i4];
        if (z) {
            new java8.util.DualPivotQuicksort.Merger(null, fArr3, i11, fArrMergeRuns, i12, i13, fArrMergeRuns2, i14, i15).invoke();
        } else {
            mergeParts((java8.util.DualPivotQuicksort.Merger) null, fArr3, i11, fArrMergeRuns, i12, i13, fArrMergeRuns2, i14, i15);
        }
        return fArr3;
    }

    static void mergeParts(java8.util.DualPivotQuicksort.Merger merger, float[] fArr, int i, float[] fArr2, int i2, int i3, float[] fArr3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (merger == null || fArr2 != fArr3) {
            i6 = i;
            i7 = i2;
            i8 = i3;
            i9 = i4;
            i10 = i5;
        } else {
            int i11 = i2;
            int i12 = i3;
            int i13 = i4;
            int i14 = i5;
            while (true) {
                if (i12 - i11 < i14 - i13) {
                    i9 = i11;
                    i10 = i12;
                    i7 = i13;
                    i8 = i14;
                } else {
                    i7 = i11;
                    i8 = i12;
                    i9 = i13;
                    i10 = i14;
                }
                if (i8 - i7 < 4096) {
                    break;
                }
                int i15 = (i7 + i8) >>> 1;
                float f = fArr2[i15];
                int i16 = i10;
                int i17 = i9;
                while (i17 < i16) {
                    int i18 = (i17 + i16) >>> 1;
                    if (f > fArr3[i18]) {
                        i17 = i18 + 1;
                    } else {
                        i16 = i18;
                    }
                }
                merger.forkMerger(fArr, i + (((i16 - i9) + i15) - i7), fArr2, i15, i8, fArr3, i16, i10);
                i11 = i7;
                i13 = i9;
                i12 = i15;
                i14 = i16;
            }
            i6 = i;
        }
        while (i7 < i8 && i9 < i10) {
            int i19 = i6 + 1;
            float f2 = fArr2[i7];
            float f3 = fArr3[i9];
            if (f2 < f3) {
                i7++;
            } else {
                i9++;
                f2 = f3;
            }
            fArr[i6] = f2;
            i6 = i19;
        }
        if (fArr != fArr2 || i6 < i7) {
            while (i7 < i8) {
                fArr[i6] = fArr2[i7];
                i6++;
                i7++;
            }
        }
        if (fArr != fArr3 || i6 < i9) {
            while (i9 < i10) {
                fArr[i6] = fArr3[i9];
                i6++;
                i9++;
            }
        }
    }

    static void sort(double[] dArr, int i, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        int i6 = i5;
        int i7 = 0;
        while (i5 > i4) {
            i5--;
            double d = dArr[i5];
            if (d == 0.0d && java.lang.Double.doubleToRawLongBits(d) < 0) {
                i7++;
                dArr[i5] = 0.0d;
            } else if (d != d) {
                i6--;
                dArr[i5] = dArr[i6];
                dArr[i6] = d;
            }
        }
        int i8 = i6 - i4;
        if (i > 1 && i8 > 4096) {
            int depth = getDepth(i, i8 >> 12);
            new java8.util.DualPivotQuicksort.Sorter(null, dArr, depth == 0 ? null : new double[i8], i2, i8, i2, depth).invoke();
        } else {
            sort((java8.util.DualPivotQuicksort.Sorter) null, dArr, 0, i4, i6);
        }
        int i9 = i7 + 1;
        if (i9 == 1) {
            return;
        }
        while (i4 <= i6) {
            int i10 = (i4 + i6) >>> 1;
            if (dArr[i10] < 0.0d) {
                i4 = i10 + 1;
            } else {
                i6 = i10 - 1;
            }
        }
        while (true) {
            i9--;
            if (i9 <= 0) {
                return;
            }
            i6++;
            dArr[i6] = -0.0d;
        }
    }

    static void sort(java8.util.DualPivotQuicksort.Sorter sorter, double[] dArr, int i, int i2, int i3) {
        double d;
        int i4 = i;
        int i5 = i3;
        while (true) {
            int i6 = i5 - 1;
            int i7 = i5 - i2;
            if (i7 < i4 + 65 && (i4 & 1) > 0) {
                mixedInsertionSort(dArr, i2, i5 - (((i7 >> 5) << 3) * 3), i5);
                return;
            }
            if (i7 < 44) {
                insertionSort(dArr, i2, i5);
                return;
            }
            if ((i4 == 0 || (i7 > 4096 && (i4 & 1) > 0)) && tryMergeRuns(sorter, dArr, i2, i7)) {
                return;
            }
            i4 += 6;
            if (i4 > 384) {
                heapSort(dArr, i2, i5);
                return;
            }
            int i8 = ((i7 >> 3) * 3) + 3;
            int i9 = i2 + i8;
            int i10 = i6 - i8;
            int i11 = (i9 + i10) >>> 1;
            int i12 = (i9 + i11) >>> 1;
            int i13 = (i11 + i10) >>> 1;
            double d2 = dArr[i11];
            double d3 = dArr[i10];
            double d4 = dArr[i12];
            if (d3 < d4) {
                dArr[i10] = d4;
                dArr[i12] = d3;
            }
            double d5 = dArr[i13];
            double d6 = dArr[i9];
            if (d5 < d6) {
                dArr[i13] = d6;
                dArr[i9] = d5;
            }
            double d7 = dArr[i10];
            double d8 = dArr[i13];
            if (d7 < d8) {
                dArr[i10] = d8;
                dArr[i13] = d7;
            }
            double d9 = dArr[i12];
            double d10 = dArr[i9];
            if (d9 < d10) {
                dArr[i12] = d10;
                dArr[i9] = d9;
            }
            double d11 = dArr[i13];
            double d12 = dArr[i12];
            if (d11 < d12) {
                dArr[i13] = d12;
                dArr[i12] = d11;
            }
            double d13 = dArr[i12];
            if (d2 >= d13) {
                double d14 = dArr[i13];
                if (d2 > d14) {
                    if (d2 > dArr[i10]) {
                        dArr[i11] = d14;
                        dArr[i13] = dArr[i10];
                        dArr[i10] = d2;
                    } else {
                        dArr[i11] = d14;
                        dArr[i13] = d2;
                    }
                }
            } else if (d2 < dArr[i9]) {
                dArr[i11] = d13;
                dArr[i12] = dArr[i9];
                dArr[i9] = d2;
            } else {
                dArr[i11] = d13;
                dArr[i12] = d2;
            }
            double d15 = dArr[i9];
            double d16 = dArr[i12];
            if (d15 < d16) {
                double d17 = dArr[i11];
                if (d16 < d17) {
                    double d18 = dArr[i13];
                    if (d17 < d18) {
                        double d19 = dArr[i10];
                        if (d18 < d19) {
                            dArr[i9] = dArr[i2];
                            dArr[i10] = dArr[i6];
                            int i14 = i2;
                            while (true) {
                                int i15 = i14 + 1;
                                if (dArr[i15] >= d15) {
                                    break;
                                } else {
                                    i14 = i15;
                                }
                            }
                            int i16 = i6;
                            while (true) {
                                int i17 = i16 - 1;
                                if (dArr[i17] <= d19) {
                                    break;
                                } else {
                                    i16 = i17;
                                }
                            }
                            int i18 = i16;
                            while (true) {
                                i16--;
                                if (i16 <= i14) {
                                    break;
                                }
                                double d20 = dArr[i16];
                                if (d20 < d15) {
                                    while (true) {
                                        if (i14 < i16) {
                                            i14++;
                                            double d21 = dArr[i14];
                                            if (d21 >= d15) {
                                                if (d21 > d19) {
                                                    i18--;
                                                    dArr[i16] = dArr[i18];
                                                    dArr[i18] = dArr[i14];
                                                } else {
                                                    dArr[i16] = d21;
                                                }
                                                dArr[i14] = d20;
                                            }
                                        }
                                    }
                                } else if (d20 > d19) {
                                    i18--;
                                    dArr[i16] = dArr[i18];
                                    dArr[i18] = d20;
                                }
                            }
                            dArr[i2] = dArr[i14];
                            dArr[i14] = d15;
                            dArr[i6] = dArr[i18];
                            dArr[i18] = d19;
                            if (i7 > 4096 && sorter != null) {
                                int i19 = i4 | 1;
                                sorter.forkSorter(i19, i14 + 1, i18);
                                sorter.forkSorter(i19, i18 + 1, i5);
                            } else {
                                int i20 = i4 | 1;
                                sort(sorter, dArr, i20, i14 + 1, i18);
                                sort(sorter, dArr, i20, i18 + 1, i5);
                            }
                            i5 = i14;
                        }
                    }
                }
            }
            double d22 = dArr[i11];
            dArr[i11] = dArr[i2];
            int i21 = i2;
            int i22 = i5;
            int i23 = i22;
            while (true) {
                i22--;
                if (i22 <= i21) {
                    break;
                }
                double d23 = dArr[i22];
                if (d23 != d22) {
                    dArr[i22] = d22;
                    if (d23 < d22) {
                        do {
                            i21++;
                            d = dArr[i21];
                        } while (d < d22);
                        if (d > d22) {
                            i23--;
                            dArr[i23] = d;
                        }
                        dArr[i21] = d23;
                    } else {
                        i23--;
                        dArr[i23] = d23;
                    }
                }
            }
            dArr[i2] = dArr[i21];
            dArr[i21] = d22;
            if (i7 > 4096 && sorter != null) {
                sorter.forkSorter(i4 | 1, i23, i5);
            } else {
                sort(sorter, dArr, i4 | 1, i23, i5);
            }
            i5 = i21;
        }
    }

    private static void mixedInsertionSort(double[] dArr, int i, int i2, int i3) {
        int i4;
        double d;
        int i5;
        if (i2 != i3) {
            double d2 = dArr[i2];
            int i6 = i3;
            while (true) {
                i4 = i + 1;
                if (i4 >= i2) {
                    break;
                }
                double d3 = dArr[i4];
                if (d3 < dArr[i]) {
                    dArr[i4] = dArr[i];
                    while (true) {
                        int i7 = i - 1;
                        double d4 = dArr[i7];
                        if (d3 >= d4) {
                            break;
                        }
                        dArr[i] = d4;
                        i = i7;
                    }
                    dArr[i] = d3;
                } else if (i6 > i4 && d3 > d2) {
                    do {
                        i6--;
                        d = dArr[i6];
                    } while (d > d2);
                    if (i6 > i4) {
                        dArr[i6] = dArr[i4];
                        i5 = i4;
                        d3 = d;
                    } else {
                        i5 = i4;
                    }
                    while (true) {
                        int i8 = i5 - 1;
                        double d5 = dArr[i8];
                        if (d3 >= d5) {
                            break;
                        }
                        dArr[i5] = d5;
                        i5 = i8;
                    }
                    dArr[i5] = d3;
                }
                i = i4;
            }
            while (i4 < i3) {
                double d6 = dArr[i4];
                double d7 = dArr[i4 + 1];
                if (d6 > d7) {
                    int i9 = i4;
                    while (true) {
                        int i10 = i9 - 1;
                        double d8 = dArr[i10];
                        if (d6 >= d8) {
                            break;
                        }
                        dArr[i9 + 1] = d8;
                        i9 = i10;
                    }
                    dArr[i9 + 1] = d6;
                    while (true) {
                        int i11 = i9 - 1;
                        double d9 = dArr[i11];
                        if (d7 >= d9) {
                            break;
                        }
                        dArr[i9] = d9;
                        i9 = i11;
                    }
                    dArr[i9] = d7;
                } else if (d6 < dArr[i4 - 1]) {
                    int i12 = i4;
                    while (true) {
                        int i13 = i12 - 1;
                        double d10 = dArr[i13];
                        if (d7 >= d10) {
                            break;
                        }
                        dArr[i12 + 1] = d10;
                        i12 = i13;
                    }
                    dArr[i12 + 1] = d7;
                    while (true) {
                        int i14 = i12 - 1;
                        double d11 = dArr[i14];
                        if (d6 >= d11) {
                            break;
                        }
                        dArr[i12] = d11;
                        i12 = i14;
                    }
                    dArr[i12] = d6;
                }
                i4 += 2;
            }
            return;
        }
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            double d12 = dArr[i];
            int i15 = i;
            while (true) {
                int i16 = i15 - 1;
                double d13 = dArr[i16];
                if (d12 < d13) {
                    dArr[i15] = d13;
                    i15 = i16;
                }
            }
            dArr[i15] = d12;
        }
    }

    private static void insertionSort(double[] dArr, int i, int i2) {
        int i3 = i;
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= i2) {
                return;
            }
            double d = dArr[i4];
            if (d < dArr[i3]) {
                int i5 = i4;
                while (true) {
                    int i6 = i5 - 1;
                    if (i6 < i) {
                        break;
                    }
                    double d2 = dArr[i6];
                    if (d >= d2) {
                        break;
                    }
                    dArr[i5] = d2;
                    i5 = i6;
                }
                dArr[i5] = d;
            }
            i3 = i4;
        }
    }

    private static void heapSort(double[] dArr, int i, int i2) {
        int i3 = (i + i2) >>> 1;
        while (i3 > i) {
            i3--;
            pushDown(dArr, i3, dArr[i3], i, i2);
        }
        while (true) {
            i2--;
            if (i2 <= i) {
                return;
            }
            double d = dArr[i];
            pushDown(dArr, i, dArr[i2], i, i2);
            dArr[i2] = d;
        }
    }

    private static void pushDown(double[] dArr, int i, double d, int i2, int i3) {
        while (true) {
            int i4 = (i << 1) - i2;
            int i5 = i4 + 2;
            if (i5 > i3) {
                break;
            }
            int i6 = (i5 == i3 || dArr[i5] < dArr[i4 + 1]) ? i4 + 1 : i5;
            double d2 = dArr[i6];
            if (d2 <= d) {
                break;
            }
            dArr[i] = d2;
            i = i6;
        }
        dArr[i] = d;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean tryMergeRuns(java8.util.DualPivotQuicksort.Sorter r17, double[] r18, int r19, int r20) {
        /*
            r0 = r17
            r1 = r20
            int r2 = r19 + r1
            int r3 = r19 + 1
            r4 = 0
            r8 = 1
            r5 = r4
            r7 = r8
            r4 = r19
        Le:
            r6 = 0
            if (r3 >= r2) goto L9c
            int r9 = r3 + (-1)
            r9 = r18[r9]
            r11 = r18[r3]
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L2b
        L1b:
            int r9 = r3 + 1
            if (r9 >= r2) goto L29
            r10 = r18[r3]
            r12 = r18[r9]
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 > 0) goto L29
            r3 = r9
            goto L1b
        L29:
            r3 = r9
            goto L5f
        L2b:
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L52
        L2f:
            int r9 = r3 + 1
            if (r9 >= r2) goto L3d
            r10 = r18[r3]
            r12 = r18[r9]
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 < 0) goto L3d
            r3 = r9
            goto L2f
        L3d:
            int r3 = r4 + (-1)
            r10 = r9
        L40:
            int r3 = r3 + r8
            int r10 = r10 + (-1)
            if (r3 >= r10) goto L29
            r11 = r18[r3]
            r13 = r18[r10]
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L29
            r18[r3] = r13
            r18[r10] = r11
            goto L40
        L52:
            int r3 = r3 + r8
            if (r3 >= r2) goto L5c
            r9 = r18[r3]
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 != 0) goto L5c
            goto L52
        L5c:
            if (r3 >= r2) goto L5f
            goto Le
        L5f:
            if (r5 != 0) goto L76
            if (r3 != r2) goto L64
            return r8
        L64:
            int r4 = r3 - r19
            r5 = 16
            if (r4 >= r5) goto L6b
            return r6
        L6b:
            int r4 = r1 >> 10
            r4 = r4 | 127(0x7f, float:1.78E-43)
            r4 = r4 & 1023(0x3ff, float:1.434E-42)
            int[] r5 = new int[r4]
            r5[r6] = r19
            goto L97
        L76:
            int r9 = r4 + (-1)
            r9 = r18[r9]
            r11 = r18[r4]
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 <= 0) goto L97
            int r4 = r3 - r19
            int r4 = r4 >> 7
            if (r7 <= r4) goto L87
            return r6
        L87:
            int r7 = r7 + 1
            r4 = 5120(0x1400, float:7.175E-42)
            if (r7 != r4) goto L8e
            return r6
        L8e:
            int r4 = r5.length
            if (r7 != r4) goto L97
            int r4 = r7 << 1
            int[] r5 = java.util.Arrays.copyOf(r5, r4)
        L97:
            r5[r7] = r3
            r4 = r3
            goto Le
        L9c:
            if (r7 <= r8) goto Lc1
            if (r0 == 0) goto Lb1
            java.lang.Object r2 = r0.b
            double[] r2 = (double[]) r2
            double[] r2 = (double[]) r2
            if (r2 != 0) goto La9
            goto Lb1
        La9:
            int r1 = r0.offset
            r16 = r2
            r2 = r1
            r1 = r16
            goto Lb5
        Lb1:
            double[] r1 = new double[r1]
            r2 = r19
        Lb5:
            if (r0 == 0) goto Lb9
            r4 = r8
            goto Lba
        Lb9:
            r4 = r6
        Lba:
            r6 = 0
            r3 = 1
            r0 = r18
            mergeRuns(r0, r1, r2, r3, r4, r5, r6, r7)
        Lc1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: java8.util.DualPivotQuicksort.tryMergeRuns(java8.util.DualPivotQuicksort$Sorter, double[], int, int):boolean");
    }

    static double[] mergeRuns(double[] dArr, double[] dArr2, int i, int i2, boolean z, int[] iArr, int i3, int i4) {
        int i5;
        double[] dArrMergeRuns;
        double[] dArrMergeRuns2;
        int i6 = i4 - i3;
        if (i6 == 1) {
            if (i2 >= 0) {
                return dArr;
            }
            int i7 = iArr[i4];
            int i8 = i7 - i;
            int i9 = iArr[i3];
            while (i7 > i9) {
                i8--;
                i7--;
                dArr2[i8] = dArr[i7];
            }
            return dArr2;
        }
        int i10 = i3;
        while (true) {
            i5 = i10 + 1;
            if (iArr[i10 + 2] > ((iArr[i3] + iArr[i4]) >>> 1)) {
                break;
            }
            i10 = i5;
        }
        if (z && i6 > 4) {
            java8.util.DualPivotQuicksort.RunMerger runMergerForkMe = new java8.util.DualPivotQuicksort.RunMerger(dArr, dArr2, i, 0, iArr, i5, i4).forkMe();
            double[] dArrMergeRuns3 = mergeRuns(dArr, dArr2, i, -i2, true, iArr, i3, i5);
            dArrMergeRuns2 = (double[]) runMergerForkMe.getDestination();
            dArrMergeRuns = dArrMergeRuns3;
        } else {
            dArrMergeRuns = mergeRuns(dArr, dArr2, i, -i2, false, iArr, i3, i5);
            dArrMergeRuns2 = mergeRuns(dArr, dArr2, i, 0, false, iArr, i5, i4);
        }
        double[] dArr3 = dArrMergeRuns == dArr ? dArr2 : dArr;
        int i11 = dArrMergeRuns == dArr ? iArr[i3] - i : iArr[i3];
        int i12 = dArrMergeRuns == dArr2 ? iArr[i3] - i : iArr[i3];
        int i13 = dArrMergeRuns == dArr2 ? iArr[i5] - i : iArr[i5];
        int i14 = dArrMergeRuns2 == dArr2 ? iArr[i5] - i : iArr[i5];
        int i15 = dArrMergeRuns2 == dArr2 ? iArr[i4] - i : iArr[i4];
        if (z) {
            new java8.util.DualPivotQuicksort.Merger(null, dArr3, i11, dArrMergeRuns, i12, i13, dArrMergeRuns2, i14, i15).invoke();
        } else {
            mergeParts((java8.util.DualPivotQuicksort.Merger) null, dArr3, i11, dArrMergeRuns, i12, i13, dArrMergeRuns2, i14, i15);
        }
        return dArr3;
    }

    static void mergeParts(java8.util.DualPivotQuicksort.Merger merger, double[] dArr, int i, double[] dArr2, int i2, int i3, double[] dArr3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        if (merger == null || dArr2 != dArr3) {
            i6 = i;
            i7 = i2;
            i8 = i3;
            i9 = i4;
            i10 = i5;
        } else {
            int i11 = i2;
            int i12 = i3;
            int i13 = i4;
            int i14 = i5;
            while (true) {
                if (i12 - i11 < i14 - i13) {
                    i9 = i11;
                    i10 = i12;
                    i7 = i13;
                    i8 = i14;
                } else {
                    i7 = i11;
                    i8 = i12;
                    i9 = i13;
                    i10 = i14;
                }
                if (i8 - i7 < 4096) {
                    break;
                }
                int i15 = (i7 + i8) >>> 1;
                double d = dArr2[i15];
                int i16 = i10;
                int i17 = i9;
                while (i17 < i16) {
                    int i18 = (i17 + i16) >>> 1;
                    if (d > dArr3[i18]) {
                        i17 = i18 + 1;
                    } else {
                        i16 = i18;
                    }
                }
                merger.forkMerger(dArr, i + (((i16 - i9) + i15) - i7), dArr2, i15, i8, dArr3, i16, i10);
                i11 = i7;
                i13 = i9;
                i12 = i15;
                i14 = i16;
            }
            i6 = i;
        }
        while (i7 < i8 && i9 < i10) {
            int i19 = i6 + 1;
            double d2 = dArr2[i7];
            double d3 = dArr3[i9];
            if (d2 < d3) {
                i7++;
            } else {
                i9++;
                d2 = d3;
            }
            dArr[i6] = d2;
            i6 = i19;
        }
        if (dArr != dArr2 || i6 < i7) {
            while (i7 < i8) {
                dArr[i6] = dArr2[i7];
                i6++;
                i7++;
            }
        }
        if (dArr != dArr3 || i6 < i9) {
            while (i9 < i10) {
                dArr[i6] = dArr3[i9];
                i6++;
                i9++;
            }
        }
    }

    private static final class Sorter extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        private static final long serialVersionUID = 20180818;
        final java.lang.Object a;
        final java.lang.Object b;
        final int depth;
        final int low;
        final int offset;
        final int size;

        Sorter(java8.util.concurrent.CountedCompleter<?> countedCompleter, java.lang.Object obj, java.lang.Object obj2, int i, int i2, int i3, int i4) {
            super(countedCompleter);
            this.a = obj;
            this.b = obj2;
            this.low = i;
            this.size = i2;
            this.offset = i3;
            this.depth = i4;
        }

        @Override // java8.util.concurrent.CountedCompleter
        public final void compute() {
            int i = this.depth;
            if (i < 0) {
                setPendingCount(2);
                int i2 = this.size >> 1;
                new java8.util.DualPivotQuicksort.Sorter(this, this.b, this.a, this.low, i2, this.offset, this.depth + 1).fork();
                new java8.util.DualPivotQuicksort.Sorter(this, this.b, this.a, this.low + i2, this.size - i2, this.offset, this.depth + 1).compute();
            } else {
                java.lang.Object obj = this.a;
                if (obj instanceof int[]) {
                    int i3 = this.low;
                    java8.util.DualPivotQuicksort.sort(this, (int[]) obj, i, i3, this.size + i3);
                } else if (obj instanceof long[]) {
                    int i4 = this.low;
                    java8.util.DualPivotQuicksort.sort(this, (long[]) obj, i, i4, this.size + i4);
                } else if (obj instanceof float[]) {
                    int i5 = this.low;
                    java8.util.DualPivotQuicksort.sort(this, (float[]) obj, i, i5, this.size + i5);
                } else if (obj instanceof double[]) {
                    int i6 = this.low;
                    java8.util.DualPivotQuicksort.sort(this, (double[]) obj, i, i6, this.size + i6);
                } else {
                    throw new java.lang.IllegalArgumentException("Unknown type of array: " + this.a.getClass().getName());
                }
            }
            tryComplete();
        }

        @Override // java8.util.concurrent.CountedCompleter
        public final void onCompletion(java8.util.concurrent.CountedCompleter<?> countedCompleter) {
            int i = this.depth;
            if (i < 0) {
                int i2 = this.low + (this.size >> 1);
                boolean z = (i & 1) == 0;
                java.lang.Object obj = this.a;
                int i3 = this.low;
                if (!z) {
                    i3 -= this.offset;
                }
                int i4 = i3;
                java.lang.Object obj2 = this.b;
                int i5 = this.low;
                if (z) {
                    i5 -= this.offset;
                }
                int i6 = i5;
                int i7 = z ? i2 - this.offset : i2;
                if (z) {
                    i2 -= this.offset;
                }
                int i8 = i2;
                int i9 = this.low + this.size;
                if (z) {
                    i9 -= this.offset;
                }
                new java8.util.DualPivotQuicksort.Merger(null, obj, i4, obj2, i6, i7, obj2, i8, i9).invoke();
            }
        }

        void forkSorter(int i, int i2, int i3) {
            addToPendingCount(1);
            new java8.util.DualPivotQuicksort.Sorter(this, this.a, this.b, i2, i3 - i2, this.offset, i).fork();
        }
    }

    private static final class Merger extends java8.util.concurrent.CountedCompleter<java.lang.Void> {
        private static final long serialVersionUID = 20180818;
        private final java.lang.Object a1;
        private final java.lang.Object a2;
        private final java.lang.Object dst;
        private final int hi1;
        private final int hi2;
        private final int k;
        private final int lo1;
        private final int lo2;

        Merger(java8.util.concurrent.CountedCompleter<?> countedCompleter, java.lang.Object obj, int i, java.lang.Object obj2, int i2, int i3, java.lang.Object obj3, int i4, int i5) {
            super(countedCompleter);
            this.dst = obj;
            this.k = i;
            this.a1 = obj2;
            this.lo1 = i2;
            this.hi1 = i3;
            this.a2 = obj3;
            this.lo2 = i4;
            this.hi2 = i5;
        }

        @Override // java8.util.concurrent.CountedCompleter
        public final void compute() {
            java.lang.Object obj = this.dst;
            if (obj instanceof int[]) {
                java8.util.DualPivotQuicksort.mergeParts(this, (int[]) obj, this.k, (int[]) this.a1, this.lo1, this.hi1, (int[]) this.a2, this.lo2, this.hi2);
            } else if (obj instanceof long[]) {
                java8.util.DualPivotQuicksort.mergeParts(this, (long[]) obj, this.k, (long[]) this.a1, this.lo1, this.hi1, (long[]) this.a2, this.lo2, this.hi2);
            } else if (obj instanceof float[]) {
                java8.util.DualPivotQuicksort.mergeParts(this, (float[]) obj, this.k, (float[]) this.a1, this.lo1, this.hi1, (float[]) this.a2, this.lo2, this.hi2);
            } else if (obj instanceof double[]) {
                java8.util.DualPivotQuicksort.mergeParts(this, (double[]) obj, this.k, (double[]) this.a1, this.lo1, this.hi1, (double[]) this.a2, this.lo2, this.hi2);
            } else {
                throw new java.lang.IllegalArgumentException("Unknown type of array: " + this.dst.getClass().getName());
            }
            propagateCompletion();
        }

        void forkMerger(java.lang.Object obj, int i, java.lang.Object obj2, int i2, int i3, java.lang.Object obj3, int i4, int i5) {
            addToPendingCount(1);
            new java8.util.DualPivotQuicksort.Merger(this, obj, i, obj2, i2, i3, obj3, i4, i5).fork();
        }
    }

    private static final class RunMerger extends java8.util.concurrent.RecursiveTask<java.lang.Object> {
        private static final long serialVersionUID = 20180818;
        private final java.lang.Object a;
        private final int aim;
        private final java.lang.Object b;
        private final int hi;
        private final int lo;
        private final int offset;
        private final int[] run;

        RunMerger(java.lang.Object obj, java.lang.Object obj2, int i, int i2, int[] iArr, int i3, int i4) {
            this.a = obj;
            this.b = obj2;
            this.offset = i;
            this.aim = i2;
            this.run = iArr;
            this.lo = i3;
            this.hi = i4;
        }

        @Override // java8.util.concurrent.RecursiveTask
        protected final java.lang.Object compute() {
            java.lang.Object obj = this.a;
            if (obj instanceof int[]) {
                return java8.util.DualPivotQuicksort.mergeRuns((int[]) obj, (int[]) this.b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            if (obj instanceof long[]) {
                return java8.util.DualPivotQuicksort.mergeRuns((long[]) obj, (long[]) this.b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            if (obj instanceof float[]) {
                return java8.util.DualPivotQuicksort.mergeRuns((float[]) obj, (float[]) this.b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            if (obj instanceof double[]) {
                return java8.util.DualPivotQuicksort.mergeRuns((double[]) obj, (double[]) this.b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            throw new java.lang.IllegalArgumentException("Unknown type of array: " + this.a.getClass().getName());
        }

        java8.util.DualPivotQuicksort.RunMerger forkMe() {
            fork();
            return this;
        }

        java.lang.Object getDestination() {
            join();
            return getRawResult();
        }
    }
}
