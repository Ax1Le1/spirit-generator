package com.spirit.maker.generator.file;

/**
 * MainGenerator
 *
 * @author yaojc
 * @date 2024/2/21
 */

import cn.hutool.extra.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 第二期の核心生成器
 */
public class FileGenerator {
    /**
     * 生成静态文件和动态文件
     *
     * @param model
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException, freemarker.template.TemplateException {
        // 当前idea打开的窗口
        String projectPath = System.getProperty("user.dir");
        // 找整个项目的根路径 dexcode-generator
        File projectFile = new File(projectPath);
        // 输入路径 ACM的示例模板 在 dexcode-generator-demo-projects 目录下
        String inputPath = new File(projectFile + "/spirit-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成动态文件，会覆盖部分已生成的静态文件
        String inputDynamicFilePath = projectPath + "/spirit-generator-maker/src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = projectPath + "/spirit-generator-demo-projects/acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }
}
