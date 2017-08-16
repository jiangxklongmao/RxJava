package com.jiangxk.rxjava.rxjava;

/**
 * Created by jiangxk on 2017/8/15.
 * 可以使用的发射源
 */

public interface Disposable {
    /**
     * 处理事件源
     */
    void dispose();

    /**
     * 事件源是否被处理
     *
     * @return 如果事件源被处理了返回true
     */
    boolean isDisposed();
}
