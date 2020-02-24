package com.lengbo.binderservice.presenter;

import com.lengbo.binderservice.view.IShow;

/**
 * date            2020-02-22
 * author          lengbo
 * description
 */
public class ShowPresenter {
    private IShow mShow;

    private ShowPresenter() {

    }

    public static ShowPresenter getInstance() {
        return Holder.instance;
    }

    public void setShow(IShow show) {
        mShow = show;
    }

    public void showData(String data) {
        if (mShow != null) {
            mShow.showData(data);
        }
    }

    static class Holder {
        public static final ShowPresenter instance = new ShowPresenter();
    }
}
