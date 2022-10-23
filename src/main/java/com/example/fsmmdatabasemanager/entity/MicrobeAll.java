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

@TableName(value = "microbe_all")
public class MicrobeAll {
    @TableId(value = "microbe_index")
    private int microbeIndex;

    @TableField(value = "microbe_name")
    private String microbeName;

    @TableField(value = "Taxonomy")
    private String taxonomy;
}
