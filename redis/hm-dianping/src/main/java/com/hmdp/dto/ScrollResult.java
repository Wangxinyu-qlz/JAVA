package com.hmdp.dto;

import lombok.Data;

import java.util.List;

/**
 * 滚动查询实体
 * <br>
 * 滚动查询的要素：
 * ori:   10 9  8 7 6 5 4 3 2 1         select 10 ~ 6 (page=2, size=5)
 * update:11 10 9 8 7 6 5 4 3 2 1       select 6 ~ 2  (page=2, size=5)
 * 所以不能使用数据角标作为查询依据，而是使用时间戳（从何处开始）和偏移量（查几条）作为查询依据
 * 在分布式情况下，时间戳有可能重复
 * ori:   10 9 8 7 6 5 4 3 2 1
 * score: 10 9 8 7 6 6 5 4 3 2          这里有一条重复的时间戳
 * update:11 10 9 8 7 6 5 4 3 2 1
 * score: 10 9  8 7 6 6 5 4 3 2         这里需要记录上一次查询的结果中，有几条重复
 */
@Data
public class ScrollResult {
    private List<?> list;
    private Long minTime;
    private Integer offset;
}
