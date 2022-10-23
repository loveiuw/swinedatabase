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

@TableName(value = "feed_ingredient")
public class FeedIngredient {
    @TableId(value = "Item")
    private String item;

    @TableField(value = "Nursing_feed_ingredient")
    private float nursingFeedIngredient;

    @TableField(value = "Phase_1_feed_ingredient")
    private float phase1FeedIngredient;

    @TableField(value = "Phase_2_feed_ingredient")
    private float phase2FeedIngredient;

    @TableField(value = "Phase_3_feed_ingredient")
    private float phase3FeedIngredient;
}
