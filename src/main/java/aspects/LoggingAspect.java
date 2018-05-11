package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {}

    @Pointcut("allLogEventMethods() && within(*.*File*Logger)")
    private void logEventInsideFileLoggers() {}

    // Method will run before join point
    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("BEFORE: " +
                joinPoint.getTarget().getClass().getSimpleName() + " " +
                joinPoint.getSignature().getName());
    }

    // Execute after join point return its value
    @AfterReturning(
            pointcut = "allLogEventMethods()",
            returning = "retVal"
    )
    public void logAfter(Object retVal) {
        System.out.println("Returned value" + retVal);
    }

    // Execute after join point trow exception
    @AfterThrowing(
            pointcut = "allLogEventMethods()",
            throwing= "ex"
    )
    public void returnAfterThrow(Throwable ex) {
        System.out.println("Thrown " + ex);
    }

}
