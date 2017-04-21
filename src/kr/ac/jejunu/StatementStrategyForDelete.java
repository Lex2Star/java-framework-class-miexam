package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hyunki on 2017. 4. 21..
 */
public class StatementStrategyForDelete implements StatementStrategy {
    private Long id;

    public StatementStrategyForDelete(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection)throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
