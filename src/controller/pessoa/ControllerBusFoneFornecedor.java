package controller.pessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import service.pessoa.FoneFornecedorService;
import view.pessoa.TelaBuscaFoneFornecedor;

public class ControllerBusFoneFornecedor implements ActionListener{

    TelaBuscaFoneFornecedor telaBuscaFoneFornecedor;

    public ControllerBusFoneFornecedor(TelaBuscaFoneFornecedor telaBusFoneFornecedor, int codigo){
        this.telaBuscaFoneFornecedor = telaBusFoneFornecedor;
        
        telaBusFoneFornecedor.getjButtonCarregar().addActionListener(this);
        telaBusFoneFornecedor.getjButtonSair().addActionListener(this);

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFoneFornecedor.getjTable().getModel();

        FoneFornecedorService foneService = new FoneFornecedorService();
        foneService.buscar(codigo).forEach(contatoAtual -> {
            tabela.addRow(new Object[]{
                contatoAtual.getFornecedor().getIdFornecedor(),
                contatoAtual.getDescricao(),
            });
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.telaBuscaFoneFornecedor.getjButtonCarregar()){
            ControllerCadFone.searchRsltContact =  (String) this.telaBuscaFoneFornecedor.getjTable().getValueAt(this.telaBuscaFoneFornecedor.getjTable().getSelectedRow(), 1);
            this.telaBuscaFoneFornecedor.dispose();
        } else if(event.getSource() == this.telaBuscaFoneFornecedor.getjButtonSair()){
            this.telaBuscaFoneFornecedor.dispose();
        }
    }
}  