package com.example.fsmmdatabasemanager.utils;

public enum FeedEnum {
    Feed_index("Feed_index", "num"),
    tag("tag", "varchar"),
    time("time", "num"),
    Nurseing_feed_percentage("Nurseing_feed_percentage", "num"),
    Phase_1_feed_percentage("Phase_1_feed_percentage", "num"),
    Phase_2_feed_percentage("Phase_2_feed_percentage", "num"),
    Phase_3_feed_percentage("Phase_3_feed_percentage", "num"),
    day_of_intake("day_of_intake", "num"),
    others("others", "none");

    private final String name;
    private final String desc;

    FeedEnum(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public static FeedEnum getType(String name){
        for(FeedEnum feedEnum : values()){
            if(feedEnum.getName().equals(name))
                return feedEnum;
        }
        return others;
    }

    public String getName(){
        return this.name;
    }

    public String getDesc(){ return this.desc; }

    public boolean isNumberAttribute(){
        return getDesc().equals("num");
    }

    public boolean isStringAttribute(){
        return getDesc().equals("varchar");
    }
}
