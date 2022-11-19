package View;

import View.components.formTable;
import models.AlunoModel;
import models.ProjetoModel;
import repositories.AlunoRepository;
import repositories.EquipeRepository;
import repositories.ProjetoRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class formProjeto extends JFrame
        implements ActionListener {

    private static final long serialVersionUID = 1L;

    private DefaultTableModel dtm;
    private Container c;
    private JLabel title;
    private JLabel tituloProjeto;
    private JTextField tituloInput ;
    private JLabel areaProjeto;
    private JTextField areaInput;
    private JLabel cidadeProjeto;
    private JLabel estado;
    private JTextField cidadeInput;
    private JTextField estadoInput;
    private JLabel descricaoProjeto;
    private JTextArea descricaoInput;
    private JButton sub;
    private JButton reset;
    private formTable tout;
    private JLabel res;
    private JTextArea resadd;
    private JButton buttonUpdate;
    private ProjetoModel projeto;
    private JButton homeButton;

    private ProjetoRepository projetoRepository;


    public formProjeto()
    {
        projetoRepository = new ProjetoRepository();
        setTitle("Cadastro de Projetos");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Cadastro de Projetos");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        // titulo: label + input
        /*-----------------*/
        tituloProjeto = new JLabel("Titulo");
        tituloProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        tituloProjeto.setSize(100, 20);
        tituloProjeto.setLocation(100, 100);
        c.add(tituloProjeto);

        tituloInput = new JTextField();
        tituloInput.setFont(new Font("Arial", Font.PLAIN, 15));
        tituloInput.setSize(190, 20);
        tituloInput.setLocation(200, 100);
        c.add(tituloInput);
        /*-----------------*/

        // area: label + input
        areaProjeto = new JLabel("Área");
        areaProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        areaProjeto.setSize(100, 20);
        areaProjeto.setLocation(100, 150);
        c.add(areaProjeto);

        areaInput = new JTextField();
        areaInput.setFont(new Font("Arial", Font.PLAIN, 15));
        areaInput.setSize(190, 20);
        areaInput.setLocation(200, 150);
        c.add(areaInput);
        /*-----------------*/

        // cidade: label + input
        cidadeProjeto = new JLabel("Cidade");
        cidadeProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        cidadeProjeto.setSize(100, 20);
        cidadeProjeto.setLocation(100, 200);
        c.add(cidadeProjeto);

        cidadeInput = new JTextField();
        cidadeInput.setFont(new Font("Arial", Font.PLAIN, 15));
        cidadeInput.setSize(190, 20);
        cidadeInput.setLocation(200, 200);
        c.add(cidadeInput);

        /*-----------------*/

        // Estado: label + input
        estado = new JLabel("Estado");
        estado.setFont(new Font("Arial", Font.PLAIN, 20));
        estado.setSize(100, 20);
        estado.setLocation(100, 250);
        c.add(estado);

        estadoInput = new JTextField();
        estadoInput.setFont(new Font("Arial", Font.PLAIN, 15));
        estadoInput.setSize(190, 20);
        estadoInput.setLocation(200, 250);
        c.add(estadoInput);

        /*-----------------*/

        // Descrição: label + input
        descricaoProjeto = new JLabel("Descrição");
        descricaoProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        descricaoProjeto.setSize(100, 20);
        descricaoProjeto.setLocation(100, 300);
        c.add(descricaoProjeto);

        descricaoInput = new JTextArea();
        descricaoInput.setFont(new Font("Arial", Font.PLAIN, 15));
        descricaoInput.setSize(200, 75);
        descricaoInput.setLocation(200, 300);
        descricaoInput.setLineWrap(true);
        c.add(descricaoInput);
        /*-----------------*/

        // Botão de enviar
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        // Campo para visualização dos dados inseridos
        String[] tblHead={"Nome","Matrícula"};
        dtm=new DefaultTableModel(tblHead,0);
        tout = new formTable(dtm);
        List<AlunoModel> alunos = new AlunoRepository().findAll();
        for (AlunoModel aluno: alunos) {
            Object [] objResult = {aluno.getNome(), aluno.getMatricula()};
            dtm.addRow(objResult);
        }
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        c.add(tout);

        // mensagem registrado com sucesso
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        // reseta os dados
        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    public formProjeto(ProjetoModel projetoModel, boolean isEdit)
    {
        projetoRepository = new ProjetoRepository();
        projeto = projetoModel;
        setTitle("Cadastro de Projetos");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Cadastro de Projetos");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        // titulo: label + input
        /*-----------------*/
        tituloProjeto = new JLabel("Titulo");
        tituloProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        tituloProjeto.setSize(100, 20);
        tituloProjeto.setLocation(100, 100);
        c.add(tituloProjeto);

        tituloInput = new JTextField();
        tituloInput.setFont(new Font("Arial", Font.PLAIN, 15));
        tituloInput.setSize(190, 20);
        tituloInput.setLocation(200, 100);
        tituloInput.setText(projetoModel.getTitulo());
        if (!isEdit){
            tituloInput.setEditable(false);
        }
        c.add(tituloInput);
        /*-----------------*/

        // area: label + input
        areaProjeto = new JLabel("Área");
        areaProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        areaProjeto.setSize(100, 20);
        areaProjeto.setLocation(100, 150);
        c.add(areaProjeto);

        areaInput = new JTextField();
        areaInput.setFont(new Font("Arial", Font.PLAIN, 15));
        areaInput.setSize(190, 20);
        areaInput.setLocation(200, 150);
        areaInput.setText(projetoModel.getArea());
        if (!isEdit){
            areaInput.setEditable(false);
        }
        c.add(areaInput);
        /*-----------------*/

        // cidade: label + input
        cidadeProjeto = new JLabel("Cidade");
        cidadeProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        cidadeProjeto.setSize(100, 20);
        cidadeProjeto.setLocation(100, 200);
        c.add(cidadeProjeto);

        cidadeInput = new JTextField();
        cidadeInput.setFont(new Font("Arial", Font.PLAIN, 15));
        cidadeInput.setSize(190, 20);
        cidadeInput.setLocation(200, 200);
        cidadeInput.setText(projetoModel.getCidade());
        if (!isEdit){
            cidadeInput.setEditable(false);
        }
        c.add(cidadeInput);

        /*-----------------*/

        // Estado: label + input
        estado = new JLabel("Estado");
        estado.setFont(new Font("Arial", Font.PLAIN, 20));
        estado.setSize(100, 20);
        estado.setLocation(100, 250);
        c.add(estado);

        estadoInput = new JTextField();
        estadoInput.setFont(new Font("Arial", Font.PLAIN, 15));
        estadoInput.setSize(190, 20);
        estadoInput.setLocation(200, 250);
        estadoInput.setText(projetoModel.getEstado());
        if (!isEdit){
            estadoInput.setEditable(false);
        }
        c.add(estadoInput);

        /*-----------------*/

        // Descrição: label + input
        descricaoProjeto = new JLabel("Descrição");
        descricaoProjeto.setFont(new Font("Arial", Font.PLAIN, 20));
        descricaoProjeto.setSize(100, 20);
        descricaoProjeto.setLocation(100, 300);
        c.add(descricaoProjeto);

        descricaoInput = new JTextArea();
        descricaoInput.setFont(new Font("Arial", Font.PLAIN, 15));
        descricaoInput.setSize(200, 75);
        descricaoInput.setLocation(200, 300);
        descricaoInput.setLineWrap(true);
        descricaoInput.setText(projetoModel.getDescricao());
        if (!isEdit){
            descricaoInput.setEditable(false);
        }
        c.add(descricaoInput);
        /*-----------------*/

        // Botão de enviar
        if(isEdit) {
            buttonUpdate = new JButton("Update");
            buttonUpdate.setFont(new Font("Arial", Font.PLAIN, 15));
            buttonUpdate.setSize(100, 20);
            buttonUpdate.setLocation(150, 450);
            buttonUpdate.addActionListener(this);
            c.add(buttonUpdate);

            reset = new JButton("Reset");
            reset.setFont(new Font("Arial", Font.PLAIN, 15));
            reset.setSize(100, 20);
            reset.setLocation(270, 450);
            reset.addActionListener(this);
            c.add(reset);
        } else {
            homeButton = new JButton("Home");
            homeButton.setFont(new Font("Arial", Font.PLAIN, 15));
            homeButton.setSize(100, 20);
            homeButton.setLocation(210, 450);
            homeButton.addActionListener(this);
            c.add(homeButton);
        }
        // Campo para visualização dos dados inseridos
        String[] tblHead={"Nome","Matrícula"};
        dtm=new DefaultTableModel(tblHead,0);
        tout = new formTable(dtm);
        ArrayList<AlunoModel> alunos = new EquipeRepository().findAlunosPorProjeto(projeto.getId());
        int count = 0;
        for (AlunoModel aluno: alunos) {
            Object [] objResult = {aluno.getNome(), aluno.getMatricula()};
            dtm.addRow(objResult);
            tout.setLinhasSelecionadas(count);
            count++;
        }
        if (isEdit){
            ArrayList<AlunoModel> AlunosDiferenteDoProjeto = new EquipeRepository().findAlunosDiferenteDoProjeto(projeto.getId());
            for (AlunoModel aluno: AlunosDiferenteDoProjeto) {
                Object [] objResult = {aluno.getNome(), aluno.getMatricula()};
                dtm.addRow(objResult);
            }
        }else {
            tout.setMouseListennerActivated(false);
        }
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        c.add(tout);

        // mensagem registrado com sucesso
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        // reseta os dados
        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    // imprime os dados
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub)
        {
            if(!tituloInput.getText().isEmpty() &&
                    !areaInput.getText().isEmpty() &&
                    !cidadeInput.getText().isEmpty() &&
                    !estadoInput.getText().isEmpty() &&
                    !descricaoInput.getText().isEmpty())
            {
                ArrayList<Integer> AlunosIndex = tout.getLinhasSelecionadas();
                if(AlunosIndex.size() > 0)
                {
                    int id = projetoRepository.add(new ProjetoModel(
                            tituloInput.getText(),
                            areaInput.getText(),
                            cidadeInput.getText(),
                            estadoInput.getText(),
                            descricaoInput.getText()
                    ));
                    ArrayList<Integer> alunosMatricula = new ArrayList<>();
                    for (int row:AlunosIndex) {
                        alunosMatricula.add((int)dtm.getValueAt(row, 1));
                    }
                    new EquipeRepository().add(id,alunosMatricula);
                    System.out.println(new HomeProjeto(projetoRepository.findAll()));
                    this.dispose();
                  }
            }
        }

        else if (e.getSource() == reset) {
            String def = "";

            tituloInput.setText(def);
            descricaoInput.setText(def);
            areaInput.setText(def);
            cidadeInput.setText(def);
            estadoInput.setText(def);
            descricaoInput.setText(def);
            resadd.setText(def);
        }
        else if(e.getSource() == buttonUpdate) {
            if(!tituloInput.getText().isEmpty() &&
                    !areaInput.getText().isEmpty() &&
                    !cidadeInput.getText().isEmpty() &&
                    !estadoInput.getText().isEmpty() &&
                    !descricaoInput.getText().isEmpty()) {
                ArrayList<Integer> AlunosIndex = tout.getLinhasSelecionadas();

                if (AlunosIndex.size() > 0) {
                    ArrayList<Integer> matriculas = new ArrayList<>();
                    for (Integer aluno:AlunosIndex) {
                        matriculas.add((int)tout.getValueAt(aluno,1));
                    }
                    projeto.setTitulo(tituloInput.getText());
                    projeto.setArea(areaInput.getText());
                    projeto.setCidade(cidadeInput.getText());
                    projeto.setEstado(estadoInput.getText());
                    projeto.setDescricao(descricaoInput.getText());
                    projetoRepository.update(projeto);
                    new EquipeRepository().update(matriculas, projeto.getId());
                    System.out.println(new HomeProjeto(projetoRepository.findAll()));
                    this.dispose();
                }
            }
        }
        else if (e.getSource() == homeButton){
            System.out.println(new HomeProjeto(projetoRepository.findAll()));
            this.dispose();
        }
    }
}
