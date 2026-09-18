import javax.swing.JOptionPane;

public class App {

    private static IClienteDAO iClienteDAO;
    public static void main(String[] args) {

        iClienteDAO = new ClienteMapDAO();

        String opcao= JOptionPane.showInputDialog(null,
             "digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração, 5 para sair",
            "cadastro", JOptionPane.INFORMATION_MESSAGE);

            while(!isOpcaoValida(opcao)){
                if ("".equals(opcao)){
                    sair();
                } 
                opcao= JOptionPane.showInputDialog(null,
             "Opção inválita digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração, 5 para sair",
            "cadastro", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            

           while (isOpcaoValida(opcao)) {
            if(isOpcaoSair(opcao)){
                sair();
            }else if(isOpcaoCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null, "digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                 "cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            }else if(isOpcaoConsulta(opcao)){
                String dados = JOptionPane.showInputDialog(null,"Digite o cpf do cliente" ,
                 "consultar cliente", JOptionPane.INFORMATION_MESSAGE);
                 consultar(dados);
            }else if(isOpcaoExclusao(opcao)){
                String dados = JOptionPane.showInputDialog(null,"Digite o cpf do cliente" ,
                 "consultar cliente", JOptionPane.INFORMATION_MESSAGE);
                 excluir(dados);
            }else{
                String dados = JOptionPane.showInputDialog(null,"digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado" ,
                 "atualizar", JOptionPane.INFORMATION_MESSAGE);
                 atualizar(dados);
            }

            opcao= JOptionPane.showInputDialog(null,
             "Opção inválita digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração, 5 para sair",
            "cadastro", JOptionPane.INFORMATION_MESSAGE);
            
           }
        }

        private static void cadastrar(String dados){
            String[] dadosSeparados = dados.split(",");
            Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
            if(isCadastrado){
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Cliente ja se encontra cadastrado", "erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private static void consultar(String dados){
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
            if(cliente != null){
                JOptionPane.showMessageDialog(null, "cliente encontrado com sucesso: " + cliente.toString(),"sucesso" ,JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "cliente não encontrado", "ERRO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private static void excluir(String dados){
            iClienteDAO.excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "cliente excluido com sucesso: ", "sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

        private static void atualizar(String dados){
            String[] dadosSeparados = dados.split(",");
            Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
            iClienteDAO.alterar(cliente);
        }

        private static boolean isOpcaoSair(String opcao){
             if("5".equals(opcao)){
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

            private static boolean isOpcaoCadastro(String opcao){
                if("1".equals(opcao)){
                    return true;
                }
                return false;
            }

            private static boolean isOpcaoValida(String opcao){
                if("1".equals(opcao)||"2".equals(opcao)||"3".equals(opcao)||"4".equals(opcao)||"5".equals(opcao)){
                    return true;
                }
                return false;
            }

            private static boolean isOpcaoConsulta(String opcao){
             if("2".equals(opcao)){
                    return true;
                }
                return false;
        }

        private static boolean isOpcaoExclusao(String opcao){
             if("3".equals(opcao)){
                    return true;
                }
                return false;
        }
    }    
