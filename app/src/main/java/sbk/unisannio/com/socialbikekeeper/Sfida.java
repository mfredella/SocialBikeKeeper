package sbk.unisannio.com.socialbikekeeper;

public class Sfida {

	private static String sfidante;
    private static String sfidato;
    private static String id;

	public Sfida(String sfidante, String sfidato, String id) {
		super();
		this.sfidante = sfidante;
		this.sfidato = sfidato;
		this.id = id;
	}
	public static String getId() {
			return id;
		}
	
	public static void setId(String id) {
		Sfida.id = id;
	}
	public static String getSfidante() {
		return sfidante;
	}

	public void setSfidante(String sfidante) {
		this.sfidante = sfidante;
	}

	public static String getSfidato() {
		return sfidato;
	}
	public void setSfidato(String sfidato) {
		this.sfidato = sfidato;
	}
}