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
import com.jiangxk.rxjava.rxjava.transverter.Converter;

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
//                testRxJava();
                testMap();
            }
        });
    }


    /**
     * RxJava 雏形测试
     */
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

    /**
     * RxJava map简易操作符测试
     */
    private void testMap() {
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
                .map(new Converter<Integer, String>() {
                    @NonNull
                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        return " easy map :" + integer;
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.i("rxjava", "onNext :" + s);
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
