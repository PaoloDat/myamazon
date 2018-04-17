package dao;

import model.Item;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ItemDaoImpl implements ItemDao {
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
    public void addItem(Item item) {
        Connection connection = null;
        try{
            connection = getConnection(URL,"postgres", "postgres");
            String sql ="Insert into items (id, code, name, price) values (nextval('items_id_seq'),?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, item.getCode());
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, item.getPrice());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void updateItem(Item item) {
        Connection connection = null;
        try{
            connection = getConnection(URL, "postgres", "postgres");
            String sql = "UPDATE items SET code = ?, name = ?, price = ? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,item.getCode());
            preparedStatement.setString(2,item.getName());
            preparedStatement.setInt(3, item.getPrice());
            preparedStatement.setInt(4,item.getId());
            preparedStatement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }


    }

    @Override
    public void removeItem(int id) {
        Connection connection = null;
        try {
            connection = getConnection(URL, "postgres", "postgres");
            String sql = "DELETE from ITEMS where id=?";
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public Item getItemById(int id) {
        Item item = new Item();
        Connection connection = null;
        try {
            connection = getConnection(URL, "postgres", "postgres");
            String sql = "SELECT * FROM items WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                                item.setId(id);
                item.setCode(resultSet.getString("code"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getInt("price"));
                           }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return  item;
    }

    @Override
    public List<Item> getItemList() {
        List<Item> result = new ArrayList<Item>();
        Connection connection = null;
        try {
            connection = getConnection(URL, "postgres", "postgres");
            String sql = "select * from items";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setCode(resultSet.getString("code"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getInt("price"));

                result.add(item);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }
}
