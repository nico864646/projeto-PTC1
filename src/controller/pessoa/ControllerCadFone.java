package controller.pessoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bo.pessoa.FoneFornecedor;
import model.bo.pessoa.Fornecedor;
import service.pessoa.FoneFornecedorService;
import service.pessoa.FornecedorService;
import view.pessoa.TelaBuscaFoneFornecedor;
import view.pessoa.TelaCadastroFoneFornecedor;

public class ControllerCadFone implements ActionListener {

    TelaCadastroFoneFornecedor telaCadFoneFornecedor;
    
    public static int supplierCode; //Recebe o ID do Fornecedor da tela de Cadastro de Fornecedores.
    public static String searchRsltContact; //Variável para receber o contato da lista de busca.
    public static String initialContact; //Variável para guardar o contato original do Forncedor recebido da tela de busca.
    public static boolean update; //Booleno para saber se está salvando ou atualizando um novo contato.


    // Passa a tela como parâmetro para o controller.
    public ControllerCadFone(TelaCadastroFoneFornecedor telaCadFoneFornecedor, int fornecedorCode) { 
        this.telaCadFoneFornecedor = telaCadFoneFornecedor;
        update = false;
        supplierCode = fornecedorCode;
        // Funções que escutam ações dos botões.
        telaCadFoneFornecedor.getjButtonSalvar().addActionListener(this);
        telaCadFoneFornecedor.getjButtonBuscar().addActionListener(this);
        telaCadFoneFornecedor.getjButtonSair().addActionListener(this);

        // Inputs
        telaCadFoneFornecedor.getjTFFornecedorID().addActionListener(this);
        telaCadFoneFornecedor.getjFTFContato().addActionListener(this);

        buttonState(true);
        inputState();
        this.telaCadFoneFornecedor.getjTFFornecedorID().setText(String.valueOf(supplierCode));
        System.out.println(update);
        System.out.println(supplierCode);
    }

    @Override // Quando disparar a ação aqui será executado o código do botão em questão.
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == telaCadFoneFornecedor.getjButtonSalvar()) {
            Fornecedor fornecedor = new Fornecedor();
            FornecedorService fornecedorService = new FornecedorService();
            FoneFornecedor foneFornecedor = new FoneFornecedor();
            FoneFornecedorService foneFornecedorService = new FoneFornecedorService();
            
            foneFornecedor.setDescricao(this.telaCadFoneFornecedor.getjFTFContato().getText());
            fornecedor = fornecedorService.buscar(Integer.parseInt(this.telaCadFoneFornecedor.getjTFFornecedorID().getText()));
            foneFornecedor.setFornecedor(fornecedor);

            if (update == false) {
                foneFornecedorService.salvar(foneFornecedor);
                this.telaCadFoneFornecedor.dispose();
            } else {
                foneFornecedorService.atualizar(initialContact, foneFornecedor);
                update = false;
            }

            buttonState(true);
            inputState();
        } else if (event.getSource() == telaCadFoneFornecedor.getjButtonBuscar()) {
            System.out.println(supplierCode);
            update = true;
            initialContact = this.telaCadFoneFornecedor.getjFTFContato().getText();
            TelaBuscaFoneFornecedor telaBusFornecedor = new TelaBuscaFoneFornecedor();
            ControllerBusFoneFornecedor controllerBusFornecedor = new ControllerBusFoneFornecedor(telaBusFornecedor, supplierCode);
            telaBusFornecedor.setVisible(true);
        } else if (event.getSource() == telaCadFoneFornecedor.getjButtonSair()) {
            this.telaCadFoneFornecedor.dispose();
        }
    }

    public void buttonState(boolean state) {
        telaCadFoneFornecedor.getjButtonSalvar().setEnabled(state);
        telaCadFoneFornecedor.getjButtonBuscar().setEnabled(state);
        telaCadFoneFornecedor.getjButtonSair().setEnabled(state);
    }

    public void inputState() {
        this.telaCadFoneFornecedor.getjTFFornecedorID().setEnabled(false);
    }
    
}
