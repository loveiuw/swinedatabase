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

@TableName(value = "admins")
public class Admins {
    @TableId(value = "admin_id")
    private int adminId;

    @TableField(value = "admin_account")
    private String adminAccount;

    @TableField(value = "admin_password")
    private String adminPassword;
}
