package projeto.view;
import projeto.model.estrutura.*;
import projeto.controller.*;

public class JogoPrincipal {
	// Para fins de teste
	public static void main(String[] args) {
		JogoDaVelha estrutura = new JogoDaVelha();
        JogoDaVelhaController control = new JogoDaVelhaController(estrutura);
        control.iniciarJogo();
	}
}
