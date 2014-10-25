package pl.kkrampa.lab1.domain;

public enum Pogoda {
	SLONECZNA, DESZCZOWA;
	private static Pogoda[] pogody = values();
	public static Pogoda fromInteger(Integer i) {
		return pogody[i - 1];
	}
}