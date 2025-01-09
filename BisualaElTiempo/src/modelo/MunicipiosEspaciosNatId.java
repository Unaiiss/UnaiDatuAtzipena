package modelo;
// Generated 18 dic 2024, 8:31:15 by Hibernate Tools 6.5.1.Final

/**
 * MunicipiosEspaciosNatId generated by hbm2java
 */
public class MunicipiosEspaciosNatId implements java.io.Serializable {

	private int idEspacio;
	private int idMunicipio;

	public MunicipiosEspaciosNatId() {
	}

	public MunicipiosEspaciosNatId(int idEspacio, int idMunicipio) {
		this.idEspacio = idEspacio;
		this.idMunicipio = idMunicipio;
	}

	public int getIdEspacio() {
		return this.idEspacio;
	}

	public void setIdEspacio(int idEspacio) {
		this.idEspacio = idEspacio;
	}

	public int getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MunicipiosEspaciosNatId))
			return false;
		MunicipiosEspaciosNatId castOther = (MunicipiosEspaciosNatId) other;

		return (this.getIdEspacio() == castOther.getIdEspacio())
				&& (this.getIdMunicipio() == castOther.getIdMunicipio());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdEspacio();
		result = 37 * result + this.getIdMunicipio();
		return result;
	}

}
