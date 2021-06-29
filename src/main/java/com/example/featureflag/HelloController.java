/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.example.featureflag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microsoft.azure.spring.cloud.feature.manager.FeatureManager;

@RestController
public class HelloController {

    @Autowired
    private FeatureManager featureManager;

    @GetMapping("")
    public String getFeatureFlag() throws JsonProcessingException {

        String beta = featureManager.isEnabledAsync("Beta").block() ? "Beta On" : "Beta Off";
        return "Message: " + beta;
    }

}
