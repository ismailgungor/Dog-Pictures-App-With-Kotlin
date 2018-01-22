package com.ismailgungor.dogPictures.splashActivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.afollestad.materialdialogs.MaterialDialog
import com.ismailgungor.dogPictures.app.AppModule
import com.ismailgungor.dogPictures.dogsActivity.R
import com.ismailgungor.dogPictures.dogsActivity.R2
import javax.inject.Inject

/**
 * Created by ismailgungor on 22.01.2018.
 */
class SplashActivity : AppCompatActivity(), SplashActivityContract.View {

    @BindView(R2.id.loading_view)
    lateinit var loadingView: LinearLayout

    @Inject
    lateinit var mPresenter: SplashActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        DaggerSplashActivityComponent.builder()
                .appModule(AppModule(this))
                .splashActivityModule(SplashActivityModule())
                .build().inject(this)

        ButterKnife.bind(this)
        this.mPresenter.setView(this)
        this.mPresenter.checkNetwork()

    }

    override fun showNetworkNotConnectedDialog() {

        MaterialDialog.Builder(this)
                .title(R.string.network_error)
                .content(R.string.required_network_connection)
                .positiveText(R.string.okey)
                .onPositive { _, _ -> mPresenter.checkNetwork() }
                .negativeText(R.string.exit)
                .onNegative { _, _ -> finish() }
                .cancelable(false)
                .show()

    }

    override fun getDogNames() {
        this.mPresenter.getDogNames()
    }

    override fun showLoadingView() {

        this.loadingView.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {

        this.loadingView.visibility = View.INVISIBLE
    }

    override fun goToDogsActivity(intent: Intent) {

        startActivity(intent)
        finish()

    }


}