package inmorate.model;

public class Inmueble {
	String identificador;
	String descripcion;
	String tipo;
	String comercial;
	double precio_salida;
	String fecha_entrada;
	boolean vendido;
	String fecha_venta;
	double precio_venta;
	double m_construidos;
	double m_habitables;
	double m_hall;
	boolean amueblado;
	double m_salon;
	boolean salon_independiente;
	int n_dormitorios;
	int n_armarios;
	double m_dormitorio_principal;
	double m_dormitorio_segundo;
	double m_dormitorio_tercero;
	double m_dormitorio_cuarto;
	double m_dormitorio_servicio;
	boolean cocina_amueblada;
	boolean tendedero;
	int n_banos;
	double m_bano1;
	double m_bano2;
	double m_bano3;
	
	public Inmueble(String identificador, String descripcion, String tipo, String comercial, double precio_salida, String fecha_entrada, boolean vendido, String fecha_venta, double precio_venta, double m_construidos, double m_habitables, double m_hall, boolean amueblado, double m_salon, boolean salon_independiente, int n_dormitorios, int n_armarios, double m_dormitorio_principal, double m_dormitorio_segundo, double m_dormitorio_tercero, double m_dormitorio_cuarto, double m_dormitorio_servicio, boolean cocina_amueblada, boolean tendedero, int n_banos, double m_bano1, double m_bano2, double m_bano3) {
		super();
		this.identificador = identificador;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.comercial = comercial;
		this.precio_salida = precio_salida;
		this.fecha_entrada = fecha_entrada;
		this.vendido = vendido;
		this.fecha_venta = fecha_venta;
		this.precio_venta = precio_venta;
		this.m_construidos = m_construidos;
		this.m_habitables = m_habitables;
		this.m_hall = m_hall;
		this.amueblado = amueblado;
		this.m_salon = m_salon;
		this.salon_independiente = salon_independiente;
		this.n_dormitorios = n_dormitorios;
		this.n_armarios = n_armarios;
		this.m_dormitorio_principal = m_dormitorio_principal;
		this.m_dormitorio_segundo = m_dormitorio_segundo;
		this.m_dormitorio_tercero = m_dormitorio_tercero;
		this.m_dormitorio_cuarto = m_dormitorio_cuarto;
		this.m_dormitorio_servicio = m_dormitorio_servicio;
		this.cocina_amueblada = cocina_amueblada;
		this.tendedero = tendedero;
		this.n_banos = n_banos;
		this.m_bano1 = m_bano1;
		this.m_bano2 = m_bano2;
		this.m_bano3 = m_bano3;
	}
	public boolean isAmueblado() {
		return amueblado;
	}
	public void setAmueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}
	public boolean isCocina_amueblada() {
		return cocina_amueblada;
	}
	public void setCocina_amueblada(boolean cocina_amueblada) {
		this.cocina_amueblada = cocina_amueblada;
	}
	public String getComercial() {
		return comercial;
	}
	public void setComercial(String comercial) {
		this.comercial = comercial;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha_entrada() {
		return fecha_entrada;
	}
	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}
	public String getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public double getM_bano1() {
		return m_bano1;
	}
	public void setM_bano1(double m_bano1) {
		this.m_bano1 = m_bano1;
	}
	public double getM_bano2() {
		return m_bano2;
	}
	public void setM_bano2(double m_bano2) {
		this.m_bano2 = m_bano2;
	}
	public double getM_bano3() {
		return m_bano3;
	}
	public void setM_bano3(double m_bano3) {
		this.m_bano3 = m_bano3;
	}
	public double getM_construidos() {
		return m_construidos;
	}
	public void setM_construidos(double m_construidos) {
		this.m_construidos = m_construidos;
	}
	public double getM_dormitorio_cuarto() {
		return m_dormitorio_cuarto;
	}
	public void setM_dormitorio_cuarto(double m_dormitorio_cuarto) {
		this.m_dormitorio_cuarto = m_dormitorio_cuarto;
	}
	public double getM_dormitorio_principal() {
		return m_dormitorio_principal;
	}
	public void setM_dormitorio_principal(double m_dormitorio_principal) {
		this.m_dormitorio_principal = m_dormitorio_principal;
	}
	public double getM_dormitorio_segundo() {
		return m_dormitorio_segundo;
	}
	public void setM_dormitorio_segundo(double m_dormitorio_segundo) {
		this.m_dormitorio_segundo = m_dormitorio_segundo;
	}
	public double getM_dormitorio_servicio() {
		return m_dormitorio_servicio;
	}
	public void setM_dormitorio_servicio(double m_dormitorio_servicio) {
		this.m_dormitorio_servicio = m_dormitorio_servicio;
	}
	public double getM_dormitorio_tercero() {
		return m_dormitorio_tercero;
	}
	public void setM_dormitorio_tercero(double m_dormitorio_tercero) {
		this.m_dormitorio_tercero = m_dormitorio_tercero;
	}
	public double getM_habitables() {
		return m_habitables;
	}
	public void setM_habitables(double m_habitables) {
		this.m_habitables = m_habitables;
	}
	public double getM_hall() {
		return m_hall;
	}
	public void setM_hall(double m_hall) {
		this.m_hall = m_hall;
	}
	public double getM_salon() {
		return m_salon;
	}
	public void setM_salon(double m_salon) {
		this.m_salon = m_salon;
	}
	public int getN_armarios() {
		return n_armarios;
	}
	public void setN_armarios(int n_armarios) {
		this.n_armarios = n_armarios;
	}
	public int getN_banos() {
		return n_banos;
	}
	public void setN_banos(int n_banos) {
		this.n_banos = n_banos;
	}
	public int getN_dormitorios() {
		return n_dormitorios;
	}
	public void setN_dormitorios(int n_dormitorios) {
		this.n_dormitorios = n_dormitorios;
	}
	public double getPrecio_salida() {
		return precio_salida;
	}
	public void setPrecio_salida(double precio_salida) {
		this.precio_salida = precio_salida;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	public boolean isSalon_independiente() {
		return salon_independiente;
	}
	public void setSalon_independiente(boolean salon_independiente) {
		this.salon_independiente = salon_independiente;
	}
	public boolean isTendedero() {
		return tendedero;
	}
	public void setTendedero(boolean tendedero) {
		this.tendedero = tendedero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
}
