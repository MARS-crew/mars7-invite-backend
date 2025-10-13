package project.mars7invite.common.handler;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import project.mars7invite.common.exception.BaseException;
import project.mars7invite.common.exception.BaseExceptionType;
import project.mars7invite.common.exception.ExceptionType;
import project.mars7invite.common.response.ApiResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    ApiResponse<?> handleBaseException(HttpServletRequest request, BaseException e) {
        ExceptionType exceptionType = e.exceptionType();
        log.warn("{} URI: {}", exceptionType.getMessage(), request.getRequestURI());
        return ApiResponse.error(exceptionType.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ApiResponse<?> handleMethodArgumentNotValidException(HttpServletRequest request,
        MethodArgumentNotValidException e) {
        log.warn("요청 인자가 올바르지 않습니다 URI: {}", request.getRequestURI());
        return ApiResponse.error(BaseExceptionType.ARGUMENT_NOT_VALID.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ApiResponse<?> handleException(HttpServletRequest request, Exception e) {
        log.error("예상하지 못한 예외가 발생했습니다. URI: {}, 내용: {}", request.getRequestURI(), convertToString(e));
        return ApiResponse.error(BaseExceptionType.UNKNOWN_SERVER_ERROR.getMessage());
    }

    private String convertToString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}