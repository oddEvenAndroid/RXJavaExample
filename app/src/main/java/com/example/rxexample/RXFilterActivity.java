package com.example.rxexample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class RXFilterActivity extends AppCompatActivity {

	private Disposable disposable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// observable
		Observable<String> animalsObservable = getAnimalsObservable();

		// observer
		Observer<String> animalsObserver = getAnimalsObserver();

		// observer subscribing to observable
		animalsObservable
				.observeOn(Schedulers.io())
				.subscribeOn(AndroidSchedulers.mainThread())

				// filter() operator Demo
				.filter(new Predicate<String>() {
					@Override
					public boolean test(String s) throws Exception {
						return s.toLowerCase().startsWith("b");
					}
				})
				.subscribe(animalsObserver);
	}

	private Observer<String> getAnimalsObserver() {
		return new Observer<String>() {
			@Override
			public void onSubscribe(Disposable d) {
				Log.d("RXDEMO", "onSubscribe");
				disposable = d;
			}

			@Override
			public void onNext(String s) {
				Log.d("RXDEMO", "Name: " + s);
			}

			@Override
			public void onError(Throwable e) {
				Log.e("RXDEMO", "onError: " + e.getMessage());
			}

			@Override
			public void onComplete() {
				Log.d("RXDEMO", "All items are emitted!");
			}
		};
	}

	private Observable<String> getAnimalsObservable() {
		return Observable.just("Ant", "Bee", "Cat", "Dog", "Fox");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// don't send events once the activity is destroyed
		disposable.dispose();
	}
}
