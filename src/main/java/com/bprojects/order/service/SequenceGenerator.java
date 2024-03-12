package com.bprojects.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bprojects.order.entity.Sequence;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderId(){
//        Sequence counter = mongoOperations.findAndModify(
//                query(org.springframework.data.mongodb.core.query.Criteria.where("_id").is("sequence")),
//                new Update().inc("sequence", 1),
//                options().returnNew(true).upsert(true),
//                Sequence.class);
    	Query query = new Query(Criteria.where("_id").is("sequence"));
        Sequence counter = mongoOperations.findAndModify(
                query,
                new Update().inc("sequence", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class);
        return counter.getSequence();

    }



}