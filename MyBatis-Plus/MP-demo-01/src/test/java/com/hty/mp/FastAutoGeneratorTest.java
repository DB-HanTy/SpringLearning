package com.hty.mp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false", "root", "123456")
                        .globalConfig(builder -> {
                            builder.author("hty") // 设置作者
//.enableSwagger() // 开启 swagger 模式
                                    .fileOverride() // 覆盖已生成文件
                                    //C:\Users\33038\Desktop\SpringLearning
                                    .outputDir("C://Users//33038//Desktop//SpringLearning//mybatis_plus"); // 指定输出目录
                        })
                        .packageConfig(builder -> {
                            builder.parent("com.hty") // 设置父包名
                                    .moduleName("mybatisplus") // 设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C://Users//33038//Desktop//SpringLearning//mybatis_plus"));
// 设置mapperXml生成路径
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("user"); // 设置需要生成的表名
                                    //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                        })
                        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                        .execute();
    }
}
