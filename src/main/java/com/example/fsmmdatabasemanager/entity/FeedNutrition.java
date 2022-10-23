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

@TableName(value = "feed_nutrition")
public class FeedNutrition {
    @TableId(value = "Item")
    private String item;

    @TableField(value = "Nursing_feed_nutrition")
    private float nursingFeedNutrition;

    @TableField(value = "Phase_1_feed_nutrition")
    private float phase1FeedNutrition;

    @TableField(value = "Phase_2_feed_nutrition")
    private float phase2FeedNutrition;

    @TableField(value = "Phase_3_feed_nutrition")
    private float phase3FeedNutrition;
}
