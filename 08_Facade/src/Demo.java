public class Demo {
    static void main() {
    IApartamentoService service = new ApartamentoService();
    service.cadastrarApartamento(new Apartamento(1, "endereço"));
    }
}
