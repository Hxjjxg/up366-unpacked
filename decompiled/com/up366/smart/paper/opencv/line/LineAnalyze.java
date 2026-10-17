package com.up366.smart.paper.opencv.line;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LineAnalyze {
    private static final java.lang.String TAG = "LineAnalyze";

    public static com.up366.smart.paper.BitmapAnalyzeResult analyze(java.util.List<com.up366.smart.paper.opencv.line.Line> lines, int width, int height) {
        com.up366.smart.paper.opencv.line.TwoLine twoLine;
        java.util.ArrayList<com.up366.smart.paper.opencv.line.TwoLine> arrayList = new java.util.ArrayList();
        for (com.up366.smart.paper.opencv.line.Line line : lines) {
            arrayList.add(new com.up366.smart.paper.opencv.line.TwoLine(line, com.up366.smart.paper.opencv.line.LineUtil.lineExtend(line, width, height)));
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.smart.paper.DrawLinesEvent(arrayList));
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (com.up366.smart.paper.opencv.line.TwoLine twoLine2 : arrayList) {
            if (!twoLine2.extendLine.oblique()) {
                java.util.Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        twoLine = null;
                        break;
                    }
                    twoLine = (com.up366.smart.paper.opencv.line.TwoLine) it.next();
                    if (com.up366.smart.paper.opencv.line.LineUtil.lineNear(twoLine2.extendLine, twoLine.extendLine, width, height)) {
                        break;
                    }
                }
                if (twoLine == null) {
                    arrayList2.add(twoLine2);
                }
            }
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        int i = 0;
        while (i < arrayList2.size() - 1) {
            com.up366.smart.paper.opencv.line.TwoLine twoLine3 = (com.up366.smart.paper.opencv.line.TwoLine) arrayList2.get(i);
            i++;
            for (int i2 = i; i2 < arrayList2.size(); i2++) {
                com.up366.smart.paper.opencv.line.TwoLine twoLine4 = (com.up366.smart.paper.opencv.line.TwoLine) arrayList2.get(i2);
                org.opencv.core.Point pointLineIntersection = com.up366.smart.paper.opencv.line.LineUtil.lineIntersection(twoLine3.extendLine, twoLine4.extendLine, width, height);
                if (pointLineIntersection != null) {
                    java.util.Iterator it2 = arrayList3.iterator();
                    boolean z = true;
                    while (it2.hasNext()) {
                        if (com.up366.smart.paper.opencv.preprocessed.PointUtil.pointsDistance(((com.up366.smart.paper.opencv.line.PointLine) it2.next()).point, pointLineIntersection) < 40.0d) {
                            z = false;
                        }
                    }
                    if (z) {
                        com.up366.smart.paper.opencv.line.PointLine pointLine = new com.up366.smart.paper.opencv.line.PointLine(pointLineIntersection, twoLine3, twoLine4);
                        double dPointAngle = pointLine.pointAngle();
                        if (dPointAngle > 70.0d || dPointAngle < 110.0d) {
                            arrayList3.add(pointLine);
                        }
                    }
                }
            }
        }
        return analyzeSelectPoints(arrayList3, width, height);
    }

    public static com.up366.smart.paper.BitmapAnalyzeResult analyzeSelectPoints(java.util.List<com.up366.smart.paper.opencv.line.PointLine> pointLines, int width, int height) {
        com.up366.smart.paper.BitmapAnalyzeResult bitmapAnalyzeResult = new com.up366.smart.paper.BitmapAnalyzeResult();
        int size = pointLines.size();
        if (size == 4) {
            if (isQuadrilateral(pointLines)) {
                com.up366.smart.paper.opencv.line.Quadrilateral quadrilateral = new com.up366.smart.paper.opencv.line.Quadrilateral();
                quadrilateral.add(pointLines);
                setAnalyzeResultInfo(bitmapAnalyzeResult, quadrilateral, width, height);
            }
        } else if (size > 4 && size < 8) {
            org.opencv.core.Point point = new org.opencv.core.Point(width / 2, height / 2);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.up366.smart.paper.opencv.line.PointLine pointLine : pointLines) {
                com.up366.smart.paper.opencv.line.TwoLine twoLine = pointLine.firstTwoLine;
                com.up366.smart.paper.opencv.line.TwoLine twoLine2 = pointLine.secondTwoLine;
                java.util.ArrayList<com.up366.smart.paper.opencv.line.PointLine> arrayList2 = new java.util.ArrayList();
                java.util.ArrayList<com.up366.smart.paper.opencv.line.PointLine> arrayList3 = new java.util.ArrayList();
                for (com.up366.smart.paper.opencv.line.PointLine pointLine2 : pointLines) {
                    if (!pointLine.equals(pointLine2)) {
                        if (twoLine.equals(pointLine2.firstTwoLine) || twoLine.equals(pointLine2.secondTwoLine)) {
                            arrayList2.add(pointLine2);
                        } else if (twoLine2.equals(pointLine2.firstTwoLine) || twoLine2.equals(pointLine2.secondTwoLine)) {
                            arrayList3.add(pointLine2);
                        }
                    }
                }
                if (arrayList2.size() > 0 && arrayList3.size() > 0) {
                    for (com.up366.smart.paper.opencv.line.PointLine pointLine3 : arrayList2) {
                        java.util.ArrayList arrayList4 = new java.util.ArrayList();
                        arrayList4.add(pointLine);
                        arrayList4.add(pointLine3);
                        for (com.up366.smart.paper.opencv.line.PointLine pointLine4 : arrayList3) {
                            arrayList4.add(pointLine4);
                            for (com.up366.smart.paper.opencv.line.PointLine pointLine5 : pointLines) {
                                if (!pointLine5.equals(pointLine) && !pointLine5.equals(pointLine3) && !pointLine5.equals(pointLine4)) {
                                    arrayList4.add(pointLine5);
                                    if (isQuadrilateral(arrayList4)) {
                                        com.up366.smart.paper.opencv.line.Quadrilateral quadrilateral2 = new com.up366.smart.paper.opencv.line.Quadrilateral();
                                        quadrilateral2.add(arrayList4);
                                        java.util.Iterator it = arrayList.iterator();
                                        boolean z = true;
                                        while (it.hasNext()) {
                                            if (((com.up366.smart.paper.opencv.line.Quadrilateral) it.next()).sameQuadrilateral(quadrilateral2)) {
                                                z = false;
                                            }
                                        }
                                        if (z) {
                                            arrayList.add(quadrilateral2);
                                        }
                                    } else {
                                        arrayList4.remove(pointLine5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (arrayList.size() == 1) {
                setAnalyzeResultInfo(bitmapAnalyzeResult, (com.up366.smart.paper.opencv.line.Quadrilateral) arrayList.get(0), width, height);
            } else if (arrayList.size() > 1) {
                java.util.Collections.sort(arrayList, new java.util.Comparator() { // from class: com.up366.smart.paper.opencv.line.LineAnalyze$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.smart.paper.opencv.line.LineAnalyze.lambda$analyzeSelectPoints$0((com.up366.smart.paper.opencv.line.Quadrilateral) obj, (com.up366.smart.paper.opencv.line.Quadrilateral) obj2);
                    }
                });
                java.util.Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (!((com.up366.smart.paper.opencv.line.Quadrilateral) it2.next()).containCenterPoint(point)) {
                        it2.remove();
                    }
                }
                if (arrayList.size() < 1) {
                    return bitmapAnalyzeResult;
                }
                setAnalyzeResultInfo(bitmapAnalyzeResult, (com.up366.smart.paper.opencv.line.Quadrilateral) arrayList.get(0), width, height);
            }
        }
        return bitmapAnalyzeResult;
    }

    static /* synthetic */ int lambda$analyzeSelectPoints$0(com.up366.smart.paper.opencv.line.Quadrilateral quadrilateral, com.up366.smart.paper.opencv.line.Quadrilateral quadrilateral2) {
        return quadrilateral.triangleArea() > quadrilateral2.triangleArea() ? 1 : -1;
    }

    public static void setAnalyzeResultInfo(com.up366.smart.paper.BitmapAnalyzeResult analyzeResult, com.up366.smart.paper.opencv.line.Quadrilateral q, int width, int height) {
        q.checkArea(width, height);
        analyzeResult.setAreaRatio(q.getAreaRatio());
        analyzeResult.setAllowArea(q.isAllowArea());
        java.util.Iterator<com.up366.smart.paper.opencv.line.PointLine> it = q.getPointLines().iterator();
        while (it.hasNext()) {
            analyzeResult.addPoint(it.next().point);
        }
    }

    public static boolean isQuadrilateral(java.util.List<com.up366.smart.paper.opencv.line.PointLine> pointLines) {
        if (pointLines.size() != 4) {
            return false;
        }
        for (int i = 0; i < pointLines.size(); i++) {
            com.up366.smart.paper.opencv.line.PointLine pointLine = pointLines.get(i);
            java.lang.Object obj = null;
            com.up366.smart.paper.opencv.line.PointLine pointLine2 = null;
            for (int i2 = 0; i2 < pointLines.size(); i2++) {
                if (i != i2) {
                    com.up366.smart.paper.opencv.line.PointLine pointLine3 = pointLines.get(i2);
                    if (pointLine.firstTwoLine.equals(pointLine3.firstTwoLine) || pointLine.firstTwoLine.equals(pointLine3.secondTwoLine)) {
                        obj = pointLine3;
                    } else if (pointLine.secondTwoLine.equals(pointLine3.firstTwoLine) || pointLine.secondTwoLine.equals(pointLine3.secondTwoLine)) {
                        pointLine2 = pointLine3;
                    }
                }
            }
            if (obj == null || pointLine2 == null || obj.equals(pointLine2)) {
                return false;
            }
        }
        return true;
    }
}
