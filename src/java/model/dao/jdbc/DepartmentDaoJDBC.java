package model.dao.jdbc;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC {

    private Connection conn;

    public DepartmentDaoJDBC() {
        conn = new DB().getConnection();

    }

    public void insert(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }

            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM department WHERE Id = ?");

            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department obj = new Department();
                obj.setId(rs.getInt("Id"));
                obj.setName("Name");
                return obj;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } 

    }

    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();

            while (rs.next()) {
                Department obj = new Department();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                list.add(obj);
            }
            return list;
            

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } 
    }
    
    public List<Department> findAllDepartmets(String value) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT department.* FROM department WHERE department.Name LIKE '%" + value + "%'");
            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()) {

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);
                list.add(dep);
            }
            return list;
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
        obj.setBirthDate(new java.util.Date(rs.getTimestamp("BirthDate").getTime()));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        
        obj.setDepartment(dep);
        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        return dep;
    }
}
