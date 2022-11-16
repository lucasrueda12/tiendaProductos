package besysoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
	private Map<Integer, Vendedor> _vendedores;
	private Map<Integer, Producto> _productos;
	
	public DataBase() {
		_vendedores = cargarVendedores();
		_productos = cargarProductos();
	}
	

	public Producto traerProducto(Integer codProduct) {
		if(!_productos.containsKey(codProduct)) {
			throw new RuntimeException("Codigo de producto no encontrado");
		}
		return _productos.get(codProduct);
	}

	public Vendedor traerVendedor(Integer codVendedor) {
		if(!_vendedores.containsKey(codVendedor)) {
			throw new RuntimeException("Codigo de vendedor no encontrado");
		}
		return _vendedores.get(codVendedor);
	}
	
	public List<Producto> traerPorCategoria(String cat){
		List<Producto> catProd = new ArrayList<>();
		
		for(Map.Entry<Integer, Producto> p: _productos.entrySet()){
			if(p.getValue().get_categoria().equals(cat)) {
				catProd.add(p.getValue());
			}
		}
		
		return catProd;
	}
	
	public Producto traerPorNombre(String nombre) {
		for(Map.Entry<Integer, Producto> p: _productos.entrySet()){
			if(p.getValue().get_nombre().equals(nombre)) {
				return p.getValue();
			}
		}
		return null;
	}
	
	
	
	private Map<Integer, Vendedor> cargarVendedores() {
		Map<Integer, Vendedor> ven = new HashMap<>();
		Vendedor x = new Vendedor("Lucas", 10000);
		ven.put(x.get_codigo(), x);
		Vendedor s = new Vendedor("Santiago", 20000);
		ven.put(s.get_codigo(), s );
		Vendedor f = new Vendedor("Fernando", 30000);
		ven.put(f.get_codigo(), f);
		return ven;
	}
	
	private Map<Integer, Producto> cargarProductos() {
		Map<Integer, Producto> prod = new HashMap<>();
		Producto ls = new Producto("Lata Stella", 230 ,"Bebida");
		prod.put(ls.get_codigo(), ls);
		Producto y = new Producto("yerva Marianita", 600, "Infusion");
		prod.put(y.get_codigo(), y );
		Producto elec = new Producto("Tostadora", 6600, "Electrodomestico");
		prod.put(elec.get_codigo(), elec);
		return prod;
	}


	
}
