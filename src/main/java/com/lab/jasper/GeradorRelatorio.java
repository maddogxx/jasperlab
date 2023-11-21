package com.lab.jasper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

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
	private static final String DADOS = "pessoa.csv";
	
	private ClassLoader carregadorClasse;
	
	public GeradorRelatorio() {
		carregadorClasse = getClass().getClassLoader();
	}
	
	public void gerarRelatorio(VersaoEnum versao) {
		List<Person> pessoas = this.getPessoas();
		String caminhoTemplate = this.obterCaminhoRecurso(versao.getTemplate());
		
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(caminhoTemplate);
			jasperReport.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);
			
			Map<String, Object> parametros = new HashMap<>();
			
			if (VersaoEnum.V2.equals(versao)) {
				parametros.put("PERSON_DATASOURCE", new JRBeanCollectionDataSource(pessoas, false));
			}
			
			JRDataSource jrds = new JRBeanCollectionDataSource(pessoas, false);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, jrds);
			
			//ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
			FileOutputStream fos = new FileOutputStream(versao.getSaida());
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, fos);
			
		} catch (JRException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private List<Person> getPessoas() {
		List<Person> registros = new ArrayList<>();
		
		String recurso = this.obterCaminhoRecurso(DADOS);
		
		if (StringUtils.hasLength(recurso)) {
			try (Scanner scanner = new Scanner(new File(this.obterCaminhoRecurso(DADOS)))) {
				while (scanner.hasNextLine()) {
					String linha = scanner.nextLine();
					
					
					try (Scanner rowScanner = new Scanner(linha)) {
						rowScanner.useDelimiter(";");
						List<String> valores = new ArrayList<>();
						
						while (rowScanner.hasNext()) {
							valores.add(rowScanner.next());
						}
						
						registros.add(new Person(Integer.valueOf(valores.get(0)), valores.get(1), valores.get(2), Integer.valueOf(valores.get(3))));
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("CSV inexistente");
		}
		
		
		return registros;
	}
	
	private String obterCaminhoRecurso(String nomeRecurso) {
		String caminho = carregadorClasse.getResource(nomeRecurso).toString();
		
		if (caminho.contains("file:")) {
			caminho = caminho.replaceAll("file:", "");
		}
		
		return caminho;
	}
	

}
