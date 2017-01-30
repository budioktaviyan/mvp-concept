package com.baculsoft.mvpconcept.views.base;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public interface Presenter<T extends View> {
    void onAttach(T view);

    void onDetach();
}