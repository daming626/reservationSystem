package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.ILoginDao;

import java.sql.*;

public class LoginDaoImpl implements ILoginDao {

    @Override
    public User login(String username, String password) {
        /*
        具体的JDBC代码，连接数据库，获取数据
         */
        String url = "jdbc:mysql://localhost:3306/test2?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM tb_user WHERE userName=? AND passWord=?";//验证用户名和密码
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "123456");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                //登录成功
                user = new User();
                user.setUserId(rs.getString("USERID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setRealName(rs.getString("REALNAME"));

                sql = "SELECT r.* FROM tb_user_role ur,tb_role r WHERE r.roleId=ur.roleId AND ur.userId=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getUserId());
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Role role = new Role();
                    role.setRoleId(rs.getString("ROLEID"));
                    role.setRoleName(rs.getString("ROLENAME"));
                    user.getRoleList().add(role);//设置用户和角色的关系
                }
                sql = "SELECT tree.* FROM tb_role_permission rp,tb_tree tree WHERE tree.treeId=rp.treeId AND rp.roleId=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getRoleList().get(0).getRoleId());
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    Tree tree = new Tree();
                    tree.setTreeId(rs.getString("treeId"));
                    tree.setParentTreeId(rs.getString("parentTreeId"));
                    tree.setTitle(rs.getString("title"));
                    tree.setTreeDesc(rs.getString("url"));
                    tree.setUrl(rs.getString("treeDesc"));
                    user.getRoleList().get(0).getTreeList().add(tree);//设置角色和菜单的关系
                }
            } else {
//                登录失败
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
