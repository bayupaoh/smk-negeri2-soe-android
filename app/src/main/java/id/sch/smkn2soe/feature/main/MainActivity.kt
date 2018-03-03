package id.sch.smkn2soe.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Menu
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem

import id.sch.smkn2soe.R
import id.sch.smkn2soe.base.ui.BaseActivity
import id.sch.smkn2soe.feature.walkthrough.WalkthroughActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainActivityView {

    private var presenter: MainActivityPresenter? = null
    var mainActivityPagerAdapter: MainActivityPagerAdapter? = null

    override val resourceLayout: Int
        get() = R.layout.activity_main

    override val context: Context
        get() = this

    override fun onViewReady(savedInstanceState: Bundle?) {
        initView()
        setupPresenter()
    }

    private fun initView() {
        var itemHome = AHBottomNavigationItem(getString(R.string.menu_home), R.drawable.ic_home, R.color.white)
        var itemNews = AHBottomNavigationItem(getString(R.string.menu_berita), R.drawable.ic_news, R.color.white)
        var itemEvent = AHBottomNavigationItem(getString(R.string.menu_acara), R.drawable.ic_event, R.color.white)
        var itemCalendar = AHBottomNavigationItem(getString(R.string.menu_kalender), R.drawable.ic_calendar, R.color.white)
        var itemSchoolInfo = AHBottomNavigationItem(getString(R.string.menu_info_sekolah), R.drawable.ic_about_school, R.color.white)

        bottomNavigationMain.addItem(itemHome)
        bottomNavigationMain.addItem(itemNews)
        bottomNavigationMain.addItem(itemEvent)
        bottomNavigationMain.addItem(itemCalendar)
        bottomNavigationMain.addItem(itemSchoolInfo)

        bottomNavigationMain.setAccentColor(ContextCompat.getColor(this, R.color.blue))
        bottomNavigationMain.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        bottomNavigationMain.setOnTabSelectedListener(
                AHBottomNavigation.OnTabSelectedListener { position: Int, wasSelected: Boolean ->
                    currentItem = position
                    ahViewpaggerMain.setCurrentItem(currentItem, true)
                    setColorToolbar(position)
                    when (currentItem) {
                        0 -> txtTitleToolbarMain.text = resources.getText(R.string.menu_home)
                        1 -> txtTitleToolbarMain.text = resources.getText(R.string.menu_berita)
                        2 -> txtTitleToolbarMain.text = resources.getText(R.string.menu_acara)
                        3 -> txtTitleToolbarMain.text = resources.getText(R.string.menu_kalender)
                        4 -> txtTitleToolbarMain.text = resources.getText(R.string.menu_info_sekolah_title)
                    }
                    true
                }
        )

        mainActivityPagerAdapter = MainActivityPagerAdapter(supportFragmentManager)
        ahViewpaggerMain.adapter = mainActivityPagerAdapter
        bottomNavigationMain.setCurrentItem(currentItem)
    }

    private fun setColorToolbar(position: Int) {
        if (position == 0) {
            toolbarMain?.setBackgroundColor(resources.getColor(android.R.color.transparent))
        } else {
            toolbarMain?.setBackgroundColor(resources.getColor(R.color.blue))
        }
    }

    private fun setupPresenter() {
        presenter = MainActivityPresenter()
        presenter!!.attachView(this)

        if (presenter!!.getDataFirstInstall()) {
            presenter!!.setDataFirstInstall(false)
            var intent = WalkthroughActivity.createIntent(this)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.let { it?.detachView() }
    }

    companion object {
        var currentItem = 0
        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
