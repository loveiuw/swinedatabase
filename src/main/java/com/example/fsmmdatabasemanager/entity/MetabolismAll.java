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

@TableName(value = "metabolism_all")
public class MetabolismAll {
    @TableId(value = "name")
    private String name;

    @TableField(value = "metabolism_KEGG_ID")
    private String metabolismKE;

    @TableField(value = "metabolis_HMDB_ID")
    private String metabolisHMDBId;
}
