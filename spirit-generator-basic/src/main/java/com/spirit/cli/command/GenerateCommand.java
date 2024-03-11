package com.spirit.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.spirit.generator.MainGenerator;
import com.spirit.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * GenerateCommand
 *
 * @author yaojc
 * @date 2024/3/11
 */
@CommandLine.Command(name = "generate",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable {
    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true,echo = true)
    String loop;

    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者名称", interactive = true,echo = true)
    String author;

    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true,echo = true)
    String outputText;


    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
