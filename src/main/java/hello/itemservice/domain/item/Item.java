package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총 합이 10000원 넘게 입력해주세요")  //객체 오류 검증-> 이 방법은 제약이 많음.
public class Item {

    private Long id;

    @NotBlank(message="공백x")
    private String itemName;

    @NotNull
    @Range(min=1000,max=1000000)
    private Integer price;

    @NotNull
    @Max(999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
