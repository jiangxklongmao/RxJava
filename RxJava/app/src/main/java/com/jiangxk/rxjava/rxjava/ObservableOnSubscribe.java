package com.jiangxk.rxjava.rxjava;

import android.support.annotation.NonNull;

/**
 * Created by jiangxk on 2017/8/16.
 */

public interface ObservableOnSubscribe<T> {
    void subscribe(@NonNull Subscriber<? super T> subscriber);
}
