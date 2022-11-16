package besysoft;

public class Producto {
	private static Integer count=0; 
	private Integer _codigo;
	private String _nombre;
	private String _categoria;
	private double _precio;
	
	public Producto(String nombre, double precio, String categoria) {
		count++;
		_codigo = count;
		_nombre = nombre;
		_categoria = categoria;
		 _precio = precio;
	}

	public Integer get_codigo() {
		return _codigo;
	}

	public String get_nombre() {
		return _nombre;
	}

	public String get_categoria() {
		return _categoria;
	}

	public double get_precio() {
		return _precio;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Producto)) return false;
		
		Producto p= (Producto) obj;
		return _codigo == p.get_codigo();
	}
	
	
}
