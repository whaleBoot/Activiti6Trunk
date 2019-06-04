package com.activiti6.demo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @ClassName UserTaskReq
 * @Description bomn文件定义
 * @Author like
 * @Data 2018/10/17 10:59
 * @Version 1.0
 **/

@Data
public class UserTaskReq implements Comparable<UserTaskReq> {

    /*用于排序*/
    private Integer index;

    private String id;

    private String name;

    private String assignee;

    private String type;

    private List<String> predecessor;

    private String conditionExpression;

    private String lineName;

    private String isEnd;

    @Override
    public int compareTo(UserTaskReq o) {
        if (this.getIndex() > o.getIndex()) {
            return 1;
        } else {
            return -1;
        }
    }
}
