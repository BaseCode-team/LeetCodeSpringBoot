package study.team.leetcode.share.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.study.common.base.model.ddd.ValueObject;

import java.util.Objects;

/**
 * 地址值对象
 *
 * @author JiaHao
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address implements ValueObject<Address> {

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;

    /**
     * 比较地址相等
     *
     * @param address 地址
     * @return boolean
     */
    @Override
    public boolean sameValueAs(Address address) {
        return Objects.equals(this, address);
    }

}
