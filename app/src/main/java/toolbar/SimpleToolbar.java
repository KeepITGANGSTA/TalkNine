package toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import talk99.doyoo.com.R;


/**
 * Created by Administrator on 2018/1/25.
 */


public class SimpleToolbar extends Toolbar {

    private RoundedImageView iv_left;
    private TextView tv_title;
    private ImageView iv_right;

    public SimpleToolbar(Context context) {
        this(context,null);
    }

    public SimpleToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        iv_left=findViewById(R.id.iv_left_toolbar);
        tv_title=findViewById(R.id.tv_title_toolbar);
        iv_right=findViewById(R.id.iv_right_toolbar);

    }

    /**
     *  设置标题
     * @param title
     */
    public void setTv_title(String title){
        this.setTitle(" ");
        tv_title.setText(title);
    }

    /**
     *  设置标题颜色
     * @param titleColor
     */
    public void setTitleColor(int titleColor){
        tv_title.setTextColor(titleColor);
    }

    /**
     *  设置左侧图标
     * @param ivLeft
     */
    public void setIv_left(int ivLeft){
        iv_left.setImageResource(ivLeft);
    }

    /**
     *  设置右侧图标
     * @param ivRight
     */
    public void setIv_right(int ivRight){
        iv_right.setImageResource(ivRight);
    }

    /**
     *  设置左侧点击事件
     * @param onClick
     */
    public void setIv_leftOnClick(OnClickListener onClick){
        iv_left.setOnClickListener(onClick);
    }

    /**
     *  设置右侧点击事件
     * @param onClick
     */
    public void setIv_rightOnClick(OnClickListener onClick){
        iv_right.setOnClickListener(onClick);
    }
}
