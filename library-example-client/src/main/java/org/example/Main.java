package org.example;


import micken.ubsa.WrapperFactory;
import micken.ubsa.testclients.BlobStoreTest;

public class Main {
    public static void main(String[] args) {
        System.out.println("hi");

        BlobStoreTest wrapper = WrapperFactory.getWrapper();
        System.out.println(wrapper.getClass().getSimpleName());
        wrapper.test();
    }
}
