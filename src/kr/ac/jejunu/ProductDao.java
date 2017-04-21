package kr.ac.jejunu;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

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
        String sql = "select * from product where id = ?";
        return jdbcContext.JdbcContextWithStatementStrategyForGet(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        });

    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO product(id, title, price) VALUES (?, ?, ?)";
        Object[] params = {product.getId(), product.getTitle(), product.getPrice()};
        jdbcContext.update(sql, params);
    }

    public void update(Product product) throws ClassNotFoundException, SQLException {
        String sql = "update product set title = ?, price = ? where id = ?";
        Object[] params = {product.getTitle(), product.getPrice(), product.getId()};
        jdbcContext.update(sql, params);
    }

    public void delete(Long id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM product WHERE id = ?";
        Object[] params = {id};
        jdbcContext.update(sql, params);
    }
}
