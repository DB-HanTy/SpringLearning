package com.hty.mp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false", "root", "123456")
                        .globalConfig(builder -> {
                            builder.author("hty") // ��������
//.enableSwagger() // ���� swagger ģʽ
                                    .fileOverride() // �����������ļ�
                                    //C:\Users\33038\Desktop\SpringLearning
                                    .outputDir("C://Users//33038//Desktop//SpringLearning//mybatis_plus"); // ָ�����Ŀ¼
                        })
                        .packageConfig(builder -> {
                            builder.parent("com.hty") // ���ø�����
                                    .moduleName("mybatisplus") // ���ø���ģ����
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C://Users//33038//Desktop//SpringLearning//mybatis_plus"));
// ����mapperXml����·��
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("user"); // ������Ҫ���ɵı���
                                    //.addTablePrefix("t_", "c_"); // ���ù��˱�ǰ׺
                        })
                        .templateEngine(new FreemarkerTemplateEngine()) // ʹ��Freemarker����ģ�壬Ĭ�ϵ���Velocity����ģ��
                        .execute();
    }
}
