package com.example.pmohale.mycloset.injection;

import com.example.pmohale.mycloset.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by PMohale on 2018/02/24.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ClosetModule.class,
        ActivityBuilders.class
})
public interface ClosetComponent {

    void inject(App closetApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(App application);

        ClosetComponent build();
    }
}

