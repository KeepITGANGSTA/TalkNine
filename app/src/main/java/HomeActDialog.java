import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import talk99.doyoo.com.R;

/**
 * Created by Administrator on 2018/1/26.
 */

public class HomeActDialog {

    private Context context;
    private AlertDialog show;
    private AlertDialog.Builder adb;

    public HomeActDialog(Context context) {
        this.context = context;
        if (adb==null){
            Log.d("Home","Dialog为空，初始化");
            adb = new AlertDialog.Builder(context);
            adb.setTitle(R.string.msg_dialogTitle);
            adb.setItems(context.getResources().getStringArray(R.array.msg_dialogItem), (dialogInterface, i) -> {
                switch (i){
                    case 0:
                        Toast.makeText(context, "清空离线消息", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context, "清空所有", Toast.LENGTH_SHORT).show();
                        break;
                }
            });
            adb.setCancelable(true);
            show=adb.create();
        }
    }




}
