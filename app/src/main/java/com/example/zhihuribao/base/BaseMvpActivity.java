package com.example.zhihuribao.base;

public abstract class BaseMvpActivity<M extends BaseModel,V extends Baseview,P extends Basepresenter> extends BaseActivity{
    protected  P Mypresenter;
    @Override
    protected void initMvp() {
        Mypresenter=initMypresenter();
        if (Mypresenter!=null){
            Mypresenter.attachView(MyMvpView());
            Mypresenter.initModel(MyMvpModel());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Mypresenter!=null){
            Mypresenter.Destory();
            Mypresenter=null;
        }
    }

    protected abstract M MyMvpModel();

    protected abstract V MyMvpView();

    protected abstract P initMypresenter();
}
