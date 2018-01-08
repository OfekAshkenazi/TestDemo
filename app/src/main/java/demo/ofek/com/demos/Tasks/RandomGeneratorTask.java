package demo.ofek.com.demos.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Random;

import demo.ofek.com.demos.Entities.User;

/**
 * Created by Android on 1/8/2018.
 */

public class RandomGeneratorTask extends Thread {

    RandomGeneratorCallbacks callbacks;
    private Boolean cancelled=false;

    public RandomGeneratorTask(RandomGeneratorCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    public void run() {
        while (!isCancelled()&&callbacks!=null) {
            Integer i = 0;
            for (; i < 3; i++) {
                callbacks.onCountdownUpdate(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    cancel();
                }
            }
            Random random=new Random();
            int randomIndex=random.nextInt(5);
            Log.d("RandomGeneratorTask","number picked"+randomIndex);
            User randUser=User.getMockUsersList().get(randomIndex);
            callbacks.onUserRandomlyPicked(randUser);
        }
        callbacks=null;
    }

    private boolean isCancelled() {
        return cancelled;
    }

    public void cancel() {
        synchronized (cancelled) {
            this.cancelled = true;
        }
    }

    public interface RandomGeneratorCallbacks{
        void onCountdownUpdate(int num);
        void onUserRandomlyPicked(User user);
    }
}
