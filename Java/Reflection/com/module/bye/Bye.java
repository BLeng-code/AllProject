package com.module.bye;

import com.module.annotation.NewHello;
import com.module.annotation.SayHello;

@NewHello
public class Bye {
    @SayHello
    public void sayHello(String who) {
        System.out.println(who + " say Hello");
    }

    public void sayBye(String who) {
        System.out.println(who + " say Bye");
    }
}