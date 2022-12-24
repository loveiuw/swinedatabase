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

@TableName(value = "metabolism")
public class Metabolism {
    @TableId(value = "metabolism_index")
    private Integer metabolismInd;

    @TableField(value = "metabolism_name")
    private String metabolismName;

    @TableField(value = "Fold_change")
    private float foldChange;

    @TableField(value = "P_value")
    private float pValue;

    @TableField(value = "VIP")
    private float vip;

    @TableField(value = "Sample")
    private String sample;

    @TableField(value = "identification")
    private String identification;

    @TableField(value = "metabolism_time")
    private Integer time;

    @TableField(value = "metabolome_difference")
    private Integer metabolismdifference;


}
