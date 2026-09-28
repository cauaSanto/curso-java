package cadastro;

import cadastro.Dao.ClienteMapDAO;
import cadastro.Dao.IClienteDAO;
import cadastro.Dao.IProdutoDao;
import cadastro.Dao.ProdutoDao;
import cadastro.Dao.generic.IgenericDao;
import cadastro.Domain.Cliente;
import cadastro.Domain.Persistente;
import cadastro.fabrica.Factory;
import cadastro.fabrica.IFabricaPersistente;
import cadastro.fabrica.IFactory;

import javax.swing.*;

public class APP2 {

    private static IProdutoDao iProdutoDao;
    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        inicializarDao();

        String opcaoMenuGeral = JOptionPane.showInputDialog(null,
                "Digite 1 para Cliente e 2 para Produto", "cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoMenuValida(opcaoMenuGeral)) {
            if ("".equals(opcaoMenuGeral)) {
                sair();
            }
            opcaoMenuGeral = JOptionPane.showInputDialog(null,
                    "opção invalida digite 1 para Cliente e 2 para Produto", "cadastro", JOptionPane.INFORMATION_MESSAGE);

        }

        while (isOpcaoValida(opcaoMenuGeral)) {
            String titulo = opcaoMenuGeral.equals("1") ? "cadastro de Clientes" : "cadastro de produtos";

            String opcao = JOptionPane.showInputDialog(null,
                    "digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração, 5 para sair",
                    "cadastro", JOptionPane.INFORMATION_MESSAGE);

            executarOpcoes(opcao, opcaoMenuGeral);

            opcaoMenuGeral = JOptionPane.showInputDialog(null,
                    "Digite 1 para Cliente e 2 para Produto", "cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }


        private static void executarOpcoes(String opcao,String opcaoMenuGeral){
            if(isOpcaoSair(opcao)){
                sair();
            } else if (isCadastro(opcao)) {
                executarOpcaoCadastrar(opcaoMenuGeral);
            }else if (isConsultar(opcao)) {
                executarOpcaoConsultar(opcaoMenuGeral);
            }else if (isExcluir(opcao)) {
                executarOpcaoExcluir(opcaoMenuGeral);
            }else {
                executarOpcaoAtualizar(opcaoMenuGeral);
            }
        }


        private static void executarOpcaoAtualizar(String opcaoMenuGeral){
            String dados = JOptionPane.showInputDialog(null, "digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                    "cadastro", JOptionPane.INFORMATION_MESSAGE);
            String [] dadosSeparados = dados.split(",");
            Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
            iClienteDAO.alterar(cliente);
            JOptionPane.showMessageDialog(null, "dados atualizados com sucesso: ",
                    "sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        private static void executarOpcaoExcluir(String opcaoMenuGeral){
            String msg = opcaoMenuGeral.equals("1") ? "digite o cpf" : "digite o codigo";
            String dados = JOptionPane.showInputDialog(null,
                    msg, "exclusão de dados", JOptionPane.INFORMATION_MESSAGE);
            getDao(opcaoMenuGeral).excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "dados excluidos com sucesso: ",
                    "sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        private static void executarOpcaoConsultar(String opcaoMenuGeral){
            String msg = opcaoMenuGeral.equals("1") ? "digite o cpf" : "digite o codigo";

            String dados = JOptionPane.showInputDialog(null,
                    msg, "consultar", JOptionPane.INFORMATION_MESSAGE);

            Persistente persistente = consultar(dados, opcaoMenuGeral);
                if(persistente != null){
                    JOptionPane.showMessageDialog(null,
                            "dado encontrado: " +persistente.toString(),"sucesso", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,
                            "dado não encontrado","sucesso", JOptionPane.INFORMATION_MESSAGE);
                }


        }

        private static void executarOpcaoCadastrar(String opcaoMenuGeral){
            String dados = "";
            if("1".equals(opcaoMenuGeral)){
                dados = JOptionPane.showInputDialog(null, "digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "cadastro", JOptionPane.INFORMATION_MESSAGE);

            }else{
                dados = JOptionPane.showInputDialog(null, "digite os dados do Produto separados por virgula, conforme exemplo: código, nome",
                        "cadastro", JOptionPane.INFORMATION_MESSAGE);
            }

            cadastrar(dados, opcaoMenuGeral);
        }




        private static void inicializarDao(){
            iClienteDAO = new ClienteMapDAO();
            iProdutoDao = new ProdutoDao();
        }


        public static IgenericDao getDao(String opcaoMenuGeral){
            if("1".equals(opcaoMenuGeral)){
                return iClienteDAO;
            }else {
                return iProdutoDao;
            }
        }


    private static Persistente consultar(String dados, String opcaoMenuGeral){
        return getDao(opcaoMenuGeral).consultar(Long.valueOf(dados));
    }


    private static void cadastrar(String dados, String opcaoMenuGeral){
        String [] dadosSeparados = dados.split(",");
        Persistente persistente = criarObjetoConcreto(dadosSeparados, opcaoMenuGeral);
        Boolean isCadastrado = cadastrarObjeto(opcaoMenuGeral, persistente);

        if(isCadastrado){
            JOptionPane.showMessageDialog(null, "dados cadastrado com sucesso ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "dados ja se encontra cadastrado", "erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private static Boolean cadastrarObjeto(String opcaoMenuGeral, Persistente persistenete){
        return getDao(opcaoMenuGeral).cadastrar(persistenete);
    }


    private static Persistente criarObjetoConcreto(String[] dadosSeparados, String opcaoMenuGeral){
        IFactory factory = new Factory();
        IFabricaPersistente fabricaPersistente = factory.criarFabrica(opcaoMenuGeral);
        return fabricaPersistente.criarObjeto(dadosSeparados);
    }

    private static boolean isOpcaoValida(String opcao){
        if("1".equals(opcao)||"2".equals(opcao)||
                "3".equals(opcao)||"4".equals(opcao)||"5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoMenuValida(String opcao){
        if("1".equals(opcao)|| "2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair(){
        JOptionPane.showConfirmDialog(null,
                "Ate logo: ",
                "sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoSair(String opcao){
        if("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isCadastro(String opcao){
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isConsultar(String opcao){
        if("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isExcluir(String opcao){
        if("3".equals(opcao)){
            return true;
        }
        return false;
    }


}
