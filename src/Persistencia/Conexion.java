package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
    protected static String getCadenaDeConexion() {
        return "jdbc:mysql://localhost:3306/oblLucaPisciottano?user=root&password=Root";
    }

    // Método para ejecutar consultas SQL (INSERT, UPDATE, DELETE)
    public boolean consulta(String sql, List<Object> parametros) throws AppSQLException{
        try (Connection conexion = DriverManager.getConnection(getCadenaDeConexion());
             PreparedStatement comando = conexion.prepareStatement(sql)) {

            // Agregar los parámetros si existen
            if (parametros != null) {
                for (int i = 0; i < parametros.size(); i++) {
                    comando.setObject(i + 1, parametros.get(i));
                }
            }

            // Ejecutar consulta
            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new AppSQLException("Error ejecutando consulta", e);
        }
    }

    // Método para realizar una selección (SELECT) y obtener resultados en una lista

    public List<List<Object>> seleccion(String sql, List<Object> parametros) throws AppSQLException{
        List<List<Object>> resultado = new ArrayList<>();

        try (Connection conexion = DriverManager.getConnection(getCadenaDeConexion());
             PreparedStatement comando = conexion.prepareStatement(sql)) {

            // Agregar los parámetros si existen
            if (parametros != null) {
                for (int i = 0; i < parametros.size(); i++) {
                    comando.setObject(i + 1, parametros.get(i));
                }
            }

            // Ejecutar la consulta y obtener el resultado
            try (ResultSet resultSet = comando.executeQuery()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Almacenar los resultados en una lista
                while (resultSet.next()) {
                    List<Object> fila = new ArrayList<>();
                    for (int i = 1; i <= columnCount; i++) {
                        fila.add(resultSet.getObject(i));
                    }
                    resultado.add(fila);
                }
            }
        } catch (SQLException e) {
            throw new AppSQLException("Error ejecutando consulta", e);
        }

        return resultado;
    }

}