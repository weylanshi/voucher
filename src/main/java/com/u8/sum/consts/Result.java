package com.u8.sum.consts;



import java.util.HashMap;

/**
 * 返回值
 */
public class Result  extends HashMap<String,Object>{



    public static Result OK(){
        return OK("","");

    }
    public static  Result OK(String msg ,Object o){
        Result result = new Result();
        result.put("status",200);
        result.put("msg",msg);
        result.put("data",o);
        return result;
    }
    public static Result OK_MESSAGE(String msg){
        return  OK(msg,"");
    }
    public static Result OK_DATA(Object o){
        return OK("",o);
    }


    public static  Result ERROR(Integer status,String msg){
        Result result = new Result();
        result.put("status",status);
        result.put("msg",msg);
        result.put("data","");
        return result;
    }
    public static  Result ERROR(String msg){
        return  ERROR(500,msg);
    }

    public static Result ERROR(Exception e){
        return ERROR(500,e.getStackTrace()[0].toString());
    }

    public static Result ERROR_DATA(String msg,Object o){
        Result result = new Result();
        result.put("status",500);
        result.put("msg",msg);
        result.put("data",o);
        return result;
    }
}
