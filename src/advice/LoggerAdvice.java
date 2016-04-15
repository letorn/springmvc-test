package advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LoggerAdvice implements AfterReturningAdvice {

	public void afterReturning(Object value, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("返回值: " + value);
		System.out.println("方法体: " + method.getName());
		System.out.println("参数值:" + args);
		System.out.println("目标体:" + target);
		throw new RuntimeException("日志写入失败！");// 抛出异常,事务回滚
	}

}
