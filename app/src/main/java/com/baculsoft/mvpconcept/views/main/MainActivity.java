package com.baculsoft.mvpconcept.views.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.baculsoft.mvpconcept.R;
import com.baculsoft.mvpconcept.internal.model.Data;
import com.baculsoft.mvpconcept.views.result.ResultFragment;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class MainActivity extends AppCompatActivity implements MainView {
    MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter();
        onAttachView();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        initToolbar();
        addButtonListener();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onShowFragment(final Data data) {
        // Get Data
        final Bundle bundle = new Bundle();
        bundle.putString("data", data.getText());

        // Show Fragment with Data
        final String tag = ResultFragment.class.getSimpleName();
        final Fragment fragment = ResultFragment.newInstance();
        fragment.setArguments(bundle);

        // Begin Fragment Transaction
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main, fragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    private void initPresenter() {
        presenter = new MainPresenter();
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);
    }

    private void addButtonListener() {
        final Button button = (Button) findViewById(R.id.btn_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                button.setVisibility(View.GONE);
                presenter.showFragment();
            }
        });
    }
}