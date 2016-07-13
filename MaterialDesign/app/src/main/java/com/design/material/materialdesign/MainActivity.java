package com.design.material.materialdesign;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.ImageRecyAdapter;
import adapter.ViewModel;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ImageRecyAdapter.OnItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_showimage)
    RecyclerView rvShowimage;

    ImageRecyAdapter imageAdaper;

    private static List<ViewModel> items = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            items.add(new ViewModel("Item " + i, "http://lorempixel.com/500/500/animals/" + i));
        }
    }

    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.content)
    CoordinatorLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        initData();
        initFab();
        initToolbar();
    }


    private void initData() {
        imageAdaper = new ImageRecyAdapter(getApplicationContext(), items);
        imageAdaper.setOnItemClickListener(this);
        rvShowimage.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rvShowimage.setAdapter(imageAdaper);
    }

    private void initFab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(content, "FAB Clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onItemClick(View view, ViewModel viewModel) {
        DetailActivity.navigate(this, view.findViewById(R.id.image), viewModel);
    }

/*new RxHttp<BaseResult>().send(ApiManager.getService().getImageTitle(),
                new Response<BaseResult>(getApplicationContext(),true) {
                    @Override
                    public void onNext(BaseResult baseResult) {
                        super.onNext(baseResult);
                        if (baseResult.response.equals("200")) {

                            ToastCommom.createToastConfig().ToastShow(GlobalApplication.context,"请求成功！");

                            finish();
                        } else {
                            ToastCommom.createToastConfig().ToastShow(GlobalApplication.context, baseResult.desc);
                        }
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }
                });*/
}
