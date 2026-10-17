package com.up366.mobile.course.count;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CountFragment extends com.up366.mobile.common.base.BaseFragment {
    private com.up366.mobile.databinding.CountFragmentBinding b;
    private com.up366.mobile.course.count.CountActivity context;
    private com.up366.mobile.course.count.HtmlCountFragment curHtmlCountFragment;
    private java.util.Stack<com.up366.mobile.course.count.HtmlCountFragment> stackFragment = new java.util.Stack<>();
    public com.up366.mobile.course.count.CountFragment.ICallMainFragment iCallMainFragment = new com.up366.mobile.course.count.CountFragment.AnonymousClass1();

    public interface ICallMainFragment {
        boolean closePage();

        void dismissProgressDialog();

        com.up366.mobile.book.model.BookInfoStudy getBookInfo();

        com.up366.mobile.course.count.HtmlCountFragment getCurHtmlFragment();

        void openNewPage(java.lang.String str);

        void setContentView(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView);

        void setEnable(boolean z);

        void showLoading(boolean z);

        void updateTitle(java.lang.String str, int i);
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.context = getActivity();
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.b = (com.up366.mobile.databinding.CountFragmentBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.count_fragment, viewGroup, false);
        initView();
        initViewData();
        return this.b.getRoot();
    }

    private void initViewData() {
        this.curHtmlCountFragment = new com.up366.mobile.course.count.HtmlCountFragment();
        getChildFragmentManager().beginTransaction().replace(com.up366.mobile.R.id.count_html_content, this.curHtmlCountFragment).commitAllowingStateLoss();
        this.iCallMainFragment.showLoading(true);
    }

    private void initView() {
        this.b.titleBar.binding.rightText.setVisibility(8);
        this.b.titleBar.setTitle(this.context.book.getBookName());
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.count.CountFragment$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() throws java.lang.Exception {
        com.up366.mobile.course.count.HtmlCountJSInterface htmlCountJSInterface = this.curHtmlCountFragment.jsInterface;
        if (htmlCountJSInterface != null) {
            this.iCallMainFragment.showLoading(true);
            htmlCountJSInterface.callJSMethod("onCourseBookListRefreshed()");
        }
    }

    public boolean handleBack() {
        return this.iCallMainFragment.closePage();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.count.CountFragment$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.mobile.course.count.CountFragment.ICallMainFragment {
        AnonymousClass1() {
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public void setContentView(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
            com.up366.mobile.course.count.CountFragment.this.b.refreshLayout.setContentView(studyPageWebView);
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public void showLoading(boolean z) {
            com.up366.mobile.course.count.CountFragment.this.b.anim.setVisibility(z ? 0 : 4);
            com.up366.mobile.course.count.CountFragment.this.b.anim.setVisibility(4);
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public void dismissProgressDialog() {
            com.up366.mobile.course.count.CountFragment.this.dismissProgressDialog();
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public void openNewPage(java.lang.String str) {
            com.up366.mobile.course.count.CountFragment.this.stackFragment.push(com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment);
            androidx.fragment.app.FragmentTransaction fragmentTransactionBeginTransaction = com.up366.mobile.course.count.CountFragment.this.getChildFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.addToBackStack("fragmentname");
            fragmentTransactionBeginTransaction.hide(com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment);
            com.up366.mobile.course.count.HtmlCountJSInterface htmlCountJSInterface = com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment.jsInterface;
            if (htmlCountJSInterface != null) {
                htmlCountJSInterface.callJSMethod("onPause()");
            }
            com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment = new com.up366.mobile.course.count.HtmlCountFragment();
            fragmentTransactionBeginTransaction.add(com.up366.mobile.R.id.count_html_content, com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment).commitAllowingStateLoss();
            com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment.loadPage(str);
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public boolean closePage() {
            if (com.up366.mobile.course.count.CountFragment.this.stackFragment.size() <= 0) {
                return false;
            }
            com.up366.mobile.course.count.CountFragment.this.getChildFragmentManager().popBackStack();
            com.up366.mobile.course.count.CountFragment countFragment = com.up366.mobile.course.count.CountFragment.this;
            countFragment.curHtmlCountFragment = (com.up366.mobile.course.count.HtmlCountFragment) countFragment.stackFragment.pop();
            com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment.onResumeBack();
            com.up366.mobile.course.count.CountFragment.this.b.refreshLayout.setContentView(com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment.webView);
            com.up366.mobile.course.count.CountFragment.this.getChildFragmentManager().beginTransaction().show(com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment).commitAllowingStateLoss();
            return true;
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public com.up366.mobile.course.count.HtmlCountFragment getCurHtmlFragment() {
            return com.up366.mobile.course.count.CountFragment.this.curHtmlCountFragment;
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public void updateTitle(final java.lang.String str, int i) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.count.CountFragment$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$updateTitle$0(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateTitle$0(java.lang.String str) throws java.lang.Exception {
            com.up366.mobile.course.count.CountFragment.this.b.titleBar.setTitle(str);
            com.up366.mobile.course.count.CountFragment.this.b.titleBar.binding.rightText.setVisibility(8);
            com.up366.mobile.course.count.CountFragment.this.b.titleBar.showRightButton(false);
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public com.up366.mobile.book.model.BookInfoStudy getBookInfo() {
            return com.up366.mobile.course.count.CountFragment.this.context.book;
        }

        @Override // com.up366.mobile.course.count.CountFragment.ICallMainFragment
        public void setEnable(boolean z) {
            com.up366.mobile.course.count.CountFragment.this.b.refreshLayout.setEnable(z);
        }
    }

    public void onHiddenChanged(boolean z) {
        if (z || this.curHtmlCountFragment.webView == null || this.curHtmlCountFragment.webView.getVisibility() != 0 || this.curHtmlCountFragment.jsInterface == null) {
            return;
        }
        this.curHtmlCountFragment.jsInterface.callJSMethod("onEnterPage()");
    }
}
