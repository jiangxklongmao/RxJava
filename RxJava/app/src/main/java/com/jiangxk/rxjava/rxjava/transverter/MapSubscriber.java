package com.jiangxk.rxjava.rxjava.transverter;

import android.support.annotation.NonNull;

import com.jiangxk.rxjava.rxjava.Disposable;
import com.jiangxk.rxjava.rxjava.Subscriber;

/**
 * Created by jiangxk on 2017/8/16.
 */

public class MapSubscriber<T, R> extends Subscriber<R> {
    private Subscriber<? super T> mSubscriber;
    private Converter<? super R, ? extends T> mConverter;

    public MapSubscriber(Subscriber<? super T> subscriber, Converter<? super R, ? extends T> converter) {
        mSubscriber = subscriber;
        mConverter = converter;
    }

    @Override

    public void onSubscribe(@NonNull Disposable disposable) {
        mSubscriber.onSubscribe(disposable);
    }

    @Override
    public void onNext(@NonNull R r) {
        try {
            mSubscriber.onNext(mConverter.apply(r));
        } catch (Exception e) {
            e.printStackTrace();
            mSubscriber.onError(e);
        }
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        mSubscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        mSubscriber.onComplete();
    }
}
