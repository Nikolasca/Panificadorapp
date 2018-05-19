/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import Modelos.Usuario;

/**
 *
 * @author nicolasmoreno
 */
public class pruebaDb {
    public static void main(String[] args) {
        DbConnection conn = new DbConnection();
        UsuarioDao dao=new UsuarioDao(conn);
        Usuario u = dao.login("0asdfg0", "1234");
        System.out.println(u);
    }
}
