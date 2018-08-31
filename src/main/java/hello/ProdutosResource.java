package hello;

import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.Produtos;

import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutosResource {

    //private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();
    private Produtos produtoRepository;

    @Autowired
    public ProdutosResource(Produtos produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    private Iterable<Produto> listaAllProdutos;

    @GetMapping(produces = "application/json")
    public @ResponseBody
    Iterable<Produto> listaProdutos() {
        listaAllProdutos = produtoRepository.findAll();
        return listaAllProdutos;
    }

    @PostMapping
    public Produto cadastroProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping
    public Produto deletaProduto(@RequestBody @Valid Produto produto) {
        produtoRepository.delete(produto);
        return produto;
    }
    /*
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name),
                "banco!");
    }

    @RequestMapping("/aaa")
    public Greeting greeting1(@RequestParam(value = "name", defaultValue = "World") String name) {
        String banco = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("DB connected");
            Connection c = DriverManager.getConnection(database.HOST + database.DB_NAME, database.USERNAME, database.PASSWORD);
            banco = "DB connected!";
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name),
                banco);
    }

    @RequestMapping("/addPessoa")
    public String addPessoa(@RequestParam(value = "name", defaultValue = "World") String name) {

        return "Funalo adicionado";
    }
    */
}
