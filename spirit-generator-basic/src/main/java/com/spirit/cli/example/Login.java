package com.spirit.cli.example;

import com.spirit.cli.utils.OptionUtil;
import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, arity = "0..1", description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true)
    String password;

    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "Check Password", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        // 打印出密码
        System.out.println("密码是：" + password);
        System.out.println("确认密码是：" + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        // 第三期直播方式：
        // new CommandLine(new Login()).execute("-u", "user123", "-p", "xxx", "-cp");

        // 强制交互式：传递类的字节码 和 args参数
        args = new String[]{"-u", "user123", "-p"};
        new CommandLine(new Login()).execute(OptionUtil.processInteractiveOptions(Login.class, args));
    }
}