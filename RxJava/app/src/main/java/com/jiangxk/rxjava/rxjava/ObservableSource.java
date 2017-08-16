package com.jiangxk.rxjava.rxjava;

import android.support.annotation.NonNull;

/**
 * Created by jiangxk on 2017/8/15.
 * 事件源
 *
 * @param <T>
 */

public interface ObservableSource<T> {

    /**
     * 将给定的观察者{@link Observer} 订阅此事件源
     *
     * @param observer
     */
    void subscribe(@NonNull Observer<? super T> observer);
}
