package com.up366.qmui.widget.section;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIDefaultStickySectionAdapter<H extends com.up366.qmui.widget.section.QMUISection.Model<H>, T extends com.up366.qmui.widget.section.QMUISection.Model<T>> extends com.up366.qmui.widget.section.QMUIStickySectionAdapter<H, T, com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder> {
    @Override // com.up366.qmui.widget.section.QMUIStickySectionAdapter
    protected com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder onCreateSectionLoadingViewHolder(android.view.ViewGroup viewGroup) {
        return new com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder(new android.view.View(viewGroup.getContext()));
    }

    @Override // com.up366.qmui.widget.section.QMUIStickySectionAdapter
    protected com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder onCreateCustomItemViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder(new android.view.View(viewGroup.getContext()));
    }
}
