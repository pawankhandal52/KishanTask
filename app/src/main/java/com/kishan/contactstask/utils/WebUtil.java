/*
 * *
 *  * Created by Pawan Kumar Sharma on 11/10/19 3:14 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/2/19 4:51 PM
 *
 */

package com.kishan.contactstask.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class WebUtil {

    public static Map<String, Object> toMap(Object obj) {
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(obj);
        return gson.fromJson(json, Map.class);
    }
}
