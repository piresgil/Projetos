package springboot.desafio.cnb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springboot.desafio.cnb.model.Transacao;
import springboot.desafio.cnb.service.CnabService;

import java.util.List;

@RestController
@RequestMapping("/cnab")
public class CnabController {

    @Autowired
    private CnabService cnabService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        cnabService.arquivoProcessar(file);
        return ResponseEntity.ok("Arquivo processado com sucesso");
    }

    @GetMapping("/transacao")
    public List<Transacao> listarTransacoes() {
        return cnabService.listarTransacoes();
    }
}
