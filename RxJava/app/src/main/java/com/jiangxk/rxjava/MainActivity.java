package com.jiangxk.rxjava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jiangxk.rxjava.rxjava.Disposable;
import com.jiangxk.rxjava.rxjava.Observable;
import com.jiangxk.rxjava.rxjava.ObservableOnSubscribe;
import com.jiangxk.rxjava.rxjava.Subscriber;

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testRxJava();
            }
        });
    }


    private void testRxJava() {
        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull Subscriber<? super Integer> subscriber) {
                        for (int i = 0; i < 10; i++) {
                            subscriber.onNext(i);
                        }
                        subscriber.onComplete();
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.i("rxjava", "onNext :" + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        Log.i("rxjava", "onError :" + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i("rxjava", "onComplete");
                    }
                });
    }
}
