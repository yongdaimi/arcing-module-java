package app.android.module_login;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import app.android.module_base.base.BaseActivity;
import app.android.module_base.constant.ARouterPath;

/**
 * @author xp.chen
 */
@Route(path = ARouterPath.MODULE_LOGIN_LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.MODULEME_MEACTIVITY)
                        .withString("param", "我要到个人中心页面").navigation();
            }
        });

        tv_login.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_headset_column_custom_audio);

    }

}
