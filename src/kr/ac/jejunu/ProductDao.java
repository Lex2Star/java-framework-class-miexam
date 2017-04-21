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
        return jdbcContext.JdbcContextWithStatementStrategyForGet(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        });
    }


    public void add(Product product) throws ClassNotFoundException, SQLException {
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product(id, title, price) VALUES (?, ?, ?)");
            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setInt(3, product.getPrice());
            return preparedStatement;
        });
    }

    public void update(Product product) throws ClassNotFoundException, SQLException {
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set title = ?, price = ? where id = ?");
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setLong(3, product.getId());
            return preparedStatement;
        });
    }

    public void delete(Long id) throws ClassNotFoundException, SQLException {
        jdbcContext.JdbcContextWithStatementStrategyForUpdate(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        });
    }
}
