/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Historico;

/**
 *
 * @author Skykynight
 */
public class FXMLDocumentController implements Initializable {
    Float data = 0f;
    float data1,ans1;
    int operation = -1;
    private String what;
    
    
   
    
    @FXML
    private Label label;
    
    @FXML
    private Button nine;

    @FXML
    private Button six;

    @FXML
    private Button mult;

    @FXML
    private Button soma;

    @FXML
    private Button one;

    @FXML
    private Button seven;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button eight;

    @FXML
    private Button zero;

    @FXML
    private Button div;

    @FXML
    private Label prom;

    @FXML
    private TextField entrada;

    @FXML
    private Button four;

    @FXML
    private Button limpar;

    @FXML
    private Button igual;

    @FXML
    private Button five;

    @FXML
    private Button subtracao;
    
    private Historico historico;
    
   @FXML
    private ListView<Historico> idHistorico;
   
    private List<Historico> Historico = new ArrayList<>();
    
    private ObservableList<Historico> obsHistorico;


    @FXML
            
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == one) {
            entrada.setText(entrada.getText() + "1");
        } else if(event.getSource() == two) {
            entrada.setText(entrada.getText() + "2");
        } else if(event.getSource() == three) {
            entrada.setText(entrada.getText() + "3");
        } else if(event.getSource() == four) {
            entrada.setText(entrada.getText() + "4");
        } else if(event.getSource() == five) {
            entrada.setText(entrada.getText() + "5");
        } else if(event.getSource() == six) {
            entrada.setText(entrada.getText() + "6");
        } else if(event.getSource() == seven) {
            entrada.setText(entrada.getText() + "7");
        } else if(event.getSource() == eight) {
            entrada.setText(entrada.getText() + "8");
        } else if(event.getSource() == nine) {
            entrada.setText(entrada.getText() + "9");
        } else if(event.getSource() == zero) {
            entrada.setText(entrada.getText() + "0");
        } else if(event.getSource() == limpar) {
            entrada.setText("");
            
        } else if(event.getSource() == soma)
        {
            data = Float.parseFloat(entrada.getText());
            data1 = data;
            operation = 1 ; //soma
            what = "" + operation;
            entrada.setText("");
        }else if(event.getSource() == subtracao) 
        {
            data = Float.parseFloat(entrada.getText());
            operation = 2 ; //subtracao
            what = "" + operation;
            entrada.setText("");
            
        }else if(event.getSource() == mult) 
        {
            data = Float.parseFloat(entrada.getText());
            operation = 3 ; //multiplicação
            what = "" + operation;
            entrada.setText("");
        }else if(event.getSource() == div) 
        {
            data = Float.parseFloat(entrada.getText());
            operation = 4 ; //divisão
            what = "" + operation;
            
            entrada.setText("");
          
    
            
        }else if(event.getSource() == igual) 
        {
            Float secondOperand = Float.parseFloat(entrada.getText());
            switch(operation)
            { case 1://soma
                   Float ans = data + secondOperand;
                   ans1 = ans;
                   entrada.setText(String.valueOf(ans));break;
              
            
            case 2://subtracao
                   ans = data - secondOperand;
                   ans1 = ans;
                   entrada.setText(String.valueOf(ans));break;
                   
           case 3://multiplicação
              
                   ans = data * secondOperand;
                   ans1 = ans;
                   entrada.setText(String.valueOf(ans));break;
            case 4://divisão
                ans = 0f;
                try{
                   ans = data / secondOperand;
                   ans1 = ans;
                }catch(Exception e){entrada.setText("Error");}
                   entrada.setText(String.valueOf(ans));break;
        }
            
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
        historico = new Historico();
        
        historico.setPv(data1);
        historico.setSv(secondOperand);
        historico.setOperador(what);
        historico.setResultado(ans1);
        }
    }
    
    


  @Override
    public void initialize(URL url, ResourceBundle rb) {
        entrada.setEditable(false);
        carregarHistorico();
    }    
    
    public void carregarHistorico() {
        Historico h1 = new Historico(1);
        Historico h2 = new Historico(2);
        
        obsHistorico = FXCollections.observableArrayList(historico);
        idHistorico.setItems(obsHistorico);
    }
    
}