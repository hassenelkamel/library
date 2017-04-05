package com.jee.library;

import javax.ejb.Remote;

/**
 * Created by Viktoriia_Moiseienko on 4/4/2017.
 */
@Remote
public interface HelloWorld {

    String sayHello();

}
