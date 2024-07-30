package UMC.TravelMate.domain.test.controller;


import UMC.TravelMate.global.common.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/example")
    public BaseResponse<String> example() {
        return BaseResponse.onSuccess( "예시 API");
    }
}
