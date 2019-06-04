package com.activiti6.demo.util;

import org.activiti.bpmn.model.*;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * @ClassName BpmnUtil
 * @Description 绘制流程图工具类
 * @Author like
 * @Data 2018/10/16 13:59
 * @Version 1.0
 **/

public class BpmnUtil {


    /**
     * 任务节点
     *
     * @param id
     * @param name
     * @param assignee
     * @return
     */
    public static UserTask createUserTask(String id, String name, String assignee) {

        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        return userTask;

    }

    /**
     * 连线箭头
     *
     * @param from
     * @param to
     * @return
     */
    public static SequenceFlow createSequenceFlow(String from, String to, String name, String conditionExpression) {

        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        flow.setName(name);
        if (StringUtils.isNotBlank(conditionExpression)) {
            flow.setConditionExpression(conditionExpression);
        }
        return flow;

    }

    /**
     * 连线箭头，头为List，多对一
     *
     * @param from
     * @param to
     * @return
     */
    public static SequenceFlow createSequenceFlow(List<String> from, String to) {

        SequenceFlow flow = new SequenceFlow();
        for (String elem : from) {
            flow.setSourceRef(elem);
        }
        flow.setTargetRef(to);
        return flow;
    }

    /**
     * 排他网关
     *
     * @param id
     * @return
     */
    public static ExclusiveGateway createExclusiveGateway(String id) {
        ExclusiveGateway exclusiveGateway = new ExclusiveGateway();
        exclusiveGateway.setId(id);
        return exclusiveGateway;
    }


    /**
     * 并行网关
     *
     * @param id
     * @return
     */
    public static ParallelGateway createParallelGateWar(String id) {
        ParallelGateway parallelGateway = new ParallelGateway();
        parallelGateway.setId(id);
        return parallelGateway;
    }

    /**
     * 开始节点
     *
     * @return
     */
    public static StartEvent createStartEvent() {

        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        return startEvent;

    }

    /**
     * 结束节点
     *
     * @return
     */
    public static EndEvent createEndEvent() {

        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        return endEvent;
    }


}
