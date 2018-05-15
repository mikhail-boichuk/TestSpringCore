package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;

@Aspect
public class StatisticsAspect {

    private Map<Class<?>, Integer> counter;

    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {}

    @AfterReturning("allLogEventMethods()")
    public void countLogCalls(JoinPoint jp) {
        Class<?> loggerClass = jp.getTarget().getClass();
        if (!counter.containsKey(loggerClass)) {
            counter.put(loggerClass, 0);
        }
        counter.put(loggerClass, counter.get(loggerClass)+1);
    }

}
