package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.pojo.Task;

import java.util.List;

import org.apache.log4j.Logger;

@Aspect
@Component
public class TaskDaoAspect {

  static Logger log = Logger.getLogger(TaskDaoAspect.class.getName());

  @Around("execution(* com.revature.dao.TaskDaoImpl.insert(..))")
  public Integer interruptDaoInsert(ProceedingJoinPoint pjp) throws Throwable {
    Signature sig = pjp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Task) pjp.getArgs()[0]);
    Integer id = (Integer) pjp.proceed();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - After: " + id);
    return id;
  }

  @Around("execution(* com.revature.dao.TaskDaoImpl.getPojoById(..))")
  public Task interruptDaoGet(ProceedingJoinPoint pjp) throws Throwable {
    Signature sig = pjp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Task) pjp.getArgs()[0]);
    Task user = (Task) pjp.proceed();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - After: " + user);
    return user;
  }

  @AfterReturning(pointcut = "execution(* com.revature.dao.TaskDaoImpl.getAllPojos(..))", returning = "result")
  public void interruptDaoGetAll(JoinPoint jp, Object result) {
    Signature sig = jp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - " + (List<Task>) result);
  }

  @Around("execution(* com.revature.dao.TaskDaoImpl.update(..))")
  public void interruptDaoUpdate(ProceedingJoinPoint pjp) throws Throwable {
    Signature sig = pjp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Task) pjp.getArgs()[0]);
    Task user = (Task) pjp.proceed();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - After: " + user);
  }

  @Before("execution(* com.revature.dao.TaskDaoImpl.delete(..))")
  public void interruptDaoDelete(JoinPoint jp) {
    Signature sig = jp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Task) jp.getArgs()[0]);
  }
}