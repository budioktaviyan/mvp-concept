package com.baculsoft.mvpconcept.views.result;

import com.baculsoft.mvpconcept.views.base.Presenter;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class ResultPresenter implements Presenter<ResultView> {
    private ResultView mView;

    @Override
    public void onAttach(final ResultView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    public void showResult(final String text) {
        mView.onShowResult(text);
    }
}