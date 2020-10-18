package com.example.homework4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mybtn_cancel;
    private Button mybtn_confirm;
    private TextView myTextView;
    private ProgressBar myProgressBar;

    private class MyTask extends AsyncTask<String, Integer, String> {

        // 方法1：onPreExecute（）
        // 作用：执行 线程任务前的操作
        @Override
        protected void onPreExecute() {
            myTextView.setText("加载中");
            // 执行前显示提示
        }


        // 方法2：doInBackground（）
        // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
        // 此处通过计算从而模拟“加载进度”的情况
        @Override
        protected String doInBackground(String... params) {

            try {
                int count = 0;
                int length = 1;
                while (count<99) {

                    count += length;
                    // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
                    publishProgress(count);
                    // 模拟耗时任务
                    Thread.sleep(50);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        // 方法3：onProgressUpdate（）
        // 作用：在主线程 显示线程任务执行的进度
        @Override
        protected void onProgressUpdate(Integer... progresses) {

            myProgressBar.setProgress(progresses[0]);
            myTextView.setText("loading..." + progresses[0] + "%");

        }

        // 方法4：onPostExecute（）
        // 作用：接收线程任务执行结果、将执行结果显示到UI组件
        @Override
        protected void onPostExecute(String result) {
            // 执行完毕后，则更新UI
            myTextView.setText("加载完毕");
        }

        // 方法5：onCancelled()
        // 作用：将异步任务设置为：取消状态
        @Override
        protected void onCancelled() {

            myTextView.setText("已取消");
            myProgressBar.setProgress(0);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void download_button(View view) {
        Toast.makeText(MainActivity.this,"点击了按钮",Toast.LENGTH_LONG).show();
        showDialog();
//        setContentView(R.layout.activity_main);
    }

    private void showDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.mydialog,null,false);
        final AlertDialog dialog = new AlertDialog.Builder(this).setView(view).create();

        mybtn_cancel = view.findViewById(R.id.btn_cancel);
        mybtn_confirm = view.findViewById(R.id.btn_confirm);
        myProgressBar = view.findViewById(R.id.progressBar);
        myTextView = view.findViewById(R.id.myTextView);

        final MyTask mTask = new MyTask();
        mTask.execute();

        mybtn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_LONG).show();
                mTask.cancel(true);
                //... To-do
                dialog.dismiss();
            }
        });

        mybtn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"确认",Toast.LENGTH_LONG).show();
                mTask.cancel(true);
                //... To-do
                dialog.dismiss();
            }
        });

        dialog.show();
        //此处设置位置窗体大小，我这里设置为了手机屏幕宽度的3/4  注意一定要在show方法调用后再写设置窗口大小的代码，否则不起效果会
//        dialog.getWindow().setLayout((ScreenUtils.getScreenWidth(this)/4*3),LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}