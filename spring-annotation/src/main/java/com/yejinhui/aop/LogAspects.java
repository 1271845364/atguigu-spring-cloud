package com.yejinhui.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类
 * 
 * @Aspect :告诉spring容器当前类是一个切面类
 * 
 * @author ye.jinhui
 * @date 2018年8月21日
 */
@Aspect
public class LogAspects {

	// 1.本类中引用
	// 2.其他类访问
	@Pointcut(value = "execution(public int com.yejinhui.aop.MathCalculator.*(..))")
	public void pointCut() {
	}

	// @Before 在目标方法之前切入：切入点表达式（指定字在那个方法切入）
	@Before(value = "pointCut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName() + "运行。。。@Before:参数列表是：{" + Arrays.asList(args) + "}");
	}

	//
	@After(value = "com.yejinhui.aop.LogAspects.pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "结束。。。@After");
	}

	// JoinPoint参数一定要出现在参数的第一位
	@AfterReturning(value = "pointCut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName() + "正常返回。。。运行结果：{" + result + "}");
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(joinPoint.getSignature().getName() + "除法异常。。。异常信息：{" + exception + "}");
	}
}
