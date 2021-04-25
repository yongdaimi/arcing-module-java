package app.android.module_main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;

import app.android.module_base.base.BaseActivity;
import app.android.module_base.constant.ARouterPath;

/**
 * @author xp.chen
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_main = findViewById(R.id.tv_main);
        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.MODULE_LOGIN_LOGIN_ACTIVITY).navigation();
            }
        });
    }

}
