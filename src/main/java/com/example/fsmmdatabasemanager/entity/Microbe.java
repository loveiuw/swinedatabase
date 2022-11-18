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

@TableName(value = "microbe")
public class Microbe {
    @TableId(value = "microbe_id")
    private Integer microbeId;

    @TableField(value = "taxonomy")
    private String taxonomy;

    @TableField(value = "microbe_Name")
    private String microbeName;

    @TableField(value = "col")
    private String col;

    @TableField(value = "days")
    private Integer days;

    @TableField(value = "abundance")
    private float abundance;

    @TableField(value = "P_value_dpf_tpf")
    private float pValueDpfTpf;

    @TableField(value = "P_value_age")
    private float pValueAge;
}
