package cn.jiaminzhu.commons.result;

/**
 * @author guapi
 * @date 2021-02-25 21:09
 * @desc 业务异常
 */
public class BizException extends RuntimeException {

    private int code;

    public BizException(String message) {
        super(message);
        this.code = Constant.YES_ERROR;
    }

    public BizException(IResultCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
