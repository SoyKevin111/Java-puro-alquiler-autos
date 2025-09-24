import java.util.Scanner;

import Service.AutoService;
import repository.AutoRepository;
import repository.ContratoRepository;
import ui.AutoConsola;
import ui.ClienteConsola;
import ui.ContratoConsola;
import ui.PrincipalConsola;
import utils.GeneralUtils;
import validations.GeneralValidation;

public class AlquilerAutosAplicacion {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AutoRepository arp = new AutoRepository();
		ContratoRepository ctcp = new ContratoRepository();

		GeneralValidation gv = new GeneralValidation(sc);

		GeneralUtils gu = new GeneralUtils(sc, gv);

		AutoService asv = new AutoService(arp, ctcp);

		AutoConsola ac = new AutoConsola(sc, asv, gu, gv);
		ClienteConsola clc = new ClienteConsola();
		ContratoConsola coc = new ContratoConsola();

		PrincipalConsola pc = new PrincipalConsola(sc, ac, clc, coc);

		pc.iniciar();

	}

}
