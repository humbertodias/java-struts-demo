package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import util.ConnectionFactory;

public abstract class ProductDAO {

    public static boolean create(Product p){
        boolean ok = false;
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUCT (NAME,PRICE) VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getName());
            ps.setFloat(2, p.getPrice());
            ok = ps.executeUpdate() > 0;
            
            ResultSet rs = ps.getGeneratedKeys();  
            int id = rs.next() ? rs.getInt(1) : 0;
            
            p.setId(id);
            
        } catch (SQLException ex) { 
            throw new RuntimeException(ex);
        }
        return ok;
    }

    public static boolean delete(int id){
        boolean ok = false;
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUCT WHERE ID = ?");
            ps.setInt(1, id);
            ok = ps.executeUpdate() > 0;
        } catch (SQLException ex) { 
            throw new RuntimeException(ex);
        }
        return ok;
    }

    public static List<Product> findAll() {
        return findById(-1);
    }
    
    
    public static List<Product> findById(int id) {
        List<Product> list = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE ID = ? OR ? = -1");
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getFloat(3));
                list.add(product);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    public static boolean update(Product p){
        boolean ok = false;
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE PRODUCT SET NAME = ? , PRICE = ? WHERE ID = ?");
            ps.setString(1, p.getName());
            ps.setFloat(2, p.getPrice());
            ps.setFloat(3, p.getId());
            ok = ps.executeUpdate() > 0;
        } catch (SQLException ex) { 
            throw new RuntimeException(ex);
        }
        return ok;
    }

    
}
