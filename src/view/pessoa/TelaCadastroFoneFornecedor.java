package view.pessoa;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastroFoneFornecedor extends javax.swing.JFrame {

    public TelaCadastroFoneFornecedor() {
        initComponents();
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public void setjButtonBuscar(JButton jButtonBuscar) {
        this.jButtonBuscar = jButtonBuscar;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public void setjButtonSair(JButton jButtonSair) {
        this.jButtonSair = jButtonSair;
    }

    public JButton getjButtonSalvar() {
        return jButtonSalvar;
    }

    public void setjButtonSalvar(JButton jButtonSalvar) {
        this.jButtonSalvar = jButtonSalvar;
    }

    public JFormattedTextField getjFTFContato() {
        return jFTFContato;
    }

    public void setjFTFContato(JFormattedTextField jFTFContato) {
        this.jFTFContato = jFTFContato;
    }

    public JPanel getjPanelContainer() {
        return jPanelContainer;
    }

    public void setjPanelContainer(JPanel jPanelContainer) {
        this.jPanelContainer = jPanelContainer;
    }

    public JTextField getjTFFornecedorID() {
        return jTFFornecedorID;
    }

    public void setjTFFornecedorID(JTextField jTFFornecedorID) {
        this.jTFFornecedorID = jTFFornecedorID;
    }

    public JTextField getjTFIdFone() {
        return jTFIdFone;
    }

    public void setjTFIdFone(JTextField jTFIdFone) {
        this.jTFIdFone = jTFIdFone;
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelBtnContainer = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanelContainer = new javax.swing.JPanel();
        jLabelContato = new javax.swing.JLabel();
        jTFFornecedorID = new javax.swing.JTextField();
        jLabelFornecedor = new javax.swing.JLabel();
        jFTFContato = new javax.swing.JFormattedTextField();
        jLabelID = new javax.swing.JLabel();
        jTFIdFone = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPTitulo.setBackground(new java.awt.Color(255, 255, 51));
        jPTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Fones");

        javax.swing.GroupLayout jPTituloLayout = new javax.swing.GroupLayout(jPTitulo);
        jPTitulo.setLayout(jPTituloLayout);
        jPTituloLayout.setHorizontalGroup(
            jPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPTituloLayout.setVerticalGroup(
            jPTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelBtnContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonSalvar.setText("Salvar");
        jPanelBtnContainer.add(jButtonSalvar);

        jButtonBuscar.setText("Buscar");
        jPanelBtnContainer.add(jButtonBuscar);

        jButtonSair.setText("Sair");
        jPanelBtnContainer.add(jButtonSair);

        jPanelContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelContato.setText("Contato");

        jLabelFornecedor.setText("Fornecedor");

        try {
            jFTFContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelID.setText("ID");

        javax.swing.GroupLayout jPanelContainerLayout = new javax.swing.GroupLayout(jPanelContainer);
        jPanelContainer.setLayout(jPanelContainerLayout);
        jPanelContainerLayout.setHorizontalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFIdFone, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFFornecedorID)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                            .addComponent(jLabelContato)
                            .addGap(111, 111, 111))
                        .addComponent(jFTFContato, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(104, 104, 104))
        );
        jPanelContainerLayout.setVerticalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabelID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFIdFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelFornecedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFFornecedorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelContato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBtnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBtnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFoneFornecedor().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFTFContato;
    private javax.swing.JLabel jLabelContato;
    private javax.swing.JLabel jLabelFornecedor;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBtnContainer;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JTextField jTFFornecedorID;
    private javax.swing.JTextField jTFIdFone;
    // End of variables declaration//GEN-END:variables
}
