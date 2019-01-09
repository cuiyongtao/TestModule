package com.test.myfirstmodule.rxbus;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Author： Victory
 * @Time： 2019/1/3
 * @QQ： 949021037
 * @Explain： com.test.myfirstmodule.baseutil
 */
public class RxBus {

    public Observable<String> observable;

    private static RxBus rxBus;
    String message;
    public static RxBus getRxBus() {
        if (rxBus == null) {
            rxBus = new RxBus();
        }
        return rxBus;
    }

    public void post(String string) {
        observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext(string);
                emitter.onComplete();
            }
        });
    }

    public String receive() {
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                message=s;
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        return message;
    }

}
