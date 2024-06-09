package javaproject.mini.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private T data;
    private String message;

    @Builder
    public ApiResponse(final T data, final String message) {
        this.data = data;
        this.message = message;
    }
}