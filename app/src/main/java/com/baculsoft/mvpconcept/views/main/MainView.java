package com.baculsoft.mvpconcept.views.main;

import com.baculsoft.mvpconcept.internal.model.Data;
import com.baculsoft.mvpconcept.views.base.View;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public interface MainView extends View {
    void onShowFragment(Data data);
}