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
    private int swineIndex;

    @TableField(value = "swine_tag")
    private String swineTag;

    @TableField(value = "col_id")
    private String colId;

    @TableField(value = "sex")
    private String sex;

    @TableField(value = "ages")
    private int ages;

    @TableField(value = "weights")
    private String weights;

    @TableField(value = "assay_station")
    private String assayStation;
}
