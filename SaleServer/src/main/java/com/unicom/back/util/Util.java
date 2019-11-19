package com.unicom.back.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class Util {

    public static JSONObject getJsonObject(String code, String msg, String orderId) {
        String jsonstr="{\"code\":"+code+",\"data\":\""+msg+"\",\"orderId\":"+orderId+"}";
        return JSONObject.parseObject(jsonstr);
    }

    public static JSONObject getJsonObject(String str) {
        String jsonstr="{\"code\":20000,\"data\":"+str+",\"message\":\"生成成功\"}";
        return JSONObject.parseObject(jsonstr);
    }

    public static JSONObject getJsonObject(List list) {
        String jsonstr="{\"code\":20000,\"data\":{\"items\":"+ JSONArray.toJSONString(list) +",\"total\":"+list.size()+"},\"message\":\"生成成功\"}";
        return JSONObject.parseObject(jsonstr);
    }
}
