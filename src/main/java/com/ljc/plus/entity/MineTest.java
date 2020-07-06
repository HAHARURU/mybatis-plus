package com.ljc.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.ljc.plus.enums.GradeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljc
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MineTest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主鍵
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年级
     */
    private GradeEnum grade;

    /**
     * 是否可用
     */
    private Boolean valid;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
