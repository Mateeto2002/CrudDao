

package com.iud.funcionario.app.presentacion;

import com.iud.funcionario.app.controller.FuncionarioController;
import com.iud.funcionario.app.controller.TipoDocumentoController;
import com.iud.funcionario.app.domain.Funcionario;
import com.iud.funcionario.app.domain.TipoDocumento;
import java.sql.SQLException;
import java.util.List;






public class FuncionarioApp {
    
    
    public static void obtenerFuncionario(FuncionarioController funcionarioController){
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionario();
            
            if(funcionarios.isEmpty()){
                System.out.println("No hay funcionario");
            }else{
                
                funcionarios.forEach(funcionario -> {
                    System.out.println("ID: " + funcionario.getFuncionarioID());
                    System.out.println("Nombre: " + funcionario.getNombre());
                    System.out.println("Apellidos: " + funcionario.getApellidos());
                    System.out.println("Tipo Identificacion: " + funcionario.getTipoIdentificacion());
                    System.out.println("Numero Identificacion: " + funcionario.getNumIdentificacion());
                    System.out.println("Sexo: " + funcionario.getSexo());
                    System.out.println("Direccion: " + funcionario.getDireccion());
                    System.out.println("Telefono: " + funcionario.getTelefono());
                    System.out.println("Fecha de Nacimiento" + funcionario.getFechaNacimiento());
                    System.out.println("Fecha de Nacimiento" );
                    System.out.println("-----------------------------------------------------");
                });
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        
        FuncionarioController funcionariocontroller = new FuncionarioController();
        
        obtenerFuncionario(funcionariocontroller);
    }
}
