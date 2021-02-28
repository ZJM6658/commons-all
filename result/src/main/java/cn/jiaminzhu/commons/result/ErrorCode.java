package cn.jiaminzhu.commons.result;

/**
 * @author guapi
 * @date 2021-02-25 21:03
 * @desc
 */
public class ErrorCode implements ResultCode {

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode(String message) {
        this.code = 999999;
        this.message = message;
    }

    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
