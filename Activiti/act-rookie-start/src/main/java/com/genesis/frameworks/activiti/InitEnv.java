package com.genesis.frameworks.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午2:33 2018/9/27
 * @modified by:
 */

public class InitEnv {
    public static void main(String... args) {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = cfg.buildProcessEngine();

    }
}
