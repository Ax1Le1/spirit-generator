package ${basePackage}.model;

import lombok.Data;

/**
* MainTemplateConfig
*
* @author yaojc
* @date 2024/2/20
*/
@Data
public class DataModel {
<#list modelConfig.models as modelInfo>
    <#if modelInfo.description??>
        /**
        * ${modelInfo.description}
        */
    </#if>
    private ${modelInfo.type} ${modelInfo.fieldName}<#if modelInfo.defaultValue??> = ${modelInfo.defaultValue?c}</#if>;
</#list>

}