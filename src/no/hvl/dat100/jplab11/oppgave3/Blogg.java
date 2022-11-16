package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable
	private int nesteledig;
	private Innlegg[] innleggtabell;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		int antall = 0;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i] != null)
				antall++;
		}
		return antall;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;
		while (pos < nesteledig && !funnet) {
			if (innleggtabell[pos].erLik(innlegg)) {
				funnet = true;
			} else {
				pos++;
			}
		}
		if (funnet) {
			return pos;
		} else {
			return -1;
		}

	}

	public boolean finnes(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if (pos >= 0)
			return true;
		else
			return false;
	}

	public boolean ledigPlass() {
		boolean plass = false;
		if (nesteledig < innleggtabell.length)
			plass = true;
		return plass;
	}

	public boolean leggTil(Innlegg innlegg) {
		boolean ok = finnInnlegg(innlegg) == -1;
		if (ok && nesteledig < innleggtabell.length) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String ret = innleggtabell.length + "\n";
		int i = 0;
		while (i < innleggtabell.length) {
			if (innleggtabell[i] != null) {
				ret += innleggtabell[i].toString();
			}
			System.out.println();
			i++;
		}
		return ret;

	}

	// 2\nTEKST\n1\nOle Olsen\n23-10\n0\nen tekst\nBILDE\n2\nOline
	// Olsen\n24-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] innleggtabell_temp = new Innlegg[2 * innleggtabell.length];
		for (int i = 0; i < innleggtabell.length; i++) {
			innleggtabell_temp[i] = innleggtabell[i];
		}
		innleggtabell = innleggtabell_temp;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean innsatt = false;
		;
		boolean ikkeMe = finnInnlegg(innlegg) == -1;
		boolean plass = ledigPlass();

		if (ikkeMe && plass) {
			innleggtabell[nesteledig] = innlegg;
		} else if (ikkeMe && !plass) {
			utvid();
			innleggtabell[nesteledig] = innlegg;
			innsatt = true;
		}
		return innsatt;
	}

	public boolean slett(Innlegg innlegg) {
		boolean slettet = false;
		boolean finnes = finnes(innlegg);
		int pos = finnInnlegg(innlegg);
		if (finnes && pos >= 0 && finnInnlegg(innlegg) < nesteledig) {
			nesteledig--;
			innleggtabell[pos] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			slettet = true;
	}

	return slettet;

	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}