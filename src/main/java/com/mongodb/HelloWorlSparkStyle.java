package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Shuv_Oohl on 10/16/2015.
 */
public class HelloWorlSparkStyle {
    public static void main(String[] args) {
        Spark.get(new Route("/"){
            @Override
            public Object handle(final Request request, final Response response){
                return "Hello World From Spark";
            }
        });
    }
}
