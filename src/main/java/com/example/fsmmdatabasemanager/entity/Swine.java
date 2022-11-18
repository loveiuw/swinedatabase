package com.example.fsmmdatabasemanager.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@TableName(value = "swine")
public class Swine {
    @TableId(value = "swine_index")
    private Integer swineIndex;

    @TableField(value = "swine_id")
    private String swineTag;

    @TableField(value = "col_id")
    private String colId;

    @TableField(value = "sex")
    private String sex;

    @TableField(value = "ages")
    private Integer ages;

    @TableField(value = "weights")
    private String weights;

    @TableField(value = "assay_station")
    private String assayStation;
}
