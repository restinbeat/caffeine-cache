package com.restinbeat.cache.sample.api;

import com.restinbeat.cache.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sample")
public class SampleRestController {

    private final SampleService sampleService;

    @GetMapping
    public String getSample(String sampleId) {
        return sampleService.getSample(sampleId);
    }

}
