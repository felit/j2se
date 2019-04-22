package com.livedrof.j2se.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.junit.Test;

public class Dee {
    @Test
    public void test() {
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("observable001");
//                observableEmitter
            }
        });
        Observer<String> reader = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(reader);
    }
}
