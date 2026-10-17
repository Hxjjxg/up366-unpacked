package com.up366.qmui.widget.tab;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITabAdapter extends com.up366.qmui.widget.QMUIItemViewsAdapter<com.up366.qmui.widget.tab.QMUITab, com.up366.qmui.widget.tab.QMUITabView> implements com.up366.qmui.widget.tab.QMUITabView.Callback {
    private com.up366.qmui.widget.tab.QMUIBasicTabSegment mTabSegment;

    @Override // com.up366.qmui.widget.tab.QMUITabView.Callback
    public void onLongClick(com.up366.qmui.widget.tab.QMUITabView qMUITabView) {
    }

    public QMUITabAdapter(com.up366.qmui.widget.tab.QMUIBasicTabSegment qMUIBasicTabSegment, android.view.ViewGroup viewGroup) {
        super(viewGroup);
        this.mTabSegment = qMUIBasicTabSegment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.up366.qmui.widget.QMUIItemViewsAdapter
    public com.up366.qmui.widget.tab.QMUITabView createView(android.view.ViewGroup viewGroup) {
        return new com.up366.qmui.widget.tab.QMUITabView(viewGroup.getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.up366.qmui.widget.QMUIItemViewsAdapter
    public final void bind(com.up366.qmui.widget.tab.QMUITab qMUITab, com.up366.qmui.widget.tab.QMUITabView qMUITabView, int i) {
        onBindTab(qMUITab, qMUITabView, i);
        qMUITabView.setCallback(this);
    }

    protected void onBindTab(com.up366.qmui.widget.tab.QMUITab qMUITab, com.up366.qmui.widget.tab.QMUITabView qMUITabView, int i) {
        qMUITabView.bind(qMUITab);
    }

    @Override // com.up366.qmui.widget.tab.QMUITabView.Callback
    public void onClick(com.up366.qmui.widget.tab.QMUITabView qMUITabView) {
        this.mTabSegment.onClickTab(getViews().indexOf(qMUITabView));
    }

    @Override // com.up366.qmui.widget.tab.QMUITabView.Callback
    public void onDoubleClick(com.up366.qmui.widget.tab.QMUITabView qMUITabView) {
        this.mTabSegment.onDoubleClick(getViews().indexOf(qMUITabView));
    }
}
