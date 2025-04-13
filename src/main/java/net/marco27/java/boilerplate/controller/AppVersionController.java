package net.marco27.java.boilerplate.controller;

import lombok.extern.slf4j.Slf4j;
import net.marco27.java.boilerplate.config.AppYmlConfig;
import net.marco27.java.boilerplate.domain.JsonResponseResult;
import net.marco27.java.boilerplate.domain.VersionBean;
import net.marco27.java.boilerplate.service.ResponseTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static net.marco27.java.boilerplate.AppConstants.SLASH;
import static net.marco27.java.boilerplate.domain.VersionBean.VERSION;

@RestController
@RequestMapping(SLASH + VERSION)
@Slf4j
public class AppVersionController {

    private final AppYmlConfig appYmlConfig;
    private final ResponseTimeService responseTimeService;

    @Autowired
    public AppVersionController(final AppYmlConfig appYmlConfig, final ResponseTimeService responseTimeService) {
        this.appYmlConfig = appYmlConfig;
        this.responseTimeService = responseTimeService;
    }

    @GetMapping("/version")
    public ResponseEntity<JsonResponseResult> releaseNotes() {
        // start
        final StopWatch stopWatch = new StopWatch("AppVersionController.releaseNotes");
        stopWatch.start();
        responseTimeService.startTime();

        // do
        final VersionBean versionBean = new VersionBean();
        log.debug("Version: {}", appYmlConfig.getVersion());

        // end
        responseTimeService.endTime();
        log.info("Response time: {}ms", responseTimeService.getResponseTime());
        stopWatch.stop();
        log.info(stopWatch.shortSummary());

        return ResponseEntity.ok(new JsonResponseResult(versionBean));
    }
}
