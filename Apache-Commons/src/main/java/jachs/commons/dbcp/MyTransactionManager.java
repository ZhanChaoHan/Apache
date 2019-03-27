package jachs.commons.dbcp;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

public class MyTransactionManager implements TransactionManager {

	@Override
	public void begin() throws NotSupportedException, SystemException {
		System.out.println("开始执行SQL");
	}

	@Override
	public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
			SecurityException, IllegalStateException, SystemException {
		System.out.println("开始提交SQL");

	}

	@Override
	public int getStatus() throws SystemException {
		System.out.println("获取状态默认返回0");
		return 0;
	}

	@Override
	public Transaction getTransaction() throws SystemException {
		return null;
	}

	@Override
	public void resume(Transaction tobj) throws InvalidTransactionException, IllegalStateException, SystemException {

	}

	@Override
	public void rollback() throws IllegalStateException, SecurityException, SystemException {

	}

	@Override
	public void setRollbackOnly() throws IllegalStateException, SystemException {

	}

	@Override
	public void setTransactionTimeout(int seconds) throws SystemException {

	}

	@Override
	public Transaction suspend() throws SystemException {
		return null;
	}

}
