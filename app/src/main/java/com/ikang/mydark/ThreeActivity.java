package com.ikang.mydark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ikang.mydark.util.TouchPriorityView;

public class ThreeActivity extends AppCompatActivity {

    private Button btnSheet, btnSheetDialog, btnSheetDialogFragment;
    private BottomSheetDialog mBottomSheetDialog;


    private NestedScrollView bottomSheet;
    private BottomSheetBehavior behavior;

    private Button btn, btnF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        btnSheet = findViewById(R.id.btnSheet);
        btnSheetDialog = findViewById(R.id.btnSheetDialog);
        btnSheetDialogFragment = findViewById(R.id.btnSheetDialogFragment);
        btn = findViewById(R.id.btn);
        btnF = findViewById(R.id.btnF);

        bottomSheet = findViewById(R.id.nested_scroll_view);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState)
            {
                //这里是bottomSheet状态的改变
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset)
            {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
            }
        });
        behavior.setFitToContents(false);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        btnSheetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog = new BottomSheetDialog(ThreeActivity.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
                TextView cancelTv = view.findViewById(R.id.cancelTv);
                ImageView wechatIv = view.findViewById(R.id.wechatIv);


                TouchPriorityView dragView = view.findViewById(R.id.dragView);


                ImageView wechatmomentsIv = view.findViewById(R.id.wechatmomentsIv);

                mBottomSheetDialog.setContentView(view);
                final BottomSheetBehavior mDialogBehavior = BottomSheetBehavior.from((View) view.getParent());


                dragView.setMyFirstPriority(new TouchPriorityView.MyFirstPriority() {
                    @Override
                    public void doMyFirstDown() {
                        //拖拽控件触发了ACTION_DOWN，告知我优先处理
                        isMyFirst = true;
                    }
                });


                mDialogBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {

                        //STATE_HIDDEN = 5: 隐藏状态。默认是false，可通过app:behavior_hideable属性设置。
                        //STATE_COLLAPSED= 4: 折叠关闭状态。可通过app:behavior_peekHeight来设置显示的高度,peekHeight默认是0。
                        //STATE_DRAGGING = 1: 被拖拽状态
                        //STATE_SETTLING = 2: 拖拽松开之后到达终点位置（collapsed or expanded）前的状态。
                        //STATE_EXPANDED= 3: 完全展开的状态。

                        Log.e("open", "newState==" + newState);
                        if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                            //如果是展开状态，我不去优先处理
                            isMyFirst = false;
                        }

                        if (!isMyFirst) {
                            //如果不是我优先，就不让他收起
                            if (newState == BottomSheetBehavior.STATE_DRAGGING) {//判断为向下拖动行为时，则强制设定状态为展开
                                mDialogBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                            }
                        } else {
                            //只有当我优先，才让他收起
                            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                                mBottomSheetDialog.dismiss();
                            }
                        }
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    }
                });


                mBottomSheetDialog.getDelegate().findViewById(R.id.design_bottom_sheet)
                        .setBackgroundColor(ThreeActivity.this.getResources().getColor(android.R.color.transparent));
                mBottomSheetDialog.setCanceledOnTouchOutside(false);
                isMyFirst = false;
                cancelTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mBottomSheetDialog.dismiss();
                    }
                });

                wechatIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ThreeActivity.this, "微信分享", Toast.LENGTH_SHORT).show();
                    }
                });

                wechatmomentsIv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ThreeActivity.this, "朋友圈分享", Toast.LENGTH_SHORT).show();
                    }
                });

                mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        //收起完成之后，我又回到了非优先级别
                        isMyFirst = false;
                    }
                });

                mBottomSheetDialog.show();
            }
        });


        btnSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else {
                    behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                }


            }
        });


        btnSheetDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThreeActivity.this, "测试一下下", Toast.LENGTH_LONG).show();
            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThreeActivity.this, FourActivity.class));
                finish();
            }
        });

    }


    boolean isMyFirst;

    @Override
    protected void onResume() {
        super.onResume();


    }
}