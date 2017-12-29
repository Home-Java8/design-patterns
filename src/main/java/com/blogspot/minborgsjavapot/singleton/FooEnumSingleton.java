package com.blogspot.minborgsjavapot.singleton;

public enum FooEnumSingleton {
    INSTANCE;

    public static FooEnumSingleton getInstance() { return INSTANCE; }

    public void bar() {}
}
