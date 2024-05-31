
package com.iud.funcionario.app.controller;

import com.iud.funcionario.app.dao.FuncionarioDao;
import com.iud.funcionario.app.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    
    
    private FuncionarioDao funcionarioDao;
    
    
    public  FuncionarioController(){
        
        funcionarioDao = new FuncionarioDao();
    }
    
    public List<Funcionario> obtenerFuncionario() throws SQLException {
    
    return funcionarioDao.obtenerFuncionario();
    }
    
    public void crearFuncionario(Funcionario funcionario)throws SQLException{
        funcionarioDao.crearFuncionario(funcionario);
    }





    
}

    
