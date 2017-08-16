package com.jiangxk.rxjava.rxjava.transverter;

import android.support.annotation.NonNull;

/**
 * Created by jiangxk on 2017/8/16.
 * 转换器
 */

public interface Converter<T, R> {
    /**
     * 转换类型 T -> R
     *
     * @param t 输入类型
     * @return 返回类型
     * @throws Exception onError
     */
    @NonNull
    R apply(@NonNull T t) throws Exception;
}
