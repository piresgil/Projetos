package springboot.desafio.cnb.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springboot.desafio.cnb.model.TipoTransacao;
import springboot.desafio.cnb.model.Transacao;
import springboot.desafio.cnb.repository.TransacaoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class CnabService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public CnabService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional
    public void arquivoProcessar(MultipartFile file) {

      try (BufferedReader br = new BufferedReader((new InputStreamReader((file.getInputStream()))))) {
          String linha;
          while ((linha = br.readLine()) != null) {
              Transacao transacao = parseLinha(linha);
              transacaoRepository.save(transacao);
          }
      } catch (IOException e) {
          e.printStackTrace();
        }
    }

    private Transacao parseLinha(String linha) {
        Transacao transacao = new Transacao();

        int tipoCodigo = Integer.parseInt(linha.substring(0, 1));
        TipoTransacao tipo = TipoTransacao.fromCodigo(tipoCodigo);

       // transacao.setTipo(tipo.getDescricao());
       // transacao.setNatureza(tipo.getNatureza());
       // transacao.setSinal(tipo.getSinal());
       // transacao.setData(LocalDate.parse(linha.substring(1, 9), DateTimeFormatter.BASIC_ISO_DATE));
       // transacao.setValor(new BigDecimal(linha.substring(9, 19)).divide(new BigDecimal(100)));
       // transacao.setCpf(linha.substring(19, 30));
       // transacao.setCartao(linha.substring(30, 43));
       // transacao.setHora(LocalTime.parse(linha.substring(42, 48), DateTimeFormatter.ofPattern("HHmmss")));
       // transacao.setDonoLoja(linha.substring(48, 62).trim());
       // transacao.setNomeLoja(linha.substring(62).trim());

        transacao.setTipo(tipo.getDescricao());
        transacao.setNatureza(tipo.getNatureza());
        transacao.setSinal(tipo.getSinal());
        transacao.setData(LocalDate.parse(linha.substring(1, 9), DateTimeFormatter.BASIC_ISO_DATE));
        transacao.setValor(new BigDecimal(linha.substring(9, 14)).divide(new BigDecimal(100)));
        transacao.setCpf(linha.substring(14, 29));
        transacao.setCartao(linha.substring(29, 33));

        try {
            transacao.setHora(LocalTime.parse(linha.substring(33, 39), DateTimeFormatter.ofPattern("HHmmss")));
        } catch (DateTimeParseException e) {
            System.err.println("Erro ao fazer parsing da hora na linha: " + linha);
            // Pode definir uma hora padrão ou ignorar a linha
            return null; // Retorna null para indicar que a linha não pôde ser parseada
        }

        transacao.setDonoLoja(linha.substring(39, 50).trim());
        transacao.setNomeLoja(linha.substring(50).trim());

        return transacao;
    }

    public List<Transacao> listarTransacoes(){
        return transacaoRepository.findAll();
    }
}
