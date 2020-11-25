package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * 标签业务逻辑类
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void add(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }


    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 封装查询对象
     * @param label
     * @return
     */
//    private Specification<Label> searchMap(Label label){
//        return
//    }
//
//    public List<Label> findSearch(final Label label){
//        return labelDao.findAll()
//    }
}
