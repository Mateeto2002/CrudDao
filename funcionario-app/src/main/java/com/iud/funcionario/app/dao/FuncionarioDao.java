package com.iud.funcionario.app.dao;

import com.iud.funcionario.app.domain.Funcionario;
import com.iud.funcionario.app.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    public static final String GET_FUNCIONARIO = "select funcionario.*, tipo_documento.descripcion "
            + "from funcionario "
            + "inner join tipo_documento on funcionario.ID_tipoDocumento = tipo_documento.ID_tipoDocumento";

    public static final String CREATE_FUNCIONARIO = "INSERT INTO funcionario "
            + "(nombre, apellidos, ID_tipoDocumento, numIdentificacion, sexo, direccion, telefono, fechaNacimiento)"
            + "VALUE(?,?,?,?,?,?,?,?)";

    public static final String CREATE_FUNCIONARIO_BY_ID = "";

    public static final String UPDATE_FUNCIONARIO = "";

    public static final String DELETE_FUNCIONARIO = "";

    public List<Funcionario> obtenerFuncionario() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setFuncionarioID(resultSet.getInt("FuncionarioID"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setTipoIdentificacion(resultSet.getString("descripcion"));
                funcionario.setNumIdentificacion(resultSet.getString("numIdentificacion"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getInt("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                funcionarios.add(funcionario);
            }

            return funcionarios;

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

    
    public void crearFuncionario(Funcionario funcionario) throws SQLException{
         
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getNombre());
            preparedStatement.setString(2, funcionario.getApellidos());
            preparedStatement.setString(3, funcionario.getTipoIdentificacion());
            preparedStatement.setString(4, funcionario.getNumIdentificacion());
            preparedStatement.setString(5, funcionario.getSexo());
            preparedStatement.setString(6, funcionario.getDireccion());
            preparedStatement.setInt(7, funcionario.getTelefono());
            preparedStatement.setString(8, funcionario.getFechaNacimiento());
            preparedStatement.executeUpdate();
            
            
        }finally{
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
        }
        
        


    }

    
    
    
    
}

    
   
