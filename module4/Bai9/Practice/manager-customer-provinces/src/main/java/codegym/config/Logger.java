package codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
    @AfterReturning("execution(public * codegym.service.CustomerService.*(..))")
    public void error(){
        System.out.println("[CMS] ok!");
    }
}
