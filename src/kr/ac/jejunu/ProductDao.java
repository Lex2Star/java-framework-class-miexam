package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {
    private JdbcContext jdbcContext;

    public ProductDao() {
    }

    public ProductDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new StatementStrategyForGet(id);
        return jdbcContext.JdbcContextWithStatementStrategyForGet(statementStrategy);
    }


    public void add(Product product) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new StatementStrategyForAdd(product);
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void update(Product product) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new StatementStrategyForUpdate(product);
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void delete(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new StatementStrategyForDelete(id);
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }
}
