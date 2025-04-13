package net.marco27.java.boilerplate.controller;

import net.marco27.java.boilerplate.config.AppYmlConfig;
import net.marco27.java.boilerplate.domain.JsonResponseResult;
import net.marco27.java.boilerplate.domain.VersionBean;
import net.marco27.java.boilerplate.service.ResponseTimeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static net.marco27.java.boilerplate.AppConstantsTest.JUST_A_TIMESTAMP;
import static net.marco27.java.boilerplate.domain.VersionBean.VERSION;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class AppVersionControllerTest {

    @Autowired
    AppYmlConfig appYmlConfig;

    AppVersionController appVersionController;
    ResponseTimeService responseTimeService;

    @BeforeEach
    void init() {
        responseTimeService = new ResponseTimeService();
        appVersionController = new AppVersionController(appYmlConfig, responseTimeService);
    }

    @Test
    void testReleaseNotes() {
        final ResponseEntity<JsonResponseResult> response = appVersionController.releaseNotes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        final JsonResponseResult jsonResponseResult = response.getBody();
        assertThat(jsonResponseResult, notNullValue());
        final VersionBean versionBean = (VersionBean) jsonResponseResult.getResult();
        assertThat(versionBean, notNullValue());
        assertThat(versionBean.getVersion(), is(VERSION));
        assertThat(versionBean.getLastUpdate().toString(), is(JUST_A_TIMESTAMP));
    }

}
