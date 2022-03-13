package com.yan1.answer.controller;


import com.yan1.answer.entity.QuestionAndAnswer;
import com.yan1.answer.service.QaService;
import com.yan1.answer.vo.QueryVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/qa")
public class QaController {

    @Resource
    private QaService qaService;

    /**
     * 查看问题和答案
     *
     * @param queryVO
     * @return
     */
    @GetMapping("/query")
    public List<QuestionAndAnswer> queryQa(QueryVO queryVO) {
        return qaService.queryQa(queryVO);
    }

}
