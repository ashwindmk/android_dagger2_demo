package com.ashwin.android.dagger2demo.di.components;

import com.ashwin.android.dagger2demo.MainActivity;
import com.ashwin.android.dagger2demo.di.modules.SharedPrefsModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {SharedPrefsModule.class})
public interface SharedPrefsComponent {
    void inject(MainActivity target);
}
