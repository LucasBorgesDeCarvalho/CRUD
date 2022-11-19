package View;

import View.components.formTable;
import models.AlunoModel;
import models.ProjetoModel;
import repositories.AlunoRepository;
import repositories.ProjetoRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class HomeAluno extends JFrame
        implements ActionListener {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel dtm;
    private Container c;
    private JLabel title;
    private JButton botaoCadastrar;
    private JButton botaoEditar;
    private JButton botaoExcluir;
    private JButton botaoVisualizar;
    private JButton botaoProjeto;
    private formTable tout;
    private List<AlunoModel> alunosTable;


    public HomeAluno(List<AlunoModel> alunos)
    {
        alunosTable = alunos;
        setTitle("Alunos");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Alunos");
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

        //Botao goto aluno
        botaoProjeto = new JButton("Goto Projetos");
        botaoProjeto.setFont(new Font("Arial", Font.PLAIN, 15));
        botaoProjeto.setSize(150, 25);
        botaoProjeto.setLocation(40, 450);
        botaoProjeto.addActionListener(this);
        c.add(botaoProjeto);


        // Campo para visualização dos dados inseridos
        String[] tblHead={"Nome","Matricula","E-Mail","Telefone"};
        dtm=new DefaultTableModel(tblHead,0);
        tout = new formTable(dtm);
        for (AlunoModel p: alunos) {
            Object [] objResult = {p.getNome(), p.getMatricula(), p.getEmail(), p.getTelefone()};
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
            formAluno f = new formAluno();
            System.out.println(f);
            this.dispose();
        }
        else if(e.getSource() == botaoExcluir)
        {
            if (!tout.EstaVazia())
            {
                ArrayList<Integer> linhas = tout.getLinhasSelecionadas();
                ArrayList<Integer> matriculasDeletadas = new ArrayList<>();
                for (Integer linha : linhas) {
                    matriculasDeletadas.add((int)dtm.getValueAt(linha, 1));
                }
                new AlunoRepository().delete(matriculasDeletadas);
                System.out.println(new HomeAluno(new AlunoRepository().findAll()));
                this.dispose();
            }
        }
        else if (e.getSource() == botaoEditar){
            if (tout.SomenteUmEstaSelecionado()){
                Integer rowIndex = tout.getLinhasSelecionadas().get(0);
                AlunoModel alunoModel = alunosTable.get(rowIndex);
                System.out.println(new formAluno(alunoModel));
                this.dispose();
            }
        }
        else if (e.getSource() == botaoProjeto){
            System.out.println(new HomeProjeto(new ProjetoRepository().findAll()));
            this.dispose();
        }

    }
}


