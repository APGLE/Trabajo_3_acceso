package modelos;



public class Inventario  {
	
	private String transaccion;
	private long  fechaHora;
	private String id;
	private String cif;
	private String operacion;
	private int cantidad;
	private int saldo;
	
	public static final char VENTA = 'v';
	public static final char COMPRA = 'c';
	public static final char INVENTARIO = 'i';
	
	public Inventario() {
		
	}
	
	public Inventario(String transaccion, long fechaHora, String id, String cif, String operacion, int cantidad,
			int saldo) {
		super();
		this.transaccion = transaccion;
		this.fechaHora = fechaHora;
		this.id = id;
		this.cif = cif;
		this.operacion = operacion;
		this.cantidad = cantidad;
		this.saldo = saldo;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public long getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(long fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Inventario [transaccion=" + transaccion + ", fechaHora=" + fechaHora + ", id=" + id + ", cif=" + cif
				+ ", operacion=" + operacion + ", cantidad=" + cantidad + ", saldo=" + saldo + "]";
	}
	 
	
	
}