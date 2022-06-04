package vn.techmaster.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class HandleException {
    // Xử lý cho trường hợp BadRequest
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleBadRequestException(BadRequestException e) {
        // Log lỗi ở đây
        log.error("Exception occurs!");
        // Log lỗi ra file
        return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    // Xử lý cho trường hợp NotFound
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleNotFoundException(NotFoundException e) {
        // Log lỗi ở đây
        log.error("Exception occurs!");
        // Log lỗi ra file
        return new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
    }

    // Xử lý cho trường hợp Login failed
    @ExceptionHandler(LoginFailedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage handleLoginFailedException(LoginFailedException e) {
        // Log lỗi ở đây
        log.error("Exception occurs!");
        // Log lỗi ra file
        return new ErrorMessage(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    // Xử lý cho các trường hợp còn lại
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleOtherException(Exception e) {
        // Log lỗi ở đây
        log.error("Exception occurs!");
        // Log lỗi ra file
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
