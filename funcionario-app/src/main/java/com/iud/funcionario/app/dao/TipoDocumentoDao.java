
package com.iud.funcionario.app.dao;


import com.iud.funcionario.app.domain.TipoDocumento;
import com.iud.funcionario.app.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDao {
    
    
    private static final String GET_TIPODOCUMENTO = "SELECT * FROM tipo_documento";
    
    public List<TipoDocumento> obtenerTipoDocumento() throws SQLException{
        
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        List<TipoDocumento> tipoDocumentos = new ArrayList<>();
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_TIPODOCUMENTO);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TipoDocumento tipoDocumento = new TipoDocumento();

                tipoDocumento.setId_tipoDocumento(resultSet.getInt("ID_tipoDocumento"));
                tipoDocumento.setDescripcion(resultSet.getString("descripcion"));
                
                tipoDocumentos.add(tipoDocumento);
                
            }
            return tipoDocumentos;
            
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
        
    }
    
    
    
    
    
    
    
}
