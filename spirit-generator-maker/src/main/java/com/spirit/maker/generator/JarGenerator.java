package com.spirit.maker.generator;

import java.io.*;

/**
 * JarGenerator
 *
 * @author yaojc
 * @date 2024/3/12
 */
public class JarGenerator {
    public static void doGenerate(String projectDir) throws Exception {
        //调用Process 类执行Maven打包命令
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";
        String mavenCommand = winMavenCommand;


        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        System.out.println(processBuilder.environment());

        Process process = processBuilder.start();

        //读取命令输出
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        int exitcode = process.waitFor();
        System.out.println("命令执行结束，退出码" + exitcode);

    }

    public static void main(String[] args) throws Exception {
        // 测试用
        doGenerate("D:\\yupi\\spirit-generator\\spirit-generator-maker\\generated");
    }
}
