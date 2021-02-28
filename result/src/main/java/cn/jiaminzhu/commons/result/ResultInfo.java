package cn.jiaminzhu.commons.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guapi
 * @date 2021-02-25 21:01
 * @desc
 */
public class ResultInfo<T extends Object> implements Serializable {

    private ResultInfo() {}

    private ResultInfo(T data, long count) {
        this.data = data;
    }

    private ResultInfo(T data) {
        this.data = data;
        this.message = "成功";
    }

    private ResultInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResultInfo pageSuccess(T data, Integer count) {
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("data", data);
        resultMap.put("totalCount", count);
        return new ResultInfo<>(resultMap);
    }

    public static <T> ResultInfo success(T data) {
        return new ResultInfo<>(data);
    }

    public static ResultInfo fail(Integer code, String message) {
        return new ResultInfo(code, message);
    }

    public static ResultInfo fail(ResultCode resultCode) {
        return ResultInfo.fail(resultCode.getCode(), resultCode.getMessage());
    }

    public static ResultInfo failFormat(ResultCode resultCode, Object... args) {
        String message = resultCode.getMessage();
        if (args != null && args.length != 0) {
            message = String.format(resultCode.getMessage(), args);
        }
        Integer code = resultCode.getCode();
        return ResultInfo.fail(code, message);
    }

    /**
     * 错误信息
     */
    private String message;
    /**
     * 错误号
     */
    private Integer code = Constant.NOT_ERROR;
    /**
     * 返回数据
     */
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
