package com.baculsoft.mvpconcept.views.main;

import com.baculsoft.mvpconcept.internal.model.Data;
import com.baculsoft.mvpconcept.views.base.Presenter;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class MainPresenter implements Presenter<MainView> {
    private MainView mView;

    @Override
    public void onAttach(final MainView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    public void showFragment() {
        // Set Data
        final Data data = new Data();
        data.setText("Hello from Data!");

        // Show Fragment with Data
        mView.onShowFragment(data);
    }
}