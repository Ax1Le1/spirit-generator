package com.spirit.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.spirit.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 * ConfigCommand
 *
 * @author yaojc
 * @date 2024/3/11
 */
@CommandLine.Command(name = "config", mixinStandardHelpOptions = true)
@Data
public class ConfigCommand implements Runnable {
    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println(field.getType());
            System.out.println(field.getName());
            System.out.println("---");
        }
    }
}
