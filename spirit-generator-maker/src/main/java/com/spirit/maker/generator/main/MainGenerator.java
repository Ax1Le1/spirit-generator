package com.spirit.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.spirit.maker.generator.JarGenerator;
import com.spirit.maker.generator.ScriptGenerator;
import com.spirit.maker.generator.file.DynamicFileGenerator;
import com.spirit.maker.meta.Meta;
import com.spirit.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * MainGenerator
 *
 * @author yaojc
 * @date 2024/3/12
 */
public class MainGenerator extends GenerateTemplate{
    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不生成dist");
    }

    public static void main(String[] args) throws Exception {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();

    }


}
