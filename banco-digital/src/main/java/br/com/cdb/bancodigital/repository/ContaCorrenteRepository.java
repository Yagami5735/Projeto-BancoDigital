package br.com.cdb.bancodigital.repository;

import br.com.cdb.bancodigital.entity.Cliente;
import br.com.cdb.bancodigital.entity.contas.ContaCorrente;
import br.com.cdb.bancodigital.service.ChavesPix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
}
