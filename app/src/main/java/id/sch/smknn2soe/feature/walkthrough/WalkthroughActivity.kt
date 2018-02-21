package id.sch.smknn2soe.feature.walkthrough

import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import id.sch.smknn2soe.R
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
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
    }
}
