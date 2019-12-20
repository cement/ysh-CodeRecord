package cn.cement.ysh.automatic.entity;

import cn.cement.ysh.coderecord.base.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ysh
 * @since 2019-10-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="THotelRegister对象", description="")
public class THotelRegister extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "身份证号码")
    private String idcard;

    @ApiModelProperty(value = "宾馆名称")
    private String hotel;

    @TableField("roomNo")
    private String roomNo;

    @ApiModelProperty(value = "入住时间")
    @TableField("checkinTime")
    private LocalDateTime checkinTime;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;


}
