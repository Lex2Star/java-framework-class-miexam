package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hyunki on 2017. 4. 21..
 */
public class StatementStrategyForUpdate implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object obj, Connection connection) throws SQLException {
        Product product = (Product)obj;
        PreparedStatement preparedStatement = connection.prepareStatement("update product set title = ?, price = ? where id = ?");
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setLong(3, product.getId());
        return preparedStatement;
    }
}
