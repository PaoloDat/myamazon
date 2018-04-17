package dao;

import model.ItemInCart;

import java.sql.*;

public class ItemInCartDaoImpl implements ItemInCartDao {
    public static final String URL ="jdbc:postgresql://localhost:5432/myshop";

    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private Connection getConnection(String url, String userName, String password) throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
    private void closeConnection (Connection connection) {
        if (connection == null) {
            return;
        }
        try{
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public int getLastId() {
        int id;
        id=0;
        Connection connection = null;
        try{
            connection = getConnection(URL,"postgres", "postgres");
            String sql = "SELECT * FROM cartslist ORDER BY id DESC limit 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                    id = resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return id;
    }

    @Override
    public void addCartNumber(int id) {
        Connection connection = null;
        try {
            connection = getConnection(URL,"postgres", "postgres");
            String sql ="Insert into cartslist (id, cart_name) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, "корзина " + id);
            preparedStatement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }


    }

    @Override
    public void addCartDetail(ItemInCart itemInCart, int id) {
        Connection connection = null;
        try{
            connection = getConnection(URL,"postgres", "postgres");
            String sql = "insert into carts (id, carts_list_id, items_id, quantity, total) " +
                    "values (nextval('carts_id_seq'),?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, itemInCart.getId());
            preparedStatement.setInt(3, itemInCart.getQuantity());
            preparedStatement.setInt(4, itemInCart.getTotal());
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }
}
