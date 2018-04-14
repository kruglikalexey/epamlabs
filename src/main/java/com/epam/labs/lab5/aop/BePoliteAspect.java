package com.epam.labs.lab5.aop;

import com.epam.labs.lab5.model.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BePoliteAspect {

    private String say(String string, JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            if (o.getClass().isInstance(Customer.class)) {
                return String.format(string, ((Customer) o).getName());
            }
        }
        return "";
    }

    @Before("@annotation(Hello)")
    void sayHello(JoinPoint joinPoint) {
        System.out.println(say("Hello, %s, how are you doing?", joinPoint));
    }

    @After("@annotation(Bye)")
    void sayBye(JoinPoint joinPoint) {
        System.out.println(say("Good bye, %s!", joinPoint));
    }

    @AfterThrowing("@annotation(Hello) || @annotation(Bye)")
    void getOut(JoinPoint joinPoint) {
        System.out.println(say("Get out, %s!", joinPoint));
    }

}
