/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Mounir
 */
public class ReportUtils {
    
    
    public static void exportarPDF(String fileName, Map<String,Object> param, List<Object> liste) throws JRException, IOException{
        

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/"+fileName+".jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),param, new JRBeanCollectionDataSource(liste));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition","attachment; filename="+fileName+".pdf");
        response.setContentType("application/pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        
        FacesContext.getCurrentInstance().responseComplete();
    }

}
