package com.lab.jasper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab.jasper.domain.Tabela;
import com.lab.jasper.domain.VersaoEnum;
import com.lab.jasper.repositorio.RepositorioTabela;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class GeradorRelatorio {
	
	@Autowired
	private RepositorioTabela repoTabela;
	
	private ClassLoader carregadorClasse;
	
	public GeradorRelatorio() {
		carregadorClasse = getClass().getClassLoader();
	}
	
	public void gerarRelatorio(VersaoEnum versao) {
		List<Tabela> tabelas = repoTabela.findAll();
		
		String caminhoTemplate = this.obterCaminhoRecurso(versao.getTemplate());
		
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(caminhoTemplate);
			jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
			
			Map<String, Object> parametros = new HashMap<>();
			
			if (VersaoEnum.V2.equals(versao)) {
				parametros.put("PERSON_DATASOURCE", new JRBeanCollectionDataSource(tabelas, false));
			}
			
			JRDataSource jrds = new JRBeanCollectionDataSource(tabelas, false);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, jrds);
			
			//ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
			FileOutputStream fos = new FileOutputStream(versao.getSaida());
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, fos);
			
		} catch (JRException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private String obterCaminhoRecurso(String nomeRecurso) {
		String caminho = carregadorClasse.getResource(nomeRecurso).toString();
		
		if (caminho.contains("file:")) {
			caminho = caminho.replaceAll("file:", "");
		}
		
		return caminho;
	}
	

}
