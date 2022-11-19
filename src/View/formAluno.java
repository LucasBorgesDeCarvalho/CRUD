package View;

import models.AlunoModel;
import models.ProjetoModel;
import repositories.AlunoRepository;
import repositories.ProjetoRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formAluno extends JFrame implements ActionListener {

    private AlunoRepository alunoRepository;
    private Container c;
    private JLabel title;
    private JLabel nomeAluno;
    private JTextField nomeAlunoInput;
    private JLabel matriculaAluno;
    private JTextField matriculaInput;
    private JLabel emailAluno;
    private JLabel telefoneAluno;
    private JTextField emailInput;
    private JTextField telefoneAlunoInput;
    private JButton cadastrar;
    private JButton reset;
    private JButton atualizar;
    private JButton buttonUpdate;
    private ProjetoModel projeto;

    private ProjetoRepository projetoRepository;


    public formAluno(){
            alunoRepository = new AlunoRepository();
            setTitle("Cadastro de Projetos");
            setBounds(300, 90, 900, 600);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);

            c = getContentPane();
            c.setLayout(null);

            title = new JLabel("Cadastro de Aluno");
            title.setFont(new Font("Arial", Font.PLAIN, 30));
            title.setSize(300, 30);
            title.setLocation(300, 30);
            c.add(title);

            // titulo: label + input
            /*-----------------*/
            nomeAluno = new JLabel("Nome");
            nomeAluno.setFont(new Font("Arial", Font.PLAIN, 20));
            nomeAluno.setSize(100, 20);
            nomeAluno.setLocation(270, 100);
            c.add(nomeAluno);

            nomeAlunoInput = new JTextField();
            nomeAlunoInput.setFont(new Font("Arial", Font.PLAIN, 15));
            nomeAlunoInput.setSize(190, 20);
            nomeAlunoInput.setLocation(350, 100);
            c.add(nomeAlunoInput);
            /*-----------------*/

            // area: label + input
            matriculaAluno = new JLabel("Matrícula");
            matriculaAluno.setFont(new Font("Arial", Font.PLAIN, 20));
            matriculaAluno.setSize(100, 20);
            matriculaAluno.setLocation(255, 150);
            c.add(matriculaAluno);

            matriculaInput = new JTextField();
            matriculaInput.setFont(new Font("Arial", Font.PLAIN, 15));
            matriculaInput.setSize(190, 20);
            matriculaInput.setLocation(350, 150);
            c.add(matriculaInput);
            /*-----------------*/

            // cidade: label + input
            emailAluno = new JLabel("E-Mail");
            emailAluno.setFont(new Font("Arial", Font.PLAIN, 20));
            emailAluno.setSize(100, 20);
            emailAluno.setLocation(275, 200);
            c.add(emailAluno);

            emailInput = new JTextField();
            emailInput.setFont(new Font("Arial", Font.PLAIN, 15));
            emailInput.setSize(190, 20);
            emailInput.setLocation(350, 200);
            c.add(emailInput);

            /*-----------------*/

            // telefoneAluno: label + input
            telefoneAluno = new JLabel("Telefone");
            telefoneAluno.setFont(new Font("Arial", Font.PLAIN, 20));
            telefoneAluno.setSize(100, 20);
            telefoneAluno.setLocation(265, 250);
            c.add(telefoneAluno);

            telefoneAlunoInput = new JTextField();
            telefoneAlunoInput.setFont(new Font("Arial", Font.PLAIN, 15));
            telefoneAlunoInput.setSize(190, 20);
            telefoneAlunoInput.setLocation(350, 250);
            c.add(telefoneAlunoInput);

            // Botão de enviar
            cadastrar = new JButton("Cadastrar");
            cadastrar.setFont(new Font("Arial", Font.PLAIN, 15));
            cadastrar.setSize(100, 20);
            cadastrar.setLocation(275, 300);
            cadastrar.addActionListener(this);
            c.add(cadastrar);

            reset = new JButton("Reset");
            reset.setFont(new Font("Arial", Font.PLAIN, 15));
            reset.setSize(100, 20);
            reset.setLocation(400, 300);
            reset.addActionListener(this);
            c.add(reset);

            setVisible(true);
        }
    public formAluno(AlunoModel alunoModel){
        alunoRepository = new AlunoRepository();
        setTitle("Cadastro de Aluno");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Atualizar Aluno");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        // titulo: label + input
        /*-----------------*/
        nomeAluno = new JLabel("Nome");
        nomeAluno.setFont(new Font("Arial", Font.PLAIN, 20));
        nomeAluno.setSize(100, 20);
        nomeAluno.setLocation(270, 100);
        c.add(nomeAluno);

        nomeAlunoInput = new JTextField();
        nomeAlunoInput.setFont(new Font("Arial", Font.PLAIN, 15));
        nomeAlunoInput.setSize(190, 20);
        nomeAlunoInput.setLocation(350, 100);
        nomeAlunoInput.setText(alunoModel.getNome());
        c.add(nomeAlunoInput);
        /*-----------------*/

        // area: label + input
        matriculaAluno = new JLabel("Matrícula");
        matriculaAluno.setFont(new Font("Arial", Font.PLAIN, 20));
        matriculaAluno.setSize(100, 20);
        matriculaAluno.setLocation(255, 150);
        c.add(matriculaAluno);

        matriculaInput = new JTextField();
        matriculaInput.setFont(new Font("Arial", Font.PLAIN, 15));
        matriculaInput.setSize(190, 20);
        matriculaInput.setLocation(350, 150);
        matriculaInput.setText(Integer.toString(alunoModel.getMatricula()));
        matriculaInput.setEditable(false);
        c.add(matriculaInput);
        /*-----------------*/

        // cidade: label + input
        emailAluno = new JLabel("E-Mail");
        emailAluno.setFont(new Font("Arial", Font.PLAIN, 20));
        emailAluno.setSize(100, 20);
        emailAluno.setLocation(275, 200);
        c.add(emailAluno);

        emailInput = new JTextField();
        emailInput.setFont(new Font("Arial", Font.PLAIN, 15));
        emailInput.setSize(190, 20);
        emailInput.setLocation(350, 200);
        emailInput.setText(alunoModel.getEmail());
        c.add(emailInput);

        /*-----------------*/

        // telefoneAluno: label + input
        telefoneAluno = new JLabel("Telefone");
        telefoneAluno.setFont(new Font("Arial", Font.PLAIN, 20));
        telefoneAluno.setSize(100, 20);
        telefoneAluno.setLocation(265, 250);
        c.add(telefoneAluno);

        telefoneAlunoInput = new JTextField();
        telefoneAlunoInput.setFont(new Font("Arial", Font.PLAIN, 15));
        telefoneAlunoInput.setSize(190, 20);
        telefoneAlunoInput.setLocation(350, 250);
        telefoneAlunoInput.setText(alunoModel.getTelefone());
        c.add(telefoneAlunoInput);

        // Botão de Atualizar
        atualizar = new JButton("Atualizar");
        atualizar.setFont(new Font("Arial", Font.PLAIN, 15));
        atualizar.setSize(100, 20);
        atualizar.setLocation(400, 300);
        atualizar.addActionListener(this);
        c.add(atualizar);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == cadastrar)
        {
            if(!nomeAlunoInput.getText().isEmpty() &&
                    !matriculaInput.getText().isEmpty() &&
                    !emailInput.getText().isEmpty() &&
                    !telefoneAlunoInput.getText().isEmpty())

            {
                alunoRepository.add(new AlunoModel(
                        Integer.parseInt(matriculaInput.getText()),
                        nomeAlunoInput.getText(),
                        emailInput.getText(),
                        telefoneAlunoInput.getText()));
                        System.out.println(new HomeAluno(new AlunoRepository().findAll()));
                        this.dispose();
            }
        }
        else if (e.getSource() == reset) {
            String def = "";

            nomeAlunoInput.setText(def);
            matriculaInput.setText(def);
            emailInput.setText(def);
            telefoneAlunoInput.setText(def);
        }
        else if(e.getSource() == atualizar) {
            if(!nomeAlunoInput.getText().isEmpty() &&
                    !matriculaInput.getText().isEmpty() &&
                    !emailInput.getText().isEmpty() &&
                    !telefoneAlunoInput.getText().isEmpty()) {
                new AlunoRepository().update(new AlunoModel(Integer.parseInt(
                        matriculaInput.getText()),
                        nomeAlunoInput.getText(),
                        emailInput.getText(),
                        telefoneAlunoInput.getText()
                        ));
                System.out.println(new HomeAluno(new AlunoRepository().findAll()));
                this.dispose();
            }
        }
    }
}



