package com.heika.test.services.user.impl;

import com.heika.test.dao.card.CardProductDao;
import com.heika.test.entities.card.CardProductEntity;
import com.heika.test.services.user.CardProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015/9/14.
 */
@Transactional
@Service
public class CardProductImpl implements CardProductService
{
    @Autowired
    CardProductDao cardProductDao;

    @Override
    public List<Integer> getAllIds()
    {
        List<CardProductEntity> regions = this.cardProductDao.findAll(CardProductEntity.class);
        List<Integer> ids = new ArrayList<>();

        for(CardProductEntity cardProductEntity: regions)
        {
            ids.add(cardProductEntity.getId());
        }

        return ids;
    }
}
