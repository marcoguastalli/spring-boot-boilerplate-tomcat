package net.marco27.java.boilerplate;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppConstantsTest {

    public static final String JUST_A_TIMESTAMP = "2025-04-13T11:12:13";

    @Test
    void testConstants() {
        assertThat(AppConstants.LOGS_FOLDER, is("logs"));
        assertThat(AppConstants.SLASH, is("/"));
        assertThat(AppConstants.JUST_A_DATE, is("2025-04-13"));
        assertThat(AppConstants.JUST_A_TIME, is("11:12:13"));
    }
}
