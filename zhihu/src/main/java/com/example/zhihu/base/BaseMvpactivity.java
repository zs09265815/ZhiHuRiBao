package com.example.zhihu.base;

public abstract class BaseMvpactivity<M extends BaseModel,V extends BaseView,P extends BasePresenter> extends BaseActivity{
    protected P Mypresenter;
    @Override
    protected void initMvp() {
        super.initMvp();
        Mypresenter=initpresenter();
        if (Mypresenter!=null){
            Mypresenter.setMymodel(initmodel());
            Mypresenter.setMyview(initview());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Mypresenter!=null){
            Mypresenter.destory();
            Mypresenter=null;
        }
    }

    protected abstract V initview();

    protected abstract M initmodel();

    protected abstract P initpresenter();
}
