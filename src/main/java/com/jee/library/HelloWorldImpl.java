package com.jee.library;

import javax.ejb.Stateless;

/**
 * Created by Viktoriia_Moiseienko on 4/4/2017.
 */

@Stateless
public class HelloWorldImpl implements HelloWorld {

    public HelloWorldImpl() {
    }

    @Override
    public String sayHello() {
        return "Hello World!!!";
    }
}
