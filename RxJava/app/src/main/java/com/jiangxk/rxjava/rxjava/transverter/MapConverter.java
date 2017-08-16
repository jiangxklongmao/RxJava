package com.jiangxk.rxjava.rxjava.transverter;

import android.support.annotation.NonNull;

import com.jiangxk.rxjava.rxjava.Observable;
import com.jiangxk.rxjava.rxjava.ObservableOnSubscribe;
import com.jiangxk.rxjava.rxjava.Subscriber;

/**
 * Created by jiangxk on 2017/8/16.
 */

public class MapConverter<T, R> implements ObservableOnSubscribe<R> {
    private Observable<T> mTObservable;
    private Converter<? super T, ? extends R> mConverter;

    public MapConverter(Observable<T> TObservable, Converter<? super T, ? extends R> converter) {
        mTObservable = TObservable;
        mConverter = converter;
    }

    @Override
    public void subscribe(@NonNull Subscriber<? super R> subscriber) {
        mTObservable.subscribe(new MapSubscriber(subscriber, mConverter));
    }

}
