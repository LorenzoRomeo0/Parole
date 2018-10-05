package parole;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import parole.model.Parole;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnDelete"
    private Button btnDelete;

    @FXML
    void doInsert(ActionEvent event) {
    	if(!txtParola.getText().isEmpty()) {
    		elenco.addParola(txtParola.getText());
    		String testo="";
    		ArrayList<String> lista=(ArrayList<String>)elenco.getElenco();
    		for(int i=0; i<lista.size();i++)
    			testo+=lista.get(i)+"\n";
    		txtResult.setText(testo);
    		txtParola.setText("");
    	}
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	elenco.reset();
    }
    
    @FXML
    void doDelete(ActionEvent event) {
    	elenco.delete(txtParola.getText());
    	String testo="";
		ArrayList<String> lista=(ArrayList<String>)elenco.getElenco();
		for(int i=0; i<lista.size();i++)
			testo+=lista.get(i)+"\n";
		txtResult.setText(testo);
		txtParola.setText("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole();
        
    }
}
