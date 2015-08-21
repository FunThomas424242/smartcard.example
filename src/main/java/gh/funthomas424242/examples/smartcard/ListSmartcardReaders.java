package gh.funthomas424242.examples.smartcard;

import java.util.List;
import javax.smartcardio.*;

/*
 * Look in rt.jar for „javax.smartcardio“ to get further information
 * Defined in: JSR 268
 */
public class ListSmartcardReaders {

	public static int listCounted() {

		/* we use the default TerminalFactory */
		TerminalFactory factory = TerminalFactory.getDefault();

		try {
			/* We can have multiple terminals on one System, so we get a list */
			List<CardTerminal> terminals = factory.terminals().list();

			for (CardTerminal terminal : terminals) {
				System.out.println("Card_Terminal_Name: " + terminal.getName());
				System.out.println("Card_in_Terminal_present: "
						+ terminal.isCardPresent());
				System.out.println("——————————————–");
			}
			return terminals.size();

		} catch (CardException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		listCounted();
	}
}