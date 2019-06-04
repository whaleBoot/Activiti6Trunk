package com.activiti6.demo.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BpmnModelReq
 * @Description TODO
 * @Author like
 * @Data 2018/10/17 10:26
 * @Version 1.0
 **/

@Data
@ApiModel
public class BpmnModelReq {

    @ApiModelProperty(value = "流程ID", notes = "流程ID", required = true, dataType = "String")
    @NotBlank(message = "流程ID不能为空")
    private String instanceKey;

    @ApiModelProperty(value = "UserTask节点", notes = "UserTask节点", required = true, dataType = "Map")
    private List<UserTaskReq> taskList;

    @ApiModelProperty(value = "resourceName", notes = "resourceName", required = true, dataType = "String")
    @NotBlank(message = "resourceName不能为空")
    private String resourceName;

    @ApiModelProperty(value = "name", notes = "name", required = true, dataType = "String")
    @NotBlank(message = "name不能为空")
    private String name;

    @ApiModelProperty(value = "filePath", notes = "bpmn文件目录", required = true, dataType = "String")
    @NotBlank(message = "filePath不能为空")
    private String filePath;

}
