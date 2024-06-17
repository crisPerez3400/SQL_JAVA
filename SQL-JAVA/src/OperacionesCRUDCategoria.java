package SqlJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OperacionesCRUDCategoria {

	public void insertarCategoria(Categoria categoria) {
        String sql = "INSERT INTO dbo.categorias (Categoria, Descripcion) VALUES (?, ?)";
        
        try (Connection conexion = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        	
            pstmt.setString(1, categoria.getCategoria());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void leerCategorias() {
        String sql = "SELECT * FROM dbo.categorias";
        
        try (Connection conexion = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Id_categoria: " + rs.getString("Categoria"));
                System.out.println("Descripcion: " + rs.getString("Descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE dbo.categorias SET Descripcion = ? WHERE Categoria = ?";
        
        try (Connection conexion = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {           
            pstmt.setString(1, categoria.getDescripcion());
            pstmt.setString(2, categoria.getCategoria());
            pstmt.executeUpdate();
            System.out.println("Categoria actualizada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void borrarCategoria(String id_categoria) {
        String sql = "DELETE FROM dbo.categorias WHERE Categoria = ?";
        
        try (Connection conexion = DatabaseConnection.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, id_categoria);
            pstmt.executeUpdate();
            System.out.println("Categoria borrada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
