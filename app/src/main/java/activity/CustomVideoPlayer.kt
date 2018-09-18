package activity

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import com.hontech.gsyvideo.R
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

class CustomVideoPlayer : StandardGSYVideoPlayer, GSYVideoProgressListener
{
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        mNeedShowWifiTip = false // 不需要提示流量
        mFullscreenButton.visibility = View.GONE // 全屏按钮
        mStartButton.visibility = View.GONE // 开始播放按钮
        mProgressBar.visibility = View.GONE // 进度条
        mBackButton.visibility = View.GONE // 返回按钮
        mCurrentTimeTextView.visibility = View.GONE
        mTitleTextView.visibility = View.GONE
        mTotalTimeTextView.visibility = View.GONE
        mTopContainer.visibility = View.GONE
        mBottomContainer.visibility = View.GONE

        val imag = ImageView(context)
        imag.scaleType = ImageView.ScaleType.CENTER_CROP
        imag.setImageResource(R.drawable.ic_launcher_background)
        thumbImageView = imag

        setGSYVideoProgressListener(this)
    }

    override fun setViewShowState(view: View, visibility: Int)
    {
        if (view == mTopContainer ||
            view == mBottomContainer ||
            view == mStartButton) {
            return
        }
        super.setViewShowState(view, visibility)
    }

    override fun onProgress(progress: Int, secProgress: Int, currentPosition: Int, duration: Int)
    {
        if (progress >= 99) {

        }
    }

    private fun playEnd()
    {
        setUp("http://pcrtlpmfd.bkt.clouddn.com/1%20mango_vert.mov", true, "")
        startPlayLogic()
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean
    {
        return true
    }

}