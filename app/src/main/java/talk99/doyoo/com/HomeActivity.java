package talk99.doyoo.com;

import android.content.DialogInterface;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeActivity extends AppCompatActivity {

    private AnimatedVectorDrawable iv_dialog_show;
    private AnimatedVectorDrawable iv_dialog_dismiss;
    private Unbinder bind;

    @BindView(R.id.iv_right_toolbar)
    ImageView iv_dialog;
    @BindView(R.id.tv_title_toolbar)
    TextView tv_title;
    private boolean flag=false;
    private AlertDialog show;
    private AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bind = ButterKnife.bind(this);
        initDialog();

    }


    private void initDialog() {
        if (Build.VERSION.SDK_INT>=21){
            iv_dialog_show= (AnimatedVectorDrawable) getDrawable(R.drawable.avd_add_to_remove);
            iv_dialog_dismiss=(AnimatedVectorDrawable) getDrawable(R.drawable.avd_remove_to_add);
        }

    }

    @OnClick({R.id.iv_right_toolbar})
    public void HomeOnClick(View view){
        switch (view.getId()){
            case R.id.iv_right_toolbar:
                if (adb==null){
                    Log.d("Home","Dialog为空，初始化");
                    adb = new AlertDialog.Builder(HomeActivity.this);
                    adb.setTitle(R.string.msg_dialogTitle);
                    adb.setItems(getResources().getStringArray(R.array.msg_dialogItem), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i){
                                case 0:
                                    Toast.makeText(HomeActivity.this, "清空离线消息", Toast.LENGTH_SHORT).show();
                                    break;
                                case 1:
                                    Toast.makeText(HomeActivity.this, "清空所有", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
                    adb.setCancelable(true);
                    show=adb.create();
                }
                dialog();
                break;
        }
    }



    /**
     * 展示会话框
     */
    private void dialog() {
        if (Build.VERSION.SDK_INT>=21){
            if (!show.isShowing()){
                iv_dialog.setImageDrawable(iv_dialog_dismiss);
                iv_dialog_dismiss.start();
                flag=true;
                show.show();
                show.setOnDismissListener(dialogInterface -> {
                    if (Build.VERSION.SDK_INT>=21){
                        Log.d("eHomee","dismiss()");
                        iv_dialog.setImageDrawable(iv_dialog_show);
                        iv_dialog_show.start();
                    }

                });
            }
        }else {
            if (!show.isShowing()){
                show.show();
            }else {
                show.dismiss();
            }
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!=null){
            bind.unbind();
        }
        if (show!=null){
            if (show.isShowing()){
                show.dismiss();
                show=null;
            }
        }
        if (adb!=null){
            adb=null;
        }


    }


}
