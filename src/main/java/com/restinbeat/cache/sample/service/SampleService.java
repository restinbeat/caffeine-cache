package com.restinbeat.cache.sample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SampleService {

    @Cacheable(value = "api.sample", key = "#sampleId")
    public String getSample(String sampleId) {

        // TODO: repository - db 통신 로직 구현

        return "sample";
    }
}
