package com.epam.cdp.spring.aspect;

import com.epam.cdp.hibernate.model.ChangeHistory;
import com.epam.cdp.hibernate.repository.IChangeHistoryRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ilya_Kukushkin on 12/20/2014
 */
@Aspect
public class ChangeHistoryAspect {

    @Autowired
    private IChangeHistoryRepository changeHistoryRepository;

    @Before("execution(* com.epam.cdp.hibernate.repository.*.save(com.epam.cdp.hibernate.model.BaseEntity)) || " +
            "execution(* com.epam.cdp.hibernate.repository.*.update(com.epam.cdp.hibernate.model.BaseEntity)) || " +
            "execution(* com.epam.cdp.hibernate.repository.*.delete(com.epam.cdp.hibernate.model.BaseEntity))")
    public void saveChangeHistory(JoinPoint joinPoint) {

        ChangeHistory changeHistory = new ChangeHistory();
        changeHistory.setAction(joinPoint.getSignature().getName());
        changeHistory.setModified(DateTime.now());

        Object[] signatureArgs = joinPoint.getArgs();
        changeHistory.setEntity(signatureArgs[0].getClass().getName());

        changeHistoryRepository.save(changeHistory);
    }

}
