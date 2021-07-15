package com.jachs.commons.dbcp;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

public class MyTransactionManager implements TransactionManager {

	public void begin() throws NotSupportedException, SystemException {
		System.out.println("开始执行SQL");
	}

	public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
			SecurityException, IllegalStateException, SystemException {
		System.out.println("开始提交SQL");

	}

    /** 
     * @Title: getStatus
     * @Description: TODO
     * @return
     * @throws SystemException 
     * @see javax.transaction.TransactionManager#getStatus() 
     */ 
    public int getStatus () throws SystemException {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @Title: getTransaction
     * @Description: TODO
     * @return
     * @throws SystemException 
     * @see javax.transaction.TransactionManager#getTransaction() 
     */ 
    public Transaction getTransaction () throws SystemException {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * @Title: resume
     * @Description: TODO
     * @param tobj
     * @throws InvalidTransactionException
     * @throws IllegalStateException
     * @throws SystemException 
     * @see javax.transaction.TransactionManager#resume(javax.transaction.Transaction) 
     */ 
    public void resume ( Transaction tobj ) throws InvalidTransactionException, IllegalStateException, SystemException {
        // TODO Auto-generated method stub
        
    }

    /** 
     * @Title: rollback
     * @Description: TODO
     * @throws IllegalStateException
     * @throws SecurityException
     * @throws SystemException 
     * @see javax.transaction.TransactionManager#rollback() 
     */ 
    public void rollback () throws IllegalStateException, SecurityException, SystemException {
        // TODO Auto-generated method stub
        
    }

    /** 
     * @Title: setRollbackOnly
     * @Description: TODO
     * @throws IllegalStateException
     * @throws SystemException 
     * @see javax.transaction.TransactionManager#setRollbackOnly() 
     */ 
    public void setRollbackOnly () throws IllegalStateException, SystemException {
        // TODO Auto-generated method stub
        
    }

    /** 
     * @Title: setTransactionTimeout
     * @Description: TODO
     * @param seconds
     * @throws SystemException 
     * @see javax.transaction.TransactionManager#setTransactionTimeout(int) 
     */ 
    public void setTransactionTimeout ( int seconds ) throws SystemException {
        // TODO Auto-generated method stub
        
    }

    /** 
     * @Title: suspend
     * @Description: TODO
     * @return
     * @throws SystemException 
     * @see javax.transaction.TransactionManager#suspend() 
     */ 
    public Transaction suspend () throws SystemException {
        // TODO Auto-generated method stub
        return null;
    }


}
