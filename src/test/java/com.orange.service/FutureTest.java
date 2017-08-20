package com.orange.service;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wangmn
 * @version 1.0
 * @date 2017/6/14
 * @description
 */
public class FutureTest {
    static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Future<String> future = executor.submit(new Task());
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    @Test
    public void test() {
        System.out.println(0.1 + 0.2 == 0.3);
    }
}
