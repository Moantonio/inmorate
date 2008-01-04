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
	String terraza;
	double m_salon;
	boolean salon_independiente;
	int n_dormitorios;
	int n_armarios;
	double m_dormitorio_principal;
	String obs_dormitorio_principal;
	double m_dormitorio_segundo;
	double m_dormitorio_tercero;
	double m_dormitorio_cuarto;
	double m_dormitorio_servicio;
	String obs_dormitorios;
	boolean cocina_amueblada;
	boolean equipamiento_cocina;
	boolean tendedero;
	int n_banos;
	double m_bano1;
	double m_bano2;
	double m_bano3;
	boolean aseo;
	boolean jardin_comunitario;
	boolean piscina_comunitaria;
	boolean piscina_propia;
	String tipo_calefaccion;
	String agua_caliente;
	boolean radiadores;
	boolean aire_acondicionado;
	boolean parabolica;
	boolean portero_automatico;
	boolean conserje;
	boolean ascensor;
	int num_plazas;
	boolean trastero;
	String carpinteria_exterior;
	String carpinteria_interior;
	String suelos;
	double gastos;
	boolean puerta_blindada;
	int antiguedad;
	int plantas_edificio;
	int puertas_planta;
	String orientacion;
	String conservacion;
	String estado_finca;
	String fecha_disponibilidad;
	boolean sauna;
	boolean gimnasio;
	String otros_comentarios;
	String direccion;
	int planta;
	
	public Inmueble() {
		
	}
	
	public Inmueble(String identificador, String descripcion, String tipo, String comercial, double precio_salida, String fecha_entrada, boolean vendido, String fecha_venta, double precio_venta, double m_construidos, double m_habitables, double m_hall, boolean amueblado, String terraza, double m_salon, boolean salon_independiente, int n_dormitorios, int n_armarios, double m_dormitorio_principal, String obs_dormitorio_principal, double m_dormitorio_segundo, double m_dormitorio_tercero, double m_dormitorio_cuarto, double m_dormitorio_servicio, String obs_dormitorios, boolean cocina_amueblada, boolean equipamiento_cocina, boolean tendedero, int n_banos, double m_bano1, double m_bano2, double m_bano3, boolean aseo, boolean jardin_comunitario, boolean piscina_comunitaria, boolean piscina_propia, String tipo_calefaccion, String agua_caliente, boolean radiadores, boolean aire_acondicionado, boolean parabolica, boolean portero_automatico, boolean conserje, boolean ascensor, int num_plazas, boolean trastero, String carpinteria_exterior, String carpinteria_interior, String suelos, double gastos, boolean puerta_blindada, int antiguedad, int plantas_edificio, int puertas_planta, String orientacion, String conservacion, String estado_finca, String fecha_disponibilidad, boolean sauna, boolean gimnasio, String otros_comentarios, String direccion, int planta) {
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
		this.terraza = terraza;
		this.m_salon = m_salon;
		this.salon_independiente = salon_independiente;
		this.n_dormitorios = n_dormitorios;
		this.n_armarios = n_armarios;
		this.m_dormitorio_principal = m_dormitorio_principal;
		this.obs_dormitorio_principal = obs_dormitorio_principal;
		this.m_dormitorio_segundo = m_dormitorio_segundo;
		this.m_dormitorio_tercero = m_dormitorio_tercero;
		this.m_dormitorio_cuarto = m_dormitorio_cuarto;
		this.m_dormitorio_servicio = m_dormitorio_servicio;
		this.obs_dormitorios = obs_dormitorios;
		this.cocina_amueblada = cocina_amueblada;
		this.equipamiento_cocina = equipamiento_cocina;
		this.tendedero = tendedero;
		this.n_banos = n_banos;
		this.m_bano1 = m_bano1;
		this.m_bano2 = m_bano2;
		this.m_bano3 = m_bano3;
		this.aseo = aseo;
		this.jardin_comunitario = jardin_comunitario;
		this.piscina_comunitaria = piscina_comunitaria;
		this.piscina_propia = piscina_propia;
		this.tipo_calefaccion = tipo_calefaccion;
		this.agua_caliente = agua_caliente;
		this.radiadores = radiadores;
		this.aire_acondicionado = aire_acondicionado;
		this.parabolica = parabolica;
		this.portero_automatico = portero_automatico;
		this.conserje = conserje;
		this.ascensor = ascensor;
		this.num_plazas = num_plazas;
		this.trastero = trastero;
		this.carpinteria_exterior = carpinteria_exterior;
		this.carpinteria_interior = carpinteria_interior;
		this.suelos = suelos;
		this.gastos = gastos;
		this.puerta_blindada = puerta_blindada;
		this.antiguedad = antiguedad;
		this.plantas_edificio = plantas_edificio;
		this.puertas_planta = puertas_planta;
		this.orientacion = orientacion;
		this.conservacion = conservacion;
		this.estado_finca = estado_finca;
		this.fecha_disponibilidad = fecha_disponibilidad;
		this.sauna = sauna;
		this.gimnasio = gimnasio;
		this.otros_comentarios = otros_comentarios;
		this.direccion = direccion;
		this.planta = planta;
	}

	public String getAgua_caliente() {
		return agua_caliente;
	}

	public void setAgua_caliente(String agua_caliente) {
		this.agua_caliente = agua_caliente;
	}

	public boolean isAire_acondicionado() {
		return aire_acondicionado;
	}

	public void setAire_acondicionado(boolean aire_acondicionado) {
		this.aire_acondicionado = aire_acondicionado;
	}

	public boolean isAmueblado() {
		return amueblado;
	}

	public void setAmueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public boolean isAscensor() {
		return ascensor;
	}

	public void setAscensor(boolean ascensor) {
		this.ascensor = ascensor;
	}

	public boolean isAseo() {
		return aseo;
	}

	public void setAseo(boolean aseo) {
		this.aseo = aseo;
	}

	public String getCarpinteria_exterior() {
		return carpinteria_exterior;
	}

	public void setCarpinteria_exterior(String carpinteria_exterior) {
		this.carpinteria_exterior = carpinteria_exterior;
	}

	public String getCarpinteria_interior() {
		return carpinteria_interior;
	}

	public void setCarpinteria_interior(String carpinteria_interior) {
		this.carpinteria_interior = carpinteria_interior;
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

	public boolean isConserje() {
		return conserje;
	}

	public void setConserje(boolean conserje) {
		this.conserje = conserje;
	}

	public String getConservacion() {
		return conservacion;
	}

	public void setConservacion(String conservacion) {
		this.conservacion = conservacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEquipamiento_cocina() {
		return equipamiento_cocina;
	}

	public void setEquipamiento_cocina(boolean equipamiento_cocina) {
		this.equipamiento_cocina = equipamiento_cocina;
	}

	public String getEstado_finca() {
		return estado_finca;
	}

	public void setEstado_finca(String estado_finca) {
		this.estado_finca = estado_finca;
	}

	public String getFecha_disponibilidad() {
		return fecha_disponibilidad;
	}

	public void setFecha_disponibilidad(String fecha_disponibilidad) {
		this.fecha_disponibilidad = fecha_disponibilidad;
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

	public double getGastos() {
		return gastos;
	}

	public void setGastos(double gastos) {
		this.gastos = gastos;
	}

	public boolean isGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(boolean gimnasio) {
		this.gimnasio = gimnasio;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public boolean isJardin_comunitario() {
		return jardin_comunitario;
	}

	public void setJardin_comunitario(boolean jardin_comunitario) {
		this.jardin_comunitario = jardin_comunitario;
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

	public int getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}

	public String getObs_dormitorio_principal() {
		return obs_dormitorio_principal;
	}

	public void setObs_dormitorio_principal(String obs_dormitorio_principal) {
		this.obs_dormitorio_principal = obs_dormitorio_principal;
	}

	public String getObs_dormitorios() {
		return obs_dormitorios;
	}

	public void setObs_dormitorios(String obs_dormitorios) {
		this.obs_dormitorios = obs_dormitorios;
	}

	public String getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public String getOtros_comentarios() {
		return otros_comentarios;
	}

	public void setOtros_comentarios(String otros_comentarios) {
		this.otros_comentarios = otros_comentarios;
	}

	public boolean isParabolica() {
		return parabolica;
	}

	public void setParabolica(boolean parabolica) {
		this.parabolica = parabolica;
	}

	public boolean isPiscina_comunitaria() {
		return piscina_comunitaria;
	}

	public void setPiscina_comunitaria(boolean piscina_comunitaria) {
		this.piscina_comunitaria = piscina_comunitaria;
	}

	public boolean isPiscina_propia() {
		return piscina_propia;
	}

	public void setPiscina_propia(boolean piscina_propia) {
		this.piscina_propia = piscina_propia;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getPlantas_edificio() {
		return plantas_edificio;
	}

	public void setPlantas_edificio(int plantas_edificio) {
		this.plantas_edificio = plantas_edificio;
	}

	public boolean isPortero_automatico() {
		return portero_automatico;
	}

	public void setPortero_automatico(boolean portero_automatico) {
		this.portero_automatico = portero_automatico;
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

	public boolean isPuerta_blindada() {
		return puerta_blindada;
	}

	public void setPuerta_blindada(boolean puerta_blindada) {
		this.puerta_blindada = puerta_blindada;
	}

	public int getPuertas_planta() {
		return puertas_planta;
	}

	public void setPuertas_planta(int puertas_planta) {
		this.puertas_planta = puertas_planta;
	}

	public boolean isRadiadores() {
		return radiadores;
	}

	public void setRadiadores(boolean radiadores) {
		this.radiadores = radiadores;
	}

	public boolean isSalon_independiente() {
		return salon_independiente;
	}

	public void setSalon_independiente(boolean salon_independiente) {
		this.salon_independiente = salon_independiente;
	}

	public boolean isSauna() {
		return sauna;
	}

	public void setSauna(boolean sauna) {
		this.sauna = sauna;
	}

	public String getSuelos() {
		return suelos;
	}

	public void setSuelos(String suelos) {
		this.suelos = suelos;
	}

	public boolean isTendedero() {
		return tendedero;
	}

	public void setTendedero(boolean tendedero) {
		this.tendedero = tendedero;
	}

	public String getTerraza() {
		return terraza;
	}

	public void setTerraza(String terraza) {
		this.terraza = terraza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo_calefaccion() {
		return tipo_calefaccion;
	}

	public void setTipo_calefaccion(String tipo_calefaccion) {
		this.tipo_calefaccion = tipo_calefaccion;
	}

	public boolean isTrastero() {
		return trastero;
	}

	public void setTrastero(boolean trastero) {
		this.trastero = trastero;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
	
	
}
