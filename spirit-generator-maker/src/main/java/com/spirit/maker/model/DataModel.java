package com.spirit.maker.model;

import lombok.Data;

/**
 * MainTemplateConfig
 *
 * @author yaojc
 * @date 2024/2/20
 */
@Data
public class DataModel {
    /**
     * 是否生成循环
     */
    private boolean loop;
    /**
     * 作者注释
     */
    private String author;
    /**
     * 输出信息
     */
    private String outputText;
}