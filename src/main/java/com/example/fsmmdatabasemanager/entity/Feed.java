package com.example.fsmmdatabasemanager.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "feed")


public class Feed {
    @TableId(value = "Feed_index")
    private int feedIndex;

    @TableField(value = "tag")
    private String tag;

    @TableField(value = "time")
    private int time;

    @TableField(value = "Nurseing_feed_percentage")
    private float nurseingFeedPercentage;

    @TableField(value = "Phase_1_feed_percentage")
    private float phase1FeedPercentage;

    @TableField(value = "Phase_2_feed_percentage")
    private float phase2FeedPercentage;

    @TableField(value = "Phase_3_feed_percentage")
    private float phase3FeedPercentage;

    @TableField(value = "day_of_intake")
    private float dayOfIntake;
}
