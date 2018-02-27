package id.sch.smknn2soe.feature.walkthrough

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import id.sch.smknn2soe.R
import id.sch.smknn2soe.feature.main.MainActivity
import id.sch.smknn2soe.helper.SlideWalkthrough

class WalkthroughActivity : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(SlideWalkthrough.newInstance(R.layout.item_walkthrough_1))
        addSlide(SlideWalkthrough.newInstance(R.layout.item_walkthrough_2))
        addSlide(SlideWalkthrough.newInstance(R.layout.item_walkthrough_3))
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        intentToMainActivity()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        intentToMainActivity()
    }

    private fun intentToMainActivity() {
        var intent = MainActivity.createIntent(this)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, WalkthroughActivity::class.java)
        }
    }
}
