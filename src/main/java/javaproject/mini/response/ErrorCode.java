package javaproject.mini.response;

import lombok.Getter;

@Getter
public enum ErrorCode {
    BAD_REQUEST_ERROR(400, "G001", "Bad Request Exception"),
    FORBIDDEN_ERROR(403, "G008", "Forbidden Exception"),
    NOT_FOUND_ERROR(404, "G009", "Not Found Exception"),
    INTERNAL_SERVER_ERROR(500, "G999", "Internal Server Error Exception");

    private final int status;
    private final String statusCode;
    private final String message;

    ErrorCode(final int status, final String statusCode, final String message) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }
}