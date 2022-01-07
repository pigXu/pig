package test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("annotationTest")
@Aspect
public class LogAspects {
  // 抽取公共的切入点表达式
  // 1、本类引用
  // 2、其他的切面引用
  @Pointcut("execution(public * test.A.*(..))")
  public void pointCut() {}

  // @Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
  @Before("pointCut()")
  public void logStart(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    System.out.println(
        joinPoint.getSignature().getName() + "运行。。。@Before:参数列表是：{" + Arrays.asList(args) + "}");
  }
}
