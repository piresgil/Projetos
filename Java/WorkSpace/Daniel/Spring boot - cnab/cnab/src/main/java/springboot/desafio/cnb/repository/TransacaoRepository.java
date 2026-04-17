package springboot.desafio.cnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.desafio.cnb.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao,Long> {

}
