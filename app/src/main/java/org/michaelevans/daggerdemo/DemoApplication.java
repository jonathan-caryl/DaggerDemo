/*
 * Copyright 2014 Michael Evans
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.michaelevans.daggerdemo;

import android.app.Application;

import org.michaelevans.daggerdemo.api.ApiModule;
import org.michaelevans.daggerdemo.preferences.PreferencesModule;
import org.michaelevans.daggerdemo.ui.UiModule;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by michael on 9/23/14.
 */
public class DemoApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        Object[] modules = getModules().toArray();
        graph = ObjectGraph.create(modules);
    }

    public List<Object> getModules() {
        return Arrays.asList(
                new ApplicationModule(this),
                new UiModule(),
                new PreferencesModule(),
                new ApiModule()
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }

    public void plus(Object object){
        graph.plus(object);
    }

    public void setObjectGraph(ObjectGraph objectGraph) {
        this.graph = objectGraph;
    }
}