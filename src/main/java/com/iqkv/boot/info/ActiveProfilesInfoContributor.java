/*
 * Copyright 2025 IQKV Foundation Team, and the original author or authors from the JHipster project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iqkv.boot.info;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * An {@link org.springframework.boot.actuate.info.InfoContributor} that exposes the list of active spring profiles.
 */
public class ActiveProfilesInfoContributor implements InfoContributor {

  private static final String ACTIVE_PROFILES = "activeProfiles";
  private final List<String> profiles;

  /**
   * Constructor for ActiveProfilesInfoContributor.
   *
   * @param environment a {@link org.springframework.core.env.ConfigurableEnvironment} object.
   */
  public ActiveProfilesInfoContributor(ConfigurableEnvironment environment) {
    profiles = Arrays.asList(
        environment.getActiveProfiles().length == 0 ? environment.getDefaultProfiles() : environment.getActiveProfiles()
    );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void contribute(Info.Builder builder) {
    builder.withDetail(ACTIVE_PROFILES, profiles);
  }
}
