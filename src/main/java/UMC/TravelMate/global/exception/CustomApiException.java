package UMC.TravelMate.global.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomApiException extends RuntimeException{
    private ErrorCode errorCode;
}
