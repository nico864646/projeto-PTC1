package controller.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.produto.TelaBuscaTamanho;
import view.produto.TelaCadastroTamanho;
import java.awt.Component;
import javax.swing.JTextField;

import model.bo.produto.Tamanho;
import service.produto.TamanhoService;

public class ControllerCadTamanho implements ActionListener {

    TelaCadastroTamanho telaCadTamanho;
    public static int codigo;

    public ControllerCadTamanho(TelaCadastroTamanho telaCadTamanho) { // Passa a tela como parâmetro para o controller.
        this.telaCadTamanho = telaCadTamanho;

        // Funções que escutam ações dos botões.
        telaCadTamanho.getjButtonNovo().addActionListener(this);
        telaCadTamanho.getjButtonCancelar().addActionListener(this);
        telaCadTamanho.getjButtonSalvar().addActionListener(this);
        telaCadTamanho.getjButtonBuscar().addActionListener(this);
        telaCadTamanho.getjButtonSair().addActionListener(this);

        // Inputs
        telaCadTamanho.getjTFId().addActionListener(this);
        telaCadTamanho.getjTFDescricao().addActionListener(this);

        buttonState(true);
        inputState(false);
    }

    @Override // Quando disparar a ação aqui será executado o código do botão em questão.
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == telaCadTamanho.getjButtonNovo()) {
            buttonState(false);
            inputState(true);
        } else if (event.getSource() == telaCadTamanho.getjButtonCancelar()) {
            buttonState(true);
            inputState(false);
        } else if (event.getSource() == telaCadTamanho.getjButtonSalvar()) {
            Tamanho tamanho = new Tamanho();
            TamanhoService tService = new TamanhoService();
            tamanho.setDescricao(this.telaCadTamanho.getjTFDescricao().getText());

            if (this.telaCadTamanho.getjTFId().getText().trim().equalsIgnoreCase("")) {
                tService.salvar(tamanho);
            } else {
                tamanho.setIdTamanho(Integer.parseInt(this.telaCadTamanho.getjTFId().getText()));
                tService.atualizar(tamanho);
            }

            buttonState(true);
            inputState(false);
        } else if (event.getSource() == telaCadTamanho.getjButtonBuscar()) {
            TelaBuscaTamanho telaBusTamanho = new TelaBuscaTamanho(null, true);
            ControllerBusTamanho controllerBusTamanho = new ControllerBusTamanho(telaBusTamanho);
            telaBusTamanho.setVisible(true);

            if (codigo != 0) {
                buttonState(false);
                inputState(true);

                Tamanho tamanho = new Tamanho();
                TamanhoService tService = new TamanhoService();

                tamanho = tService.buscar(codigo);

                this.telaCadTamanho.getjTFId().setText(tamanho.getIdTamanho() + "");
                this.telaCadTamanho.getjTFDescricao().setText(tamanho.getDescricao());
                this.telaCadTamanho.getjTFId().setEnabled(false);
            }
        } else if (event.getSource() == telaCadTamanho.getjButtonSair()) {
            this.telaCadTamanho.dispose();
        }
    }

    public void buttonState(boolean state) {
        telaCadTamanho.getjButtonNovo().setEnabled(state);
        telaCadTamanho.getjButtonCancelar().setEnabled(!state);
        telaCadTamanho.getjButtonSalvar().setEnabled(!state);
        telaCadTamanho.getjButtonBuscar().setEnabled(state);
        telaCadTamanho.getjButtonSair().setEnabled(state);
    }

    public void inputState(boolean state) {

        Component[] componentes = this.telaCadTamanho.getjPanelContainer().getComponents();

        for (Component componente : componentes) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText("");
                componente.setEnabled(state);
            }
        }
        this.telaCadTamanho.getjTFId().setEnabled(false);
    }
}
