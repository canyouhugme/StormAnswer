package com.yan1.answer.service;


import com.yan1.answer.entity.QuestionAndAnswer;
import com.yan1.answer.vo.QueryVO;

import java.util.List;

public interface QaService {
    List<QuestionAndAnswer> queryQa(QueryVO queryVO);
}
