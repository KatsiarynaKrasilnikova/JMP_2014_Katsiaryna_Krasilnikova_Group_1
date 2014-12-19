package com.epam.cdp.hibernate.service;

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

    /*@Autowired
    protected ISkillService skillService;

    @Autowired
    protected IUserService userService;

    @Autowired
    protected IProjectService projectService;

    @Autowired
    protected  IContactInfoService contactInfoService;

    @Before
    public void initData() {
        Project project1 = new Project();
        project1.setName("Project1");
        projectService.save(project1);

        Project project2 = new Project();
        project2.setName("Project2");
        projectService.save(project2);

        Skill skill1 = new Skill();
        skill1.setName("Skill1");
        skillService.save(skill1);

        Skill skill2 = new Skill();
        skill2.setName("Skill2");
        skillService.save(skill2);

        Skill skill3 = new Skill();
        skill3.setName("Skill3");
        skillService.save(skill3);

        Skill skill4 = new Skill();
        skill4.setName("Skill4");
        skillService.save(skill4);

        Skill skill5 = new Skill();
        skill5.setName("Skill5");
        skillService.save(skill5);

        Skill skill6 = new Skill();
        skill6.setName("Skill6");
        skillService.save(skill6);

        Skill skill7 = new Skill();
        skill7.setName("Skill7");
        skillService.save(skill7);

        Skill skill8 = new Skill();
        skill8.setName("Skill8");
        skillService.save(skill8);

        Skill skill9 = new Skill();
        skill9.setName("Skill9");
        skillService.save(skill9);

        Skill skill10 = new Skill();
        skill10.setName("Skill10");
        skillService.save(skill10);

        User user1 = new User();
        user1.setEmail("user1@gmail.com");
        user1.setPassword("pass");
        user1.setRole(Role.ROLE_DEVELOPER);
        user1.setProject(project1);

        ContactInfo contactInfo1 = new ContactInfo();
        contactInfo1.setFirstName("user1");
        contactInfo1.setLastName("user1");
        contactInfo1.setBirthday(LocalDate.now());
        contactInfo1.setUser(user1);

        user1.setContactInfo(contactInfo1);
        userService.save(user1);

        User user2 = new User();
        user2.setEmail("user2@gmail.com");
        user2.setPassword("pass");
        user2.setRole(Role.ROLE_QA);
        user2.setProject(project1);

        ContactInfo contactInfo2 = new ContactInfo();
        contactInfo2.setFirstName("user2");
        contactInfo2.setLastName("user2");
        contactInfo2.setBirthday(LocalDate.now());
        contactInfo2.setUser(user2);

        user2.setContactInfo(contactInfo2);
        userService.save(user2);

        User user3 = new User();
        user3.setEmail("user3@gmail.com");
        user3.setPassword("pass");
        user3.setRole(Role.ROLE_DEVELOPER);
        user3.setProject(project1);

        ContactInfo contactInfo3 = new ContactInfo();
        contactInfo3.setFirstName("user3");
        contactInfo3.setLastName("user3");
        contactInfo3.setBirthday(LocalDate.now());
        contactInfo3.setUser(user3);

        user3.setContactInfo(contactInfo3);
        userService.save(user3);

        User user4 = new User();
        user4.setEmail("user4@gmail.com");
        user4.setPassword("pass");
        user4.setRole(Role.ROLE_DEVELOPER);
        user4.setProject(project2);

        ContactInfo contactInfo4 = new ContactInfo();
        contactInfo4.setFirstName("user4");
        contactInfo4.setLastName("user4");
        contactInfo4.setBirthday(LocalDate.now());
        contactInfo4.setUser(user4);

        user4.setContactInfo(contactInfo4);
        userService.save(user4);

        User user5 = new User();
        user5.setEmail("user5@gmail.com");
        user5.setPassword("pass");
        user5.setRole(Role.ROLE_DEVELOPER);
        user5.setProject(project2);

        ContactInfo contactInfo5 = new ContactInfo();
        contactInfo5.setFirstName("user5");
        contactInfo5.setLastName("user5");
        contactInfo5.setBirthday(LocalDate.now());
        contactInfo5.setUser(user5);

        user5.setContactInfo(contactInfo5);
        userService.save(user5);

        user1.setSkills(new HashSet<Skill>(skillService.findAll().subList(0, 5)));
        user2.setSkills(new HashSet<Skill>(skillService.findAll().subList(0, 4)));
        user3.setSkills(new HashSet<Skill>(skillService.findAll().subList(0, 3)));
        user4.setSkills(new HashSet<Skill>(skillService.findAll().subList(0, 2)));

        userService.update(user1);
        userService.update(user2);
        userService.update(user3);
        userService.update(user4);
    }*/
}
