package com.jiangxk.rxjava.rxjava;

import android.support.annotation.NonNull;

/**
 * Created by jiangxk on 2017/8/15.
 */

public class Observable<T> implements ObservableSource<T> {
    private ObservableOnSubscribe mObservableOnSubscribe;

    private Observable(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.mObservableOnSubscribe = observableOnSubscribe;
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        return new Observable<T>(observableOnSubscribe);
    }

    @Override
    public void subscribe(@NonNull Observer<? super T> observer) {
        ((Subscriber) observer).onStart();
        mObservableOnSubscribe.subscribe((Subscriber) observer);
    }
}
