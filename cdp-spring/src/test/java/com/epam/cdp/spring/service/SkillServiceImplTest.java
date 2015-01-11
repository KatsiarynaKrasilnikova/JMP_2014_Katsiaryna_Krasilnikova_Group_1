package com.epam.cdp.spring.service;

import com.epam.cdp.hibernate.model.Skill;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SkillServiceImplTest extends AbstractServiceTest {

    @Autowired
    private ISkillService skillService;

    @Test
    @Ignore
    public void testFindMostPopularSkills() throws Exception {
        int maxResults = 5;
        List<Skill> skills = skillService.findMostPopularSkills(maxResults);

        assertThat(skills.size(), is(maxResults));
        assertThat(skills, contains(
                allOf(
                        hasProperty("id", is(5L)),
                        hasProperty("name", is("Skill5"))
                ),
                allOf(
                        hasProperty("id", is(4L)),
                        hasProperty("name", is("Skill4"))
                ),
                allOf(
                        hasProperty("id", is(3L)),
                        hasProperty("name", is("Skill3"))
                ),
                allOf(
                        hasProperty("id", is(2L)),
                        hasProperty("name", is("Skill2"))
                ),
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("name", is("Skill1"))
                )
        ));
    }

    @Test
    @Ignore
    public void testFindAllNotPresentedSkills() {
        List<Skill> skills = skillService.findAllNotPresentedSkills();

        assertThat(skills.size(), is(5));
        assertThat(skills, contains(
                allOf(
                        hasProperty("id", is(6L)),
                        hasProperty("name", is("Skill6"))
                ),
                allOf(
                        hasProperty("id", is(7L)),
                        hasProperty("name", is("Skill7"))
                ),
                allOf(
                        hasProperty("id", is(8L)),
                        hasProperty("name", is("Skill8"))
                ),
                allOf(
                        hasProperty("id", is(9L)),
                        hasProperty("name", is("Skill9"))
                ),
                allOf(
                        hasProperty("id", is(10L)),
                        hasProperty("name", is("Skill10"))
                )
        ));
    }
}