package com.livedrof.testng;


import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
public class DemoTest {
    String message = "Manisha";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "Manisha";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(dependsOnMethods = {"initEnvironmentTest"})
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Manisha";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }

    @Test
    public void initEnvironmentTest() {

        System.out.println("This is initEnvironmentTest");
    }
}

class MessageUtil {
    private String message;

    // Constructor
    // @param message to be printed
    public MessageUtil(String message) {
        this.message = message;
    }

    // prints the message
    public String printMessage() {
        System.out.println(message);
        return message;
    }

    // add "Hi!" to the message
    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }
}