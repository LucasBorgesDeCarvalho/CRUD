import View.HomeProjeto;
import repositories.ProjetoRepository;

public class MainCRUD {
    public static void main(String[] args) throws Exception
    {
        //formProjeto f = new formProjeto();
        HomeProjeto h = new HomeProjeto(new ProjetoRepository().findAll());
        System.out.println(h);

//        String titulo = JOptionPane.showInputDialog("Digite o TITULO");
//        String area = JOptionPane.showInputDialog("Digite o Area");
//        String cidade = JOptionPane.showInputDialog("Digite a cidade");
//        String estado = JOptionPane.showInputDialog("Digite o estado");
//        String descricao = JOptionPane.showInputDialog("Digite a descrição");
//
//        ProjetoModel cadastro = new ProjetoModel(titulo,area,cidade, estado, descricao);
//        ProjetoRepository.add(cadastro);

    }
}

