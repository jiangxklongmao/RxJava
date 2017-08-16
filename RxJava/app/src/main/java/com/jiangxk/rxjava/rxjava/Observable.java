package com.jiangxk.rxjava.rxjava;

import android.support.annotation.NonNull;

import com.jiangxk.rxjava.rxjava.transverter.Converter;
import com.jiangxk.rxjava.rxjava.transverter.MapConverter;

/**
 * Created by jiangxk on 2017/8/15.
 */

public class Observable<T> implements ObservableSource<T> {
    private ObservableOnSubscribe mObservableOnSubscribe;

    private Observable(ObservableOnSubscribe<T> observableOnSubscribe) {
        this.mObservableOnSubscribe = observableOnSubscribe;
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        return new Observable(observableOnSubscribe);
    }

    @Override
    public void subscribe(@NonNull Observer<? super T> observer) {
        ((Subscriber) observer).onStart();
        mObservableOnSubscribe.subscribe((Subscriber) observer);
    }

    /**
     * 转换操作符 T -> R
     *
     * @param converter
     * @param <R>
     * @return
     */
    public <R> Observable<R> map(Converter<? super T, ? extends R> converter) {
        return create(new MapConverter(this, converter));
    }

//
//    public <R> Observable<R> map(final Converter<? super T, ? extends R> converter) {
//        //创建一个桥接的Observable 和 ObservableOnSubscribe
//        return create(new ObservableOnSubscribe<R>() {
//            @Override
//            public void subscribe(@NonNull final Subscriber<? super R> subscriber) {
//                //订阅上层的Observable
//                Observable.this.mObservableOnSubscribe.subscribe(new Subscriber<T>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable disposable) {
//                        subscriber.onSubscribe(disposable);
//                    }
//
//                    @Override
//                    public void onNext(@NonNull T t) {
//                        try {
//                            //将上层发送的 事件源 转换成 另一种类型 转发出去并处理异常
//                            subscriber.onNext(converter.apply(t));
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            subscriber.onError(e);
//                        }
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable throwable) {
//                        subscriber.onError(throwable);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        subscriber.onComplete();
//                    }
//                });
//            }
//        });
//    }
//
}
