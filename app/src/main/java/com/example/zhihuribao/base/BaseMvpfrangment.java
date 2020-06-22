package com.example.zhihuribao.base;

public abstract class BaseMvpfrangment<M extends BaseModel,V extends Baseview,P extends Basepresenter> extends BaseFrangment{
    protected P Mypresenter;
    @Override
    protected void initMvp() {
        Mypresenter=initMypresenter();
        if (Mypresenter!=null){
            Mypresenter.initModel(MyMvpModel());
            Mypresenter.attachView(MyMvpView());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Mypresenter!=null){
            Mypresenter.Destory();
            Mypresenter=null;
        }
    }

    protected abstract V MyMvpView();

    protected abstract M MyMvpModel();

    protected abstract P initMypresenter();
}
