package com.blogspot.minborgsjavapot.singleton;

public class FooSingleton {
    public final static FooSingleton INSTANCE = new FooSingleton();

    private FooSingleton() {}

    public void bar() {}
        
}
