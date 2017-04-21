package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        ProductDao productDao = new HallaProductDao();
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Product product = new Product();
        Long id = Long.valueOf(new Random().nextInt(Integer.MAX_VALUE));
        String title = "캐치잇";
        Integer price = 30000;

        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        ProductDao productDao = new JejuProductDao();
        productDao.add(product);
        Product product1 = productDao.get(id);

        assertThat(id, is(product1.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }
}
