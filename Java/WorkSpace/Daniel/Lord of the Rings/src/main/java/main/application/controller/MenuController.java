package main.application.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import lombok.Getter;
import lombok.Setter;
import main.application.listener.AtualizarJsonListener;
import main.application.model.Besta;
import main.application.model.Heroi;
import main.application.model.Personagem;
import main.application.model.enums.Tipo;
import main.application.repository.PersonagemJsonRepository;
import main.application.service.Batalha;
import main.application.service.PersonagemManager;
import main.application.utils.FormUtils;
import main.application.utils.JsonUtils;
import main.application.utils.PopupUtils;
import main.application.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class MenuController implements AtualizarJsonListener {
    @Getter
    @Setter
    @FXML
    private BorderPane root;
    @FXML
    public Label lblJogador1, lblJogador2;
    @FXML
    public Pane pnJogador1, pnJogador2;
    @FXML
    public ComboBox<Tipo> cbbTipoJogador1, cbbTipoJogador2;
    @FXML
    public TextField txtNomeJogador1, txtVidaJogador1, txtArmaduraJogador1, txtAtaqueJogador1;
    @FXML
    public TextField txtNomeJogador2, txtVidaJogador2, txtArmaduraJogador2, txtAtaqueJogador2;
    @FXML
    public StackPane stkBatalha;
    @FXML
    public Button btnBatalhar, btnCriarPersonagem1, btnCriarPersonagem2, btnEliminarPersonagem1,
            btnEliminarPersonagem2, btnEditarPersonagem2, btnEditarPersonagem1, btnGravarPersonagem1, btnGravarPersonagem2,
            btnCimaJogador1, btnBaixoJogador1, btnCimaJogador2, btnBaixoJogador2;

    @FXML
    public ListView<Personagem> listViewHerois, listViewBestas;

    // Listas observáveis personagens
    @FXML
    private ObservableList<Personagem> observableListHerois = FXCollections.observableArrayList();
    private ObservableList<Personagem> observableListBestas = FXCollections.observableArrayList();

    @FXML
    private PersonagemJsonRepository repository = new PersonagemJsonRepository();
    private PersonagemManager manager = new PersonagemManager();
    private Personagem selecionado;
    private boolean editMode;
    private Node top, bottom, left, right;

    // Construtor sem parâmetros (adicionado para que o FXMLLoader funcione)
    public MenuController() {

    }

    @FXML
    public void initialize() {
        configurarHandlers();
        configInitial();
        habilitarCampos();
    }

    @FXML
    public void configInitial() {
        editMode = false;

        // Configurar os tipos nos ComboBox
        cbbTipoJogador1.setItems(FXCollections.observableArrayList(Tipo.values()));
        cbbTipoJogador1.getSelectionModel().select(null);
        cbbTipoJogador2.setItems(FXCollections.observableArrayList(Tipo.values()));
        cbbTipoJogador2.getSelectionModel().select(null);

        atualizarJsonListener();
        resetarButons();
    }

    @Override
    public void atualizarJsonListener() {
        JsonUtils.setListener(this);
        carregarListas();
    }

    @FXML
    public void carregarListas() {
        // Carregar listas
        observableListHerois = FXCollections.observableArrayList(repository.carregarHerois());
        observableListBestas = FXCollections.observableArrayList(repository.carregarBestas());

        listViewHerois.setItems(observableListHerois);
        listViewBestas.setItems(observableListBestas);

        // Atualizar as listas com os dados mais recentes
        FormUtils.atualizarListView(listViewHerois, lblJogador1, cbbTipoJogador1, txtNomeJogador1, txtVidaJogador1, txtArmaduraJogador1, txtAtaqueJogador1);
        FormUtils.atualizarListView(listViewBestas, lblJogador2, cbbTipoJogador2, txtNomeJogador2, txtVidaJogador2, txtArmaduraJogador2, txtAtaqueJogador2);

        // Substitua por listeners simplificados
        listViewHerois.getSelectionModel().selectedItemProperty().addListener((obs, old, novo) -> {
            if (novo != null) lblJogador1.setText(novo.getNome());
            else lblJogador1.setText(" ");
        });

        listViewBestas.getSelectionModel().selectedItemProperty().addListener((obs, old, novo) -> {
            if (novo != null) lblJogador2.setText(novo.getNome());
            else lblJogador2.setText(" ");
        });
    }

    @FXML
    public void resetarButons() {
        // Resetar a seleção de personagem
        selecionado = null;

        // Exibir botões de criar personagem
        btnCriarPersonagem1.setVisible(true);
        btnCriarPersonagem2.setVisible(true);

        // Ocultar botões de editar, eliminar e gravar personagem
        btnEditarPersonagem1.setVisible(false);
        btnEditarPersonagem2.setVisible(false);
        btnEliminarPersonagem1.setVisible(false);
        btnEliminarPersonagem2.setVisible(false);
        btnGravarPersonagem1.setVisible(false);
        btnGravarPersonagem2.setVisible(false);
        // Resetar o texto do botão de editar
        btnEditarPersonagem1.setText("Editar");
        btnEditarPersonagem2.setText("Editar");
    }

    @FXML
    private void cancelarEdicao() {
        System.out.println("Cancelando edição...");

        // Remove o colaborador em edição
        selecionado = null;
        
        // Resetando o modo de edição
        editMode = false;
        // Limpar os formulários
        FormUtils.limparFormulario(pnJogador1);
        FormUtils.limparFormulario(pnJogador2);

        resetarButons(); // Chama a função para restaurar o estado inicial

        habilitarCampos();

    }

    @FXML
    public void habilitarCampos() {
        cbbTipoJogador1.setDisable(false);
        txtNomeJogador1.setDisable(false);
        txtVidaJogador1.setDisable(false);
        txtArmaduraJogador1.setDisable(false);
        txtAtaqueJogador1.setDisable(false);

        cbbTipoJogador2.setDisable(false);
        txtNomeJogador2.setDisable(false);
        txtVidaJogador2.setDisable(false);
        txtArmaduraJogador2.setDisable(false);
        txtAtaqueJogador2.setDisable(false);
    }

    @FXML
    private void configurarHandlers() {

        // Para o botão que cria o Heroi
        btnCriarPersonagem1.setOnAction(actionEvent -> {
            // Cria uma nova instância de Heroi
            Personagem heroi = new Heroi();
            criarPersonagem(heroi, observableListHerois, listViewHerois);
        });

        // Para o botão que cria o Besta
        btnCriarPersonagem2.setOnAction(actionEvent -> {
            // Cria uma nova instância de Heroi
            Personagem besta = new Besta();
            criarPersonagem(besta, observableListBestas, listViewBestas);
        });

        // Handler de clique para a ListView de Heróis (Eventos de Seleção das ListViews: Configura a visibilidade dos botões de editar e criar com base na seleção das ListViews.)
        listViewHerois.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean itemSelecionado = newSelection != null;
            btnEditarPersonagem1.setVisible(itemSelecionado);
            btnCriarPersonagem1.setVisible(!itemSelecionado);
        });

        // Handler de clique para a ListView de Bestas (Eventos de Seleção das ListViews: Configura a visibilidade dos botões de editar e criar com base na seleção das ListViews.)
        listViewBestas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            boolean itemSelecionado = newSelection != null;
            btnEditarPersonagem2.setVisible(itemSelecionado);
            btnCriarPersonagem2.setVisible(!itemSelecionado);
        });

        btnEliminarPersonagem1.setOnAction(actionEvent -> eliminarPersonagem(listViewHerois, observableListHerois));
        btnEliminarPersonagem2.setOnAction(actionEvent -> eliminarPersonagem(listViewBestas, observableListBestas));

        btnEditarPersonagem1.setOnAction(actionEvent -> editarPersonagem(0));  // Muda para editar
        btnEditarPersonagem2.setOnAction(actionEvent -> editarPersonagem(1));  // Muda para editar

        // Para o botão que gravar o Heroi
        btnGravarPersonagem1.setOnAction(actionEvent -> {
            // Cria uma nova instância de Heroi
            Personagem heroi = new Heroi();
            gravarPersonagem(heroi, observableListHerois, listViewHerois);
        });

        // Para o botão que gravar o Besta
        btnGravarPersonagem2.setOnAction(actionEvent -> {
            // Cria uma nova instância de Besta
            Personagem besta = new Besta();
            gravarPersonagem(besta, observableListBestas, listViewBestas);
        });


        btnCimaJogador1.setOnAction(actionEvent -> FormUtils.moverItemParaCima(listViewHerois, observableListHerois));
        btnCimaJogador2.setOnAction(actionEvent -> FormUtils.moverItemParaCima(listViewBestas, observableListBestas));

        btnBaixoJogador1.setOnAction(actionEvent -> FormUtils.moverItemParaBaixo(listViewHerois, observableListHerois));
        btnBaixoJogador2.setOnAction(actionEvent -> FormUtils.moverItemParaBaixo(listViewBestas, observableListBestas));


        //  Filtro para verificar o clique fora das ListViews
        root.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            // Verifica se o clique foi fora das ListViews e de outros nós permitidos
            if (!ValidationUtils.isClickInsideAllowedNodes(root, event)) {

                // Desmarcar a seleção nas ListViews
                listViewHerois.getSelectionModel().clearSelection();
                listViewBestas.getSelectionModel().clearSelection();

                cancelarEdicao();
            }
        });

        btnBatalhar.setOnAction(actionEvent -> batalha());
    }

    @FXML
    /**
     * Metodo para criar Personagem
     */
    private void criarPersonagem(Personagem personagem, List<Personagem> lista, ListView<Personagem> listView) {
        if (personagem == null) {
            PopupUtils.showErrorPopup("Erro", "Personagem não pode ser nulo.", getRoot());
            return;
        }

        try {

            // Preenche a entidade de acordo com o tipo de personagem (Heroi ou Besta)
            if (personagem instanceof Heroi) {
                Tipo tipo = cbbTipoJogador1.getValue();
                String nome = txtNomeJogador1.getText();
                Integer vida = Integer.valueOf(txtVidaJogador1.getText());
                Integer armadura = Integer.valueOf(txtArmaduraJogador1.getText());
                Integer ataque = Integer.valueOf(txtAtaqueJogador1.getText());

                // Modifica o personagem existente
                personagem.setTipo(tipo);
                personagem.setNome(nome);
                personagem.setVida(vida);
                personagem.setArmadura(armadura);
                personagem.setAtaque(ataque);

            } else if (personagem instanceof Besta) {
                Tipo tipo = cbbTipoJogador2.getValue();
                String nome = txtNomeJogador2.getText();
                Integer vida = Integer.valueOf(txtVidaJogador2.getText());
                Integer armadura = Integer.valueOf(txtArmaduraJogador2.getText());
                Integer ataque = Integer.valueOf(txtAtaqueJogador2.getText());

                // Modifica o personagem existente
                personagem.setTipo(tipo);
                personagem.setNome(nome);
                personagem.setVida(vida);
                personagem.setArmadura(armadura);
                personagem.setAtaque(ataque);
            }

            // Verifique se o personagem foi preenchido corretamente
            if (!ValidationUtils.validarPersonagem(personagem)) {
                PopupUtils.showErrorPopup("Erro", "Campos do Personagem não preenchidos corretamente.", getRoot());
                return;
            }

            // Adiciona a personagem na lista
            lista.add(personagem);

            // Atualiza a ListView
            listView.refresh();

            // Exibe mensagem de sucesso
            PopupUtils.showSuccessPopup("Sucesso", "Personagem " + personagem.getNome() + " adicionado com sucesso!", getRoot());

        } catch (NumberFormatException e) {
            PopupUtils.showErrorPopup("Error", "Vida, Armadura e ataque tem que ser inteiros positivos", getRoot());
        }
    }

    @FXML
    /**
     * Método para Eliminar Personagem
     */
    private void eliminarPersonagem(ListView<Personagem> listView, List<Personagem> lista) {
        System.out.println("Botão Eliminar clicado");
        try {
            selecionado = listView.getSelectionModel().getSelectedItem();

            if (selecionado == null) {
                PopupUtils.showErrorPopup("Erro", "Nenhum personagem selecionado!", getRoot());
                return;
            }

            boolean confirmar = PopupUtils.showConfirmationPopup(
                    "Confirmação",
                    "Eliminar Personagem " + selecionado.getNome(),
                    "Tem certeza que deseja eliminar este personagem?",
                    getRoot()
            );
            if (!confirmar) return;

            if (selecionado instanceof Heroi) {
                manager.removerHeroi(selecionado.getId());
            } else if (selecionado instanceof Besta) {
                manager.removerBesta(selecionado.getId());
            }

            // Atualiza a lista e UI
            lista.removeIf(p -> p.getId().equals(selecionado.getId()));
            listView.getItems().removeIf(p -> p.getId().equals(selecionado.getId()));

            listView.refresh();

            PopupUtils.showSuccessPopup("Sucesso", "Personagem removido com sucesso!", getRoot());

            cancelarEdicao();

        } catch (Exception e) {
            e.printStackTrace();
            PopupUtils.showErrorPopup("Erro", "Exceção ao remover: " + e.getMessage(), getRoot());
        }
    }

    @FXML
    /*
     * Método genérico para editar um personagem.
     * Este método gerencia o comportamento de edição de um personagem selecionado
     * a partir de duas listas diferentes (heróis e bestas).
     */
    private void editarPersonagem(int index) {

        /*
         * Usando ArrayList para armazenar as ListViews de personagens (heróis e bestas).
         */
        ArrayList<ListView<Personagem>> listViews = new ArrayList<>();
        listViews.add(listViewHerois);
        listViews.add(listViewBestas);

        // Lógica que será executada ao clicar no botão de editar
        System.out.println("Botão Editar Personagem " + (index + 1) + " Clicado");

        // Verifica se está em modo de edição, caso sim, cancela a edição e retorna aos valores originais
        if (editMode) {
            cancelarEdicao(); // Cancela a edição
        } else {
            // Se não está em modo de edição, tenta selecionar um personagem da ListView correspondente
            selecionado = listViews.get(index).getSelectionModel().getSelectedItem();

            // Se um personagem foi selecionado, entra no modo de edição
            if (selecionado != null) {
                editMode = true; // Ativa o modo de edição

                habilitarCampos();


                // Atualiza apenas os botões correspondentes ao index
                if (index == 0) {
                    btnEditarPersonagem1.setText("Voltar");

                    btnGravarPersonagem1.setVisible(true);
                    btnCriarPersonagem1.setVisible(false);
                    btnEliminarPersonagem1.setVisible(true);

                    // Desativa apenas os botões do outro grupo
                    btnGravarPersonagem2.setVisible(false);
                    btnCriarPersonagem2.setVisible(false);
                    btnEliminarPersonagem2.setVisible(false);


                } else {
                    btnEditarPersonagem2.setText("Voltar");

                    btnGravarPersonagem2.setVisible(true);
                    btnCriarPersonagem2.setVisible(false);
                    btnEliminarPersonagem2.setVisible(true);

                    // Desativa apenas os botões do outro grupo
                    btnGravarPersonagem1.setVisible(false);
                    btnCriarPersonagem1.setVisible(false);
                    btnEliminarPersonagem1.setVisible(false);

                }
            }
        }
    }

    @FXML
    /**
     * Método para gravar a edição do personagem.
     */
    public void gravarPersonagem(Personagem personagem, List<Personagem> lista, ListView<Personagem> listView) {
        try {

            personagem = listView.getSelectionModel().getSelectedItem();

            if (selecionado == null) {
                PopupUtils.showErrorPopup("Erro", "Nenhum personagem selecionado!", getRoot());
                return;
            }
            Personagem personagemAtualizado = selecionado;

            if (selecionado instanceof Heroi) {

                personagemAtualizado = new Heroi();
                Tipo tipo = cbbTipoJogador1.getValue();
                String nome = txtNomeJogador1.getText();
                Integer vida = Integer.valueOf(txtVidaJogador1.getText());
                Integer armadura = Integer.valueOf(txtArmaduraJogador1.getText());
                Integer ataque = Integer.valueOf(txtAtaqueJogador1.getText());

                // Modifica o personagem existente
                selecionado.setTipo(tipo);
                selecionado.setNome(nome);
                selecionado.setVida(vida);
                selecionado.setArmadura(armadura);
                selecionado.setAtaque(ataque);

                manager.atualizarHeroi((Heroi) selecionado);

            } else if (selecionado instanceof Besta) {

                personagemAtualizado = new Besta();
                Tipo tipo = cbbTipoJogador2.getValue();
                String nome = txtNomeJogador2.getText();
                Integer vida = Integer.valueOf(txtVidaJogador2.getText());
                Integer armadura = Integer.valueOf(txtArmaduraJogador2.getText());
                Integer ataque = Integer.valueOf(txtAtaqueJogador2.getText());

                // Modifica o personagem existente
                selecionado.setTipo(tipo);
                selecionado.setNome(nome);
                selecionado.setVida(vida);
                selecionado.setArmadura(armadura);
                selecionado.setAtaque(ataque);

                manager.atualizarBesta((Besta) selecionado);
            }

            // Verifique se o personagem foi preenchido corretamente
            if (!ValidationUtils.validarPersonagem(selecionado)) {
                PopupUtils.showErrorPopup("Erro", "Campos do Personagem não preenchidos corretamente.", getRoot());
                return;
            }

            // Atualizar a ListView
            listView.refresh();

            // Salvar os dados
            manager.salvarTodos();

            // Mensagem de sucesso
            PopupUtils.showSuccessPopup("Sucesso", "Personagem atualizado com sucesso!", getRoot());

            // Sair do modo edição
            cancelarEdicao();

        } catch (Exception e) {
            e.printStackTrace();
            PopupUtils.showErrorPopup("Erro", "Exceção ao atualizar: " + e.getMessage(), getRoot());
        }
    }

    @FXML
    public void batalha() {
        try {
            // Verificação das listas
            if (listViewHerois.getItems() == null || listViewBestas.getItems() == null ||
                    listViewHerois.getItems().isEmpty() || listViewBestas.getItems().isEmpty()) {

                PopupUtils.showErrorPopup("Seleção Incompleta",
                        "Por favor, carregue e selecione pelo menos um herói e uma besta válidos.", root);
                return;
            }

            // Clone defensivo profundo dos personagens
            List<Personagem> heroisCopia = new ArrayList<>();
            List<Personagem> bestasCopia = new ArrayList<>();

            for (Personagem heroi : listViewHerois.getItems()) {
                heroisCopia.add(clonarPersonagem(heroi));
            }

            for (Personagem besta : listViewBestas.getItems()) {
                bestasCopia.add(clonarPersonagem(besta));
            }

            // Criação do controlador de batalha
            Batalha batalhaController = new Batalha(() -> {
                Platform.runLater(() -> {
                    System.out.println("Batalha finalizada - Restaurando UI");
                    restaurarElementosUI();

                    // Atualiza as ListViews para refletir possíveis mudanças
                    listViewHerois.refresh();
                    listViewBestas.refresh();
                });
            }, heroisCopia, bestasCopia);

            // Configuração da UI
            root.setCenter(batalhaController.getRoot());
            batalhaController.iniciarBatalha();
            esconderElementosUI();

        } catch (Exception e) {
            handleInitializationError(e);
            PopupUtils.showErrorPopup("Erro na Batalha",
                    "Ocorreu um erro ao iniciar a batalha: " + e.getMessage(), root);
        }
    }

    // Método auxiliar para clonar personagens
    private Personagem clonarPersonagem(Personagem original) {
        if (original instanceof Heroi) {
            Heroi heroi = (Heroi) original;
            return new Heroi(heroi.getId(), heroi.getTipo(), heroi.getNome(),
                    heroi.getVida(), heroi.getArmadura(), heroi.getAtaque());
        } else if (original instanceof Besta) {
            Besta besta = (Besta) original;
            return new Besta(besta.getId(), besta.getTipo(), besta.getNome(),
                    besta.getVida(), besta.getArmadura(), besta.getAtaque());
        }
        throw new IllegalArgumentException("Tipo de personagem desconhecido");
    }

    private void esconderElementosUI() {
        // Armazenar os elementos antes de removê-los
        top = root.getTop();
        bottom = root.getBottom();
        left = root.getLeft();
        right = root.getRight();

        // Remover os elementos do BorderPane
        root.setTop(null);
        root.setBottom(null);
        root.setLeft(null);
        root.setRight(null);
    }

    private void restaurarElementosUI() {
        // Restaurar os elementos para o BorderPane
        root.setTop(top);
        root.setBottom(bottom);
        root.setLeft(left);
        root.setRight(right);
    }

    /**
     * Trata erros durante a inicialização da batalha e exibe uma mensagem de erro ao usuário.
     *
     * @param e A exceção que foi gerada durante a inicialização.
     */
    private void handleInitializationError(Exception e) {
        System.err.println("Erro na inicialização da batalha:");
        e.printStackTrace();

        PopupUtils.showErrorPopup("Erro de Inicialização",
                "Não foi possível preparar a batalha. Verifique os dados e tente novamente.", root);
    }
}
