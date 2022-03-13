package com.yan1.answer.vo;

import lombok.Data;

@Data
public class QueryVO {
    private String searchKey;

    private int pageNo = 1;
    private int pageSize = 10;

}
