package com.demoopensource;

import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.runner.JUnitCore.runClasses;

public class Runner {
    public static void main(String[] args) {
        Result result = runClasses(TestClass.class);

        if (result.wasSuccessful()) {
            System.out.println("Success!");
        } else {
            for (Failure failure : result.getFailures()) {
                System.err.println("Exception - " + failure.getException());
                System.err.println("Trace - " + failure.getTrace());
            }

        }
    }
}
