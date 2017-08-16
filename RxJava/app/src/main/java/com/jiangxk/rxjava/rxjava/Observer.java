package com.jiangxk.rxjava.rxjava;

import android.support.annotation.NonNull;

/**
 * Created by jiangxk on 2017/8/15.
 * 观察者
 *
 * @param <T> 元素类型
 */

public interface Observer<T> {

    /**
     * 为观察者提供取消(即处理)的方法
     *
     * @param disposable
     */
    void onSubscribe(@NonNull Disposable disposable);

    /**
     * 发射一个新事件
     *
     * @param t
     */
    void onNext(@NonNull T t);

    /**
     * 通知观察者 遇到一个错误
     * 如果调用此方法 将不会调用 {@link #onNext(Object)} 和 {@link #onComplete()}
     *
     * @param throwable
     */
    void onError(@NonNull Throwable throwable);

    /**
     * 全部完成
     */
    void onComplete();
}
