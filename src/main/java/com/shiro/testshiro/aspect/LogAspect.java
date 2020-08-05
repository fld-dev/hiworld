package com.shiro.testshiro.aspect;

import com.shiro.testshiro.annotation.UserAccess;
import com.shiro.testshiro.vo.JsonResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    //@Around("within(com.shiro.testshiro.service.*)")//粗粒度表达式表示符合该路径当前目录下的所有方法实现功能的拓展
    //@Around("within(com.shiro.testshiro.service..*)")//粗粒度表达式表示符合当前路径以及子目录下所有方法实现功能的拓展
    //@Around("within(com.shiro.testshiro.service.MessageServiceImpl)")//粗粒度表达式表示该类全路径下的所有方法实现功能的拓展
    //@Around("bean(*ServiceImpl)")//粗粒度表达式,表示指定所有后缀为Impl的类下的所有方法实现功能的拓展
    //@Around("bean(MessageServiiceImpl)")//粗粒度表达式，表示该类中的所有方法实现功能的拓展
    //@Around("execution(void com.shiro.testshiro.controller.AopController.testAop())")//细粒度表达式应用于方法级别。表示为具体方法的全路径加上void。为该方法实现功能的拓展
    //@Around("execution(void com.shiro.testshiro.controller.AopController.testAop(String))")//当这个方法含有重载时，同个加上数据类型来确定是哪一个方法实现功能的拓展
    //@Around此注解修饰的方法为一个环绕通知(用户封装和织入拓展功能)，用来修饰方法参数为ProceedingJoinPoint的方法.也可能在包含此参数的情况下包含别的参数，这时@Around也要包含新增的参数信息。表示在此方法执行之前或之后实现业务拓展
    //@Around("@annotation(com.shiro.testshiro.annotation.UserAccess)")//应用于方法级别，实现细粒度的控制，配合自定义注解。通过自定义注解修饰的类或方法做锁定并为他们实现功能的拓展@annotation路径只能写自定义注解的路径

    //@Around注解中的内容为一个切入点表达式，通过此表达式告诉spring这个通知会什么时候执行
    @Pointcut("@annotation(com.shiro.testshiro.annotation.UserAccess)")//将自己自定义注解作为切点的根据，@annotation路径只能为自定义注解的全路径
    public void access(){

    }

    @Before("access()")//在目标方法Object result = joinPoint.proceed();执行之前执行的一段代码
    public void doBefore(JoinPoint joinPoint)throws Throwable{
        System.out.println("AOP Before:进入目标方法前！");
    }

    @Around("@annotation(userAccess)")//@Around环绕通知可以取代@Before与@After
        //细粒度表达式的另一种实现方法配合@Pointcut 与自定义注解配合实现对目标方法细粒度的控制,@Around中的切入点表达式的内容需要与around环绕通知方法中的参数相匹配
    public Object around(ProceedingJoinPoint joinPoint,UserAccess userAccess) throws Throwable {
        //ProceedingJoinPoint joinPoint 表示一个连接点对象，这个连接点对象封装了具体目标方法的信息，底层的实现其实是通过代理机制实现的
        System.out.println("=================目标方法执行前====================");
        Object[] getArgs = joinPoint.getArgs();
        System.out.println("AOP Before:进入目标方法前！");
        System.out.println("参数获取："+getArgs[0]);
        System.out.println("获取自定义注解中的值："+userAccess.value());
        Object result = joinPoint.proceed();//执行目标方法，目标方法的锁定通过粗粒度表达式或细粒度表达式确定
        System.out.println("AOP After:进入目标方法后");
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
        Timestamp now = new Timestamp(new Date().getTime());
        System.out.println(now);
        System.out.println(createTime);
        System.out.println("======================目标方法执行后=======================");
        return result;//return 返回目标方法的执行结果
    }

    @After("access()")//在目标方法Object result = joinPoint.proceed();执行之后执行的一段代码
    public void doAfter(JoinPoint joinPoint){
        System.out.println("AOP After:进入目标方法后");
    }
}
