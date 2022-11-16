package besysoft;

public class Vendedor {
	private static Integer count=0; 
	private Integer _codigo;
	private double _sueldo;
	private String _nombre;

	public Vendedor(String nombre, double sueldo) {
		count++;
		_codigo = count;
		_nombre = nombre;
		_sueldo = sueldo; 
	}

	public Integer get_codigo() {
		return _codigo;
	}

	public double get_sueldo() {
		return _sueldo;
	}

	public String get_nombre() {
		return _nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Vendedor)) return false;
		
		Vendedor v= (Vendedor) obj;
		return _codigo == v.get_codigo();
	}

}
