package net.marco27.java.boilerplate.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@SpringBootTest
@ActiveProfiles("test")
class AppYmlConfigTest {

    @Autowired
    AppYmlConfig appYmlConfig;

    @Test
    void testGetVersion() {
        assertThat(appYmlConfig.getVersion(), notNullValue());
        assertThat(appYmlConfig.getVersion(), is("v1"));
    }

}
