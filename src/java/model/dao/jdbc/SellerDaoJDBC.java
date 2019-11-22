package model.dao.jdbc;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Seller> list = new ArrayList<>();

    public SellerDaoJDBC() {
        conn = new DB().getConnection();
    }
    
    public void insert(Seller obj) {
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getEmail());
                        stmt.setString(3, obj.getPassword());
			stmt.setDate(4, new java.sql.Date(obj.getBirthDate().getTime()));
			stmt.setDouble(5, obj.getBaseSalary());
                        stmt.setDouble(6, obj.getBaseSalary());
			stmt.setInt(7, obj.getDepartment().getId());
			
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

    /*public void insert(Seller seller) {
        String sql = "INSERT INTO seller (Name, Email, Password, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, seller.getName());
            stmt.setString(2, seller.getEmail());
            stmt.setString(3, seller.getPassword());
            stmt.setDate(4, (Date) new java.util.Date(seller.getBirthDate().getTime()));
            stmt.setDouble(5, seller.getBaseSalary());
            stmt.setInt(6, seller.getDepartment().getId());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }*/

    public void update(Seller obj) {
        try {
            st = conn.prepareStatement("UPDATE seller SET Name = ?, Email = ?, Password = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? WHERE Id = ?");

            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getPassword());
            stmt.setDate(4, (Date) new java.util.Date(obj.getBirthDate().getTime()));
            stmt.setDouble(5, obj.getBaseSalary());
            stmt.setInt(6, obj.getDepartment().getId());
            stmt.setInt(7, obj.getId());

            stmt.executeQuery();
            stmt.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deleteById(Integer id) {

        try {
            stmt = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
            stmt.setInt(1, id);

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ? ");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                Seller obj = instantiateSeller(rs, dep);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setPassword(rs.getString("Password"));
        obj.setBirthDate(new java.sql.Date(rs.getTimestamp("BirthDate").getTime()));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));

        obj.setDepartment(dep);
        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        return dep;
    }

    
    
    public ArrayList<Seller> findAll() {
        String sql = "SELECT * FROM seller ORDER BY Name";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));
                
                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setPassword(rs.getString("Password"));
                obj.setBirthDate((Date) new java.util.Date(rs.getTimestamp("BirthDate").getTime()));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setDepartment(dep);
                
                list.add(obj);

            }
            
        } catch (SQLException e) {
            throw new DbException("Error method find all: " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Seller> findAllSellers(String value) {
        String sql = "SELECT seller.* FROM seller WHERE seller.Name LIKE '%" + value + "%'";
    
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException("Error method find all sellers: " + e.getMessage());
        } 
    }

    public ArrayList<Seller> findByDepartment(Department department) {
        try {
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE DepartmentId = ? ORDER BY Name");

            stmt.setInt(1, department.getId());
            rs = stmt.executeQuery();

            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {
                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }
                Seller obj = instantiateSeller(rs, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException("Error method find by department: " + e.getMessage());
        }

    }

}
