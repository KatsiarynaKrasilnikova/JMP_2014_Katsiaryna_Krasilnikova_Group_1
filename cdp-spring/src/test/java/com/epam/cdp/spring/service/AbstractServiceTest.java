package com.epam.cdp.spring.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Ilya_Kukushkin on 12/17/2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-data.xml",
        "classpath:spring/spring-service.xml"
})
@ActiveProfiles("test")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class AbstractServiceTest {
}
