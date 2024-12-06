package br.com.senac2.exemplo_security_api2.resources;

import br.com.senac2.exemplo_security_api2.entitys.Produto;
import br.com.senac2.exemplo_security_api2.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController  extends  AbstractController{
    private final ProdutoService service;


    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto entidade) {
        return ResponseEntity.created(URI.create("/api/produtos/" + entidade.getId())).body(service.salvar(entidade));
    }


    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok().body(service.listAll());
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getByID(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(service.findByID(id));
    }


    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto) {
        return ResponseEntity.created(URI.create("/api/produtos/" + produto.getId())).body(service.atualizar(produto));
    }
}
