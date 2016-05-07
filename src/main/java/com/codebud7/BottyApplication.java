package com.codebud7;

import com.codebud7.controller.Messenger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BottyApplication
{

    public static void main(final String[] args)
    {
        SpringApplication.run(Messenger.class, args);
    }
}
