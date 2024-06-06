package javaproject.mini.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private String reason;
    private String message;

    @Builder
    protected ErrorResponse(final ErrorCode code, final String reason) {
        this.reason = reason;
        this.message = code.getMessage();
    }

    public static ErrorResponse of(final ErrorCode code, final String reason) {
        return new ErrorResponse(code, reason);
    }
}