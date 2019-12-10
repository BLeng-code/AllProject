package com.module.hello;

import com.module.annotation.NewHello;
import com.module.annotation.SayHello;

@NewHello
public class Hello {
    @SayHello
    public void sayHello(String who) {
        System.out.println(who + " say Hello");
    }

    public void sayBye(String who) {
        System.out.println(who + " say Bye");
    }
}