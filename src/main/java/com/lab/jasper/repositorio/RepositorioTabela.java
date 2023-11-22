package com.lab.jasper.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab.jasper.domain.Tabela;

@Repository
public interface RepositorioTabela extends JpaRepository<Tabela, Integer> {

}
