package com.spirit.cli;

import com.spirit.cli.command.ConfigCommand;
import com.spirit.cli.command.GenerateCommand;
import com.spirit.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * CommandExecutor
 *
 * @author yaojc
 * @date 2024/3/11
 */
@Command(name = "spirit", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入具体命令,或者输入--help  查看命令提示");
    }

    //执行命令
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
