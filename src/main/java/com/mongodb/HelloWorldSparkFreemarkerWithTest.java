package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuv_Oohl on 10/16/2015.
 */
public class HelloWorldSparkFreemarkerWithTest {
    public static void main(String[] args) {
        final Configuration config = new Configuration();
        config.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class,"/");


        Spark.get(new Route("/") {
            @Override
            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template hello = config.getTemplate("hello.ftl");


                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("name", "World");
                    hello.process(map, writer);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }

                return writer;
            }
        });

        Spark.get(new Route("/test") {
            @Override
            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template hello = config.getTemplate("hello.ftl");


                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("name", "Tester");
                    hello.process(map, writer);

                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }

                return writer;
            }
        });
    }
}
