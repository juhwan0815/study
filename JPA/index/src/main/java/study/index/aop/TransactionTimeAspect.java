package study.index.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class TransactionTimeAspect {

    @Around("execution(* study.index.service.UserService.find*(..))")
    public Object doTransactionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("[트랜잭션 시간] {} {}ms", joinPoint.getSignature(), resultTime);
        return result;
    }
}
