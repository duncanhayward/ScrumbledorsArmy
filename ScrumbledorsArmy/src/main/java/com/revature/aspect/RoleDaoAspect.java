package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.pojo.Role;

import java.util.List;

import org.apache.log4j.Logger;

@Aspect
@Component
public class RoleDaoAspect {

  static Logger log = Logger.getLogger(RoleDaoAspect.class.getName());

  @Around("execution(* com.revature.dao.RoleDaoImpl.insert(..))")
  public Integer interruptDaoInsert(ProceedingJoinPoint pjp) throws Throwable {
    Signature sig = pjp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Role) pjp.getArgs()[0]);
    Integer id = (Integer) pjp.proceed();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - After: " + id);
    return id;
  }

  @Around("execution(* com.revature.dao.RoleDaoImpl.getPojoById(..))")
  public Role interruptDaoGet(ProceedingJoinPoint pjp) throws Throwable {
    Signature sig = pjp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Role) pjp.getArgs()[0]);
    Role user = (Role) pjp.proceed();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - After: " + user);
    return user;
  }

  @AfterReturning(pointcut = "execution(* com.revature.dao.RoleDaoImpl.getAllPojos(..))", returning = "result")
  public void interruptDaoGetAll(JoinPoint jp, Object result) {
    Signature sig = jp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - " + (List<Role>) result);
  }

  @Around("execution(* com.revature.dao.RoleDaoImpl.update(..))")
  public void interruptDaoUpdate(ProceedingJoinPoint pjp) throws Throwable {
    Signature sig = pjp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Role) pjp.getArgs()[0]);
    Role user = (Role) pjp.proceed();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - After: " + user);
  }

  @Before("execution(* com.revature.dao.RoleDaoImpl.delete(..))")
  public void interruptDaoDelete(JoinPoint jp) {
    Signature sig = jp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (Role) jp.getArgs()[0]);
  }
}