package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuv_Oohl on 10/16/2015.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class,"/");

        try{
            Template hello = config.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name","Dan");
            hello.process(map, writer);
            System.out.println(writer);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
