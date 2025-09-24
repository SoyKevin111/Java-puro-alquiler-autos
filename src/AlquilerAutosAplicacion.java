import java.util.Scanner;

import Service.AutoService;
import Service.ClienteService;
import Service.ContratoService;
import repository.AutoRepository;
import repository.ClienteRepository;
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
		ContratoRepository ctp = new ContratoRepository();
		ClienteRepository crp = new ClienteRepository();

		GeneralValidation gv = new GeneralValidation(sc);

		GeneralUtils gu = new GeneralUtils(sc, gv);

		AutoService asv = new AutoService(arp, ctp);
		ContratoService cts = new ContratoService(arp, ctp);
		ClienteService cls = new ClienteService(crp);

		AutoConsola ac = new AutoConsola(sc, asv, gu, gv);
		ClienteConsola clc = new ClienteConsola(sc, cls);
		ContratoConsola coc = new ContratoConsola(sc, gu, cts, cls, gv);

		PrincipalConsola pc = new PrincipalConsola(sc, ac, clc, coc);

		pc.iniciar();

	}

}
