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
@ApiModel(value="TStudent对象", description="")
public class TStudent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String idcard;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "所属院系")
    private String department;

    @ApiModelProperty(value = "班级")
    @TableField("class")
    private String clazz;

    @ApiModelProperty(value = "头像")
    private String photo;

    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;


}
