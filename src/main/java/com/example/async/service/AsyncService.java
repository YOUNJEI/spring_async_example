package com.example.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncService {
    public String sync(String name) throws InterruptedException {
        System.out.println("---> in sync");
        Thread.sleep(5000);
        String newName = "[" + name + "]";
        System.out.println(newName);
        return newName;
    }

    @Async
    public String async(String name) throws InterruptedException {
        System.out.println("---> in sync");
        Thread.sleep(5000);
        String newName = "[" + name + "]";
        System.out.println(newName);
        return newName;
    }

    @Async
    public Future<String> asyncFuture(String name) throws InterruptedException {
        System.out.println("---> in sync");
        Thread.sleep(5000);
        String newName = "[" + name + "]";
        System.out.println(newName);
        return new AsyncResult<String>(newName);
    }
}
