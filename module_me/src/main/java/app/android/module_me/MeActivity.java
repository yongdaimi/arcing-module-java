package app.android.module_me;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import app.android.module_base.base.BaseActivity;
import app.android.module_base.constant.ARouterPath;

/**
 * @author xp.chen
 */
@Route(path = ARouterPath.MODULEME_MEACTIVITY)
public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        // 注入传递的参数
        ARouter.getInstance().inject(this);
        Toast.makeText(getApplicationContext(), getIntent().getStringExtra("param"), Toast.LENGTH_LONG).show();
    }

}
