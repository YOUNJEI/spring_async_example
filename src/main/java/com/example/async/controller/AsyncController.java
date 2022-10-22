package com.example.async.controller;

import com.example.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async/{name}")
    public String async(@PathVariable String name) throws InterruptedException {
        return asyncService.async(name);
    }

    @GetMapping("/asyncFuture/{name}")
    public String asyncFuture(@PathVariable String name) throws InterruptedException {
        Future<String> stringFuture = asyncService.asyncFuture(name);
        String newName = "";

        try {
            newName = stringFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return newName;
    }

    @GetMapping("/sync/{name}")
    public String sync(@PathVariable String name) throws InterruptedException {
        return asyncService.sync(name);
    }
}
