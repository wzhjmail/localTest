package com.common;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSql {
    public static void main(String[] args) throws Exception {
        GeneratorSql generatorSql = new GeneratorSql();
        generatorSql.generator();
    }

    private void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String filepath = System.getProperty("user.dir") + "/src/main/resources";

        //指定 逆向工程配置文件
        File configFile = new File(filepath + "/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
