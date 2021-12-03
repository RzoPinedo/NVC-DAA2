package idat.edu.pe.controller;

import java.io.FileInputStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import idat.edu.pe.service.AlumnosServicio;
import idat.edu.pe.service.CursosServicio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class ReportesController {
	@Autowired
	private CursosServicio servicio;
	@Autowired AlumnosServicio servicioAlumnos;
	
	@GetMapping("/ReporteDeCursos")
	public  ResponseEntity<byte[]> generarPdfCursos() throws Exception, JRException
	{
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(servicio.buscarTodo());
		JasperReport compileReport= JasperCompileManager.compileReport(new FileInputStream("src/main/resources/static/reportes/ReporteDeCursos.jrxml"));		
		JasperPrint report= JasperFillManager.fillReport(compileReport, new HashMap<>(),beanCollectionDataSource);
		byte[] data=JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers=new HttpHeaders(); 
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline;filename=ReporteDeCursos.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);			
	}
	
	@GetMapping("/ReporteDeAlumnos")
	public  ResponseEntity<byte[]> generarPdfUsuarios() throws Exception, JRException
	{
		JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(servicioAlumnos.buscarTodo());
		JasperReport compileReport= JasperCompileManager.compileReport(new FileInputStream("src/main/resources/static/reportes/ReporteDeUsuarios.jrxml"));		
		JasperPrint report= JasperFillManager.fillReport(compileReport, new HashMap<>(),beanCollectionDataSource);
		byte[] data=JasperExportManager.exportReportToPdf(report);
		HttpHeaders headers=new HttpHeaders(); 
		headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline;filename=ReporteDeAlumnos.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);			
	}
}
