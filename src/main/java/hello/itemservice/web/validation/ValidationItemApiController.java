package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    //json api로 받았을 때 검증.
    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {  //ItemSaveForm을 뷰에서가 아니라 json으로 받을 때.

        log.info("API 컨트롤러 호출");

        //오류 존재 시
        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 errors={}", bindingResult);
            return bindingResult.getAllErrors();   //필드 에러와 오브젝트 에러 모두 반환.
            //여기서는 예시로 보여주기 위해서 검증 오류 객체들을
            //그대로 반환했다. 실제 개발할 때는 이 객체들을 그대로 사용하지 말고, 필요한 데이터만 뽑아서 별도의 API
            //스펙을 정의하고 그에 맞는 객체를 만들어서 반환해야 한다

        }

        log.info("성공 로직 실행");
        return form;
    }
}