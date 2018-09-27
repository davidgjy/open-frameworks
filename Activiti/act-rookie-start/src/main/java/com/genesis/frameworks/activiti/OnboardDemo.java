package com.genesis.frameworks.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午3:15 2018/9/27
 * @modified by:
 */

public class OnboardDemo {
    public static void main(String... args) {
        ProcessEngineConfiguration cfg = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = cfg.buildProcessEngine();

        // 启动流程
        ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey("onboarding");
        System.out.println("process id" + pi.getId());
        System.out.println("process name" + pi.getName());

        // 获取任务
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().taskAssignee("lili").list();
        System.out.println("任务个数" + list.size());
        if (list != null && list.size() > 0) {
            for (Task t : list) {
                System.out.print(t.getId() + ",");
                System.out.print(t.getName() + ",");
                System.out.print(t.getAssignee() + ",");
                System.out.println(t.getProcessInstanceId());
            }
        }
    }
}
