package activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.hontech.gsyvideo.R
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.utils.GSYVideoType
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import kotlin.math.log


class VideoActivity : AppCompatActivity()
{
    private val mVideoPlayer: StandardGSYVideoPlayer by lazy { findViewById<StandardGSYVideoPlayer>(R.id.id_video_player) }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        GSYVideoType.enableMediaCodec()
        GSYVideoType.enableMediaCodecTexture()
        GSYVideoType.setShowType(GSYVideoType.SCREEN_MATCH_FULL)


   //     GSYVideoManager.instance().clearAllDefaultCache(this) // 清除缓存
        //val source = "http://pcrtlpmfd.bkt.clouddn.com/1%20mango_vert.mov"
        val source = "http://pcrtlpmfd.bkt.clouddn.com/i6.mp4"
       // val source = "http://pcrtlpmfd.bkt.clouddn.com/720ppp.mp4"

        mVideoPlayer.setUp(source, true, "")
        mVideoPlayer.startPlayLogic()
    }

    override fun onPause()
    {
        super.onPause()
        mVideoPlayer.onVideoPause()
    }

    override fun onResume()
    {
        super.onResume()
        mVideoPlayer.onVideoResume()
    }

    override fun onDestroy()
    {
        super.onDestroy()
        GSYVideoManager.releaseAllVideos()
    }
}
