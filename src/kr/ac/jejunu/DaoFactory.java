package kr.ac.jejunu;

/**
 * Created by hyunki on 2017. 4. 21..
 */
public class DaoFactory {
    public ProductDao getPrductDao() {
        return new ProductDao(getConnection());
    }

    private ConnectionMaker getConnection() {
        return new JejuProductDao();
    }
}
