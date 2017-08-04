package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.pojo.User;

import org.apache.log4j.Logger;

@Aspect
@Component
public class UserDaoAspect {

  static Logger log = Logger.getLogger(UserDaoAspect.class.getName());

  @Around("execution(* com.revature.dao.UserDaoImpl.getPojoById(..))")
  public User hijackDaoGet(ProceedingJoinPoint pjp) throws Throwable {
    Signature sig = pjp.getSignature();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - Before: " + (User) pjp.getArgs()[0]);
    User user = (User) pjp.proceed();
    log.info(sig.getDeclaringTypeName() + " : " + sig.getName() + " - After: " + user);
    return user;
  }

}
