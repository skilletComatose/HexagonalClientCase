package co.com.ntt.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public  class GlobalResponse<T> {
    int code;
    Object msg;
    T data;
}
