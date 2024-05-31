



package com.iud.funcionario.app.controller;

import com.iud.funcionario.app.dao.TipoDocumentoDao;
import com.iud.funcionario.app.domain.TipoDocumento;
import java.sql.SQLException;
import java.util.List;


public class TipoDocumentoController {
    
     private TipoDocumentoDao tipoDocumentoDao;
    
    
    public  TipoDocumentoController(){
        
        tipoDocumentoDao = new TipoDocumentoDao();
    }
    
    public List<TipoDocumento> obtenerTipoDocumento() throws SQLException {
    
    return tipoDocumentoDao.obtenerTipoDocumento();
    }    
    
    
    
}
