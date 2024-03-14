package com.spirit.maker.meta;

/**
 * 元信息异常
 *
 * @author yaojc
 * @date 2024/3/13
 */
public class MetaException extends RuntimeException {

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
