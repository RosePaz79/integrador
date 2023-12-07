package com.br.apismartwatch.apismartwatch.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;

@Component
public class ConsultaLoader {

    private final ResourceLoader resourceLoader;

    @Value("classpath:consulta.sql.xml")
    private Resource consultaSqlResource;

    public ConsultaLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public String carregarConsultaPorId(String id) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(consultaSqlResource.getInputStream());

            NodeList queryList = document.getElementsByTagName("query");
            for (int i = 0; i < queryList.getLength(); i++) {
                Element queryElement = (Element) queryList.item(i);
                String queryId = queryElement.getAttribute("id");

                if (id.equals(queryId)) {
                    return queryElement.getTextContent().trim();
                }
            }

            throw new RuntimeException("Consulta com o ID '" + id + "' não encontrada no arquivo consultas.sql.xml");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o arquivo consultas.sql.xml", e);
        }
    }
}
