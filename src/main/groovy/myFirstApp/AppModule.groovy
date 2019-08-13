package myFirstApp

import com.google.inject.name.Names
import groovy.transform.CompileStatic
import restling.guice.modules.RestlingApplicationModule

@CompileStatic
class AppModule extends RestlingApplicationModule{
    Class<MyAppRouter> routerClass = MyAppRouter

    @Override
    void configureCustomBindings() {}
}