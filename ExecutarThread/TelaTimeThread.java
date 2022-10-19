package Thread.ExecutarThread;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

public class TelaTimeThread extends JDialog {

    private JPanel jpanel = new JPanel(new GridBagLayout());

    private JLabel nomeUsuario = new JLabel("Nome ");

    private JTextField emailUsuario = new JTextField();

    private JTextField nomeUser = new JTextField();

    private JLabel email = new JLabel("E-mail: ");
    private JButton jButton = new JButton("Gerar Lote");

    private JButton jButton2 = new JButton("Parar");

    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

    public TelaTimeThread() {
        setTitle("Envio de Emails");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        email.setPreferredSize(new Dimension(200, 25));
        jpanel.add(email, gridBagConstraints);

        emailUsuario.setPreferredSize(new Dimension(200, 25));
        jpanel.add(emailUsuario, gridBagConstraints);
        gridBagConstraints.gridy++;

        emailUsuario.setEditable(true);
        jpanel.add(emailUsuario, gridBagConstraints);

        nomeUsuario.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jpanel.add(nomeUsuario, gridBagConstraints);

        nomeUser.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        nomeUser.setEditable(true);

        jpanel.add(nomeUser, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        jButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy++;
        jpanel.add(jButton, gridBagConstraints);

        jButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jpanel.add(jButton2, gridBagConstraints);

        jButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                       
                ObjetoFilaThread filaThread = new ObjetoFilaThread();
                filaThread.setEmail(nomeUser.getText());
                filaThread.setNome(emailUsuario.getText());

                fila.add(filaThread);
            }

        });

        jButton2.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

            }

        });
        add(jpanel, BorderLayout.WEST);

        setVisible(true);

        fila.start();

    }
}
