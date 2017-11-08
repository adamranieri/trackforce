package com.revature.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.revature.dao.BatchDao;
import com.revature.dao.BatchDaoHibernate;
import com.revature.entity.TfAssociate;
import com.revature.entity.TfBatch;

public class testBatchDaoHibernate {

    @Test(enabled =false)
    public void testgetBatchDetails() {
        Timestamp firstDate = Timestamp.valueOf("2017-09-10 10:10:10.0");
        Timestamp secondDate = Timestamp.valueOf("2017-12-30 10:10:10.0");
        BatchDao batchdao = new BatchDaoHibernate();
        List<TfBatch> batchlist = batchdao.getBatchDetails(firstDate, secondDate);
        Assert.assertNotNull(batchlist);
        System.out.println("Test Get Batch Details");
        System.out.println(batchlist);
    }

    @Test(enabled =false)
    public void testgetBatchDetailsNegative() {
        Timestamp firstDate = Timestamp.valueOf("2017-12-30 10:10:10.0");
        Timestamp secondDate = Timestamp.valueOf("2017-09-10 10:10:10.0");
        BatchDao batchdao = new BatchDaoHibernate();
        List<TfBatch> batchlist = batchdao.getBatchDetails(firstDate, secondDate);
        Assert.assertNotNull(batchlist);
        System.out.println("Test Get Batch Details Negative");
        System.out.println(batchlist);
    }

    @Test
    public void testGetBatch() {
        BatchDaoHibernate batch = new BatchDaoHibernate();
        TfBatch batchA = batch.getBatch("1709 Sept11 JTA");
        System.out.println(batchA.toString());
        System.out.println(batchA.getTfBatchStartDate());
        for (TfAssociate asc : batchA.getTfAssociates()) {
            System.out.println(asc.getTfAssociateFirstName());
        }
        System.out.println("Test Get Batch");
        Assert.assertNotNull(batchA);
    }

    @Test (enabled =false)
    public void testGetBatchNegative() {
        BatchDao batchDao = new BatchDaoHibernate();
        TfBatch batch = batchDao.getBatch("さいうえぁじぇうjp♫¥=⌐~ë");

        assertNotNull(batch);
        System.out.println("Test Get Batch Negative");
        System.out.println(batch);
    }
}