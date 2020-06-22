package com.example.zhihuribao.base;

import java.util.ArrayList;

public abstract class Basepresenter<M extends BaseModel,V extends Baseview> {
    protected ArrayList<BaseModel> list=new ArrayList<>();
    protected  M Mymodel;
    protected V Myview;
    public void attachView(V Myview){
        this.Myview=Myview;
    }
    public void initModel(M Mymodel){
        this.Mymodel=Mymodel;
        list.add(Mymodel);
    }
    public void Destory(){
        if (list.size()>0){
            for (BaseModel baseModel:list) {
                baseModel.destory();
            }
        }
        if (Mymodel!=null){
            Mymodel=null;
        }
        if (Myview!=null){
            Myview=null;
        }
    }
}
