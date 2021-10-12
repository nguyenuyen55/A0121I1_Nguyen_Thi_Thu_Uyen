package vn.codegym.managerbook.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import vn.codegym.managerbook.exception.ErrorCodeBook;

@Component
@Aspect
public class Logger {
   @After("execution(public * vn.codegym.managerbook.repository..*(..))")
    public void checkLogger(JoinPoint point){
       String className= point.getTarget().getClass().getSimpleName();
       String method= point.getSignature().getName();
        System.out.println("đã vô hàm function"+method+" ở lớp "+className);
    }
    @AfterThrowing(value = "execution(public * vn.codegym.managerbook.repository..*(..))",throwing = "e")
 public void logException(JoinPoint point, ErrorCodeBook e){
     String className= point.getTarget().getClass().getSimpleName();
     String method= point.getSignature().getName();
     System.out.println("đã vô hàm function"+method+"ở lớp "+className+" và bị lỗi " +e.getMessage());
 }
}
