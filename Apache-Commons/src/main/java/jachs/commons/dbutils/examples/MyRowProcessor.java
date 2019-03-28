package jachs.commons.dbutils.examples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.RowProcessor;

public class MyRowProcessor implements RowProcessor {

	@Override
	public Object[] toArray(ResultSet rs) throws SQLException {
		return null;
	}

	@Override
	public <T> T toBean(ResultSet rs, Class<? extends T> type) throws SQLException {
		return null;
	}

	@Override
	public <T> List<T> toBeanList(ResultSet rs, Class<? extends T> type) throws SQLException {
		return null;
	}

	@Override
	public Map<String, Object> toMap(ResultSet rs) throws SQLException {
		return null;
	}

}
