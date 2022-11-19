package View;

import View.components.formTable;
import models.ProjetoModel;
import repositories.AlunoRepository;
import repositories.ProjetoRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class HomeProjeto extends JFrame
        implements ActionListener {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel dtm;
    private Container c;
    private JLabel title;
    private JButton botaoCadastrar;
    private JButton botaoEditar;
    private JButton botaoExcluir;
    private JButton botaoVisualizar;
    private JButton botaoAluno;
    private formTable tout;
    private List<ProjetoModel> projetosTable;


    public HomeProjeto(List<ProjetoModel> projetos)
    {
        projetosTable = projetos;
        setTitle("Projetos Acadêmicos");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Projetos Acadêmicos");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        // Botão cadastrar projeto
        /*-----------------*/

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
        botaoCadastrar.setSize(150, 25);
        botaoCadastrar.setLocation(40, 100);
        botaoCadastrar.addActionListener(this);
        c.add(botaoCadastrar);

        /*-----------------*/

        // Botão editar projeto

        botaoEditar = new JButton("Editar");
        botaoEditar.setFont(new Font("Arial", Font.PLAIN, 15));
        botaoEditar.setSize(150, 25);
        botaoEditar.setLocation(40, 150);
        botaoEditar.addActionListener(this);
        c.add(botaoEditar);


        // Botão editar projeto
        /*-----------------*/
        botaoExcluir = new JButton("Excluir");
        botaoExcluir.setFont(new Font("Arial", Font.PLAIN, 15));
        botaoExcluir.setSize(150, 25);
        botaoExcluir.setLocation(40, 200);
        botaoExcluir.addActionListener(this);
        c.add(botaoExcluir);

        /*-----------------*/

        // Botão listar os projetos
        botaoVisualizar = new JButton("Visualizar");
        botaoVisualizar.setFont(new Font("Arial", Font.PLAIN, 15));
        botaoVisualizar.setSize(150, 25);
        botaoVisualizar.setLocation(40, 250);
        botaoVisualizar.addActionListener(this);
        c.add(botaoVisualizar);

        //Botao goto aluno
        botaoAluno = new JButton("Goto Aluno");
        botaoAluno.setFont(new Font("Arial", Font.PLAIN, 15));
        botaoAluno.setSize(150, 25);
        botaoAluno.setLocation(40, 450);
        botaoAluno.addActionListener(this);
        c.add(botaoAluno);


        // Campo para visualização dos dados inseridos
        String[] tblHead={"Titulo","Área","Cidade","Estado"};
        dtm=new DefaultTableModel(tblHead,0);
        tout = new formTable(dtm);
        for (ProjetoModel p: projetos) {
            Object [] objResult = {p.getTitulo(), p.getArea(), p.getCidade(), p.getEstado(), p.getId()};
            dtm.addRow(objResult);
        }
        //Tamanho do espaço
        tout.setFont(new Font("Arial", Font.PLAIN, 17));
        tout.setSize(550, 400);
        tout.setLocation(300, 100);
        c.add(tout);


        setVisible(true);
    }


    // eventos dos botões
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == botaoCadastrar)
        {
            formProjeto f = new formProjeto();
            System.out.println(f);
            this.dispose();
        }
        else if(e.getSource() == botaoExcluir)
        {
            if (!tout.EstaVazia())
            {
                ArrayList<Integer> linhas = tout.getLinhasSelecionadas();
                ArrayList<Integer> projetosIdDeletados = new ArrayList<>();
                for (Integer linha : linhas) {
                    projetosIdDeletados.add(projetosTable.get(linha).getId());
                }
                new ProjetoRepository().delete(projetosIdDeletados);
                System.out.println(new HomeProjeto(new ProjetoRepository().findAll()));
                this.dispose();
            }
        }
        else if (e.getSource() == botaoEditar){
            if (tout.SomenteUmEstaSelecionado()){
                Integer rowIndex = tout.getLinhasSelecionadas().get(0);
                ProjetoModel projetoModel = projetosTable.get(rowIndex);
                System.out.println(new formProjeto(projetoModel, true));
                this.dispose();
            }
        }
        else if (e.getSource() == botaoVisualizar){
            if (tout.SomenteUmEstaSelecionado()) {
                Integer rowIndex = tout.getLinhasSelecionadas().get(0);
                ProjetoModel projetoModel = projetosTable.get(rowIndex);
                System.out.println(new formProjeto(projetoModel, false));
                this.dispose();
            }
        }
        else if (e.getSource() == botaoAluno){
            System.out.println(new HomeAluno(new AlunoRepository().findAll()));
            this.dispose();
        }

    }
}


