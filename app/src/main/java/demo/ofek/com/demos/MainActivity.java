package demo.ofek.com.demos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import demo.ofek.com.demos.Entities.User;
import demo.ofek.com.demos.Tasks.RandomGeneratorTask;

public class MainActivity extends AppCompatActivity implements RandomGeneratorTask.RandomGeneratorCallbacks{
    BaseFragment fragment1;
    BaseFragment fragment2;
    Button startBtn;
    TextView countdownTV;
    RandomGeneratorTask generatorTask=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragments();
        setViews();
    }

    private void setViews() {
        startBtn= (Button) findViewById(R.id.startBtn);
        countdownTV= (TextView) findViewById(R.id.countdownTV);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (generatorTask==null){
                    generatorTask=new RandomGeneratorTask(MainActivity.this);
                    generatorTask.start();
                }
            }
        });
    }

    private void showFragments() {
        fragment1=new BaseFragment();
        fragment2=new BaseFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag1Lay,fragment1).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag2Lay,fragment2).commit();
    }


    @Override
    public void onCountdownUpdate(final int num) {
        countdownTV.post(new Runnable() {
            @Override
            public void run() {
               countdownTV.setText(String.valueOf(3-num));
            }
        });
    }

    @Override
    public void onUserRandomlyPicked(final User user) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fragment1.saveUser(user);
                fragment2.showUser();
            }
        });
    }
}
