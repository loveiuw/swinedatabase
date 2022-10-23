package com.example.fsmmdatabasemanager.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.ValidationEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@TableName(value = "microbe")
public class Microbe {
    @TableId(value = "microbe_id")
    private int microbeId;

    @TableField(value = "taxonomy")
    private String taxonomy;

    @TableField(value = "microbe_Name")
    private String microbeName;

    @TableField(value = "col")
    private String col;

    @TableField(value = "days")
    private int days;

    @TableField(value = "abundance")
    private float abundance;

    @TableField(value = "P_value_dpf_tpf")
    private float pValueDpfTpf;

    @TableField(value = "P_value_age")
    private float pValueAge;
}
